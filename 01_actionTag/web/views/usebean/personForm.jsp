<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<form action="personEnd.jsp" method="post">
		<table>
			<tr>
				<td>성명</td> 
				<td><input type="text" name='name'/></td>
			</tr>
			<tr>
				<td>나이</td> 
				<td><input type="number" name='age'/></td>
			</tr>
			<tr>
				<td>성별</td> 
				<td><input type="text" name='gender'/></td>
			</tr>
				<tr>
				<td colspan="2"> 
				<input type="submit"/></td>
			</tr>
		</table>
	</form>

</body>
</html>