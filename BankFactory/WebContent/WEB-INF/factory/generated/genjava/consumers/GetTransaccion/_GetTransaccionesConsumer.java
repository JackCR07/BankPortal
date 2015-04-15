/**
 * Title:        _GetTransaccionesConsumer
 *
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006, 2007. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * Description:  Generated methods class for IBM Web Experience Factory application.
 *
 * This code was automatically generated at 02:28:56 PM on Apr 15, 2015
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
public class _GetTransaccionesConsumer  implements IExemplar
{

/**
 * Creates a new instance of this class
 */
public Object newInstance()
{
   return new _GetTransaccionesConsumer();
}

/*begin*/
/**
 * Generated Method [GetTransaccionesServiceGetTransaccionesOperation]
 */
public IXml GetTransaccionesServiceGetTransaccionesOperation(WebAppAccess webAppAccess)
{
//	The following webapp variables should be populated prior to invoking this method.
//	GetTransaccionesServiceGetTransaccionesOperationInputs

	Object result = webAppAccess.callMethod("GetTransaccionesService.executeOperation", "GetTransaccionesOperation", Boolean.FALSE );
	if (result instanceof WebAppAccessConsumer) {
		((WebAppAccessConsumer)result).setWebAppAccess(webAppAccess);
	}
	return (IXml)result;
}


/**
 * Generated Method [GetTransaccionesServiceGetTransaccionesOperationWithArgs]
 */
public IXml GetTransaccionesServiceGetTransaccionesOperationWithArgs(WebAppAccess webAppAccess, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8)
{
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetTransaccionesServiceGetTransaccionesOperationInputs/operation1/id_cuenta", arg1, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetTransaccionesServiceGetTransaccionesOperationInputs/operation1/id_tipo_transaccion", arg2, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetTransaccionesServiceGetTransaccionesOperationInputs/operation1/fecha_mov_mayor_a", arg3, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetTransaccionesServiceGetTransaccionesOperationInputs/operation1/fecha_mov_menor_a", arg4, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetTransaccionesServiceGetTransaccionesOperationInputs/operation1/mon_trans_mayor_a", arg5, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetTransaccionesServiceGetTransaccionesOperationInputs/operation1/mon_trans_menor_a", arg6, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetTransaccionesServiceGetTransaccionesOperationInputs/operation1/n_trans_mayor_a", arg7, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetTransaccionesServiceGetTransaccionesOperationInputs/operation1/n_trans_menor_a", arg8, false );
	Object result = webAppAccess.callMethod("GetTransaccionesService.executeOperation", "GetTransaccionesOperation", Boolean.TRUE );
	if (result instanceof WebAppAccessConsumer) {
		((WebAppAccessConsumer)result).setWebAppAccess(webAppAccess);
	}
	return (IXml)result;
}


/**
 * Generated Method [GetTransaccionesService_createHelper]
 */
public Object GetTransaccionesService_createHelper(WebAppAccess webAppAccess)
{
    com.bowstreet.builders.webapp.ServiceConsumer2DataHelper helper = new com.bowstreet.builders.webapp.ServiceConsumer2DataHelper();
    helper.setName("GetTransaccionesService");
    return helper;
}

/**
 * Generated Method [GetTransaccionesServiceView_SelectRow]
 */
public void GetTransaccionesServiceView_SelectRow(WebAppAccess webAppAccess, Integer rowIndex, String nextAction)
  {
    int index = rowIndex.intValue();
    String elementName="operation1Response";
    Variables vars = webAppAccess.getVariables();
    int selectedRow = index - 1;
    IXml data = vars.getXml("GetTransaccionesServiceGetTransaccionesOperationResults");
    if (data == null) return;
    if (data instanceof DataRetriever) { 
		data=vars.getXml("GetTransaccionesServiceView_PagingData");
    	if (data == null) return;
	    PagingAssistant asst=(PagingAssistant)vars.getObject("GetTransaccionesServiceView_Paging");
        if (asst!=null) {
        	elementName=asst.getTopLevelTagName();
            selectedRow=(index%asst.getRowsPerPage()); 
            selectedRow=selectedRow==0?asst.getRowsPerPage()-1:selectedRow-1; 
        }
 	} 
	if (elementName!=null) { 
    	data = data.findElement(elementName);
    }
    if (data == null) return;
    int row = 0;
    IXml child = data.getFirstChildElement();
    while (child != null) {
      if (row == selectedRow) {
        vars.setXml("GetTransaccionesServiceView_SelectedRowData", child.cloneElement());
        break;
      }
      row++;
      child = child.getNextSiblingElement();
    } 
  webAppAccess.processAction(nextAction);
  }

