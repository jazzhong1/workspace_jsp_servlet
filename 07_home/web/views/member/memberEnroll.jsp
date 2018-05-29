<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>

<script>
	$(function() {
		$("#password_2").blur(function() {
			var p1 = $("#password_").val();
			var p2 = $("#password_2").val();
			if (p1 != p2) {
				alert("비밀번호를 확인하세요");
				$("#password_").focus();
				$("#password_").val("");
				$("#password_2").val("");

			}
		});
	});

	function fn_enroll_validate() {
		var userId = $("#userId_");
		if (userId.val().trim().length < 0 && userId.length < 4) {
			alert("아이디를 확인하세요");
			return false;
		}
		return ture;
	}
	
	function fn_checkIdDuplicate() {
		var userId=$("#userId_").val().trim();
		
		if(!userId||userId.length<4){
			alert("공백없이 4자이상 입력하세요");
			userId.focus();
			//해당 문자 혹은 태그를 진하게 표시
			return false;
		}
		var url="<%=request.getContextPath()%>/checkIdDuplicate";
		var title="checkIdduplicate";
		var status="left=500px,top=100px,width=300px,height=200px";
		var popup=window.open("",title,status);
		
		checkIdDuplicateFrm.userId.value=userId;
		checkIdDuplicateFrm.target=title;
		checkIdDuplicateFrm.action=url;
		checkIdDuplicateFrm.method="post";
		checkIdDuplicateFrm.submit();
		return true;		
	}
</script>

<section id="enroll-container">
	<h2>회원가입정보 입력</h2>
	<form action="memberEnrollEnd.do" method="post"
		onsubmit="return fn_enroll_validate();">
		<table>
			<tr>
				<th>아이디 :</th>
				<td><input type="text" placeholder="4글자 이상 공백없음" name="userId"
					id="userId_" required> <input type="button" id="checkId_"
					name="checkId" value="중복검사" onclick="fn_checkIdDuplicate();">
				</td>
			</tr>
			<tr>
				<th>비밀번호 :</th>
				<td><input type="password" name="password" id="password_"
					required><br></td>
			</tr>
			<tr>
				<th>비밀번호 확인 :</th>
				<td><input type="password" name="password" id="password_2"
					required><br></td>
			</tr>
			<tr>
				<th>이름 :</th>
				<td><input type="text" name="userName" id="userName" required><br>
				</td>
			</tr>
			<tr>
				<th>나이 :</th>
				<td><input type="number" name="age" id="age"><br>
				</td>
			</tr>
			<tr>
				<th>이메일 :</th>
				<td><input type="email" name="email" placeholder="abc@ab.com"
					id="email"><br></td>
			</tr>
			<tr>
				<th>전화번호 :</th>
				<td><input type="tel" name="phone" placeholder="-(없이)010000000"
					id="phone" maxlength=11 required><br></td>
			</tr>
			<tr>
				<th>주소 :</th>
				<td><input type="text" name="address" id="address"><br>
				</td>
			</tr>
			<tr>
				<th>성별 :</th>
				<td><input type="radio" name="gender" id="gender0" value="M"
					checked> <label for="gender0">남</label> <input type="radio"
					name="gender" id="gender1" value="F"> <label for="gender1">여</label>
				</td>
			</tr>
			<tr>
				<th>취미 :</th>
				<td><input type="checkbox" name="hobby" id="hobby0" value="운동">
					<label for="hobby0">운동</label> <input type="checkbox" name="hobby"
					id="hobby1" value="등산"> <label for="hobby1">등산</label> <input
					type="checkbox" name="hobby" id="hobby2" value="독서"> <label
					for="hobby2">독서</label> <input type="checkbox" name="hobby"
					id="hobby3" value="게임"> <label for="hobby3">게임</label> <input
					type="checkbox" name="hobby" id="hobby4" value="여행"> <label
					for="hobby4">여행</label></td>
			</tr>
		</table>
		<input type="submit" value="가입"> <input type="reset"
			value="취소">
	</form>
	<form name="checkIdDuplicateFrm" method="post">
		<input type="hidden" name="userId" />
	</form>
</section>

<%@ include file="/views/common/footer.jsp"%>