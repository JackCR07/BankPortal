<html>
<head>
<title>IBM Factory Login</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/factory/factory.css">
<script type="text/javascript">
function reallySubmit() {
 if (document.loginform.j_password.value == '') {
  alert('No PASSWORD specified. You must specify a password to log in to the IBM Factory.');
  return false;
 }
 return true;
}

function handleEnterKey(e){
   if(!e)e=event;
   if(e.which){
     if(e.which==13) doLogin();
     return;
   }
   if(e.keyCode){
      if(e.keyCode==13) doLogin();
      return;
   }
  }

 function doLogin(){
    //check validation
     var oButton = document.forms[0].submitButton;
     if ( oButton) {
        oButton.click();
     }
 }
</script>
</head>
<body body bgcolor="#ffffff" onLoad="document.loginform.j_username.focus()" >
<form name="loginform" method=POST  onSubmit='return(reallySubmit())' action='j_security_check'>
<!-- Begin Header -->
  <table  role="presentation" width="100%" border="0" cellspacing="0" cellpadding="1">
    <tr  role="presentation">
      <td  role="presentation" valign="top" width="100%" class="bg2" height="28">&nbsp;</td>
		</tr>
		<tr  role="presentation">
      <td  role="presentation" valign="top" width="100%" class="bg3">&nbsp;</td>
    </tr>
  </table>
<!-- End Header -->
  <div id="loginBoxSection" name="loginBoxSection">
  <table  role="presentation">

<% if (request.getParameter("TryAgain") != null) { %>
  <tr  role="presentation">
    <td  role="presentation" width="264">&nbsp;</td>
    <td  role="presentation" colspan="2" class="errorText">
      Either the specified username/password are not valid or this user is not allowed to access the requested resource.&nbsp;&nbsp;Please Try Again.<br><br>
    </td>
    <td  role="presentation" width="185">&nbsp;</td>
  </tr>

<% } %>

  <tr  role="presentation">
    <td  role="presentation" width="264">&nbsp; </td>
    <td  role="presentation" width="68" class="dataField"> Username: &nbsp; </td>
    <td  role="presentation" colspan="2" valign="top">
      <input type="text" name="j_username">
    </td>
  </tr>
  <tr  role="presentation">
    <td  role="presentation" width="264">&nbsp; </td>
    <td  role="presentation" ccolspan="2" width="68" class="dataField"> Password: &nbsp; &nbsp;</td>
    <td  role="presentation" align="left" width="491" valign="top">
      <input name="j_password" onKeyDown="handleEnterKey(event);return true;" type="password" >
    </td>
    <td  role="presentation" width="185">&nbsp;</td>
  </tr>
  <tr  role="presentation">
    <td  role="presentation" width="264">&nbsp;</td>
    <td  role="presentation">&nbsp;</td>
    <td  role="presentation" colspan="2">
      <input type=submit name="submitButton" value="Submit" />
    </td>
  </tr>
  <tr  role="presentation">
    <td  role="presentation" colspan="4"><br><br></td>
  </tr>
</table>
</div>
<!-- Begin Footer -->
  <table  role="presentation" width="100%"  height="20" border="0" cellspacing="0" cellpadding="0" bgcolor="#003366">
    <tr  role="presentation">
       <td  role="presentation" align="right" width="295" class="bg3">&nbsp;</td>
    </tr>
    <tr  role="presentation">
      <td  role="presentation" colspan="2" class="bg2">&nbsp;</td>
    </tr>
  </table>
  <!-- End Footer -->

</form>
</body>
</html>
