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
 * Tree support.
 */
if (typeof(lastData) == "undefined") 
{
// begin tree javascript support

function initTreeApplet(sXml,appletName){
  var reg=new _tree_Applets();
  if(window._tree_AppletReg){
     window._tree_AppletReg.addApplet(sXml,appletName);
  }
}

function _tree_Applets(){
  if(window._tree_AppletReg) return;
  window._tree_AppletReg=this;
  // Run this function "on load" - need to use browser-specific means.
  var f = function() {
    window._tree_AppletReg.init();
    // Allow multiple initializations after initial "on load" has run.
    // Possible when Ajax-y means are used to load parts of a page, e.g., Portal CSA.
    window._tree_AppletReg=null;
  };
  // Modern browsers other than IE
  if (window.addEventListener) window.addEventListener('load', f, false);
  // Internet Explorer
  else if (window.attachEvent) window.attachEvent('onload', f);
  // Relics like NS4
  else window.setTimeout(f, 2000);
  window._tree_AppletReg._applets= new Array();
}


function _tree_AppletsAddApplet(sXML,sName){
    var index=window._tree_AppletReg._applets.length;
    var appletsWithThisName = 0;
    for (var i = 0; i < index; i++) {
        var a = window._tree_AppletReg._applets[i];
        if (a._name == sName)
            appletsWithThisName++;
    }
    var oAppletData=new _tree_AppletData(sName,sXML,appletsWithThisName)
    window._tree_AppletReg._applets[index]=oAppletData;
}

function _tree_AppletsInit(){
   for(oApplet in window._tree_AppletReg._applets){
        if(window._tree_AppletReg._applets[oApplet]){
           var sName=window._tree_AppletReg._applets[oApplet]._name;
           var sXML=window._tree_AppletReg._applets[oApplet].xml;

           // this might be a list if there are
           // two tree applets with the same name
           var thisApplet=document.applets[sName];
/* This fails in Firefox, and I'm pretty sure we would break in other places if more than one tree had the same name.           
           if (thisApplet.length) {
               var ix = window._tree_AppletReg._applets[oApplet].nameIndex;
               thisApplet = thisApplet[ix];
           }
*/           
           // var thisApplet=document.applets[oApplet];

           if(thisApplet){
              thisApplet.setTreeXML(sXML);

           }
        }
   }
}

function _tree_AppletData(name,xml,appletsWithThisName){
  this._name=name;
  this.xml=xml.replace(/&apos;/g, "'");
  this.nameIndex=appletsWithThisName;
}

var lastData=null;

function resetlastData(){
  lastData=null;
}

function bsError(){
  return true;
}

function getOriginalName(name){
  var stemp=name
  var pos =stemp.indexOf('_');
  while(pos >-1){
    stemp=stemp.substr(pos+1);
    pos =stemp.indexOf('_');
  }
  return stemp;
}

// Called from the applet code to run a specified model action
function callFunctionForTreeNodeEvent(action, target, inputName) {
    var url = document.location.href;
    var frm;
    item = getTreeControlInputByID(inputName)
    if (!item)
        item = lookupFormControl(inputName);
    if (!item)
        return;
    frm = item.form;
    if (!frm)
        return;
    url = url.replace(/\?.*/, "");
    if (/Action!/.test(url)) {
        url.replace(/Action!([^\/]*)/, "Action!" + action);
    } else {
        url = url + "/Action!" + action;
    }
    frm.action = url;
    if (target)
    frm.target = target;
    if (!frm.onsubmit || frm.onsubmit()) {
        frm.submit();
    }
}

function getTreeControlInputByID(id)
{
    var i,j;
    var theForms = document.forms;
    for (var i=0; i<theForms.length; i++) {
        var elems = theForms[i].elements;
        for (j=0; j<elems.length; j++) {
            if (elems[j].id == id)
                return elems[j];
        }
    }
    return null;
}

function lookupFormControl(nameIn)
{
    if (document.all != null) // The IE solution
    {
        return document.all.item(nameIn);
    }
    else // The Netscape solution
    {
        var i,j;
        var theForms = document.forms;
        for (var i=0; i<theForms.length; i++) {
            var elems = theForms[i].elements;
            for (j=0; j<elems.length; j++) {
                if (elems[j].name == nameIn)
                    return elems[j];
            }
        }
        return null;
    }
}

function updateTreeInputValue(s) {
   var id = s.name.substring(1);
   var value = "", sep = "";
   for (var i = 0; i < s.options.length; i++) {
       var o = s.options[i];
       if (!o.selected)
           continue;
       
	   value = value + sep + (o.value || o.text);
       sep = ";";
   }
   setTreeInput(id, value);
}

function setTreeInput(inputName,data){
  oInput = getTreeControlInputByID(inputName);
  if (!oInput)
      oInput =lookupFormControl(inputName);
  if(oInput){
    if(lastData==data){
      lastData=null;
      var sfunction = "on"+getOriginalName(inputName)+"_DBLClick";
      window.onerror=bsError;
      var ofunc=eval(sfunction);
      window.onerror=null;
      if(ofunc !=null &&typeof ofunc=='function'){
        eval(sfunction+'()');
      }
    }else{
      lastData=data;
      var changed = (oInput.value != data);
      oInput.value=data;
      if (oInput.onclick)
          oInput.onclick();
      else if (changed && oInput.onchange)
          oInput.onchange();
    }
    window.setTimeout('resetlastData();',500,'javascript')
  }
}

_tree_Applets.prototype.addApplet=_tree_AppletsAddApplet;
_tree_Applets.prototype.init=_tree_AppletsInit;

// end tree support

};


