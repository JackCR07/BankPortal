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
 */
/*** openModalDialog.js
 ***
 *** Used to provide a cross-browser way to open and close modal dialogs, since
 *** they are not officially supported by Mozilla. Call openModalDialog() function
 *** with a callback function pointer. When the window closes (using closeModalDialog()),
 *** your JS function will be called. 
 ***
 *** IE's showModalDialog() function is used; for Mozilla, a modal dialog is simulated by
 *** setting the parent window to handle events by passing focus back to the dialog.
 *** One difference between IE and Mozilla: In Mozilla, openModalDialog() will return
 *** immediately. In IE, it won't return until after the window is closed.
 ***/
/***
 ***	Edited by Daniel Delion, 25/03/2004
 ***/
if (typeof(window.BrowserWindowClose)=="undefined"){
	window.BrowserWindowClose = window.close;
}


function isGecko() {
  return (document.all) ? false : true;
}

function openModalDialog(sUrl, fCallback) {
  window.modalCallback = fCallback;
  var retVal = window.showModalDialog(sUrl, '', 'resizable: Yes;status: No;help: No;');
  if (retVal) window.modalCallback(retVal);

}

function closeModalDialog(data) {
  if (data) {
    window.returnValue = data;
    if (isGecko() && window.opener && window.opener.modalCallback) {
      window.opener.removeEventListener("focus", resetFocus, false);
      window.opener.removeEventListener("click", resetFocus, false); 
      window.opener.removeEventListener("change", resetFocus, false); 
      window.opener.modalCallback(data);
    }
  }
  window.close();
}



if(isGecko())
{
	window.showModalDialog = Gecko_showModalDialog;
}


oGeckoDlgArg = null;
oGeckoDlgRet = null;

function Gecko_showModalDialog(url, args, opt)
{
	var title = "";

	if(typeof args == "object")
		if(args && args.dlgTitle)
			title = args.dlgTitle;
		else
			title = "";
	else
		if(typeof args == "string")
			title = args;

    var aOpts;
	if (opt) aOpts = opt.split(";");
	else aOpts = new Array();
	aOpts[aOpts.length] = "dialog:yes";
	aOpts[aOpts.length] = "modal:yes";

	for(var i=0;i<aOpts.length;i++)
	{
		var aPair = aOpts[i].split(":");
		switch(aPair[0])
		{
		case "dialogHeight":
			aPair[0] = "height";
			break;
		case "dialogWidth":
			aPair[0] = "width";
			break;
		case "center":
			aPair[0] = "centerscreen";
			break;
		}

	aOpts[i] = aPair.join("=");
	}

	var sOpts = aOpts.join(",");
	oGeckoDlgArg = args;
	oGeckoDlgRet = null;
	
	window.modalWin = this.open(url, title, sOpts);
        window.addEventListener("focus", resetFocus, false);
        window.addEventListener("click", resetFocus, false);
        window.addEventListener("change", resetFocus, false);
	return oGeckoDlgRet;
}

if(isGecko())
{
	Gecko_InitDialog();
	if(top.opener && top.opener.oGeckoDlgArg) {
	  window.closeOrg = window.close;
	  window.close = Gecko_CloseWindow;
	}
}

function Gecko_InitDialog()
{
	if(top.opener && top.opener.oGeckoDlgArg)
		self.dialogArguments = top.opener.oGeckoDlgArg;
}

function Gecko_EndDialog()
{
	if(top.opener)
		top.opener.oGeckoDlgRet = self.returnValue;
}

function Gecko_CloseWindow()
{
	Gecko_EndDialog();
	window.closeOrg();
}

function resetFocus(event) {
  window.modalWin.focus();
}

/*****************************************************************************************/
/**** Dialog resizing function, from spell checker code ***/

//Resizes dialog. Call this from an onload event handler. Typically, contentWidth should
//be [containingElement].offsetWidth and contentHeight should be [containingElement].offsetHeight.
//gWidth and gHeight are in case modifications are needed for Gecko (Mozilla). They are
//optional.
function resizeDialog(contentWidth, contentHeight, gWidth, gHeight) {
	if (isGecko()) {               
		window.innerWidth = (gWidth == null) ? contentWidth : gWidth; 
		window.innerHeight = (gHeight == null) ? contentHeight : gHeight; 
	} else {
		var dialogHeight = parseInt(window.dialogHeight.substring(0, window.dialogHeight.length-2));
		var dialogWidth = parseInt(window.dialogWidth.substring(0, window.dialogWidth.length-2));
		var chromeHeight = dialogHeight - document.body.offsetHeight;
		var chromeWidth = dialogWidth - document.body.offsetWidth;
		window.dialogHeight = "" + (contentHeight + chromeHeight) + "px";
		window.dialogWidth = "" + (contentWidth + chromeWidth) + "px";
	}
}





