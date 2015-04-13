/* Licensed Materials - Property of IBM 
 * 5724-O03
 * Copyright 2009. IBM Corp.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 */
if(!dojo._hasResource["wpf.data.WPFXmlStore"]){ // Check to see if it has already been declared
dojo._hasResource["wpf.data.WPFXmlStore"] = true;
dojo.provide("wpf.data.WPFXmlStore");
dojo.require("dojox.data.XmlStore");

// WPFXmlStore is an extension of XmlStore to handle posting data back to a WPF model
dojo.declare("wpf.data.WPFXmlStore", dojox.data.XmlStore, {
	// Take over XmlStore _saveItem function
	_saveItem: function(item, keywordArgs, method){
	
	var url;
	var scope;
	url = this._getPostUrl(item);
	if(!url){
		if(keywordArgs.onError){
			scope = keywordArgs.scope || dojo.global;
			keywordArgs.onError.call(scope, new Error("No URL for saving content: " + this._getPostContent(item)));
		}
		return;
	}

	// Always use a POST back to the server, but place real operation in the X-Method-Override header
	var saveArgs = {
		url: url,
		method: "POST",
		contentType: "text/xml",
		handleAs: "xml",
        headers: {}
	};
	// place the desired HTTP method type in a special header since WPF can only handle POST for changes. 
	saveArgs.headers = {"X-Method-Override": method};
	// always use POST for saving back to WPF model (i.e. can't use HTTP PUT, DELETE).
	saveArgs.postData = this._getPostContent(item);

	var saveHandler = dojo.rawXhrPost(saveArgs);
	scope = (keywordArgs.scope || dojo.global);
	var self = this;
	saveHandler.addCallback(function(data){
		self._forgetItem(item);
		if(keywordArgs.onComplete){
			keywordArgs.onComplete.call(scope);
		}
	});
	saveHandler.addErrback(function(error){
		if(keywordArgs.onError){
			keywordArgs.onError.call(scope, error);
		}
	});
}
});
}
