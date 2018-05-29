<%@page import="org.apache.catalina.Session"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
  <% 
  	Member memberLoggedIn=(Member)request.getAttribute("member");
  %> 
	 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello MVC</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
<script>
	 function fn_login_validate() {
		if($("#userId").val().trim().length==0){
			alert("아이디를 공백없이 입력하세요")
			return false;
		}
		if($("#password").val().trim().length==0){
			alert("패스워드를 공백없이 입력하세요")
			return false;
		}
		return true;
	}
	 
	 
</script>
</head>
<body>
<div id="container">
	<header>
		<h1>Hello MVC</h1>
		<div class="login-container">
			<!-- 로그인 폼 작성 -->
			<%if(memberLoggedIn==null){ %>
			<form id="loginFrm" action="<%=request.getContextPath()%>/login.do" method="post" onsubmit="return fn_login_validate();">
				<table>
					<tr>
						<td><input type="text" name="userId" id="userId" placeholder="아이디" ></td>
						<td></td>
					</tr>
					<tr>
						<td><input type="password" name="password" id="password" placeholder="비밀번호"></td>
						<td><input type="submit" value="로그인"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="checkbox" name="saveId" id="saveId" >
							<label for="saveId">아이디저장</label>&nbsp;&nbsp;
							<input type="button" value="회원가입" onclick="location.href='<%=request.getContextPath() %>/memberEnroll'"/>
						</td>
					</tr>
				</table>
			</form>
			<%} else{%>
			<table id="logged-in">
				<tr>
					<td><%= memberLoggedIn.getMemberName() %>님 환영합니다.</td>
				</tr>
				<tr>
					<td><input type="button" value="내정보보기" 
					  onclick="location.href='<%=request.getContextPath() %>/memberView?userId=<%= memberLoggedIn.getMemberId()%>';">
					 </td> 
					<td><input type="button" value="로그아웃" 
					onclick="location.href='<%=request.getContextPath() %>/logout.do';">
				</tr>
			</table>
			<%} %>
			
		</div>
		
		<!-- 로그인 폼 작성 끝! -->
	<!-- 메인 메뉴 -->
	<nav>
		<ul class="main-nav">
			<li class="home"><a href="<%=request.getContextPath() %>/">home</a></li>
			<li id="notice"><a href="#">공지사항</a></li>
			<li id="board"><a href="#">게시판</a></li>
			<li id="photo-board"><a href="#">사진게시판</a></li>
		</ul>
	</nav>
	</header>
	
<section>
	
	
	
	
	
	
	