<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생입력</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
	div#enroll-container {
		text-align: center;
	}
	
	table#tbl-student {
		margin: 0 auto;
		border: 1px solid;
		border- collapse: collapse;
	}
	
	table#tbl-student th, table#tbl-student td {
		border: 1px solid;
		padding: 5px;
	}
	
	table#tbl-student th {
		text-align: right;
	}
	
	table#tbl-student td {
		text-align: left;
	}
	
	table#tbl-student td:last-of-type {
		text- align: center;
	}
</style>
</head>
<body>
	<div id="enroll-container">
		<h2>학생등록</h2>
		<form
			action="${pageContext.request.contextPath}/studentEnrollEnd.do"
			method="post">
			<input type="hidden" name='flag' value='${flag}'>
			<table id="tbl-student">
				<tr>
					<th>학생이름</th>
					<td><input type="text" name="studentName" required /></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="tel" name="studentTel" maxlength="11" required /></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="studentEmail" /></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="studentAddr" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="등록" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>









