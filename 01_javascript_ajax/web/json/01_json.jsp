<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
				$.ajax({
				url:"<%=request.getContextPath()%>/ajaxjson",
				type:"post",
				dataType:"json",
				success: function(data) {
					console.log(data);
					var temp="";
					$.each(data, function(index,item) {
						temp+="이름 :"+item.name;
						temp+="아이디 : "+item.id;
						temp+="주소 : "+item.addr;	
					})
					console.log(temp);
						$("#print").html(temp);
				},
				error: function(request,status,error) {
					alert(error)
				}
			})
		})
	});
</script>
</head>
<body>
	<h2>Json객체받기</h2>
	<button id='btn'>실행</button>
	<div id='print'></div>

</body>
</html>