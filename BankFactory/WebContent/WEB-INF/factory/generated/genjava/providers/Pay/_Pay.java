/**
 * Title:        _Pay
 *
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006, 2007. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * Description:  Generated methods class for IBM Web Experience Factory application.
 *
 * This code was automatically generated at 12:26:45 AM on Apr 30, 2015
 * by the IBM Web Experience Factory -- do not edit manually.
 * Generated using the following Profiles - Not Profiled.
 *
 */
package genjava.providers.Pay;


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
public class _Pay  implements IExemplar
{

/**
 * Creates a new instance of this class
 */
public Object newInstance()
{
   return new _Pay();
}

/*begin*/
/**
 * Generated Method [MensajeTransferencia]
 */
public String MensajeTransferencia(WebAppAccess webAppAccess, int res)
{ 
    if(res==0) 
    return "El pago se realiz\u00F3 satisfactoriamente"; 
    else if(res==-2) 
    return "El servicio no se encuentra disponible en estos momentos, intentelo mas tarde"; 
    else 
    return "La cuenta no tiene fondos suficientes"; 
/* Simple Code Samples - See help for further info 
Get a string variable value, 
String value = webAppAccess.getVariables().getString("MyVariable"); 
 
Set a string variable value, 
webAppAccess.getVariables().setString("MyVariable", "Value"); 
 
Call a method, 
webAppAccess.callMethod("MethodName", arg1, arg2); 
 
Execute service calls, 
webAppAccess.callMethod("ServiceCallName.invoke"); 
 
Process page inputs, 
webAppAccess.getRequestInputs().getInputValue("InputName"); 
 
Display a page, 
webAppAccess.processPage("PageName"); 
*/ 
}

/**
 * Generated Method [PayCallOnLoadHandler]
 */
public void PayCallOnLoadHandler(WebAppAccess webAppAccess)
{
  // This method is an OnModelLoad event handler, and it's how we make sure 
  // that every user (every session thread) gets their own unique 
  // service call LJO so it can be stateful - so runtime code can call 
  // setTimeout etc and the object can hold the value safely until 
  // the invoke is called. Instantiating the LJO in the regen would mean 
  // that it would have to be stateless since there would be one instance 
  // shared by all users of that profile. 
  com.bowstreet.builders.webapp.methods.ServiceCallMethods helper = new com.bowstreet.builders.webapp.methods.ServiceCallMethods();
  helper.init( webAppAccess, "PayCall_data", "PayCall_reply", "PayCall_replyHeaders");
  com.bowstreet.webapp.Variable ljo = webAppAccess.getVariables().getVariable("PayCall");
  ljo.setValue(helper);
}


/**
 * Generated Method [_IRResolver_1]
 */
public Object _IRResolver_1(WebAppAccess webAppAccess)
{
    return "http://172.16.11.225:7800/createTransaccion/createTransaccion";
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
    return "http://CreateTransaccion";
}

/**
 * Generated Method [_IRResolver_5]
 */
public Object _IRResolver_5(WebAppAccess webAppAccess)
{
    return "http://CreateTransaccion/operation1";
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
    return webAppAccess.getVariables().getObject("PayCall_arg1_operation1Parameters");
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
 * Generated Method [PayOperationInitInputs]
 */
public void PayOperationInitInputs(WebAppAccess webAppAccess)
{
    IXml inputs = webAppAccess.getVariables().getXml("PayOperationTargetInputStructure").cloneElement();
    IXml data = webAppAccess.getVariables().getXml("PayOperationInputs");
    if (data == null) {
        data = XmlUtil.create("operation1");
    }
    inputs.setText("id_cuenta_origen", DataConverter.toString(data.getText("id_cuenta_origen")));
    inputs.setText("numero_cuenta_destino", DataConverter.toString(data.getText("numero_cuenta_destino")));
    inputs.setText("id_tipo_transaccion", "1");
    inputs.setText("monto_transferido", DataConverter.toString(data.getText("monto_transferido")));
    webAppAccess.getVariables().setXml("PayCall_arg1_operation1Parameters", inputs);
}


/**
 * Generated Method [PayOperationExecute]
 */
public void PayOperationExecute(WebAppAccess webAppAccess)
{
    PayOperationInitInputs(webAppAccess);
    webAppAccess.callMethod("PayCall.invoke");
    IXml results =  webAppAccess.getVariables().getXml("PayCall_reply");
    PayOperationSetResults(webAppAccess, results);
}


/**
 * Generated Method [PayOperationSetResults]
 */
public void PayOperationSetResults(WebAppAccess webAppAccess, IXml operationResults)
{
    IXml results = XmlUtil.create("operation1Response");
    if (operationResults == null) {
        operationResults = XmlUtil.create("data");
    }
    XmlUtil.copyAttributes(operationResults,results,false);
    IXml data = operationResults;
    IXml tempData = null;
    results.setText("resultado", DataConverter.toString(webAppAccess.callMethod("MensajeTransferencia", new Object[] { DataConverter.toInteger(data.getText("resultado")) })));
    webAppAccess.getVariables().setXml("PayOperationResults", results);
}


/**
 * Generated Method [payModelPayOperationTestMethod]
 */
public IXml payModelPayOperationTestMethod(WebAppAccess webAppAccess)
{
    webAppAccess.callMethod("PayOperationExecute");
    IXml data = webAppAccess.getVariables().getXml("PayOperationResults");
    data = ServiceTestHelper.getData(data);
    ServiceTestHelper.cleanSampleData(data);
    return data;
}

/**
 * Generated Method [payModelPayOperation_InputPage_SaveData]
 */
public void payModelPayOperation_InputPage_SaveData(WebAppAccess webAppAccess)
{
  String str;
  boolean performValidation;
  Variables variables = webAppAccess.getVariables();
  IInputFieldFormatter formatter;
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("payModelPayOperation_InputPageError");
    errors.clear();

    {
        IXml PayOperationInputs = variables.getXml("PayOperationInputs");
        if (PayOperationInputs == null) {
            PayOperationInputs = XmlUtil.create("operation1");
            variables.setXml("PayOperationInputs", PayOperationInputs);
        }
        
            str = webAppAccess.getRequestInputs().getInputValue("id_cuenta_origen");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional integer"))
              errors.addMessage("id_cuenta_origen", formatter.getErrorMessage());
            PayOperationInputs.setText("id_cuenta_origen", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("numero_cuenta_destino");
            PayOperationInputs.setText("numero_cuenta_destino", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("id_tipo_transaccion");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional integer"))
              errors.addMessage("id_tipo_transaccion", formatter.getErrorMessage());
            PayOperationInputs.setText("id_tipo_transaccion", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("monto_transferido");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional Floating Point Number"))
              errors.addMessage("monto_transferido", formatter.getErrorMessage());
            PayOperationInputs.setText("monto_transferido", str);
    
        variables.getVariable("PayOperationInputs").notifyValueChanged();
    }
}

/**
 * Generated Method [_init_payModelPayOperation_InputPageError]
 */
public com.bowstreet.builderutilities.PageAutomationMessages _init_payModelPayOperation_InputPageError(WebAppAccess webAppAccess)
{
    PageAutomationMessages result = new PageAutomationMessages();

    result.setReadableName("id_cuenta_origen", "Id Cuenta Origen");
    result.setReadableName("numero_cuenta_destino", "Numero Cuenta Destino");
    result.setReadableName("id_tipo_transaccion", "Id Tipo Transaccion");
    result.setReadableName("monto_transferido", "Monto Transferido");

    return result;
}

/**
 * Generated Method [clear_payModelPayOperation_InputPage_Errors]
 */
public void clear_payModelPayOperation_InputPage_Errors(WebAppAccess webAppAccess)
{
  webAppAccess.callMethod("payModelPayOperation_InputPageError.clear");
}

/**
 * Generated Method [payModelPayOperation_InputPage_NextAction]
 */
public void payModelPayOperation_InputPage_NextAction(WebAppAccess webAppAccess)
{
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("payModelPayOperation_InputPageError");
    String action = errors.getForceAction();
    if (action != null)
        webAppAccess.processAction(action);
    else    if (errors.hasMessages())
        webAppAccess.processAction("payModelPayOperation_InputPage");
    else
        webAppAccess.processAction("payModelPayOperation_ShowResults");
}

/**
 * Generated ActionList [payModelPayOperation_ShowResults]
 */
public Object payModelPayOperation_ShowResults(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: PayOperationExecute
    returnValue = webAppAccess.callMethod("PayOperationExecute", new Object[] {  });

    // Line 2: payModelPayOperation_ViewPage
    returnValue = webAppAccess.processAction("payModelPayOperation_ViewPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [payModelPayOperationGotoOperation]
 */
public Object payModelPayOperationGotoOperation(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    returnValue = webAppAccess.processAction("payModelPayOperation_InputPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [main]
 */
public Object main(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    returnValue = webAppAccess.processAction("payModelIndexPage");
    return (Object)returnValue;
}



}
