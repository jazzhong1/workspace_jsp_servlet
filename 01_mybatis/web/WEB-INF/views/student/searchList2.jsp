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
	<table style="text-align: left">
		<tr>
			<th>학생번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>주소</th>
			<th>가입날짜</th>
		</tr>
		<c:if test="${not empty list }">
		<c:forEach var='student' items="${list }">
		<tr>
				<td><c:out value="${student.studentNo }"></c:out></td>
				<%-- <td><c:out value="${student["student No"] }"></c:out></td> mapper에서 "student no" 로 별칭부여시 할수 있음 --%>				
				<td><c:out value="${student.studentName }"></c:out></td>
				<td><c:out value="${student.studentTel }"></c:out></td>
				<td><c:out value="${student.studentEmail }"></c:out></td>
				<td><c:out value="${student.studentAddr }"></c:out></td>
				<td><c:out value="${student.reg_date }"></c:out></td>
		<tr>
		</c:forEach>
		</c:if> 
		<c:if test="${empty list }">
			<td colspan="5"><c:out value="없음"></c:out></td>
		</c:if>
	</table>
</body>
</html>









