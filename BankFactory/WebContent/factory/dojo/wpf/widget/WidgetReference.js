/* Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2010. IBM Corp.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 */
dojo.provide("wpf.widget.WidgetReference");

dojo.require("dijit._Widget");

// Hidden widget used to destroy specified widget reference if necessary when this widget is destroyed
// Used by Dialog where the dialog is moved from its original location to the body element
dojo.declare("wpf.widget.WidgetReference", dijit._Widget, {
  widget_ref: "", // the id of the widget to destroy
  destroy: function(/*Boolean*/ preserveDom){
    try{
      // destroy the referenced widget if it's not already been destroyed.
      if(this.widget_ref){
        var widget=dijit.byId(this.widget_ref);
        if(widget && widget._destroyed != true){
          widget.destroyRecursive();
        }
      }
    } catch (ex){}
    this.inherited(arguments);
  }
});