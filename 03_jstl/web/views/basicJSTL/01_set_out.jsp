<%@page import="com.kh.el.model.vo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<h1>JSTL out을 이용하여 출력하기</h1>
	<p>c:out 태그를 이용하여 출력가능, 속성은 value가 있음.
		value의 값 "" 문자 리터럴이나 EL($)
	   방식 :<c:out value="리터럴값"></c:out> 
	</p>
	<!-- 태그에 감싸서 출력가능 -->
	<h1><c:out value="h1태그안에서 출력"></c:out></h1>
	<!-- <h1>h1태그안에서 출력</h1> -->
	<!-- value안에 태그를 사용해서 출력-->
	<c:out value="<h1>h1태그안에서 출력</h1>" escapeXml="false"></c:out>	
	<!-- escapeXml="false"  로 주면 태그로 사용가능하다.-->
	
	
	
	EL출력 : ${name }
	<%request.setAttribute("name", "홍성진"); %>
	JSTL로 EL출력 : <c:out value="${name }"/>
	JSTL로 EL출력2 : <c:out value="<h3>${name }<h3>" escapeXml="false"/>
	
	<h2>출력문에 대한 예외처리를 defalut값을 설정할 수 있다.</h2>
	
	예외처리 후 있는 문장 출력 <c:out value="${name }" default="홍길동"></c:out><br>
	예외처리 후 있는 문장 출력 <c:out value="${kim }" default="홍길동"></c:out><br>
	<c:out value="${name }"></c:out>
	
	<!-- 반드시 c:out 태그는 value값으로 출력을 정해줘야 한다. -->
	
	<h1>jstl값 대입/저장</h1>
	<p>값을 저장하는것은 c:set태그를 이용하여 처리 </p>
	<p>속성값은 value, var가 있음 var은 일반 변수명 의미하고, value는 var에 들어갈 값을 의미</p>
	
	값 대입후 출력
	<c:set var='book' value='java'></c:set><br>
	<c:out value="${book }"></c:out><br>
	연산값 대입 후 출력 : <c:set var='cal' value="${10-20}"></c:set><br>
	<c:out value="${cal }"/><br>
	<!-- c:set에는 객체도 저장할 수 있다. -->
	<%Person person=new Person("장현수",28,"망함"); %>
	<c:set var="p" value="<%=person %>"></c:set>
	<br>객체출력 : <c:out value="${p.name}"></c:out><br>
	<!--c:set scope를 지정할수있음  page<request<session<application-->
	
	<c:set var="age" value="19" scope="request"/>
	<c:set var="age" value="25" scope="session"/>
	<c:out value="${sessionScope.age}"></c:out><br>
	<!-- 출력할때 하나만쓰고싶은경우 sessionScope로 접근한다. -->
	<!-- session으로 저장된 자를 서블릿에서 확인할수 있지만 requset에 저장된 자료를 확인하지 못함. -->
	<c:out value="${requestScope.age}"></c:out><br>
	<a href="${pageContext.request.contextPath }/checkDate.do">값 확인하기</a>
	
	<!-- 객체를 생성하고 객체에 값을 넣을수 있음 -->
	<c:set var='p1'	value="<%=new Person() %>"></c:set>
	<c:out value="${p1.name }"></c:out>
	<!-- 값을 넣는 방법 target 객체를 선정 property값을 넣을 변수를 지정
	     value에 있는 값을 넣음 -->
	<c:set target="${p1 }" property="name" value="메시"></c:set>
	<c:out value="${p1.name }"></c:out>
	
	<h1>객체 삭제</h1>
	<p>삭제는 c:remove var=변수명 방식으로 변수명에 대한 자료 삭제</p><br>
	삭제 전 출력:<c:out value="${p1 }"/><br>
	<!-- 삭제구문 -->
	<c:remove var="p1"/>
	삭제후 출력:<c:out value="${p1 }"></c:out>
	
	<!-- 삭제 시에도 SCOPE를 저장하여 해당영역에 있는 데이터를 지울 수 있음 -->
	<c:remove var="age" scope="session"/><br>
	session :<c:out value="${sessionScope.age }"></c:out> <br>
	requset : <c:out value="${requestScope.age }"></c:out>
	
</body>
</html>