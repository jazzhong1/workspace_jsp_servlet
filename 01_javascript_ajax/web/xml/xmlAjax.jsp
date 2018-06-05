<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function(){
		$('#btn').click(function(){
			$.ajax({
				url:"sample.xml",
				type:"get",
				dataType:"xml",
				//이부분점검//
				success: function(data) {
					//data의 루트노드 즉 books... 
					var root=$(data).find(":root");		//ajx로 하기때문에 바로 xml로가서 찾아올수있따.
					//books 하위의 북 tag를 찾기
					var bookArr=$(root).find("book"); //배열로들어옴...
					
					var fictionInfo="<tr><th>제목</th><th>저자</th></tr>";
					var itInfo="<tr><th>제목</th><th>저자</th></tr>"
					
					//each문은 for in문과 비슷 
					bookArr.each(function(index,value) {
						//bookArr 태그 하위의 태그를 찾는것
						//제목(title),저자(author)을 찾음
						
						var info="<tr><td>"+$(this).find("title").text()+"</td>";
						info+="<td>"+$(this).find("author").text()+"</td></tr>";
						//$실수 ㄴㄴ
						//title,author은 즉 name개념으로 태그명으로 찾아올수있음.
						//xml은 바로 태그명에있는 속성값을 가져올수있다는 장점이있따.
						if($(this).find("subject").text()=="소설"){
							fictionInfo+=info;
						}
						else{
							itInfo+=info;
						}
					})
					$("#fictioninfo").html(fictionInfo);
					$("#itinfo").html(itInfo);
				}

			//이부분점검//
			})
		})
	});
</script>
</head>
<body>
	<h2>jquery-jax:xml</h2>
	<button id='btn'>실행</button>
	<div id='fiction'>
		<h3>소설</h3>
		<table id='fictioninfo'></table>
	</div>

	<div id='id'>
		<h3>프로그래밍</h3>
		<table id='itinfo'></table>
	</div>
	
</body>
</html>