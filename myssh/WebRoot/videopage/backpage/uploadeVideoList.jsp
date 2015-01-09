<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'uploadeVideoList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="../resource/js/jquery.js"></script>
	<script type="text/javascript">
	
	
	</script>
  </head>
  
  <body>
    <s:form action="video/UploadeVideoList.action" enctype="multipart/form-data" id="uploadform" method="post" namespace="/video">  
           影音类别：
			<select name="videoType">
  				<c:forEach items="${videoType }" var="type">
  					<option value="${type.videoTypeId }" label="${type.videoTypeName }">${type.videoTypeName }</option>
  				</c:forEach>
  			</select>

		  <br/>
           <s:file label="上传文件" name="videos"></s:file>  <br/>
           <s:file label="上传文件" name="videos"></s:file>  <br/>
           <s:file label="上传文件" name="videos" javascriptTooltip="ff"></s:file>   <br/>
           
           <s:submit value="上传" />  
       </s:form>  
  </body>
</html>
