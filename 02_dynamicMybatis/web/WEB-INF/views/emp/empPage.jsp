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

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"  crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

<style type="text/css">
div#pagebar-contatiner {
	padding: 15px;
}
	table,tr,th,td{
		  border: 1px solid gray;
	}
</style>
</head>
<body>
	<div id='search-contianer'>
		<c:if test="${not empty list }">
			<table>
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
				<c:forEach var='e' items="${list }">
					<tr>
						<td><c:out value="${e['EMP_ID'] }" /></td>
						<td><c:out value="${e['EMP_NAME'] }" /></td>
						<td><c:out value="${fn:substring(e['EMP_NO'],0,8).concat('*******')}" /></td>
						<td><c:out value="${e['EMAIL'] }" /></td>
						<td><c:out value="${e['PHONE'] }" /></td>
						<td><c:out value="${e['DEPT_CODE'] }" /></td>
						<td><c:out value="${e['JOB_CODE'] }" /></td>
						<td><c:out value="${e['SAL_LEVEL'] }" /></td>
						<td><fmt:formatNumber value="${e['SALARY'] }" type="currency" /></td>
						<td><fmt:formatNumber value="${e['BOUNS'] }" type="percent" /></td>
						<td><c:out value="${e['MANAGER_ID'] }" /></td>
						<td><fmt:formatDate value="${e['HIRE_DATE'] }" type="date" /></td>
					</tr>
				</c:forEach>
				
			</table>
		</c:if>
		<div id='pagebar-container'>${pageBar }</div>
	</div>
</body>
</html>









