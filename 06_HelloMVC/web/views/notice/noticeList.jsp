<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="notice.model.vo.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Notice> noticeList = (ArrayList) request.getAttribute("noticelist");
%>
<%@ include file="/views/common/header.jsp"%>
<style>
div#notice-container {
	width: 600px;
	margin: 0 auto;
	text-align: center;
}

div#notice-container h2 {
	margin: 10px 0;
}

table#tbl-notice {
	width: 100%;
	margin: 0 auto;
	border: 1px solid black;
	border-collapse: collapse;
}

table#tbl-notice th, table#tbl-notice td {
	border: 1px solid;
	padding: 5px 0;
	text-align: center;
}

input#btn-add{
	float:right;
	/*왼족으로 이동 찾아보기*/
	margin: 0 0 15px;
}

</style>

<div id="notice-container">
	<h2>공지사항</h2>
	<%if(memberLoggedIn!=null&&(memberLoggedIn.getUserId()).equals("admin")){ %>
	<input id="btn-add" type="button" value="글쓰기" onclick="fn_addNotice();">
	<%}%>
	
	<script type="text/javascript">
		function fn_addNotice() {
			location.href="<%=request.getContextPath()%>/noticeAdd";
		}
	</script>
	
	<table id="tbl-notice">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>첨부파일</th>
			<th>작성일</th>
		</tr>
		
		<tbody>
			<%
				for (Notice n : noticeList) {
			%>
			<tr>
				<td><%=n.getNotice_no()%></td>
				<td><a href="<%=request.getContextPath()%>/noticeView?no=<%=n.getNotice_no()%>"><%=n.getNotice_title()%></a></td>
				<td><%=n.getNotice_writer()%></td>
				
				<td>
					<% if(n.getFilePath()!=null){ %>
					<img alt="첨부파일" src="<%=request.getContextPath()%>/image/file.png" width="16px"> 
					<%}%>
				</td>
				
				<td><%=n.getNotice_date()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
		
	</table>
</div>

<%@ include file="/views/common/footer.jsp"%>

