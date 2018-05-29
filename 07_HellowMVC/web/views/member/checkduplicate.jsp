<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean isUsable=(boolean)request.getAttribute("isUsable");
	String userId=(String)request.getAttribute("userId");

%>    

<!DOCTYPE html>
<html>
<head>
<style>
	div#checkid-container
	{
		text-align:center;
		padding-top:50px;
	}
	span#duplicated
	{
		color:red;
		font-weight:bold;
	}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	function fn_checkIdDuplicate()
	{
		
		var userId=$("#userId").val().trim();
		
		if(!userId||userId.length<4)
		{
			alert("아이디는 4글자 이상 가능합니다.");	
		}
		checkDuplicateFrm.userId.value=userId;
		checkDuplicateFrm.submit();
	}
</script>

<meta charset="UTF-8">
<title>아이디중복확인결과</title>
</head>
<body>
	<div id="checkId-container">
		<% if(isUsable){%>
			[<span><%= userId %></span>]는 사용가능합니다.
			<br><br>
			<button type="button" onclick="self.close();">닫기</button>
										<!-- 팝업닫기 -->
		<%} else {%>
		[<span id="duplicated"><%=userId %></span>]는 이미 사용중입니다.
		<br><br>
		<form action="<%=request.getContextPath()%>/checkIdDuplicate" name="checkDuplicateFrm" method="post">
			<input type="text" name="userId" id="userId" placeholder="아이디를 입력하세요">&nbsp;&nbsp;
			<button type="button" onclick="fn_checkIdDuplicate();">중복검사</button>
		</form>
		<%}%>
	</div>
</body>
</html>














