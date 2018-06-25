package memeber.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet(name="MemberUpdateServlet",
			urlPatterns="/memberUpdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자 입력 데이터 받아오기!
		System.out.println(request.getAttribute("msg"));
		String userId = request.getParameter("userId");
//		String password = request.getParameter("password");
//		System.out.println(password);
		String userName = request.getParameter("userName");
		System.out.println(userName);
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String[] hobby=request.getParameterValues("hobby");
		
		String hobby_str=String.join(",",hobby);
		//입력한 데이터 VO(=DTO)에 저장하여 application에서 활용
		Member member=new Member(userId,"",userName,gender,age,email,phone,address,hobby_str,null);
		//입력받은 데이터 DB저장(삽입)의뢰 -> MemberService()
		//결과값은!!CRUD int로 나옴
		int result=new MemberService().updateMember(member);
		
		//요청에 대한 응답작성/처리
		String view="";
		String msg="";
		String loc="";
		
		if(result>0)
		{
			msg="성공적으로 회원정보를 수정하였습니다.";
		}
		else
		{
			msg="회원정보 수정에 실패하였습니다.";
		}
		view="views/common/msg.jsp";
		loc="/";
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		RequestDispatcher rd=request.getRequestDispatcher(view);
		rd.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
