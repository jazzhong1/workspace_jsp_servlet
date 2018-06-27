<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<h2>personform.jsp보낸 parameter값을 바로 useBean에 넣어 활용</h2>
	<jsp:useBean id="person" class="com.kh.action.model.vo.Person">	<!-- person객체생성으로 볼수있음 -->
		<jsp:setProperty property='name' name='person' param='name'/>	<!-- set -->
		<jsp:setProperty property='age' name='person' param='age'/>		<!-- set -->
		<jsp:setProperty property='gender' name='person' param='gender'/>
	</jsp:useBean>
	<!-- name은 정해줄수 있음. -->
	<!-- Person person=new Person();
		person.setName(name);
		person.setAge(age); ....
	 -->
	 <!-- 바로앞에있는 bean을 가져오는것.. -->
	 이름 : <jsp:getProperty property="name" name="person"/>
	 나이 : <jsp:getProperty property="age" name="person"/>
	 성별 : <jsp:getProperty property="gender" name="person"/>
	 
	 
	 
	 
	 
	<!-- action tag는 name으로 보내면 propertey로 vo면수명으로 받고 bean으로 객체를 받아서 대입해서사용.. -->
	<!-- useBean의 id는 name으로 매핑?되는개념 --> 
	<h1>파라미터 이름과 객체 멤버변수명이 같을 경우 
		param속성을 생략해도 일치하는 값이 대입됨	
	</h1>
	<jsp:useBean id="p" class="com.kh.action.model.vo.Person">
		<jsp:setProperty property='name' name='p'/>	
		<jsp:setProperty property='age' name='p'/>
		<jsp:setProperty property='gender' name='p'/>
	</jsp:useBean>
	
	
	 이름 : <jsp:getProperty property="name" name="p"/>
	 나이 : <jsp:getProperty property="age" name="p"/>
	 성별 : <jsp:getProperty property="gender" name="p"/>

</body>
</html>