/**
 * Title:        _GetTransaccionesProvider
 *
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006, 2007. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * Description:  Generated methods class for IBM Web Experience Factory application.
 *
 * This code was automatically generated at 02:25:43 PM on Apr 15, 2015
 * by the IBM Web Experience Factory -- do not edit manually.
 * Generated using the following Profiles - Not Profiled.
 *
 */
package genjava.providers.GetTransacciones;


/* begin method imports */
import com.bowstreet.builders.webapp.methods.ServiceTestHelper;
import com.bowstreet.builders.webapp.pageautomation.StandardFormatter;
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
public class _GetTransaccionesProvider  implements IExemplar
{

/**
 * Creates a new instance of this class
 */
public Object newInstance()
{
   return new _GetTransaccionesProvider();
}

/*begin*/
/**
 * Generated Method [GetTransaccionesWSDLOnLoadHandler]
 */
public void GetTransaccionesWSDLOnLoadHandler(WebAppAccess webAppAccess)
{
  // This method is an OnModelLoad event handler, and it's how we make sure 
  // that every user (every session thread) gets their own unique 
  // service call LJO so it can be stateful - so runtime code can call 
  // setTimeout etc and the object can hold the value safely until 
  // the invoke is called. Instantiating the LJO in the regen would mean 
  // that it would have to be stateless since there would be one instance 
  // shared by all users of that profile. 
  com.bowstreet.builders.webapp.methods.ServiceCallMethods helper = new com.bowstreet.builders.webapp.methods.ServiceCallMethods();
  helper.init( webAppAccess, "GetTransaccionesWSDL_data", "GetTransaccionesWSDL_reply", "GetTransaccionesWSDL_replyHeaders");
  com.bowstreet.webapp.Variable ljo = webAppAccess.getVariables().getVariable("GetTransaccionesWSDL");
  ljo.setValue(helper);
}


/**
 * Generated Method [_IRResolver_1]
 */
public Object _IRResolver_1(WebAppAccess webAppAccess)
{
    return "http://172.16.11.225:7800/getTransacciones/getTransacciones";
}

/**
 * Generated Method [_IRResolver_2]
 */
public Object _IRResolver_2(WebAppAccess webAppAccess)
{
    return "30";
}

/**
 * Generated Method [_IRResolver_3]
 */
public Object _IRResolver_3(WebAppAccess webAppAccess)
{
    return "operation1";
}

/**
 * Generated Method [_IRResolver_4]
 */
public Object _IRResolver_4(WebAppAccess webAppAccess)
{
    return "http://getTransacciones";
}

/**
 * Generated Method [_IRResolver_5]
 */
public Object _IRResolver_5(WebAppAccess webAppAccess)
{
    return "http://getTransacciones/operation1";
}

/**
 * Generated Method [_IRResolver_6]
 */
public Object _IRResolver_6(WebAppAccess webAppAccess)
{
    return "literal";
}

/**
 * Generated Method [_IRResolver_7]
 */
public Object _IRResolver_7(WebAppAccess webAppAccess)
{
    return "http://www.w3.org/2001/XMLSchema";
}

/**
 * Generated Method [_IRResolver_8]
 */
public Object _IRResolver_8(WebAppAccess webAppAccess)
{
    return webAppAccess.getVariables().getObject("GetTransaccionesWSDL_arg1_operation1Parameters");
}

/**
 * Generated Method [_IRResolver_9]
 */
public Object _IRResolver_9(WebAppAccess webAppAccess)
{
    return null;
}

/**
 * Generated Method [_IRResolver_10]
 */
public Object _IRResolver_10(WebAppAccess webAppAccess)
{
    return null;
}

/**
 * Generated Method [GetTransaccionesOperationInitInputs]
 */
public void GetTransaccionesOperationInitInputs(WebAppAccess webAppAccess)
{
    IXml data = webAppAccess.getVariables().getXml("GetTransaccionesOperationInputs");
    IXml inputs = webAppAccess.getVariables().getXml("GetTransaccionesOperationTargetInputStructure");
    webAppAccess.getVariables().setXml("GetTransaccionesWSDL_arg1_operation1Parameters", data);
    if (data!=null) {
        	XmlUtil.copyElementContents(data,inputs);
    }
}


/**
 * Generated Method [GetTransaccionesOperationExecute]
 */
public void GetTransaccionesOperationExecute(WebAppAccess webAppAccess)
{
    GetTransaccionesOperationInitInputs(webAppAccess);
    webAppAccess.callMethod("GetTransaccionesWSDL.invoke");
    IXml results =  webAppAccess.getVariables().getXml("GetTransaccionesWSDL_reply");
    GetTransaccionesOperationSetResults(webAppAccess, results);
}


/**
 * Generated Method [GetTransaccionesOperationSetResults]
 */
public void GetTransaccionesOperationSetResults(WebAppAccess webAppAccess, IXml operationResults)
{
    IXml results = operationResults;
    webAppAccess.getVariables().setXml("GetTransaccionesOperationResults", results);
}


/**
 * Generated Method [getTransaccionesServiceGetTransaccionesOperationTestMethod]
 */
public IXml getTransaccionesServiceGetTransaccionesOperationTestMethod(WebAppAccess webAppAccess)
{
    webAppAccess.callMethod("GetTransaccionesOperationExecute");
    IXml data = webAppAccess.getVariables().getXml("GetTransaccionesOperationResults");
    data = ServiceTestHelper.getData(data);
    ServiceTestHelper.cleanSampleData(data);
    return data;
}

/**
 * Generated Method [getTransaccionesServiceGetTransaccionesOperation_InputPage_SaveData]
 */
public void getTransaccionesServiceGetTransaccionesOperation_InputPage_SaveData(WebAppAccess webAppAccess)
{
  String str;
  boolean performValidation;
  Variables variables = webAppAccess.getVariables();
  IInputFieldFormatter formatter;
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("getTransaccionesServiceGetTransaccionesOperation_InputPageError");
    errors.clear();

    {
        IXml GetTransaccionesOperationInputs = variables.getXml("GetTransaccionesOperationInputs");
        if (GetTransaccionesOperationInputs == null) {
            GetTransaccionesOperationInputs = XmlUtil.create("operation1");
            variables.setXml("GetTransaccionesOperationInputs", GetTransaccionesOperationInputs);
        }
        
            str = webAppAccess.getRequestInputs().getInputValue("id_cuenta");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional integer"))
              errors.addMessage("id_cuenta", formatter.getErrorMessage());
            GetTransaccionesOperationInputs.setText("id_cuenta", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("id_tipo_transaccion");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional integer"))
              errors.addMessage("id_tipo_transaccion", formatter.getErrorMessage());
            GetTransaccionesOperationInputs.setText("id_tipo_transaccion", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("fecha_mov_mayor_a");
            GetTransaccionesOperationInputs.setText("fecha_mov_mayor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("fecha_mov_menor_a");
            GetTransaccionesOperationInputs.setText("fecha_mov_menor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("mon_trans_mayor_a");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional Floating Point Number"))
              errors.addMessage("mon_trans_mayor_a", formatter.getErrorMessage());
            GetTransaccionesOperationInputs.setText("mon_trans_mayor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("mon_trans_menor_a");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional Floating Point Number"))
              errors.addMessage("mon_trans_menor_a", formatter.getErrorMessage());
            GetTransaccionesOperationInputs.setText("mon_trans_menor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("n_trans_mayor_a");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional integer"))
              errors.addMessage("n_trans_mayor_a", formatter.getErrorMessage());
            GetTransaccionesOperationInputs.setText("n_trans_mayor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("n_trans_menor_a");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional integer"))
              errors.addMessage("n_trans_menor_a", formatter.getErrorMessage());
            GetTransaccionesOperationInputs.setText("n_trans_menor_a", str);
    
        variables.getVariable("GetTransaccionesOperationInputs").notifyValueChanged();
    }
}

