<!--
  Licensed Materials - Property of IBM
  5724-O03
  Copyright 2013. IBM Corp. All rights reserved.
  US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
-->

<%--
  ==================================================================================================================
  USAGE NOTE: This page (or any page specified in a builder call to replace this page) will be added to the <head>
              element of another page. It may safely contain JSP code and <script> elements. It should specifically
              NOT include any HTML elements that display information on the page (including <span> elements) and it
              should NOT refer to Dojo, as the contents of this page will not be processed by the dojo parser.
  ==================================================================================================================
--%>

<%
{
    final String _header = request.getHeader("User-Agent");
    final String _userAgent = (_header != null) ? _header.toLowerCase() : "unknown";
    final boolean _isHybridApp = (_userAgent.indexOf("worklight") > -1);

    if (_isHybridApp)
    {
%>
<script type="text/javascript">
var WL = WL ? WL : {};
WL.StaticAppProps =
{
  "APP_DISPLAY_NAME":"WLApp",
  "APP_ID": "WLApp",
  "APP_SERVICES_URL":"\/apps\/services\/",
  "APP_VERSION":"1.0",
  "LOGIN_DISPLAY_TYPE":"embedded",
  "WORKLIGHT_PLATFORM_VERSION":"6.1.0.00.20131219-1900",
<%
        if (_userAgent.indexOf("iphone") > -1 || _userAgent.indexOf("ipad") > -1 || _userAgent.indexOf("ipod") > -1)
        {
%>
  "ENVIRONMENT":"iphone",
  "WORKLIGHT_NATIVE_VERSION": "3577331796",
  "WORKLIGHT_ROOT_URL":"\/apps\/services\/api\/WLApp\/iphone\/"
};
</script>
<script src="/worklight-ios/cordova.js"></script>
<script src="/worklight-ios/wljq.js"></script>
<script src="/worklight-ios/worklight.js"></script>
<script src="/worklight-ios/checksum.js"></script>
<%
        }
        else
        {
%>
  "ENVIRONMENT":"android",
  "WORKLIGHT_NATIVE_VERSION": "1420749232",
  "WORKLIGHT_ROOT_URL":"\/apps\/services\/api\/WLApp\/android\/"
};
</script>
<script src="/worklight-and/cordova.js"></script>
<script src="/worklight-and/wljq.js"></script>
<script src="/worklight-and/worklight.js"></script>
<script src="/worklight-and/checksum.js"></script>
<%
        }
    }
}
%>
