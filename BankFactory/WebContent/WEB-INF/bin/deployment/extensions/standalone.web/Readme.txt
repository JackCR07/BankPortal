This folder is for customer specific extensions to the generated web.xml deployment descriptor for standalone web application WARs.

All extension fragments must be in an XML file or files containing a <web-app> element and then the children you wish to extend web.xml with.
Extension filenames must end with .xml,  any other files not ending with .xml will be ignored.

Note, the <display-name> element is set by WPF deployment code and should not be included in an extension fragment.

Most web.xml extension structures will be "added" to the generated web.xml.
For login-config and welcome-file-list, since they should only appear once, they will "replace" those structures from the WPF template, if they appear in an extension fragment, 

For example, to create a web.xml extension fragment to add a servlet to the generated web.xml deployment descriptor, you would have a file ending in ".xml" with the following contents:

<web-app xmlns="http://java.sun.com/xml/ns/j2ee">

  <servlet>
    <servlet-name>MyNewServlet</servlet-name>
    <servlet-class>
      com.my.new.servlet.MyNewServlet
    </servlet-class>
  </servlet>

  <servlet-mapping>
      <servlet-name>MyNewServlet</servlet-name>
      <url-pattern>/mynewservlet/*</url-pattern>
  </servlet-mapping>
  
</web-app>
