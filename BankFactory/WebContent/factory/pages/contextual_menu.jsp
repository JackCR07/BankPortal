<SPAN name="contextualMenuOuterWrapper">
<HTMLWRAPPER name="menuId"><%String menuId = "toBeChanged"; %></HTMLWRAPPER>
<HTMLWRAPPER name="position"><%String position = "toBeChanged"; %></HTMLWRAPPER>
	<TABLE role="presentation" border="0" cellpadding="0" cellspacing="0" width="0">
		<TR role="presentation">
			<TD role="presentation">	
<div id="menuControl<%= menuId %>"  style="visibility:visible;overflow:visible;z-index:0;width:auto;">	
			<HTMLWRAPPER classButton="ContextualMenuDialogIconBackground" classLink="ContextualMenuText" valign="top" name="MenuControl" onclick="javascript:ContextualMenuToggleMenu('menuControl<%= menuId %>','menu<%= menuId%>','<%= position%>');" onmouseover="javascript:ContextualMenuShowImg('imgmenu<%= menuId%>')" onfocus="javascript:ContextualMenuShowImg('imgmenu<%= menuId%>')" onmouseout="javascript:ContextualMenuHideItem('imgmenu<%= menuId%>')" onblur="javascript:ContextualMenuHideItem('imgmenu<%= menuId%>');">
			    <nobr><HTMLWRAPPER name="menuTextValue"></HTMLWRAPPER><img name="menuImageValue" id="imgmenu<%= menuId %>" align="middle" style="vertical-align: middle;" border='0'  alt="" title=""></img></nobr>
			</HTMLWRAPPER>
</div>
			</TD>			
		</TR>
	</TABLE>	
					
<div id="menu<%= menuId%>" style="visibility:hidden;position:absolute;z-index:1;"> 
	<table role="presentation" name="menuItemsTable" border="0" cellpadding="" cellspacing="0" class="ContextualMenuTable"> 
		<HTMLWRAPPER name="menuItem">
			<tr role="presentation">
				<HTMLWRAPPER name="menuItemID"><%String menuItemID="toBeChanged"; %></HTMLWRAPPER>
				<td role="presentation" width="100%" name="menuItemTD" id="<%= menuItemID %>" nowrap class="ContextualMenuITD">
				<a name="menuItemLink" href="#" onmouseover="javascript:ContextualMenuHandleMenuItemTD('<%= menuItemID %>',true);" onmouseout="javascript:ContextualMenuHandleMenuItemTD('<%= menuItemID %>',false);"  class="ContextualMenuIText" id="wacmenuOptionId<%= menuItemID%>"></a>
				</td>			
			</tr> 
		</HTMLWRAPPER>
		<HTMLWRAPPER name="menuItemLine"><tr role="presentation"><td role="presentation"><hr name="menuItemLineHR" /></td></tr></HTMLWRAPPER>
	</table>
</div>

<!--[if lt IE 7]>
<script type="text/javascript">
document.getElementById('menuControl<%= menuId %>').style.width='0px'; 
</script>
<![endif]-->

<script type="text/javascript">
if (window.navigator.userAgent.indexOf("MSIE")>=1)
{
document.getElementById('menu<%= menuId%>').style.left='-1000px';
document.getElementById('menu<%= menuId%>').style.top='-1000px';
}
</script>
</SPAN>
