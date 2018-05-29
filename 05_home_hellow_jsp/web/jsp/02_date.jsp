<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	
<%
	Date date=new Date();
	SimpleDateFormat sdfm=new SimpleDateFormat("yyyy-MM-dd");
	String today=sdfm.format(date);
	//today=String.format("%tF", date);
	String time=String.format("%tT", date);
	String today_result=String.format("%tY년%tm월%td일%ta요일", date,date,date,date);
	
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>날짜 출력하기</title>
</head>
<body>
	<h1>현재날짜를 출력하세요</h1>
	<ul style="list-style:decimal;">
		<li>오늘의 날짜:<%=today%></li>
		<li>오늘의 시각:<%=time %></li>
		<li>오늘은 <span style="color:red;"><%=today_result %></span></li>
	</ul>
	
</body>
</html>