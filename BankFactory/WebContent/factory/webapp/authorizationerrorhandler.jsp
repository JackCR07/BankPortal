
<%@ page isErrorPage="true" %>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="com.bowstreet.services.base.ActionStatus"%>
<%@ page import="com.bowstreet.util.IXml"%>

<!--
 Handle Authorization Errors where user wasn't logged in,
 by reporting them, rather than trying to force the user to login.
 If you prefer to have the engine attempt to get the user to login
 as a result of one of these Authorization errors, then the 
 bowstreet.webapp.security.authzLoginHandlerJSP  property should
 be set to /factory/webapp/defaultAuthorizationLoginHandler.jsp
 and not to this handler, which just reports the error to the user.

 If you'd rather have users redirected to a public entrypoint for your
 web app, on such an authorization error (eg, the user bookmarked the
 wrong page), then you may change the
 bowstreet.webapp.security.authzLoginHandlerJSP property value to any
 relative (to this app context) URL that you desire, (JSP or HTML page).
-->

<html>

<head>
<title>Authorization Login Handler Page</title>
</head>

<body>

<center>
<h1>
<font color=red>Authorization Login Handler Page</font>
</h1>
</center>

<p>
Unhandled Authorization Error during request for a model protected by roles, by a user who has not yet logged in..

<p>
<b>Exception: </b>
<%= exception %>

<pre>
<%
 if (exception != null) {
   out.println("<b>Stack Trace:</b>");
   PrintWriter w = new PrintWriter(out);
   exception.printStackTrace(w);
 }
%>
</pre>

<%
ActionStatus status = (ActionStatus)request.getAttribute("bowstreet.webapp.actionStatus");
if (status != null) {
  out.println("<b>Action Status: </b><br>");
  PrintWriter pw = new PrintWriter(out);
  IXml data = status.getActionStatusHTML();
  data.writeHtml(pw);
}
%>


</body>
</html>

