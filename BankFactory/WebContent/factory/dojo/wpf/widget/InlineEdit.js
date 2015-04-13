/**
 * Description:  Inline Edit JavaScript File
 *
 * Licensed Materials - Property of IBM 
 * 5724-O03
 * (C) Copyright 2006. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use. 
 *
 */
dojo.provide("wpf.widget.InlineEdit");

dojo.require("dijit._Widget");
dojo.require("dijit._Container");


dojo.declare(
	"wpf.widget.InlineEdit",
	[dijit._Widget, dijit._Container],
	{
	    // The path to the html template that will replace the target dojoType TextEdit element.
	    // For performance reasons we are NOT using Dojo type templates, instead we use a template at regen time in the builder.
		templatePath: null,
		// The style sheet template for styles that are used in the html (currently not used)
		templateCssPath: null,

	    // The name of this widget
		widgetType: "InlineEdit",
		cancelEventName: "WPF/InlineEdit/Cancel/Edit",
		processCancelEventName: "",
		cancelEventHandle: null,
		isContainer: false,
		editOnClick: false,
		continueAutoCancel: false,
		allowMultipleEdits: false,
		inputQuery: "input,textarea",
		originalValue: "",
		inputType: "",
		editOnClickHandle: null,
		endEditHandle: null,

	    // minimum size of input
    	minSize: 2,

		// Nodes we care about from the inline_edit.html template
    	textDisplayNode: null,
	    editImageNode: null,
	    saveImageNode: null,
        cancelImageNode: null,
        inputContainerNode: null,
        
        
	    /**
	     * This function is called by Dojo after the widget is constructed.
	     *
	     * This is used to initialized, and find all the elements needed by the onEdit(),onSave(), and onCancel()
	     */
		postCreate: function(args, frag)
		{
	       // Get the elements we need to control
	       // Note - If we used the Dojo html templates these would automatically get populated using the dojoAttachPoint attribute
	       // For client redraw performance reasons we are using a template at regen time.
	       this.textDisplayNode = this.getElement("textDisplayNode");
	       this.inputContainerNode = this.getElement("inputContainerNode");
	       this.editImageNode = this.getElement("editImageNode");
	       this.saveImageNode = this.getElement("saveImageNode");
	       this.cancelImageNode = this.getElement("cancelImageNode");

           if(this.editOnClick)
        	    this.editOnClickHandle = this.connect(this.srcNodeRef.parentNode, "onclick", "onEdit");
           
           // Connect the images "onclick" event to our handlers
           this.connect(this.editImageNode, "onclick", "onEdit");
   		   this.connect(this.saveImageNode, "onclick", "onSave");
   		   this.connect(this.cancelImageNode, "onclick", "onCancel");
   		   
   		   
   		   // Override functions based on edit widget type.
			if(this.inputType == "com.bowstreet.builders.webapp.RadioButtonGroupBuilder")
			{
				this.getDisplayValue = this.getRadioDisplayValue;
				this.getOriginalValue = this.getRadioOriginalValue;
				this.setInputValue = this.setRadioInputValue;
			}
			else if(this.inputType == "com.bowstreet.builders.webapp.DojoSelectBuilder")
			{
				this.getDisplayValue = this.getDojoSelectDisplayValue;
				this.getOriginalValue = this.getDojoSelectOriginalValue;
				this.setInputValue = this.setDojoSelectInputValue;
			}
			else if(this.inputType == "com.bowstreet.builders.webapp.SelectBuilder")
			{
				this.getDisplayValue = this.getSelectDisplayValue;
				this.setInputValue = this.setSelectInputValue;
			}
			else if(this.inputType == "com.bowstreet.builders.webapp.DojoCheckBoxBuilder")
			{
				this.setInputValue = this.setDojoCheckBoxInputValue;
				this.getOriginalValue = this.getDojoCheckboxOriginalValue;
			}
			else if(this.inputType == "com.bowstreet.builders.webapp.CheckBoxBuilder")
			{
				this.setInputValue = this.setCheckBoxInputValue;
			}
			else if(this.inputType == "com.bowstreet.builders.webapp.DojoEditorBuilder")
			{
				this.setInputValue = this.setRichTextInputValue;
			}
		},
		
		// cleanup editors that are under inline edit. required by smart refresh
		destroyDescendants: function(preserveDom) {
			dojo.forEach(this.getDescendants(), function(widget) {
				// don't do work if already destroyed
				if (widget.destroyRecursive && widget._destroyed != true) {
					widget.destroyRecursive(preserveDom);
				}
			});
			this.inherited(arguments);
		},
				
		/////////////////////////
		// Handler when the edit icon is clicked
		/////////////////////////
		onEdit: function(e)
		{
			var originalTarget = this.getOriginalTarget(e);
			// Don't go back into edit mode if Save or Cancel was hit
			if(originalTarget == this.cancelImageNode || originalTarget == this.saveImageNode)
				return;
			
			// first cancel any other edits going on (pass us so we can be modified by the other widget instance)
			dojo.publish(this.cancelEventName, [this]);
			
			// see if the user choose not to cancel 
			if(this.continueAutoCancel)
			{
				this.continueAutoCancel = false;
				dojo.stopEvent(e);
				return;
			}
			
			// disconnect click to edit while in edit mode
           if(this.editOnClickHandle != null)
           {
        	   this.disconnect(this.editOnClickHandle);
        	   this.editOnClickHandle = null;
           }
		   
		   
		   this.showEdit(true);
           
		   // set backgroundColor to because of row highlighter
		   if(this.inputType == "com.bowstreet.builders.webapp.DojoEditorBuilder")
	          dojo.style(this.getIframeBody(), {backgroundColor: "white"});

		   
		   // now subscribe so other can close us
		   if(this.allowMultipleEdits == false && this.cancelEventHandle == null)
		       this.cancelEventHandle = dojo.subscribe(this.cancelEventName, this, this.autoCancel);
		   
	       var input = this.getVisibleInputElement();
		    
		   if(input)
		   {
			   this.originalValue = this.getOriginalValue();
			   input.focus();
			   // Set input size ??
		   }

			// stop any further handling of this event
			dojo.stopEvent(e);
		},

		/////////////////////////
	    // Handler when the save icon is clicked
		/////////////////////////
		onSave: function(e)
		{
			if(this.cancelEventHandle != null)
			{
			    dojo.unsubscribe(this.cancelEventHandle);
			    this.cancelEventHandle = null;
			}
			
	        if(this.editOnClick && this.editOnClickHandle == null)
	        	this.editOnClickHandle = this.connect(this.srcNodeRef.parentNode, "onclick", "onEdit");
			
		    this.showEdit(false);

		    var value = this.getDisplayValue();
		    
	        // put the input text back in the display node
			this.textDisplayNode.innerHTML = value;

			// stop any further handling of this event
		//	dojo.stopEvent(e);
		},

		
		/////////////////////////
	    // Handler when the cancel icon is clicked
		/////////////////////////
		onCancel: function(e)
		{
			if(this.editOnClick && this.editOnClickHandle == null)
			   	this.editOnClickHandle = this.connect(this.srcNodeRef.parentNode, "onclick", "onEdit");

			
			if(this.cancelEventHandle != null)
			{
			    dojo.unsubscribe(this.cancelEventHandle);
			    this.cancelEventHandle = null;
			}
			
			
		    this.showEdit(false);
		    
            // revert the input value back to the display value
		    this.setInputValue(this.textDisplayNode.innerHTML);

			// stop any further handling of this event
			if (e)
				dojo.stopEvent(e);
		},

        // used to auto cancel when another field is selected
        autoCancel: function(target)
        {
        	// see if the user wants to cancel the cancel
        	this.processAutoCancel();

        	target.continueAutoCancel = this.continueAutoCancel;
        	
        	if(this.continueAutoCancel)
        	{
     	       var input = this.getVisibleInputElement();
   		    
    		   if(input)
    			   input.focus();

        		return;
        	}

        	
        	this.continueAutoCancel = false;

        	this.onCancel(null);
        },
        
        
		/////////////////////////
	    // Show/Hide the elements based on whether or not we are in the edit mode.
		/////////////////////////
		showEdit: function(showEdit)
		{
	        dojo.style(this.textDisplayNode, {display : showEdit?"none":""});
	        dojo.style(this.inputContainerNode, {display : showEdit?"":"none"});
	        // don't change if editOnClick enabled
	        if(!this.editOnClick)
	          dojo.style(this.editImageNode, {display : showEdit?"none":""});
	        dojo.style(this.saveImageNode, {display : showEdit?"":"none"});
	        dojo.style(this.cancelImageNode, {display : showEdit?"":"none"});
	        
	        if(showEdit)
		        dojo.style(this.inputContainerNode, {color : "black"});
	        else
		        dojo.style(this.inputContainerNode, {color : ""});
		},


		processAutoCancel: function()
		{
			function InlineEditState()
			{
				this.continueAutoCancel = true;
			}
			
			var state = new InlineEditState();
			
			if(typeof wpf_event_bus != "undefined")
			{
			    wpf_event_bus.fire(this.processCancelEventName, { inlineEditState: state });
  			    this.continueAutoCancel = !state.continueAutoCancel;
			}
		},
		
		/////////////////////////
	    // Gets the element that contains a value attribute
		///////////////////// ////
		getInputElement: function()
		{
		   var inputs = dojo.query(this.inputQuery, this.srcNodeRef);
		   
		   if(inputs.length > 0)
		       return inputs[inputs.length - 1];
		   
		   return null;
		},
		
		/////////////////////////
	    // Gets the element that contains a value attribute visible  
		/////////////////////////
		getVisibleInputElement: function()
		{
		   var inputs = dojo.query(this.inputQuery, this.srcNodeRef);
		   
		   if(inputs.length > 0)
		       return inputs[0];
		   
		   return null;
		},
		
		
		/////////////////////////
	    // Gets the value used for display purposes 
		// Note - This implementation changes based on edit type
		/////////////////////////
		getDisplayValue: function()
		{
			var inputs = dojo.query(this.inputQuery, this.srcNodeRef);

			if(inputs && inputs.length > 0)
				return inputs[inputs.length - 1].value;

			return null;
		},
		
		
		// Gets the value used for display purposes for a Select editor 
		getSelectDisplayValue: function()
		{
			var inputs = dojo.query('select', this.srcNodeRef);
			if(inputs && inputs.length > 0)
				return inputs[0].options[inputs[0].selectedIndex].innerHTML;

			return null;
		},
		
		// Gets the value used for display purposes for a Dojo Select editor 
		getDojoSelectDisplayValue: function()
		{
			var inputs = dojo.query(this.inputQuery, this.srcNodeRef);
			if(inputs && inputs.length > 0)
					return inputs[0].value;

			return null;
		},
		
		// Gets the value used for display purposes for a Radio Button editor 
		getRadioDisplayValue: function()
		{
			var inputs = dojo.query(this.inputQuery, this.srcNodeRef);

			if(inputs && inputs.length > 0)
			{
				for (var i = 0; i < inputs.length; i++) {
					if(inputs[i].checked)
					{
						// use the label for the display value if available 
						var labels = dojo.query('label', inputs[i].parentNode);

						if(labels && labels.length > 0)
							return labels[0].innerHTML;

						return inputs[i].value;
					}
				}
			}

			return null;
		},
		
		
		// Gets the value used for display purposes for a Dojo Rich Text editor 
		getRichTextDisplayValue: function()
		{
			var inputs = dojo.query(this.inputQuery, this.srcNodeRef);
			if(inputs && inputs.length > 0)
					return inputs[0].value;

			return null;
		},
		
		
		// Used to get the original value prior to editing
		// Note - This implementation changes based on edit type
		getOriginalValue: function()
		{
			var inputs = dojo.query(this.inputQuery, this.srcNodeRef);
			
			if(inputs && inputs.length > 0)
				return inputs[0].value;

			return null;
		},
		
		
		// Used to get the original value prior to editing
		getRadioOriginalValue: function()
		{
			var inputs = dojo.query(this.inputQuery, this.srcNodeRef);
			
			for (var i = 0; i < inputs.length; i++) {
				if(inputs[i].checked)
					return inputs[i].value;  
			}
			return null;
		},
		
		// Used to get the original value prior to editing
		getDojoSelectOriginalValue: function()
		{
			var inputs = dojo.query(this.inputQuery, this.srcNodeRef);
			
			// find the widget and set its value
			var widget = dijit.byId(inputs[0].getAttribute("id"));
			if(widget)
				return widget.attr('value');
			
			return null;
		},
		
		
		// Used to get the original value prior to editing
		getDojoCheckboxOriginalValue: function()
		{
			var inputs = dojo.query(this.inputQuery, this.srcNodeRef);
			
			// find the widget and set its value
			var widget = dijit.byId(inputs[0].getAttribute("id"));
			if(widget)
				return widget.attr('checked');
			
			return null;
		},
		
		
		/////////////////////////
	    // Set the value in the input. 
		// Note - This implementation changes based on edit type
		/////////////////////////
		setInputValue: function(value)
		{
			var inputs = dojo.query(this.inputQuery, this.srcNodeRef);

			// default processing
			for(var x = 0;x< inputs.length;x++)
			{
				inputs[x].value = value;
			}
		},

		
		// Set the value in the input for a Dojo Checkbox
		setDojoCheckBoxInputValue: function(value)
		{
			var inputs = dojo.query(this.inputQuery, this.srcNodeRef);
			if(inputs.length > 0)
			{
				// find the widget and set its value
				var widget = dijit.byId(inputs[0].getAttribute("id"));
				if(widget)
					widget.attr('checked', this.originalValue);
				
				inputs[1].value = value;
				
			}
		},
		
		// Set the value in the input for a Dojo Checkbox
		setCheckBoxInputValue: function(value)
		{
			var inputs = dojo.query(this.inputQuery, this.srcNodeRef);
			if(inputs.length > 0)
				   inputs[0].checked = value;
		},
		
		
		// Set the input value for a Select
		setSelectInputValue: function(value)
		{
			var inputs = dojo.query(this.inputQuery, this.srcNodeRef);

			if(inputs.length > 0)
			{
				// select the option for the specified display value
				var inputs = dojo.query('select', this.srcNodeRef);
				for (var i = 0; i < inputs[0].options.length; i++) {
					if(inputs[0].options[i].innerHTML == value)
					{
						inputs[0].selectedIndex = i;
						return;
					}
				}
			}  
		},
		
		// Set the input value for a Dojo Select
		setDojoSelectInputValue: function(value)
		{
			var inputs = dojo.query(this.inputQuery, this.srcNodeRef);

			if(inputs.length > 0)
			{
				// find the widget and set its value
				var widget = dijit.byId(inputs[0].getAttribute("id"));
				if(widget)
					widget.attr('displayedValue', value); 
			}  
		},
		
		// Set the value in the input for a Dojo RichText
		setRichTextInputValue: function(value)
		{
			var body = this.getIframeBody();
			body.innerHTML = value;
		},
		
		
		// Set the input value for a Radio Button
		setRadioInputValue: function(value)
		{
			var inputs = dojo.query(this.inputQuery, this.srcNodeRef);

			if(inputs.length > 0)
			{
				// check the value that matches
				for (var i = 0; i < inputs.length; i++) {
					inputs[i].checked = inputs[i].value == this.originalValue;

				}
			}  
		},
		
        // Gets the originalTarget from an event
		getOriginalTarget: function(e)
		{
			if(e == undefined)
				return null;
			else if(e.originalTarget)
				return e.originalTarget;
			else
				return e.srcElement;
		},
		
		
        // Gets body element of the iframe on the rich text editor
		getIframeBody: function(e)
		{
		  var iframe = dojo.query("iframe", this.srcNodeRef);
		  if(iframe.length > 0)
		  {
			  var body = null;
			  if(iframe[0].contentDocument)
				  body = iframe[0].contentDocument.body;
			  else
				  body = iframe[0].document.body;
			  
			  return body;
		  }
		
		},
		
		/////////////////////////
	    // Gets the specified template element
		/////////////////////////
		getElement: function(name)
		{
		   var elements = dojo.query("[inline_edit_id='" + name + "']", this.srcNodeRef);
		   if(elements.length == 1)
		       return elements[0];
		}
	}
);

