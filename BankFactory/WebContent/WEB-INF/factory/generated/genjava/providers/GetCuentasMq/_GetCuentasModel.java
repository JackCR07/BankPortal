/**
 * Title:        _GetCuentasModel
 *
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006, 2007. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * Description:  Generated methods class for IBM Web Experience Factory application.
 *
 * This code was automatically generated at 02:55:32 PM on May 19, 2015
 * by the IBM Web Experience Factory -- do not edit manually.
 * Generated using the following Profiles - Not Profiled.
 *
 */
package genjava.providers.GetCuentasMq;


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
public class _GetCuentasModel  implements IExemplar
{

/**
 * Creates a new instance of this class
 */
public Object newInstance()
{
   return new _GetCuentasModel();
}

/*begin*/
/**
 * Generated Method [getCuentasOInitInputs]
 */
public void getCuentasOInitInputs(WebAppAccess webAppAccess)
{
    IXml inputs = webAppAccess.getVariables().getXml("getCuentasOTargetInputStructure").cloneElement();
    IXml data = webAppAccess.getVariables().getXml("getCuentasOInputs");
    if (data == null) {
        data = XmlUtil.create("arguments");
    }
    inputs.setText("arg1", DataConverter.toString(webAppAccess.callMethod("getUserId")));
    inputs.setText("arg2", DataConverter.toString(data.getText("arg2")));
    inputs.setText("arg3", DataConverter.toString(data.getText("arg3")));
    inputs.setText("arg4", DataConverter.toString(data.getText("arg4")));
    inputs.setText("arg5", DataConverter.toString(data.getText("arg5")));
    inputs.setText("arg6", DataConverter.toString(data.getText("arg6")));
    webAppAccess.getVariables().setXml("getCuentasOCalledActionInputs", inputs);
}


/**
 * Generated Method [getCuentasOExecute]
 */
public void getCuentasOExecute(WebAppAccess webAppAccess)
{
    getCuentasOInitInputs(webAppAccess);
    IXml inputs = webAppAccess.getVariables().getXml("getCuentasOCalledActionInputs");
    IXml results = (IXml)webAppAccess.callMethod("mqConnectLJO.getMessageQueue", new Object[] {
        inputs.getText("arg1"), 
        DataConverter.toInteger(inputs.getText("arg2")), 
        inputs.getText("arg3"), 
        inputs.getText("arg4"), 
        inputs.getText("arg5"), 
        inputs.getText("arg6")
    } );
    getCuentasOSetResults(webAppAccess, results);
}


/**
 * Generated Method [getCuentasOSetResults]
 */
public void getCuentasOSetResults(WebAppAccess webAppAccess, IXml operationResults)
{
    IXml results = XmlUtil.create("operation1Response");
    if (operationResults == null) {
        operationResults = XmlUtil.create("data");
    }
    XmlUtil.copyAttributes(operationResults,results,false);
    for (Iterator iter = operationResults.getChildren().iterator(); iter.hasNext();) {
        IXml data = (IXml) iter.next();
        IXml resultRow = XmlUtil.create("cuenta");
        results.addChildElement(resultRow);
        resultRow.copyContent(data);
    }
    webAppAccess.getVariables().setXml("getCuentasOResults", results);
}


/**
 * Generated Method [getUserId]
 */
public String getUserId(WebAppAccess webAppAccess)
{ 
	//return webAppAccess.getUserInfo().getUserID(); 
	return "lprado"; 
}

/**
 * Generated Method [getCuentasMqServiceGetCuentasOTestMethod]
 */
public IXml getCuentasMqServiceGetCuentasOTestMethod(WebAppAccess webAppAccess)
{
    webAppAccess.callMethod("getCuentasOExecute");
    IXml data = webAppAccess.getVariables().getXml("getCuentasOResults");
    data = ServiceTestHelper.getData(data);
    ServiceTestHelper.cleanSampleData(data);
    return data;
}

/**
 * Generated Method [getCuentasMqServiceGetCuentasO_InputPage_SaveData]
 */
public void getCuentasMqServiceGetCuentasO_InputPage_SaveData(WebAppAccess webAppAccess)
{
  String str;
  boolean performValidation;
  Variables variables = webAppAccess.getVariables();
  IInputFieldFormatter formatter;
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("getCuentasMqServiceGetCuentasO_InputPageError");
    errors.clear();

    {
        IXml getCuentasOInputs = variables.getXml("getCuentasOInputs");
        if (getCuentasOInputs == null) {
            getCuentasOInputs = XmlUtil.create("arguments");
            variables.setXml("getCuentasOInputs", getCuentasOInputs);
        }
        
            str = webAppAccess.getRequestInputs().getInputValue("arg1");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Required String"))
              errors.addMessage("arg1", formatter.getErrorMessage());
            getCuentasOInputs.setText("arg1", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("arg2");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Required integer"))
              errors.addMessage("arg2", formatter.getErrorMessage());
            getCuentasOInputs.setText("arg2", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("arg3");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Required String"))
              errors.addMessage("arg3", formatter.getErrorMessage());
            getCuentasOInputs.setText("arg3", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("arg4");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Required String"))
              errors.addMessage("arg4", formatter.getErrorMessage());
            getCuentasOInputs.setText("arg4", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("arg5");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Required String"))
              errors.addMessage("arg5", formatter.getErrorMessage());
            getCuentasOInputs.setText("arg5", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("arg6");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Required String"))
              errors.addMessage("arg6", formatter.getErrorMessage());
            getCuentasOInputs.setText("arg6", str);
    
        variables.getVariable("getCuentasOInputs").notifyValueChanged();
    }
}

/**
 * Generated Method [_init_getCuentasMqServiceGetCuentasO_InputPageError]
 */
public com.bowstreet.builderutilities.PageAutomationMessages _init_getCuentasMqServiceGetCuentasO_InputPageError(WebAppAccess webAppAccess)
{
    PageAutomationMessages result = new PageAutomationMessages();

    result.setReadableName("arg1", "Arg1");
    result.setReadableName("arg2", "Arg2");
    result.setReadableName("arg3", "Arg3");
    result.setReadableName("arg4", "Arg4");
    result.setReadableName("arg5", "Arg5");
    result.setReadableName("arg6", "Arg6");

    return result;
}

/**
 * Generated Method [clear_getCuentasMqServiceGetCuentasO_InputPage_Errors]
 */
public void clear_getCuentasMqServiceGetCuentasO_InputPage_Errors(WebAppAccess webAppAccess)
{
  webAppAccess.callMethod("getCuentasMqServiceGetCuentasO_InputPageError.clear");
}

/**
 * Generated Method [getCuentasMqServiceGetCuentasO_InputPage_NextAction]
 */
public void getCuentasMqServiceGetCuentasO_InputPage_NextAction(WebAppAccess webAppAccess)
{
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("getCuentasMqServiceGetCuentasO_InputPageError");
    String action = errors.getForceAction();
    if (action != null)
        webAppAccess.processAction(action);
    else    if (errors.hasMessages())
        webAppAccess.processAction("getCuentasMqServiceGetCuentasO_InputPage");
    else
        webAppAccess.processAction("getCuentasMqServiceGetCuentasO_ShowResults");
}

/**
 * Generated ActionList [getCuentasMqServiceGetCuentasO_ShowResults]
 */
public Object getCuentasMqServiceGetCuentasO_ShowResults(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: getCuentasOExecute
    returnValue = webAppAccess.callMethod("getCuentasOExecute", new Object[] {  });

    // Line 2: getCuentasMqServiceGetCuentasO_ViewPage
    returnValue = webAppAccess.processAction("getCuentasMqServiceGetCuentasO_ViewPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [getCuentasMqServiceGetCuentasOGotoOperation]
 */
public Object getCuentasMqServiceGetCuentasOGotoOperation(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    returnValue = webAppAccess.processAction("getCuentasMqServiceGetCuentasO_InputPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [main]
 */
public Object main(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    returnValue = webAppAccess.processAction("getCuentasMqServiceIndexPage");
    return (Object)returnValue;
}



}
