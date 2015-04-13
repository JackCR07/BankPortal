<%@ page import="com.bowstreet.BSConfig" %>
<%@ page import="com.bowstreet.security.framework.WEFSecurityManager" %>

<%
    // Sample logout page to help log you out and optionally go to a specified page.
    // Figure out which AppServer/container we're in
    String implementation = BSConfig.getProperty("runtime.container.implementation");
    if (implementation == null) implementation = "unknown";

    if (implementation.equals("WebSphere")) {

        // WebSphere proprietary logout - must submit (POST) to well known action
        RequestDispatcher disp = request.getRequestDispatcher("/ibm_security_logout");
        disp.forward(request, response);

    } else {

        // Generic appserver logout via session invalidate and redirect
        String logoutexitpage = request.getParameter("logoutExitPage");
        session.invalidate();
        if (logoutexitpage != null && !logoutexitpage.startsWith("http"))
            logoutexitpage = request.getContextPath() + logoutexitpage;
        response.sendRedirect( WEFSecurityManager.checkForIllegalSplitting( logoutexitpage ));
    }
  
%>
