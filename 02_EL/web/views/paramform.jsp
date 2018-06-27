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
	<h2>EL파라미터 테스트</h2>
	<ul style="list-style: none;">
	<form action="paraEnd.jsp" method="post">		<!-- form으로넘기는건 모두 param -->
		<li>제품명 : <input type="text" name='pname' placeholder="제품명"></li><br>
		<li>수량 : <input type="number" name='pconut' placeholder="수량"></li><br>
		<li>옵션 : <input type="text" name='option' placeholder="옵션"></li><br>
		<li>옵션1 : <input type="text" name='option' placeholder="옵션"></li><br>
		<li><input type="submit" value="제출"/></li>
	</form>
</ul>
</body>
</html>