/**
 * Title:        _PayModel
 *
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006, 2007. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * Description:  Generated methods class for IBM Web Experience Factory application.
 *
 * This code was automatically generated at 12:00:42 AM on Apr 30, 2015
 * by the IBM Web Experience Factory -- do not edit manually.
 * Generated using the following Profiles - 
 {
  { mobile_devicetype_base : Default  }
 }
 *
 */
package genjava.consumers.Pay;


/* begin method imports */
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
public class _PayModel  implements IExemplar
{

/**
 * Creates a new instance of this class
 */
public Object newInstance()
{
   return new _PayModel();
}

/*begin*/
/**
 * Generated Method [CreateTransaccionConsumerServiceCreateTransaccionOperation]
 */
public IXml CreateTransaccionConsumerServiceCreateTransaccionOperation(WebAppAccess webAppAccess)
{
//	The following webapp variables should be populated prior to invoking this method.
//	CreateTransaccionConsumerServiceCreateTransaccionOperationInputs

	Object result = webAppAccess.callMethod("CreateTransaccionConsumerService.executeOperation", "CreateTransaccionOperation", Boolean.FALSE );
	if (result instanceof WebAppAccessConsumer) {
		((WebAppAccessConsumer)result).setWebAppAccess(webAppAccess);
	}
	return (IXml)result;
}


/**
 * Generated Method [CreateTransaccionConsumerServiceCreateTransaccionOperationWithArgs]
 */
public IXml CreateTransaccionConsumerServiceCreateTransaccionOperationWithArgs(WebAppAccess webAppAccess, String arg1, String arg2, String arg3, String arg4)
{
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"CreateTransaccionConsumerServiceCreateTransaccionOperationInputs/operation1/id_cuenta_origen", arg1, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"CreateTransaccionConsumerServiceCreateTransaccionOperationInputs/operation1/numero_cuenta_destino", arg2, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"CreateTransaccionConsumerServiceCreateTransaccionOperationInputs/operation1/id_tipo_transaccion", arg3, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"CreateTransaccionConsumerServiceCreateTransaccionOperationInputs/operation1/monto_transferido", arg4, false );
	Object result = webAppAccess.callMethod("CreateTransaccionConsumerService.executeOperation", "CreateTransaccionOperation", Boolean.TRUE );
	if (result instanceof WebAppAccessConsumer) {
		((WebAppAccessConsumer)result).setWebAppAccess(webAppAccess);
	}
	return (IXml)result;
}


/**
 * Generated Method [CreateTransaccionConsumerService_createHelper]
 */
public Object CreateTransaccionConsumerService_createHelper(WebAppAccess webAppAccess)
{
    com.bowstreet.builders.webapp.ServiceConsumer2DataHelper helper = new com.bowstreet.builders.webapp.ServiceConsumer2DataHelper();
    helper.setName("CreateTransaccionConsumerService");
    return helper;
}

/**
 * Generated Method [ObtenerCuentasGetCuentasSO]
 */
public IXml ObtenerCuentasGetCuentasSO(WebAppAccess webAppAccess)
{
//	The following webapp variables should be populated prior to invoking this method.
//	ObtenerCuentasGetCuentasSOInputs

	Object result = webAppAccess.callMethod("ObtenerCuentas.executeOperation", "GetCuentasSO", Boolean.FALSE );
	if (result instanceof WebAppAccessConsumer) {
		((WebAppAccessConsumer)result).setWebAppAccess(webAppAccess);
	}
	return (IXml)result;
}


/**
 * Generated Method [ObtenerCuentasGetCuentasSOWithArgs]
 */
public IXml ObtenerCuentasGetCuentasSOWithArgs(WebAppAccess webAppAccess, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6)
{
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"ObtenerCuentasGetCuentasSOInputs/operation1/id_cliente", arg1, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"ObtenerCuentasGetCuentasSOInputs/operation1/id_tipo_cuenta", arg2, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"ObtenerCuentasGetCuentasSOInputs/operation1/fecha_mayor_a", arg3, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"ObtenerCuentasGetCuentasSOInputs/operation1/fecha_menor_a", arg4, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"ObtenerCuentasGetCuentasSOInputs/operation1/saldo_mayor_a", arg5, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"ObtenerCuentasGetCuentasSOInputs/operation1/saldo_menor_a", arg6, false );
	Object result = webAppAccess.callMethod("ObtenerCuentas.executeOperation", "GetCuentasSO", Boolean.TRUE );
	if (result instanceof WebAppAccessConsumer) {
		((WebAppAccessConsumer)result).setWebAppAccess(webAppAccess);
	}
	return (IXml)result;
}


/**
 * Generated Method [ObtenerCuentas_createHelper]
 */
