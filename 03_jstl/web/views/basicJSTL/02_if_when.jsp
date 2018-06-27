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
	<h2>if문 사용하기</h2>
	<p>작성법: c:if if문과 동일하게 test라는 속성값에</p>
	<p>조건에 대한 결과를 대입하여 (true/false) test값에 따라서 실행할지 않할지 결정</p>
	<hr>
	<p>범위는 시작태그부터 끝태그까지</p>
	<!-- 기본 if 작성 -->
	<%
		int su1 = 30;
		int su2 = 50;
		request.setAttribute("su1", su1);
		request.setAttribute("su2", su2);
	%>

	<c:if test="${su1>su2}" var="check">
		<p>test가 true입니다.</p>
		<c:out value="${check }" />
	</c:if>

	<!-- 파라미터로처리 -->
	<!-- 색상을 입력값에따라 분기처리로직 -->

	<c:if test="${param.color=='빨강'}">
		<span style="color: red;">빨강입니다.</span>
	</c:if>
	<c:if test="${param.color=='파랑'}">
		<span style="color: blue;">빨강입니다.</span>
	</c:if>
	<c:if test="${param.color=='노랑'}">
		<span style="color: yellow;">노랑입니다</span>
	</c:if>
	<!-- 숫자는 ''없음 -->

	<h1>choose태그 이용하기</h1>
	<c:choose>
		<c:when test="${param.product=='플스'}">
			<span style="color: red;">플스입니다.</span>
			<img alt="없음"
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJCPcqfnrysOHk8KZrpi2cOvOfXH7XGt8uJ3be6whssOB733v4"
				width="100px" height="100px">
		</c:when>

		<c:when test="${param.product=='핸드폰'}">
			<span style="color: red;">핸드폰입니다.</span>
			<img alt="없음"
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOLODCbx4brEPDVW7FgmjEfINoL85hcy5hd7OF9getA9ypmDUu"
				width="100px" height="100px">
		</c:when>

		<c:when test="${param.product=='감스트싸인'}">
			<span style="color: red;">감스트싸인입니다.</span>
			<img alt="없음"
				src="data:image/jpeg;base64,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"
				width="100px" height="100px">
		</c:when>

		<c:otherwise>
			<span style="color: pink;"><c:out value="${param.product }"></c:out></span>
		</c:otherwise>
	</c:choose>
	
	
	


</body>
</html>