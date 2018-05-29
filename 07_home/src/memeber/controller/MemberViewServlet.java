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

@WebServlet("/memberView")
public class MemberViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId=request.getParameter("userId");
		System.out.println(userId);
		
		Member member=new MemberService().selectOne(userId);
		//DB로부터 받아온 데이터를 페이지에 전송하기 위해 request객체에 저장
		//key:value 방식으로 

		String msg="";//에러 메세지 출력변수
		String view="";//이동할 페이지 설정변수
		String loc="";//이동한 페이지에서 재이동할 페이지 설정
		//DB로부터 리턴받은 값에 따라 페이지를 선택하는 로직
		//페이지 이동시 필요한 데이터 세팅
		//필요한 데이터를 request객체에 저장
		
		if(member==null){
			view="views/common/msg.jsp";
			msg="회원정보를 가져올수 없습니다.";
			loc="/";
			
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
		}
		else{
			view="views/member/memberView.jsp";
			request.setAttribute("member", member);
		}
		RequestDispatcher rd=request.getRequestDispatcher(view);
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
