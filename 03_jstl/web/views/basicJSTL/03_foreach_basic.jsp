<%@page import="java.util.ArrayList"%>
<%@page import="com.test.el.model.vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<%-- <h1>c:forEach문 사용하기</h1>
	<p>사용자가 입력한 다수의 취미를 페이지에 출력하기</p>
	<c:forEach var="value" items="${paramValues.hobby}">
		<c:choose>
			<c:when test="${value=='reading' }">
				<span>독서</span>
			</c:when>
			<c:when test="${value=='travel' }">
				<span>여행</span>
			</c:when>
			<c:when test="${value=='excercise' }">
				<span>운동</span>
			</c:when>
			<c:when test="${value=='movie' }">
				<span>영화</span>
			</c:when>
			<c:when test="${value=='eat' }">
				<span>먹방</span>
			</c:when>
			<c:otherwise>
				<span>몰선택했니?</span>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<hr> --%>
	
	<h1>c:forEach varStatus 확인하기</h1>
	<p>varStatus는 객체로 for문에 대한 정보를 가진다.</p>
	<p>index번호, for문이 돌아간 횟수, 처음자료인지 끝자료인지</p>
	
	<!-- 게시판 자료출력할떄 많이사용 다수의 데이터를 출려ㄱ할때 -->
	<c:forEach var="value" items="${paramValues.hobby}" varStatus="s">
	<%--<c:out value="${s.index }"/><br>
		<c:out value="${c.count }"/><br> --%>
		<c:if test="${s.first }">(</c:if>
		<c:out value="${value }"/>
		<c:if test="${not s.last}">,</c:if>
		<c:if test="${s.last }">)</c:if>
	</c:forEach>	
	
	
	
	<%String[] player={"토니크로스","외질","케디라","베르너","훔멜스","보아텡"};
		request.setAttribute("player", player);
		List<Member> list=new ArrayList();
		list.add(new Member("홍성진",12,"포도","농구"));
		list.add(new Member("감스트",42,"딸기","축구"));
		list.add(new Member("탱구",53,"바나나","배구"));
		list.add(new Member("노공만",45,"사과","탁구"));
		request.setAttribute("list", list);
	%>
	
	<p>축구선수</p>
	<ul style="list-style: none; display: inline;" >
	<c:forEach var='palyer' items="${strs}" varStatus="s">
		<li><c:out value="${(s.index)+1 }."/><c:out value="${palyer }"/></li>
	</c:forEach>
	</ul>
	<hr>
	
	<p>member<p>
	<ul style="list-style: none; display: inline;" >
	<c:forEach var='member' items="${list}" varStatus="status">
		<li><c:out value="번호 :${(status.index)+1 } "/>
		<c:out value="이름 :${member.name } 나이: ${member.age }"/></li>
	</c:forEach>
	</ul>
	<hr>
	
	<h2>c:forEach begin/end를 활용하기<h2>
	<p>begin하고 end forEach문의 시작과 끝을 의미한다고 볼수있다.</p>
	<h3>반복값을 하나씩출력하기</h3>
	<!-- 역순으로는 안됨... -->
	<ul style="list-style: none; display: inline;">
		<c:forEach var='cnt' varStatus="status" begin="5" end="10">
		<li><c:out value="번호 :${status.index } "/></li>
		<li><c:out value="번호 :${cnt} "/></li>
	</c:forEach>
	</ul>
	<hr>
	
	<h2>forEach태그에 응용해서 처리하기!</h1>
	<c:forEach var="val" begin="1" end="5" items="${player }" varStatus="status">
		<h${status.index+1}>${player[status.index] }<h${status.index+1}>
	</c:forEach>
	<hr>
	
	<h2>forTokens</h2>
	<p>문자열에 포함된 구분자를 통해 토큰을 분리해서 반복처리</p>	
	
	
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>