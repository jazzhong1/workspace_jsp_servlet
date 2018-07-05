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
		<h2>학생정보 검색</h2>
			<table id='tbl-student'>
				<tr>
					<th>학생번호</th>
					<td><input id='stu_no' type="number" name='no' required/></td>
				</tr>
				<tr>
					<td colspan='2'>
						<input type="button" onclick="fn_sendData()" value='검색'/>
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

	function fn_sendData() {
		$.ajax({
			/*요청 페이지 주소*/
			url:"${pageContext.request.contextPath }/selectAjax.do",
			/*전송할 파리미터 값 스크립트 객체(key:value) 로전송*/
			data:{no:$('#stu_no').val()},
			/* 전송방식(get/post)*/
			type: "get",
			//리턴받을 타입
			dataType:'json', 	//받는 타입.
	
			success: function(data) {
				var html;
				if(data!=null){
					html+="<tr><th>학생번호 </th><td>"+data.studentNo+"</td></tr>";
					html+="<tr><th>학생이름 </th><td>"+data.studentName+"</td></tr>";
					html+="<tr><th>전화번호 </th><td>"+data.studentTel+"</td></tr>";
					html+="<tr><th>이메일 </th><td>"+data.studentEmail+"</td></tr>";
					html+="<tr><th>주소 </th><td>"+data.studentAddr+"</td></tr>";
				}
				else{
					html+="<tr><th>학생번호</th><td>조회된 학생이 없습니다.</td></tr>";
				}
				$('#tbl-ajax').html(html).show();
			},
			error: function(jqxhr,textStatus,error) {
				console.log(jqxhr);
				console.log(textStatus);
				console.log(error);
			}
		})
	}
		
</script>






