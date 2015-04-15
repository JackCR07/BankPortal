/**
 * Title:        _CreateTransaccionConsumer_Default
 *
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006, 2007. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * Description:  Generated methods class for IBM Web Experience Factory application.
 *
 * This code was automatically generated at 11:44:53 AM on Apr 15, 2015
 * by the IBM Web Experience Factory -- do not edit manually.
 * Generated using the following Profiles - 
 {
  { mobile_devicetype_base : Default  }
 }
 *
 */
package genjava.consumers.CreateTransaccion;


/* begin method imports */
import com.bowstreet.builders.webapp.methods.*;
import com.bowstreet.builders.webapp.methods.DataRetriever;
import com.bowstreet.builders.webapp.methods.PagingAssistant;
import com.bowstreet.builders.webapp.methods.WebAppAccessConsumer;
import com.bowstreet.builders.webapp.pageautomation.StandardFormatter;
import com.bowstreet.builders.webapp.ServiceConsumer2DataHelper;
import com.bowstreet.builderutilities.PageAutomationMessages;
import com.bowstreet.builderutilities.PageAutomationRuntime;
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
/* end method imports */

/**
 * Auto-generated methods class for IBM Web Experience Factory application.
 */
public class _CreateTransaccionConsumer_Default  implements IExemplar
{

/**
 * Creates a new instance of this class
 */
public Object newInstance()
{
   return new _CreateTransaccionConsumer_Default();
}

/*begin*/
/**
 * Generated Method [CreateTransaccionCreateTransaccion]
 */
public IXml CreateTransaccionCreateTransaccion(WebAppAccess webAppAccess)
{
//	The following webapp variables should be populated prior to invoking this method.
//	CreateTransaccionCreateTransaccionInputs

	Object result = webAppAccess.callMethod("CreateTransaccion.executeOperation", "CreateTransaccion", Boolean.FALSE );
	if (result instanceof WebAppAccessConsumer) {
		((WebAppAccessConsumer)result).setWebAppAccess(webAppAccess);
	}
	return (IXml)result;
}


/**
 * Generated Method [CreateTransaccionCreateTransaccionWithArgs]
 */
public IXml CreateTransaccionCreateTransaccionWithArgs(WebAppAccess webAppAccess, String arg1, String arg2, String arg3, String arg4)
{
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"CreateTransaccionCreateTransaccionInputs/operation1/id_cuenta_origen", arg1, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"CreateTransaccionCreateTransaccionInputs/operation1/numero_cuenta_destino", arg2, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"CreateTransaccionCreateTransaccionInputs/operation1/id_tipo_transaccion", arg3, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"CreateTransaccionCreateTransaccionInputs/operation1/monto_transferido", arg4, false );
	Object result = webAppAccess.callMethod("CreateTransaccion.executeOperation", "CreateTransaccion", Boolean.TRUE );
	if (result instanceof WebAppAccessConsumer) {
		((WebAppAccessConsumer)result).setWebAppAccess(webAppAccess);
	}
	return (IXml)result;
}


/**
 * Generated Method [CreateTransaccion_createHelper]
 */
public Object CreateTransaccion_createHelper(WebAppAccess webAppAccess)
{
    com.bowstreet.builders.webapp.ServiceConsumer2DataHelper helper = new com.bowstreet.builders.webapp.ServiceConsumer2DataHelper();
    helper.setName("CreateTransaccion");
    return helper;
}

/**
 * Generated Method [CreateTransaccionView_Paging_createHelper]
 */
public com.bowstreet.builders.webapp.methods.PagingAssistant CreateTransaccionView_Paging_createHelper(WebAppAccess webAppAccess)
{
    com.bowstreet.builders.webapp.methods.PagingAssistant asst;
    asst = new com.bowstreet.builders.webapp.methods.PagingAssistant();
    asst.preserveLocation(false);
    asst.setName("CreateTransaccionView_Paging");
    asst.setTopLevelTagName("operation1Response");
    asst.reset(webAppAccess);
    int rowsPerPage;
    try { rowsPerPage = DataConverter.toInteger("5").intValue(); }
    catch (Exception badValue) { rowsPerPage = 1; }
    asst.setRowsPerPage(rowsPerPage);
    return asst;
}

/**
 * Generated Method [CreateTransaccionView_Paging_createRetriever]
 */
public DataRetriever CreateTransaccionView_Paging_createRetriever(WebAppAccess webAppAccess)
{
    DataRetriever dr = (DataRetriever)PagingAssistant.findDataRetriever(webAppAccess, webAppAccess.getVariables().getObject("CreateTransaccionCreateTransaccionResults"), true, true);

    return dr;
}

/**
 * Generated Method [CreateTransaccionView_Paging_CreateHelper]
 */
public com.bowstreet.builders.webapp.methods.PagingLinks CreateTransaccionView_Paging_CreateHelper(WebAppAccess webAppAccess)
{
    PagingAssistant asst;
    asst = (PagingAssistant)webAppAccess.getVariables().getObject("CreateTransaccionView_Paging");
    PagingLinks lnks = new PagingLinks(asst);
    lnks.setMaxLinks(DataConverter.toInteger("5").intValue());
    return lnks;
}

/**
 * Generated Method [CreateTransaccionView_InputPage_SaveData]
 */
