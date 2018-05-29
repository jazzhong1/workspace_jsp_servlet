<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%
		String main_menu=(String)request.getAttribute("main_menu");
		String side_menu=(String)request.getAttribute("side_menu");
		String drink_menu=(String)request.getAttribute("drink_menu");
		String price=String.valueOf(request.getAttribute("price"));
			
	%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>출력</title>
</head>
<body>
	<%=main_menu%>
	<%=side_menu%>
	<%=drink_menu%>
	<%=price%>
</body>
</html>