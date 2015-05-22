/**
 * Title:        _StringSource
 *
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006, 2007. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * Description:  Generated methods class for IBM Web Experience Factory application.
 *
 * This code was automatically generated at 12:57:12 PM on May 20, 2015
 * by the IBM Web Experience Factory -- do not edit manually.
 * Generated using the following Profiles - Not Profiled.
 *
 */
package genjava.portlets;


/* begin method imports */
import com.bowstreet.builders.webapp.pageautomation.StandardFormatter;
import com.bowstreet.builderutilities.PageAutomationMessages;
import com.bowstreet.builderutilities.PageAutomationRuntime;
import com.bowstreet.methods.adapters.events.PropertyBrokerManager;
import com.bowstreet.methods.IInputFieldFormatter;
import com.bowstreet.util.cache.CacheManager;
import com.bowstreet.util.IExemplar;
import com.bowstreet.util.IXml;
import com.bowstreet.util.StringUtil;
import com.bowstreet.util.SystemProperties;
import com.bowstreet.util.SystemTrace;
import com.bowstreet.util.XmlTreeWalker;
import com.bowstreet.util.XmlUtil;
import com.bowstreet.webapp.DataConverter;
import com.bowstreet.webapp.engine.WebAppAccessImpl;
import com.bowstreet.webapp.LinkedModel;
import com.bowstreet.webapp.ModelInstanceCreator;
import com.bowstreet.webapp.RegenSettings;
import com.bowstreet.webapp.RequestData;
import com.bowstreet.webapp.RequestInputs;
import com.bowstreet.webapp.Schema;
import com.bowstreet.webapp.util.URLMapper;
import com.bowstreet.webapp.util.UserInfo;
import com.bowstreet.webapp.Variable;
import com.bowstreet.webapp.VariableContext;
import com.bowstreet.webapp.Variables;
import com.bowstreet.webapp.WebApp;
import com.bowstreet.webapp.WebAppAccess;
import com.bowstreet.webapp.WebAppData;
import com.bowstreet.webapp.WebAppHandle;
import java.util.*;
import javax.servlet.http.*;
import org.apache.log4j.Logger;
/* end method imports */

/**
 * Auto-generated methods class for IBM Web Experience Factory application.
 */
