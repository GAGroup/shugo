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
 	<table cellspacing="1" border="1" cellpadding="1">
    	<thead>添加用户角色</thead>
    	<tr>
    		<td>角色名称</td>
    		<td><input name="" type="text"/></td>
    	</tr>
    	<tr>
    		<td>角色描述</td>
    		<td><textarea rows="8" cols="14"></textarea></td>
    	</tr>
    	<tr>
    		<td>角色权限</td>
    		<td>
    			<input name="" type="checkbox" value="">注册用户
    			<input name="" type="checkbox" value="">编辑用户
    			<input name="" type="checkbox" value="">删除用户
    			<input name="" type="checkbox" value="">添加商品
    			<input name="" type="checkbox" value="">删除商品
    			<input name="" type="checkbox" value="">下架商品
    		
    		</td>
    	</tr>
    	
    	<tr>
    		<td></td>
    		<td><input type="submit" value="创建"/></td>
    	</tr>
    	
    </table>
  </body>
</html>
