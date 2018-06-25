<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
	Member member=(Member)request.getAttribute("member");
	//member userid, userpassword, usrname email.... hobby
	String hobby=member.getHobby();
	String[] hobbys=hobby.split(",");
	String[] checked=new String[5];
	//String userName=member.getMemberName()!=null?member.getMemberName():"";
	for(int i=0;i<hobbys.length;i++)
	{
		switch(hobbys[i])
		{
			case "운동" : checked[0]="checked";break; 
			case "등산" : checked[1]="checked";break;
			case "독서" : checked[2]="checked";break;
			case "게임" : checked[3]="checked";break;
			case "여행" : checked[4]="checked";break;
		}
	}
%>
<%@ include file="/views/common/header.jsp" %>
<script>

	function fn_update_member(servlet)
	{
		var frm=$("#memberfrm");
		var url="<%=request.getContextPath()%>/memberUpdate";
		frm.attr('action',url);
		frm.submit();
	}
	
	function fn_delete_member()
	{
		var frm=$("#memberfrm");
		var url="<%=request.getContextPath()%>/memberDelete";
		frm.attr('action',url);
		frm.submit();
	}
	function fn_update_password()
	{
		var url="<%=request.getContextPath()%>/updatePassword?userId=<%=member.getMemberId() %>";
		var status="left=500px, top=200px, width=400px, height=210px";
		var title="updatePassword";
		
		var popup=window.open(url, title, status);		
	}
	
	
</script>
<section id="enroll-container">
	<h2>회원 정보 수정</h2>
	<form id="memberfrm" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text"  
					name="userId" 
					id="userId_" value="<%=member.getMemberId() %>" readonly>
				</td>
			</tr>
<%-- 			<tr>
				<th>비밀번호</th>
				<td><input type="password" 
				name="password" id="password_" 
				value="<%=member.getMemberPw() %>" required><br>
				</td>					
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password" 
				name="passwordCkeck" id="password_2" 
				value="<%=member.getMemberPw() %>" required><br>
				</td>					
			</tr> --%>				
			<tr>
				<th>이름</th>
				<td><input type="text" 
				name="userName" id="userName" 
				value="<%=member.getMemberName() %>" required><br>
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="number" 
				name="age" id="age" value="<%=member.getAge() %>"><br>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" 
				name="email" 
				value="<%=member.getEmail() %>"
				id="email"><br>
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="tel" name="phone"
				value="<%=member.getPhone() %>"
				id="phone" maxlength=11 required><br>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" 
				name="address" value="<%=member.getAddress() %>"
				id="address"><br>
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
				<%if("M".equals(member.getGender())) {%>
					<input type="radio" name="gender"
					 id="gender0" 
					value="M" checked>
					<label for="gender0">남</label>
					<input type="radio" name="gender" 
					id="gender1" value="F" >
					<label for="gender1">여</label>
				<%} else { %>
					<input type="radio" name="gender"
					 id="gender0" 
					value="M">
					<label for="gender0">남</label>
					<input type="radio" name="gender" 
					id="gender1" value="F" checked>
					<label for="gender1">여</label>
				<% } %>
				</td>
			</tr>
			<tr>
				<th>취미</th>
				<td>
				<input type="checkbox" name="hobby"
				id="hobby0" value="운동" <%=checked[0] %>>
				<label for="hobby0">운동</label>
				<input type="checkbox" name="hobby"
				id="hobby1" value="등산" <%=checked[1] %>>
				<label for="hobby1">등산</label>
				<input type="checkbox" name="hobby"
				id="hobby2" value="독서" <%=checked[2] %>>
				<label for="hobby2">독서</label>
				<input type="checkbox" name="hobby"
				id="hobby3" value="게임" <%=checked[3] %>>
				<label for="hobby3">게임</label>
				<input type="checkbox" name="hobby"
				id="hobby4" value="여행" <%=checked[4] %>>
				<label for="hobby4">여행</label>
				</td>				
			</tr>
		</table>
		<input type="button" onclick="fn_update_member();" value="정보수정">
		<input type="button" onclick="fn_update_password();" value="비밀번호변경">
		<input type="button" onclick="fn_delete_member();" value="탈퇴">
	</form>
</section>	
<%@ include file="/views/common/footer.jsp"%>












