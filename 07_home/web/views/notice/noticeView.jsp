<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="notice.model.vo.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<%
	Notice n = (Notice) request.getAttribute("notice");

	String loc = request.getContextPath() + "/noticeList";
	//목록으로 보내기위해
%>
	

<%@ include file="/views/common/header.jsp"%>
<div id="notice-container">
	<table id="tbl-notice">
		<tr>
			<th>제목</th>
			<td><%=n.getNotice_title() %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=n.getNotice_writer() %></td>
		</tr>
		<tr>
		<th>첨부파일</th>
		<td><%if(n.getFilePath()!=null){%>
		<a href="<%=request.getContextPath()%>/noticeFileDownload?filePath=<%=n.getFilePath()%>"><img alt='첨부파일' src='<%=request.getContextPath()%>/image/file.png' width='16px'></a>
	
		<%} %>
		</td>
		<tr>
		<td colspan="2">
		<input type="button" value="목록으로" onclick="location.href='<%=loc%>'">
		<%if(memberLoggedIn!=null&&(memberLoggedIn.getMemberId()).equals("admin")) 
					  { %>
						<input type='button' value='수정하기' onclick='fn_updateNotice()'>
						<input type='button' value='삭제하기' onclick='fn_deleteNotice()'>
					<%} %>
		<script type="text/javascript">
		 function fn_updateNotice() {
			 location.href="<%=request.getContextPath()%>/noticeUpdate?no=<%=n.getNotice_no()%>";
		}

		 function fn_deleteNotice() {
			 location.href="<%=request.getContextPath()%>/noticedelete?no=<%=n.getNotice_no()%>";
		}
		</script>
		
		</tr>
	</table>
</div>



<%@ include file="/views/common/footer.jsp"%>

