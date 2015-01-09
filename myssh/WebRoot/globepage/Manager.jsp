<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	
    <base href="<%=basePath%>">
    <title>商云管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
  </head>
  
  <frameset rows="127,*,11" frameborder="no" border="0" framespacing="0">
	<frame src="globepage/top.html" name="topFrame" scrolling="No"
		noresize="noresize" id="topFrame" />
	<frame src="globepage/center.html" name="mainFrame" id="mainFrame" />
	<frame src="globepage/down.html" name="bottomFrame" scrolling="No"
		noresize="noresize" id="bottomFrame" />
</frameset>
<noframes>
<body>
</body>
</noframes>
  
 <!-- <frameset rows="100,*" border="1" framespacing="1">
	<frame name="top" src="globepage/head.html"> 
	<frameset cols="150,*">
		<frame name="left" src="globepage/left.jsp">
		<frame name="right" src="globepage/right.jsp"> 
	</frameset> 
</frameset> -->
  
  <!-- <body>
  <div id="div-tree"></div>
    <div id = "contener">
  		<div id="top"><h1> 实验室建设申报系统</h1></div>
  		<div id="bander"></div>
  		<div id="mid"><div id="left"></div><div id="right"  class="right">右边是显示内容，链接到的页面在此处显示</div></div>
  		<div id="buttom">底部栏目</div>
  	</div> 
  </body>-->
</html>
