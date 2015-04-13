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
 */

/*** peoplePickerSupport.js
 ***
 *** Used to define the functions to support People Picker Builder.
 *** 
 ***/
// The source object to open the people picker dialog
var srcObj;
// Returned people attribute type  - name, dn ....
var peopleAttr;
// User defined delimiter to separate values in multiple selection mode and the textfield control is selected.
var resultDelimiter;

/*
 * Add an option to the list control.
 */
function addOpt(oSelect,newOptText,newOptValue){	
	var options=oSelect.options;
	var i=0;
	//If the specified text/value exists, do not add it again.
	for(i=0;i<options.length;i++){
		var aOption=options[i];
		if(aOption.text == newOptText){
			return;
		}
	}
	var index=oSelect.options.length;
	oSelect.options[index]= new Option(newOptText,newOptValue);
	oSelect.options[index].selected=true;
}

/**
 * Remove the specified option from the list control.
 */
function removeOpts(oSelect){
	var oOptions=oSelect.options;
	var opts=new Array();		
	//Gather all unselected options	as the remaining options.
	for(i=0;i<oOptions.length;i++){
		var aOption=oOptions[i];
		if(!aOption.selected){
			opts.push(aOption);
		}
	}		
	//Remove all options from the list control	
	while(oOptions.length>0){
		oSelect.removeChild(oOptions[oOptions.length-1]);
	}
	//Add all remaining options to the list control. 
	for(i=0;i<opts.length;i++){			
		oSelect.options[i]= new Option(opts[i].text,opts[i].value);
	}	
}

/**
 * Process the result for text field.
 * 
 * For single selection mode, just use the returned result to fill in the input box. 
 * For multiple selection mode, the values are separated by the defined delimiter.
 */
function processResultForTextField(nameArr){		
	var selectedPeople = "";
	if (nameArr != null) {
		for (i = 0; i < nameArr.length; i++) {
			for(j = 0; j < nameArr[i].length; j++) {
				peopleValue = eval("nameArr[i][j]."+peopleAttr);
				if(j==0){
					selectedPeople=peopleValue;
				}
				else { 
				    //concat the multiple values with the defined delimiter. 
					selectedPeople=selectedPeople+resultDelimiter+peopleValue; 
				}
			} 
		}
	}
	// srcObj is defined by the generated 'openPeoplePicker' method in the generated builder html.
	document.getElementById( srcObj ).value = selectedPeople;	
}

/**
 * Process the result for list control - add new options to the list control.
 *
 * The option text is always the user/group name,and the option value is defined in the builder UI.
 */
function processResultForList(nameArr){
	// srcObj is defined by the generated 'openPeoplePicker' method in the generated builder html
	oSelect = document.getElementById( srcObj )
	if (nameArr != null && nameArr[0] != null) {
		for (i = 0; i < nameArr.length; i++) {
			selectedPeople = '';
			for(j = 0; j < nameArr[i].length; j++) {
				peopleValue = eval("nameArr[i][j]." + peopleAttr);
				peopleText = eval("nameArr[i][j].name");
				addOpt(oSelect,peopleText,peopleValue);
			}
		}
	}
}