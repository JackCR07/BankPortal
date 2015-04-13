/* Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright IBM Corp. 2006,2007,2011
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * WPF/LWF CORE PRODUCT SUPPORT - NOT CUSTOMER MODIFIABLE
 * Customer modification of core product files may void support agreements with respect to affected portions
 * of the product and any changes you make to the core product files may be lost when the product is upgraded.
 */
var contextualMenu = null;
var contextualMenuShowTime;

function ContextualMenuNeedScroll(){
  if(!document.all){
    return true;
  }
  if(document.all[0] ==null || document.all[0].nodeValue==null || document.all[0].nodeValue.indexOf("xhtml")<0){
    return false;
  }
  return true;
}

function ContextualMenuGetTotalScollLeft(menuControl){
  var left=0;
  var top=0;
  if(ContextualMenuNeedScroll()){//not IE
    var item = menuControl.parentNode;
    while(item!=null){
      if(item.nodeName=="BODY") break;
      if(item.scrollLeft >0){
        left+=item.scrollLeft;
      }
      if(item.scrollTop >0){
        top+=item.scrollTop;
      }
      item = item.parentNode;
    }
  }
  var postion = new Object;
  postion.left=left;
  postion.top=top;
  return postion;
}

function ContextualMenuGetOffset(baseItem){
  var left=0;
  var top=0;
  var item = baseItem;
  while(item!=null){
    left+= item.offsetLeft;
    top += item.offsetTop;
    item = item.offsetParent;
  }
  var postion = new Object;
  postion.left =left;
  postion.top =top;
  return postion;
}

function ContextualMenuGetParentOffset(baseItem){
  var left =0;
  var top =0;
  var item = baseItem.offsetParent;
  while(item!=null ){
    left+= item.offsetLeft;
    top += item.offsetTop;
    item = item.offsetParent;
  }
  var postion = new Object;
  postion.left =left;
  postion.top =top;
  return postion;
}

function ContextualMenuShowItem(menuControlId,itemID,align){
  var menuControl=document.getElementById(menuControlId);
  var menuItem = document.getElementById(itemID);
  var left,top;
  var offsetPosition = ContextualMenuGetOffset(menuControl);
  var scrollPosition = ContextualMenuGetTotalScollLeft(menuControl);
  if('Right'==align){
    left = (offsetPosition.left+menuControl.offsetWidth);
    top=offsetPosition.top;
  }else if('LeftBottom' == align){
    left = offsetPosition.left;
    top=offsetPosition.top+menuControl.offsetHeight;
  }else if('RightBottom' == align){
    left=offsetPosition.left+menuControl.offsetWidth-menuItem.offsetWidth;
    top=offsetPosition.top+menuControl.offsetHeight;
  }else if('Left' == align){
    left=offsetPosition.left-menuItem.offsetWidth;
    top=offsetPosition.top;
  }
  left -=scrollPosition.left;
  top  -=scrollPosition.top;
  var itemParent = ContextualMenuGetParentOffset(menuItem);
  left -=itemParent.left;
  top -=itemParent.top;
  left+='';
  top+='';
  if(left.substring(0,1) =='-'){
    left='0px';
  }
  if(left.indexOf("px")==-1){
    left +='px';
  }
  if(top.indexOf("px")==-1){
    top +='px';
  }
  menuItem.style.left=left;
  menuItem.style.top=top;
  menuItem.style.zIndex = 3;
  menuItem.style.visibility = 'visible';
  menuItem.style.display = '';
  // See if there is a defined "loader" script for this menu. If so, call it as a method of the menu container.
  var menuItem = document.getElementById(itemID);
  var loader = menuItem.getAttribute("onload");
  if (loader){
    if (typeof loader == "string")
      loader = new Function(loader);
      if (typeof loader == "function")
        loader.apply(menuItem, []);
  }
}

function ContextualMenuShowImg(imgID){
  document.getElementById(imgID).style.visibility = 'visible';
}

function ContextualMenuHideItem(itemID){
  node = document.getElementById(itemID);
  // The element may not exist if the page was re-rendered by a PPR
  if(node != null)
    node.style.visibility = 'hidden';
}

function ContextualMenuHideMenu(){
  if((new Date()).getTime() - contextualMenuShowTime <10){
    return;
  }else{
    if (contextualMenu != null){
      ContextualMenuHideItem(contextualMenu);
    }
  }
}

function ContextualMenuToggleMenu(menuControlId,menuID,align){
  if (document.getElementById(menuID).style.visibility == 'visible'){
    ContextualMenuHideItem(menuID);
    contextualMenu = null;
  }else{
    ContextualMenuHideMenu();
    contextualMenuHideTime=0;
    ContextualMenuShowItem(menuControlId,menuID,align);
    contextualMenu = menuID;
  }
  contextualMenuShowTime =(new Date()).getTime();
}

function ContextualMenuHandleMenuItemTD(mitemTDid, highlightFlag){
  var menuitemTD = document.getElementById(mitemTDid);
  if (highlightFlag){
    menuitemTD.className="ContextualMenuITDHover";
  }else{
    menuitemTD.className="ContextualMenuITD";
  }
}

//if (window.Event) { document.captureEvents(Event.ONCLICK); }
if(typeof document.addEventListener!= 'undefined'){
  document.addEventListener('click',ContextualMenuHideMenu,false);
}else if(typeof document.attachEvent!= 'undefined'){
  document.attachEvent('onclick',ContextualMenuHideMenu);
}

// Build pop-up menu HTML from a JSON description.
function ContextualMenuCreateMenu(container, data){
  // Example data object:
  // [ { text: "Item 1", attrs: {  onclick: "go(\"Item 1\")" } }, { text: "Item 2", attrs: {  onclick: "go(\"Item 2\")" } } ]
  var html = '<TABLE name="menuItemsTable" border="0" cellpadding="" cellspacing="0" class="ContextualMenuTable">';
  var highlight = "onmouseover='ContextualMenuDoHighlight(this, \"lightBlue\")'' onmouseout='ContextualMenuDoHighlight(this, \"\")' ";
  for (var row = 0; row < data.length; row++){
    var item = data[row];
    html += '<TR><TD align="left" nowrap class="ContextualMenuITD"  ';
    if (item.isSeparator){
      html += '><HR /></TD></TR>';
      continue;
    }
    html += highlight + '><A class="ContextualMenuIText" ';
    html += highlight;
    var attrs = item.attrs;   
    for (var i in attrs){
      html += " " + i + "='" + attrs[i] + "'";
    }
    html += ' >' + item.text + '</A>';
    html += '</TD></TR>';
  }
  html += '</TABLE>';  
  container.innerHTML = html;
}
// Highlight an element, and any A tags inside it.
function ContextualMenuDoHighlight(item, color){
  item.style.backgroundColor = color;
  var links = item.getElementsByTagName("A");
  if (links && links[0])
    ContextualMenuDoHighlight(links[0], color);
}
