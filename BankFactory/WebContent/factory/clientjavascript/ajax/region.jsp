<%@ page import="com.bowstreet.security.framework.WEFSecurityManager" %><% 
 	// $, 0-9, A-Z, _, a-z, anything 0x80 and above.  Validates id parameter.
 	// Note: only intended to prevent insertion of potential exploit strings;
 	// not intended to validate JavaScript name correctness.
 	final String whitelistForId = "^[\\x240-9A-Z_a-z\\u0080-\\uffff]*$";

    response.setContentType("application/javascript");
    String id = WEFSecurityManager.checkForIllegalString( request.getParameter("id"), whitelistForId );
    String objName = "wpf_ajax_region_" + id;
%>
/**
 * Copyright (c) 2006, 2014 IBM. All Rights Reserved.
 */
if (typeof <%= objName %> == "undefined") {
var <%= objName %> = {
    first: true,
    idlist: {},    
    navigate: function (url) {
        var iframe = this.getIFrame();
        iframe.src = url;
    },
    hookSubmit: function(frm) {
        var url = frm.action;
        if (url.indexOf("javascript:") >= 0)
        {
            url = url.substring("javascript:".length);
            url = url.replace(/[^(]*(.*)/, "$1");
            var args = url.replace("(", "["); 
            args = args.replace(")", "]"); 
            args = eval(args);
    
            url = args[0];
        }
        frm.target = "<%= id %>"; // iframe name
        frm.action = url;
        <%= objName %>.getIFrame();
        return true;
    },
    
    handleLoad: function() {
        try {
        var found = !(this.idlist && this.idlist.length > 0); 
        var isTimeout = function(responseText) { 
            return responseText && responseText.indexOf('<') >= 0; 
        };
        var handleTimeout = function() {      
            top.location.reload(); 
        };
        if (typeof(wpf) == "object" && wpf.overrides && wpf.overrides.ajax) {
            if (typeof(wpf.overrides.ajax.isSessionTimeoutResponse) == "function")
                isTimeout = wpf.overrides.ajax.isSessionTimeoutResponse;

            if (typeof(wpf.overrides.ajax.handleSessionTimeout) == "function")
                handleTimeout = wpf.overrides.ajax.handleSessionTimeout;
        }

        var iframe = this.getIFrame();
        if (!<%= id %> || !<%= id %>.document) return;
        for (id in this.idlist) {
            var el = document.getElementById(id);
            if (!el) continue;
        
            // Get the contents of the special DIV with which the builder wrapped the page.
            var contentElement = <%= id %>.document.getElementById(id);
            if (!contentElement) { 
                if (!<%= id %>.document.body.innerHTML || !isTimeout(<%= id %>.document.body.innerHTML))
                    found = true;
                continue; 
            }               
            found = true;
               
            // Collect stylesheet references
            var links = <%= id %>.document.getElementsByTagName("link");
            for (var i = 0; i < links.length; i++)
            {
                var url = links[i].getAttribute("href");
                if (url)
                    this.addStyleSheet(url);
            }
            
            // Copy the HTML from the IFRAME to the view element.
   
            var html = contentElement.innerHTML;           
            el.innerHTML = html;
            
            // Collect scripts from the IFRAME document.      
            var scripts = this.nodesAsArray(contentElement.getElementsByTagName("script"));
            if (contentElement.className == "_wpf_ar_whole_page") {
                var heads = <%= id %>.document.getElementsByTagName("head");
                if (heads && heads.length)
                    scripts = scripts.concat(this.nodesAsArray(heads[0].getElementsByTagName("script")));
            }
            
            var scptTxt = "";
            for (var i = 0; i < scripts.length; i++)
            {
                var scpt = scripts[i].innerHTML;                 
                if (scpt)
                {
                    // HACK: special-case the script in the gridtable.html
                    // which creates a stylesheet link - this isn't needed
                    // because we copy styles, and provokes a FireFox bug.
                    if (!/_bst_gridtable_css_link/.test(scpt))
                    {
                        scptTxt += scpt + "\n";
                    }
                }
                var url = scripts[i].src;
                if (url)
                {
                    var el = document.createElement("script");                
                    el.type = "text/javascript";
                    el.defer = false;
                    el.src = url;
                    var heads = document.getElementsByTagName("head");      
                    if (heads.length) {
                        heads.item(0).appendChild(el);
                    } else {
                        var head = document.createElement("head");
                        head = document.documentElement.appendChild(head);
                        head.appendChild(el);
                    }                
                }
            }
            
            // If scripts were found above, load them into the root context.            
            if (scptTxt)
            {
                // See if we have set up a function to evaluate scripts.
                if (typeof window._wpf_global_eval == "undefined")
                {
                    // This call has the dual effects of testing for eval running in the global scope, 
                    // and defining the function. If this defines the function globally, then it can be used.
                    window.eval("var _wpf_global_eval = function(s) { window.eval(s); }");
                }
                if (typeof window._wpf_global_eval == "undefined")
                {
                    // Here for IE, Safari, or in others where eval doesn't happen in global scope.
                    window._wpf_global_eval = function(s)
                    {   // Add script tag to head with specified contents, executing it.
                        var el = document.createElement("script");
                        el.type = "text/javascript";
                        el.defer = false;
                        el.text = s;
                        var heads = document.getElementsByTagName("head");      
                        if (heads.length) {
                            heads.item(0).appendChild(el);
                        } else {
                            var head = document.createElement("head");
                            head = document.documentElement.appendChild(head);
                            head.appendChild(el);
                        }   
                    };
                }
                window._wpf_global_eval(scptTxt);
            }
        }
        this.addOnSubmitHandlers();
        if (!found)
            handleTimeout();
        } catch (ignored) {
           // may be caused by back button navigation when form POSTS are involved
        }
    },
    
    addOnSubmitHandlers: function() {
        // Add onsubmit handlers to all forms in the refresh region.
        for (id in this.idlist) {      
            var el = document.getElementById(id);
            if (!el) continue;
            var forms = el.getElementsByTagName("FORM");
            if (!forms) continue;
            for (var fx = 0; fx < forms.length; fx++) {
                var frm = forms[fx];
                if (frm["_wpf_form_hooked"]) continue;
                frm["_wpf_form_hooked"] = true;
                var ons = frm.onsubmit;
                var hs = this.hookSubmit;
                frm.onsubmit = (function(xfrm, xons) {return function() { if (xons && !xons.apply(xfrm, [])) { return false; } hs(xfrm); return true; };})(frm, ons);
            }
        } 
    },
    
    getIFrame: function() {
        return document.getElementById('<%= id %>');
    },  
    nodesAsArray: function(nodelist) {
        var arr = new Array();
        if (!nodelist) return arr;
        for (var i = 0; i < nodelist.length; i++) {
            arr.push(nodelist[i]);
        }
        return arr;
    },
    appendQueryParameter: function(url, name, value) {
        var sep = "?";
        if (url.indexOf("?") > 0)
            sep = "&";
        return url + sep + name + "=" + value;    
    },
    
    addStyleSheet: function(url) {
        var sheetTracker = "";
        if (!window.<%= id %>AddedStyleSheets)
            window.<%= id %>AddedStyleSheets = new Array();
        if (window.<%= id %>AddedStyleSheets[url])
            return;
        window.<%= id %>AddedStyleSheets[url] = true;
        
        // Add stylesheet, using DOM script to insert in HEAD, if possible.
        if (document.getElementsByTagName && document.getElementById)
        {
            var head;          
            var heads = document.getElementsByTagName("head");
            if (!heads || heads.length == 0)
            {
                var html = document.getElementsByTagName("html")[0];
                if (html)
                {
                    head = document.createElement("head");
                    html.appendChild(head);
                }
            }
            else head = heads[0];
            if (head)
            {  
                var link = document.createElement("link");
                link.setAttribute("rel", "STYLESHEET");
                link.setAttribute("type", "text/css");
                link.setAttribute("href", url);
                head.appendChild(link);
            }
        }    
    },
    
    handleWindowLoad: function() {
        if ("<%= id %>" != window.name) {
            <%= objName %>.addOnSubmitHandlers();
        }
    },
    
    addRegion: function(regionID) {    
        this.idlist[regionID] = true;        
    }
};
if(window.addEventListener) window.addEventListener('load', <%= objName %>.handleWindowLoad, false);
else if(window.attachEvent) window.attachEvent('onload', <%= objName %>.handleWindowLoad);
function <%= objName %>handleLoad() {
    <%= objName %>.handleLoad();
}
if ("<%= id %>" != window.name && !document.getElementById('<%= id %>')) {
    var frmSrc = "<IFRAME src='<%= request.getContextPath() %>/factory/pages/empty.html' " +
                          "id='<%= id %>' name='<%= id %>' " +
                          "style='visibility:hidden;height:1px' border='0' frameborder='0' " +  
                          "onload='<%= objName %>handleLoad()'></IFRAME>"; 
                          
    document.write(frmSrc);
    }
}
