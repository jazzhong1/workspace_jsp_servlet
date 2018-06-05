<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{border:1px solid; border-collapse:collapse;}
	tr,td{border:1px solid;}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#btn').click(function() {
			var user={
					userId:$("#userid").val(),	
					userPhone:$("#userphone").val(),
					userProfile:$("#userprofile").val()
			}

			console.log(user);
			$.ajax({
				url:"<%=request.getContextPath()%>/ajaxjson",
				data:user,
				type:"post",
				success: function(data) {
				var temp="<table>";
				console.log(data);
				for(var i in data){
					var user=data[i]
					temp+="<tr><td>"+user.name+"</td>";
					temp+="<td>"+user.phone+"</td>";
					temp+="<td>"+user.profile+"</td></tr>";
					console.log(temp);
				}
					temp+="</table>";
				$("#container").html(temp);
				},
				error: function(request,status,data) {
					$("#container").html("자료를가져오는데실패");

				},
				complete: function (data) {
 					$("[name=userName],[name=userId],[name=userAddr]").val("");

				}
			})
		});
	})
</script>
</head>
<body>
<h3>회원가입 및 출력</h3>
<p>ajax로 입력받는 사용자 정보를 회원목록에 추가하고 회원전체를 출력하는 로직</p>
이름 : <input type='text' name='username' id='username' placeholder="이름을 입력하세요"/><br><br>
아이디 : <input type='text' name='userphone' id='userphone' placeholder="전화번호를 입력하세요"/><br><br>
주소 : <input type='text' name='userprofile' id='userprofile' placeholder="프로필입력"/><br><br>
<button id='btn'>입력</button>
<div id='container' class='area'></div>
</body>
</html>