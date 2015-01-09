<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>  
	<script type="text/javascript" src="resources/ckfinder/ckfinder.js"></script>
	
	 <% 
  List list = new ArrayList();
  list.add("dsfasd");
  request.setAttribute("mails", list); %>
	
  </head>
  
  <body>
   	首页
   	<a href="globepage/login.html">管理员平台登录</a>
   	<display:table name="mails" list="mails" cellspacing="1" cellpadding="1">
	  
	  <display:caption>This is the table caption</display:caption>
	</display:table>
  </body>
</html>
