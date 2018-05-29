package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import member.model.sevice.MemberService;
import member.model.vo.Member;

@WebServlet("/login.do")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberLogin() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		System.out.println(userId);
		System.out.println(password);

		int result = new MemberService().loginCheck(userId, password);
		System.out.println(result);
		String view = "/";
		if (result == MemberService.LOGINOK) {
			Member member=new MemberService().selectOne(userId);
			request.setAttribute("member", member);
			
			HttpSession session=request.getSession();
			session.setAttribute("member", member);
			session.setMaxInactiveInterval(30);			

			
		}

		else {
			String msg ="";
			if (result == MemberService.PASSWORDMAISS) {
				msg="비밀번호가 옳지 않습니다.";
				
			}			
			else{
				msg="아이디가 옳지 않습니다.";				
			}
			request.setAttribute("msg", msg);
			request.setAttribute("loc", "/");
			view = "views/common/msg.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
