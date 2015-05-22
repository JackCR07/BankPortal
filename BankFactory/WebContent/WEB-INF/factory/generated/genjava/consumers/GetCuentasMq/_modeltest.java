/**
 * Title:        _modeltest
 *
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006, 2007. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * Description:  Generated methods class for IBM Web Experience Factory application.
 *
 * This code was automatically generated at 11:14:10 AM on May 20, 2015
 * by the IBM Web Experience Factory -- do not edit manually.
 * Generated using the following Profiles - Not Profiled.
 *
 */
package genjava.consumers.GetCuentasMq;


/* begin method imports */
import com.bowstreet.builders.webapp.methods.WebAppAccessConsumer;
import com.bowstreet.builders.webapp.ServiceConsumer2DataHelper;
import com.bowstreet.util.cache.CacheManager;
import com.bowstreet.util.IExemplar;
import com.bowstreet.util.IXml;
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
public class _modeltest  implements IExemplar
{

/**
 * Creates a new instance of this class
 */
public Object newInstance()
{
   return new _modeltest();
}

/*begin*/
/**
 * Generated Method [testconsumerSumarTransaccionesOp]
 */
public IXml testconsumerSumarTransaccionesOp(WebAppAccess webAppAccess)
{
//	The following webapp variables should be populated prior to invoking this method.
//	testconsumerSumarTransaccionesOpInputs

	Object result = webAppAccess.callMethod("testconsumer.executeOperation", "SumarTransaccionesOp", Boolean.FALSE );
	if (result instanceof WebAppAccessConsumer) {
		((WebAppAccessConsumer)result).setWebAppAccess(webAppAccess);
	}
	return (IXml)result;
}


/**
 * Generated Method [testconsumerSumarTransaccionesOpWithArgs]
 */
public IXml testconsumerSumarTransaccionesOpWithArgs(WebAppAccess webAppAccess, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8)
{
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"testconsumerSumarTransaccionesOpInputs/operation2InputParameter1/idCliente", arg1, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"testconsumerSumarTransaccionesOpInputs/operation2InputParameter1/idTipoTransaccion", arg2, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"testconsumerSumarTransaccionesOpInputs/operation2InputParameter1/fecha_mov_mayor_a", arg3, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"testconsumerSumarTransaccionesOpInputs/operation2InputParameter1/fecha_mov_menor_a", arg4, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"testconsumerSumarTransaccionesOpInputs/operation2InputParameter1/mon_trans_mayor_a", arg5, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"testconsumerSumarTransaccionesOpInputs/operation2InputParameter1/mon_trans_menor_a", arg6, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"testconsumerSumarTransaccionesOpInputs/operation2InputParameter1/n_trans_mayor_a", arg7, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"testconsumerSumarTransaccionesOpInputs/operation2InputParameter1/n_trans_menor_a", arg8, false );
	Object result = webAppAccess.callMethod("testconsumer.executeOperation", "SumarTransaccionesOp", Boolean.TRUE );
	if (result instanceof WebAppAccessConsumer) {
		((WebAppAccessConsumer)result).setWebAppAccess(webAppAccess);
	}
	return (IXml)result;
}


/**
 * Generated Method [testconsumer_createHelper]
 */
public Object testconsumer_createHelper(WebAppAccess webAppAccess)
{
    com.bowstreet.builders.webapp.ServiceConsumer2DataHelper helper = new com.bowstreet.builders.webapp.ServiceConsumer2DataHelper();
    helper.setName("testconsumer");
    return helper;
}

/**
 * Generated ActionList [main]
 */
public Object main(WebAppAccess webAppAccess)
{
    Object returnValue = null;

    // Line 1: DataServices/testconsumer/SumarTransaccionesOp
    returnValue = webAppAccess.processAction("testconsumerSumarTransaccionesOp");

    // Line 2: pagina
    returnValue = webAppAccess.processAction("pagina");
    return (Object)returnValue;
}



}
