
<%@ page import="java.io.PrintWriter"%>
<%@ page import="com.bowstreet.services.base.ActionStatus"%>
<%@ page import="com.bowstreet.util.IXml"%>
<%@ page import="com.bowstreet.webapp.Page"%>
<%@ page import="java.util.ResourceBundle"%>
<%@ page import="java.util.MissingResourceException"%>
<%@ page contentType="text/html; charset=UTF-8" %> 

<%!
    static final String BUNDLE_NAME="com.bowstreet.content.factory.webapp.messages";
    static final ResourceBundle RES_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
    static String fmtMessage(String key) {
        try {
            return RES_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
%>   

<html>

<head>
  <title><%=fmtMessage("nulloutput.Title")%></title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>

<center>
<h1><font color="red"><%=fmtMessage("nulloutput.Title")%></font></h1>
</center>

<p>
<%=com.bowstreet.util.StringUtil.printf(fmtMessage("nulloutput.Message"),
                                        "Page.PROCESSED_PAGE_REQUEST_ATTRIBUTE",
                                        "/factory/webapp/nulloutput.jsp",
                                        "bowstreet.webapp.missingOutputHandler",
                                        "bowstreet.properties")
%>
<br>
<br>

<%
ActionStatus status = (ActionStatus)request.getAttribute("bowstreet.webapp.actionStatus");
if (status != null) {
%>
<b><%=fmtMessage("nulloutput.ActionStatus")%></b><br>
<%
  PrintWriter pw = new PrintWriter(out);
  IXml data = status.getActionStatusHTML();
  data.writeHtml(pw);
}
%>

</body>
</html>
