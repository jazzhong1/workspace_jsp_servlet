package memeber.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import member.model.service.MemberService;
import member.model.vo.Member;
import sun.security.util.Password;

@WebServlet(urlPatterns="/login.do",
			name="MemberLoginServlet")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginCheck() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		System.out.println(userId);
		System.out.println(password);

		int result = new MemberService().loginCheck(userId, password);
		System.out.println(result);
		String view = "";
		if (result == MemberService.LOGINOK) {
			Member member = new MemberService().selectOne(userId);
			// System.out.println(member);
			HttpSession session = request.getSession();
			System.out.println(session.getId());
			session.setAttribute("memberLoggedIn", member);
			// session.setMaxInactiveInterval(30);
			view = "/";
			// index로 보내버리라는뜻.
			session.setMaxInactiveInterval(1800*60);

			String saveId = request.getParameter("saveId");
			if (saveId != null) {
				Cookie cookie = new Cookie("saveId", userId);
				cookie.setMaxAge(6 * 24 * 60 * 60);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
			else {
				Cookie cookie = new Cookie("saveId", userId);
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}

		} else {
			String msg;
			if (result == MemberService.WORNGPW) {
				msg = "패스워드를 잘못입력하셨습니다.";
			} else {
				msg = "존재하지않는 아이디입니다.";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("loc", "/");
			view = "views/common/msg.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
