/**
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006 IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * WPF/LWF CORE PRODUCT SUPPORT - NOT CUSTOMER MODIFIABLE
 *
 * Customer modification of core product files may void support agreements with
 * respect to affected portions of the product and any changes you make to the
 * core product files may be lost when the product is upgraded.
 *
 *  List Support
 */
if (typeof(list_requireUnique) == "undefined") 
{

// globals
 
var list_requireUnique = true;
var list_ie4 = false;
var list_ns4 = false;
var list_allString = "";

if (parseInt(navigator.appVersion) >= 4)
{
    list_ns4 = true;
    list_allString = "";
}

// Convert object name string or object reference 
// into a valid object reference 
// *** No longer used by this file - see list_getSelectObject below.
function list_getObject(obj) 
{
  var theObj;
  if (obj != null && typeof obj == "string") 
  {
    theObj = eval("document." + list_allString + obj);
  } 
  else 
  {
    theObj = obj;
  }

  return theObj;
}

// Find the named select object in this page.
function list_getSelectObject(obj, selectedForm)
{
    // If an object reference is passed in, return it; otherwise, look it up.
    if (obj != null && typeof obj == "string") 
    {
        // Return first input found in all forms on this page that has the
        // requested name.  Ideally, we could do this lookup more reliably -
        // any ideas?
        for (var i = 0; i < document.forms.length; i++)
        {
            var f = document.forms[i];
            if (selectedForm && (f != selectedForm))
                continue;
            for (var j = 0; j < f.elements.length; j++)
            {
                var el = f.elements[j];
                if (el.name == obj)
                    return el;
            }
        }
    }
    return obj;
}

// Find the named select object in this page.
function list_getSelectObjects(obj, selectedForm)
{
    var objs = new Array();
    var nObjs = 0;
    if (obj != null && typeof obj == "object")
        objs[nObjs++] = obj;

    // If an object reference is passed in, return it; otherwise, look it up.
    if (obj != null && typeof obj == "string") 
    {
        // Return all inputs found in all forms on this page that have the
        // requested name.
        for (var i = 0; i < document.forms.length; i++)
        {
            var f = document.forms[i];
            if (selectedForm && (f != selectedForm))
                continue;
            for (var j = 0; j < f.elements.length; j++)
            {
                var el = f.elements[j];
                if (el.name == obj)
                    objs[nObjs++] = el; 
            }
        }
    }
    return objs;
}

// Determine if the option is already in the list
function list_isInOptions(select, anOption, selectedForm)
{
    select = list_getSelectObject(select, selectedForm);
    var isIn = false;
    var i = 0;
    while (i < select.options.length)
    {
        var option = select.options[i];
        if (option.text == anOption.text && option.value == anOption.value)
        {

            isIn = true;
            break;
        }
        i++;
    }
    return isIn;
}

// add an option to a select
// In Netscape, it always adds at the end.
function list_addOptionToSelect(sel, name, val, selectedForm)
{
   sel = list_getSelectObject(sel, selectedForm);
   if(list_ie4)
   {
     var newElem = document.createElement("OPTION")
     newElem.text = name
     newElem.value = val
     sel.options.add(newElem, sel.selectedIndex)
   }
   else if (list_ns4)
   {
     sel.options[sel.length] = new Option(name, val, false, false)
   }
}

// remove an option from a select
function list_removeOptionIndexFromSelect(sel, val, selectedForm)
{
  sel = list_getSelectObject(sel, selectedForm);

  var max = sel.length;
  if (val >=0 && val < max)
  {
    if(list_ie4)
    {
        sel.options.remove(val);             
    }
    else if (list_ns4)
    {
        sel.options[val] = null;
    }
  }    
}

// move an option from one select to another
function list_doSelect(fromSelect, toSelect, selectedForm)
{
    fromSelect=list_getSelectObject(fromSelect, selectedForm);
    toSelect=list_getSelectObject(toSelect, selectedForm);

    var i = 0;
    while (i < fromSelect.options.length)
    {
        var option = fromSelect.options[i];
        if (option.selected && (!list_requireUnique || !list_isInOptions(toSelect, option)))
        {
            list_addOptionToSelect(toSelect, option.text, option.value, selectedForm);
        }
        i++;
    }
}

// remove an option from a select
function list_doDeselect(select, button, selectedForm)
{
    select=list_getSelectObject(select, selectedForm);

    if ((select.selectedIndex == -1) && (button == "delete"))
    {
        alert("You must select a value to delete.");
        return;
    }

    // if !list_requireUnique, then only remove the one they are really sitting on.
    if (!list_requireUnique)
    {

        var oldIndex = select.selectedIndex;

        if (oldIndex >= 0)
        {
            list_removeOptionIndexFromSelect(select, oldIndex, selectedForm);
            if (oldIndex < select.length)
                select.selectedIndex = oldIndex;
        }
    }
    else
    {
        var i = 0;
        while (i < select.options.length)
        {
            var option = select.options[i];
            if (option.selected)
            {
                list_removeOptionIndexFromSelect(select, i, selectedForm);
            }
            else
            {
                i++;
            }
        }
    }
}

// move all options from one select to another
function list_doSelectAll(fromSelect, toSelect, selectedForm)
{
    fromSelect=list_getSelectObject(fromSelect);
    toSelect=list_getSelectObject(toSelect);

    var i = 0;
    while (i < fromSelect.options.length)
    {
        var option = fromSelect.options[i];
        if (!list_isInOptions(toSelect, option))
        {
            list_addOptionToSelect(toSelect, option.text, option.value, selectedForm);
        }
        i++;
    }
}

// remove all options from a select
function list_doDeselectAll(select, selectedForm)
{
    select=list_getSelectObject(select, selectedForm);

    var i = 0;
    while (i < select.options.length)
    {
        var option = select.options[i];
        list_removeOptionIndexFromSelect(select, i, selectedForm);
    }
}

// add select to list array
function list_initList(select){
  var reg=new list_Array();
  if(window._list_ArrayReg){
    window._list_ArrayReg.addList(select);
  }
}

// create list array
function list_Array(){
  if(window._list_ArrayReg)
    return;
  window._list_ArrayReg=this;
  window._list_ArrayReg._lists=new Array();
  window._list_ArrayReg._submits=new Array();
}

// add select to list array
function list_ArrayAddList(select){
  var index=window._list_ArrayReg._lists.length;
  window._list_ArrayReg._lists[index]=select;
  // select=list_getSelectObject(select);
  var selects=list_getSelectObjects(select);
  if (selects == null)
    return;
  for (var iSel = 0; iSel < selects.length; iSel++)
  {
    select = selects[iSel];
    // determine whether to add old submit handler to list
    if (select.form.onsubmit != null) 
    {
      if(typeof(select.form.onsubmit)=='function')
      {
        var szFormSubmit = select.form.onsubmit.toString();
        var szListSubmit = list_submit.toString();
        if (szFormSubmit != szListSubmit)
        {
          var bFound = false;
          var len=window._list_ArrayReg._submits.length;
          for (var j= 0; j < len; j++)
          {
            if (select.form.onsubmit == window._list_ArrayReg._submits[j])
            {
              bFound = true;
              break;
            }
          }
    
          if (!bFound)
          {
            // submit handler is not currently in list so add it
            window._list_ArrayReg._submits[len]=select.form.onsubmit;
          }
        }
      }
    }
    
    // reset submit handler to our function
    select.form.onsubmit=list_submit;
  }
}

list_Array.prototype.addList=list_ArrayAddList;

// get the options
function list_submit()
{
  if (!window._list_ArrayReg || !window._list_ArrayReg._lists) {
    return;
  }
  var len = window._list_ArrayReg._lists.length;
  for (var j= 0; j < len; j++)
  {
    var selectname=window._list_ArrayReg._lists[j];
    
    // select all the options in the target list
    // var select=list_getSelectObject(selectname);
    var select;
    var selects=list_getSelectObjects(selectname);
    if (selects == null)
      continue;
    for (var iSel = 0; iSel < selects.length; iSel++)
    {
      select = selects[iSel];
      select.multiple = true;
      if (select.options)
      {
        for (var i = 0; i != select.options.length; i++)
        {
          select.options[i].selected = true;
        }
      }
    }
    
    // deselect all the options in the source list
    select=list_getSelectObject("_BS_FromList_"+selectname);
    if (select != null)
    {
      select.multiple = true;
      if (select.options)
      {
        for (var i = 0; i != select.options.length; i++)
        {
          select.options[i].selected = false;
        }
      }
    }
  }

  var len2 = window._list_ArrayReg._submits.length;
  for (var j= 0; j < len2; j++)
  {
      // invoke original onsubmit handlers
      if(typeof(window._list_ArrayReg._submits[j])=='function')
        window._list_ArrayReg._submits[j]();
  }
  
  return true;
}

} // end if
