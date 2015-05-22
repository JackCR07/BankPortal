/* Licensed Materials - Property of IBM - see product id 5724-O03 license for terms and conditions of use
 * Copyright IBM Corp. 2012,2013
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 */
if(typeof wef_camera_support85201404141110==="undefined"){
var wef_camera_support85201404141110=function(_1,_2,_3){
this.isCordovaReady=false;
this.listeningForDeviceReady=false;
this.uploadState="NotStarted";
this.parameters=_1||{};
this.parameters.ThumbnailDisplayType=this.convertToThumbnailDisplayType(this.parameters.ThumbnailDisplayType,"ServerURI");
this.parameters.ChunkedMode=this.convertToBoolean(this.parameters.ChunkedMode,false);
this.parameters.UsePhotoLibrary=this.convertToBoolean(this.parameters.UsePhotoLibrary,false);
this.parameters.LogToConsole=this.convertToBoolean(this.parameters.LogToConsole,false);
this.parameters.ButtonEnableDelay=this.convertToNumber(this.parameters.ButtonEnableDelay,undefined);
this.options=_2||{};
this.strings=_3;
this.logMessage(this.strings.log_camera_created);
this.localImageUri=undefined;
this.latitude=undefined;
this.longitude=undefined;
var _4=document.readyState=="interactive";
var _5=document.readyState=="complete";
var _6=document.readyState=="loaded";
if(_4||_5||_6){
this.logMessage(this.strings.log_calling_domReady);
if(_4||_5){
this.domReady();
}else{
this.domLoaded();
}
}else{
if(document.addEventListener){
this.logMessage(this.strings.log_listen_readystatechange);
document.addEventListener("readystatechange",this.bind(this.domReady),false);
}
if(document.addEventListener){
this.logMessage(this.strings.log_listen_readystatechange);
document.addEventListener("DOMContentLoaded",this.bind(this.domLoaded),false);
}
}
};
wef_camera_support85201404141110.prototype.domReady=function(){
if(document.readyState=="interactive"){
this.listenForDeviceReady();
}else{
if(document.readyState=="complete"){
this.listenForDeviceReady();
}
}
};
wef_camera_support85201404141110.prototype.domLoaded=function(){
this.listenForDeviceReady();
};
wef_camera_support85201404141110.prototype.listenForDeviceReady=function(){
if(this.listeningForDeviceReady){
return;
}
this.listeningForDeviceReady=true;
if(document.addEventListener){
this.logMessage(this.strings.log_listen_deviceready);
document.addEventListener("deviceready",this.bind(this.cordovaReady),false);
}
};
wef_camera_support85201404141110.prototype.cordovaReady=function(){
if(this.isCordovaReady){
return;
}
this.isCordovaReady=true;
this.enableTakePictureButton();
this.options.destinationType=Camera.DestinationType.FILE_URI;
this.options.mediaType=this.convertToNumber(this.options.mediaType,Camera.MediaType.PICTURE);
this.options.encodingType=this.convertToNumber(this.options.encodingType,Camera.EncodingType.JPEG);
this.options.quality=this.convertToNumber(this.options.quality,100);
this.options.targetWidth=this.convertToNumber(this.options.targetWidth,undefined);
this.options.targetHeight=this.convertToNumber(this.options.targetHeight,undefined);
this.options.allowEdit=this.convertToBoolean(this.options.allowEdit,false);
this.options.saveToPhotoAlbum=this.convertToBoolean(this.options.saveToPhotoAlbum,false);
this.options.correctOrientation=this.convertToBoolean(this.options.correctOrientation,true);
if(this.parameters.LogToConsole){
var _7=JSON.stringify(this,function(_8,_9){
return (_8=="strings")?undefined:_9;
},4);
this.logMessage(this.replaceValue(this.strings.log_version_and_object,device.cordova,_7));
}
};
wef_camera_support85201404141110.prototype.enableTakePictureButton=function(){
var _a=document.getElementById(this.parameters.TakePictureButtonId);
if(_a){
if(_a.disabled){
if(this.parameters.ButtonEnableDelay){
var _b=currTime=new Date().getTime();
while(_b+this.parameters.ButtonEnableDelay>currTime){
currTime=new Date().getTime();
}
}
_a.disabled=false;
_a.style.opacity=1;
}
}
};
wef_camera_support85201404141110.prototype.setUsePhotoLibrary=function(_c){
this.logMessage(this.replaceValue(this.strings.log_photo_library_state,_c));
this.parameters.UsePhotoLibrary=_c;
};
wef_camera_support85201404141110.prototype.setGeolocation=function(_d){
this.latitude=_d.latitude;
this.longitude=_d.longitude;
this.logMessage(this.replaceValue(this.strings.log_set_geolocation,this.latitude,this.longitude));
};
wef_camera_support85201404141110.prototype.takePicture=function(){
if(this.isCordovaReady){
if(this.parameters.UsePhotoLibrary){
this.options.sourceType=Camera.PictureSourceType.PHOTOLIBRARY;
}else{
this.options.sourceType=Camera.PictureSourceType.CAMERA;
}
if(this.parameters.EnableGeolocation){
this.getLocation();
}
this.logMessage(this.replaceValue(this.strings.log_get_picture,JSON.stringify(this.options,null,4)));
navigator.camera.getPicture(this.bind(this.onPictureSuccess),this.bind(this.onPictureFail),this.options);
}else{
this.displayAlert(this.strings.error_no_camera);
}
};
wef_camera_support85201404141110.prototype.onPictureSuccess=function(_e){
this.logMessage(this.replaceValue(this.strings.log_on_picture_success,_e));
this.localImageUri=_e;
var _f=document.getElementById(this.parameters.ThumbnailPlaceholderId);
if(_f){
_f.style.display="none";
}else{
this.logMessage(this.replaceValue(this.strings.log_placeholder_not_found,this.parameters.ThumbnailPlaceholderId));
}
var _10=document.getElementById(this.parameters.PictureCapturedMessageSectionId);
if(_10){
_10.style.display="inline-block";
}
if(this.parameters.ThumbnailDisplayType=="ServerURI"){
this.uploadPicture();
}else{
if(this.parameters.ThumbnailDisplayType=="Base64Data"){
window.resolveLocalFileSystemURI(this.localImageUri,this.bind(this.onThumbnailEntrySuccess),this.bind(this.onThumbnailFail));
}
}
};
wef_camera_support85201404141110.prototype.getLocation=function(){
if(this.isCordovaReady){
var _11={maximumAge:600000,timeout:5000,enableHighAccuracy:true};
navigator.geolocation.getCurrentPosition(this.bind(this.onPositionSuccess),this.bind(this.onPositionFail),_11);
}
};
wef_camera_support85201404141110.prototype.onPositionSuccess=function(_12){
this.logMessage(this.replaceValue(this.strings.log_on_position_success,_12.coords.latitude,_12.coords.longitude));
this.latitude=_12.coords.latitude;
this.longitude=_12.coords.longitude;
};
wef_camera_support85201404141110.prototype.onThumbnailEntrySuccess=function(_13){
this.logMessage(this.replaceValue(this.strings.log_on_thumbnail_entry_success,_13.name));
_13.file(this.bind(this.onThumbnailFileSuccess),this.bind(this.onThumbnailFail));
};
wef_camera_support85201404141110.prototype.onThumbnailFileSuccess=function(_14){
this.logMessage(this.replaceValue(this.strings.log_on_thumbnail_file_success,_14.name));
var _15=new FileReader();
_15.onloadend=this.bind(this.onThumbnailLoadEnd);
_15.readAsDataURL(_14);
};
wef_camera_support85201404141110.prototype.onThumbnailLoadEnd=function(_16){
if(_16.target.error){
this.onThumbnailFail(_16.target.error);
}else{
if(_16.target.result){
var _17=_16.target.result;
if(_17.indexOf("data:image/jpeg;base64,")===0){
this.logMessage(this.strings.log_base64_prefix_exists);
}else{
this.logMessage(this.strings.log_base64_prefix_added);
_17="data:image/jpeg;base64,"+_17;
}
this.displayThumbnail(_17);
}else{
this.logMessage(this.strings.log_no_thumbnail_data);
}
}
};
wef_camera_support85201404141110.prototype.displayThumbnail=function(_18){
var _19=document.getElementById(this.parameters.ThumbnailId);
if(_19){
if(this.parameters.ThumbnailDisplayType=="ServerURI"){
var d=new Date();
_18+="?time="+d.getTime();
}
_19.style.display="inline-block";
_19.src=_18;
}else{
this.logMessage(this.replaceValue(this.strings.log_thumbnail_not_found,this.parameters.ThumbnailId));
}
};
wef_camera_support85201404141110.prototype.beginUploadPicture=function(_1a){
this.parameters.UploadButtonId=_1a.id;
this.logMessage(this.replaceValue(this.strings.log_begin_upload_picture,this.uploadState,this.parameters.CameraId,this.parameters.FileType));
if(this.uploadState==="InProgress"){
return null;
}else{
if(this.uploadState==="Complete"){
return true;
}else{
if(this.uploadState==="Error"){
this.uploadState="Complete";
return null;
}
}
}
if(this.uploadState!=="NotStarted"){
this.logMessage(this.replaceValue(this.strings.log_invalid_upload_state,this.uploadState));
this.uploadState="NotStarted";
return true;
}
if(!this.localImageUri){
this.logMessage(this.strings.log_no_local_image_uri);
return true;
}
if(this.isCordovaReady){
this.uploadPicture();
this.uploadState="InProgress";
return null;
}else{
this.logMessage(this.strings.log_no_cordova_camera);
return true;
}
};
wef_camera_support85201404141110.prototype.uploadPicture=function(){
if(this.isCordovaReady){
this.parameters.UploadUrl=this.forceAbsoluteUrl(this.parameters.UploadUrl,this.parameters.UploadProxy);
var now=new Date().getTime();
var _1b=this.parameters.CameraId+"_"+now;
var _1c=_1b+"."+this.parameters.FileType;
this.logMessage(this.replaceValue(this.strings.log_upload_picture,_1c,this.parameters.UploadUrl,this.parameters.UploadId));
var _1d=new FileUploadOptions();
_1d.fileKey="file";
_1d.fileName=_1c;
_1d.mimeType=this.parameters.FileType=="png"?"image/png":"image/jpeg";
_1d.httpMethod="POST";
_1d.chunkedMode=this.parameters.ChunkedMode;
var _1e=new Object();
_1e.wef_file_upload_token_file=this.parameters.UploadId;
_1e.ImageFilename=_1c;
_1e.GeneratedId=_1b;
_1e.Latitude=this.latitude;
_1e.Longitude=this.longitude;
_1d.params=_1e;
var _1f=new Object();
_1f.Accept="application/json";
if(!this.parameters.ChunkedMode){
_1f.Connection="close";
}
_1d.headers=_1f;
this.logMessage(this.replaceValue(this.strings.log_upload,this.localImageUri,this.parameters.UploadUrl,JSON.stringify(_1d)));
new FileTransfer().upload(this.localImageUri,this.parameters.UploadUrl,this.bind(this.onUploadSuccess),this.bind(this.onUploadFail),_1d);
}else{
this.logMessage(this.strings.log_no_cordova_camera);
}
};
wef_camera_support85201404141110.prototype.endUploadPicture=function(){
this.logMessage(this.replaceValue(this.strings.log_end_upload_state,this.uploadState));
this.uploadState="NotStarted";
};
wef_camera_support85201404141110.prototype.onUploadSuccess=function(_20){
this.logMessage(this.replaceValue(this.strings.log_on_upload_success,JSON.stringify(_20,null,4)));
if(_20.response===null||_20.response===""){
this.onUploadFail(new FileTransferError(10001,null,null,500,null));
return;
}
try{
_20.response=JSON.parse(_20.response);
}
catch(e){
this.logMessage(this.strings.log_json_parse_error);
this.onUploadFail(new FileTransferError(0,null,null,500,null));
return;
}
if(_20.response.instanceId){
var _21=eval(_20.response.instanceId);
if(_21&&_20.response.variables){
dojo.safeMixin(_21.variables,_20.response.variables);
this.logMessage(this.strings.log_update_client_variables);
}
}
if(this.uploadState=="InProgress"){
this.uploadState="Complete";
var _22=document.getElementById(this.parameters.UploadButtonId);
if(_22){
_22.click();
}else{
this.logMessage(this.replaceValue(this.strings.log_upload_button_not_found,this.parameters.UploadButtonId));
}
}
if(this.parameters.ThumbnailDisplayType=="ServerURI"){
this.displayThumbnail(_20.response.destinationUri);
}
};
wef_camera_support85201404141110.prototype.forceAbsoluteUrl=function(url,_23){
var _24=url;
if(url){
var _25=/^https?:\/\//i;
if(!_25.test(url)){
if(_23){
_24=_23+url;
}else{
_24=document.location.protocol+"//"+document.location.host+url;
}
}
}
return _24;
};
wef_camera_support85201404141110.prototype.convertToThumbnailDisplayType=function(_26,_27){
if((typeof _26!="string")||(_26!="ServerURI"&&_26!="Base64Data"&&_26!="NoDisplay")){
_26=_27;
}
return _26;
};
wef_camera_support85201404141110.prototype.convertToBoolean=function(_28,_29){
if((typeof _28!="boolean")){
if(typeof _28=="string"){
if(_28=="true"){
_28=true;
}else{
if(_28=="false"){
_28=false;
}else{
_28=_29;
}
}
}else{
_28=_29;
}
}
return _28;
};
wef_camera_support85201404141110.prototype.convertToNumber=function(_2a,_2b){
if((typeof _2a!="number")){
if(typeof _2a=="string"){
var _2c=parseInt(_2a,10);
if(isNaN(_2c)===false){
_2a=_2c;
}else{
_2a=_2b;
}
}else{
_2a=_2b;
}
}
return _2a;
};
wef_camera_support85201404141110.prototype.logMessage=function(_2d){
if(this.parameters.LogToConsole){
console.log(_2d);
}
};
wef_camera_support85201404141110.prototype.displayAlert=function(_2e){
if(this.isCordovaReady&&navigator.notification&&navigator.notification.alert){
navigator.notification.alert(_2e,null);
}else{
alert(_2e);
}
};
wef_camera_support85201404141110.prototype.bind=function(_2f){
if(_2f&&typeof _2f==="function"){
if(_2f.bind){
return _2f.bind(this);
}else{
var _30=this;
var fn=_2f;
var _31=function(){
return fn.apply(_30,Array.prototype.slice.call(arguments));
};
_31.prototype=_2f.prototype;
return _31;
}
}else{
return null;
}
};
wef_camera_support85201404141110.prototype.replaceValue=function(_32,_33,_34,_35,_36,_37){
var _38=_32;
if(_38&&_38.replace){
if(typeof _33!=="undefined"){
_38=_38.replace("{0}",_33);
}
if(typeof _34!=="undefined"){
_38=_38.replace("{1}",_34);
}
if(typeof _35!=="undefined"){
_38=_38.replace("{2}",_35);
}
if(typeof _36!=="undefined"){
_38=_38.replace("{3}",_36);
}
if(typeof _37!=="undefined"){
_38=_38.replace("{4}",_37);
}
}
return _38;
};
wef_camera_support85201404141110.prototype.onPositionFail=function(_39){
this.logMessage(this.replaceValue(this.strings.log_on_position_fail,_39.code,_39.message));
};
wef_camera_support85201404141110.prototype.onPictureFail=function(_3a){
this.logMessage(this.replaceValue(this.strings.log_on_picture_fail,_3a));
};
wef_camera_support85201404141110.prototype.onThumbnailFail=function(_3b){
var _3c;
switch(_3b.code){
case FileError.NOT_FOUND_ERR:
_3c=this.strings.error_thumbnail_not_found;
break;
case FileError.SECURITY_ERR:
_3c=this.strings.error_thumbnail_not_accessed;
break;
case FileError.NOT_READABLE_ERR:
_3c=this.strings.error_thumbnail_not_read;
break;
case FileError.ENCODING_ERR:
_3c=this.strings.error_thumbnail_not_encoded;
break;
default:
_3c=this.strings.error_thumbnail_not_displayed;
break;
}
this.logMessage(this.replaceValue(this.strings.log_on_thumbnail_fail,_3b.code,_3c));
this.displayAlert(_3c);
};
wef_camera_support85201404141110.prototype.extractErrorBodyJson=function(_3d){
if(_3d&&_3d[0]!="{"){
_3d=_3d.substring(_3d.indexOf("{"),_3d.lastIndexOf("}")+1);
}
return _3d;
};
wef_camera_support85201404141110.prototype.onUploadFail=function(_3e){
this.logMessage(this.replaceValue(this.strings.log_on_upload_fail,JSON.stringify(_3e,null,4)));
if(this.parameters.ThumbnailDisplayType=="ServerURI"){
this.logMessage(this.strings.log_restore_picture_controls);
this.localImageUri=undefined;
var _3f=document.getElementById(this.parameters.ThumbnailPlaceholderId);
if(_3f){
_3f.style.display="inline";
}
var _40=document.getElementById(this.parameters.ThumbnailId);
if(_40){
_40.style.display="none";
}
var _41=document.getElementById(this.parameters.PictureCapturedMessageSectionId);
if(_41){
_41.style.display="none";
}
}
if(this.uploadState=="InProgress"){
this.uploadState="Error";
var _42=document.getElementById(this.parameters.UploadButtonId);
if(_42){
this.logMessage(this.strings.log_upload_fail_click_button);
_42.click();
}else{
this.logMessage(this.replaceValue(this.strings.log_upload_failed_no_button,this.parameters.UploadButtonId));
}
}
var _43=false;
if(_3e.body){
try{
_3e.body=JSON.parse(this.extractErrorBodyJson(_3e.body));
if(_3e.body.defaultErrorPageData.errorCode=="session_timeout"){
_43=true;
}
}
catch(e){
this.logMessage(this.strings.log_upload_failed_bad_json);
}
}
var _44;
if(_43){
_44=this.strings.error_session_timeout;
}else{
if(_3e.http_status==403){
_44=this.strings.error_picture_not_verified;
}else{
if(_3e.http_status==404){
_44=this.strings.error_picture_not_found;
}else{
if(_3e.http_status==410){
_44=this.strings.error_picture_not_moved;
}else{
if(_3e.http_status==413){
_44=this.strings.error_picture_too_large;
}else{
if(_3e.http_status==500){
if(_3e.code==10001){
_44=this.strings.error_session_timeout;
}else{
_44=this.strings.error_picture_not_uploaded;
}
}else{
switch(_3e.code){
case FileTransferError.FILE_NOT_FOUND_ERR:
_44=this.strings.error_no_picture;
break;
case FileTransferError.INVALID_URL_ERR:
_44=this.strings.error_bad_picture_url;
break;
case FileTransferError.CONNECTION_ERR:
_44=this.strings.error_server_connection;
break;
default:
_44=this.strings.error_upload_failed;
break;
}
}
}
}
}
}
}
this.displayAlert(_44);
};
}
