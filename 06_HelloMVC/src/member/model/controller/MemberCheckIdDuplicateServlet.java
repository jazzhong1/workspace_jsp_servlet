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
 * Servlet implementation class MemberCheckIdDuplicateServlet
 */
@WebServlet("/checkIdDuplicate")
public class MemberCheckIdDuplicateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberCheckIdDuplicateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post방식으로 받아와서 한글은 인코딩을 해줘야함
		request.setCharacterEncoding("UTF-8");
		//보낸 userId값 받아오기
		String userId=request.getParameter("userId");
		//보낸 userId값 반복확인 비지니스로직 수행
		//플래그값으로 isUsable을 선언하여 true면 사용가능
		//false면 사용불가능
		boolean isUsable=new MemberService().duplicateId(userId);
		//4.받은결과 페이지 팝업창으로 전송처리
		request.setAttribute("userId", userId);
		request.setAttribute("isUsable", isUsable);
		RequestDispatcher rd=request.getRequestDispatcher("views/member/checkDuplicate.jsp");
		rd.forward(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
