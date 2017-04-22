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
  <font color="red"><s:property value="#attr.msg" /></font>
	<form method="post" action="${pageContext.request.contextPath}/addtask?id=${param.id}">
			<dl>
				<dd>任务标题<input type="text" name="taskinfo.title"/></dd>
				<dd>任务内容<input type="text" name="taskinfo.content"/></dd>
				<dd>任务状态	<input type="radio" name="taskinfo.status" value="已完成">已完成
							<input type="radio" name="taskinfo.status" value="未完成">未完成</dd>
				<dd>任务结果<input type="text" name="taskinfo.result"/></dd>
				<dd>结束时间<input type="text" name="taskinfo.endtime"/></dd>
	         <dd><input type="submit" class="sumbit" value="添加任务"/></dd>
			</dl>
	</form>

  </body>
</html>
