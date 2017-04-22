<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	       <li style="float:left"><a href="${pageContext.request.contextPath }/watchuser">查看用户任务 &nbsp;</a></li>
	       <li style="float:left"><a href="${pageContext.request.contextPath }/logout">注销</a></li>
	    </s:else>
    </ul>
    <br><br><br>
    <table>
    	<tr>
    		<th>任务标题</th>
    		<th>任务内容</th>
    		<th>任务状态</th>
    		<th>任务结果</th>
    		<th>结束时间</th>
    		<th>实际完成时间</th>
    		<c:if test="${sessionScope.user.userid == param.id }">
    			<th><a href="${pageContext.request.contextPath }/addtask.jsp?id=<s:property value="#session.user.userid"/>">添加任务</a></th>
    		</c:if>
    	</tr>
		<s:iterator value="#request.list" id="task">
			<tr>
	    		<th><s:property value="#task.title"/></th>
	    		<th><s:property value="#task.content"/></th>
	    		<th><s:property value="#task.status"/></th>
	    		<th><s:property value="#task.result"/></th>
	    		<th><s:date name="#task.endtime" format="yyyy-MM-dd" nice="false"/> </th>
	    		<th><s:date name="#task.realtime" format="yyyy-MM-dd" nice="false"/></th>
	    		<c:if test="${sessionScope.user.userid == param.id }">
		    		<th><a href="${pageContext.request.contextPath }/findtask?taskid=<s:property value="#task.taskid"/>">修改任务</th>
		    		<th><a href="${pageContext.request.contextPath }/deletetask?taskid=<s:property value="#task.taskid"/>">删除任务</th>
	    		</c:if>
	    	</tr>
		</s:iterator>
    </table>
  </body>
</html>
