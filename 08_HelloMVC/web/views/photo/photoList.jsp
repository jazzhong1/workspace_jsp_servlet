<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int total =  (int)request.getAttribute("total");
%>
<%@ include file="/views/common/header.jsp" %>
<style>
section#photoList-container{width:600px; margin:0 auto; text-align:center;}
section#photoList-container h2{margin:10px 0;}
/* 글쓰기버튼추가 */
section#photoList-container input#btn-add{float:right; margin: 0 0 15px;}

div#btn-more-container button#btn-more{float:right; margin: 0 0 15px;}
/* 사진 */
.polaroid{
	margin:10px auto;
	width:300px;
	background-color:#fff;
	box-shadow: 2px 2px 3px rgba(135, 139, 133, 0.4);
	transition: 0.5s
}
.polaroid:hover{
	box-shadow: 10px 10px 8px rgba(135, 139, 133, 0.4);
}
p.info{text-align:left;margin:0;}
span.writer{font-weight:bold;font-size:8px;}
span.photoDate{font-size:6px;}
</style>
<script>
$(function( ){
		fn_more(1);
		
		$("#btn-more").click(function(){
			fn_more($(this).val());
		});
});
function fn_more(start){
	console.log(start);
	var param = {
			start:start
	};
	$.ajax({
		url:"<%=request.getContextPath()%>/photo/photoMore",
		data:param,
		type:"post",
		dataType:"json",
		success:function(data){
			//console.log(data);
			var html="";
			for(var i in data){	
				var p = data[i];
				html+= "<div class='polaroid'>";
				html+="<img src='<%=request.getContextPath()%>/uploadFiles/photo/"+p.renamedFileName+"' width='300'>";
				html+="<p class='info'><span clsas='writer'>"+p.photoWriter+"</span>&nbsp;&nbsp";
				html+="<span class='photoDate'>"+p.photoDate+"</span></p>"
				html+="<p class='caption'>"+p.photoContent+"</p></div>";
			}
			$("#photo-container").append(html);
			
			//다음 더보기 시작값 저장하기
			//반드시 숫자형으로 형변환 시킬것.
			$("#btn-more").val(Number(start)+5);
			$("#btn-more").attr("current",Number($("#btn-more").attr("current"))+data.length);
			//만약 마지막페이지라면, 더보기버튼 비활성화
			var total = $("#btn-more").attr("total");
			var current = $("#btn-more").attr("current");
			if(current==total){
				$("#btn-more").attr("disabled","disabled");
				$("#btn-more").css("cursor","not-allowed");
			}
		},
		error : function(jqxhr, textStatus, errorThrown){
			console.log("실시간주문현황 ajax 처리 실패");
			//에러로그
			console.log(jqxhr);
			console.log(textStatus);
			console.log(errorThrown);
		}
	});
}
function fn_goPhotoForm(){
	location.href = "<%=request.getContextPath()%>/photo/photoForm";
}
</script>
<section id="photoList-container">
	<h2>사진게시판 </h2>
	<%--로그인한 경우 글쓰기 가능 --%>
	<% if(memberLoggedIn!=null){ %>
	<input type="button" value="글쓰기" id="btn-add" onclick="fn_goPhotoForm();"/>
	<%} %>
	
	<div id="photo-container"></div>
	<hr />
	<div id='btn-more-container'>
		<!-- 사진게시판 전체 게시물수를 total속성에 담아둠. -->
		<!-- 사진게시판 현재 가져온 게시물수를 current속성에 담아둠. -->
		<button id="btn-more" value="" total="<%=total%>" current="0">더보기</button>
	</div>
</section>
<%@ include file="/views/common/footer.jsp" %>