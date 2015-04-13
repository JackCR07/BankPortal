/* Licensed Materials - Property of IBM 
 * 5724-O03
 * Copyright 2009. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use. 
 */
dojo.provide("wpf.widget.EnhancedTable");

dojo.require("dojo.DeferredList");
dojo.require("dojo.dnd.Source");
dojo.require("dojo.dnd.Moveable");
dojo.require("dijit._Widget");
dojo.require("dijit._Container");

dojo.declare(
	"wpf.widget.EnhancedTable",
	[dijit._Widget, dijit._Container],
	{
		// debug enabled flag
		debugEnabled: false,
		// Holds the current cell being resized
		resizeTarget: null,
		// Temporary div used by dojo.dnd.Moveable for resizing the columns
		resizeDiv: null,
		// the dojo.dnd.Moveable used for resizing the columns
		dndMoveable: null,
		// the dojo.dnd.Source used for drag/drop column reordering
		dndSource: null,
		// The client side event prefix
		attrEventPrefix: null,
		// The name of the builder call
		attrBuilderName: null,
		// flag indicating if click events are enabled
		attrFireRowClick: null,
		// flag indicating if double click events are enabled
		attrFireRowDoubleClick: null,
		// time interval for double click events
		attrDoubleClickTime: null,

		/////////////////////////
		// Perform some setup work for the widget here in postCreate.
		/////////////////////////
		postCreate: function()
		{
			this.debugEnabled = (dojo.attr(this.domNode, "EnhancedTableModifierDebug") == "true");
			this.debug("Dojo version: " + dojo.version);
			if (dojo.version.major < 1) {
				this.debug("Unsupported Dojo version: " + dojo.version);
				return;
			} else if (dojo.version.major == 1) {
				if (dojo.version.minor < 3) {
					this.debug("Unsupported Dojo version: " + dojo.version);
					return;
				} else if (dojo.version.minor == 3) {
					if (dojo.version.patch < 2) {
						this.debug("Unsupported Dojo version: " + dojo.version);
						return;
					}
				}
			}
			// Obtain the eventPrefix and builderName values from the markup
			this.attrEventPrefix = dojo.attr(this.domNode, "eventPrefix");
			this.attrBuilderName = dojo.attr(this.domNode, "builderName");
			this.attrFireRowClick = (dojo.attr(this.domNode, "fireRowClick") == "true");
			this.attrFireRowDoubleClick = (dojo.attr(this.domNode, "fireRowDoubleClick") == "true");
			this.attrDoubleClickTime = dojo.attr(this.domNode, "doubleClickTime");
			var allowResize = (dojo.attr(this.domNode, "allowResize") == "true");
			var allowReorder = (dojo.attr(this.domNode, "allowReorder") == "true");

			// Find the <tr> elements for the <table>
			var trs = this.domNode.rows;
			if (allowReorder) {
				// loop through all the <th> and add the dojoDndItem to their "class"
				// this must be done before creating the dojo.dnd.Source
				var ths = trs[0].cells;
				for (var i = 0; i < ths.length; i++) {
					dojo.addClass(ths[i], "dojoDndItem");
				}
				// make the table header a DnD source and target
				var sourceParams = {copyOnly: true, horizontal: true};
				this.dndSource = new dojo.dnd.Source(trs[0], sourceParams);
				// Take over the onDndDrop function of the DnD Source.
				this.dndSource.onDndDrop = dojo.hitch(this, "onDndDrop");
			}
			if (allowResize) {
				// Connect some mouse events for column width resizing of header columns
				this.connect(trs[0], "mousemove", "mouseOver");
				this.connect(trs[0], "mousedown", "mouseDown");
				this.connect(trs[0], "mouseout", "mouseOut");
			}
			// Connect events for row click/double click
			for (var i = 1; i < trs.length; i++) {
				if (this.attrFireRowClick) {
					// If we're also firing double click events, we need to use a timer otherwise we can directly call rowClick
					if (this.attrFireRowDoubleClick)
						this.connect(trs[i], "click", "startRowClick");
					else
						this.connect(trs[i], "click", "rowClick");
				}
				if (this.attrFireRowDoubleClick)
					this.connect(trs[i], "dblclick", "rowDblClick");
			}
		},

		// cleanup widgets that are under enhanced table. required by smart refresh
		destroyDescendants: function(preserveDom) {
			dojo.forEach(this.getDescendants(), function(widget) {
				// don't do work if already destroyed
				if (widget.destroyRecursive && widget._destroyed != true) {
					widget.destroyRecursive(preserveDom);
				}
			});
			this.inherited(arguments);
		},

		// cleanup this widget
		destroy: function(preserveDom) {
			if (this.dndSource != null) {
				try {
					this.dndSource.destroy();
				} catch (ex) {
				}
			}	
			// invoke the super class destroy (if any)
			this.inherited(arguments);
		},

		/////////////////////////
		// Helper debug function
		/////////////////////////
		debug: function(s) {
			if (this.debugEnabled) {
				console.log(s);
			}
		},

		/////////////////////////
		// Handles a click action within a table row
		/////////////////////////
		startRowClick: function(e) {
			this.debug("startRowClick: " + this.getRowOrdinal(e.target));
			// Check to make sure we don't already have an active click timer
			if (e.target.clickTimer == null) {
				// Start a timer for the actual click action so we can cancel it if we quickly receive a double click event
				e.target.clickTimer = setTimeout(dojo.hitch(this, "rowClick", e), this.attrDoubleClickTime);
			}
		},

		/////////////////////////
		// Performs the actual click action within a table row
		/////////////////////////
		rowClick: function(e) {
			// Clear the click timer since we're executing the click action now
			e.target.clickTimer = null;
			// Get the row ordinal of the click
			var ordinal = this.getRowOrdinal(e.target);
			this.debug("rowClick: " + ordinal);
			// Fire the WPF client event and pass the row ordinal
			wpf_event_bus.fire(this.attrEventPrefix + this.attrBuilderName + "OnRowClick", {ordinal: ordinal});
		},

		/////////////////////////
		// Handles a double click action within a table row
		/////////////////////////
		rowDblClick: function(e) {
			// Check for a click timer waiting to execute a single click action
			if (e.target.clickTimer != null) {
				this.debug("rowDblClick cleared timer: " + e.target.clickTimer);
				// Clear the click timer to cancel the single click event
				clearTimeout(e.target.clickTimer);
				e.target.clickTimer = null;
			}
			// Get the row ordinal of the double click
			var ordinal = this.getRowOrdinal(e.target);
			this.debug("rowDblClick: " + ordinal);
			// Fire the WPF client event and pass the row ordinal
			wpf_event_bus.fire(this.attrEventPrefix + this.attrBuilderName + "OnRowDblClick", {ordinal: ordinal});
		},

		/////////////////////////
		// Returns the row ordinal of the provided element
		/////////////////////////
		getRowOrdinal: function(target) {
			var ord = -1;
			// Loop over the rows of the table
			var trs = this.domNode.rows;
			for (var i = 1; (ord == -1) && (i < trs.length); i++) {
				var node = target;
				// Starting with the provided target, walk up the DOM until we get to the root DOM node
				while ((ord == -1) && (node != this.domNode)) {
					// Check the current node to see if it's one of our table's TR tags
					if (trs[i] == node) {
						ord = i;
					}
					node = node.parentNode;
				}
			}
			return ord;
		},

		/////////////////////////
		// Returns the column index of the provided element
		/////////////////////////
		getColumnIndex: function(column) {
			var idx = -1;
			// Loop over the header cells of the table
			var trs = this.domNode.rows;
			var tds = trs[0].cells;
			for (var i = 0; (idx == -1) && (i < tds.length); i++) {
				// Compare the provided column to the cell
				if (tds[i] == column) {
					idx = i;
				}
			}
			return idx;
		},

		/////////////////////////
		// Returns the actual width of the provided element excluding any padding and borders
		/////////////////////////
		getWidth: function(target) {
			// Get the widths of the left/right padding
			var leftPadding = dojo.style(target, "paddingLeft");
			var rightPadding = dojo.style(target, "paddingRight");
			// Get the widths of the left/right borders
			var leftBorder = dojo.style(target, "borderLeftWidth");
			var rightBorder = dojo.style(target, "borderRightWidth");
			// Return the offsetWidth of the target excluding the padding and borders
			return target.offsetWidth - (leftPadding + rightPadding + leftBorder + rightBorder);
		},

		/////////////////////////
		// Start resizing the header column
		/////////////////////////
		startColumnResize: function(e) {
			// Cancel the drag and drop action which may also fire as the resize begins
			if (this.dndSource != null) {
				this.dndSource.onDndCancel();
			}
			// Save the current column header being resized
			this.resizeTarget = e.target;
			// Get the initial width of the column
			var initialWidth = this.getWidth(this.resizeTarget);
			this.debug("startColumnResize: width: " + initialWidth);
			// Create a <div> to track the resize
			this.resizeDiv = document.createElement("div");
			dojo.style(this.resizeDiv, {position: "absolute", left: 0});
			// Make the resizeDiv the same width as the current column
			dojo.style(this.resizeDiv, {width: initialWidth + "px"});
			dojo.body().appendChild(this.resizeDiv);
			// Create a new dojo.dnd.Moveable to handle the resize
			this.dndMoveable = new dojo.dnd.Moveable(this.resizeDiv);
			// Connect our resizeColumn function to the onMove of the Moveable
			this.dndMoveable.onMove = dojo.hitch(this, "resizeColumn", e);
			// Connect our onMoveStop to the onMoveStop of the Moveable
			this.connect(this.dndMoveable, "onMoveStop", "onMoveStop");
			// Call the Moveable's onMouseDown to begin the move
			this.dndMoveable.onMouseDown(e);
		},

		/////////////////////////
		// Called when the resize has stopped so we can save the changes and cleanup the temporary objects
		/////////////////////////
		onMoveStop: function(e , obj, arg) {
			this.debug("onMoveStop");
			// Get the new width of the column
			var newWidth = this.getWidth(this.resizeTarget);
			this.debug("onMoveStop new width: " + newWidth);
			// Get the dojocolumnid attribute for the column
			var dojocolumnid = dojo.attr(this.resizeTarget, "dojocolumnid");
			// Create a Deferred to invoke the save operation when the update is complete
			var d = new dojo.Deferred();
			// Update the width attribute of the column in the data store
			this.updateStoreItem(dojocolumnid, "width", newWidth, d);
			this.debug("back from updateStoreItem!");
			// Add a callback to the Deferred to invoke the save operation
			d.addCallback(dojo.hitch(this, "saveStoreCallback"));
			// Cleanup the resizeDiv temporary object
			this.cleanupElement(this.resizeDiv);
			// Cleanup the dndMoveable temporary object
			this.dndMoveable = null;
		},

		/////////////////////////
		// resize the column by setting its width style
		/////////////////////////
		resizeColumn: function(e , obj, arg) {
			// Calculate the new width for the column using the original width (saved in the resizeDiv) and the delta (arg.l)
			dojo.style(e.target, {width: this.resizeDiv.offsetWidth + arg.l + "px"});
			
			this.debug("resizeColumn(" + this.getColumnIndex(e.target) + "): width: " + (this.resizeDiv.offsetWidth + arg.l) + "<br/>delta: " + arg.l);
		},

		/////////////////////////
		// Checks if we are over the resize area of header cell (i.e. the edge)
		/////////////////////////
		overResizeArea: function(e)
		{
			// Only respond to a resize if the object under the mouse is a TH
			if (e.target.nodeName.toUpperCase() == "TH") {
				// Determine if the mouse is close to the right edge of the TH
				var rect = e.target.getBoundingClientRect();
				return ((e.clientX - rect.left) > (e.target.offsetWidth - 7));
			} else {
				return false;
			}
		},

		/////////////////////////
		// Handler for mouse down over table header area
		/////////////////////////
		mouseDown: function(e)
		{
			if (this.overResizeArea(e))
			{
				this.startColumnResize(e);
				return true;
			}
		},

		/////////////////////////
		// Handler for mouse over table header area so we can display the resize cursor when over the correct location
		/////////////////////////
		mouseOver: function(e)
		{
			if (this.overResizeArea(e))
				dojo.addClass(e.target, "wpfTableColumnResizing");
			else
				dojo.removeClass(e.target, "wpfTableColumnResizing");
		},

		/////////////////////////
		// Handler for mouse out of table header area
		/////////////////////////
		mouseOut: function(e)
		{
			if (this.overResizeArea(e))
				dojo.removeClass(e.target, "wpfTableColumnResizing");
		},

		/////////////////////////
		// Take over the onDndDrop function of the Source.
		// This is used to Drop the columns to a new location
		/////////////////////////
		onDndDrop: function(source, nodes, copy, target) {	
			this.debug("onDndDrop invoked...");
			if (source == target)
			{
				var current = target.current;
				var children = source.node.children;
				// find the index for the column being moved, and the target
				var sourceIndex = 0;
				var targetIndex = 0;
				for (var i = 0; i < children.length; i++) {
					if (nodes[0].id == children[i].id)
						sourceIndex = i;
					
					if (current.id == children[i].id)
						targetIndex = i;
				}
				// see if we should move the column before or after the target
				var location = source.before ? "before":"after";
				// get all the <tr> elements. Use the source node because after a smart refresh this.domNode is null.
				var table = source.node.parentNode;
				if (table.nodeName.toUpperCase() == "THEAD" || table.nodeName.toUpperCase() == "TBODY") {
					table = table.parentNode;
				}
				var trs = table.rows; 
				// move the <td> elements for each row of data
				for (var i = 0; i < trs.length; i++) {
					var tds = trs[i].cells;
					// skip any spacer rows
					if (tds.length > 1)
						dojo.place(tds[sourceIndex], tds[targetIndex], location);
				}
				// Determine the indices of the affected columns
				var startIndex;
				var endIndex;
				this.debug("sourceIndex: " + sourceIndex);
				this.debug("targetIndex: " + targetIndex);
				this.debug("before?: " + source.before);
				// See if we're moving a column to the right or left
				if (sourceIndex < targetIndex) {
					// We're moving a column to the right
					// Start at the sourceIndex
					startIndex = sourceIndex;
					// End at the targetIndex (-1 if we're dropping it before the targetIndex)
					endIndex = source.before ? targetIndex-1:targetIndex;
				} else {
					// We're moving a column to the left
					// Start at the targetIndex (+1 if we're dropping it after the target)
					startIndex = source.before ? targetIndex:targetIndex+1;
					// End at the sourceIndex
					endIndex = sourceIndex;
				}
				this.debug("startIndex: " + startIndex);
				this.debug("endIndex: " + endIndex);
				// We only need to do something if a column actually moved
				if (startIndex < endIndex) {
					// Create an array to hold a list of Deferreds
					var deferreds = new Array();
					// Loop over the affected columns
					var tds = trs[0].cells;
					for (var i = startIndex; i <= endIndex; i++) {
						this.debug("idx: " + i);
						// Get the dojocolumnid attribute of the column
						var dojocolumnid = dojo.attr(tds[i], "dojocolumnid");
						// Add a Deferred to the list of Deferreds so we get notified when this update is complete
						deferreds[i-startIndex] = new dojo.Deferred();
						// Update the position attribute of the column in the data store
						this.updateStoreItem(dojocolumnid, "position", i, deferreds[i-startIndex]);
					}
					// Create a new DeferredList to wait for all updates to complete
					var dl = new dojo.DeferredList(deferreds);
					// Add a callback to the DeferredList to invoke the save operation after all updates are complete
					dl.addCallback(dojo.hitch(this, "saveStoreCallback"));
				}
			}
			source.onDndCancel();
			this.debug("onDndDrop complete!");
		},

		/////////////////////////
		// Utility function to cleanup elements
		/////////////////////////
		cleanupElement: function(element) {
			// Remove the element from its parent
			this.debug("cleanupElement invoked...");
			dojo.destroy(element);
			delete element;
			element = null;
			this.debug("cleanupElement complete!");
		},

		/////////////////////////
		// Utility function to update the attribute of an item in the data store
		// if a deferred object is not provided, a synchronous save is done
		// if a deferred object is provided, a save is not done and the deferred is notified after the update is complete
		/////////////////////////
		updateStoreItem: function(id, attribute, value, deferred) {
			this.debug("updateStoreItem id = [" + id + "] attribute = [" + attribute + "] value = [" + value + "]");
			// Locate the data store
			var store = dojo.getObject(this.attrBuilderName + "ColumnMetadataStore");
			// Create a reference to our debug function to invoke from the callbacks
			var debugfn = dojo.hitch(this, "debug");
			function onItem(item, request) {
				debugfn("onItem: " + store.isItem(item));
				debugfn("onItem setValue: " + value);
				store.setValue(item, attribute, value);
				debugfn("onItem setValue complete!");
				if (deferred != null) {
					debugfn("onItem notifying callback...");
					deferred.callback(true);
					debugfn("onItem callback notify complete!");
				} else {
					debugfn("onItem save...");
					store.save();
					debugfn("onItem save complete!");
				}
			}
			function onError(error, request) {
				debugfn("onError: " + error);
				debugfn("onError nofitying callback...");
				deferred.errback(error);
				debugfn("onError callback notify complete!");
			}
			store.fetchItemByIdentity({identity: id, onItem: onItem, onError: onError});
			this.debug("updateStoreItem complete!");
		},

		/////////////////////////
		// Utility function to save any changes in the data store
		/////////////////////////
		saveStore: function() {
			this.debug("saveStore invoked...");
			// Locate the data store
			var store = dojo.getObject(this.attrBuilderName + "ColumnMetadataStore");
			// Invoke its save method
			store.save();
			this.debug("saveStore complete!");
		},

		/////////////////////////
		// Utility callback function to save changes in the data store
		/////////////////////////
		saveStoreCallback: function(result) {
			this.debug("saveStoreCallback invoked...");
			// Call our saveStore function
			this.saveStore();
			this.debug("saveStoreCallback complete!");
			// To be a proper callback this must chain the result to any other callbacks
			return result;
		}
	}
);
