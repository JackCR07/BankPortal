<HTMLWRAPPER name="menuId"><%String menuId = "toBeChanged"; %></HTMLWRAPPER>
<HTMLWRAPPER name="position"><%String position = "toBeChanged"; %></HTMLWRAPPER>
<HTMLWRAPPER name="newMenuId"><%String newMenuId=webAppAccess.getInstanceID()+menuId;%></HTMLWRAPPER>
	<table role="presentation" border="0" cellpadding="0" cellspacing="0" width="0">
		<tr role="presentation">
			<td role="presentation" align="right">	
<div id="menuControl<%= newMenuId %>"  style="visibility:visible;overflow:visible;z-index:0;width:auto;">	
			<HTMLWRAPPER id="button<%= newMenuId %>" classButton="actionMenuButton" classLink="ContextualMenuText" valign="top" name="MenuControl" onclick="javascript:ContextualMenuToggleMenu('menuControl<%= newMenuId %>','menu<%= newMenuId%>','<%= position%>');" onmouseover="javascript:ContextualMenuShowImg('imgmenu<%= newMenuId%>')" onfocus="javascript:ContextualMenuShowImg('imgmenu<%= newMenuId%>')" onmouseout="javascript:ContextualMenuHideItem('imgmenu<%= newMenuId%>')" onblur="javascript:ContextualMenuHideItem('imgmenu<%= newMenuId%>');">
			    <nobr>
				<HTMLWRAPPER name="menuTextValue"></HTMLWRAPPER>
				<img name="menuImageValue" id="imgmenu<%= newMenuId %>" align="middle" style="vertical-align: middle;visibility:hidden;" border='0'  alt="" title=""></img>								
				</nobr>
			</HTMLWRAPPER>
</div>
			</TD>			
		</TR>
	</TABLE>	
					
<div id="menu<%= newMenuId%>" style="visibility:hidden;position:absolute;display:block;z-index:1;"> 
	<table role="presentation" name="menuItemsTable" border="0" cellpadding="" cellspacing="0" class="ContextualMenuTable"> 
		<HTMLWRAPPER name="menuItem">
			<tr role="presentation" >
				<HTMLWRAPPER name="menuItemID"><%String menuItemID="toBeChanged"; %></HTMLWRAPPER>
				<HTMLWRAPPER name="newMenuItemID"><%String newMenuItemID=webAppAccess.getInstanceID()+menuItemID; %></HTMLWRAPPER>
				<td role="presentation" align="left" width="100%" name="menuItemTD" id="<%= newMenuItemID %>" nowrap class="ContextualMenuITD">
				<a name="menuItemLink" href="#" onmouseover="javascript:ContextualMenuHandleMenuItemTD('<%= newMenuItemID %>',true);" onmouseout="javascript:ContextualMenuHandleMenuItemTD('<%= newMenuItemID %>',false);"  class="ContextualMenuIText" id="wacmenuOptionId<%= newMenuId%>"></a>
				</td>			
			</tr> 
		</HTMLWRAPPER>
		<HTMLWRAPPER name="menuItemLine"><tr role="presentation"><td role="presentation"><hr name="menuItemLineHR" /></td></tr></HTMLWRAPPER>
	</table>
</div>
<!--[if lt IE 7]>
<script LANGUAGE="JavaScript">
document.getElementById('menuControl<%= newMenuId %>').style.width='0px'; 
</script>
<![endif]-->

<script LANGUAGE="JavaScript">
document.getElementById('button<%= newMenuId %>').className='actionMenuButton';
if (window.navigator.userAgent.indexOf("MSIE")>=1)
{
document.getElementById('menu<%= newMenuId%>').style.left='-1000px';
document.getElementById('menu<%= newMenuId%>').style.top='-1000px';
}
</script>
