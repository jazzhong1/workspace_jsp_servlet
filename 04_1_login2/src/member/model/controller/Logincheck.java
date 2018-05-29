package member.model.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static common.JDBCTemplate.*;

import member.model.vo.Member;
import member.service.MemberService;

@WebServlet("/login.do")
public class Logincheck extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Logincheck() {
	}

		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("호출되니");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String msg="";
		String view="";
		Member member = new MemberService().loginCheck(id, pw);
		//member 객체가 null이면 id없음!
		//member 객체에 멤버변수 중 userPwd가 ""a면 pw가 틀린것.
		
		if(member!=null){
			//중요
			if(member.getMember_pwd().equals("")){
				//ㅔpw틀린것
				
				msg="비밀번호가 일치하지 않습니다.";
				//에러메세지를 만들어서 메세지를 비밀번호가 일치하지 않습니다 출력후 메인으로 이동
				//메세지내용을  request객체에 map방식(key:value)으로 저장! 
				request.setAttribute("msg",msg);
				view="error";
			}
			else {
				//로그인성공
				request.setAttribute("member", member);
				view="mainview";
//				response.sendRedirect("main");
			}
			
		}
		else{
			msg="아이디가 일치하지 않습니다.";
			//에러메세지를 만들어서 메세지를 비밀번호가 일치하지 않습니다 출력후 메인으로 이동
			request.setAttribute("msg",msg);
			view="error";
		}
		RequestDispatcher rd=request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
