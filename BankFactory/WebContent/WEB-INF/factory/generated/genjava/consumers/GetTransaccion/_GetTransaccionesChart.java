/**
 * Title:        _GetTransaccionesChart
 *
 * Licensed Materials - Property of IBM
 * 5724-O03
 * Copyright 2006, 2007. IBM Corp. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 * See Web Experience Factory ( product id 5724-O03 ) product license for terms and conditions of use.
 *
 * Description:  Generated methods class for IBM Web Experience Factory application.
 *
 * This code was automatically generated at 02:50:46 AM on May 22, 2015
 * by the IBM Web Experience Factory -- do not edit manually.
 * Generated using the following Profiles - Not Profiled.
 *
 */
package genjava.consumers.GetTransaccion;


/* begin method imports */
import com.bowstreet.builders.webapp.client.ClientOnlyMethodException;
import com.bowstreet.builders.webapp.methods.SharedVariable;
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
public class _GetTransaccionesChart  implements IExemplar
{

/**
 * Creates a new instance of this class
 */
public Object newInstance()
{
   return new _GetTransaccionesChart();
}

/*begin*/
/**
 * Generated Method [fireclientClientServiceError]
 */
public Object fireclientClientServiceError(WebAppAccess webAppAccess, String error)
{
Object _eventTarget = null;
	Object args[] = {
	error
	};
	webAppAccess.getHttpServletRequest().setAttribute(WebAppAccessImpl.RENDERING_MODE_KEY, WebAppAccessImpl.SILENT_RENDERING_MODE);
	webAppAccess.fireEvent(_eventTarget, "clientClientServiceError", args);

	return "(typeof wpf_event_bus != 'undefined') && wpf_event_bus.fire('" + "consumers_00215GetTransaccion_00215GetTransaccionesChartclientClientServiceError" + "', { error: '" + error + "' })";}

/**
 * Generated Method [fireclientClientPageError]
 */
public Object fireclientClientPageError(WebAppAccess webAppAccess, String error)
{
Object _eventTarget = null;
	Object args[] = {
	error
	};
	webAppAccess.getHttpServletRequest().setAttribute(WebAppAccessImpl.RENDERING_MODE_KEY, WebAppAccessImpl.SILENT_RENDERING_MODE);
	webAppAccess.fireEvent(_eventTarget, "clientClientPageError", args);

	return "(typeof wpf_event_bus != 'undefined') && wpf_event_bus.fire('" + "consumers_00215GetTransaccion_00215GetTransaccionesChartclientClientPageError" + "', { error: '" + error + "' })";}

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
 * Generated Method [SumarTransaccionesConsumerSumarTransaccionesOp]
 */
public IXml SumarTransaccionesConsumerSumarTransaccionesOp(WebAppAccess webAppAccess)
{
//	The following webapp variables should be populated prior to invoking this method.
//	SumarTransaccionesConsumerSumarTransaccionesOpInputs

	Object result = webAppAccess.callMethod("SumarTransaccionesConsumer.executeOperation", "SumarTransaccionesOp", Boolean.FALSE );
	if (result instanceof WebAppAccessConsumer) {
		((WebAppAccessConsumer)result).setWebAppAccess(webAppAccess);
	}
	return (IXml)result;
}


/**
 * Generated Method [SumarTransaccionesConsumerSumarTransaccionesOpWithArgs]
 */
public IXml SumarTransaccionesConsumerSumarTransaccionesOpWithArgs(WebAppAccess webAppAccess, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8)
{
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"SumarTransaccionesConsumerSumarTransaccionesOpInputs/operation2InputParameter1/idCliente", arg1, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"SumarTransaccionesConsumerSumarTransaccionesOpInputs/operation2InputParameter1/idTipoTransaccion", arg2, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"SumarTransaccionesConsumerSumarTransaccionesOpInputs/operation2InputParameter1/fecha_mov_mayor_a", arg3, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"SumarTransaccionesConsumerSumarTransaccionesOpInputs/operation2InputParameter1/fecha_mov_menor_a", arg4, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"SumarTransaccionesConsumerSumarTransaccionesOpInputs/operation2InputParameter1/mon_trans_mayor_a", arg5, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"SumarTransaccionesConsumerSumarTransaccionesOpInputs/operation2InputParameter1/mon_trans_menor_a", arg6, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"SumarTransaccionesConsumerSumarTransaccionesOpInputs/operation2InputParameter1/n_trans_mayor_a", arg7, false );
	com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"SumarTransaccionesConsumerSumarTransaccionesOpInputs/operation2InputParameter1/n_trans_menor_a", arg8, false );
	Object result = webAppAccess.callMethod("SumarTransaccionesConsumer.executeOperation", "SumarTransaccionesOp", Boolean.TRUE );
	if (result instanceof WebAppAccessConsumer) {
		((WebAppAccessConsumer)result).setWebAppAccess(webAppAccess);
	}
	return (IXml)result;
}


