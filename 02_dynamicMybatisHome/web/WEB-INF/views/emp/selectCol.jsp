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
<style>
	table,tr,th,td{
		  border: 1px solid #444444;
	}
</style>
</head>
<body>
	<div>
		<form action="${pageContext.request.contextPath }/selectColEnd.do">
		<table>
		<tr>
		<td colspan="2">
			<select name='searchType' required="required">
				<option value="" disabled="disabled">검색타입</option>
				<option value="emp_id" <c:if test="${'emp_id' eq param.searchType }">selected</c:if>>사번</option>
				<option value="emp_name" <c:if test="${'emp_name' eq param.searchType }">selected</c:if>>이름</option>
				<option value="email" <c:if test="${'email' eq param.searchType }">selected</c:if>>메일</option>
				<option value="phone" <c:if test="${'phone' eq param.searchType }">selected</c:if>>전화번호</option>
			</select>
			</td>
			</tr>
			<tr>
				<td>
					<input type="radio" name="gender" value="남" id='gender'>
					<label for="gender">남</label>
				</td>
				<td>
					<input type="radio" name="gender" value="여" id='gender1'>
					<label for="gender1">여</label>
				</td>
			</tr>
			<tr>
			<td colspan="2">
			<input type="text" name='keyword' />
			</td>
			</tr>
		</table>
			<input type="submit" value="검색"/>
		</form>
		<c:if test="${not empty list }">
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
				<th>성별</th>					
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
						<td><fmt:formatDate value="${e.hire_date }" pattern="yyyy월MM월dd일hh시"/></td>
						<td><c:out value="${e.GENDER }"/></td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan='14'>검색결과가 존재하지 않습니다.</td> 
				</tr>
			</c:if>
		</table>
		</c:if>
	</div>
</body>
</html>

















<!-- 	<script type="text/javascript">
			function fn_sendData() {
				
				var colval = $('#col_select').val();
				var radioval = $(':radio[name="gender"]:checked').val();

				$.ajax({
					url:"${pageContext.request.contextPath}/selectColAjax.do",
					data:{searchType:colval, gender:radioval},
					type: "get",
					dataType:"json",
					success : function (data) {
						
					},
					error: function(request, status, error) {
						console.log(request);
						console.log(status);
						console.log(error);

					}
				})
			}
		</script>
 -->
