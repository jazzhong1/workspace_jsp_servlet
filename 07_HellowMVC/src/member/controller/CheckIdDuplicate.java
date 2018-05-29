package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.sevice.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class CheckIdDuplicate
 */
@WebServlet("/checkIdDuplicate")
public class CheckIdDuplicate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckIdDuplicate() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId=request.getParameter("userId");
		request.setAttribute("userId", userId);
		Member member=new MemberService().selectOne(userId);
		System.out.println(member);
		boolean isUsable=false;
		if(member==null){
			isUsable=!isUsable;
		}
		System.out.println(isUsable);
		request.setAttribute("userId", userId);
		request.setAttribute("isUsable", isUsable);

		RequestDispatcher rd=request.getRequestDispatcher("/views/member/checkduplicate.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
