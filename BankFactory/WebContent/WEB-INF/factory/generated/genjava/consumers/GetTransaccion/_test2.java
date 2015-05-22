/**
 * Title:        _test2
 *
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006, 2007. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * Description:  Generated methods class for IBM Web Experience Factory application.
 *
 * This code was automatically generated at 01:46:54 PM on May 21, 2015
 * by the IBM Web Experience Factory -- do not edit manually.
 * Generated using the following Profiles - Not Profiled.
 *
 */
package genjava.consumers.GetTransaccion;


/* begin method imports */
import com.bowstreet.builders.webapp.methods.SharedVariable;
import com.bowstreet.util.cache.CacheManager;
import com.bowstreet.util.IExemplar;
import com.bowstreet.util.IXml;
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
/* end method imports */

/**
 * Auto-generated methods class for IBM Web Experience Factory application.
 */
public class _test2  implements IExemplar
{

/**
 * Creates a new instance of this class
 */
public Object newInstance()
{
   return new _test2();
}

/*begin*/
/**
 * Generated Method [fireclientClientServiceError]
 */
public Object fireclientClientServiceError(WebAppAccess webAppAccess, String error)
{
Object _eventTarget = null;
	Object args[] = {
	error
	};
	webAppAccess.getHttpServletRequest().setAttribute(WebAppAccessImpl.RENDERING_MODE_KEY, WebAppAccessImpl.SILENT_RENDERING_MODE);
	webAppAccess.fireEvent(_eventTarget, "clientClientServiceError", args);

	return "(typeof wpf_event_bus != 'undefined') && wpf_event_bus.fire('" + "consumers_00215GetTransaccion_00215test2clientClientServiceError" + "', { error: '" + error + "' })";}

/**
 * Generated Method [fireclientClientPageError]
 */
public Object fireclientClientPageError(WebAppAccess webAppAccess, String error)
{
Object _eventTarget = null;
	Object args[] = {
	error
	};
	webAppAccess.getHttpServletRequest().setAttribute(WebAppAccessImpl.RENDERING_MODE_KEY, WebAppAccessImpl.SILENT_RENDERING_MODE);
	webAppAccess.fireEvent(_eventTarget, "clientClientPageError", args);

	return "(typeof wpf_event_bus != 'undefined') && wpf_event_bus.fire('" + "consumers_00215GetTransaccion_00215test2clientClientPageError" + "', { error: '" + error + "' })";}

/**
 * Generated Method [firechangeInVariables]
 */
public Object firechangeInVariables(WebAppAccess webAppAccess)
{
Object _eventTarget = null;
	Object args[] = {
		};
	webAppAccess.getHttpServletRequest().setAttribute(WebAppAccessImpl.RENDERING_MODE_KEY, WebAppAccessImpl.SILENT_RENDERING_MODE);
	webAppAccess.fireEvent(_eventTarget, "changeInVariables", args);

	return "(typeof wpf_event_bus != 'undefined') && wpf_event_bus.fire('" + "changeInVariables" + "', { })";}

/**
 * Generated Method [getClientMethodBodies]
 */
public String getClientMethodBodies(WebAppAccess webAppAccess)
{
return com.bowstreet.builders.webapp.client.ClientActionUtils.getClientMethodsScript(webAppAccess.getWebApp(), webAppAccess.getInstanceID());
}

/**
 * Generated Method [getClientVariableValues]
 */
public String getClientVariableValues(WebAppAccess webAppAccess)
{
return "dojo.safeMixin(" + webAppAccess.getInstanceID() + ".variables" + ", " + webAppAccess.callMethod("ClientActionDispatcher.getAggregatorPageVariablesAsJSON") + ");";
}

/**
 * Generated Method [setDeferredClientAction]
 */
public void setDeferredClientAction(WebAppAccess webAppAccess, String actionName)
{
webAppAccess.setCurrentPage(actionName);
}

/**
 * Generated Method [setDeferredClientActionParameters]
 */
public void setDeferredClientActionParameters(WebAppAccess webAppAccess, String parameters)
{
webAppAccess.getHttpServletRequest().setAttribute("bowstreet.client.deferred.action.parameters", parameters);
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
 * Generated Method [SharedInputTransaccion_createHelper]
 */
public Object SharedInputTransaccion_createHelper(WebAppAccess webAppAccess)
{
    com.bowstreet.builders.webapp.methods.SharedVariable helper = new com.bowstreet.builders.webapp.methods.SharedVariable();
    helper.setName("SharedInputTransaccion");
    return helper;
}

/**
 * Generated ActionList [main]
 */
public Object main(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: clientPage
    returnValue = webAppAccess.processAction("clientPage");
    return (Object)returnValue;
}



}
