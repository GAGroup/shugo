<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<link rel="stylesheet" type="text/css" href="resources/script/resources/css/ext-all.css">
    <script type="text/javascript" src="resources/script/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="resources/script/ext-all.js"></script>
    <script type="text/javascript" src="resources/script/resources/locale/ext-lang-zh_CN.js"></script>
	<script type="text/javascript">
	Ext.onReady(function(){
			//jsp和html的路径写法不同
			enableDrag:true;
    		var tree = new Ext.tree.TreePanel({
    		el:'left',
    		loader:new Ext.tree.TreeLoader({dataUrl:'globepage/1.txt'}),
    		  autoScroll: true,//允许滚动条     
                 
            // tree-specific configs:     
            // 树控件的特有的配置选项     
            rootVisible: true,//隐藏根结点     
            lines: true,     
            singleExpand: false,//同时只能打开一个树,当打开其中任何一个树时,将会关闭其他已经打开的树目录     
            useArrows: true,//树形目录使用visita中树目录显示效果(三角形代替+号)
    		});
    		var root = new Ext.tree.AsyncTreeNode({text:'商云管理',expanded:false});
    		tree.setRootNode(root);
    		tree.render();
    		root.expand(false,false);//默认结点不展开
    	
    		
    		 
    		
    		//指定张开结点
    		/* tree.on("expandnode",function(node){alert(node.text+"展开");});
    		tree.on("collapsenode",function(node){alert(node.text+"折叠");});
    		tree.on("click",function(node){alert(node.text+"单击");});
    		tree.on("dblclick",function(node){alert(node.text+"双击");}); */
    	});
	</script>

  </head>
  
  <body>
   <div id="left" ></div>
  </body>
</html>
