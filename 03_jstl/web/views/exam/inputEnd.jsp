<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<ul style="list-style: none;">
		<!-- 기본은 setAttribute로 받게된다. -->
		<li>이름 : <c:out value="${param.name }"></c:out></li><br>
		<li>나이 : <c:out value="${param.age }"></c:out></li><br>
  		<c:forEach items="${paramValues.fruit}" var="fruit"> 
  			<li>과일 : <c:out value="${fruit.index}"/></li>
  		</c:forEach>
  		
  		<c:forEach items="${paramValues.hobby}" var="hobby"> 
  			<li>취미 : <c:out value="${hobby}"/></li>
  		</c:forEach>
  		
</ul>
</body>
</html>



