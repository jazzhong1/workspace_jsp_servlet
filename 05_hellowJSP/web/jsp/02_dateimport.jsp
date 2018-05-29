
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날짜출력하기~</title>
</head>
<body>

	<%
		//서블릿에서 자료가져올때 먼저 읽기위해 	
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
		String s_today = sdf.format(today);
		String date = String.format("%tF", today);
		String time = String.format("%tT", today);
		String toay = String.format("%tY년%tm월%td일 %tA", today, today, today, today);
		//순서대로 먹는다.
	%>

	<h1>현재 날짜를 출력해 봅시다~~</h1>
	<h2>
		<%=today%></h2>
		
		<ul style="list-style:decimal;">
		<li>오늘의 날짜 : <%=date %></li>
		<li>현재 시각 : <%=time %></li>
		<li>오늘은<span style="color:red;"><%=toay %></span></li>
		<li style="color:red;">오늘은<%=toay %></li>
	</ul>
</body>
</html>