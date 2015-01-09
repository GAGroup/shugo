<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'rigester.jsp' starting page</title>
    
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
    <h2>用户注册</h2>
    <table>
    	<tr>
    		<td>账户</td>
    		<td><input name="" type="text"/></td>
    	</tr>
    	<tr>
    		<td>邮箱</td>
    		<td><input name="" type="text"/></td>
    	</tr>
    	<tr>
    		<td>电话</td>
    		<td><input name="" type="text"/></td>
    	</tr>
    	<tr>
    		<td>密码</td>
    		<td><input name="" type="password"/></td>
    	</tr>
    	<tr>
    		<td>重输密码</td>
    		<td><input name="" type="password"/></td>
    	</tr>
    	<tr>
    		<td><input type="reset" value="重置"/></td>
    		<td><input type="submit" value="注册"/></td>
    	</tr>
    
    </table>
  </body>
</html>
