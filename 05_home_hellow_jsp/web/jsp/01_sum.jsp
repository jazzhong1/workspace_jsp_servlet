<%--directicve page --%>
<%@page import="org.omg.CORBA.PRIVATE_MEMBER"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 인코딩에 예민핟. -->

<html>
<head>
<meta charset="UTF-8">
<title>1에서10까지 합을 구하는 jsp</title>
</head>
<body>
	<%-- jsp 합을 구하자. 	--%>
	<!--html 주석 	스크립트에서 작성한것을 출력해준다.-->
	<%--jsp주석은 사용자에게 전달이 되지 않는다. --%>

	<%--첫번쨰 사용엘리멘트 : 스크립트(<% %>) 자바 코드 작성영역 --%>
	<%!public static final int num = 100;%>

	<%
		int sum = 0;
		for (int i = 0; i <= 10; i++) {
			sum += i;
		}
	%>
	<h2>결과 :<%=sum%></h2>
	<h3>전역변수 결과 : <%=num%></h3>
</body>
</html>