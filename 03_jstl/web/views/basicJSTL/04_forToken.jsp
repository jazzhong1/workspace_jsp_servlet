<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<h1>forTokens</h1>
	<p>문자열을 특정한 기호에 따라 분리하는것</p>
	<p>사용 c:forTokens values="" delims="기호"</p>
	<c:set var="player" value="감스트,20분,휴식시간,축구"></c:set>
	<c:set var="player1" value="감스.트,2.0분,휴.식시.간,축구"></c:set>

	<!-- check나 ,를 디비에서 list로 받아올때 처리한다. -->
	<c:forTokens var="tt" items="${player }" delims=",">
		<c:out value="${tt }"></c:out>
	</c:forTokens>
	<br>
	<c:forTokens var="tt" items="${player1 }" delims=" .,">
		<c:out value="${tt }"></c:out>
	</c:forTokens>
	<!-- 질문....하기 -->
	<%
		request.setAttribute("search", "베르너");
	%>
	<h1>url</h1>
	<c:url var="search" value="https://search.naver.com/search.naver">
		<c:url var="search1" value="https://search.naver.com/search.naver" />
		<c:param name="query" value="${search }" />
	</c:url>
	<a href="${search }">검색하기</a>
	<a href="${search}">검색하기2</a>


	<%-- 	<h1>redirect</h1>
	<c:redirect url="${search }"/>
	<c:redirect url="${search }">
		<c:param name="query" value="김민우"></c:param>
	</c:redirect>
 --%>

	<!-- include 와 비슷한 기능을 가진 태그로 
		  다른 페이지를 현재 페이지로 출력하는 기능
		 사용: c:import url="" 파라미터값을 가질 수 있음-->
	<!-- var라는변수에 추가할 페이지가 들어가 있어 var명칭으로 호출한곳에 지정된 페이지를 출력 할 수 있다. -->

	<c:import var="impor"
		url="http://localhost:9090/01_actionTag/views/include/header.jsp">
		<c:param name="title" value="import한 페이지"></c:param>
	</c:import>
	<!-- 변수에 담아서 해당 jsp를 필요한곳에 추가해서 사용 할 수 있다. -->

	<c:import var="im2" url="03_foreach_basic.jsp" />

	<h1>하하</h1>
	<h1>하하</h1>
	<h1>하하</h1>
	<h1>하하</h1>
	${impor }
	<c:out value="${impor }" escapeXml="false"></c:out>
	<c:out value="${im2 }" escapeXml="false"></c:out>





</body>
</html>