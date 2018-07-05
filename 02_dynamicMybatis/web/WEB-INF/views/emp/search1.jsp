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
		  border: 1px solid gray;
	}
</style>
</head>
<body>
	<div>
		<form action="${pageContext.request.contextPath }/searchColEnd.kh">
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
			<td colspan="2">
			<input type="text" name='keyword' placeholder="컬럼명"/>
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
				<td>
					<input type="number" name="salary" min='0' value="${param.salary}">
					<input type="radio" name="salary_le_ge" value="ge" id='salary_ge' ${param.salary_le_ge eq 'ge'?'checked':''}/>
					<label for='salary_ge'>이상</label>
					<input type="radio" name="salary_le_ge" value="le" id='salary_le' ${param.salary_le_ge eq 'ge'?'checked':''}/>
					<label for='salary_le'>이하</label>
			
				</td>
				
				<td>
					<input type="date" name="hire_date" min='0' value="${param.hrie_date}">
					<input type="radio" name="hire_date_le_ge" value="ge" id='hire_date_ge' ${param.hrie_date_le_ge eq 'ge'?'checked':''}/>
					<label for='hire_date_ge'>이상</label>
					<input type="radio" name="hire_date_le_ge" value="le" id='hire_date_le' ${param.hrie_date_le_ge eq 'ge'?'checked':''}/>
					<label for='hire_date_le'>이하</label>
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="checkbox" name='job_code' id='j1' value='J1'>
					<label for="j1">대표</label>
					<input type="checkbox" name='job_code' id='j2' value='J2'>
					<label for="j2">부사장</label>
					<input type="checkbox" name='job_code' id='j3' value='J3'>
					<label for="j3">부장</label>
					<input type="checkbox" name='job_code' id='j4' value='J4'>
					<label for="j4">차장</label>
					<input type="checkbox" name='job_code' id='j5' value='J5'>
					<label for="j5">과장</label>
					<input type="checkbox" name='job_code' id='j6' value='J6'>
					<label for="j6">대리</label>
					<input type="checkbox" name='job_code' id='j7' value='J7'>
					<label for="j7">사원</label>
					
					
				</td>
			</tr>
			
		</table>
			<input type="submit" value="검색"/>
		</form>
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
				<th>직급</th>				
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
						<td><c:out value="${e.GENDER }"/></td>
						<td><c:out value="${e.JOB_NAME }"/></td>
						
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan='13'>검색결과가 존재하지 않습니다.</td> 
				</tr>
			</c:if>
		</table>
	</div>
</body>
</html>









