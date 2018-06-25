<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<h1>usebean으로 서블릿에서 보낸 객체 받기</h1>
	<jsp:useBean id="person" class='com.kh.action.model.vo.Person' scope='request'/>
		이름 : <jsp:getProperty property="name" name="person"/>
		나이 : <jsp:getProperty property="age" name="person"/>
		성별 : <jsp:getProperty property="gender" name="person"/>

</body>
</html>







