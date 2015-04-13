<%@ page import="com.bowstreet.security.framework.WEFSecurityManager" %><%
/**
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006 IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See WebSphere Portlet Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * WPF/LWF CORE PRODUCT SUPPORT - NOT CUSTOMER MODIFIABLE
 *
 * Customer modification of core product files may void support agreements with
 * respect to affected portions of the product and any changes you make to the
 * core product files may be lost when the product is upgraded.
 *
 * Client-side implementation for the Print Page Contents builder.
 */
 	// $, 0-9, A-Z, _, a-z, anything 0x80 and above.  Validates id and fn
 	// parameters.  Note: only intended to prevent insertion of potential
 	// exploit strings; not intended to validate JavaScript name correctness.
 	final String whitelistForIdAndFn = "^[\\x240-9A-Z_a-z\\u0080-\\uffff]*$";

 	// "height" followed by "width" spec.
 	final String whitelistForWh = "^height=\\d+,width=\\d+$";

    response.setContentType("application/javascript");
    String id = WEFSecurityManager.checkForIllegalString( request.getParameter("id"), whitelistForIdAndFn );
    String fn = WEFSecurityManager.checkForIllegalString( request.getParameter("fn"), whitelistForIdAndFn );
    String wh = WEFSecurityManager.checkForIllegalString( request.getParameter("wh"), whitelistForWh );
    boolean close = request.getParameter("close") != null;
    boolean disable = request.getParameter("disable") != null; 
    final int LOOP_TIMEOUT = 100;    
    final int MAX_LOOP_TIME = 30 * 1000; // Loop for 30 seconds at most waiting for page to finish loading
    final int MAX_LOOP_COUNT = MAX_LOOP_TIME / LOOP_TIMEOUT;
%>
var <%= id %>_doc;
var <%= id %>_window;
var <%= id %>_loop_count;
function <%= fn %>() {
  <%= id %>_loop_count = 0; 
  var elem = document.getElementById('<%= id %>');
  var w = window.open( '<%= request.getContextPath() %>/factory/pages/empty.html' , elem.name + '_printer', '<%= wh %>') ||
          frames[elem.name + '_printer'];
  if (!w)
      return; // Pop-up blocker?
  <%= id %>_window = w;
  var d = w.document;
  <%= id %>_doc = d;
  d.write('<' + 'html> <' + 'head>');
  var styleSheets = document.styleSheets;
  for (var i = 0; i < styleSheets.length; i++) 
    if (styleSheets[i].href != null && styleSheets[i].href != '')
      d.write('  <link rel="stylesheet" type="text/css" href="' + styleSheets[i].href + '" />');
  d.write('<' + 'script type="text/javascript">');
  var close = <%= close %> ? "  setTimeout(function(){ window.close(); }, 1000);" : "";
  d.write('function prt(){   window.print(); ' + close + '}'); 
  d.write('document.doPrint=prt;');
  d.write('<' + '/' + 'script></head><body style="cursor:wait"><div id="<%= id %>_spot" /></body></html>');
  d.close();
  setTimeout('finish_<%= fn %>();', 100);
}
function finish_<%= fn %>() { 
  var d=<%= id %>_doc;
  var targElem = d.getElementById('<%= id %>_spot');
  if (targElem == null) {  // Ensure target is done rendering.
     setTimeout('finish_<%= fn %>();', 100);
     return;
  }
  var html = document.getElementById('<%= id %>').innerHTML;
  targElem.innerHTML=html;
  if (<%= disable %>) {
    var links = d.getElementsByTagName("A");
    for (var i = 0; i < links.length; i++) {
      links[i].setAttribute("onclick","return false");
      links[i].setAttribute("href","#");
    }
    var buttons = d.getElementsByTagName("INPUT");
    for (var i = 0; i < buttons.length; i++) { 
      if (buttons[i].type == "button") 
        buttons[i].setAttribute("onclick","return false");
    }
  }
  window.setTimeout('waitAndPrint_<%= fn %>()', <%= LOOP_TIMEOUT %>); 
}

function waitAndPrint_<%= fn %>() {
  var d = <%= id %>_doc;
  var ok = true;
  var iframes = d.getElementsByTagName("iframe");
  if (<%= id %>_loop_count++ < <%= MAX_LOOP_COUNT %> && iframes) {
      for (var i = 0; i < iframes.length; i++) {
          var iframe = iframes[i];
          var ifwin = iframe.contentWindow;
          if (iframe.className && iframe.className.indexOf("wpf_wait_when_printing") >= 0 && !ifwin.wpf_load_completed)
              ok = false;              
      }
  }
  if (ok)
      d.doPrint();
  else
      window.setTimeout('waitAndPrint_<%= fn %>()', <%= LOOP_TIMEOUT %>);
}