public class _StringSource  implements IExemplar
{

/**
 * Creates a new instance of this class
 */
public Object newInstance()
{
   return new _StringSource();
}

/*begin*/
/**
 * Generated Method [pb286Action_StringSourceA]
 */
public void pb286Action_StringSourceA(WebAppAccess webAppAccess)
{
        Object StringSourceA = webAppAccess.getVariables().getXmlChildText("FullnameData", "Fullname");
        PropertyBrokerManager.fireEvent(webAppAccess, "StringSourceA", null, StringSourceA);
        webAppAccess.processPage(webAppAccess.getCurrentPage());
}


/**
 * Generated Method [pbAction_StringSourceA]
 */
public void pbAction_StringSourceA(WebAppAccess webAppAccess, String actionName)
{
        Object StringSourceA = webAppAccess.getVariables().getXmlChildText("FullnameData", "Fullname");
        PropertyBrokerManager.fireEvent(webAppAccess, "StringSourceA", null, StringSourceA);
        webAppAccess.processPage(webAppAccess.getCurrentPage());
}


/**
 * Generated Method [InputPage_SaveData]
 */
public void InputPage_SaveData(WebAppAccess webAppAccess)
{
  String str;
  boolean performValidation;
  Variables variables = webAppAccess.getVariables();
  IInputFieldFormatter formatter;
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("InputPageError");
    errors.clear();

    {
        IXml FullnameData = variables.getXml("FullnameData");
        if (FullnameData == null) {
            FullnameData = XmlUtil.create("InputParms");
            variables.setXml("FullnameData", FullnameData);
        }
        
            str = webAppAccess.getRequestInputs().getInputValue("Fullname");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Required String"))
              errors.addMessage("Fullname", formatter.getErrorMessage());
            FullnameData.setText("Fullname", str);
    
        variables.getVariable("FullnameData").notifyValueChanged();
    }
}

/**
 * Generated Method [_init_InputPageError]
 */
public com.bowstreet.builderutilities.PageAutomationMessages _init_InputPageError(WebAppAccess webAppAccess)
{
    PageAutomationMessages result = new PageAutomationMessages();

    result.setReadableName("Fullname", "Fullname");

    return result;
}

/**
 * Generated Method [clear_InputPage_Errors]
 */
public void clear_InputPage_Errors(WebAppAccess webAppAccess)
{
  webAppAccess.callMethod("InputPageError.clear");
}

/**
 * Generated Method [InputPage_NextAction]
 */
public void InputPage_NextAction(WebAppAccess webAppAccess)
{
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("InputPageError");
    String action = errors.getForceAction();
    if (action != null)
        webAppAccess.processAction(action);
    else    if (errors.hasMessages())
        webAppAccess.processAction("InputPage");
    else
        webAppAccess.processAction("act_SubmitPage");
}

/**
 * Generated Method [fireAjaxPreLoad]
 */
public Object fireAjaxPreLoad(WebAppAccess webAppAccess)
{
Object _eventTarget = null;
	Object args[] = {
		};
	webAppAccess.getHttpServletRequest().setAttribute(WebAppAccessImpl.RENDERING_MODE_KEY, WebAppAccessImpl.SILENT_RENDERING_MODE);
	webAppAccess.fireEvent(_eventTarget, "AjaxPreLoad", args);

	return "(typeof wpf_event_bus != 'undefined') && wpf_event_bus.fire('" + "<%= webAppAccess.getInstanceID() %>AjaxPreLoad" + "', { })";}

/**
 * Generated Method [fireTargetedAjaxPreLoad]
 */
public Object fireTargetedAjaxPreLoad(WebAppAccess webAppAccess, Object _eventTarget)
{
	Object args[] = {
		};
	webAppAccess.getHttpServletRequest().setAttribute(WebAppAccessImpl.RENDERING_MODE_KEY, WebAppAccessImpl.SILENT_RENDERING_MODE);
	webAppAccess.fireEvent(_eventTarget, "AjaxPreLoad", args);

	return "(typeof wpf_event_bus != 'undefined') && wpf_event_bus.fire('" + "<%= webAppAccess.getInstanceID() %>AjaxPreLoad" + "', { })";}

/**
 * Generated Method [fireAjaxPreUpdate]
 */
public Object fireAjaxPreUpdate(WebAppAccess webAppAccess)
{
Object _eventTarget = null;
	Object args[] = {
		};
	webAppAccess.getHttpServletRequest().setAttribute(WebAppAccessImpl.RENDERING_MODE_KEY, WebAppAccessImpl.SILENT_RENDERING_MODE);
	webAppAccess.fireEvent(_eventTarget, "AjaxPreUpdate", args);

	return "(typeof wpf_event_bus != 'undefined') && wpf_event_bus.fire('" + "<%= webAppAccess.getInstanceID() %>AjaxPreUpdate" + "', { })";}

/**
 * Generated Method [fireTargetedAjaxPreUpdate]
 */
public Object fireTargetedAjaxPreUpdate(WebAppAccess webAppAccess, Object _eventTarget)
{
	Object args[] = {
		};
	webAppAccess.getHttpServletRequest().setAttribute(WebAppAccessImpl.RENDERING_MODE_KEY, WebAppAccessImpl.SILENT_RENDERING_MODE);
	webAppAccess.fireEvent(_eventTarget, "AjaxPreUpdate", args);

	return "(typeof wpf_event_bus != 'undefined') && wpf_event_bus.fire('" + "<%= webAppAccess.getInstanceID() %>AjaxPreUpdate" + "', { })";}

/**
 * Generated Method [fireAjaxPostLoad]
 */
public Object fireAjaxPostLoad(WebAppAccess webAppAccess)
{
Object _eventTarget = null;
	Object args[] = {
		};
	webAppAccess.getHttpServletRequest().setAttribute(WebAppAccessImpl.RENDERING_MODE_KEY, WebAppAccessImpl.SILENT_RENDERING_MODE);
	webAppAccess.fireEvent(_eventTarget, "AjaxPostLoad", args);

	return "(typeof wpf_event_bus != 'undefined') && wpf_event_bus.fire('" + "<%= webAppAccess.getInstanceID() %>AjaxPostLoad" + "', { })";}

/**
 * Generated Method [fireTargetedAjaxPostLoad]
 */
public Object fireTargetedAjaxPostLoad(WebAppAccess webAppAccess, Object _eventTarget)
{
	Object args[] = {
		};
	webAppAccess.getHttpServletRequest().setAttribute(WebAppAccessImpl.RENDERING_MODE_KEY, WebAppAccessImpl.SILENT_RENDERING_MODE);
	webAppAccess.fireEvent(_eventTarget, "AjaxPostLoad", args);

	return "(typeof wpf_event_bus != 'undefined') && wpf_event_bus.fire('" + "<%= webAppAccess.getInstanceID() %>AjaxPostLoad" + "', { })";}

/**
 * Generated Method [fireAjaxLoadError]
 */
public Object fireAjaxLoadError(WebAppAccess webAppAccess)
{
Object _eventTarget = null;
	Object args[] = {
		};
	webAppAccess.getHttpServletRequest().setAttribute(WebAppAccessImpl.RENDERING_MODE_KEY, WebAppAccessImpl.SILENT_RENDERING_MODE);
	webAppAccess.fireEvent(_eventTarget, "AjaxLoadError", args);

	return "(typeof wpf_event_bus != 'undefined') && wpf_event_bus.fire('" + "<%= webAppAccess.getInstanceID() %>AjaxLoadError" + "', { })";}

/**
 * Generated Method [fireTargetedAjaxLoadError]
 */
public Object fireTargetedAjaxLoadError(WebAppAccess webAppAccess, Object _eventTarget)
{
	Object args[] = {
		};
	webAppAccess.getHttpServletRequest().setAttribute(WebAppAccessImpl.RENDERING_MODE_KEY, WebAppAccessImpl.SILENT_RENDERING_MODE);
	webAppAccess.fireEvent(_eventTarget, "AjaxLoadError", args);

	return "(typeof wpf_event_bus != 'undefined') && wpf_event_bus.fire('" + "<%= webAppAccess.getInstanceID() %>AjaxLoadError" + "', { })";}

/**
 * Generated Method [getDefaultProgressIndicatorProgressIndicatorPageID]
 */
public String getDefaultProgressIndicatorProgressIndicatorPageID(WebAppAccess webAppAccess)
{
    StringBuffer id = new StringBuffer(webAppAccess.getInstanceID());
    id.append("getDefaultProgressIndicatorProgressIndicatorPageID_0");
    return id.toString();
}


/**
 * Generated ActionList [main]
 */
public Object main(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: InputPage
    returnValue = webAppAccess.processAction("InputPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [act_SubmitPage]
 */
public Object act_SubmitPage(WebAppAccess webAppAccess)
{
    Object returnValue = null;
    Logger logger = Logger.getLogger("bowstreet.system.out");
    boolean loggingIsEnabled = (logger != null) ? logger.isInfoEnabled() : false;

    // Line 1: running act_SubmitPage
    if (loggingIsEnabled)
        logger.info("SystemOut: running act_SubmitPage = " + "running act_SubmitPage");

    // Line 2: pb286Action_StringSourceA
    returnValue = webAppAccess.processAction("pb286Action_StringSourceA");

    // Line 3: 
    //InputPage
    return (Object)returnValue;
}


/**
 * Generated ActionList [act_LinkAction]
 */
public Object act_LinkAction(WebAppAccess webAppAccess)
{
    Object returnValue = null;
    Logger logger = Logger.getLogger("bowstreet.system.out");
    boolean loggingIsEnabled = (logger != null) ? logger.isInfoEnabled() : false;

    // Line 1: running act_LinkAction start
    if (loggingIsEnabled)
        logger.info("SystemOut: running act_LinkAction start = " + "running act_LinkAction start");

    // Line 2: pb286Action_StringSourceA
    returnValue = webAppAccess.processAction("pb286Action_StringSourceA");

    // Line 3: running act_LinkAction end
    if (loggingIsEnabled)
        logger.info("SystemOut: running act_LinkAction end = " + "running act_LinkAction end");
    return (Object)returnValue;
}



}