/**
 * Generated Method [GetTransaccionesServiceView_Paging_createHelper]
 */
public com.bowstreet.builders.webapp.methods.PagingAssistant GetTransaccionesServiceView_Paging_createHelper(WebAppAccess webAppAccess)
{
    com.bowstreet.builders.webapp.methods.PagingAssistant asst;
    asst = new com.bowstreet.builders.webapp.methods.PagingAssistant();
    asst.preserveLocation(false);
    asst.setName("GetTransaccionesServiceView_Paging");
    asst.setTopLevelTagName("operation1Response");
    asst.reset(webAppAccess);
    int rowsPerPage;
    try { rowsPerPage = DataConverter.toInteger("5").intValue(); }
    catch (Exception badValue) { rowsPerPage = 1; }
    asst.setRowsPerPage(rowsPerPage);
    return asst;
}

/**
 * Generated Method [GetTransaccionesServiceView_Paging_createRetriever]
 */
public DataRetriever GetTransaccionesServiceView_Paging_createRetriever(WebAppAccess webAppAccess)
{
    DataRetriever dr = (DataRetriever)PagingAssistant.findDataRetriever(webAppAccess, webAppAccess.getVariables().getObject("GetTransaccionesServiceGetTransaccionesOperationResults"), true, true);

    return dr;
}

/**
 * Generated Method [GetTransaccionesServiceView_Paging_CreateHelper]
 */
public com.bowstreet.builders.webapp.methods.PagingLinks GetTransaccionesServiceView_Paging_CreateHelper(WebAppAccess webAppAccess)
{
    PagingAssistant asst;
    asst = (PagingAssistant)webAppAccess.getVariables().getObject("GetTransaccionesServiceView_Paging");
    PagingLinks lnks = new PagingLinks(asst);
    lnks.setMaxLinks(DataConverter.toInteger("5").intValue());
    return lnks;
}

/**
 * Generated Method [GetTransaccionesServiceView_InputPage_SaveData]
 */
