package kh.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheck extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		
		String fixId="user01";
		String fixPw="user01";
		if (id.equals(fixId)) {
			
			if(pw.equals(fixPw)){
				System.out.println("로그인성공");
				RequestDispatcher rd=req.getRequestDispatcher("success.do");
				rd.forward(req, resp);
				//req,resp 두개 인자를 가지고 가져가라 
				//클래스에 있는 자동으로 doget메소드로 간다. 
			}
			else {
				resp.sendRedirect("views/loginfail.html");
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}
		
		else {
			System.out.println("일치하는아이디가 없습니다.");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
	}

}
