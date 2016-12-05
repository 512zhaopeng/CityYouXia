<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery1.11.3.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
  </head>
  
  <body> 
  	<input type="text"  id="content"/>
    <input type="button" value="ajax-get" id="btn"/>
    
    <form action="<%=basePath%>fileOper/uploadHelpImage.do" method="post" enctype="multipart/form-data">   
		<input name="image1" id="image1" type="file" /><br>
		<input name="image2" id="image2" type="file" /><br>
		<input name="helpId" id="helpId" value="1"/><br>
		<input name="name" id="name" value="好惨"/><br>
		<input type="submit" value="上传"/>
	</form>  
  </body>
</html>
