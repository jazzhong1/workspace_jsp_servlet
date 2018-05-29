package kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import kh.member.model.sevice.MemberService;
import kh.member.model.vo.Member;


@WebServlet("/logincheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginCheck() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		Member m=new MemberService().logincheck(id,pw);
		//로그인결과확인
		System.out.println(m.getMember_pwd());
		if(m!=null){
			if(m.getMember_pwd()!=null){
				HttpSession session=request.getSession();
				//request.getSession() 주소값이 session에대입 
				session.setAttribute("loginmen", m);
										//키값 ,속성
				//session주소값에.set~~하기때문에 같은 주소값을 가리킨다.]
				//패턴중요
				
				
				request.setAttribute("member", m);
				//객체안에 데이터를 추가한것.			
				System.out.println("로그인성공");

				//로그인이 되엇다는걸 check유지~
				
				RequestDispatcher rd=request.getRequestDispatcher("main.do");


				rd.forward(request, response);
			}
			else {
				System.out.println("로그인실패");
			}
			
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
