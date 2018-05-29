package memeber.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOut
 */
@WebServlet("/logout.do")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOut() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session!=null){
			session.invalidate();
			//세션끊기
			response.sendRedirect(request.getContextPath()+"/");
			//세션 타임아웃을 정하는벙법
			//1.session.setMaxinactiveInterval();
											//인자값 sencond
			//2.web.xml에서 설정하는 방법 
			/* 
			 * <session-config>
			 * 	<session-timeout>00</session-timeout>
			 * 					min(정수만)
			 * </session-config>
			 * 
			 * 1)application
			 * 2)server(tomcat)
			 */
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
