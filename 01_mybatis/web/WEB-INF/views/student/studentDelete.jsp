<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
 <style>
    div#student-container{text-align:center;}
    table#tbl-student{margin:0 auto;border:1px solid; border-collapse:collapse;}
    table#tbl-student th,table#tbl-student td{
        border:1px solid;
        padding:5px;
        line-height: 2em; 
    }
    table#tbl-student th{text-align:right;}
    table#tbl-student td{text-align:left;}
    table#tbl-student tr:last-of-type td{text-align:center;}
 </style>
 
 <script type="text/javascript">
	if(${result}==1){
		alert('삭제성공');
	}
	else{
		alert('학생번호가 없습니다.');
	}
 </script>
 
</head>
<body>
	<div id='student-container'>
		<h2>학생삭제</h2>
		<form action="${pageContext.request.contextPath }/studentDeleteEnd.do">
			<table id='tbl-student'>
				<tr>
					<th>학생번호</th>
					<td><input type="number" name='no' required/></td>
				</tr>
				<tr>
					<td colspan='2'>
						<input type='submit' value='삭제'/>
					</td>
				</tr>				
			</table>
		</form>
	</div>
	<a  id='change' type="hidden" href="/"></a>
</body>
</html>