/**
 * Generated Method [_init_getTransaccionesServiceGetTransaccionesOperation_InputPageError]
 */
public com.bowstreet.builderutilities.PageAutomationMessages _init_getTransaccionesServiceGetTransaccionesOperation_InputPageError(WebAppAccess webAppAccess)
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
 * Generated Method [clear_getTransaccionesServiceGetTransaccionesOperation_InputPage_Errors]
 */
public void clear_getTransaccionesServiceGetTransaccionesOperation_InputPage_Errors(WebAppAccess webAppAccess)
{
  webAppAccess.callMethod("getTransaccionesServiceGetTransaccionesOperation_InputPageError.clear");
}

/**
 * Generated Method [getTransaccionesServiceGetTransaccionesOperation_InputPage_NextAction]
 */
public void getTransaccionesServiceGetTransaccionesOperation_InputPage_NextAction(WebAppAccess webAppAccess)
{
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("getTransaccionesServiceGetTransaccionesOperation_InputPageError");
    String action = errors.getForceAction();
    if (action != null)
        webAppAccess.processAction(action);
    else    if (errors.hasMessages())
        webAppAccess.processAction("getTransaccionesServiceGetTransaccionesOperation_InputPage");
    else
        webAppAccess.processAction("getTransaccionesServiceGetTransaccionesOperation_ShowResults");
}

/**
 * Generated ActionList [getTransaccionesServiceGetTransaccionesOperation_ShowResults]
 */
public Object getTransaccionesServiceGetTransaccionesOperation_ShowResults(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: GetTransaccionesOperationExecute
    returnValue = webAppAccess.callMethod("GetTransaccionesOperationExecute", new Object[] {  });

    // Line 2: getTransaccionesServiceGetTransaccionesOperation_ViewPage
    returnValue = webAppAccess.processAction("getTransaccionesServiceGetTransaccionesOperation_ViewPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [getTransaccionesServiceGetTransaccionesOperationGotoOperation]
 */
public Object getTransaccionesServiceGetTransaccionesOperationGotoOperation(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    returnValue = webAppAccess.processAction("getTransaccionesServiceGetTransaccionesOperation_InputPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [main]
 */
public Object main(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    returnValue = webAppAccess.processAction("getTransaccionesServiceIndexPage");
    return (Object)returnValue;
}



}