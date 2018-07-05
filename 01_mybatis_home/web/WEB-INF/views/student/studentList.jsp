<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
	<h2>검색결과</h2>
	<table>
		<tr>
			<th>학생번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>주소</th>
		</tr>
		<c:if test="${not empty list }">
			<c:forEach var='student' items="${list}">
			<tr>
				<td><c:out value="${student.studentNo }"></c:out>
				<td><c:out value="${student.studentName }"></c:out>
				<td><c:out value="${student.studentTel }"></c:out>
				<td><c:out value="${student.studentEmail }"></c:out>
				<td><c:out value="${student.studentAddr }"></c:out>
				<td><c:out value="${student.reg_date }"></c:out>
			</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty list }">
			<tr>
				<td colspan="5">없음</td>
			</tr>
		</c:if>
	</table>
</body>
</html>








