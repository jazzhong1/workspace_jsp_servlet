<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<h2>서블릿에서 보낸 requset 값출력</h2>
		축구선수 이름 : ${player}<br>
		축구선수 이름 : <%=request.getAttribute("player") %><br>
		<!--  page부터 세션~이런식으로 찾아가기떄문에 우선순위가 낮다.-->
		축구선수 나이 : ${age}<br>
		포지션 : ${position}<br>
		아이템 목록 : ${items}<br>
		Person목록[list] : ${person}<br>
		Person의 name출력 : ${person.name}<br>
								<!-- vo의변수명 -->
								<!-- vo에 getter를 가져옴 -->
		Person의 age출력 : ${person['age']}<br>
								<!-- vo의변수명 -->
								<!-- vo에 getter를 가져옴 -->		
	<h2>객체 출력하기</h2>	
		
		
				
</body>
</html>