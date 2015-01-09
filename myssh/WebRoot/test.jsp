<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="dispaly" uri="http://displaytag.sf.net" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- displaytag样式 -->
	<link rel="stylesheet" type="text/css" href="css/screen.css" media="screen,print">

  </head>
  
  <body>
  <%
  List list = new ArrayList();
  list.add("adfasdf");
  list.add("adfasdf");
  list.add("adfasdf");
  list.add("adfasdf");
  request.setAttribute("list", list);
   %>
    <dispaly:table name="list" pagesize="2" id="ab" 
    export="true" class="Simple" ><!-- ISIS,ITS,Mars,Simple -->
    </dispaly:table>
   <!--  <display:caption>
        <font size="7">
            Caption of The Table
        </font>
</display:caption> -->
<display:footer>
dsdffs
</display:footer>
  </body>
</html>
