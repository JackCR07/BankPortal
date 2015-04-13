/**
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006,2012 IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * WPF/LWF CORE PRODUCT SUPPORT - NOT CUSTOMER MODIFIABLE
 *
 * Customer modification of core product files may void support agreements with
 * respect to affected portions of the product and any changes you make to the
 * core product files may be lost when the product is upgraded.
 *
 *  Incremental Search Support
 */
function BowStIncrementalSearch()
{
    this.currentID = 1;
    this.xmlHttp = null;
    this.pendingTimerID = null;
    this.keystrokeDelay = 500; // milliseconds
    this.maxViewResults = 10;
}

if (!BowStIncrementalSearch.instance)
{
// Don't re-define all this stuff if we've been pulled in before.


BowStIncrementalSearch.prototype.getChoices = function(el, url)
{
    // If the Ajax Type Ahead builder targets the page location of an element that is declaring a dojo widget, then the
    // onkeyup handler will pass the dojo widget as 'el'. In that case, the DOM element we're looking for is the "focus
    // node" of the dojo widget. If the Ajax Type Ahead builder targets the page location of a non-dojo element, then
    // the onkeyup handler will pass the DOM element of the text field we're looking for as 'el'.
    if (el.focusNode)
    {
        el = el.focusNode;
    }
    if (!document.getElementById || !el.value)
    {
        return;
    }   
    if (!el.id)
    {
        el.id = "_bst_el" + this.currentID++;
    }
    
    if (this.pendingTimerID)
    {
        window.clearTimeout(this.pendingTimerID);
        this.pendingTimerID = null;
    }
    
    this.pendingID = el.id;
    this.pendingValue = el.value;
    this.pendingURL = url;
  
    this.pendingTimerID = window.setTimeout("BowStIncrementalSearch.instance.doServiceCall()", this.keystrokeDelay);
}

BowStIncrementalSearch.prototype.doServiceCall = function()
{
    this.callService(this.pendingID, this.pendingValue, this.pendingURL);
}

BowStIncrementalSearch.prototype.makeChoice = function(sel, txtid)
{
    if (sel.options && sel.selectedIndex < 0)    
        return;
    var txt = document.getElementById(txtid);
    var selTxt = sel.options ? sel.options[sel.selectedIndex].text : sel.value;
    txt.value = selTxt;
    var selid = "_bst_incremental_selector";
    var c = document.getElementById(selid);
    c.innerHTML = "";
    // IE focus bug workaround.
    if (navigator && navigator.userAgent && navigator.userAgent.indexOf("MSIE") > -1)
        setTimeout(function () {txt.focus();}, 100);
    else
    	txt.focus();
}

BowStIncrementalSearch.prototype.calculateOffsetLeft = function(el)
{
  return this.getOffset(el, "offsetLeft")
}

BowStIncrementalSearch.prototype.calculateOffsetTop = function(el)
{
  return this.getOffset(el, "offsetTop") + 24;
}

BowStIncrementalSearch.prototype.getOffset = function(el, attr)
{
  var off = 0;
  while (el)
  {
    off += el[attr]; 
    el = el.offsetParent;
  }
  return off;
}
// Attempt to get an object capable of calling back to the server.
BowStIncrementalSearch.prototype.getXMLHTTP = function()
{
    var xh = null;
    try {
        xh = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (noMsxml2) {
      try {
        xh = new ActiveXObject("Microsoft.XMLHTTP");
      } catch(noActiveXObject) {
        xh = null;
      }
    }
    if (!xh && typeof XMLHttpRequest != "undefined") {
        xh = new XMLHttpRequest();
    }
    return xh;
}
// Call the service to get a list of results.
BowStIncrementalSearch.prototype.callService = function(id, pat, url)
{
    // If there is a pending request, cancel it.
    if (this.xmlHttp && this.xmlHttp.readyState!=0)
    {
        this.xmlHttp.abort();
    }
    if (pat == null) pat = "";
    this.xmlHttp=this.getXMLHTTP();
    if (this.xmlHttp)
    {
        var iq = url.indexOf("?");
        var us = iq < 0 ? "?" : "&";
        this.xmlHttp.open("POST", url, true);
        this.xmlHttp.onreadystatechange = function()
        {
          var xmlHttp = BowStIncrementalSearch.instance.xmlHttp;
      
          if (xmlHttp.readyState == 4 && xmlHttp.responseText)
          {       
              var prog = "BowStIncrementalSearch.instance.handleServiceResult(" + xmlHttp.responseText + ")";                      
              eval(prog);
          }
        }

        this.xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");         
        this.xmlHttp.send("pat=" + encodeURIComponent(pat) + "&id=" + encodeURIComponent(id));
    }
}
// Called when service results are available.
BowStIncrementalSearch.prototype.handleServiceResult = function(id, results)
{
    var selid = "_bst_incremental_selector";
    var el = document.getElementById(id);
    var c = document.getElementById(selid);
  
    if (c)
    {
        // Cannot reuse this div due to IE 6 bug.
        document.body.removeChild(c);
    }  
    c = document.createElement("DIV");
    c.id = selid;
    c.style.position = "absolute";
    document.body.appendChild(c);
    
    c.style.left = this.calculateOffsetLeft(el) + "px";
    c.style.top = this.calculateOffsetTop(el) + "px";
    var z = this.getMaxZ(el, 1);
    c.style.zIndex = z + 1;
    
    var h = "";
       
    if (results && results.length > 0)
    {
        // There are results: build a select to display them.
        var selSize = results.length;
        if (selSize > this.maxViewResults)
            selSize = this.maxViewResults;         
        if (selSize > 1)
        {
            h = document.createElement("select");
            h.setAttribute("size", selSize);
            for (var i = 0; i < results.length; i++)
            {
                var opt = document.createElement("option");
                opt.text = results[i];
                try { h.add(opt, null) } catch (ex) { h.add(opt); }
            }   
            h.setAttribute("style", "width:" + el.offsetWidth + "px;");
        }
        else
        {
            // Just one result: make a disabled text input.
            h = document.createElement("input");
            h.setAttribute("type", "text");
            h.setAttribute("readonly", "true");
            h.setAttribute("value", results[0]);
            var sz = el.getAttribute("size");
            if (sz) {
                h.setAttribute("size", sz);
            } else {
                h.setAttribute("style", "width:" + el.offsetWidth + "px;");
            }
        }
    }
    c.innerHTML = "";
    if (!h) 
        return;
    h.elementFocusLost = function() { 
        c.innerHTML = ""; 
    };
    h.onfocus = function() {
        // FF and IE selection behavior incorrect when selectedIndex is set.
        var isFF = navigator && navigator.userAgent && (navigator.userAgent.indexOf("Firefox") >= 0);
        var isIE = navigator && navigator.userAgent && (navigator.userAgent.indexOf("MSIE") >= 0);
        if (this.nodeName == "SELECT" && !isFF && !isIE)
    		this.options.selectedIndex = 0;
        h.onblur = function() { 
            c.innerHTML = ""; 
        }; 
        h.elementFocusLost = function() {};         
    };
    h.onclick = function() { 
        BowStIncrementalSearch.instance.makeChoice(this, id); 
    }; 
    h.onkeydown = function (e) { 
        var cc = (e || (e = window.event) || (e = {keyCode:0})).keyCode; 
        if (cc == 13)
        { 
            // Enter key acts like a click.
            e.cancelBubble = true;
            e.returnValue = false; 
            window.setTimeout(function() { BowStIncrementalSearch.instance.makeChoice(h, id); }, 500);
            return false;
        }
        else if (cc == 38 && ((!this.options) || this.selectedIndex == 0))
        {
            // Up-arrow on top item goes back to text input.        
            h.onblur = function() {};
            c.innerHTML = "";        
            el.focus();
        } 
    };   
    c.appendChild(h);  
    el.onblur = function() { 
        window.setTimeout(function() { 
            el.onblur = null; 
               h.elementFocusLost(); 
        }, 500); };
    el.onkeydown = function(e) {
        var cc = (e || (e = window.event) || (e = {keyCode:0})).keyCode;
        if (cc == 40)
        {
            // Down-arrow in text box goes into picker.
            e.cancelBubble = true;
            e.returnValue = false;
            try { h.focus(); } catch (ignored) {}
            return false;
        }    
    };
}
BowStIncrementalSearch.prototype.getMaxZ = function(el, maxSoFar) {
   while (el) {
       if (el.style) {
           var z = el.style.zIndex;
           if (z > maxSoFar) maxSoFar = z;
       }
       el = el.parentNode;
   }
   return maxSoFar;
}
BowStIncrementalSearch.instance = new BowStIncrementalSearch();
}  
    

