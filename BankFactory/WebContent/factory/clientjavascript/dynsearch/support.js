/**
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006 IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * WPF/LWF CORE PRODUCT SUPPORT - NOT CUSTOMER MODIFIABLE
 *
 * Customer modification of core product files may void support agreements with
 * respect to affected portions of the product and any changes you make to the
 * core product files may be lost when the product is upgraded.
 *
 * Generic typeahead support.
 */
if (typeof wpf_dynsearch == "undefined")
{
    var wpf_dynsearch = {
        onkeyup: function(opts) {
            // Accumulate keystrokes to prevent multiple requests in too short a time.
            var pending = wpf_dynsearch.pending;
            if (pending.timerID) {
                window.clearTimeout(pending.timerID);
                pending.timerID = null;
            }
            pending.opts = opts;
            pending.timerID = window.setTimeout("wpf_dynsearch.showChoices(wpf_dynsearch.pending.opts)", opts.keystrokeDelay || 500);            
        },
        
        showChoices: function(opts) {
            // Bring up the picker, creating if necessary.
            wpf_dynsearch.current = opts.input;
            var c = document.getElementById("wpf_dynsearch_container");
            if (!c) {
                c = document.createElement("div");
                c.setAttribute("id", "wpf_dynsearch_container");
                c.setAttribute("class", "wpf_dynsearch_container");
                c.innerHTML = "<form id='wpf_dynsearch_form' target='wpf_dynsearch_frame' method='POST'><input type='hidden' name='pat' /><input type='hidden' name='id' /></form><iframe id='wpf_dynsearch_frame' class='wpf_dynsearch_frame' name='wpf_dynsearch_frame' />";
                document.body.appendChild(c);
            }
            var value = opts.input.value;
            if (!value) {
                wpf_dynsearch.closePicker();
                return;
            }

            c.style.display = "block";
            c.style.position = "absolute";
            c.style.left = wpf_dynsearch.getX(opts.input) + "px";
            c.style.top = wpf_dynsearch.getY(opts.input) + "px";
            c.style.zIndex = wpf_dynsearch.getMaxZ(opts.input) + 1;
            
            var iframe = document.getElementById("wpf_dynsearch_frame");
            iframe.setAttribute("width", opts.width);
            iframe.setAttribute("height", opts.height);
            // Arrange for lost focus to close picker, unless focus goes to the picker.
            wpf_dynsearch.elementFocusLost = function() { wpf_dynsearch.closePicker(); };
            var handleBlur = function() {             
                window.setTimeout(function() {
                    wpf_dynsearch.elementFocusLost();
                    wpf_dynsearch.elementFocusLost = function() { wpf_dynsearch.closePicker(); };                    
                }, 500); };
            var handleFocus = function() {     
                wpf_dynsearch.elementFocusLost = function() {}; 
            };
            opts.input.onblur = handleBlur;
            opts.input.onfocus = handleFocus;

            iframe.contentWindow.onfocus = handleFocus;
            iframe.contentWindow.onblur = handleBlur;            
            iframe.onload = function() {
                this.contentWindow.onfocus = handleFocus;
                this.contentWindow.onblur = handleBlur;                
            };            
            var form = document.getElementById("wpf_dynsearch_form");
            form.elements['pat'].value = value;
            form.elements['id'].value = opts.input.id;
            form.action = opts.url;
            form.submit();            
        },
        selectItem: function(value) {
            if (wpf_dynsearch.current)
            {
                wpf_dynsearch.current.value = value;
            }                
            wpf_dynsearch.closePicker();
        },
        closePicker: function() {
            var c = document.getElementById("wpf_dynsearch_container");
            c.style.display = "none";
            wpf_dynsearch.pending = {};            
        },
        getX: function(el)
        {
          return wpf_dynsearch.getOffset(el, "offsetLeft")
        },
    
        getY: function(el)
        {
          return wpf_dynsearch.getOffset(el, "offsetTop") + el.offsetHeight;
        },
        
        getOffset: function(el, attr)
        {
          var off = 0;
          while (el)
          {          
            off += el[attr]; 
            el = el.offsetParent;
          }
          return off;
        },
        
        getMaxZ: function(el) {
            var maxSoFar = 1;
            while (el) {
                if (el.style) {
                    var z = el.style.zIndex;
                    if (z > maxSoFar) maxSoFar = z;
                }
                el = el.parentNode;
            }
            return maxSoFar;
        },

        pending: {}
    };
};
