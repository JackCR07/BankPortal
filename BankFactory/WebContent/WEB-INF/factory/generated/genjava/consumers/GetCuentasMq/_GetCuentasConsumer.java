/**
 * Title:        _GetCuentasConsumer
 *
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006, 2007. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * Description:  Generated methods class for IBM Web Experience Factory application.
 *
 * This code was automatically generated at 02:55:35 PM on May 19, 2015
 * by the IBM Web Experience Factory -- do not edit manually.
 * Generated using the following Profiles - 
 {
  { mobile_devicetype_base : Default  }
 }
 *
 */
package genjava.consumers.GetCuentasMq;


/* begin method imports */
import com.bowstreet.builders.webapp.methods.*;
import com.bowstreet.builders.webapp.methods.DataRetriever;
import com.bowstreet.builders.webapp.methods.PagingAssistant;
import com.bowstreet.builders.webapp.methods.WebAppAccessConsumer;
import com.bowstreet.builders.webapp.pageautomation.StandardFormatter;
import com.bowstreet.builders.webapp.ServiceConsumer2DataHelper;
import com.bowstreet.builderutilities.PageAutomationMessages;
import com.bowstreet.builderutilities.PageAutomationRuntime;
import com.bowstreet.methods.adapters.events.PropertyBrokerManager;
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
import com.bowstreet.webapp.engine.WebAppRuntimeException;
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
public class _GetCuentasConsumer  implements IExemplar
{

/**
 * Creates a new instance of this class
 */
public Object newInstance()
{
   return new _GetCuentasConsumer();
}

/*begin*/
/**
 * Generated Method [GetCuentasServiceGetCuentasO]
 */
public IXml GetCuentasServiceGetCuentasO(WebAppAccess webAppAccess)
{
//	The following webapp variables should be populated prior to invoking this method.
//	GetCuentasServiceGetCuentasOInputs

	Object result = webAppAccess.callMethod("GetCuentasService.executeOperation", "getCuentasO", Boolean.FALSE );
	if (result instanceof WebAppAccessConsumer) {
		((WebAppAccessConsumer)result).setWebAppAccess(webAppAccess);
	}
	return (IXml)result;
}


/**
 * Generated Method [GetCuentasServiceGetCuentasOWithArgs]
 */
public IXml GetCuentasServiceGetCuentasOWithArgs(WebAppAccess webAppAccess, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6)
{
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetCuentasServiceGetCuentasOInputs/arguments/arg1", arg1, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetCuentasServiceGetCuentasOInputs/arguments/arg2", arg2, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetCuentasServiceGetCuentasOInputs/arguments/arg3", arg3, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetCuentasServiceGetCuentasOInputs/arguments/arg4", arg4, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetCuentasServiceGetCuentasOInputs/arguments/arg5", arg5, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"GetCuentasServiceGetCuentasOInputs/arguments/arg6", arg6, false );
	Object result = webAppAccess.callMethod("GetCuentasService.executeOperation", "getCuentasO", Boolean.TRUE );
	if (result instanceof WebAppAccessConsumer) {
		((WebAppAccessConsumer)result).setWebAppAccess(webAppAccess);
	}
	return (IXml)result;
}


/**
 * Generated Method [GetCuentasService_createHelper]
 */
public Object GetCuentasService_createHelper(WebAppAccess webAppAccess)
{
    com.bowstreet.builders.webapp.ServiceConsumer2DataHelper helper = new com.bowstreet.builders.webapp.ServiceConsumer2DataHelper();
    helper.setName("GetCuentasService");
    return helper;
}

/**
 * Generated Method [GetCuentasServiceView_Paging_createHelper]
 */
public com.bowstreet.builders.webapp.methods.PagingAssistant GetCuentasServiceView_Paging_createHelper(WebAppAccess webAppAccess)
{
    com.bowstreet.builders.webapp.methods.PagingAssistant asst;
    asst = new com.bowstreet.builders.webapp.methods.PagingAssistant();
    asst.preserveLocation(false);
    asst.setName("GetCuentasServiceView_Paging");
    asst.setTopLevelTagName("operation1Response");
    asst.reset(webAppAccess);
    int rowsPerPage;
    try { rowsPerPage = DataConverter.toInteger("5").intValue(); }
    catch (Exception badValue) { rowsPerPage = 1; }
    asst.setRowsPerPage(rowsPerPage);
    return asst;
}

/**
 * Generated Method [GetCuentasServiceView_Paging_createRetriever]
 */
public DataRetriever GetCuentasServiceView_Paging_createRetriever(WebAppAccess webAppAccess)
{
    DataRetriever dr = (DataRetriever)PagingAssistant.findDataRetriever(webAppAccess, webAppAccess.getVariables().getObject("GetCuentasServiceGetCuentasOResults"), true, true);

    return dr;
}

/**
 * Generated Method [GetCuentasServiceView_Paging_CreateHelper]
 */
public com.bowstreet.builders.webapp.methods.PagingLinks GetCuentasServiceView_Paging_CreateHelper(WebAppAccess webAppAccess)
{
    PagingAssistant asst;
    asst = (PagingAssistant)webAppAccess.getVariables().getObject("GetCuentasServiceView_Paging");
    PagingLinks lnks = new PagingLinks(asst);
    lnks.setMaxLinks(DataConverter.toInteger("5").intValue());
    return lnks;
}

/**
 * Generated Method [tipoCuentasGetXmlData]
 */
public IXml tipoCuentasGetXmlData(WebAppAccess webAppAccess)
{
  // Extract the XML content, if any.  Otherwise ignore the content.
  final Object content = webAppAccess.getVariables().getObject("tipoCuentasXmlData");
  return (content instanceof IXml) ? (IXml) tipoCuentasFilterXml( webAppAccess, (IXml) content ) : null;
}


/**
 * Generated Method [tipoCuentasGetValueTagName]
 */
public String tipoCuentasGetValueTagName(WebAppAccess webAppAccess)
{
  return "Value";
}

/**
 * Generated Method [tipoCuentasGetLabelTagName]
 */
public String tipoCuentasGetLabelTagName(WebAppAccess webAppAccess)
{
  return "Label";
}

/**
 * Generated Method [tipoCuentasGetParentTagName]
 */
public String tipoCuentasGetParentTagName(WebAppAccess webAppAccess)
{
  return "UserAddition";
}

/**
 * Generated Method [tipoCuentasToLabel]
 */
public String tipoCuentasToLabel(WebAppAccess webAppAccess, String value)
{
  if (value == null) return null;
  String label = null;

  try
  {
    // Get the tag names that identify the value and label elements
    // in the source data XML.
    final String valueTagName = tipoCuentasGetValueTagName(webAppAccess);
    final String labelTagName = tipoCuentasGetLabelTagName(webAppAccess);

    // Setup the XPATH expresion that is used to find the label that
    // corresponds to the given value.
    final String xPath = "//[" + valueTagName + "='" + value + "']";

    // Get any additional data from the XML variable.  This variable
    // is either provided by the modeller directly or is created from
    // the additional data input of the lookup table builder.
    final IXml additionalDataXml = DataConverter.toIXml(webAppAccess.getVariables().getObject("tipoCuentasAdditionalXmlData"));
    String labelFromAdditionalData = null;

    if( additionalDataXml != null )
    {
      // Look for an override label in the additional data.  If a parent
      // element was found see if it specifies an override (the default
      // behavior when the collision resolution is not specified).

      final IXml element = additionalDataXml.findElement( xPath );
      final IXml parent = ( element == null ) ? null : element.getParentElement();

      if( parent != null )
      {
        // Save the label just in case we need to use it as a default
        // below (when the main lookup table does not contain a reference).
        labelFromAdditionalData = parent.getText( labelTagName );

        final String collisionResolution = parent.getText( "CollisionResolution" );
        final boolean performOverride = collisionResolution == null || "UseThisValue".equals( collisionResolution );
        label = ( performOverride ) ? labelFromAdditionalData : null;
      }
    }

    if( label == null )
    {
      // There was no override label in the additional data, so get
      // the main lookup table data and see if there is a match.

      final IXml lookupTable = (IXml) webAppAccess.callMethod( "tipoCuentasGetXmlData" );

      if( lookupTable != null )
      {
        final IXml element = lookupTable.findElement( xPath );
        final IXml parent = ( element == null ) ? null : element.getParentElement();
        label = ( parent == null ) ? null : parent.getText( labelTagName );
      }
    }

    // If there was no match in the main lookup table then go back
    // to the additional data.  If a match was found previously,
    // then use this as the default for the label.
    if( label == null && labelFromAdditionalData != null )
      label = labelFromAdditionalData;
  }
  catch( Throwable t )
  {
    throw new WebAppRuntimeException( t );
  }

  return label;
}


/**
 * Generated Method [tipoCuentasToValue]
 */
public String tipoCuentasToValue(WebAppAccess webAppAccess, String label)
{
  if (label == null) return null;
  String value = null;

  try
  {
    // Get the tag names that identify the value and label elements
    // in the source data XML.
    final String valueTagName = tipoCuentasGetValueTagName(webAppAccess);
    final String labelTagName = tipoCuentasGetLabelTagName(webAppAccess);

    // Setup the XPATH expresion that is used to find the value that
    // corresponds to the given label.
    final String xPath = "//[" + labelTagName + "='" + label + "']";

    // Get any additional data from the XML variable.  This variable
    // is either provided by the modeller directly or is created from
    // the additional data input of the lookup table builder.
    final IXml additionalDataXml = DataConverter.toIXml(webAppAccess.getVariables().getObject("tipoCuentasAdditionalXmlData"));
    String valueFromAdditionalData = null;

    if( additionalDataXml != null )
    {
      // Look for an override value in the additional data.  If a parent
      // element was found see if it specifies an override (the default
      // behavior when the collision resolution is not specified).

      final IXml element = additionalDataXml.findElement( xPath );
      final IXml parent = ( element == null ) ? null : element.getParentElement();

      if( parent != null )
      {
        // Save the value just in case we need to use it as a default
        // below (when the main lookup table does not contain a reference).
        valueFromAdditionalData = parent.getText( valueTagName );

        final String collisionResolution = parent.getText( "CollisionResolution" );
        final boolean performOverride = collisionResolution == null || "UseThisValue".equals( collisionResolution );
        value = ( performOverride ) ? valueFromAdditionalData : null;
      }
    }

    if( value == null )
    {
      // There was no override value in the additional data, so get
      // the main lookup table data and see if there is a match.

      final IXml lookupTable = (IXml) webAppAccess.callMethod( "tipoCuentasGetXmlData" );

      if( lookupTable != null )
      {
        final IXml element = lookupTable.findElement( xPath );
        final IXml parent = ( element == null ) ? null : element.getParentElement();
        value = ( parent == null ) ? null : parent.getText( valueTagName );
      }
    }

    // If there was no match in the main lookup table then go back
    // to the additional data.  If a match was found previously,
    // then use this as the default for the value.
    if( value == null && valueFromAdditionalData != null )
      value = valueFromAdditionalData;
  }
  catch( Throwable t )
  {
    throw new WebAppRuntimeException( t );
  }

  return value;
}


/**
 * Generated Method [tipoCuentasFilterXml]
 */
public IXml tipoCuentasFilterXml(WebAppAccess webAppAccess, IXml data)
{
  String labelTag = tipoCuentasGetLabelTagName(webAppAccess);
  String valueTag = tipoCuentasGetValueTagName(webAppAccess);
  if (StringUtil.isEmpty(labelTag) || StringUtil.isEmpty(valueTag))
    return data;
  data = data.cloneElement();
  java.util.List rows = data.getChildren();
  for (int i = 0; i < rows.size(); i++)
  {
    IXml row = (IXml)rows.get(i);
    if (row.findElement(valueTag) == null || row.findElement(labelTag) == null)
        data.removeChildElement(row);
  }  return data;
}

/**
 * Generated Method [tipoCuentasGetLookupTable]
 */
public IXml tipoCuentasGetLookupTable(WebAppAccess webAppAccess)
{
  // Fetch the content of the main lookup table.  If no main table
  // exists, then create an empty one as a default.
  IXml lookupTable = (IXml) webAppAccess.callMethod( "tipoCuentasGetXmlData" );
  lookupTable = (lookupTable == null) ? XmlUtil.create( "LookupTable" ) : lookupTable.cloneElement();

  // Get any additional data from the XML variable.  This variable
  // is either provided by the modeller directly or is created from
  // the additional data input of the lookup table builder.
  final IXml additionalDataXml = DataConverter.toIXml(webAppAccess.getVariables().getObject("tipoCuentasAdditionalXmlData"));

  if( additionalDataXml != null )
  {
    // Get the tag names that identify the value and label elements
    // in the source data XML.
    final String valueTagName = tipoCuentasGetValueTagName(webAppAccess);
    final String labelTagName = tipoCuentasGetLabelTagName(webAppAccess);
    final String parentTagName = tipoCuentasGetParentTagName(webAppAccess);

    // Setup the XPATH prefix expresion that is used to find values in
    // the lookup table XML.
    final String xPathPrefix = "//[" + valueTagName + "='";

    // Find the first original value/label pair in the table.
    final IXml firstOriginalPair = lookupTable.getFirstChildElement();

    for( Iterator children = additionalDataXml.getChildren().iterator(); children.hasNext(); )
    {
      final IXml child = (IXml) children.next();
      final String value = child.getText( valueTagName );
      final String label = child.getText( labelTagName );
      final String collisionResolution = child.getText( "CollisionResolution" );
      final boolean performOverride = collisionResolution == null || "UseThisValue".equals( collisionResolution );

      // Search for the value in the main lookup table.
      final IXml element = lookupTable.findElement( xPathPrefix + value + "']" );
      final IXml parent = ( element == null ) ? null : element.getParentElement();

      if( parent == null )
      {
        // The value does not exist in the main lookup table so
        // we will need to merge it and put the new pair either at
        // the front or back.

        if( true )
        {
          // Add the new value/label pair at the front of the table
          // because one was not found in the main lookup table.
          final IXml newPair = XmlUtil.create( parentTagName );
          newPair.addChildWithText( valueTagName, value );
          newPair.addChildWithText( labelTagName, label );
          lookupTable.insertBefore( newPair, firstOriginalPair );
        }
        else
        {
          // Add the new value/label pair at the back of the table
          // because one was not found in the main lookup table.
          final IXml newPair = lookupTable.addChildElement( parentTagName );
          newPair.addChildWithText( valueTagName, value );
          newPair.addChildWithText( labelTagName, label );
        }
      }
      else if( performOverride )
      {
        // The value exists in the main lookup table and it is marked
        // to override any original label, so merge the new value and
        // label in-place.
        parent.setText( labelTagName, label );
      }
    }
  }

  return lookupTable;
}


/**
 * Generated Method [pbAction_Source]
 */
public void pbAction_Source(WebAppAccess webAppAccess, String actionName, String numero_cuenta)
{
        PropertyBrokerManager.fireEvent(webAppAccess, "numero_cuenta", null, numero_cuenta);
        webAppAccess.processPage(webAppAccess.getCurrentPage());
}


/**
 * Generated Method [GetCuentasServiceView_InputPage_SaveData]
 */
public void GetCuentasServiceView_InputPage_SaveData(WebAppAccess webAppAccess)
{
  String str;
  boolean performValidation;
  Variables variables = webAppAccess.getVariables();
  IInputFieldFormatter formatter;
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("GetCuentasServiceView_InputPageError");
    errors.clear();

    {
        IXml GetCuentasServiceGetCuentasOInputs = variables.getXml("GetCuentasServiceGetCuentasOInputs");
        if (GetCuentasServiceGetCuentasOInputs == null) {
            GetCuentasServiceGetCuentasOInputs = XmlUtil.create("arguments");
            variables.setXml("GetCuentasServiceGetCuentasOInputs", GetCuentasServiceGetCuentasOInputs);
        }
        
            str = webAppAccess.getRequestInputs().getInputValue("arg2");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Required String"))
              errors.addMessage("arg2", formatter.getErrorMessage());
            GetCuentasServiceGetCuentasOInputs.setText("arg2", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("arg3");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional Date(yyyy-MM-dd)"))
              errors.addMessage("arg3", formatter.getErrorMessage());
            GetCuentasServiceGetCuentasOInputs.setText("arg3", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("arg4");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Optional Date(yyyy-MM-dd)"))
              errors.addMessage("arg4", formatter.getErrorMessage());
            GetCuentasServiceGetCuentasOInputs.setText("arg4", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("arg5");
            GetCuentasServiceGetCuentasOInputs.setText("arg5", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("arg6");
            GetCuentasServiceGetCuentasOInputs.setText("arg6", str);
    
        variables.getVariable("GetCuentasServiceGetCuentasOInputs").notifyValueChanged();
    }
}

/**
 * Generated Method [_init_GetCuentasServiceView_InputPageError]
 */
public com.bowstreet.builderutilities.PageAutomationMessages _init_GetCuentasServiceView_InputPageError(WebAppAccess webAppAccess)
{
    PageAutomationMessages result = new PageAutomationMessages();

    result.setReadableName("arg1", "Id Cliente");
    result.setReadableName("arg2", "Tipo de Cuenta");
    result.setReadableName("arg3", "Fecha Desde");
    result.setReadableName("arg4", "Fecha Hasta");
    result.setReadableName("arg5", "Saldo Inferior");
    result.setReadableName("arg6", "Saldo Superior");

    return result;
}

/**
 * Generated Method [clear_GetCuentasServiceView_InputPage_Errors]
 */
public void clear_GetCuentasServiceView_InputPage_Errors(WebAppAccess webAppAccess)
{
  webAppAccess.callMethod("GetCuentasServiceView_InputPageError.clear");
}

/**
 * Generated Method [GetCuentasServiceView_InputPage_NextAction]
 */
public void GetCuentasServiceView_InputPage_NextAction(WebAppAccess webAppAccess)
{
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("GetCuentasServiceView_InputPageError");
    String action = errors.getForceAction();
    if (action != null)
        webAppAccess.processAction(action);
    else    if (errors.hasMessages())
        webAppAccess.processAction("GetCuentasServiceView_InputPage");
    else
        webAppAccess.processAction("GetCuentasServiceView_ShowResults");
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
 * Generated Method [GetCuentasServiceView_PagingGoToPage]
 */
public void GetCuentasServiceView_PagingGoToPage(WebAppAccess webAppAccess)
{
    String pageStr = webAppAccess.getRequestInputs().getInputValue("splitPagerExplicitPage");
    int pg = StringUtil.safeParseInt(pageStr, 1) - 1;
    PagingAssistant asst = (PagingAssistant)webAppAccess.getVariables().getObject("GetCuentasServiceView_Paging");
    asst.setCurrentPage(pg);
}


/**
 * Generated Method [GetCuentasServiceView_PagingGoToSpecificPage]
 */
public void GetCuentasServiceView_PagingGoToSpecificPage(WebAppAccess webAppAccess)
{
    String pageStr = webAppAccess.getRequestInputs().getInputValue("splitPagerTopExplicitPage");
    int pg = StringUtil.safeParseInt(pageStr, 1) - 1;
    PagingAssistant asst = (PagingAssistant)webAppAccess.getVariables().getObject("GetCuentasServiceView_Paging");
    asst.setCurrentPage(pg);
}


/**
 * Generated Method [GetCuentasServiceView_PagingSetRowsPerPage]
 */
public void GetCuentasServiceView_PagingSetRowsPerPage(WebAppAccess webAppAccess)
{
    String rppStr = webAppAccess.getRequestInputs().getInputValue("Arg1");
    int rpp = StringUtil.safeParseInt(rppStr, 1);
    PagingAssistant asst = (PagingAssistant)webAppAccess.getVariables().getObject("GetCuentasServiceView_Paging");
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
 * Generated Method [GetCuentasServiceView_PagingHandlePageLoad]
 */
public void GetCuentasServiceView_PagingHandlePageLoad(WebAppAccess webAppAccess)
{
    PagingAssistant asst = (PagingAssistant)webAppAccess.getVariables().getObject("GetCuentasServiceView_Paging");
    asst.setWebAppAccess(webAppAccess);
    webAppAccess.getVariables().getObject("GetCuentasServiceView_PagingData");}

/**
 * Generated ActionList [main]
 */
public Object main(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    // Show the input page.

    // Line 2: GetCuentasServiceView_InputPage
    returnValue = webAppAccess.processAction("GetCuentasServiceView_InputPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [GetCuentasServiceView_ShowResults]
 */
public Object GetCuentasServiceView_ShowResults(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: GetCuentasServiceGetCuentasO
    returnValue = webAppAccess.callMethod("GetCuentasServiceGetCuentasO", new Object[] {  });

    // Line 2: GetCuentasServiceView_ViewPage
    returnValue = webAppAccess.processAction("GetCuentasServiceView_ViewPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [_gen_call_pbAction_Source]
 */
public Object _gen_call_pbAction_Source(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    returnValue = webAppAccess.callMethod("pbAction_Source", new Object[] { webAppAccess.getRequestInputs().getInputValue("ACTION_NAME"), webAppAccess.getRequestInputs().getInputValue("numero_cuenta") });
    return (Object)returnValue;
}



}
