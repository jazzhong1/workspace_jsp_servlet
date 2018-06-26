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
	<form action="paraEnd.jsp" method="post">
		제품명 : <input type="text" name='pname' placeholder="제품명"><br>
		수량 : <input type="number" name='pconut' placeholder="수량"><br>
		옵션 : <input type="text" name='option' placeholder="옵션"><br>
		옵션1 : <input type="text" name='option' placeholder="옵션"><br>
		<input type="submit" value="제출"/>
	</form>

</body>
</html>