<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%response.setCharacterEncoding("UTF-8"); 
   request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<jsp:include page='header.jsp'>
		<jsp:param value="신간소개" name="title"/>
	</jsp:include>
	
	<div id='container' style='text-align:center;'>
		<h3>신간소개</h3>
		도서명 : 향수<br/>
		저자 : 유병승<br/>
		페이지수 : 300페이지<br/>
		가격 : 1,000,000원<br/>	
	</div>
	<jsp:include page='footer.jsp'/>
<%-- <%@ include file='footer.jsp' %> --%>
</body>
</html>