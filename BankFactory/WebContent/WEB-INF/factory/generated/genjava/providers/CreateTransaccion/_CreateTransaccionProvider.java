/**
 * Title:        _CreateTransaccionProvider
 *
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006, 2007. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * Description:  Generated methods class for IBM Web Experience Factory application.
 *
 * This code was automatically generated at 12:03:24 PM on Apr 15, 2015
 * by the IBM Web Experience Factory -- do not edit manually.
 * Generated using the following Profiles - Not Profiled.
 *
 */
package genjava.providers.CreateTransaccion;


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
public class _CreateTransaccionProvider  implements IExemplar
{

/**
 * Creates a new instance of this class
 */
public Object newInstance()
{
   return new _CreateTransaccionProvider();
}

/*begin*/
/**
 * Generated Method [CreateTransaccionWSDLCallOnLoadHandler]
 */
public void CreateTransaccionWSDLCallOnLoadHandler(WebAppAccess webAppAccess)
{
  // This method is an OnModelLoad event handler, and it's how we make sure 
  // that every user (every session thread) gets their own unique 
  // service call LJO so it can be stateful - so runtime code can call 
  // setTimeout etc and the object can hold the value safely until 
  // the invoke is called. Instantiating the LJO in the regen would mean 
  // that it would have to be stateless since there would be one instance 
  // shared by all users of that profile. 
  com.bowstreet.builders.webapp.methods.ServiceCallMethods helper = new com.bowstreet.builders.webapp.methods.ServiceCallMethods();
  helper.init( webAppAccess, "CreateTransaccionWSDLCall_data", "CreateTransaccionWSDLCall_reply", "CreateTransaccionWSDLCall_replyHeaders");
  com.bowstreet.webapp.Variable ljo = webAppAccess.getVariables().getVariable("CreateTransaccionWSDLCall");
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
    return webAppAccess.getVariables().getObject("CreateTransaccionWSDLCall_arg1_operation1Parameters");
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
 * Generated Method [CreateTransaccionInitInputs]
 */
public void CreateTransaccionInitInputs(WebAppAccess webAppAccess)
{
    IXml data = webAppAccess.getVariables().getXml("CreateTransaccionInputs");
    IXml inputs = webAppAccess.getVariables().getXml("CreateTransaccionTargetInputStructure");
    webAppAccess.getVariables().setXml("CreateTransaccionWSDLCall_arg1_operation1Parameters", data);
    if (data!=null) {
        	XmlUtil.copyElementContents(data,inputs);
    }
}


/**
 * Generated Method [CreateTransaccionExecute]
 */
public void CreateTransaccionExecute(WebAppAccess webAppAccess)
{
    CreateTransaccionInitInputs(webAppAccess);
    webAppAccess.callMethod("CreateTransaccionWSDLCall.invoke");
    IXml results =  webAppAccess.getVariables().getXml("CreateTransaccionWSDLCall_reply");
    CreateTransaccionSetResults(webAppAccess, results);
}


/**
 * Generated Method [CreateTransaccionSetResults]
 */
public void CreateTransaccionSetResults(WebAppAccess webAppAccess, IXml operationResults)
{
    IXml results = operationResults;
    webAppAccess.getVariables().setXml("CreateTransaccionResults", results);
}


/**
 * Generated Method [createTransacccionServiceCreateTransaccionTestMethod]
 */
public IXml createTransacccionServiceCreateTransaccionTestMethod(WebAppAccess webAppAccess)
{
    webAppAccess.callMethod("CreateTransaccionExecute");
    IXml data = webAppAccess.getVariables().getXml("CreateTransaccionResults");
    data = ServiceTestHelper.getData(data);
    ServiceTestHelper.cleanSampleData(data);
    return data;
}

/**
 * Generated Method [createTransacccionServiceCreateTransaccion_InputPage_SaveData]
 */
public void createTransacccionServiceCreateTransaccion_InputPage_SaveData(WebAppAccess webAppAccess)
{
  String str;
  boolean performValidation;
  Variables variables = webAppAccess.getVariables();
  IInputFieldFormatter formatter;
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("createTransacccionServiceCreateTransaccion_InputPageError");
    errors.clear();

    {
        IXml CreateTransaccionInputs = variables.getXml("CreateTransaccionInputs");
        if (CreateTransaccionInputs == null) {
            CreateTransaccionInputs = XmlUtil.create("operation1");
            variables.setXml("CreateTransaccionInputs", CreateTransaccionInputs);
        }
        
            str = webAppAccess.getRequestInputs().getInputValue("id_cuenta_origen");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional integer"))
              errors.addMessage("id_cuenta_origen", formatter.getErrorMessage());
            CreateTransaccionInputs.setText("id_cuenta_origen", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("numero_cuenta_destino");
            CreateTransaccionInputs.setText("numero_cuenta_destino", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("id_tipo_transaccion");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional integer"))
              errors.addMessage("id_tipo_transaccion", formatter.getErrorMessage());
            CreateTransaccionInputs.setText("id_tipo_transaccion", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("monto_transferido");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional Floating Point Number"))
              errors.addMessage("monto_transferido", formatter.getErrorMessage());
            CreateTransaccionInputs.setText("monto_transferido", str);
    
        variables.getVariable("CreateTransaccionInputs").notifyValueChanged();
    }
}

/**
 * Generated Method [_init_createTransacccionServiceCreateTransaccion_InputPageError]
 */
public com.bowstreet.builderutilities.PageAutomationMessages _init_createTransacccionServiceCreateTransaccion_InputPageError(WebAppAccess webAppAccess)
{
    PageAutomationMessages result = new PageAutomationMessages();

    result.setReadableName("id_cuenta_origen", "Id Cuenta Origen");
    result.setReadableName("numero_cuenta_destino", "Numero Cuenta Destino");
    result.setReadableName("id_tipo_transaccion", "Id Tipo Transaccion");
    result.setReadableName("monto_transferido", "Monto Transferido");

    return result;
}

/**
 * Generated Method [clear_createTransacccionServiceCreateTransaccion_InputPage_Errors]
 */
public void clear_createTransacccionServiceCreateTransaccion_InputPage_Errors(WebAppAccess webAppAccess)
{
  webAppAccess.callMethod("createTransacccionServiceCreateTransaccion_InputPageError.clear");
}

/**
 * Generated Method [createTransacccionServiceCreateTransaccion_InputPage_NextAction]
 */
public void createTransacccionServiceCreateTransaccion_InputPage_NextAction(WebAppAccess webAppAccess)
{
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("createTransacccionServiceCreateTransaccion_InputPageError");
    String action = errors.getForceAction();
    if (action != null)
        webAppAccess.processAction(action);
    else    if (errors.hasMessages())
        webAppAccess.processAction("createTransacccionServiceCreateTransaccion_InputPage");
    else
        webAppAccess.processAction("createTransacccionServiceCreateTransaccion_ShowResults");
}

/**
 * Generated ActionList [createTransacccionServiceCreateTransaccion_ShowResults]
 */
public Object createTransacccionServiceCreateTransaccion_ShowResults(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: CreateTransaccionExecute
    returnValue = webAppAccess.callMethod("CreateTransaccionExecute", new Object[] {  });

    // Line 2: createTransacccionServiceCreateTransaccion_ViewPage
    returnValue = webAppAccess.processAction("createTransacccionServiceCreateTransaccion_ViewPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [createTransacccionServiceCreateTransaccionGotoOperation]
 */
public Object createTransacccionServiceCreateTransaccionGotoOperation(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    returnValue = webAppAccess.processAction("createTransacccionServiceCreateTransaccion_InputPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [main]
 */
public Object main(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    returnValue = webAppAccess.processAction("createTransacccionServiceIndexPage");
    return (Object)returnValue;
}



}