public Object ObtenerCuentas_createHelper(WebAppAccess webAppAccess)
{
    com.bowstreet.builders.webapp.ServiceConsumer2DataHelper helper = new com.bowstreet.builders.webapp.ServiceConsumer2DataHelper();
    helper.setName("ObtenerCuentas");
    return helper;
}

/**
 * Generated Method [CuentasUsuarioGetXmlData]
 */
public IXml CuentasUsuarioGetXmlData(WebAppAccess webAppAccess)
{
  // Invoke data service operation.
  webAppAccess.callMethod("ObtenerCuentasGetCuentasSO");
  // Extract the XML content, if any.  Otherwise ignore the content.
  final Object content = webAppAccess.getVariables().getObject("ObtenerCuentasGetCuentasSOResults");
  return (content instanceof IXml) ? (IXml) CuentasUsuarioFilterXml( webAppAccess, (IXml) content ) : null;
}


/**
 * Generated Method [CuentasUsuarioGetValueTagName]
 */
public String CuentasUsuarioGetValueTagName(WebAppAccess webAppAccess)
{
  return "id_cuenta";
}

/**
 * Generated Method [CuentasUsuarioGetLabelTagName]
 */
public String CuentasUsuarioGetLabelTagName(WebAppAccess webAppAccess)
{
  return "numero_cuenta";
}

/**
 * Generated Method [CuentasUsuarioGetParentTagName]
 */
public String CuentasUsuarioGetParentTagName(WebAppAccess webAppAccess)
{
  return "UserAddition";
}

/**
 * Generated Method [CuentasUsuarioToLabel]
 */
