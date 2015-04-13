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
 * Loads the specified CSS file, optionally checking to see if it has already been loaded.
 *
 * Request parameters:
 * css		URL of full CSS file
 * rule		optional CSS selector to search for in existing styles -
 *			if found, the xcss file will be loaded instead of css
 * xcss		URL of alternate CSS file, loaded if rule is already defined
 */
  	// All WEF references to the css and xcss parameters are relative URLs
 	// to CSS files somewhere under "/factory".  We'll allow a null or any
 	// relative URL path whose parts contain a-z, A-Z, 0-9, or "_" characters.
	final String whitelistForCssAndXcss = "^((/\\w+)+\\.css)?$";

 	// All WEF references to the rule parameter specify ".lotus" as the
 	// value.  We'll allow a null or any string that begins with a period
 	// followed by one or more a-z, A-Z, 0-9, or "_" characters.
	final String whitelistForRule = "^(\\.\\w+)?$";

     try {
         response.setHeader("Cache-Control", "max-age=60"); 
     } catch (Exception e) {}
     response.setContentType("application/javascript");
     String css = request.getContextPath() + WEFSecurityManager.checkForIllegalString( request.getParameter("css"), whitelistForCssAndXcss );
     String xcss = WEFSecurityManager.checkForIllegalString( request.getParameter("xcss"), whitelistForCssAndXcss );
     if (xcss != null && xcss.length() > 0)
         xcss = request.getContextPath() + xcss;
     else
         xcss = "";
     String rule = WEFSecurityManager.checkForIllegalString( request.getParameter("rule"), whitelistForRule );
     boolean checkRule = rule != null && rule.length() > 0;
 %>
(function() {
 var addStyleSheet=function(url){
  var h = document.getElementsByTagName("head")[0];
  var ss = document.createElement("link");
  ss.type = "text/css";
  ss.rel = "stylesheet";
  ss.href = url;
  h.appendChild(ss);
 };
<% // See if we've already loaded this one.  Note that loop below checks for somebody else loading the same styles. %>
 if (!window._wpf_loadCSS_tracker)
  window._wpf_loadCSS_tracker={};
 var tracker=window._wpf_loadCSS_tracker;
 if(tracker["<%= css %>"]){
  return;
 }
<% if (checkRule) { // If rule is defined, see if it's present in existing styles.%>
 for (var i=0;i<document.styleSheets.length;i++){
  try{
   var sheet=document.styleSheets[i];
   var rules=sheet.rules || sheet.cssRules;
   for(var j=0;j<rules.length;j++){
    var sel=rules[j].selectorText;
    if(sel && sel.indexOf("<%= rule %>")>=0){
     <% // rule is defined - load alternate CSS if specified, otherwise just bail %>
     if("<%= xcss %>")
      addStyleSheet("<%= xcss %>");
     return;
    }
   }
  }catch(badSheet){}
 }
<% } %>
<% // Haven't seen this CSS file yet - add it, and remember that we added it. %>
 addStyleSheet("<%= css %>");
 tracker["<%= css %>"]=true;
})()