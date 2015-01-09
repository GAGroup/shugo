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
    
    <title>My JSP 'uploadeVideo.jsp' starting page</title>
    
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
	
  </head>
  
  <body>
  	
  		<h1><s:text name="影音上传"></s:text></h1>
  	<!-- 加上传的图片 --做封面--ex属性-->
  	<s:form method="post" enctype="multipart/form-data" theme="simple" action="uploadeVideo" namespace="/video">
  	
  		<table cellpadding="0" border="3" cellspacing="0" bordercolor="#e8ebeb">
  			<tr >
  				<td>上传影音文件</td>
  				<td><s:file name="video"></s:file></td>
  			</tr>
  			 <tr >
  				<td>外站影音</td>
  				<td><s:textfield name="visitPath" type="hidden"></s:textfield></td>
  			</tr> 
  			<tr>
  				<td>分类</td>
  				<td>
  				<select name="videoType">
  				<c:forEach items="${videoType }" var="type">
  					<option value="${type.videoTypeId }" label="${type.videoTypeName }">${type.videoTypeName }</option>
  				</c:forEach>
  				</select>
  					
  				<%-- <s:textfield label="分类" name="videoType"></s:textfield> --%>
  				
  				</td>
  			</tr>
  			<tr>
  				<td>查看级别</td>
  				<td><s:textfield label="查看权限级别" name="visitPower"></s:textfield></td>
  			</tr>
  			<tr>
  				<td>收费</td>
  				<td><s:textfield label="收费" name="visitValue"></s:textfield>（单位：￥元）</td>
  			</tr>
  			<tr>
  				<td>描述</td>
  				<td><s:textarea label="描述" name="videoDesc" rows="10" id="editor_text">影音的主要内容简介</s:textarea></td>
					<ckfinder:setupCKEditor basePath="resources/ckfinder/" editor="editor1" />
					<ckeditor:replace replace="editor1" basePath="ckeditor/" />
  			
  			
  			</tr>
  			<tr>
  				<td></td>
  				<td><s:submit value="保存"></s:submit></td>
  			</tr>
  		</table>
  	</s:form>  
  	
  </body>
</html>
<script type="text/javascript">
// This is a check for the CKEditor class. If not defined, the paths must be checked.
if ( typeof CKEDITOR == 'undefined' )
{
document.write('<strong><span style="color: #ff0000">Error</span>: CKEditor not found</strong>.' +'This sample assumes that CKEditor (not included with CKFinder) is installed in' +'the "/ckeditor/" path. If you have it installed in a different place, just edit' +'this file, changing the wrong paths in the <head> (line 5) and the "BasePath"' +'value (line 32).' ) ;
}
else
{
var editor = CKEDITOR.replace( 'editor_text' );
CKFinder.setupCKEditor(editor, '../resources/ckfinder' );
// It is also possible to pass an object with selected CKFinder properties as a second argument.
// CKFinder.SetupCKEditor( editor, { BasePath : '../../', RememberLastFolder : false } ) ;
}
</script>