<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 호출 서블릿 test3.do/get/dateType text -->
	<script>
		$(function(){
			$("#btn2").on('click',function(){
				
				$.ajax({
					url:"<%=request.getContextPath()%>/test3.do",
					type:'get',
					dataType:"text",
					success:function(data){//csv내용
						var userArr=data.split("\n");
						console.log("user : "+userArr);
						var tbl=$("<table></table>");
						
						for(var i=0;i<userArr.length;i++)
						{
							var user=userArr[i].split(",");
							//userArr을 모두잘라서 user에 대입 
							
							var html="<tr><td>"+user[0]+"</td>";
							html+="<td>"+user[1]+"</td>";
							html+="<td><img src=<%=request.getContextPath()%>/images/"+user[2]+"></td></tr>";
							tbl.append(html);
						}
						$('#csv').html(tbl);
					}
				});
			});
		});
	</script>

</head>
<style>
table tr td{border:1px solid black;}

</style>
<body>
 <h2>jquery-Ajax : csv</h2>
 <button id='btn2'>실행</button>
 <div id="csv"></div>

</body>
</html>