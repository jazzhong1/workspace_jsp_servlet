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
	<%!
	//선언자의 변수는 생성된 서블릿 객체의 맴버변수로 생성.
	public static final int su = 100;%>
	<%--맴버변수는 접근제한자 를 써줘야한다.--%>

	<%
		//스크립트에 있는 변수는 _jspservice 메소드 내에 존재 
		int num = 0;
		int num1 = 10;

		int sum = 0;
		for (int i = 0; i <= num1; i++) {
			sum += i;
		}
	%>
	

	<h1>0에서 1까지의 합을 구하면?</h1>
	<h2>
		결과 :
		<%=sum%></h2>

	<h2>전역변수 실행 = <%=su %> </h2> 

</body>
</html>