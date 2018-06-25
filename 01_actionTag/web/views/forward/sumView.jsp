<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	결과값 : <span style="color:red">
		<%=request.getAttribute("total") %>
	</span></br>
	<h2>EL을 통한 출력</h2>
	결과값 : <span style="color:green">
		${total }
	</span></br>
</body>
</html>




