<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<h1>날짜를 표현하는 format</h1>
	<c:set var="now" value="<%=new Date() %>"/>
	<fmt:formatDate var="date" value="${now }"/>
	<c:out value="${date }"></c:out><br>
	<!-- type: both, time -->
	type=time : <fmt:formatDate value="${now }" type="time"/><br>
	type=both : <fmt:formatDate value="${now }" type="both"/><br>
	
	<!-- pattern양식  -->
	<!-- pattern 개발자가 날짜 형식을 자유롭게 설정 -->
	pattern1 : <fmt:formatDate value="${now }" pattern="yyyy년mm월dd일HH시mm분ss초"/><br>
	pattern2 : <fmt:formatDate value="${now }" pattern="yyyy년mm월dd일E요일"/><br>
	pattern3 : <fmt:formatDate value="${now }" pattern="yyyy년mm월dd일E요일"/><br>
	
	<!-- DateStyel속성 ! 지정된 날짜형식 -->
	datestyle=default : <fmt:formatDate value="${now }" dateStyle="default"/><br>
	datestyle=short : <fmt:formatDate value="${now }" dateStyle="short"/><br>
	datestyle=long : <fmt:formatDate value="${now }" dateStyle="long"/><br>
	datestyle=full : <fmt:formatDate value="${now }" dateStyle="full"/><br>
	
	<!-- timeStyle 속성을 이용하여 지정된 시간형식 -->
	timeStyle=short : <fmt:formatDate value="${now }" type="both" timeStyle="short"/><br>
	timeStyle=medium : <fmt:formatDate value="${now }" type="both" timeStyle="medium"/><br>
	timeStyle=long : <fmt:formatDate value="${now }" type="both" timeStyle="long"/><br>
	timeStyle=full : <fmt:formatDate value="${now }" type="both" timeStyle="full"/><br>
	
	
</body>
</html>