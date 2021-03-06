<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="notice.model.vo.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	List<Notice> noticeList = (ArrayList) request.getAttribute("noticelist");
	int numPerPage=(int)request.getAttribute("numPerPage");
	int cPage=(int)request.getAttribute("cPage");
	String pageBar=(String)request.getAttribute("pageBar");
%>

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
<script type="text/javascript">
	window.onload = function(){
	var numPerPage = document.querySelector("#numPerPage");
	numPerPage.addEventListener("change", function() {	//디폴트 이벤트발생 아주중요.
	document.numPerPageFrm.submit();
});
}

</script>

<%@ include file="/views/common/header.jsp"%>
<div id="notice-container">
	<h2>공지사항</h2>
	<%if(memberLoggedIn!=null&&(memberLoggedIn.getMemberId()).equals("admin")){ %>
	<input id="btn-add" type="button" value="글쓰기" onclick="fn_addNotice();">
	<%} %>
	
	<script type="text/javascript">
	function fn_addNotice() {
				location.href="<%=request.getContextPath()%>/noticeAdd";			
		}
	</script>
	<div id='numPerPage-container' align="left">
				페이지당 게시판수 : 
				<form name="numPerPageFrm" 
				id="numPerPageFrm" 
				action="<%=request.getContextPath() %>/noticeList">
					<input type="hidden" name="cPage" value="<%=cPage %>">
					<select name="numPerPage" id="numPerPage">
						<option value='10' <%=numPerPage==10?"selected":"" %>>10</option>
						<option value='5' <%=numPerPage==5?"selected":"" %>>5</option>
						<option value='3' <%=numPerPage==3?"selected":"" %>>3</option>
					</select>
				</form>
			</div>
	
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
					<%if(n.getFilePath()!=null){%>
						<img alt="첨부파일" src="<%=request.getContextPath()%>/image/file.png" width="16px">
					<%} %>
				</td>
				<td><%=n.getNotice_date()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
		
	</table>
		<div id="pageBar" align="center"><%=pageBar%></div>
	

</div>
<%@ include file="/views/common/footer.jsp"%>

