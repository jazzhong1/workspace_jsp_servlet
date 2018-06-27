<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<h2>파라미터값 EL로 출력하기!</h2>
<p>EL로 출력시에는 반드시 앞에 객체명 param을 작성하고 접근 연산자를 통해접근
	param을 작성하고 접근 연산자를 통해 접근
<%-- 	예) param.명칭 // 명칭 X
	ex) ${param.명칭 } //${명칭} X --%>
</p>

	<p>상품명세서</p>		
	<ul style="list-style: none">		<!-- form으로넘기는건 모두 param -->
		<li>상품명(param미기재): ${pname}</li>
		<li>상품명: ${param.pname }</li>
		<!-- 여래개값을 받을떄 param으로 출력하면 처음 값 하나만 출력 -->
		<li>수량: ${param.pcount }</li>
		<li>옵션: ${param.option}</li>
		
		<!-- 여러개 값을 다 출력하려면 paramValues를 이용해여 배열 형식으로 출력 -->
		<li>옵션 : ${paramValues.option[0]}</li>	<!-- 배열은 이런방식으로 받는다 하지만 JSTL로 for:each문돌림. -->
		<li>옵션 : ${paramValues.option[1]}</li>
	</ul>


</body>
</html>