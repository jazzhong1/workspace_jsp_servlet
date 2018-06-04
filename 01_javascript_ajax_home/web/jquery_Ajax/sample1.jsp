<%@page import="model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ page import="java.util.*" %>
<%
	List<User> list=(List)request.getAttribute("list");
%>
<style>
	img{width:100px}
	table{border:1px solid; border-collapse:collapse;}
	th,td{border:1px solid; padding:10px;}
</style>


<table it="tbl-member">
	<tr>
		<th>이름</th>
		<th>전화번호</th>
		<th>프로필</th>
	</tr>
	<% if(!list.isEmpty()) {
		for(User u:list)
		{ %>
		<tr>
			<td><%=u.getName() %></td>
			<td><%=u.getPhone() %></td>
			<td><img src="<%=request.getContextPath()%>
			/images/<%= u.getProfile() %>" alt=""/></td>
		</tr>
	<% }
	}%>
</table>

