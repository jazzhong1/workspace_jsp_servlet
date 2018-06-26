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
		request.setAttribute("su1", 10);
		request.setAttribute("su2", 30);
		session.setAttribute("su3", 50);	
	%>
	<h1>기본출력</h1>
	전송된 requset출력 : ${name} 
	<hr/>
	
	<h1>덧셈연산</h1>
	덧셈 : ${su1+su2} <br>
	뺄셈 : ${su1-su2} <br>		<!-- Attribute값으로 대입해서불러올 수 있다. -->
	나머지 : ${su3 mod su1} <br>	<!-- 세션도 가져와서 바로 쓸수있따. -->
	비교 : ${3 eq 5} <br>
	비교연산자 : ${10 eq 10 } <br>
	대소비교 : ${10 lt 20 } <br> <!-- 10<20 -->
	대소비교2 : ${10 gt 20 }<br>
	null : ${empty name} <br>
	삼항연산자 : ${not empty name?"이름이야":""} <br>

	<h1>실제 서블릿에서 보내는 값을 받아 EL로 처리하기</h1>
	<h2><a href="eltest.do">EL test</a></h2>
	


</body>
</html>

