<%@ page import="java.util.*" %>
<%@ page import="com.bowstreet.*"%>

<!-- If we are not initialized, go ahead and initialize (needed for RAD 6)-->
<%
    
    BSBootstrapConfig bconfig=BSBootstrapConfig.getInstance();
    String bstRootDir=bconfig.getProperty(BSConfig.RUNTIME_ROOT_DIRECTORY);
    if(bstRootDir==null){
        bstRootDir=System.getProperty(BSConfig.RUNTIME_ROOT_DIRECTORY);
    }
    java.io.File file=new java.io.File(application.getRealPath("/factory/designer/initializeIfNecesary.jsp")+"\\..\\..\\..\\WEB-INF");
    if(bstRootDir==null)
       com.bowstreet.servlet.J2EEDeploymentHandler.setRuntimeProperties(config,file.getCanonicalPath(),"bowstreet5");//,file.getCanonicalPath());
%>
<HTML>
<BODY>
</BODY>
</HTML>