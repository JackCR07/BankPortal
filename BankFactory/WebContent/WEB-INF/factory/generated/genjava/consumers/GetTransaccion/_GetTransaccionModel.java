/**
 * Title:        _GetTransaccionModel
 *
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006, 2007. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * Description:  Generated methods class for IBM Web Experience Factory application.
 *
 * This code was automatically generated at 03:39:34 PM on Apr 15, 2015
 * by the IBM Web Experience Factory -- do not edit manually.
 * Generated using the following Profiles - 
 {
  { mobile_devicetype_base : Default  }
 }
 *
 */
package genjava.consumers.GetTransaccion;


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
public class _GetTransaccionModel  implements IExemplar
{

/**
 * Creates a new instance of this class
 */
public Object newInstance()
{
   return new _GetTransaccionModel();
}

/*begin*/
/**
 * Generated Method [GetTransaccionesGetTransaccionesOperation]
 */
public IXml GetTransaccionesGetTransaccionesOperation(WebAppAccess webAppAccess)
{
//	The following webapp variables should be populated prior to invoking this method.
//	GetTransaccionesGetTransaccionesOperationInputs

	Object result = webAppAccess.callMethod("GetTransacciones.executeOperation", "GetTransaccionesOperation", Boolean.FALSE );
	if (result instanceof WebAppAccessConsumer) {
		((WebAppAccessConsumer)result).setWebAppAccess(webAppAccess);
	}
	return (IXml)result;
}


/**
 * Generated Method [GetTransaccionesGetTransaccionesOperationWithArgs]
 */
public IXml GetTransaccionesGetTransaccionesOperationWithArgs(WebAppAccess webAppAccess, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8)
{
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetTransaccionesGetTransaccionesOperationInputs/operation1/id_cuenta", arg1, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetTransaccionesGetTransaccionesOperationInputs/operation1/id_tipo_transaccion", arg2, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetTransaccionesGetTransaccionesOperationInputs/operation1/fecha_mov_mayor_a", arg3, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetTransaccionesGetTransaccionesOperationInputs/operation1/fecha_mov_menor_a", arg4, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetTransaccionesGetTransaccionesOperationInputs/operation1/mon_trans_mayor_a", arg5, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetTransaccionesGetTransaccionesOperationInputs/operation1/mon_trans_menor_a", arg6, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetTransaccionesGetTransaccionesOperationInputs/operation1/n_trans_mayor_a", arg7, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetTransaccionesGetTransaccionesOperationInputs/operation1/n_trans_menor_a", arg8, false );
	Object result = webAppAccess.callMethod("GetTransacciones.executeOperation", "GetTransaccionesOperation", Boolean.TRUE );
	if (result instanceof WebAppAccessConsumer) {
		((WebAppAccessConsumer)result).setWebAppAccess(webAppAccess);
	}
	return (IXml)result;
}


/**
 * Generated Method [GetTransacciones_createHelper]
 */
public Object GetTransacciones_createHelper(WebAppAccess webAppAccess)
{
    com.bowstreet.builders.webapp.ServiceConsumer2DataHelper helper = new com.bowstreet.builders.webapp.ServiceConsumer2DataHelper();
    helper.setName("GetTransacciones");
    return helper;
}

/**
 * Generated Method [GetTransaccionesView_Paging_createHelper]
 */
public com.bowstreet.builders.webapp.methods.PagingAssistant GetTransaccionesView_Paging_createHelper(WebAppAccess webAppAccess)
{
    com.bowstreet.builders.webapp.methods.PagingAssistant asst;
    asst = new com.bowstreet.builders.webapp.methods.PagingAssistant();
    asst.preserveLocation(false);
    asst.setName("GetTransaccionesView_Paging");
    asst.setTopLevelTagName("operation1Response");
    asst.reset(webAppAccess);
    int rowsPerPage;
    try { rowsPerPage = DataConverter.toInteger("5").intValue(); }
    catch (Exception badValue) { rowsPerPage = 1; }
    asst.setRowsPerPage(rowsPerPage);
    return asst;
}

