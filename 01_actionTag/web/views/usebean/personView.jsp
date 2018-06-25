<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<h1>usebean으로 서블릿에서 보낸 객체 받기</h1>
	<!-- Person객체생성 /default생성자로 !! -->
	<jsp:useBean id="person" class='com.kh.action.model.vo.Person' scope='request'/>
	 <!-- scope로 해줘야지 확인을한다. 스코프는 자동으로 person에 새팅을 해준다.-->
	 
	 <div style="color: green">
		 이름 : <jsp:getProperty property="name" name="person"/>
		나이 : <jsp:getProperty property="age" name="person"/>
		성별 : <jsp:getProperty property="gender" name="person"/>
	 </div>
	 <div style="color: red">
		<jsp:setProperty property="name" name="person" value='홍성진'/>
		<jsp:setProperty property="age" name="person" value='26'/>
		<jsp:setProperty property="gender" name="person" value='M'/>
		이름 : <jsp:getProperty property="name" name="person"/>
		나이 : <jsp:getProperty property="age" name="person"/>
		성별 : <jsp:getProperty property="gender" name="person"/>
	 </div>
</body>
</html>







