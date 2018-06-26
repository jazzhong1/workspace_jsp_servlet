<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<%
		request.setAttribute("name", "홍성진");
	%>
	<h1>기본출력</h1>
	전송된 requset출력 : ${name} 
	<hr/>
	
	<h1>덧셈연산</h1>
	덧셈 : ${10+20} <br>
	뺄셈 : ${10-20} <br>
	나머지 : ${3 mod 5} <br>
	비교 : ${3 eq 5} <br>
	비교연산자 : ${10 eq 10 } <br>
	대소비교 : ${10 lt 20 } <br> <!-- 10<20 -->
	대소비교2 : ${10 gt 20 }<br>
	null : ${empty name} <br>

</body>
</html>

