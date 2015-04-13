
<%-- See if a public WebApp or JSP set a custom login page before the user hit a protected resource --%>
<%
    String customLoginPage = (String)session.getAttribute("bowstreet.security.login.custom");
    if ((customLoginPage == null) || (customLoginPage.length()==0))
        customLoginPage = "default_login.jsp";
%>
<jsp:include page="<%=customLoginPage%>" flush="true" />
