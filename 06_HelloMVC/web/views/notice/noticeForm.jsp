<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/views/common/header.jsp"%>

<style>
 div#notice-container{width:600px; margin:0 auto; text-align:center;}
    div#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
	table textarea{  resize: none;}
</style>

<script type="text/javascript">
	function validate() {
		var content=$("input[name=content]").val();
		if(content.trim().length==0){
			alert("내용을 입력하세요");
			return false;
		}
		return true;
	}
</script>

    <div id="notice-container">
    <form action="<%=request.getContextPath() %>/noticeFormEnd" method="post" enctype="multipart/form-data">
    																		<!--반드시 post로 보낸다.
    																		파일보낼떄 꼭 서야하는것이다.-->
        <table id="tbl-notice">
        <tr>
            <th>제 목</th>
            <td><input type="text" name="title" required></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" name="writer" value=<%=memberLoggedIn.getUserId()%> readonly required/></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td><input type="file" name="up_file"></td>
        </tr>
        <tr>
            <th>내 용</th>
            <td><textarea rows="5" cols="50" name="content"></textarea></td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="등록하기" onclick="return validate();">
            </th>
        </tr>
    </table>
    </form>
    </div>

<%@ include file="/views/common/footer.jsp"%>

