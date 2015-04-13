This folder is for customer specific extensions to the generated portlet.xml deployment descriptor for JSR286 portlet WARs.

All extension fragments must be in an XML file or files containing a <portlet-app> element and then the children you wish to extend portlet.xml with.
Extension filenames must end with .xml,  any other files not ending with .xml will be ignored.

For example, to add portlet filters to the generated portlet.xml descriptor, create a file in this folder with a filename ending in ".xml" containing something like the following structure.

<portlet-app xmlns="http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd">

    <filter>
        <filter-name>Log Filter</filter-name>
        <filter-class>com.my.LogFilter</filter-class> 
        <lifecycle>ACTION_PHASE</lifecycle> 
        <lifecycle>RENDER_PHASE</lifecycle>
    </filter> 

    <filter>
        <filter-name>Audit Filter</filter-name>
        <filter-class>com.my.AuditFilter</filter-class> 
        <lifecycle>ACTION_PHASE</lifecycle> 
        <lifecycle>RENDER_PHASE</lifecycle>
        <lifecycle>EVENT_PHASE</lifecycle>
    </filter> 

    <filter-mapping> 
        <filter-name>Log Filter</filter-name> 
        <portlet-name>SamplePortlet</portlet-name> 
    </filter-mapping> 

    <filter-mapping> 
        <filter-name>Audit Filter</filter-name> 
        <portlet-name>*</portlet-name> 
    </filter-mapping> 

</portlet-app>
