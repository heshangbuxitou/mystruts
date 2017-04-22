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
  <font color="red"><s:property value="#attr.msg" /></font>
	<form method="post" action="${pageContext.request.contextPath}/modifytask?taskid=<s:property value="#request.taskinfo.taskid" />">
			<dl>
				<dd>任务标题<input type="text" name="taskinfo.title" value="<s:property value="#request.taskinfo.title" />"   /></dd>
				<dd>任务内容<input type="text" name="taskinfo.content" value="<s:property value="#request.taskinfo.content" />" /></dd>
				<dd>任务状态<input type="radio" name="taskinfo.status" value="已完成" <c:if test="${ requestScope.taskinfo.status=='已完成'}">checked="checked" disabled="disabled" </c:if>>已完成
						<input type="radio" name="taskinfo.status" value="未完成" <c:if test="${ requestScope.taskinfo.status=='未完成'}">checked="checked" </c:if> <c:if test="${ requestScope.taskinfo.status=='已完成'}"> disabled="disabled" </c:if>>未完成</dd>
				<dd>任务结果<input type="text" name="taskinfo.result" value="<s:property value="#request.taskinfo.result" />"  /></dd>
				<dd>结束时间<input type="text" name="taskinfo.endtime" value="<s:date name="#request.taskinfo.endtime" format="yyyy-MM-dd" nice="false"/>" /></dd>
	         <dd><input type="submit" class="sumbit" value="修改任务"/></dd>
			</dl>
	</form>
  </body>
</html>
