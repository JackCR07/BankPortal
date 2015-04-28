/**
 * Title:        _GetCuentasProvider
 *
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006, 2007. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * Description:  Generated methods class for IBM Web Experience Factory application.
 *
 * This code was automatically generated at 02:56:19 PM on Apr 28, 2015
 * by the IBM Web Experience Factory -- do not edit manually.
 * Generated using the following Profiles - Not Profiled.
 *
 */
package genjava.providers.GetCuentas;


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
public class _GetCuentasProvider  implements IExemplar
{

/**
 * Creates a new instance of this class
 */
public Object newInstance()
{
   return new _GetCuentasProvider();
}

/*begin*/
/**
 * Generated Method [GetCuentasWSDLCallOnLoadHandler]
 */
public void GetCuentasWSDLCallOnLoadHandler(WebAppAccess webAppAccess)
{
  // This method is an OnModelLoad event handler, and it's how we make sure 
  // that every user (every session thread) gets their own unique 
  // service call LJO so it can be stateful - so runtime code can call 
  // setTimeout etc and the object can hold the value safely until 
  // the invoke is called. Instantiating the LJO in the regen would mean 
  // that it would have to be stateless since there would be one instance 
  // shared by all users of that profile. 
  com.bowstreet.builders.webapp.methods.ServiceCallMethods helper = new com.bowstreet.builders.webapp.methods.ServiceCallMethods();
  helper.init( webAppAccess, "GetCuentasWSDLCall_data", "GetCuentasWSDLCall_reply", "GetCuentasWSDLCall_replyHeaders");
  com.bowstreet.webapp.Variable ljo = webAppAccess.getVariables().getVariable("GetCuentasWSDLCall");
  ljo.setValue(helper);
}


/**
 * Generated Method [_IRResolver_1]
 */
public Object _IRResolver_1(WebAppAccess webAppAccess)
{
    return "http://172.16.11.225:7800/GetCuentas/GetCuentas";
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
    return "http://GetCuentas";
}

/**
 * Generated Method [_IRResolver_5]
 */
public Object _IRResolver_5(WebAppAccess webAppAccess)
{
    return "http://GetCuentas/operation1";
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
    return webAppAccess.getVariables().getObject("GetCuentasWSDLCall_arg1_operation1Parameters");
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
 * Generated Method [GetCuentasSOInitInputs]
 */
public void GetCuentasSOInitInputs(WebAppAccess webAppAccess)
{
    IXml inputs = webAppAccess.getVariables().getXml("GetCuentasSOTargetInputStructure").cloneElement();
    IXml data = webAppAccess.getVariables().getXml("GetCuentasSOInputs");
    if (data == null) {
        data = XmlUtil.create("operation1");
    }
    inputs.setText("id_cliente", DataConverter.toString(webAppAccess.callMethod("getUserId")));
    inputs.setText("id_tipo_cuenta", DataConverter.toString(data.getText("id_tipo_cuenta")));
    inputs.setText("fecha_mayor_a", DataConverter.toString(data.getText("fecha_mayor_a")));
    inputs.setText("fecha_menor_a", DataConverter.toString(data.getText("fecha_menor_a")));
    inputs.setText("saldo_mayor_a", DataConverter.toString(data.getText("saldo_mayor_a")));
    inputs.setText("saldo_menor_a", DataConverter.toString(data.getText("saldo_menor_a")));
    webAppAccess.getVariables().setXml("GetCuentasWSDLCall_arg1_operation1Parameters", inputs);
}


/**
 * Generated Method [GetCuentasSOExecute]
 */
public void GetCuentasSOExecute(WebAppAccess webAppAccess)
{
    GetCuentasSOInitInputs(webAppAccess);
    webAppAccess.callMethod("GetCuentasWSDLCall.invoke");
    IXml results =  webAppAccess.getVariables().getXml("GetCuentasWSDLCall_reply");
    GetCuentasSOSetResults(webAppAccess, results);
}


/**
 * Generated Method [GetCuentasSOSetResults]
 */
public void GetCuentasSOSetResults(WebAppAccess webAppAccess, IXml operationResults)
{
    IXml results = operationResults;
    webAppAccess.getVariables().setXml("GetCuentasSOResults", results);
}


/**
 * Generated Method [getUserId]
 */
public String getUserId(WebAppAccess webAppAccess)
{ 
	return webAppAccess.getUserInfo().getUserID(); 
}

/**
 * Generated Method [getCuentasServiceGetCuentasSOTestMethod]
 */
public IXml getCuentasServiceGetCuentasSOTestMethod(WebAppAccess webAppAccess)
{
    webAppAccess.callMethod("GetCuentasSOExecute");
    IXml data = webAppAccess.getVariables().getXml("GetCuentasSOResults");
    data = ServiceTestHelper.getData(data);
    ServiceTestHelper.cleanSampleData(data);
    return data;
}

/**
 * Generated Method [getCuentasServiceGetCuentasSO_InputPage_SaveData]
 */
public void getCuentasServiceGetCuentasSO_InputPage_SaveData(WebAppAccess webAppAccess)
{
  String str;
  boolean performValidation;
  Variables variables = webAppAccess.getVariables();
  IInputFieldFormatter formatter;
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("getCuentasServiceGetCuentasSO_InputPageError");
    errors.clear();

    {
        IXml GetCuentasSOInputs = variables.getXml("GetCuentasSOInputs");
        if (GetCuentasSOInputs == null) {
            GetCuentasSOInputs = XmlUtil.create("operation1");
            variables.setXml("GetCuentasSOInputs", GetCuentasSOInputs);
        }
        
            str = webAppAccess.getRequestInputs().getInputValue("id_cliente");
            GetCuentasSOInputs.setText("id_cliente", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("id_tipo_cuenta");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional integer"))
              errors.addMessage("id_tipo_cuenta", formatter.getErrorMessage());
            GetCuentasSOInputs.setText("id_tipo_cuenta", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("fecha_mayor_a");
            GetCuentasSOInputs.setText("fecha_mayor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("fecha_menor_a");
            GetCuentasSOInputs.setText("fecha_menor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("saldo_mayor_a");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional Floating Point Number"))
              errors.addMessage("saldo_mayor_a", formatter.getErrorMessage());
            GetCuentasSOInputs.setText("saldo_mayor_a", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("saldo_menor_a");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional Floating Point Number"))
              errors.addMessage("saldo_menor_a", formatter.getErrorMessage());
            GetCuentasSOInputs.setText("saldo_menor_a", str);
    
        variables.getVariable("GetCuentasSOInputs").notifyValueChanged();
    }
}

/**
 * Generated Method [_init_getCuentasServiceGetCuentasSO_InputPageError]
 */
public com.bowstreet.builderutilities.PageAutomationMessages _init_getCuentasServiceGetCuentasSO_InputPageError(WebAppAccess webAppAccess)
{
    PageAutomationMessages result = new PageAutomationMessages();

    result.setReadableName("id_cliente", "Id Cliente");
    result.setReadableName("id_tipo_cuenta", "Id Tipo Cuenta");
    result.setReadableName("fecha_mayor_a", "Fecha Mayor A");
    result.setReadableName("fecha_menor_a", "Fecha Menor A");
    result.setReadableName("saldo_mayor_a", "Saldo Mayor A");
    result.setReadableName("saldo_menor_a", "Saldo Menor A");

    return result;
}

/**
 * Generated Method [clear_getCuentasServiceGetCuentasSO_InputPage_Errors]
 */
public void clear_getCuentasServiceGetCuentasSO_InputPage_Errors(WebAppAccess webAppAccess)
{
  webAppAccess.callMethod("getCuentasServiceGetCuentasSO_InputPageError.clear");
}

/**
 * Generated Method [getCuentasServiceGetCuentasSO_InputPage_NextAction]
 */
public void getCuentasServiceGetCuentasSO_InputPage_NextAction(WebAppAccess webAppAccess)
{
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("getCuentasServiceGetCuentasSO_InputPageError");
    String action = errors.getForceAction();
    if (action != null)
        webAppAccess.processAction(action);
    else    if (errors.hasMessages())
        webAppAccess.processAction("getCuentasServiceGetCuentasSO_InputPage");
    else
        webAppAccess.processAction("getCuentasServiceGetCuentasSO_ShowResults");
}

/**
 * Generated ActionList [getCuentasServiceGetCuentasSO_ShowResults]
 */
public Object getCuentasServiceGetCuentasSO_ShowResults(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: GetCuentasSOExecute
    returnValue = webAppAccess.callMethod("GetCuentasSOExecute", new Object[] {  });

    // Line 2: getCuentasServiceGetCuentasSO_ViewPage
    returnValue = webAppAccess.processAction("getCuentasServiceGetCuentasSO_ViewPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [getCuentasServiceGetCuentasSOGotoOperation]
 */
public Object getCuentasServiceGetCuentasSOGotoOperation(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    returnValue = webAppAccess.processAction("getCuentasServiceGetCuentasSO_InputPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [main]
 */
public Object main(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    returnValue = webAppAccess.processAction("getCuentasServiceIndexPage");
    return (Object)returnValue;
}



}