/**
 * Generated Method [SumarTransaccionesConsumer_createHelper]
 */
public Object SumarTransaccionesConsumer_createHelper(WebAppAccess webAppAccess)
{
    com.bowstreet.builders.webapp.ServiceConsumer2DataHelper helper = new com.bowstreet.builders.webapp.ServiceConsumer2DataHelper();
    helper.setName("SumarTransaccionesConsumer");
    return helper;
}

/**
 * Generated Method [_IRResolver_1]
 */
public Object _IRResolver_1(WebAppAccess webAppAccess)
{
    return webAppAccess.getVariables().getXmlElement("InputTransaccion", "operation1/id_cuenta");
}

/**
 * Generated Method [_IRResolver_2]
 */
public Object _IRResolver_2(WebAppAccess webAppAccess)
{
    return webAppAccess.getVariables().getXmlElement("InputTransaccion", "operation1/id_tipo_transaccion");
}

/**
 * Generated Method [_IRResolver_3]
 */
public Object _IRResolver_3(WebAppAccess webAppAccess)
{
    return webAppAccess.getVariables().getXmlElement("InputTransaccion", "operation1/fecha_mov_mayor_a");
}

/**
 * Generated Method [_IRResolver_4]
 */
public Object _IRResolver_4(WebAppAccess webAppAccess)
{
    return webAppAccess.getVariables().getXmlElement("InputTransaccion", "operation1/fecha_mov_menor_a");
}

/**
 * Generated Method [_IRResolver_5]
 */
public Object _IRResolver_5(WebAppAccess webAppAccess)
{
    return webAppAccess.getVariables().getXmlElement("InputTransaccion", "operation1/mon_trans_mayor_a");
}

/**
 * Generated Method [_IRResolver_6]
 */
public Object _IRResolver_6(WebAppAccess webAppAccess)
{
    return webAppAccess.getVariables().getXmlElement("InputTransaccion", "operation1/mon_trans_menor_a");
}

/**
 * Generated Method [_IRResolver_7]
 */
public Object _IRResolver_7(WebAppAccess webAppAccess)
{
    return webAppAccess.getVariables().getXmlElement("InputTransaccion", "operation1/n_trans_mayor_a");
}

/**
 * Generated Method [_IRResolver_8]
 */
public Object _IRResolver_8(WebAppAccess webAppAccess)
{
    return webAppAccess.getVariables().getXmlElement("InputTransaccion", "operation1/n_trans_menor_a");
}

/**
 * Generated Method [getClientMethodBodies]
 */
public String getClientMethodBodies(WebAppAccess webAppAccess)
{
return com.bowstreet.builders.webapp.client.ClientActionUtils.getClientMethodsScript(webAppAccess.getWebApp(), webAppAccess.getInstanceID());
}

/**
 * Generated Method [getClientVariableValues]
 */
public String getClientVariableValues(WebAppAccess webAppAccess)
{
return "dojo.safeMixin(" + webAppAccess.getInstanceID() + ".variables" + ", " + webAppAccess.callMethod("ClientActionDispatcher.getAggregatorPageVariablesAsJSON") + ");";
}

/**
 * Generated Method [setDeferredClientAction]
 */
public void setDeferredClientAction(WebAppAccess webAppAccess, String actionName)
{
webAppAccess.setCurrentPage(actionName);
}

/**
 * Generated Method [setDeferredClientActionParameters]
 */
public void setDeferredClientActionParameters(WebAppAccess webAppAccess, String parameters)
{
webAppAccess.getHttpServletRequest().setAttribute("bowstreet.client.deferred.action.parameters", parameters);
}

/**
 * Generated Method [SumarTransaccionesConsumerSumarTransaccionesOpClient]
 */