/**
 * Generated Method [GetTransaccionesView_Paging_createRetriever]
 */
public DataRetriever GetTransaccionesView_Paging_createRetriever(WebAppAccess webAppAccess)
{
    DataRetriever dr = (DataRetriever)PagingAssistant.findDataRetriever(webAppAccess, webAppAccess.getVariables().getObject("GetTransaccionesGetTransaccionesOperationResults"), true, true);

    return dr;
}

/**
 * Generated Method [GetTransaccionesView_Paging_CreateHelper]
 */
public com.bowstreet.builders.webapp.methods.PagingLinks GetTransaccionesView_Paging_CreateHelper(WebAppAccess webAppAccess)
{
    PagingAssistant asst;
    asst = (PagingAssistant)webAppAccess.getVariables().getObject("GetTransaccionesView_Paging");
    PagingLinks lnks = new PagingLinks(asst);
    lnks.setMaxLinks(DataConverter.toInteger("5").intValue());
    return lnks;
}

/**
 * Generated Method [GetTransaccionesView_InputPage_SaveData]
 */
public void GetTransaccionesView_InputPage_SaveData(WebAppAccess webAppAccess)
{
  String str;
  boolean performValidation;
  Variables variables = webAppAccess.getVariables();
  IInputFieldFormatter formatter;
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("GetTransaccionesView_InputPageError");
    errors.clear();

    {
        IXml GetTransaccionesGetTransaccionesOperationInputs = variables.getXml("GetTransaccionesGetTransaccionesOperationInputs");
        if (GetTransaccionesGetTransaccionesOperationInputs == null) {
            GetTransaccionesGetTransaccionesOperationInputs = XmlUtil.create("operation1");
            variables.setXml("GetTransaccionesGetTransaccionesOperationInputs", GetTransaccionesGetTransaccionesOperationInputs);
        }
        
            str = webAppAccess.getRequestInputs().getInputValue("id_cuenta");
            GetTransaccionesGetTransaccionesOperationInputs.setText("id_cuenta", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("id_tipo_transaccion");
            GetTransaccionesGetTransaccionesOperationInputs.setText("id_tipo_transaccion", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("fecha_mov_mayor_a");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional Date(yyyy-MM-dd)"))
              errors.addMessage("fecha_mov_mayor_a", formatter.getErrorMessage());
            GetTransaccionesGetTransaccionesOperationInputs.setText("fecha_mov_mayor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("fecha_mov_menor_a");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional Date(yyyy-MM-dd)"))
              errors.addMessage("fecha_mov_menor_a", formatter.getErrorMessage());
            GetTransaccionesGetTransaccionesOperationInputs.setText("fecha_mov_menor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("mon_trans_mayor_a");
            GetTransaccionesGetTransaccionesOperationInputs.setText("mon_trans_mayor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("mon_trans_menor_a");
            GetTransaccionesGetTransaccionesOperationInputs.setText("mon_trans_menor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("n_trans_mayor_a");
            GetTransaccionesGetTransaccionesOperationInputs.setText("n_trans_mayor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("n_trans_menor_a");
            GetTransaccionesGetTransaccionesOperationInputs.setText("n_trans_menor_a", str);
    
        variables.getVariable("GetTransaccionesGetTransaccionesOperationInputs").notifyValueChanged();
    }
}

/**
 * Generated Method [_init_GetTransaccionesView_InputPageError]
 */
public com.bowstreet.builderutilities.PageAutomationMessages _init_GetTransaccionesView_InputPageError(WebAppAccess webAppAccess)
{
    PageAutomationMessages result = new PageAutomationMessages();

    result.setReadableName("id_cuenta", "Id Cuenta");
    result.setReadableName("id_tipo_transaccion", "Id Tipo Transaccion");
    result.setReadableName("fecha_mov_mayor_a", "Fecha Mov Mayor A");
    result.setReadableName("fecha_mov_menor_a", "Fecha Mov Menor A");
    result.setReadableName("mon_trans_mayor_a", "Mon Trans Mayor A");
    result.setReadableName("mon_trans_menor_a", "Mon Trans Menor A");
    result.setReadableName("n_trans_mayor_a", "N Trans Mayor A");
    result.setReadableName("n_trans_menor_a", "N Trans Menor A");

    return result;
}

/**
 * Generated Method [clear_GetTransaccionesView_InputPage_Errors]
 */
public void clear_GetTransaccionesView_InputPage_Errors(WebAppAccess webAppAccess)
{
  webAppAccess.callMethod("GetTransaccionesView_InputPageError.clear");
}

/**
 * Generated Method [GetTransaccionesView_InputPage_NextAction]
 */
public void GetTransaccionesView_InputPage_NextAction(WebAppAccess webAppAccess)
{
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("GetTransaccionesView_InputPageError");
    String action = errors.getForceAction();
    if (action != null)
        webAppAccess.processAction(action);
    else    if (errors.hasMessages())
        webAppAccess.processAction("GetTransaccionesView_InputPage");
    else
        webAppAccess.processAction("GetTransaccionesView_ShowResults");
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
 * Generated Method [GetTransaccionesView_PagingGoToPage]
 */
public void GetTransaccionesView_PagingGoToPage(WebAppAccess webAppAccess)
{
    String pageStr = webAppAccess.getRequestInputs().getInputValue("splitPagerExplicitPage");
    int pg = StringUtil.safeParseInt(pageStr, 1) - 1;
    PagingAssistant asst = (PagingAssistant)webAppAccess.getVariables().getObject("GetTransaccionesView_Paging");
    asst.setCurrentPage(pg);
}


/**
 * Generated Method [GetTransaccionesView_PagingGoToSpecificPage]
 */
public void GetTransaccionesView_PagingGoToSpecificPage(WebAppAccess webAppAccess)
{
    String pageStr = webAppAccess.getRequestInputs().getInputValue("splitPagerTopExplicitPage");
    int pg = StringUtil.safeParseInt(pageStr, 1) - 1;
    PagingAssistant asst = (PagingAssistant)webAppAccess.getVariables().getObject("GetTransaccionesView_Paging");
    asst.setCurrentPage(pg);
}


/**
 * Generated Method [GetTransaccionesView_PagingSetRowsPerPage]
 */
public void GetTransaccionesView_PagingSetRowsPerPage(WebAppAccess webAppAccess)
{
    String rppStr = webAppAccess.getRequestInputs().getInputValue("Arg1");
    int rpp = StringUtil.safeParseInt(rppStr, 1);
    PagingAssistant asst = (PagingAssistant)webAppAccess.getVariables().getObject("GetTransaccionesView_Paging");
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
 * Generated Method [GetTransaccionesView_PagingHandlePageLoad]
 */
public void GetTransaccionesView_PagingHandlePageLoad(WebAppAccess webAppAccess)
{
    PagingAssistant asst = (PagingAssistant)webAppAccess.getVariables().getObject("GetTransaccionesView_Paging");
    asst.setWebAppAccess(webAppAccess);
    webAppAccess.getVariables().getObject("GetTransaccionesView_PagingData");}

/**
 * Generated ActionList [main]
 */
public Object main(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    // Show the input page.

    // Line 2: GetTransaccionesView_InputPage
    returnValue = webAppAccess.processAction("GetTransaccionesView_InputPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [GetTransaccionesView_ShowResults]
 */
public Object GetTransaccionesView_ShowResults(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: GetTransaccionesGetTransaccionesOperation
    returnValue = webAppAccess.callMethod("GetTransaccionesGetTransaccionesOperation", new Object[] {  });

    // Line 2: GetTransaccionesView_ViewPage
    returnValue = webAppAccess.processAction("GetTransaccionesView_ViewPage");
    return (Object)returnValue;
}



}
