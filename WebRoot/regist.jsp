<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<html>
  <head>
    <title>注册界面</title>
    
    <script type="text/javascript">
  	function test(){
		var image = document.getElementsByTagName("img")[0];
		var myDate = new Date();
		image.src = "${pageContext.request.contextPath }/image.jsp?time="+myDate.getTime();
  	 }
</script> 
  </head>
  
  <body>
	 <div id="header">
		<h1 align="center"><a style="float:left" href="${pageContext.request.contextPath }/index.jsp">个人任务系统</a></h1>
	    <ul style="list-style:none;float:left">
		   <font color="red"><s:property value="#attr.msg" /></font>
	       <li style="float:left"><a href="${pageContext.request.contextPath }/index.jsp">首页</a></li>
	       <li style="float:left"><a href="${pageContext.request.contextPath }/login.jsp">登录</a></li>
	       <li style="float:left"><a href="${pageContext.request.contextPath }/regist.jsp">注册</a></li>
	    </ul>
	</div> 
	<br><br>
	<form method="post" action="${pageContext.request.contextPath}/regist">
		<dl>
			<dd>注册名:<input type="text" name="user.username"/></dd>
			<dd>注册密码:<input type="password" name="user.password"/></dd>
			<dd>验证码:<input id="vali" type="text" name="valistr" class="code"/><img id="vali" alt="" onclick="test();" src="${pageContext.request.contextPath }/image.jsp"></dd>
         <dd><input type="submit" class="sumbit" value="注册"/></dd>
		</dl>
	</form>
	
  </body>
</html>
