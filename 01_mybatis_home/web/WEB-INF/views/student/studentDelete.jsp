<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
 <style>
    div#student-container{text-align:center;}
    table#tbl-student{margin:0 auto;border:1px solid; border-collapse:collapse;}
    table#tbl-student th,table#tbl-student td{
        border:1px solid;
        padding:5px;
        line-height: 2em; 
    }
    table#tbl-student th{text-align:right;}
    table#tbl-student td{text-align:left;}
    table#tbl-student tr:last-of-type td{text-align:center;}
 </style>
 
</head>
<body>
	<div id='student-container'>
		<h2>학생삭제</h2>
			<table id='tbl-student'>
				<tr>
					<th>학생번호</th>
					<td><input type="number" required id='stu_no'/></td>
				</tr>
				<tr>
					<td colspan='2'>
						<input type='button' value='삭제' onclick="fn_delete_ajax()"/>
					</td>
				</tr>				
			</table>
		<div style="text-align: left;">
			<table id='tbl-ajax' style="display: none;">

			</table>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	function fn_delete_ajax() {
	$.ajax({
			url:"${pageContext.request.contextPath}/studentDeleteEnd.do",
			data: {no:$('#stu_no').val()},
			type: "get",
			dataType:'json',	//data처리가없을경우 dataType를 쓰면 오류남
			success : function(data) {
				alert(data.msg);
			},
			error: function(jqxhr,textStatus,error) {
				console.log(jqxhr);
				console.log(textStatus);
				console.log(error);
			}
		})
	}
</script>






