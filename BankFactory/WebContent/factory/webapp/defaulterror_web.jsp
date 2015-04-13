<%--
IMPORTANT:
The non-standard formatting of this JSP is intentional in order to avoid writing to the response stream before it can set HTTP headers.

This page is referenced in web.xml as the J2EE unhandled error page for the application, and simply sets some HTTP header items before
including the standard defaulterror.jsp page.
--%><%@ page isErrorPage="true" %><%@ page contentType="text/html; charset=UTF-8" %><%@ page import="com.bowstreet.webapp.ErrorPageUtil" %><%
ErrorPageUtil.setResponseHeaders(request, response);
%>
<jsp:include page="defaulterror.jsp" />
