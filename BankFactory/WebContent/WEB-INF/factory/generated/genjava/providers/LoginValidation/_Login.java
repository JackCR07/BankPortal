/**
 * Title:        _Login
 *
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006, 2007. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * Description:  Generated methods class for IBM Web Experience Factory application.
 *
 * This code was automatically generated at 11:24:45 AM on Apr 15, 2015
 * by the IBM Web Experience Factory -- do not edit manually.
 * Generated using the following Profiles - Not Profiled.
 *
 */
package genjava.providers.loginValidation;


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
public class _Login  implements IExemplar
{

/**
 * Creates a new instance of this class
 */
public Object newInstance()
{
   return new _Login();
}

/*begin*/
/**
 * Generated Method [LoginCallOnLoadHandler]
 */
public void LoginCallOnLoadHandler(WebAppAccess webAppAccess)
{
  // This method is an OnModelLoad event handler, and it's how we make sure 
  // that every user (every session thread) gets their own unique 
  // service call LJO so it can be stateful - so runtime code can call 
  // setTimeout etc and the object can hold the value safely until 
  // the invoke is called. Instantiating the LJO in the regen would mean 
  // that it would have to be stateless since there would be one instance 
  // shared by all users of that profile. 
  com.bowstreet.builders.webapp.methods.ServiceCallMethods helper = new com.bowstreet.builders.webapp.methods.ServiceCallMethods();
  helper.init( webAppAccess, "LoginCall_data", "LoginCall_reply", "LoginCall_replyHeaders");
  com.bowstreet.webapp.Variable ljo = webAppAccess.getVariables().getVariable("LoginCall");
  ljo.setValue(helper);
}


/**
 * Generated Method [_IRResolver_1]
 */
public Object _IRResolver_1(WebAppAccess webAppAccess)
{
    return "http://172.16.11.225:7800/LoginValidation/LoginValidation";
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
    return "http://LoginValidation";
}

/**
 * Generated Method [_IRResolver_5]
 */
public Object _IRResolver_5(WebAppAccess webAppAccess)
{
    return "http://LoginValidation/operation1";
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
    return webAppAccess.getVariables().getObject("LoginCall_arg1_operation1Parameters");
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
 * Generated Method [LoginValidationInitInputs]
 */
public void LoginValidationInitInputs(WebAppAccess webAppAccess)
{
    IXml data = webAppAccess.getVariables().getXml("LoginValidationInputs");
    IXml inputs = webAppAccess.getVariables().getXml("LoginValidationTargetInputStructure");
    webAppAccess.getVariables().setXml("LoginCall_arg1_operation1Parameters", data);
    if (data!=null) {
        	XmlUtil.copyElementContents(data,inputs);
    }
}


/**
 * Generated Method [LoginValidationExecute]
 */
public void LoginValidationExecute(WebAppAccess webAppAccess)
{
    LoginValidationInitInputs(webAppAccess);
    webAppAccess.callMethod("LoginCall.invoke");
    IXml results =  webAppAccess.getVariables().getXml("LoginCall_reply");
    LoginValidationSetResults(webAppAccess, results);
}


/**
 * Generated Method [LoginValidationSetResults]
 */
public void LoginValidationSetResults(WebAppAccess webAppAccess, IXml operationResults)
{
    IXml results = operationResults;
    webAppAccess.getVariables().setXml("LoginValidationResults", results);
}


/**
 * Generated Method [loginLoginValidationTestMethod]
 */
public IXml loginLoginValidationTestMethod(WebAppAccess webAppAccess)
{
    webAppAccess.callMethod("LoginValidationExecute");
    IXml data = webAppAccess.getVariables().getXml("LoginValidationResults");
    data = ServiceTestHelper.getData(data);
    ServiceTestHelper.cleanSampleData(data);
    return data;
}

/**
 * Generated Method [loginLoginValidation_InputPage_SaveData]
 */
public void loginLoginValidation_InputPage_SaveData(WebAppAccess webAppAccess)
{
  String str;
  boolean performValidation;
  Variables variables = webAppAccess.getVariables();
  IInputFieldFormatter formatter;
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("loginLoginValidation_InputPageError");
    errors.clear();

    {
        IXml LoginValidationInputs = variables.getXml("LoginValidationInputs");
        if (LoginValidationInputs == null) {
            LoginValidationInputs = XmlUtil.create("operation1");
            variables.setXml("LoginValidationInputs", LoginValidationInputs);
        }
        
            str = webAppAccess.getRequestInputs().getInputValue("idUsuario");
            LoginValidationInputs.setText("idUsuario", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("password");
            LoginValidationInputs.setText("password", str);
    
        variables.getVariable("LoginValidationInputs").notifyValueChanged();
    }
}

/**
 * Generated Method [_init_loginLoginValidation_InputPageError]
 */
public com.bowstreet.builderutilities.PageAutomationMessages _init_loginLoginValidation_InputPageError(WebAppAccess webAppAccess)
{
    PageAutomationMessages result = new PageAutomationMessages();

    result.setReadableName("idUsuario", "Id Usuario");
    result.setReadableName("password", "Password");

    return result;
}

/**
 * Generated Method [clear_loginLoginValidation_InputPage_Errors]
 */
public void clear_loginLoginValidation_InputPage_Errors(WebAppAccess webAppAccess)
{
  webAppAccess.callMethod("loginLoginValidation_InputPageError.clear");
}

/**
 * Generated Method [loginLoginValidation_InputPage_NextAction]
 */
public void loginLoginValidation_InputPage_NextAction(WebAppAccess webAppAccess)
{
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("loginLoginValidation_InputPageError");
    String action = errors.getForceAction();
    if (action != null)
        webAppAccess.processAction(action);
    else    if (errors.hasMessages())
        webAppAccess.processAction("loginLoginValidation_InputPage");
    else
        webAppAccess.processAction("loginLoginValidation_ShowResults");
}

/**
 * Generated ActionList [loginLoginValidation_ShowResults]
 */
public Object loginLoginValidation_ShowResults(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: LoginValidationExecute
    returnValue = webAppAccess.callMethod("LoginValidationExecute", new Object[] {  });

    // Line 2: loginLoginValidation_ViewPage
    returnValue = webAppAccess.processAction("loginLoginValidation_ViewPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [loginLoginValidationGotoOperation]
 */
public Object loginLoginValidationGotoOperation(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    returnValue = webAppAccess.processAction("loginLoginValidation_InputPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [main]
 */
public Object main(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    returnValue = webAppAccess.processAction("loginIndexPage");
    return (Object)returnValue;
}



}
