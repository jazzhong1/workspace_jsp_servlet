package member.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class MemberPasswordUpdateEndServlet
 */
@WebServlet(name="MemberPasswordUpdateEndServlet",
		urlPatterns="/updatePasswordEnd")
public class MemberPasswordUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPasswordUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String userId=request.getParameter("userId");
			String password=request.getParameter("password");
			String pass_new=request.getParameter("password_new");
			
			int result=new MemberService().loginCheck(userId, password);
			
			String msg="";
			String loc="";
			String view="views/common/msg.jsp";
			if(result==MemberService.LOGIN_OK){
				
				result=new MemberService().updatePassword(userId,pass_new);
				System.out.println(pass_new);
				if(result>0) {
					msg="변경완료";
					String script="self.close()";
					request.setAttribute("script", script);
					System.out.println(script);
				}
			}
			else{
				msg="로그인 실패";
				loc="/";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			RequestDispatcher dispatcher=request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
