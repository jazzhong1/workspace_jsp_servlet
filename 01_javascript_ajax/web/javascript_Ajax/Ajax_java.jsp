<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트 Ajax 통신</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<h2>JavaScript이용한 get방식 전송</h2>
	<hr>
	<button onclick='fn_getTest()'>실행</button>
	<div id='test'></div>
	<script>
		function fn_getTest()
		{
			//XMLHTTPRequest객체만들기
			//브라우저마다 표준방식이 다르기때문에
			xhr=getXMLHttpRequest();
			//요청정보설정
			<%-- xhr.open('GET',"<%=request.getContextPath()%>/test?name=홍성진&age=26",true); --%>
			
			xhr.open('POST',"<%=request.getContextPath()%>/test");
			//context-type설정을 해줘야함.. post방식은
			xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded;');			
			xhr.onreadystatechange=myHandle; //변수에 대입했기떄문에 변수명만 정해준다.
			//서버에 페이지 요청 stat가 변변경될떄마다...실행한다.
			//send에서 보낸걸 onreadystatechange에서 감지해서 실행한다.
			
			xhr.send('name=홍성진&age=26');				
		};
		
		
		function getXMLHttpRequest()
		{
			if(window.ActiveXObject)
				//윈도우 객체안에 ActiveXObject가 있으면 IE브라우져라는 말...익스플로어
			{
				try
				{
					return new ActiveXObject("Msxml.XMLHTTP");
				}
				catch(ex)
				{
					return null;
				}
			}
			else if(window.XMLHttpRequest)
				//윈도우 객체안에 XMLHttpRequest가 있으면 
			{
				return new XMLHttpRequest();
			}
			else
				return null;
		};
		/*
		window.ActiveXObject 는 ActiveXObject를 지원하는 브라우저라면 오브젝트를 리턴하고 그렇지 않다면 null를 리턴하게 된다. 
		따라서 오브젝트가 존재하면 if 구문은 true 를 반환하고 xmlHttp 값은 ActiveXObject 객체가 할당되어진다. 
		if 구문이 false 를 반환하면 else if 구분으로 이동하여 xmlHttp 값은 navtive javascript 객체가 할당될 것이다.
			따라서 위 코드를 이용하면 브라우저가 다르더라도 하나의 메소드로 XHR 객체를 생성하여 사용할 수 있다.*/
		
		
		var myHandle=function()
		{
			if(xhr.readyState===4)
			{
				if(xhr.status===200)
					//정상처리
				{
					//console.log(xhr.responseText);
					document.getElementById("test").innerHTML=xhr.responseText; //responseXML
				}
			}
		};
		
	</script>
</body>
</html>





