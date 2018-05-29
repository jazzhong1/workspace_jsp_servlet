package memeber.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

@WebServlet("/checkIdDuplicate")
public class MemberCheckIdDuplicateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberCheckIdDuplicateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* (non-Javadoc)
		 *  request로 id를 받아와서 체크해서 아이디가 중복,중복이아님을 판단해서 
		 *  checkduplicate.jsp로 보낸다.
		 *  
		 *  
		 *  
		 *  
		 * 
		 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
		 */
		
		String userId=request.getParameter("userId");
		
		boolean isUsable=new MemberService().duplicate(userId);
		System.out.println(userId);
		System.out.println(isUsable);
	
		request.setAttribute("userId", userId);
		request.setAttribute("isUsable", isUsable);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/views/member/checkduplicate.jsp");
		dispatcher.forward(request, response);

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
