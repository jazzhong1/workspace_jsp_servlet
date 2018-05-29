<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	/* request.setAttribute("main_menu", main_menu);
	request.setAttribute("side_menu", side_menu);
	request.setAttribute("drink_menu", drink_menu);
	request.setAttribute("price", price);*/
	
	String main_menu=(String)request.getAttribute("main_menu");
	String side_menu=(String)request.getAttribute("side_menu");
	String drink_menu=(String)request.getAttribute("drink_menu");
	String sum=String.valueOf(request.getAttribute("price"));
	
    %>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>출력</title>
</head>
<body>
<%=main_menu %>
<%=side_menu %>
<%=drink_menu %>
<%=sum%>


</body>
</html>