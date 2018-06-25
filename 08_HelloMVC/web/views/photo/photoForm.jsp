<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>    
<style>
div#photo-container{width:600px; margin:0 auto; text-align:center;}
div#photo-container h2{margin:10px 0;}
table#tbl-photo{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
table#tbl-photo th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
table#tbl-photo td {border:1px solid; padding: 5px 10px 5px 10px; text-align:left;}
table#tbl-photo #img-viewer-container {
	width:350px;
	height:200px;
	border:2px dashed darkgray;
	display:table-cell;
}
</style>
<script>
function validate(){
	var content = $("[name=content]").val();
	//console.log(content.length)
	if(content.trim().length==0){
		alert("내용을 입력하세요");
		return false;
	}
	return true;
}
function fn_loadImg(f) {
	//console.log(f.files);//FileList
	//console.log(f.files[0]);//File(byte)
	if (f.files && f.files[0]) {
		var reader = new FileReader();
		//파일읽기 메소드, 읽기완료시 onload이벤트발생
		reader.readAsDataURL(f.files[0]);
		
		reader.onload = function(e) {
			//FileReader객체의 result속성에 파일의 컨텐츠가 담겨있음.
			$("#img-viewer").attr("src", e.target.result);
		}
	}
}
</script>
<div id="photo-container">
<h2>사진게시판 작성</h2>
<form action="<%=request.getContextPath() %>/photo/photoFormEnd" method="post" enctype="multipart/form-data">
	<table id="tbl-photo">
	<tr>
		<th>작성자</th>
		<td><input type="text" name="writer" value=<%=memberLoggedIn.getMemberId()%> readonly required/></td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td><input type="file" name="up_file" onchange="fn_loadImg(this);" required multiple="multiple"></td>
	</tr>
	<tr>
		<th>이미지 보기</th>
		<td>
			<div id="img-viewer-container">
				<img width="350">
			</div>
		</td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea  id="img-viewer" rows="5" cols="50" name="content"></textarea></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" value="등록하기" onclick="return validate();">
		</th>
	</tr>
</table>
</form>
</div>
<%@ include file="/views/common/footer.jsp" %>