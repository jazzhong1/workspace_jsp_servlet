<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
	<script>
	$(function(){
		$("#password_2").blur(function(){
			var p1=$("#password_").val();
			var p2=$("#password_2").val();
			if(p1!=p2){
				alert("패스워드가 일치하지 않습니다.");
				$("#password_").focus();
				$("#password_").val("");
				$("#password_2").val("");
			}
		})
	})
	//아이디 글자수 제한
	function fn_enroll_validate(){
		var userId=$("#userId_");
		if(userId.val().length<4){
			alert("아이디는 최소 4자리 이상이어야 합니다.");
			userId.focus();
			return false;
		}
		return true;
	}
	//중복 검사를 위한 별도의 서블릿 요청
	function fn_checkIdDuplicate(){
		//아이디가 있는지 체크
		var userId=$("#userId_").val().trim();
		//javascript에서 null=false로 인식
		if(!userId||userId.length<4){
			alert("아이디를 입력하거나 4자이상 입력하세요.");
			return;
		}
		var url="<%=request.getContextPath()%>/checkIdDuplicate";
		var title="checkIdduplicate";
		var status="left=500px,top=100px,width=300px,height=200px";
		var popup=window.open("http://www.naver.com",title,status);
		
		checkIdDuplicateFrm.userId.value=userId;
		//윈도우 지칭
		checkIdDuplicateFrm.target=title;
		//
		checkIdDuplicateFrm.action=url;
		checkIdDuplicateFrm.method="post";
		checkIdDuplicateFrm.submit();
	}
	
	
	
	
	</script>


	<section id="enroll-container">
		<h2>회원가입 정보 입력</h2>
		<form action="<%=request.getContextPath() %>/memberEnrollEnd" method="post" onsubmit="return fn_enroll_validate();">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" placeholder="4글자 이상" name="userId" id="userId_" required>
						<!-- 이곳에 폼을 넣어봤자 위의 폼의 액션이 적용되기에 스크립트문으로 해결 -->
						<input type="button" value="중복검사" onclick="fn_checkIdDuplicate();"/></td>
				</tr>
				<tr>
				<th>비밀번호</th>
					<td><input type="password" name="password" id="password_" required ></td>
				</tr>
				
				<tr>
				<th>비밀번호 확인</th>
					<td><input type="password" name="passwordcheck" id="password_2" required></td>
				</tr>
				
				
				<tr>
				<th>이름</th>
					<td><input type="text" name="userName" id="userName" required></td>"
				</tr>
				<tr>
				<th>나이</th>
					<td><input type="number" name="age" id="age"></td>
				</tr>
				<tr>
				<th>이메일</th>
					<td><input type="email" name="email" placeholder="abc@ab.com" id="email"></td>
				</tr>
				<tr>
				<th>전화번호</th>
					<td><input type="tel" name="phone" placeholder="-(없이)010000000" id="phone" maxlength=11 required></td>
				</tr>
				<tr>
				<th>주소</th>
					<td><input type="text" name="address" id="address"></td>
				</tr>
				<tr>
				<th>성별</th>
					<td><input type="radio" name="gender" id="gender0" value="M" checked>
						<label for="gender0">남</label>
						
						<input type="radio" name="gender" id="gender1" value="F">
						<label for="gender1">여</label>
					</td>
					
				</tr>
				<tr>
				<th>취미</th>
					<td><input type="checkbox" name="hobby" id="hobby0" value="운동">
						<label for="hobby0">운동</label>
						<input type="checkbox" name="hobby" id="hobby1" value="등산">
						<label for="hobby1">등산</label>
						<input type="checkbox" name="hobby" id="hobby2" value="독서">
						<label for="hobby2">독서</label>
						<input type="checkbox" name="hobby" id="hobby3" value="게임">
						<label for="hobby3">게임</label>
						<input type="checkbox" name="hobby" id="hobby4" value="여행">
						<label for="hobby4">여행</label>
					
					</td>
				</tr>
			</table>
			<input type="submit" value="가입">
			<input type="reset" value="취소">
			
		
		
		</form>
		<form name="checkIdDuplicateFrm" method="post">
			<input type="hidden" name="userId"/>
		</form>
	
	</section>
	
	


<%@ include file="/views/common/footer.jsp"%>