<%/* 
  Copyright IBM Corp. 2010
  This page is used in samples to create a trivial "skip to main" link.
*/%>
<% 
if (request.getAttribute("wpf_skip_navigation_added") == null) {
    request.setAttribute("wpf_skip_navigation_added", Boolean.TRUE);
%>   
<div id="wpf_skip_nav_container">
<a href="#wpf_skip_nav" class="wpf_skip_nav_link">Skip Navigation</a>
</div> 
<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/factory/pages/samples/skipnav.css" />
<% String h3ID = "mainHeader" + Integer.toString((int)Math.floor(100000.0 * Math.random())); %>
<h3 role="main" id="<%= h3ID %>">Sample</h3>
<script type="text/javascript">(document.getElementById("<%= h3ID %>") || {}).innerHTML = document.title;</script>
<a name="wpf_skip_nav"></a>
<% } %>