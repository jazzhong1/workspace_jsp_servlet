<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원검색결과</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
	table,tr,th,td{
		  border: 1px solid #444444;
	}
</style>
</head>
<body>
	<div id="emp-container">
		<h2>사원정보</h2>
		<table class="tbl-emp" style="text-align: left;">
			<tr>
				<th>사번</th>
				<th>사원명</th>
				<th>주민번호</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>부서코드</th>
				<th>직급코드</th>
				<th>급여레벨</th>
				<th>급여</th>
				<th>보너스율</th>
				<th>매니저 사번</th>
				<th>입사일</th>				
			</tr>
			<c:if test="${not empty list }">
				<c:forEach var="e" items="${list }" varStatus="vs">
					<tr>
						<td><c:out value="${e.emp_id }"/></td>
						<td><c:out value="${e.emp_name }"/></td>
						<td><c:out value="${e.emp_no }"/></td>
						<td><c:out value="${e.email }"/></td>
						<td><c:out value="${e.phone }"/></td>
						<td><c:out value="${e.dept_code }"/></td>
						<td><c:out value="${e.job_code }"/></td>
						<td><c:out value="${e.sal_level }"/></td>
						<td><fmt:formatNumber type="currency" value="${e.salary }"/></td>
						<td><fmt:formatNumber type="percent" value="${e.bonus }"/></td>
						<td><c:out value="${e.manager_id }"/></td>
						<td><fmt:formatDate value="${e.hire_date }" type='time' pattern="yyyy월MM월dd일hh시mm분ss초"/></td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan=13>검색결과가 존재하지 않습니다.</td> 
				</tr>
			</c:if>
		</table>
	
	</div>
</body>
</html>






