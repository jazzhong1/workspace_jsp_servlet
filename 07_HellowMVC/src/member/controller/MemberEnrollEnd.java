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
 * Servlet implementation class MemberEnrollEnd
 */
@WebServlet("/memberEnrollEnd")
public class MemberEnrollEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberEnrollEnd() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Member member=new Member();
		member.setMemberId(request.getParameter("userId"));
		member.setMemberPw(request.getParameter("password"));
		member.setMemberName(request.getParameter("userName"));
		member.setGender(request.getParameter("gender"));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		member.setAddress(request.getParameter("address"));
		String[] hobbys=request.getParameterValues("hobby");
		member.setHobby(String.join(",", hobbys));
		System.out.println(member);
		int result=new MemberService().insert(member);
		System.out.println(result);
		String msg="";
		if(result>0){
			msg="회원가입성공";
		}
		else {
			msg="회원가입실패";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", "/");
		RequestDispatcher dispatcher=request.getRequestDispatcher("./views/common/msg.jsp");
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
