<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name="유병승";
	String title=request.getParameter("title");
%>
<style>
	li{
		list-style-type:none;
		display:inline-block;
	}
</style>
<div>
<%=title %>
	<ul>
		<li>home</li>
		<li>notice</li>
		<li>board</li>
	</ul>
</div>




