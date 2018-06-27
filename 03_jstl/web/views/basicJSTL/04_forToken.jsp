<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<h1>forTokens</h1>
	<p>문자열을 특정한 기호에 따라 분리하는것</p>	
	<p>사용 c:forTokens values="" delims="기호"</p>
	<c:set></c:set>
	<!-- check나 ,를 디비에서 list로 받아올때 처리한다. -->
	<c:forTokens items="" delims=""></c:forTokens>
	
</body>
</html>