public void GetTransaccionesServiceView_InputPage_SaveData(WebAppAccess webAppAccess)
{
  String str;
  boolean performValidation;
  Variables variables = webAppAccess.getVariables();
  IInputFieldFormatter formatter;
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("GetTransaccionesServiceView_InputPageError");
    errors.clear();

    {
        IXml GetTransaccionesServiceGetTransaccionesOperationInputs = variables.getXml("GetTransaccionesServiceGetTransaccionesOperationInputs");
        if (GetTransaccionesServiceGetTransaccionesOperationInputs == null) {
            GetTransaccionesServiceGetTransaccionesOperationInputs = XmlUtil.create("operation1");
            variables.setXml("GetTransaccionesServiceGetTransaccionesOperationInputs", GetTransaccionesServiceGetTransaccionesOperationInputs);
        }
        
            str = webAppAccess.getRequestInputs().getInputValue("id_cuenta");
            GetTransaccionesServiceGetTransaccionesOperationInputs.setText("id_cuenta", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("id_tipo_transaccion");
            GetTransaccionesServiceGetTransaccionesOperationInputs.setText("id_tipo_transaccion", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("fecha_mov_mayor_a");
            GetTransaccionesServiceGetTransaccionesOperationInputs.setText("fecha_mov_mayor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("fecha_mov_menor_a");
            GetTransaccionesServiceGetTransaccionesOperationInputs.setText("fecha_mov_menor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("mon_trans_mayor_a");
            GetTransaccionesServiceGetTransaccionesOperationInputs.setText("mon_trans_mayor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("mon_trans_menor_a");
            GetTransaccionesServiceGetTransaccionesOperationInputs.setText("mon_trans_menor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("n_trans_mayor_a");
            GetTransaccionesServiceGetTransaccionesOperationInputs.setText("n_trans_mayor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("n_trans_menor_a");
            GetTransaccionesServiceGetTransaccionesOperationInputs.setText("n_trans_menor_a", str);
    
        variables.getVariable("GetTransaccionesServiceGetTransaccionesOperationInputs").notifyValueChanged();
    }
}

/**
 * Generated Method [_init_GetTransaccionesServiceView_InputPageError]
 */
public com.bowstreet.builderutilities.PageAutomationMessages _init_GetTransaccionesServiceView_InputPageError(WebAppAccess webAppAccess)
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
 * Generated Method [clear_GetTransaccionesServiceView_InputPage_Errors]
 */
public void clear_GetTransaccionesServiceView_InputPage_Errors(WebAppAccess webAppAccess)
{
  webAppAccess.callMethod("GetTransaccionesServiceView_InputPageError.clear");
}

/**
 * Generated Method [GetTransaccionesServiceView_InputPage_NextAction]
 */
public void GetTransaccionesServiceView_InputPage_NextAction(WebAppAccess webAppAccess)
{
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("GetTransaccionesServiceView_InputPageError");
    String action = errors.getForceAction();
    if (action != null)
        webAppAccess.processAction(action);
    else    if (errors.hasMessages())
        webAppAccess.processAction("GetTransaccionesServiceView_InputPage");
    else
        webAppAccess.processAction("GetTransaccionesServiceView_ShowResults");
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
 * Generated Method [GetTransaccionesServiceView_PagingGoToPage]
 */
public void GetTransaccionesServiceView_PagingGoToPage(WebAppAccess webAppAccess)
{
    String pageStr = webAppAccess.getRequestInputs().getInputValue("splitPagerExplicitPage");
    int pg = StringUtil.safeParseInt(pageStr, 1) - 1;
    PagingAssistant asst = (PagingAssistant)webAppAccess.getVariables().getObject("GetTransaccionesServiceView_Paging");
    asst.setCurrentPage(pg);
}


/**
 * Generated Method [GetTransaccionesServiceView_PagingGoToSpecificPage]
 */
public void GetTransaccionesServiceView_PagingGoToSpecificPage(WebAppAccess webAppAccess)
{
    String pageStr = webAppAccess.getRequestInputs().getInputValue("splitPagerTopExplicitPage");
    int pg = StringUtil.safeParseInt(pageStr, 1) - 1;
    PagingAssistant asst = (PagingAssistant)webAppAccess.getVariables().getObject("GetTransaccionesServiceView_Paging");
    asst.setCurrentPage(pg);
}


/**
 * Generated Method [GetTransaccionesServiceView_PagingSetRowsPerPage]
 */
public void GetTransaccionesServiceView_PagingSetRowsPerPage(WebAppAccess webAppAccess)
{
    String rppStr = webAppAccess.getRequestInputs().getInputValue("Arg1");
    int rpp = StringUtil.safeParseInt(rppStr, 1);
    PagingAssistant asst = (PagingAssistant)webAppAccess.getVariables().getObject("GetTransaccionesServiceView_Paging");
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
 * Generated Method [GetTransaccionesServiceView_PagingHandlePageLoad]
 */
public void GetTransaccionesServiceView_PagingHandlePageLoad(WebAppAccess webAppAccess)
{
    PagingAssistant asst = (PagingAssistant)webAppAccess.getVariables().getObject("GetTransaccionesServiceView_Paging");
    asst.setWebAppAccess(webAppAccess);
    webAppAccess.getVariables().getObject("GetTransaccionesServiceView_PagingData");}

/**
 * Generated ActionList [main]
 */
public Object main(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    // Show the input page.

    // Line 2: GetTransaccionesServiceView_InputPage
    returnValue = webAppAccess.processAction("GetTransaccionesServiceView_InputPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [GetTransaccionesServiceView_ShowResults]
 */
public Object GetTransaccionesServiceView_ShowResults(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: GetTransaccionesServiceGetTransaccionesOperation
    returnValue = webAppAccess.callMethod("GetTransaccionesServiceGetTransaccionesOperation", new Object[] {  });

    // Line 2: GetTransaccionesServiceView_ViewPage
    returnValue = webAppAccess.processAction("GetTransaccionesServiceView_ViewPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [_gen_call_GetTransaccionesServiceView_SelectRow]
 */
public Object _gen_call_GetTransaccionesServiceView_SelectRow(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    returnValue = webAppAccess.callMethod("GetTransaccionesServiceView_SelectRow", new Object[] { DataConverter.toInteger(webAppAccess.getRequestInputs().getInputValue("selectRow_Arg1")), webAppAccess.getRequestInputs().getInputValue("selectRow_Arg2") });
    return (Object)returnValue;
}



}
