<!--
/**
*
* Licensed Materials - Property of IBM 
* 5724-Od03
* © Copyright 2004, 2007. IBM Corp. All rights reserved.
* US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
*
* The Program may contain sample source code or programs, which illustrate programming techniques. You may only copy, modify, 
* and distribute these samples internally. These samples have not been tested under all conditions and are provided to you by
* IBM without obligation of support of any kind.
*
* IBM PROVIDES THESE SAMPLES "AS IS" SUBJECT TO ANY STATUTORY WARRANTIES THAT CANNOT BE EXCLUDED. IBM MAKES NO WARRANTIES OR 
* CONDITIONS, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OR CONDITIONS OF MERCHANTABILITY, 
* FITNESS FOR A PARTICULAR PURPOSE, AND NON-INFRINGEMENT REGARDING THESE SAMPLES OR TECHNICAL SUPPORT, IF ANY.
*
*/
-->
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>



<%!
  // Set these to the JNDI path of the desired DataSource.
  static final private String jndiPath = "java:comp/env";
  static final private String dataSourceName = "jdbc/BPF-DATA";
  static final private String tableName = "EMPLOYEE";

  // Set this to the SQL statement you want to execute.
  static final private String sqlStatement = "select * from employee";

  // A cached DataSource will be dropped here upon the first
  // page view of the JSP.  That DataSource will be used for
  // all JSP instances.
  static private DataSource dataSource = null;
  static private String dsTypeDS = null;
  static private String dsTypeCPDS = null;
  static private String dsTypeWSDS = null;

  static
  {
    try
    {
      // These are boiler-plate; you probably don't want to
      // modify these unless the app server has organized the
      // JNDI space strangly.
      final Context initContext = new InitialContext();
      final Context context = (Context) initContext.lookup( jndiPath );
      final Object object = context.lookup( dataSourceName );
      if (object instanceof javax.sql.DataSource)
           dsTypeDS = "DataSource";
      // Initialize the common DataSource instance.  We do this
      // to verify that the obtained object is actually castable
      // to a DataSource.
      dataSource = (DataSource) object;
    }
    catch( Exception e )
    {
      e.printStackTrace(); 
    }
  }
%>

<html>
<head>
   <style>
      h2	  { font-size: 12pt;
			    font-family : Arial, Helvetica, sans-serif;
			    margin-bottom : 0;
			  }
      h3	  { font-size : 12pt;
			    font-family : Arial, Helvetica, sans-serif;
			  }
	  p,li		  { font-size : 10pt;
			    font-family : Arial, Helvetica, sans-serif;
			  }
   </style>
</head>
<body>
<h2>DataSource Info: Primary Keys</h2>
<p>Running this page assists in troubleshooting problems using the database-related 
builders in Factory. This page determines whether the trouble is with the data source being
used or with Factory. This page successfully runs if at the bottom of the page you see
the Primary Key information for the specified table.</p>

<p>This page fails if an error gets displayed during the lookup of the datasource object or
the creation of the connection, creation, or execution of the SQL statement. If this page
fails, check your datasource configuration and/or your application server environment. 
</p>

<hr />
<h3>DataSource JNDI Name and SQL Statement</h3>

<p>JNDI name used: <%=dataSourceName %><br />
SQL Statement executed: <%=sqlStatement %></p>



<h3>Primary Key Information</h3>
<%
  if (dataSource != null) {
  int rows = -1;
  Connection connection = null;
  Statement statement = null;
  ResultSet resultSet = null;

  try
  {
  	connection = dataSource.getConnection(); 
  	DatabaseMetaData dmd = connection.getMetaData();
  	ResultSet pkeyrs=dmd.getPrimaryKeys(null,null,tableName);
	ResultSetMetaData pmd=pkeyrs.getMetaData();
	out.write("<table border=\"1\">\n");
	out.write("<tr><th>Column Name</th><th>Key Sequence</th><th>Constraint Name</th></tr>\n");
	while(pkeyrs != null && pkeyrs.next()){
	  out.write("<tr>");
	  out.write("<td>"+ pkeyrs.getString(4) + "</td>"
		+"<td>" + pkeyrs.getInt(5)+ "</td>"
		+ "<td>" + pkeyrs.getString(6) + "</td>"); 
	  out.write("</tr>\n");
    	}
    
%>


<%
  }
  catch( Exception e )
  {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream( baos );
    e.printStackTrace( ps ); 
%>

<pre>
Exception:
<%= baos.toString() %>
</pre>

<%
  }
  finally
  {
    try { if( resultSet != null ) resultSet.close(); } catch( Exception ignore ) {}
    try { if( statement != null ) connection.close(); } catch( Exception ignore ) {}
    try { if( connection != null ) connection.close(); } catch( Exception ignore ) {}
  }
}
else { out.write("<p>The dataSource object is null. Make sure the JNDI name you specified for the DataSource is correct.</p>"); }
%>

</body>
</html>


