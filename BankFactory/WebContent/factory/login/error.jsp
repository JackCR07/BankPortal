
<%@ page isErrorPage="true" %>

<html>
<head>
<title>Login Error Page</title>
</head>

<body>

<center>
<h1>Login Error Page</h1>
</center>

<h2>Not Authorized.</h2>
<p>
Either the account/password are not valid or this user is not allowed to access the requested resource.
<p>
Use the Browser's BACK button and try again.

<% if (exception != null) { %>
<pre>
<%= exception %> 
</pre>
<% } %>

</body>
</html>
