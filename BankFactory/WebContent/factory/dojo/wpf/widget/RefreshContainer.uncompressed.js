/* Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright IBM Corp. 2010,2012
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 */
dojo.provide("wpf.widget.RefreshContainer");

dojo.require("dojox.layout.ContentPane");
dojo.require("dijit.DialogUnderlay");

dojo.declare("wpf.widget.RefreshContainer", dojox.layout.ContentPane, {
  originalGetChildren: null,
  // return empty child array, so the real destroyDescendants() doesn't do actual work
  getEmptyChildren: function(){
    return [];
  },
  destroyDescendants: function(){
    // save a copy of descendants before destroying children.
    var descendants = this.getDescendants();
    // first safely destroy children
    this.doCleanup(this.getChildren());
    // force an empty child list before calling super.destroyDescendants(), since we already did a safe destroy
    this.originalGetChildren = this.getChildren;
    this.getChildren = this.getEmptyChildren;
    try{
      this.inherited(arguments); // call the super destroyDescendants
    }catch(ex){}
    finally{
      this.getChildren = this.originalGetChildren;
    }
    this.doCleanup(descendants); // now clean up any orphan descendants (e.g tooltip/content pane)
  },
  // destroy widgets if they have not already been destroyed
  doCleanup: function(widgets){
    try{
      if(widgets){
        dojo.forEach(widgets, function(widget){
          // don't do work if already destroyed
          if(widget.destroyRecursive && widget._destroyed != true){
            // skip any global (body) widgets... 
            if(dijit._MasterTooltip && (widget instanceof dijit._MasterTooltip))
              return;
            if(dijit.DialogUnderlay && (widget instanceof dijit.DialogUnderlay))
              return;
            widget.destroyRecursive();
          }
        });
      }
    } catch(ex) {}
  },
  wasResizeCalled: function(){
    return this._resizeCalled;
  }
});
