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
		$("#srcName").keyup(function() {
			//눌럿다 때면
			var srcName=$(this).val();
			$.ajax({
				
				url: "<%=request.getContextPath()%>/list.do",
				type: "post",
				data:"srcName="+srcName,
				dataType:"html",
				success:function(data){
					console.log(data);
					var dataList=data.split("\n");
					var html="";
					for (var i = 0; i < dataList.length; i++) {
						html+="<option>"+dataList[i]+"</option>";
					}
					$("#datalist").html(html);
				}
			})
		})
	})
</script>
</head>
<body>
<h2>jquery-ajax:datalist</h2>
<input type='text' name="srcName" id="srcName" list="datalist" multiple></input>
<datalist id="datalist"></datalist>
</body>
</html>