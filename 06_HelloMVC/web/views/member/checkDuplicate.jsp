<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean isUsable=(boolean)request.getAttribute("isUsable");
	String userId=(String)request.getAttribute("userId");
	
%>
<script>
	function fn_checkIdDuplicate(){
		var userId=document.getElementById("userId").value.trim();
		if(!userId||userId.length<4){
			alert("아이디는 4글자 이상 가능합니다.");
		}
		checkDuplicateFrm.userId.value=userId;
		checkDuplicateFrm.submit();
	}


</script>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인 결과</title>
<style>
	div#checkid-container{
	text-align:center;padding-top:50px;}
	span#duplicated{color:red;font-weight:bold;}
</style>

</head>
<body>
	<div id="checkid-container">
		<%if(isUsable){ %>
		[<span><%=userId %></span>]는 사용가능합니다.
		<br><br>
		<button type="button" onclick="self.close();">닫기</button>		
		<%} else{%>
		[<span id="duplicated"><%=userId %></span>]는 이미 사용중인 ID입니다.
		<br><br>
		<form action="<%=request.getContextPath()%>/checkIdDuplicate" name="checkDuplicateFrm" method="post">
			<input type="text" name="userId" placeholder="아이디를 입력하세요.">&nbsp;
			<button type="button" onclick="fn_checkIdDuplicate();">중복검사</button>
		</form>
		<%} %>
	</div>

</body>
</html>