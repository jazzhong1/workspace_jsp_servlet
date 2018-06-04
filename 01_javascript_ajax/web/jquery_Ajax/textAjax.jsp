<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div#text{
	width:500px;
	height:300px;
	boder:1px solid red;
	margin:30px 10px;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#btn1').on('click',function(){
			$.ajax({
				//xml requset가 자동으로 생성된다고 볼수있다.
				url:"sample.txt",
				type:"get",
				dataType:"text",
				success:function(data){	//success완료가됬을떄 별도의 
										//data변수를 명수하지않아도 알아서 받아서 넣는다.
					//readyState:4번
					//sataus:200일때 작용한다.
					$('#text').html(data);
					//text는 태그를 인식하지못한다.
					//html로 하면 태그를인식해 파싱처리해서인식한다.
				}
			});
		});
	});
</script>
</head>
<body>
	<h2>jquery_ajax : text</h2>
	<button type='button' id='btn1'>simple.txt</button>
	<div id='text'></div> <!-- 빈공간에 쏴주기위해 -->
	
	
</body>
</html>