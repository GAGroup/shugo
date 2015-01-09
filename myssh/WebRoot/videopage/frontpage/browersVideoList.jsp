<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'browersVideoList.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/screen.css" media="screen,print">

  </head>
  
  <body>
  <div>
	<!-- 云存储做到负载均衡--减轻服务器负担 -->
   
  <table bgcolor="#e8ebeb" border="1" cellspacing="1">
  	<thead>影音列表</thead>
  	<tr>
  		<th>图片</th>
  		<th>影音名称</th>
  		<th>影音简介</th>
  		<th>上传时间</th>
  		<th>状态</th>
  		<th>访问量</th>
  		<th>收费</th>
  		<th>操作</th>
  	</tr>
  	<c:forEach items="${videoList }" var="video">
  	<tr>
  		<td>
  		<%-- <video width="120" height="120" controls="controls">
		  <source src="${video.visitPath }" type="video/mp4" />
		  <source src="${video.visitPath }" type="video/ogg" />
		  <object data="${video.visitPath }" width="20" height="20">
		    <embed src="${video.visitPath }" width="20" height="20" />
		  </object>
		</video> --%>
		<img alt="${video.videoName }" src="${video.ex }" height="100" width="100">
	  	<%-- 	<a href="${video.visitPath }">
	 			<img alt="${video.videoName }" src="${video.ex }" height="100" width="100">
	 		</a> --%>
 		</td>
  		<td width="10">${video.videoName }</td>
  		<td>${video.videoDesc }</td>
  		<td width="10">${video.uploadTime }</td>
  		<td>
  		<c:if test="${video.videoState==null }">
  			未发布
  		</c:if>
  		<c:if test="${video.videoState!=null }">
  			已发布
  		</c:if>
  		</td>
  		<td>${video.visitedTimes==null? 0:video.visitedTimes }</td>
  		<td>${video.visitValue }</td>
  		<td> 
  		<a href="${video.visitPath }">查看</a>
  		<a href="${video.visitPath }">删除</a>
  		<a href="${video.visitPath }">下线</a>
  		</td>
  	</tr>
  	</c:forEach>
  </table>

	<display:table name="videoList" id="video" export="true" pagesize="10" 
	requestURI="video/browersVideoList.action" excludedParams="asdf">
	
	<display:column property="videoName" title="影音名称" href="${video.visitPath }"></display:column> 
	<display:column property="visitedTimes" title="访问次数"></display:column>	
	<display:column property="uploadTime" title="上传时间"></display:column>	
	</display:table>
	
  </body>
</html>
