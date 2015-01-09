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
    
  
    <!-- 异步处理 -->
     <button onclick="window.location='pagesetpage/friendlink/addFriendlink.jsp'" value="">添加友情链接</button><br>
    <table cellspacing="0" border="1" cellpadding="1">
    	<thead>友情链接</thead>
    	<tr>
    		<th>链接名称</th>
    		<th>链接路径</th>
    		<th>链接描述描述</th>
    		<th>创建者</th>
    		<th>创建时间</th>
    		<th>显示位置</th>
    		<th>操作</th>
    	</tr>
    	<tr>
    		<td>淘宝网</td>
    		<td>http://www.taobao.com</td>
    		<td>淘宝购物入口</td>
    		<td>###</td>
    		<td>2014年12月30日</td>
    		<td>首页</td>
    		<td>
    		<a href="success.jsp">隐藏</a>|
    		<a href="success.jsp">修改</a>|
    		<a href="success.jsp">删除</a>
    		</td>
    	</tr>
    	<tr>
    		<td>淘宝网</td>
    		<td>http://www.taobao.com</td>
    		<td>淘宝购物入口</td>
    		<td>###</td>
    		<td>2014年12月30日</td>
    		<td>首页</td>
    		<td>
    		<a href="success.jsp">隐藏</a>|
    		<a href="success.jsp">修改</a>|
    		<a href="success.jsp">删除</a>
    		</td>
    	</tr>
    	<tr>
    		<td>淘宝网</td>
    		<td>http://www.taobao.com</td>
    		<td>淘宝购物入口</td>
    		<td>###</td>
    		<td>2014年12月30日</td>
    		<td>首页</td>
    		<td>
    		<a href="success.jsp">隐藏</a>|
    		<a href="success.jsp">修改</a>|
    		<a href="success.jsp">删除</a>
    		</td>
    	</tr>
    	<tr>
    		<td>淘宝网</td>
    		<td>http://www.taobao.com</td>
    		<td>淘宝购物入口</td>
    		<td>###</td>
    		<td>2014年12月30日</td>
    		<td>首页</td>
    		<td>
    		<a href="success.jsp">隐藏</a>|
    		<a href="success.jsp">修改</a>|
    		<a href="success.jsp">删除</a>
    		</td>
    	</tr>
    	<tr>
    		<td>淘宝网</td>
    		<td>http://www.taobao.com</td>
    		<td>淘宝购物入口</td>
    		<td>###</td>
    		<td>2014年12月30日</td>
    		<td>首页</td>
    		<td>
    		<a href="success.jsp">隐藏</a>|
    		<a href="success.jsp">修改</a>|
    		<a href="success.jsp">删除</a>
    		</td>
    	</tr>
    	<tr>
    		<td>淘宝网</td>
    		<td>http://www.taobao.com</td>
    		<td>淘宝购物入口</td>
    		<td>###</td>
    		<td>2014年12月30日</td>
    		<td>首页</td>
    		<td>
    		<a href="success.jsp">隐藏</a>|
    		<a href="success.jsp">修改</a>|
    		<a href="success.jsp">删除</a>
    		</td>
    	</tr>
    </table>
  </body>
</html>
