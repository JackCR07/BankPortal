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
<%@ page import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.ResultSetMetaData, javax.naming.Context, javax.naming.InitialContext, javax.sql.DataSource" session="false" %>
<%@ page import="java.io.StringWriter" %>
<%@ page import="java.io.PrintWriter" %>

<%
String dsname = request.getParameter("datasource");
String query = request.getParameter("query");
String username = request.getParameter("username");
String password = request.getParameter("password");
if (dsname == null) dsname = "";
if (query == null) query = "";
if (username == null) username = "";
if (password == null) password = "";
%>
<html>
    <head>
    	<title>DataSource Tester 2</title>
    	<style>
    		h1	  { font-size: 14pt;
				    font-family : Arial, Helvetica, sans-serif;
				    margin-bottom : 0;
				  }
	      h2	  { font-size: 12pt;
				    font-family : Arial, Helvetica, sans-serif;
				    margin-bottom : 0;
				  }
	      h3	  { font-size : 12pt;
				    font-family : Arial, Helvetica, sans-serif;
				  }
	      p,li	  { font-size : 10pt;
				    font-family : Arial, Helvetica, sans-serif;
				  }
   	</style>
    </head>
    <body>
    	<h1>DataSource Tester</h1>
    	<p>This page fails if an error gets displayed during the lookup of the datasource object or
	the creation of the connection, creation, or execution of the SQL statement. If this page
	fails, check your datasource configuration and/or your application server environment. Some common causes
	of DataSource misconfiguration include:
	</p>
	<ul>
	  <li>Inappropriate JDBC Driver implementation class specified for the DataSource. Specifically, Factory does
	      not support transactional JDBC Driver class implmentations. Typical JDBC Driver implementations that are 
	      known to work are:
	      <ul>
	         <li><b>DB2</b>&nbsp;--&nbsp;COM.ibm.db2.jdbc.DB2ConnectionPoolDataSource</li>
	         <li><b>Oracle</b>&nbsp;--&nbsp;oracle.jdbc.pool.OracleConnectionPoolDataSource</li>
	         <li><b>SQL Server 2000</b>&nbsp;--&nbsp;com.microsoft.jdbc.sqlserver.SQLServerDataSource</li>
	      </ul></li>
	  <li>Bad credentials specified in the data source configuration. Confirm that the credentials for the DataSource 
	  specify a user name and password for a valid user with appropriate DB permissions.</li>
	  <li>Class collisions: Confirm that you do not multiple versions of the JDBC driver classes
	      being loaded by the application server. <b>Note:</b> "Testing" the datasource in this case will
	      be  successful, but the datasource will fail in use.</li>
	</ul>

        <h1>Read DB Data</h1>
        Enter the name of the JNDI data source and a query to execute against 
        that data source. The page will display the data along with the time needed to fetch it.
        <form method="post">
           <table  role="presentation">
           <tr  role="presentation"><td  role="presentation">Data source:</td><td  role="presentation"><input size="50" type="text" name="datasource" value="<%= dsname %>" /></td></tr>
           <tr  role="presentation"><td  role="presentation">User name:</td><td  role="presentation"><input size="50" type="text" name="username" value="<%= username %>" /></td></tr>
           <tr  role="presentation"><td  role="presentation">Password:</td><td  role="presentation"><input size="50" type="text" name="password" value="<%= password %>"  /></td></tr>
           </table>
           Query:<br />
           <textarea name="query" rows="20" cols="50"><%= query %></textarea><br />
           <input type="submit" value="Lookup" /><br />
           <hr />

<%
               
        if (dsname != null && dsname.trim().length() > 0 && query != null && query.trim().length() > 0)
        {
          long t0 = System.currentTimeMillis();
          Context ctx = new InitialContext();
          DataSource ds = null;
          Connection con = null;
          ResultSet rs = null;
          PreparedStatement pstmt = null;
          try {
            ds = (DataSource)ctx.lookup(dsname);
            if (username != null && username.length() > 0 && password != null
                    && password.length() > 0)
                con = ds.getConnection(username, password);
            else
                con = ds.getConnection();

            con.setAutoCommit(false);
            pstmt = con.prepareStatement(query);

            rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int nCols = rsmd.getColumnCount();
            
            String data = "<table>";
            int nRows = 0;
            while (rs.next())
            {  
                nRows++;
                String row = "<tr>";
                
                for (int i = 1; i <= nCols; i++)
                {
                    row += "<td>" + rs.getObject(i) + "</td>";                    
                }
                row += "</tr>";
                data += row;
            }

            data += "</table>";
            long t1 = System.currentTimeMillis();
            long millis = t1 - t0;
            double secs = millis / 1000.0;
            data = "<h3>Read " + nRows + " rows in " + secs + " seconds</h3>" + data;
            out.println(data);
          }
          catch( Throwable t )
          {
      		final StringWriter sw = new StringWriter();
    		final PrintWriter pw = new PrintWriter( sw );
    		t.printStackTrace( pw );
    		pw.close();

    		final String s = sw.toString();
    		out.println("<br><br><b>Exception:</b><pre>" + s + "</pre>" );
          }
          finally
          {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
          } 
        }
%>
            
        </form>
    </body>
</html>
