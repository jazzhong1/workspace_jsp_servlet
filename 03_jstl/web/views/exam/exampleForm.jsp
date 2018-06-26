<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<h2>ELtest</h2>
	<ul style="list-style: none;">
	
	<form action="inputEnd.jsp" method="post">
		<li>이름 : <input type="text" name='name' placeholder="이름"></li><br>
		<li>나이 : <input type="number" name='age' placeholder="나이"></li><br>
		<li>과일 : 사과<input type="checkbox" name='fruit' value="사과" >
				 바나나<input type="checkbox" name='fruit' value="바나나">
				 포도<input type="checkbox" name='fruit' value="포도">
				 복숭아<input type="checkbox" name='fruit'value="복숭아"></li><br>
		<li>취미 : 독서<input type="checkbox" name='hobby' value="독서">
				 산책<input type="checkbox" name='hobby' value="산책">
				 요리<input type="checkbox" name='hobby' value="요리">
				 운동<input type="checkbox" name='hobby' value="운동"></li><br>
		<li><input type="submit" value="제출"/></li>
	</form>
</ul>
</body>
</html>


