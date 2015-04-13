/* Licensed Materials - Property of IBM (See Web Experience Factory product id 5724-O03 for license terms of use)
 * Copyright IBM Corp. 2013
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * CORE PRODUCT SUPPORT, NOT CUSTOMER MODIFIABLE, OVERWRITTEN ON UPGRADE
 */
if (typeof WpfGeo=="undefined")
{
  // Client side geolocation events
  function WpfGeoClient(idPrefix,positionOptions,markerElementId){
    this.idPrefix=idPrefix;
    this.positionOptions=positionOptions;
    this.watchId=null;
    this.markerElementId=markerElementId;

    // invoke getCurrentPosition when DOM is loaded
    this.addOnload=function(){
      if (document.readyState=="loading"){
        // The page is still loading. Add an event listener to call getCurrentPosition() when it's done loading
        var self = this;
        if (document.addEventListener){
          document.addEventListener("DOMContentLoaded",self.getCurrentPosition(),false);
        }else if (window.attachEvent){
          // This is necessary to support IE 8 and older.
          window.attachEvent("onload",self.getCurrentPosition());
        }
      }else{
        // Page already loaded, so just call getCurrentPosition() directly.
        this.getCurrentPosition();
      }
    };

    // used to manually request a geolocation getCurrentPosition
    this.getCurrentPosition=function(){
      // we could use setPosition.bind(this) so that "this" gets passes to callback method but it's not supported in FF 3.x
      var self=this;
      if(navigator.geolocation){
        // use the geo location API to call back the setPosition() function. Options are: {enableHighAccuracy:false, maximumAge:1000000, timeout:50000}
        navigator.geolocation.getCurrentPosition(function(position){self.setPosition(self, position);},function(error){self.geoError(self,error);},self.positionOptions);
      }
    };

    // callback for getCurrentPosition
    this.setPosition=function(self,position){
      if (typeof wpf_event_bus != "undefined"){
        var element=self.findReferenceElement();
        wpf_event_bus.fire(self.idPrefix+"GeoLocationClient",{geoLocation:position.coords,geoElement:element});
      }
    };

    // error callback for getCurrentPosition
    this.geoError=function(self,error)
    {
      if (typeof wpf_event_bus != "undefined"){
        var element=self.findReferenceElement();
        wpf_event_bus.fire(self.idPrefix +"GeoLocationErrorClient",{geoLocationError:error,geoElement:element});
      }
    };

    // error callback for getCurrentPosition
    this.findReferenceElement=function(){
      // The marker element has a unique ID within the context of the current document, and is a child of the
      // reference element. To find the reference element, first find the marker element, then return its parent.
      var element=null;
      if (this.markerElementId){
        var markerElement=document.getElementById(this.markerElementId);
        if (markerElement){
          element=markerElement.parentNode;
        }
      }
      return element;
    };

    // used to manually request a geolocation watchPosition
    this.watchPosition=function(){
      // we could use setPosition.bind(this) so that "this" gets passes to callback method but it's not supported in FF 3.x
      var self=this;
      if (navigator.geolocation){
        // use the geo location API to call back the setPosition() function. Options are: {enableHighAccuracy:false, maximumAge:1000000, timeout:50000}
        self.watchId=navigator.geolocation.watchPosition(function(position){self.setPosition(self,position);},function(error){self.geoError(self,error);},self.positionOptions);
        return self.watchId;
      }
    };

    // used to cancel a geolocation watchPosition
    this.clearWatch=function(watchId){
      if(navigator.geolocation){
        if(watchId){
          navigator.geolocation.clearWatch(watchId);
        }else if(this.watchId){
          navigator.geolocation.clearWatch(this.watchId);
        }
      }
    };
  }

  // Used for server side geolocation events
  function WpfGeo(idPrefix,inputs,errorInputs,positionOptions){
    this.idPrefix=idPrefix;
    this.positionOptions=positionOptions;
    this.inputs=inputs;
    this.errorInputs=errorInputs;

    // invoke getCurrentPosition when DOM is loaded
    this.addOnload=function(){
      if (document.readyState=="loading"){
        // The page is still loading. Add an event listener to call getCurrentPosition when it's done loading
        var self=this;
        if (document.addEventListener){
          document.addEventListener("DOMContentLoaded",self.getCurrentPosition(),false);
        }else if (window.attachEvent){
          // This is necessary to support IE 8 and older.
          window.attachEvent("onload",self.getCurrentPosition());
        }
      }else{
        // The page has already been loaded, so just call getCurrentPosition directly
        this.getCurrentPosition();
      }
    };

    // used to manually request a geolocation
    this.getCurrentPosition=function(){
      // we could use setPosition.bind(this) so that "this" gets passes to callback method but it's not supported in FF 3.x
      var self=this;
      if(navigator.geolocation){
        navigator.geolocation.getCurrentPosition(function(position){self.setPosition(self,position);},function(error){self.geoError(self,error);},self.positionOptions);
      }
    };

    // call back for getCurrentPosition, update inputs and submit back to server
    this.setPosition=function(self,position){
      // update the hidden inputs
      for(var x=0;x<self.inputs.length;x++){
        var input=self.inputs[x];
        var target=document.getElementById(self.idPrefix+input);
        if(target)
          eval("target.value = position.coords."+input+";");
      }
      var link=document.getElementById(self.idPrefix+"geolocation_submit");
      // click on the submit form link
      if(link)
        link.onclick();
    };

    // error call back for getCurrentPosition, update error inputs and submit back to server
    this.geoError=function(self,error){
      // update the hidden inputs
      for(var x=0;x<self.errorInputs.length;x++){
        var input=self.errorInputs[x];
        var target=document.getElementById(self.idPrefix + input);
        if(target)
          eval("target.value = error."+input+";");
      }
      var link=document.getElementById(self.idPrefix+"geolocation_submit");
      // click on the submit form link
      if(link)
        link.onclick();
    };

    // used to manually request a geolocation watchPosition
    this.watchPosition=function(){
      // we could use setPosition.bind(this) so that "this" gets passes to callback method but it's not supported in FF 3.x
      var self=this;
      if(navigator.geolocation){
        // use the geo location API to call back the setPosition function. Options are: {enableHighAccuracy:false, maximumAge:1000000, timeout:50000
        self.watchId=navigator.geolocation.watchPosition(function(position){self.setPosition(self,position);}, function(error){self.geoError(self,error);},self.positionOptions);
          return self.watchId;
      }
    };

    // used to cancel a geolocation watchPosition
    this.clearWatch=function(watchId){
      if(navigator.geolocation){
        if(watchId){
          navigator.geolocation.clearWatch(watchId);
        }
        else if(this.watchId){
          navigator.geolocation.clearWatch(this.watchId);
        }
      }
    };
  }
}
