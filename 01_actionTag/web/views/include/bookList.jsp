<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%response.setCharacterEncoding("UTF-8"); 
   request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<jsp:include page='header.jsp'>
		<jsp:param value="북리스트" name="title"/>
	</jsp:include>
	<h2>bookList현황</h2>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>