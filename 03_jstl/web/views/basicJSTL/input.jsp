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

<h2>색상입력</h2>
<form action="02_if_when.jsp" method="get">
	<ul style="list-style: none">
		<li>색상:<input type='text' name='color'> <li>
		<li><input type="submit" value="제출"><li>
	</ul>
</form>
<hr>

<h2>상품</h2>
<p>ex)플스,핸드폰,감스트싸인</p>
<form action="02_if_when.jsp" method="get">
	<ul style="list-style: none">
		<li>상품:<input type='text' name='product'><li>
		<li><input type="submit" value="제출"><li>
	</ul>
</form>

<h2>취미</h2>
<form action="03_foreach_basic.jsp" method="get">
	<ul style="list-style: none; display: inline;" >
		<li>독서 <input type="checkbox" name='hobby' value='reading'>
		여행 <input type="checkbox" name='hobby' value='travel'>
		운동 <input type="checkbox" name='hobby' value='excercise'>
		영화 <input type="checkbox" name='hobby' value='movie'>
		먹방 <input type="checkbox" name='hobby' value='eat'></li>
		<li><input type="submit" value="제출"><li>
	</ul>
</form>


</body>
</html>