public String CuentasUsuarioToLabel(WebAppAccess webAppAccess, String value)
{
  if (value == null) return null;
  String label = null;

  try
  {
    // Get the tag names that identify the value and label elements
    // in the source data XML.
    final String valueTagName = CuentasUsuarioGetValueTagName(webAppAccess);
    final String labelTagName = CuentasUsuarioGetLabelTagName(webAppAccess);

    // Setup the XPATH expresion that is used to find the label that
    // corresponds to the given value.
    final String xPath = "//[" + valueTagName + "='" + value + "']";

    // Get any additional data from the XML variable.  This variable
    // is either provided by the modeller directly or is created from
    // the additional data input of the lookup table builder.
    final IXml additionalDataXml = DataConverter.toIXml(webAppAccess.getVariables().getObject("CuentasUsuarioAdditionalXmlData"));
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

      final IXml lookupTable = (IXml) webAppAccess.callMethod( "CuentasUsuarioGetXmlData" );

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
 * Generated Method [CuentasUsuarioToValue]
 */
public String CuentasUsuarioToValue(WebAppAccess webAppAccess, String label)
{
  if (label == null) return null;
  String value = null;

  try
  {
    // Get the tag names that identify the value and label elements
    // in the source data XML.
    final String valueTagName = CuentasUsuarioGetValueTagName(webAppAccess);
    final String labelTagName = CuentasUsuarioGetLabelTagName(webAppAccess);

    // Setup the XPATH expresion that is used to find the value that
    // corresponds to the given label.
    final String xPath = "//[" + labelTagName + "='" + label + "']";

    // Get any additional data from the XML variable.  This variable
    // is either provided by the modeller directly or is created from
    // the additional data input of the lookup table builder.
    final IXml additionalDataXml = DataConverter.toIXml(webAppAccess.getVariables().getObject("CuentasUsuarioAdditionalXmlData"));
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

      final IXml lookupTable = (IXml) webAppAccess.callMethod( "CuentasUsuarioGetXmlData" );

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
 * Generated Method [CuentasUsuarioFilterXml]
 */
public IXml CuentasUsuarioFilterXml(WebAppAccess webAppAccess, IXml data)
{
  String labelTag = CuentasUsuarioGetLabelTagName(webAppAccess);
  String valueTag = CuentasUsuarioGetValueTagName(webAppAccess);
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
 * Generated Method [CuentasUsuarioGetLookupTable]
 */
public IXml CuentasUsuarioGetLookupTable(WebAppAccess webAppAccess)
{
  // Fetch the content of the main lookup table.  If no main table
  // exists, then create an empty one as a default.
  IXml lookupTable = (IXml) webAppAccess.callMethod( "CuentasUsuarioGetXmlData" );
  lookupTable = (lookupTable == null) ? XmlUtil.create( "LookupTable" ) : lookupTable.cloneElement();

  // Get any additional data from the XML variable.  This variable
  // is either provided by the modeller directly or is created from
  // the additional data input of the lookup table builder.
  final IXml additionalDataXml = DataConverter.toIXml(webAppAccess.getVariables().getObject("CuentasUsuarioAdditionalXmlData"));

  if( additionalDataXml != null )
  {
    // Get the tag names that identify the value and label elements
    // in the source data XML.
    final String valueTagName = CuentasUsuarioGetValueTagName(webAppAccess);
    final String labelTagName = CuentasUsuarioGetLabelTagName(webAppAccess);
    final String parentTagName = CuentasUsuarioGetParentTagName(webAppAccess);

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
 * Generated Method [TipoTransaccionesGetXmlData]
 */
public IXml TipoTransaccionesGetXmlData(WebAppAccess webAppAccess)
{
  // Extract the XML content, if any.  Otherwise ignore the content.
  final Object content = webAppAccess.getVariables().getObject("TipoTransaccionesXmlData");
  return (content instanceof IXml) ? (IXml) TipoTransaccionesFilterXml( webAppAccess, (IXml) content ) : null;
}


/**
 * Generated Method [TipoTransaccionesGetValueTagName]
 */
public String TipoTransaccionesGetValueTagName(WebAppAccess webAppAccess)
{
  return "Value";
}

/**
 * Generated Method [TipoTransaccionesGetLabelTagName]
 */
public String TipoTransaccionesGetLabelTagName(WebAppAccess webAppAccess)
{
  return "Label";
}

/**
 * Generated Method [TipoTransaccionesGetParentTagName]
 */
public String TipoTransaccionesGetParentTagName(WebAppAccess webAppAccess)
{
  return "UserAddition";
}

/**
 * Generated Method [TipoTransaccionesToLabel]
 */
public String TipoTransaccionesToLabel(WebAppAccess webAppAccess, String value)
{
  if (value == null) return null;
  String label = null;

  try
  {
    // Get the tag names that identify the value and label elements
    // in the source data XML.
    final String valueTagName = TipoTransaccionesGetValueTagName(webAppAccess);
    final String labelTagName = TipoTransaccionesGetLabelTagName(webAppAccess);

    // Setup the XPATH expresion that is used to find the label that
    // corresponds to the given value.
    final String xPath = "//[" + valueTagName + "='" + value + "']";

    // Get any additional data from the XML variable.  This variable
    // is either provided by the modeller directly or is created from
    // the additional data input of the lookup table builder.
    final IXml additionalDataXml = DataConverter.toIXml(webAppAccess.getVariables().getObject("TipoTransaccionesAdditionalXmlData"));
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

      final IXml lookupTable = (IXml) webAppAccess.callMethod( "TipoTransaccionesGetXmlData" );

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
 * Generated Method [TipoTransaccionesToValue]
 */
public String TipoTransaccionesToValue(WebAppAccess webAppAccess, String label)
{
  if (label == null) return null;
  String value = null;

  try
  {
    // Get the tag names that identify the value and label elements
    // in the source data XML.
    final String valueTagName = TipoTransaccionesGetValueTagName(webAppAccess);
    final String labelTagName = TipoTransaccionesGetLabelTagName(webAppAccess);

    // Setup the XPATH expresion that is used to find the value that
    // corresponds to the given label.
    final String xPath = "//[" + labelTagName + "='" + label + "']";

    // Get any additional data from the XML variable.  This variable
    // is either provided by the modeller directly or is created from
    // the additional data input of the lookup table builder.
    final IXml additionalDataXml = DataConverter.toIXml(webAppAccess.getVariables().getObject("TipoTransaccionesAdditionalXmlData"));
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

      final IXml lookupTable = (IXml) webAppAccess.callMethod( "TipoTransaccionesGetXmlData" );

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
 * Generated Method [TipoTransaccionesFilterXml]
 */
public IXml TipoTransaccionesFilterXml(WebAppAccess webAppAccess, IXml data)
{
  String labelTag = TipoTransaccionesGetLabelTagName(webAppAccess);
  String valueTag = TipoTransaccionesGetValueTagName(webAppAccess);
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
 * Generated Method [TipoTransaccionesGetLookupTable]
 */
public IXml TipoTransaccionesGetLookupTable(WebAppAccess webAppAccess)
{
  // Fetch the content of the main lookup table.  If no main table
  // exists, then create an empty one as a default.
  IXml lookupTable = (IXml) webAppAccess.callMethod( "TipoTransaccionesGetXmlData" );
  lookupTable = (lookupTable == null) ? XmlUtil.create( "LookupTable" ) : lookupTable.cloneElement();

  // Get any additional data from the XML variable.  This variable
  // is either provided by the modeller directly or is created from
  // the additional data input of the lookup table builder.
  final IXml additionalDataXml = DataConverter.toIXml(webAppAccess.getVariables().getObject("TipoTransaccionesAdditionalXmlData"));

  if( additionalDataXml != null )
  {
    // Get the tag names that identify the value and label elements
    // in the source data XML.
    final String valueTagName = TipoTransaccionesGetValueTagName(webAppAccess);
    final String labelTagName = TipoTransaccionesGetLabelTagName(webAppAccess);
    final String parentTagName = TipoTransaccionesGetParentTagName(webAppAccess);

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
 * Generated Method [CreateTransaccionConsumerView_InputPage_SaveData]
 */
public void CreateTransaccionConsumerView_InputPage_SaveData(WebAppAccess webAppAccess)
{
  String str;
  boolean performValidation;
  Variables variables = webAppAccess.getVariables();
  IInputFieldFormatter formatter;
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("CreateTransaccionConsumerView_InputPageError");
    errors.clear();

    {
        IXml CreateTransaccionConsumerServiceCreateTransaccionOperationInputs = variables.getXml("CreateTransaccionConsumerServiceCreateTransaccionOperationInputs");
        if (CreateTransaccionConsumerServiceCreateTransaccionOperationInputs == null) {
            CreateTransaccionConsumerServiceCreateTransaccionOperationInputs = XmlUtil.create("operation1");
            variables.setXml("CreateTransaccionConsumerServiceCreateTransaccionOperationInputs", CreateTransaccionConsumerServiceCreateTransaccionOperationInputs);
        }
        
            str = webAppAccess.getRequestInputs().getInputValue("id_cuenta_origen");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Required String"))
              errors.addMessage("id_cuenta_origen",DataConverter.toString(webAppAccess.getVariables().getObject("Mensaje_Validacion")));
            CreateTransaccionConsumerServiceCreateTransaccionOperationInputs.setText("id_cuenta_origen", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("numero_cuenta_destino");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Required String"))
              errors.addMessage("numero_cuenta_destino",DataConverter.toString(webAppAccess.getVariables().getObject("Mensaje_Validacion")));
            CreateTransaccionConsumerServiceCreateTransaccionOperationInputs.setText("numero_cuenta_destino", str);
        
            str = webAppAccess.getRequestInputs().getInputValue("monto_transferido");
            formatter = (IInputFieldFormatter)variables.getObject("StandardFormatter");
            formatter.setWebAppAccess(webAppAccess);
            if (!formatter.validate(str, "Required String"))
              errors.addMessage("monto_transferido",DataConverter.toString(webAppAccess.getVariables().getObject("Mensaje_Validacion")));
            CreateTransaccionConsumerServiceCreateTransaccionOperationInputs.setText("monto_transferido", str);
    
        variables.getVariable("CreateTransaccionConsumerServiceCreateTransaccionOperationInputs").notifyValueChanged();
    }
}

/**
 * Generated Method [_init_CreateTransaccionConsumerView_InputPageError]
 */
public com.bowstreet.builderutilities.PageAutomationMessages _init_CreateTransaccionConsumerView_InputPageError(WebAppAccess webAppAccess)
{
    PageAutomationMessages result = new PageAutomationMessages();

    result.setReadableName("id_cuenta_origen", "Cuenta de Origen");
    result.setReadableName("numero_cuenta_destino", "Numero de Cuenta Destino");
    result.setReadableName("id_tipo_transaccion", "Tipo de Transaccion");
    result.setReadableName("monto_transferido", "Monto Transferido");

    return result;
}

/**
 * Generated Method [clear_CreateTransaccionConsumerView_InputPage_Errors]
 */
public void clear_CreateTransaccionConsumerView_InputPage_Errors(WebAppAccess webAppAccess)
{
  webAppAccess.callMethod("CreateTransaccionConsumerView_InputPageError.clear");
}

/**
 * Generated Method [CreateTransaccionConsumerView_InputPage_NextAction]
 */
public void CreateTransaccionConsumerView_InputPage_NextAction(WebAppAccess webAppAccess)
{
    PageAutomationMessages errors = (PageAutomationMessages)webAppAccess.getVariables().getObject("CreateTransaccionConsumerView_InputPageError");
    String action = errors.getForceAction();
    if (action != null)
        webAppAccess.processAction(action);
    else    if (errors.hasMessages())
        webAppAccess.processAction("CreateTransaccionConsumerView_InputPage");
    else
        webAppAccess.processAction("CreateTransaccionConsumerView_ShowResults");
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
 * Generated ActionList [main]
 */
public Object main(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: 
    // Show the input page.

    // Line 2: CreateTransaccionConsumerView_InputPage
    returnValue = webAppAccess.processAction("CreateTransaccionConsumerView_InputPage");
    return (Object)returnValue;
}


/**
 * Generated ActionList [CreateTransaccionConsumerView_ShowResults]
 */
public Object CreateTransaccionConsumerView_ShowResults(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: CreateTransaccionConsumerServiceCreateTransaccionOperation
    returnValue = webAppAccess.callMethod("CreateTransaccionConsumerServiceCreateTransaccionOperation", new Object[] {  });

    // Line 2: CreateTransaccionConsumerView_ViewPage
    returnValue = webAppAccess.processAction("CreateTransaccionConsumerView_ViewPage");
    return (Object)returnValue;
}



}
