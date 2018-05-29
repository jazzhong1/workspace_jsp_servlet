package member.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */

@WebServlet(name="MemberUpdateServlet",
			urlPatterns="/memberUpdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자 입력 데이터 받아오기
		System.out.println(request.getAttribute("msg"));
		String userId=request.getParameter("userId");
//		String password=request.getParameter("password");
		String userName=request.getParameter("userName");
		System.out.println(userName);
		int age=Integer.parseInt(request.getParameter("age"));
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String[] hobbys=request.getParameterValues("hobby");
		String hobby="";
		
//		hobby=String.join(",", hobbys);
		
		for(int i=0;i<hobbys.length;i++) {
			hobby=hobby+hobbys[i];
			if(i!=hobbys.length-1) {
				hobby=hobby+",";
			}
		}
		//입력한 데이터 VO(DTO)에 저장하여 application에서 활용
		Member m=new Member(userId,"",userName,gender,age,email,phone,address,hobby);
		//입력받은 데이터 DB저장의뢰 -> MemberService()
		//결과 값은!!CRUD int로나옴
		
		int result= new MemberService().updateMember(m);
		
		//요청에 대한 응답 작성/처리
		String view="";
		String msg="";
		String loc="";
		if(result>0) {
			msg="성공적으로 회원정보를 수정하였습니다.";
		}else {
			msg="회원정보 수정에 실패하였습니다.";
		}
		view="views/common/msg.jsp";
		loc="/";
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		RequestDispatcher rd=request.getRequestDispatcher(view);
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
