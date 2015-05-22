/**
 * Title:        _transaccionesSharedVariables
 *
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006, 2007. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * Description:  Generated methods class for IBM Web Experience Factory application.
 *
 * This code was automatically generated at 01:01:03 PM on May 21, 2015
 * by the IBM Web Experience Factory -- do not edit manually.
 * Generated using the following Profiles - Not Profiled.
 *
 */
package genjava.providers.GetTransacciones;


/* begin method imports */
import com.bowstreet.builders.webapp.methods.SharedVariable;
import com.bowstreet.util.cache.CacheManager;
import com.bowstreet.util.IExemplar;
import com.bowstreet.util.IXml;
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
public class _transaccionesSharedVariables  implements IExemplar
{

/**
 * Creates a new instance of this class
 */
public Object newInstance()
{
   return new _transaccionesSharedVariables();
}

/*begin*/
/**
 * Generated Method [firechangeInVariables]
 */
public Object firechangeInVariables(WebAppAccess webAppAccess)
{
Object _eventTarget = null;
	Object args[] = {
		};
	webAppAccess.getHttpServletRequest().setAttribute(WebAppAccessImpl.RENDERING_MODE_KEY, WebAppAccessImpl.SILENT_RENDERING_MODE);
	webAppAccess.fireEvent(_eventTarget, "changeInVariables", args);

	return "(typeof wpf_event_bus != 'undefined') && wpf_event_bus.fire('" + "changeInVariables" + "', { })";}

/**
 * Generated Method [SharedInputTransaccion_createHelper]
 */
public Object SharedInputTransaccion_createHelper(WebAppAccess webAppAccess)
{
    com.bowstreet.builders.webapp.methods.SharedVariable helper = new com.bowstreet.builders.webapp.methods.SharedVariable();
    helper.setName("SharedInputTransaccion");
    return helper;
}


}
