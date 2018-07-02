<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
	<p>학생객체입력</p>
	<a href="${path }/studentInput.do">학생객체입력</a><br>
	<a href="${path }/studentInput.do?flag=0">학생(map(문자))</a><br>
	<a href="${path }/studentInput.do?flag=1">학생(map(객체))</a><br>
	<a href='${path }/studentSearch.do'>학생조회</a><br>
</body>
</html>