public void CreateTransaccionView_InputPage_SaveData(WebAppAccess webAppAccess)
{
  String str;
  boolean performValidation;
  Variables variables = webAppAccess.getVariables();
  IInputFieldFormatter formatter;
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("CreateTransaccionView_InputPageError");
    errors.clear();

    {
        IXml CreateTransaccionCreateTransaccionInputs = variables.getXml("CreateTransaccionCreateTransaccionInputs");
        if (CreateTransaccionCreateTransaccionInputs == null) {
            CreateTransaccionCreateTransaccionInputs = XmlUtil.create("operation1");
            variables.setXml("CreateTransaccionCreateTransaccionInputs", CreateTransaccionCreateTransaccionInputs);
        }
        
            str = webAppAccess.getRequestInputs().getInputValue("id_cuenta_origen");
            CreateTransaccionCreateTransaccionInputs.setText("id_cuenta_origen", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("numero_cuenta_destino");
            CreateTransaccionCreateTransaccionInputs.setText("numero_cuenta_destino", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("id_tipo_transaccion");
            CreateTransaccionCreateTransaccionInputs.setText("id_tipo_transaccion", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("monto_transferido");
            CreateTransaccionCreateTransaccionInputs.setText("monto_transferido", str);
    
        variables.getVariable("CreateTransaccionCreateTransaccionInputs").notifyValueChanged();
    }
}

/**
 * Generated Method [_init_CreateTransaccionView_InputPageError]
 */
public com.bowstreet.builderutilities.PageAutomationMessages _init_CreateTransaccionView_InputPageError(WebAppAccess webAppAccess)
{
    PageAutomationMessages result = new PageAutomationMessages();

    result.setReadableName("id_cuenta_origen", "Id Cuenta Origen");
    result.setReadableName("numero_cuenta_destino", "Numero Cuenta Destino");
    result.setReadableName("id_tipo_transaccion", "Id Tipo Transaccion");
    result.setReadableName("monto_transferido", "Monto Transferido");

    return result;
}

/**
 * Generated Method [clear_CreateTransaccionView_InputPage_Errors]
 */
public void clear_CreateTransaccionView_InputPage_Errors(WebAppAccess webAppAccess)
{
  webAppAccess.callMethod("CreateTransaccionView_InputPageError.clear");
}

/**
 * Generated Method [CreateTransaccionView_InputPage_NextAction]
 */
public void CreateTransaccionView_InputPage_NextAction(WebAppAccess webAppAccess)
{
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("CreateTransaccionView_InputPageError");
    String action = errors.getForceAction();
    if (action != null)
        webAppAccess.processAction(action);
    else    if (errors.hasMessages())
        webAppAccess.processAction("CreateTransaccionView_InputPage");
    else
        webAppAccess.processAction("CreateTransaccionView_ShowResults");
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
 * Generated Method [CreateTransaccionView_PagingGoToPage]
 */
public void CreateTransaccionView_PagingGoToPage(WebAppAccess webAppAccess)
{
    String pageStr = webAppAccess.getRequestInputs().getInputValue("splitPagerExplicitPage");
    int pg = StringUtil.safeParseInt(pageStr, 1) - 1;
    PagingAssistant asst = (PagingAssistant)webAppAccess.getVariables().getObject("CreateTransaccionView_Paging");
    asst.setCurrentPage(pg);
}


/**
 * Generated Method [CreateTransaccionView_PagingGoToSpecificPage]
 */
public void CreateTransaccionView_PagingGoToSpecificPage(WebAppAccess webAppAccess)
{
    String pageStr = webAppAccess.getRequestInputs().getInputValue("splitPagerTopExplicitPage");
    int pg = StringUtil.safeParseInt(pageStr, 1) - 1;
    PagingAssistant asst = (PagingAssistant)webAppAccess.getVariables().getObject("CreateTransaccionView_Paging");
    asst.setCurrentPage(pg);
}


/**
 * Generated Method [CreateTransaccionView_PagingSetRowsPerPage]
 */
public void CreateTransaccionView_PagingSetRowsPerPage(WebAppAccess webAppAccess)
{
    String rppStr = webAppAccess.getRequestInputs().getInputValue("Arg1");
    int rpp = StringUtil.safeParseInt(rppStr, 1);
    PagingAssistant asst = (PagingAssistant)webAppAccess.getVariables().getObject("CreateTransaccionView_Paging");
    asst.setRowsPerPage(rpp);
}


/**
 * Generated Method [_pageDispatcher]
 */
public void _pageDispatcher(WebAppAccess webAppAccess)
{
    com.bowstreet.webapp.JSPSupport.dispatch(webAppAccess);
}

/**
 * Generated Method [CreateTransaccionView_PagingHandlePageLoad]
 */
public void CreateTransaccionView_PagingHandlePageLoad(WebAppAccess webAppAccess)
{
    PagingAssistant asst = (PagingAssistant)webAppAccess.getVariables().getObject("CreateTransaccionView_Paging");
    asst.setWebAppAccess(webAppAccess);
    webAppAccess.getVariables().getObject("CreateTransaccionView_PagingData");}

/**
 * Generated ActionList [main]
 */
public Object main(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    // Show the input page.

    // Line 2: CreateTransaccionView_InputPage
    returnValue = webAppAccess.processAction("CreateTransaccionView_InputPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [CreateTransaccionView_ShowResults]
 */
public Object CreateTransaccionView_ShowResults(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: CreateTransaccionCreateTransaccion
    returnValue = webAppAccess.callMethod("CreateTransaccionCreateTransaccion", new Object[] {  });

    // Line 2: CreateTransaccionView_ViewPage
    returnValue = webAppAccess.processAction("CreateTransaccionView_ViewPage");
    return (Object)returnValue;
}



}
