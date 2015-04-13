<%@ page import="java.util.*" %>
<%@ page import="com.bowstreet.*"%>
<%!
    // This keeps track of the last session used
    static HttpSession oldSession;
%>

<!-- Get a URL to redirect to from a request parameter -->
<% java.lang.String redirectTo = request.getParameter("redirectTo"); %>



<!-- If we come from the designer and in development mode then flush the Dynamic Class Loader cach so we pickup changed ancillary LJO classes -->
<%
    boolean developmentMode = com.bowstreet.BSConfig.getProperty("bowstreet.server.type", "deployment").equals("development");
    if(developmentMode)
    {
        if (oldSession != null)
        {
            // Release previous session
            try
            {
                oldSession.invalidate();
            }
            catch (Throwable t)
            {
            }
        }

        // Make sure current session is valid (workaround occasional mozilla problem)
        try {
            boolean isNew = session.isNew();
        } catch (IllegalStateException iae) {
            session = request.getSession(true);
        }

        oldSession = session;
        // flush the Dynamic Class Loader cach
        com.bowstreet.engine.ServiceClassLoader.resetClasses();

        // clear profile cache
        com.bowstreet.profiles.ProfileCache.getProfileCache().clearCachedProfiles();

        // clear WebApp cache
        com.bowstreet.util.cache.CacheManager.getCacheManager().clearWebAppCache();

        // enable/disable model tracing
        if (request.getParameter("RunWithTracing") != null)
              com.bowstreet.util.PTimer.enableTrace(true);
        else
              com.bowstreet.util.PTimer.enableTrace(false);

        // Get the session and remove all of the data from it
        java.util.Enumeration names = session.getAttributeNames();
        while(names.hasMoreElements())
        {
            String name = (String)names.nextElement();
            session.removeAttribute(name);
        }

        // Force the service mapping registry to pick up new mappings.
        com.bowstreet.factory.model.mapping.ServiceMapper.reset();

        // Force reset of REST Service Call auto feed handlers
        com.bowstreet.builders.webapp.methods.FeedAnalyzer.resetHandlers();

    }
%>

<!-- Specify that we came from the designer so we can invalidate the WebApp Method class instance -->
<% session.setAttribute("bowstreet.fromDesigner", "true"); %>

<!-- Send them on their way -->
<% response.sendRedirect(redirectTo); %>
