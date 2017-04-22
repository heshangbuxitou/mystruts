<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<html>
  <head>
    <title>主页</title>
  </head>
  
  <body>
   <ul style="list-style:none;">
	    <s:if test="%{#session.user==null}">
			<div style="float:left">欢迎光临个人任务系统,请登录！</div>
		   <li style="float:left"><a href="${pageContext.request.contextPath }/index.jsp">首页</a></li>
	       <li style="float:left"><a href="${pageContext.request.contextPath }/regist.jsp">注册</a></li>
	       <li style="float:left"><a href="${pageContext.request.contextPath }/login.jsp">登录</a></li>
	       
	    </s:if>
	    <s:else>
	       <div style="float:left">欢迎光临个人任务系统,<s:property value="#session.user.username"/> </div>
		   <li style="float:left"><a href="${pageContext.request.contextPath }/index.jsp">首页&nbsp;</a></li>
	       <li style="float:left"><a href="${pageContext.request.contextPath }/watchtask?id=<s:property value="#session.user.userid" />">查看当前任务 &nbsp;</a></li>
	       <li style="float:left"><a href="${pageContext.request.contextPath }/logout">注销</a></li>
	    </s:else>
    </ul>
    <br><br><br>
    <table>
    	<tr>
    		<th>用户名</th>
    	</tr>
		<s:iterator value="#request.list" id="user">
			<tr>
				<th><s:property value="#user.username"/></th>
				<th><a href="${pageContext.request.contextPath }/watchtask?id=<s:property value="#user.userid"/>">查看任务</a></th>
	    	</tr>
		</s:iterator>
    </table>
    
    
  </body>
</html>
