<%@ page import="com.bowstreet.security.framework.WEFSecurityManager" %>

<!--
 Handle Factory Authorization Errors where user wasn't logged in prior
 to trying to run a model which had roles specified in its model properties,
 and where an optionally configured AuthorizationHandler threw an
 AuthorizationRequiresAuthenticationException because it couldn't verify
 authorization without the user being logged in.

 Because this handler JSP should be protected by a security constraint,
 that alone should force the user to attempt to login.

 If that login is successful, then the logic in this page should
 be executed by the AppServer/servlet container.

 The logic in this page is basically to lookup info in the user's
 session on what the original WebAppRunner URL request was that
 failed due to not being logged in yet, and to attempt to redirect
 the user back to that URL now that we should be successfully logged in.

 If you'd rather just have the authorization error reported to the user,
 then bowstreet.webapp.security.authzLoginHandlerJSP  property should
 be set to /factory/webapp/authorizationerrorhandler.jsp
 and not to this handler.

 If you'd rather have users redirected to a public entrypoint for your
 web app, on such an authorization error (eg, the user bookmarked the
 wrong page), then you may change the
 bowstreet.webapp.security.authzLoginHandlerJSP property value to any
 relative (to this app context) URL that you desire, (JSP or HTML page).
-->

<%
    String goBackTo = (String)request.getSession(false).getAttribute("bowstreet.webapp.postLoginRedirect");
    String user = request.getRemoteUser();
    if (user != null) {
      response.sendRedirect( WEFSecurityManager.checkForIllegalSplitting( goBackTo ));
    } else {
%>
<h2>Authorization Failure:</h2>
<p>
You tried to access a model which has an optional security role property set at URL:
<br><br>
&nbsp; &nbsp; <%= WEFSecurityManager.encodeForHTMLContent( goBackTo ) %>
<br><br>
but you are not yet authenticated to the application server.
<%  }  %>
