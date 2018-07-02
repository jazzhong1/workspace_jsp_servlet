<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <c:set var='path' value="${pageContext.request.contextPath }"/>
 <!-- pageContext.request.contextPath==request.getContextPath() -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<h1>Mybatis테스트!</h1>
	<!-- 루트컨택스트(rootContextPath)를 불러올때 pageContext를 이용해서 불러와야함 -->
	<a href='${path }/mybatisTest.do'>입력테스트하기</a><br>
	<a href='${path }/mybatisTest1.do'>이름 insert</a><br>
	<a href='${path }/studentInput.do?map=0'>학생입력</a><br>
	<a href='${path }/studentInput.do?map=1'>학생입력(map)</a><br>
	<a href='${path }/studentInput.do?map=2'>학생입력(map,객체)</a><br>
	<a href='${path }/studentSearch.do'>학생조회</a><br>
</body>
</html>






