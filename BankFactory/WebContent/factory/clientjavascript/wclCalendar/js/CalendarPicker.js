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

/**
 * JavaScript function that wraps initialization of the WCL Calendar objects. 
 * 
 * textId - the id of the text entry field
 * monthNames - translated month names separated by "|"
 * dayNames - translated day of the week names separated by "|". This could contain a leading first day of the week value ("1|Sun|Mon|Tue|Wed|Thu|Fri|Sat")
 * pattern - date format pattern
 *
 */
function CalendarPicker(textId, monthNames, dayNames, weekendDays, pattern, isLTR, imageURLPath, closeLabel, previousLabel, nextLabel, okLabel, cancelLabel, styleSheet)
{
	
    var id = textId + "_dc";
    var buttonId = textId
    buttonId.replace("input", "button");
    
    // see if there is a leading first day of the week value, if so remove it and use its value
	var firstDayOfWeek = parseInt(dayNames.substring(0,1));
	if(isNaN(firstDayOfWeek))
	{
	  firstDayOfWeek = 0;
	}
	else
	{
	  dayNames = dayNames.substring(2);
	}
    
	var cal = new Calendar(monthNames, dayNames, firstDayOfWeek.toString(), weekendDays );
	var df = new DateFormat(cal, pattern, 1926 ); 
	var dc = new WDateChooser(id, textId, buttonId, isLTR, false, 0, cal, df, 30, '', '', '', '');
 
	dc.setImage( 'CLOSE', new WImage( imageURLPath + '/dc4.gif', null, 18, 15, closeLabel ) );
	dc.setImage( 'PREVIOUS_MONTH', new WImage( imageURLPath + '/dc6.gif', null, 15, 15, previousLabel ) );
	dc.setImage( 'PREVIOUS_MONTH_OVER', new WImage( imageURLPath + '/dc8.gif', null, 15, 15, previousLabel ) );
	dc.setImage( 'NEXT_MONTH', new WImage(  imageURLPath + '/dc5.gif', null, 15, 15, nextLabel ) );
	dc.setImage( 'NEXT_MONTH_OVER', new WImage( imageURLPath + '/dc7.gif', null, 15, 15, nextLabel ) );
	dc.setText( 'OK', okLabel );
	dc.setText( 'CANCEL', cancelLabel );
	dc.addStyleSheet( styleSheet );

    return dc;
}
         
