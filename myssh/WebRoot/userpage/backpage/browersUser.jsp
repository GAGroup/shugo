<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'browersUser.jsp' starting page</title>
    
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
  <button onclick="window.location='userpage/backpage/addUserManager.jsp'">添加用户</button>
    <table cellpadding="0" cellspacing="0" border="1">
    	<thead>商品管理员用户</thead>
    	<tr>
    		<td>用户名</td>
    		<td>联系方式</td>
    		<td>用户角色</td>
    		<td>创建时间</td>
    		<td>邮箱</td>
    		<td>操作</td>
    	</tr>
    	<tr>
    		<td><input type="text" name="" > </td>
    		<td><input type="text" name="" > </td>
    		<td><input type="text" name="" > </td>
    		<td><input type="text" name="" > </td>
    		<td><input type="text" name="" > </td>
    		<td><button value="" name="">搜索</button></td>
    	</tr>
    	<tr>
    		<td>****</td>
    		<td>11111111111</td>
    		<td>商品管理员</td>
    		<td>2014年12月30日</td>
    		<td>1111@qq.com</td>
    		<td>
    			<a href="">禁用</a>|
    			<a href=""> 查看</a>|
    			<a href="userpage/backpage/editUser.jsp">编辑</a>|
    			<a href="success.jsp">删除</a></td>
    	</tr>
    	<tr>
    		<td>****</td>
    		<td>11111111111</td>
    		<td>商品管理员</td>
    		<td>2014年12月30日</td>
    		<td>1111@qq.com</td>
    		<td>
    			<a href="">禁用</a>|
    			<a href=""> 查看</a>|
    			<a href="userpage/backpage/editUser.jsp">编辑</a>|
    			<a href="success.jsp">删除</a></td>
    	</tr>
    	<tr>
    		<td>****</td>
    		<td>11111111111</td>
    		<td>商品管理员</td>
    		<td>2014年12月30日</td>
    		<td>1111@qq.com</td>
    		<td>
    			<a href="">禁用</a>|
    			<a href=""> 查看</a>|
    			<a href="userpage/backpage/editUser.jsp">编辑</a>|
    			<a href="success.jsp">删除</a></td>
    	</tr>
    	<tr>
    		<td>****</td>
    		<td>11111111111</td>
    		<td>商品管理员</td>
    		<td>2014年12月30日</td>
    		<td>1111@qq.com</td>
    		<td>
    			<a href="">禁用</a>|
    			<a href=""> 查看</a>|
    			<a href="userpage/backpage/editUser.jsp">编辑</a>|
    			<a href="success.jsp">删除</a></td>
    	</tr>
    	<tr>
    		<td>****</td>
    		<td>11111111111</td>
    		<td>商品管理员</td>
    		<td>2014年12月30日</td>
    		<td>1111@qq.com</td>
    		<td>
    			<a href="">禁用</a>|
    			<a href=""> 查看</a>|
    			<a href="userpage/backpage/editUser.jsp">编辑</a>|
    			<a href="success.jsp">删除</a></td>
    	</tr>
    	<tr>
    		<td>****</td>
    		<td>11111111111</td>
    		<td>商品管理员</td>
    		<td>2014年12月30日</td>
    		<td>1111@qq.com</td>
    		<td>
    			<a href="">禁用</a>|
    			<a href=""> 查看</a>|
    			<a href="userpage/backpage/editUser.jsp">编辑</a>|
    			<a href="success.jsp">删除</a></td>
    	</tr>
    </table>
  </body>
</html>
