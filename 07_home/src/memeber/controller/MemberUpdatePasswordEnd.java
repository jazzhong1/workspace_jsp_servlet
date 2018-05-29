package memeber.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

@WebServlet(urlPatterns = "/updatePasswordEnd", name = "MemberPasswordUpdateEndServlet")
public class MemberUpdatePasswordEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberUpdatePasswordEnd() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String password_new = request.getParameter("password_new");

		int result = new MemberService().loginCheck(userId, password);

		String msg = "";
		String loc = "";
		String view = "views/common/msg.jsp";
		if (result == 1) {

			result = new MemberService().updatePassword(userId, password_new);
			System.out.println(password_new);
			if (result > 0) {
				msg = "변경완료";
				String script = "self.close()";
				request.setAttribute("script", script);
				System.out.println(script);
			}
		} else {
			msg = "로그인 실패";
			loc = "/";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
