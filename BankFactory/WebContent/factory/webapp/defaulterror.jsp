<%--  Sample default error page
Licensed Materials - Property of IBM 
5724-O03
Copyright IBM Corp. 2002, 2006, 2009, 2010, 2013
US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.

The Program may contain sample source code or programs, which illustrate
programming techniques. You may only copy, modify, and distribute these
samples internally. These samples have not been tested under all conditions
and are provided to you by IBM without obligation of support of any kind.

IBM PROVIDES THESE SAMPLES "AS IS" SUBJECT TO ANY STATUTORY WARRANTIES THAT
CANNOT BE EXCLUDED. IBM MAKES NO WARRANTIES OR CONDITIONS, EITHER EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OR CONDITIONS OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, AND NON-INFRINGEMENT
REGARDING THESE SAMPLES OR TECHNICAL SUPPORT, IF ANY.

This is a sample / default error page for use during development, and to show
how a customer might obtain error related data for their own custom error page.
We do not recommend that this sample be used as is for actual deployed applications.

While most errors should be caught and handled within your application,
you should have a customized version of this default error page that is
appropriate for your environment.  Deployed applications typically do not
display as much error information to the user, as this development/debug
error page does, but rather inform the user that an unexpected error has
occurred and to contact their application administration for further help.
--%>

<%@ page isErrorPage="true" %>
<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import="java.util.Locale"%>
<%@ page import="java.util.ResourceBundle"%>
<%@ page import="java.util.MissingResourceException"%>
<%@ page import="com.bowstreet.services.base.ActionStatus"%>
<%@ page import="com.bowstreet.BSConfig" %>
<%@ page import="com.bowstreet.util.StringUtil" %>
<%@ page import="com.bowstreet.util.JSONUtil" %>
<%@ page import="com.bowstreet.webapp.ClientAppSupport" %>
<%@ page import="com.bowstreet.webapp.ErrorPageUtil" %>

<%!
    final static String BUNDLE_NAME="com.bowstreet.content.factory.webapp.messages";

    final static boolean devMode = isDevMode();
    private static boolean isDevMode() {
        boolean retval = false;
        try {
            retval = "development".equals(BSConfig.getProperty("bowstreet.server.type"));
        } catch (Exception e) {
            e.printStackTrace(); // Dump it to the log - can't rely on logging if BSConfig isn't working
        }
        return retval;
    }

	private static String ncrEncode( final String s )
	{
		final StringBuffer buffer = new StringBuffer();
		final int length = (s != null) ? s.length() : 0;
		
		for( int i = 0; i < length; i++ )
		{
			final char c = s.charAt( i );
			    
			if( c <= 127 )
				buffer.append( c );
			else
				buffer.append( "&#" ).append( (int) c ).append( ";" );
		}

		return buffer.toString();
	}

    private Locale preferredLocale = null;
    private ResourceBundle RES_BUNDLE = null;

    private String fmtMessage( final String key )
    {
        try
        {
            return RES_BUNDLE.getString( key );
        }
        catch( MissingResourceException mre )
        {
            return '!' + key + '!';
        }
    }
%>

