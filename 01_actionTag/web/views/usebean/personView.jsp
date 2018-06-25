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
	<!-- Person객체 생성 / default생성자로!!!  -->
	<jsp:useBean id="person" class='com.kh.action.model.vo.Person' scope='request'/>
		이름 : <jsp:getProperty property="name" name="person"/>
		나이 : <jsp:getProperty property="age" name="person"/>
		성별 : <jsp:getProperty property="gender" name="person"/>
		<!-- 객체에 값을 대입하는 jsp:setProperty -->
		<jsp:setProperty property="name" name="person" value='백종훈'/>
		<jsp:setProperty property="age" name="person" value='27'/>
		<jsp:setProperty property="gender" name="person" value='남'/>
		
		<table border=1>
			<tr>
				<td>이름 : <jsp:getProperty property="name" name="person"/></td>
			</tr>
			<tr>
				<td>나이 : <jsp:getProperty property="age" name="person"/></td>
			</tr>
			<tr>
				<td>성별 : <jsp:getProperty property="gender" name="person"/></td>
			</tr>
		</table>
		<h2>빈객체를 활용하는 방법</h2>
		<jsp:useBean id="p" class="com.kh.action.model.vo.Person" />
		<jsp:setProperty property="name" name="p" value='김재홍'/>
		<jsp:setProperty property="age" name="p" value='29'/>
		<!-- 객체출력! -->
		이름 : <jsp:getProperty property="name" name="p"/>
		나이 : <jsp:getProperty property="age" name="p"/>
		성별 : <jsp:getProperty property="gender" name="p"/>
		
</body>
</html>







