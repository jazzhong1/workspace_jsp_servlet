<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="board.model.vo.Board" %>
    <%
        Board b = (Board)request.getAttribute("board");
    %>
<%@ include file="/views/common/header.jsp"%>

    <style>
    div#board-container{width:600px; margin:0 auto; text-align:center;}
    div#board-container h2{margin:10px 0;}
    table#tbl-board{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-board th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-board td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    </style>

		<div id="board-container">
		<h2>게시판</h2>
		<table id="tbl-board">
			<tr>
				<th>글번호</th>
				<td><%=b.getBoardNo() %></td>
			</tr>
			<tr>
				<th>제 목</th>
				<td><%=b.getBoardTitle() %></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=b.getBoardWriter() %></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=b.getBoardReadCount() %></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
				<% if(b.getBoardOriginalFileName() != null){ %>
				<a href="javascript:fn_fileDownload('<%= b.getBoardOriginalFileName() %>','<%=b.getBoardRenameFileName()%>');">
					<img alt="첨부파일" src="<%=request.getContextPath() %>/images/file.png" width=16px>
				<%= b.getBoardOriginalFileName() %>
				</a>
				<% }%>
					<script>
						function fn_fileDownload(oriName, reName)
						{
							var url="<%=request.getContextPath()%>/boardFileDownLoad";
							oName=encodeURIComponent(oriName);
							//인코딩처리르해야지 파일명이 제대로 넘어감.
							location.href=url+"?oName="+oName+"&rName="+reName;
						}
					</script>
				
				</td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><%=b.getBoardContent()%></td>
			</tr>
			<%--글작성자/관리자인경우 수정삭제 가능 --%>
		
			<tr>
				<th colspan="2">
				<input type="button" value="목록으로" onclick="fn_goList()">
					<script>
						function fn_goList()
						{
							location.href="<%=request.getContextPath()%>/boardList";
						}
					</script>			
					<% if(memberLoggedIn!=null && 
				(b.getBoardWriter().equals(memberLoggedIn.getUserId())
				|| "admin".equals(memberLoggedIn.getUserId()))){ %>
					<input type="button" value="수정하기" onclick="fn_updateBoard()">
					<input type="button" value="삭제하기" onclick="fn_deleteBoard()">
				</th>
			</tr>
			<%} %>	
		</table>
		
		
		<!--관리자만볼수있으며 hiiden으로 값을 감춰놓고 함수문만 별도로 보낸다.-->
			<% if(memberLoggedIn!=null && 
            (b.getBoardWriter().equals(memberLoggedIn.getUserId())
            || "admin".equals(memberLoggedIn.getUserId())) ){ %>
		    <form name="boardDelFrm" action="<%=request.getContextPath()%>/boardDelete" method="post">
		    <input type="hidden" name="no" value="<%=b.getBoardNo() %>" />
		    <input type="hidden" name="renamedFileName" value="<%= b.getBoardRenameFileName()!=null?b.getBoardRenameFileName():""%>" />
		    </form>
		    <%} %>
  		  </div>
  		  
		    <script>
		    function fn_updateBoard(){
		        location.href="<%=request.getContextPath()%>/boardUpdate?no=<%=b.getBoardNo() %>";
		    }
		    function fn_deleteBoard(){
		        if(!confirm('이 게시글을 정말 삭제하시겠습니까?')) return;
		        $("[name=boardDelFrm]").submit();
		    }
		    </script>
<%@ include file="/views/common/footer.jsp"%>

