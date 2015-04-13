/* Licensed Materials - Property of IBM (See product 5724-O03 license for terms and conditions of use)
 * Copyright IBM Corp. 2006,2010 
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * WPF/LWF CORE PRODUCT SUPPORT - NOT CUSTOMER MODIFIABLE
 */
if (typeof wpf_lazy_load==="undefined"){
wpf_lazy_load={
  timerInterval:0,
  timerID:null,
  activate:function(interval){
    interval=interval||500;
    if(wpf_lazy_load.timerInterval<=0||interval<wpf_lazy_load.timerInterval){
      wpf_lazy_load.timerInterval=interval;
      if (wpf_lazy_load.timerID)
        window.clearTimeout(wpf_lazy_load.timerID);
      wpf_lazy_load.timerID=window.setInterval(wpf_lazy_load.lookForWork,interval);
    }
  },
  lookForWork:function(){
    dojo.query(".wpf_lazy_load").forEach(function(el){
      if(wpf_lazy_load.isElementVisible(el)){
        dojo.removeClass(el,"wpf_lazy_load");
            var f=el.onchange||el.getAttribute("onchange");
            if(f){
              if (typeof f==="function"){
                f.apply(el);
              }else{
                (new Function(f)).apply(el);
              }
            }
          }
      });
  },
  isElementVisible:function(el){
    if(wpf_lazy_load.isElementHidden(el))
      return false;
    var top=el.offsetTop;
    var left=el.offsetLeft;
    var width=el.offsetWidth;
    var height=el.offsetHeight;
    while(el.offsetParent){
      el=el.offsetParent;
      top += el.offsetTop;
      left += el.offsetLeft;
    }
    return ((top<(document.body.clientHeight||window.innerHeight)+document.body.scrollTop) &&
            (left<(document.body.clientWidth||window.innerWidth)+document.body.scrollLeft) &&
            ((top+height)>document.body.scrollTop) &&
            ((left+width)>document.body.scrollLeft));
  },
  isElementHidden:function(el){
    if(dojo.style(el,"display")==="none"||dojo.style(el,"visibility")==="hidden")
      return true;
    if (el.parentNode&&el.parentNode.tagName!="body"&&el.parentNode.tagName!="BODY")
      return wpf_lazy_load.isElementHidden(el.parentNode);
    return false;
  }
};
}