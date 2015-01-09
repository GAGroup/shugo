<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  
  	<h1>发布文章</h1>
  <table>
  	<tr>
  		<td>发布到
  			<select>
  				<option>公告</option>
  				<option>促销</option>
  				<option>优惠</option>
  				<option>广告</option>
  			</select>
  		<td>
  	</tr>
  	<tr>
  	<td>
  		 <textarea id="editor_text" name="content" rows="12" cols="450">编辑发布文章</textarea>
					<ckfinder:setupCKEditor basePath="resources/ckfinder/" editor="editor1" />
					<ckeditor:replace replace="editor1" basePath="ckeditor/" />
	</td>
  	</tr>
  
  
  </table>
  
  
   
					
					<!-- editor.document.getBody().getText(); //取得纯文本
						有漏洞，可以直接访问查看finder=====ckfinder/ckfinder.html
						editor.document.getBody().getHtml(); //取得html文本 -->
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
CKFinder.setupCKEditor(editor, 'resources/ckfinder' );
// It is also possible to pass an object with selected CKFinder properties as a second argument.
// CKFinder.SetupCKEditor( editor, { BasePath : '../../', RememberLastFolder : false } ) ;
}
</script>