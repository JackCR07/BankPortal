/* Licensed Materials, Property of IBM 5724-O03 Copyright IBM Corp. 2006,2010 
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 * WPF/LWF CORE PRODUCT SUPPORT, NOT CUSTOMER MODIFIABLE, OVERWRITTEN ON UPGRADE */
if (typeof wpf_highlighter=="undefined"){
var wpf_highlighter={
  apply:function(tr,styles){
    if (tr.tagName!="TR"&&tr.tagName!="tr")
      return;
    for (style in styles){
      tr.style[style]=styles[style];
      if (style=="backgroundColor"||style=="color"){
        var tds=tr.childNodes;
        for (var i=0;i<tds.length;i++){
          if (tds[i].tagName=="TD"||tds[i].tagName=="td"){
            tds[i].style[style]=styles[style];
          }
        }
      }
    }
  }
};
};