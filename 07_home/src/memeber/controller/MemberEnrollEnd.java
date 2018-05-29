package memeber.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/memberEnrollEnd.do")
public class MemberEnrollEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberEnrollEnd() {
        super();
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
		String hobby=String.join(",", hobbys);
		member.setHobby(request.getParameter("hobby"));
		
		System.out.println(member);
		
		int result=new MemberService().insertMember(member);
		String view = "";
		String msg="";
		if(result>0){
			msg="가입완료";
			
		}
		else {
			msg="가입실패";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", "/");
		view = "views/common/msg.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
