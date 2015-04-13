/**
 * Description:  DragDropTarget widget JavaScript File
 *
 * Licensed Materials - Property of IBM 
 * 5724-O03
 * Copyright 2006, 2008. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use. 
 *
 */
dojo.provide("wpf.widget.DragDropTarget");

dojo.require("dojo.dnd.Source");
dojo.require("dijit._Widget");

dojo.declare(
    "wpf.widget.DragDropTarget",
	dijit._Widget,
    {
        // Create a dojo.dnd.Target object, and override its behavior to suit our purposes.
		postCreate: function()
		{
		    // Prepare creation parameters for the Target.
		    var connectid = this.domNode.getAttribute("connectid");
		    var accept = this.domNode.getAttribute("accept");
	        var targetParams = {
	            isSource: false,
	            accept: [ accept ],
	            copyOnly: true
	        };
	        // Make a Target controlling our own dom node.
		    var target = new dojo.dnd.Target(this.domNode, targetParams);
            // Give this object a new drop handler.
		    target.onDndDrop = function(source, nodes, copy) {
		        // if it's not for us leave
		        if(this.containerState != "Over")
		            return;
		        var input = dojo.byId(connectid);
		        if (!input) { console.log("cannot find object with id " + connectid); return; }
  		        if (!input.onclick) { console.log("action handler does not have an onclick method"); return; }
		        input.value = nodes[0].getAttribute("dragDropData");  
		        // This will trigger the action specified in the builder.      
		        input.onclick();
		    };
		}
	}
);
