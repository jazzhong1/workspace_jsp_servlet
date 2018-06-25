package memeber.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet(name="MemberLoginServlet",
			urlPatterns="/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		System.out.println(userId);
		System.out.println(password);
		//서비스단에 id/passwordcheck 요청
		int result=new MemberService().loginCheck(userId, password);
		System.out.println(result);
		//결과에 따른 로그인처리 및 거부처리
		String view="";
		if(result==MemberService.LOGIN_OK)
		{
			Member member=new MemberService().selectOne(userId);
			//System.out.println(member);
			
			//session객체를 받아서 login데이터를 삽입
			HttpSession session=request.getSession();
			
			session.setAttribute("memberLoggedIn", member);
			session.setMaxInactiveInterval(30);			
			//아이디 저장 쿠키 남기기
			String saveId=request.getParameter("saveId");
			if(saveId!=null)
			{
				//쿠키 생성
				Cookie c=new Cookie("saveId",userId);
				c.setMaxAge(6*24*60*60);//6일간쿠키보관
				c.setPath("/");
				response.addCookie(c);				
			}
			else 
			{
				Cookie c=new Cookie("saveId",userId);
				c.setMaxAge(0);//쿠키 삭제
				c.setPath("/");
				response.addCookie(c);
			}
			
			//request.setAttribute("memberLoggedIn",member);
			view="/";
			
		}
		else
		{
			String msg;
			if(result==MemberService.WRONG_PASSWORD)
			{
				msg="패스워드를 잘못 입력하셨습니다.";
			}
			else
			{
				msg="존재하지 않는 아이디 입니다.";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("loc", "/");
			view="views/common/msg.jsp";
		}
		RequestDispatcher rd
			=request.getRequestDispatcher(view);
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
