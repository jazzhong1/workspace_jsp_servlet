<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div#test {
	padding: 10px;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#btn').on('click',function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/test1.do",
				type:'get',
				dataType:'html',
				success:function(data){
					$('#test').html(data);
				}
			});
		});
	});
	
	
	
	
	
	
</script>
</head>
<body>
	<h2>jquery-ajax : html</h2>
	<button type='button' id='btn'>실행</button>
	<div id='test'></div>

</body>
</html>