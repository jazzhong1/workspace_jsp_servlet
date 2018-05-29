<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘의 운세</title>
</head>
<body>
	<%
		/* 
			Date today=new Date();
			String day=String.format("%tY년%tm월%td일%tA",today,today,today,today); */
	%>

	<h2>
		오늘의 운세는<sub style="color: lightgray;"><%@ include file="date.jsp" %></sub>
														<!--include 이렇게해주면 jsp 결과물을 가져오거나 해당 jsp를 가져온다.-->
	</h2>
	<select>
		<option>쥐띠</option>
		<option>소띠</option>
		<option>호랑이띠</option>
		<option>토끼띠</option>
	</select>

</body>
</html>






