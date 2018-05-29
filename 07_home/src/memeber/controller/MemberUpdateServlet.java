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

@WebServlet("/memberUpdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		Member member=new Member();
		member.setMemberId(request.getParameter("userId"));
		member.setMemberPw(request.getParameter("password"));
		member.setMemberName(request.getParameter("userName"));
		member.setGender(request.getParameter("gender"));
		member.setAge(Integer.parseInt(request.getParameter("age")));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		member.setAddress(request.getParameter("address"));
		String[] hobbys=request.getParameterValues("hobby");
		String hobby="";
		for(int i=0;i<hobbys.length;i++) {
			hobby=hobby+hobbys[i];
			if(i!=hobbys.length-1) {
				hobby=hobby+",";
			}
		}
		member.setHobby(hobby);
		
		System.out.println(member);
		int result=new MemberService().update(member);
		System.out.println(result);
		
		String msg="";
		String loc="";
		String view="";
		if(result>0){
			msg="회원정보수정완료";
		}	
		else {
			msg="회원수정실패";
		}
		view="views/common/msg.jsp";
		loc="/";
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		RequestDispatcher rd=request.getRequestDispatcher(view);
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
