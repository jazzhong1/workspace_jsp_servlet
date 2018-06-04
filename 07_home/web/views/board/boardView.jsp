<%@page import="java.util.List"%>
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
	input#btn-add{float:right; margin: 0 0 15px;}
	table#tbl-comment{width:580px; margin:0 auto; border-collapse:collapse; clear:both; } 
    table#tbl-comment tr td{border-bottom:1px solid; border-top:1px solid; padding:5px; text-align:left; line-height:120%;}
    table#tbl-comment tr td:first-of-type{padding: 5px 5px 5px 50px;}
    table#tbl-comment tr td:last-of-type {text-align:right; width: 100px;}
    table#tbl-comment button.btn-reply{display:none;}
    table#tbl-comment button.btn-delete{display:none;}
    table#tbl-comment tr:hover {background:lightgray;}
    table#tbl-comment tr:hover button.btn-reply{display:inline;}
    table#tbl-comment tr:hover button.btn-delete{display:inline;}
    table#tbl-comment tr.level2 {color:gray; font-size: 14px;}
    table#tbl-comment sub.comment-writer {color:navy; font-size:14px}
    table#tbl-comment sub.comment-date {color:tomato; font-size:10px}
    table#tbl-comment tr.level2 td:first-of-type{padding-left:100px;}
    table#tbl-comment tr.level2 sub.comment-writer {color:#8e8eff; font-size:14px}
    table#tbl-comment tr.level2 sub.comment-date {color:#ff9c8a; font-size:10px}
    textarea {resize: none;}
	
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
				<%if(b.getBoardOriginalFileName()!=null){ %>
				<a href="javascript:fn_fileDownload('<%=b.getBoardOriginalFileName()%>','<%=b.getBoardRenameFileName()%>');">
				<img alt="첨부파일" src="<%=request.getContextPath()%>/image/file.png" width=16px>
				<%=b.getBoardOriginalFileName() %>
				<%} %>
				</a>
				<script type="text/javascript">
					function fn_fileDownload(oriName,reName) {
						var url="<%=request.getContextPath()%>/boardFileDownLoad";
						oName=encodeURIComponent(oriName);
						location.href=url+"?oName="+oriName+"&rName="+reName;
						//쿼리스트링방식으로넘긴다...ajax사용가능...
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
					<%--글작성자/관리자인경우 수정삭제 가능 --%>
							
					<!--로그인한사람-->
					<%if(memberLoggedIn!=null&&b.getBoardWriter().equals(memberLoggedIn.getMemberId())||(memberLoggedIn.getMemberId().equals("admin"))){ %>
					<input type="button" value="수정하기" onclick="fn_updateBoard()">
					<input type="button" value="삭제하기" onclick="fn_deleteBoard()">
					<%} %>
				</th>
			</tr>
		</table>
		
			
			<%if(memberLoggedIn!=null&&b.getBoardWriter().equals(memberLoggedIn.getMemberId())||(memberLoggedIn.getMemberId().equals("admin"))){ %>
		    <form name="boardDelFrm" action="<%=request.getContextPath()%>/boardDelete" method="post">
		    <input type="hidden" name="no" value="<%=b.getBoardNo() %>" />
		    <input type="hidden" name="renamedFileName" 
		    value="<%= b.getBoardRenameFileName()!=null?b.getBoardRenameFileName():""%>" />
		    </form>
  		  	<%} %>
		    <script>
		    function fn_updateBoard() {
				location.href="<%=request.getContextPath()%>/boardUpdate?no=<%=b.getBoardNo()%>";
			}
		    function fn_deleteBoard() {
				location.href="<%=request.getContextPath()%>/boardDelete?no=<%=b.getBoardNo()%>";
			}
		    </script>
		    
		    
    </div>
<%@ include file="/views/common/footer.jsp"%>

