/* Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright IBM Corp. 2011,2012,2013
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory (product id 5724-O03) product license for terms and conditions of use
 */
dojo.declare("com.ibm.client.WebAppAccess85201404141110",null,{pages:{},dojoParser:null,executeScripts:false,instanceID:null,serviceErrorEvent:null,pageErrorEvent:null,currentPage:null,variables:{},enableDebugLog:false,constructor:function(_1){
this.pages={};
this.variables={};
dojo.safeMixin(this,_1);
var _2=this;
dojo.forEach(this.pages.getPages(),function(_3){
_3.template=_2.initializeTemplate(_3);
});
},initializeTemplate:function(_4){
if(_4==undefined||_4.remote){
return null;
}
var _5=null;
var _6=this.getTargetPage(_4);
if(_6!=undefined){
if(_6.nodeName=="SCRIPT"&&(_6.type)&&(_6.type==="text/plain")){
_5=_6.textContent;
if(_5==undefined){
_5=_6.text;
}
_5=_5.replace(/wef.hide.script/g,"script");
_5=_5.replace(/&#39;/g,"'");
var _7=document.createElement("div");
var _8=_6.attributes;
dojo.forEach(_8,function(_9){
_7.setAttribute(_9.name,_9.value);
});
_7.setAttribute("id",_6.getAttribute("id"));
_6.parentNode.insertBefore(_7,_6);
dojo.destroy(_6);
}else{
console.error("Script element not found in initializeTemplate()");
}
}
return _5;
},destroyWidgets:function(_a){
if(this.dojoParser!=null){
if(this.enableDebugLog){
this.log("destroyWidgets"+dojo.byId(_a)+" on page "+_a);
}
try{
var _b=dojo.byId(_a);
var _c=_b?dijit.findWidgets(_b):null;
var _d=this;
while(_c&&_c.length>0){
dojo.forEach(_c,function(_e){
if(_e!=undefined){
if(_d.enableDebugLog){
_d.log("about to destroy "+_e.id+" on page "+_a);
}
_e.destroyRecursive(true);
}
});
_c=dijit.findWidgets(_b);
}
var w=dijit.byId(_a);
if(w){
w.destroy();
}
}
catch(ex){
console.error("Error in  destroyWidgets "+ex);
}
}
},parseWidgets:function(_f){
if(this.dojoParser!=null){
if(this.enableDebugLog){
this.log("parseWidgets on page "+_f);
}
var _10=_f.getElementsByTagName("*");
var _11=[];
_f._type=_f.getAttribute("dojoType")||_f.getAttribute("data-dojo-type");
if(_f._type){
_11.push(_f);
}
for(var i=0,len=_10.length;i<len;i++){
_10[i]._type=_10[i].getAttribute("dojoType")||_10[i].getAttribute("data-dojo-type");
if(_10[i]._type){
_11.push(_10[i]);
}
}
this.dojoParser.instantiate(_11);
}
},hidePages:function(){
dojo.forEach(this.pages.pages,function(_12){
var _13=dojo.byId(_12.getId());
if(_13!=null){
dojo.style(_13,"display","none");
}
});
},hidePage:function(_14){
var _15=this.getPage(_14);
if(_15!=undefined){
var _16=dojo.byId(_15.getId());
if(_16!=null){
dojo.style(_16,"display","none");
}
}
},showPage:function(_17,_18,_19){
if(this.enableDebugLog){
this.log("about to show page "+_17.getName());
}
var _1a=dojo.byId(_17.getId());
if(_1a!=null){
dojo.style(_1a,"display","");
_1a.removeAttribute("disabled");
}
},log:function(_1b){
if(this.enableDebugLog){
console.log(_1b);
}
},getCurrentPage:function(){
return this.currentPage;
},callActions:function(_1c){
var _1d=new com.ibm.client.Runner85201404141110({functions:_1c,context:this});
return _1d.run();
},callServerAction:function(el,_1e){
this.progressIndicator(true);
if(this.enableDebugLog){
this.log("callServerAction called - el = ",el);
}
var _1f=this;
var _20={load:function(_21,_22){
_1f.progressIndicator(false);
if(_1f.enableDebugLog){
_1f.log("callServerAction: action returns ",_21);
}
if(_21.variables){
dojo.safeMixin(_1f.variables,_21.variables);
}
if(_21.defaultErrorPageData){
_1f.handleErrorResponse(_21,_22);
}else{
if(_21.currentPage){
if(_21.errorData){
_1f.setVariable("errorData",_21.errorData);
}
if(_21.arguments){
_1f.processMethod(_21.currentPage,_21.arguments);
}else{
_1f.processAction(_21.currentPage);
}
_1f.setVariable("errorData",null);
}
}
},error:function(_23,_24){
_1f.progressIndicator(false);
console.error("callServerAction error ",_23,"  ioArgs = ",_24);
try{
var _25=JSON.parse(_23.responseText);
if(_25.defaultErrorPageData){
_1f.handleErrorResponse(_25,_24);
}
}
catch(ignore){
}
if(wpf_event_bus&&wpf_event_bus.fire&&_1f.serviceErrorEvent!=null){
wpf_event_bus.fire(_1f.serviceErrorEvent,{error:_23});
}
return _23;
},handleAs:"json",headers:{Accept:"application/json"}};
if(typeof el==="string"){
_20.content=_1e;
_20.url=this.getServerActionURL({_wef_action:el,_wef_currpg:this.currentPage});
return dojo.xhrPost(_20);
}else{
if(el.href){
_20.url=el.href+"&_wef_currpg="+this.currentPage;
return dojo.xhrGet(_20);
}else{
if(el.tagName&&el.tagName.toLowerCase()=="form"){
el.action+="&_wef_currpg="+this.currentPage;
_20.form=el;
if(el.enctype=="multipart/form-data"){
dojo.require("dojo.io.iframe");
return dojo.io.iframe.send(_20);
}else{
return dojo.xhrPost(_20);
}
}else{
console.error("Unknown action type in callServerAction ",el,_1e);
}
}
}
},handleErrorResponse:function(_26,_27){
var _28=false;
if(_27&&_27.xhr&&_27.xhr.getResponseHeader){
if(_27.xhr.getResponseHeader("X-WEF-Session-Expired")=="true"){
_28=true;
}
}
if(_28){
this.handleExpiredSession();
}else{
this.setVariable("defaultErrorPageData",_26.defaultErrorPageData);
this.processAction("defaultErrorPage");
}
},handleExpiredSession:function(){
window.top.location.reload();
},progressIndicator:function(_29){
try{
if(_29){
if(!this.progressIndicatorLocation&&this.getCurrentPage()!=null){
var _2a=this.pages.getPage(this.getCurrentPage());
this.progressIndicatorLocation=_2a.getViewId();
if(wpf_event_bus&&wpf_event_bus.fireLocally){
wpf_event_bus.fireLocally(this.instanceID+"AjaxPreLoad",{ids:[this.progressIndicatorLocation]});
}
}
}else{
if(this.progressIndicatorLocation){
if(wpf_event_bus&&wpf_event_bus.fireLocally){
wpf_event_bus.fireLocally(this.instanceID+"AjaxPreUpdate",{ids:[this.progressIndicatorLocation]});
}
this.progressIndicatorLocation=null;
}
}
}
catch(cannotShowProgressIndicator){
console.error("progress indicator failed: ",cannotShowProgressIndicator);
}
},setVariable:function(_2b,_2c){
if(this.enableDebugLog){
this.log("setVariable "+_2b+" : "+_2c);
}
dojo.setObject("variables."+_2b,_2c,this);
},getVariable:function(_2d){
var _2e=dojo.getObject("variables."+_2d,false,this);
if(_2e==null||this.isEmptyObject(_2e)){
_2e="";
}
if(this.enableDebugLog){
this.log("getVariable "+_2d+" : "+_2e);
}
return _2e;
},isEmptyObject:function(_2f){
var _30=(typeof _2f=="object");
if(_30){
for(var _31 in _2f){
if(_2f.hasOwnProperty(_31)){
_30=false;
break;
}
}
}
return _30;
},exists:function(_32){
var _33=this.getVariable(_32);
if(_33==undefined||_33==null||_33==""){
return false;
}else{
return true;
}
},getSafeArray:function(_34){
var _35=null;
if(this.exists(_34)){
var _36=this.getVariable(_34);
if(_36 instanceof Array){
_35=_36;
}else{
_35=new Array(_36);
}
}else{
_35=new Array();
}
if(this.enableDebugLog){
this.log("getSafeArray "+_34+" : "+_35.length);
}
return _35;
},processPage:function(_37,_38,_39){
try{
this.currentPage=_37;
var _3a=this.pages.getPage(_37);
if(_38===undefined){
var _3b=this.getVariable("ClientDefaultTransitionDirection");
if(_3b===undefined||_3b===null||_3b===""){
_38="1";
}else{
_38=_3b;
}
}
if(_39===undefined){
var _3c=this.getVariable("ClientDefaultTransition");
if(_3c===undefined||_3c===null||_3c===""){
_39="slide";
}else{
_39=_3c;
}
}
if(this.enableDebugLog){
this.log("processPage "+_37);
}
if(_3a.remote&&_3a.template==null){
this.loadRemotePage(_3a,_38,_39);
}else{
this.processPageData(_3a,_38,_39);
}
}
catch(ex){
if(_37!="defaultErrorPage"){
this.handleErrorResponse({defaultErrorPageData:{errorMessage:ex.message,exceptionMessage:ex.message,stackTrace:ex.stack}});
}
if(wpf_event_bus&&wpf_event_bus.fire&&this.pageErrorEvent!=null){
wpf_event_bus.fire(this.pageErrorEvent,{error:ex});
}
console.error("ERROR processing page data "+ex);
}
},processMethod:function(_3d,_3e){
var _3f=this[_3d];
if(typeof _3f==="function"){
if(_3e){
return _3f.apply(this,_3e);
}else{
return _3f.apply(this);
}
}
},processAction:function(_40,_41,_42){
if(this.pages.pageExists(_40)){
return this.processPage(_40,_41,_42);
}else{
return this.processMethod(_40);
}
},prepare:function(t){
var _43=/\[@=(.*?)@\]/g;
var _44=/\[@(.*?)@\]/g;
t=t.replace(/<!--(.*?)-->/g,"");
t=t.replace(/[\n\r]+/g,"\\n");
t=t.replace(/\\(d)/g,"\\\\d");
t=t.replace(/"/g,"\\\"");
t=t.replace(_43,function(m,_45){
return "\" + ("+_45.replace(/\\"/g,"\"").replace(/\\n/g,"")+") + \"";
});
t=t.replace(_44,function(m,_46){
return "\"; "+_46.replace(/\\"/g,"\"").replace(/\\n/g,"")+" _out += \"";
});
t=t.replace(/webAppAccess/g,this.instanceID);
t="var _out = \""+t+"\"; return _out";
var _47="with (this) {"+t+"}";
try{
return new Function(_47);
}
catch(compileError){
console.error("Error: prepare template - "+compileError);
if(this.enableDebugLog){
this.log("Template: "+_47);
}
}
},loadRemotePage:function(_48,_49,_4a){
var _4b=dojo.xhrGet({url:_48.remoteURL});
var _4c=new dojo.DeferredList([_4b]);
var _4d=this;
_4c.addCallback(function(_4e){
var _4f=_4e[0][1];
_4f=_4f.replace(/&gt;/g,">");
_4f=_4f.replace(/&lt;/g,"<");
_4f=_4f.replace(/&#39;/g,"'");
_48.template=_4f;
if(_4d.enableDebugLog){
_4d.log("Loaded remote page "+_48.remoteURL);
}
_4d.processPageData(_48,_49,_4a);
});
},getServerActionURL:function(_50){
var url=this.dispatcherURL;
var sep=url.indexOf("?")<0?"?":"&";
for(p in _50){
url+=sep+p+"="+_50[p];
sep="&";
}
return url;
},getText:function(_51){
var _52=this.getVariable(_51).toString();
_52=_52.replace(/</g,"&#x3C;");
_52=_52.replace(/>/g,"&#x3E;");
return _52;
},getMessage:function(_53){
var _54=this.getVariable(_53);
if(_54==undefined){
_54="";
}
return _54;
},getIsInvalidString:function(_55){
if(this.exists(_55)){
message="true";
}else{
message="false";
}
return message;
},getCheckedName:function(_56,_57){
var _58=this.getVariable(_56);
var _59="_bst_unchecked";
if(_58!=null&&_58==_57){
_59="checked";
}
return _59;
},getCheckedAttribute:function(_5a,_5b){
var _5c=this.getVariable(_5a);
var _5d="false";
if(_5c!=null&&_5c==_5b){
_5d="true";
}
return _5d;
},getSelected:function(_5e,_5f){
var _60=this.getVariable(_5e);
var _61="";
if(_60!=null&&_60==_5f){
_61="selected";
}
return _61;
},getLookupLabel:function(_62,_63,_64,_65){
var _66=this.getVariable(_63);
if(_62==null||_62==""||_66==null){
return "";
}
var _67=this.findArray(_66);
if(_67!=null){
for(var i=0;i<_67.length;i++){
if(_67[i][_64]==_62){
var _68=_67[i][_65];
if(_68.content==undefined){
return _68;
}else{
return _68.content;
}
}
}
}
return _62;
},findArray:function(_69){
for(var _6a in _69){
var _6b=_69[_6a];
if(dojo.isArray(_6b)){
return _6b;
}else{
if(dojo.isObject(_6b)){
var _6c=this.findArray(_6b);
if(_6c){
return _6c;
}
}
}
}
return null;
},formatDate:function(_6d,_6e,_6f){
var _70=this.getVariable(_6d);
if(_70!=null&&_70.length>0){
var _71=dojo.date.locale.parse(_70,{datePattern:_6e,selector:"date"});
if(_71){
_70=dojo.date.locale.format(_71,{datePattern:_6f,selector:"date"});
}
}
return _70;
},formatNumber:function(_72,_73){
var _74=this.getVariable(_72);
if(_74!=null&&_74.length>0){
var _75=dojo.number.parse(_74);
_74=dojo.number.format(_75,{pattern:_73});
}
return _74;
},getTargetPage:function(_76){
return dojo.byId(_76.getId());
},getNewTargetPage:function(_77,_78){
return _78;
},processPageData:function(_79,_7a,_7b){
if(_79.context==undefined){
_79.context=this.prepare(_79.template);
}
this.hidePages();
var _7c=this.getTargetPage(_79);
this.destroyWidgets(_79.getViewId());
var _7d=_79.context.apply(this);
dojox.html.set(_7c,_7d,{executeScripts:this.executeScripts,scriptHasHooks:false,renderStyles:true});
_7c=this.getNewTargetPage(_79,_7c);
this.parseWidgets(_7c);
this.showPage(_79,_7a,_7b);
this.trackActivation(_79);
},trackActivation:function(_7e){
var _7f=this;
var _80=dojo.byId(_7e.getViewId());
dojo.forEach(_80.getElementsByTagName("form"),function(f){
function _81(el){
_7f.setCurrentPageAndForm(_7e.name,f);
};
dojo.forEach(f.elements,function(el){
dojo.connect(el,"onfocus",_81);
});
dojo.forEach(f.getElementsByTagName("a"),function(el){
dojo.connect(el,"onfocus",_81);
});
var _82=f.onsubmit;
f.onsubmit=function(_83){
if(!_82||_82()){
_7f.callServerAction(f);
}
return false;
};
});
},setCurrentPageAndForm:function(_84,el){
if(this.currentPage!=_84){
if(this.enableDebugLog){
this.log("setting current page to "+_84);
}
}
this.currentPage=_84;
var _85=null;
while(el&&!_85){
if(el.tagName.toLowerCase()=="form"){
_85=el;
}else{
if(el.form){
_85=el.form;
}else{
el=el.parentNode;
}
}
}
if(_85){
if(_85!=this.currentForm){
if(this.enableDebugLog){
console.debug("setting current form to ",_85);
}
}
this.currentForm=_85;
}
},getIsNullOrFalseForCompare:function(_86){
var _87=true;
if(_86!=null&&_86!=undefined&&_86!=""){
if(typeof _86=="boolean"){
_87=!_86;
}else{
if(typeof _86=="string"){
_87=_86.toLowerCase()=="false";
}else{
if(typeof _86=="number"){
_87=isNaN(_86);
}else{
_87=false;
}
}
}
}
return _87;
},getStringValueForCompare:function(_88){
var _89=_88;
if(typeof _89!="string"){
_89=String(_89);
}
return _89;
},getCaseInsensitiveStringValueForCompare:function(_8a){
return this.getStringValueForCompare(_8a).toLowerCase();
},getNumberValueForCompare:function(_8b){
var _8c=_8b;
if(typeof _8c!="number"){
_8c=Number(_8c);
}
return _8c;
},hideWhenFalse:function(_8d){
var _8e=false;
if(typeof _8d=="boolean"){
_8e=!_8d;
}else{
if(typeof _8d=="string"){
_8e=(_8d==="false")||(_8d==="hide");
}
}
return this.getStyleDisplayValue(_8e);
},hideWhenEqual:function(_8f,_90){
var _91=(_8f==_90);
return this.getStyleDisplayValue(_91);
},hideWhenNotEqual:function(_92,_93){
var _94=(_92!=_93);
return this.getStyleDisplayValue(_94);
},getStyleDisplayValue:function(_95){
return _95?"display:none":"display:inherit";
},getSortImage:function(_96,_97,_98){
var _99="";
var _9a=this.getSafeArray("ClientSortMetadata.sortMetadata.collection");
if(_9a){
for(var _9b=0;_9b<_9a.length;_9b++){
if(_9a[_9b].name==_96){
if(_9a[_9b].column==_97){
_99=(_98==2)?_9a[_9b].sortedImage2:_9a[_9b].sortedImage1;
}else{
_99=(_98==2)?_9a[_9b].unsortedImage2:_9a[_9b].unsortedImage1;
}
break;
}
}
}
return _99;
}});
dojo.declare("com.ibm.client.PageNotFoundException85201404141110",null,{pageName:"",constructor:function(_9c){
dojo.safeMixin(this,_9c);
},toString:function(){
return "PageNotFoundException ["+this.pageName+"]";
}});
dojo.declare("com.ibm.client.PageInfo85201404141110",null,{name:"",id:null,wrapper:null,constructor:function(_9d){
dojo.safeMixin(this,_9d);
this.wrapper=this.id+"_wrapper";
},getId:function(){
return this.wrapper;
},getViewId:function(){
return this.wrapper;
},getName:function(){
return this.name;
}});
dojo.declare("com.ibm.client.MobilePageInfo85201404141110",com.ibm.client.PageInfo85201404141110,{inner:null,constructor:function(_9e){
this.inner=this.id;
},getViewId:function(){
return this.inner;
}});
dojo.declare("com.ibm.client.Pages85201404141110",null,{pages:[],constructor:function(_9f){
this.pages=[];
},addPage:function(_a0){
this.pages.push(_a0);
},getPage:function(_a1){
for(var i=0;i<this.pages.length;i++){
if(this.pages[i].name==_a1){
return this.pages[i];
}
}
if(this.enableDebugLog){
this.log("page not found "+_a1);
}
throw new com.ibm.client.PageNotFoundException85201404141110({pageName:_a1});
},getPages:function(){
return this.pages;
},pageExists:function(_a2){
for(var i=0;i<this.pages.length;i++){
if(this.pages[i].name==_a2){
return true;
}
}
return false;
}});
dojo.declare("com.ibm.client.Runner85201404141110",null,{functions:[],current:0,returnValue:null,callback:[],context:{},constructor:function(_a3){
this.functions=[];
this.callback=null;
this.context={};
dojo.safeMixin(this,_a3);
},run:function(){
this.current=0;
return this.next();
},next:function(_a4){
var _a5=this;
this.returnValue=_a4;
while(this.functions&&this.current<this.functions.length){
var rv=this.functions[this.current++].call(this.context);
if(rv&&rv.addCallback){
rv.addCallback(function(_a6){
_a5.next(_a6);
});
return this;
}
}
if(this.callback!=null){
var _a7=this.callback;
this.callback=null;
return _a7(_a4);
}
},addCallback:function(fn){
this.callback=fn;
}});
dojo.declare("com.ibm.client.MobileWebAppAccess85201404141110",com.ibm.client.WebAppAccess85201404141110,{hidePages:function(){
},showPage:function(_a8,_a9,_aa){
var id=_a8.getViewId();
var w=dijit.byId(id);
if(w){
var v=w.getShowingView();
if(v&&(id!=v.id)){
v.performTransition(id,_a9,_aa);
}else{
if(v&&v.resize){
v.resize();
}
}
}
},getTargetPage:function(_ab){
return dojo.byId(_ab.getId());
},getNewTargetPage:function(_ac,_ad){
var _ae=dojo.byId(_ac.getViewId());
if(_ae!=null){
_ae.setAttribute("selected","true");
_ad.parentNode.appendChild(_ae);
}else{
console.error("Could not find target page "+_ac.getViewId());
}
return _ae;
}});