public void SumarTransaccionesConsumerSumarTransaccionesOpClient(WebAppAccess webAppAccess)
{
    RequestInputs inputs = webAppAccess.getRequestInputs();
    com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"SumarTransaccionesConsumerSumarTransaccionesOpInputs", "operation2InputParameter1/idCliente", inputs.getInputValue("idCliente"), false);
    com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"SumarTransaccionesConsumerSumarTransaccionesOpInputs", "operation2InputParameter1/idTipoTransaccion", inputs.getInputValue("idTipoTransaccion"), false);
    com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"SumarTransaccionesConsumerSumarTransaccionesOpInputs", "operation2InputParameter1/fecha_mov_mayor_a", inputs.getInputValue("fecha_mov_mayor_a"), false);
    com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"SumarTransaccionesConsumerSumarTransaccionesOpInputs", "operation2InputParameter1/fecha_mov_menor_a", inputs.getInputValue("fecha_mov_menor_a"), false);
    com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"SumarTransaccionesConsumerSumarTransaccionesOpInputs", "operation2InputParameter1/mon_trans_mayor_a", inputs.getInputValue("mon_trans_mayor_a"), false);
    com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"SumarTransaccionesConsumerSumarTransaccionesOpInputs", "operation2InputParameter1/mon_trans_menor_a", inputs.getInputValue("mon_trans_menor_a"), false);
    com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"SumarTransaccionesConsumerSumarTransaccionesOpInputs", "operation2InputParameter1/n_trans_mayor_a", inputs.getInputValue("n_trans_mayor_a"), false);
    com.bowstreet.builderutilities.PageAutomationRuntime.assign(webAppAccess,"SumarTransaccionesConsumerSumarTransaccionesOpInputs", "operation2InputParameter1/n_trans_menor_a", inputs.getInputValue("n_trans_menor_a"), false);
    webAppAccess.callMethod("SumarTransaccionesConsumerSumarTransaccionesOp");
}


/**
 * Generated Method [SharedInputTransaccion_createHelper]
 */
public Object SharedInputTransaccion_createHelper(WebAppAccess webAppAccess)
{
    com.bowstreet.builders.webapp.methods.SharedVariable helper = new com.bowstreet.builders.webapp.methods.SharedVariable();
    helper.setName("SharedInputTransaccion");
    return helper;
}

/**
 * Generated Method [UpdateChartClientActionList]
 */
public void UpdateChartClientActionList(WebAppAccess webAppAccess)
/* This is the client method:
UpdateChartClientActionList() 
{
return this.callActions([
function() {return this.callServerAction('SumarTransaccionesConsumerSumarTransaccionesOpClient', (function(v) { for (var i in v) return v[i]; })(this.getVariable('SumarTransaccionesConsumerSumarTransaccionesOpInputs'))); },
function() {this.setVariable("Egreso", this.getVariable('SumarTransaccionesConsumerSumarTransaccionesOpResults.operation2OutputParameter1.Credito')); },
function() {this.setVariable("Ingreso", this.getVariable('SumarTransaccionesConsumerSumarTransaccionesOpResults.operation2OutputParameter1.Debito')); },
function() {return webAppAccess.metodo(); }
]);

}
*/
/* Server method */ 
{
throw new ClientOnlyMethodException("UpdateChartClientActionList");
}

/**
 * Generated Method [metodo]
 */
public void metodo(WebAppAccess webAppAccess)
/* This is the client method:
metodo() 
{ 
 
    var doughnutData = [ 
				{ 
					value: parseInt(this.getVariable('Ingreso')), 
					color:"#F7464A", 
					highlight: "#FF5A5E", 
					label: "Red" 
				}, 
				{ 
					value: parseInt(this.getVariable('Egreso')), 
					color: "#46BFBD", 
					highlight: "#5AD3D1", 
					label: "Green" 
				} 
 
			]; 
 
				var ctx = document.getElementById("chart-area").getContext("2d"); 
				window.myDoughnut = new Chart(ctx).Doughnut(doughnutData, {responsive : true}); 
			 
}
*/
/* Server method */ 
{
throw new ClientOnlyMethodException("metodo");
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

    // Line 1: clientPage
    returnValue = webAppAccess.processAction("clientPage");
    return (Object)returnValue;
}



}
