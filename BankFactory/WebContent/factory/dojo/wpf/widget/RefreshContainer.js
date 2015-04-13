/* Licensed Materials Property of IBM 5724-O03
Copyright IBM Corp. 2013
US Government Users Restricted Rights - Use duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp
See Web Experience Factory license for terms and conditions of use*/
dojo.provide("wpf.widget.RefreshContainer");
dojo.require("dojox.layout.ContentPane");
dojo.require("dijit.DialogUnderlay");
dojo.declare("wpf.widget.RefreshContainer",dojox.layout.ContentPane,{originalGetChildren:null,getEmptyChildren:function(){
return [];
},destroyDescendants:function(){
var _1=this.getDescendants();
this.doCleanup(this.getChildren());
this.originalGetChildren=this.getChildren;
this.getChildren=this.getEmptyChildren;
try{
this.inherited(arguments);
}
catch(ex){
}
finally{
this.getChildren=this.originalGetChildren;
}
this.doCleanup(_1);
},doCleanup:function(_2){
try{
if(_2){
dojo.forEach(_2,function(_3){
if(_3.destroyRecursive&&_3._destroyed!=true){
if(dijit._MasterTooltip&&(_3 instanceof dijit._MasterTooltip)){
return;
}
if(dijit.DialogUnderlay&&(_3 instanceof dijit.DialogUnderlay)){
return;
}
_3.destroyRecursive();
}
});
}
}
catch(ex){
}
},wasResizeCalled:function(){
return this._resizeCalled;
}});