<%
    preferredLocale = request.getLocale();
    RES_BUNDLE = ResourceBundle.getBundle( BUNDLE_NAME, preferredLocale );

    Throwable thr = (Throwable)request.getAttribute("javax.servlet.jsp.jspException");
    if (thr == null)
        thr = exception;

    String exceptionMessage = null;
    String errorMessage = null;
    if (thr != null && thr.getMessage() != null && thr.getMessage().length() > 0)
    {
        exceptionMessage = thr.getMessage();
        errorMessage = StringUtil.printf(fmtMessage("defaulterror.ErrorMessage"), exceptionMessage);
    }
    String stackTrace = null;
    if (thr != null)
    {
        stackTrace = StringUtil.getStackTraceAsString(thr);
    }

    String errorCode = ErrorPageUtil.isSessionExpired(request) ? "session_timeout" : "unknown_error";

    ActionStatus actionStatus = (ActionStatus)request.getAttribute("bowstreet.webapp.actionStatus");

    if (!ClientAppSupport.isJSONResponseExpected(request))
    {
%>
<html>

<head>
  <title><%=ncrEncode(fmtMessage("defaulterror.UnhandledError"))%></title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

  <!-- These 2 simple styles provided for showing and hiding groups -->
  <%-- This styles define the show and hide states --%>
  <STYLE>
    .showControl { visibility: visible; }
    .hideControl { visibility: hidden; display: none; }
  </STYLE>
</head>

<body>

<form name="exceptionForm">

<p>
<font color="red">
<b>
<%=ncrEncode(fmtMessage("defaulterror.UnhandledError"))%>

<br>
<%
if (devMode && errorMessage != null) {
%>
<%=ncrEncode(errorMessage)%>
<br/>
<%}%>
</b>
</font>
<br/>
<%=ncrEncode(fmtMessage("defaulterror.ErrorLogInfo"))%>
</p>

<% if (devMode) { %>
<%-- This function shows and hides the error section when the link is clicked --%>
<script type="text/javascript">

	function toggleVis(groupId)
	{
		// the element that contains the area to hide/show
		toToggle = document.getElementById(groupId);
				
		// toggle the class attribute to change visibility
		currentClass = toToggle.className;
		if(currentClass == '' || currentClass == 'showControl')
			toToggle.className = 'hideControl';
		
		else
			toToggle.className = 'showControl';
		
	}

</script>

<%-- get the timestamp for naming and referencing the area to show and hide so it's unique --%>
<%
	String time = String.valueOf(System.currentTimeMillis());
%>

<p>
<a onclick="javascript:toggleVis('exceptionDiv<%= time %>');toggleVis('showMessageDiv');toggleVis('hideMessageDiv');" href="javascript:void(0);">
<span id="showMessageDiv" class="showControl"><%=ncrEncode(fmtMessage("defaulterror.ShowDetails"))%></span>
<span id="hideMessageDiv" class="hideControl"><%=ncrEncode(fmtMessage("defaulterror.HideDetails"))%></span>
</a>
</p>

<%-- This whole div tag is shown or hidden when the user clicks on the link above --%>
<div id="exceptionDiv<%= time %>" class="hideControl">
<p>
<b><%=ncrEncode(fmtMessage("defaulterror.Exception"))%></b>
<%=ncrEncode(exceptionMessage)%>
</p>

<pre>
<%
if (stackTrace != null) {
%>
<b><%=ncrEncode(fmtMessage("defaulterror.StackTrace"))%></b>
<%=ncrEncode(stackTrace)%>
<%}%>
</pre>

<p>
<%
if (actionStatus != null) {
%>
<b><%=ncrEncode(fmtMessage("defaulterror.ActionStatus"))%></b><br>
<%=ncrEncode(actionStatus.getActionStatusHTML().toString())%>
<%}%>
</p>
</div>
<% } // end of if (devMode) %>
</form>

</body>
</html>
<%
    } else {
        boolean isMultipart = request.getContentType().startsWith("multipart/");
        if (isMultipart) {
%><html><body><textarea><%
        }
%>
{
  "defaultErrorPageData" : {
<%
if (devMode) {
    if (exceptionMessage != null) {
%>
    "exceptionMessage" : "<%=JSONUtil.escapeJSON(exceptionMessage)%>",
<%
    }
    if (errorMessage != null) {
%>
    "errorMessage" : "<%=JSONUtil.escapeJSON(errorMessage)%>",
<%
    }
    if (stackTrace != null) {
%>
    "stackTrace" : "<%=JSONUtil.escapeJSON(stackTrace)%>",
<%
    }
    if (actionStatus != null) {
%>
    "actionStatus" : "<%=JSONUtil.escapeJSON(actionStatus.getActionStatusString())%>",
<%
    }
}
%>
    "error" : "<%=JSONUtil.escapeJSON(fmtMessage("defaulterror.UnhandledError"))%>",
    "errorCode" : "<%=errorCode%>"
  }
}
<%
        if (isMultipart) {
%></textarea></body></html><%
        }
    }
%>
