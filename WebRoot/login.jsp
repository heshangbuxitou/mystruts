<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<html>
  <head>
    <title>登录界面</title>
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
	<form method="post" action="${pageContext.request.contextPath}/login">
		<dl>
			<dd>用户名:<input type="text" name="user.username"/></dd>
			<dd>用户密码:<input type="password" name="user.password"/></dd>
         <dd><input type="submit" class="sumbit" value="登录"/></dd>
		</dl>
	</form>
	
  </body>
</html>
