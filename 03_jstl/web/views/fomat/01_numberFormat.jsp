<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<h1>numberformat 형식</h1>
	<c:set var="numtest1" value="123451245666"/>
	<c:set var="numtest2" value="198284234526673"/>
	<c:set var="numtest3" value="1"/>
	<c:set var="numtest4" value="123.456"/>
	
	기본적인 숫자설정 : <fmt:formatNumber value="${numtest1}"/>
	<br>
	
	<!-- 천단위로 구분하지않고 출력 -->
	천단위 없이 출력 : <fmt:formatNumber value="${numtest1 }" groupingUsed="false"/><br>	
	<!-- 화폐단위를 출력  locaiton이라는 지역 설정에 따라서 자동으로 부여, 
		 기준: 톰켓에 설정되엉있는 지역-->
	통화(기본) : <fmt:formatNumber value="${numtest1 }" type="currency"/><br>
	<fmt:setLocale value="ja_jp"/>
	통화(일본) : <fmt:formatNumber value="${numtest1 }" type="currency"/><br>
	<fmt:setLocale value="en_us"/>
	통화(미국) : <fmt:formatNumber value="${numtest1 }" type="currency"/><br>
	
	<!-- currencySymbol -->
	통화(임의) :<fmt:formatNumber value="${numtest1 }" type="currency" currencySymbol="#"/><br>
	<!-- 퍼센트로 표시해주는 기능 -->
	퍼센트 : <fmt:formatNumber value="${numtest3 }" type="percent"/><br>
	
	<h1>숫자에 패턴적용하기</h1>
	<p>패턴 : #,0 패턴!
		# : 그 자리에 숫자가 없으면 표시하지 않음
		0 : 그자리에 숫자가 없으면 0을 표시1
	</p>
	
	패턴지정 1 <fmt:formatNumber value="${numtest4 }" pattern="0,000.0"/> <br>
	패턴지정 2 <fmt:formatNumber value="${numtest4 }" pattern="##,###.#######"/><br>
	패턴지정 2 <fmt:formatNumber value="${numtest4 }" pattern="#,###.000"/><br>
	
	<!-- 소수점 자리를 표현하는 옵션값 
		minFractionDight :최소 소수점 자리수 
		maxFractionDigit : 최대 소수점 자리수-->
	minFractionDight : <fmt:formatNumber value="${numtest4 }" minFractionDigits="5" pattern="#,###.#####"/><br>
	minFractionDight : <fmt:formatNumber value="${numtest4 }" maxFractionDigits="2" pattern="#,###"/>	
	
	
</body>
</html>