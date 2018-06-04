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
	$(function () {
		$("#btn1").on("click", function() {
			$.ajax({
				url: "sample.txt",
				//대문자안댐...
				dataType: "text",
				type: "get",
				success: function(data) {
					$("#text").html(data);
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