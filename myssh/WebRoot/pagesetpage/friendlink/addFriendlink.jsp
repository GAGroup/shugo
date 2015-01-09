<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addUserCategory.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    
 
    
     <button onclick="window.location='userpage/backpage/addFriendlink.jsp'" value="创建角色">创建角色</button><br>
    <table cellspacing="0" border="1" cellpadding="1">
    	<thead>添加友情链接</thead>
    	<tr>
    		<td>链接名称</td>
    		<td><input name="" type="text"></td>
    	</tr>
    	<tr>
    		<td>链接地址</td>
    		<td><input name="" type="text"></td>
    	</tr>
    	<tr>
    		<td>链接图片</td>
    		<td><input name="" type="text"></td>
    	</tr>
    	<tr>
    		<td>链接描述</td>
    		<td><input name="" type="text"></td>
    	</tr>
    	<tr>
    		<td>显示位置</td>
    		<td><input name="" type="text"></td>
    	</tr>
    	<tr>
    		<td></td>
    		<td><input type="submit" value="创建"></td>
    	</tr>
    </table>
  </body>
</html>
