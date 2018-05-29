package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminMemberServiceServlet;
import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/memberList")
public class AdminMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminMemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member memberLoggedId=(Member)request.getSession().getAttribute("memberLoggedIn");
		if (memberLoggedId == null||!memberLoggedId.getMemberId().equals("admin")) {
			request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		
		
		//페이징처리 시작
		//1.파라미터로 변수받기
		//현재페이지,페이지에 표시될 자료를 초기화.
		
		int cPage;
		//현재페이지..초기값을 0으로 한다.
		try{
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}
		catch (NumberFormatException e) {
			cPage=1;
		}
		//표시할 row수를 List.jsp에서 가져온다.
		int numPerPage;
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		} catch (NumberFormatException e) {
			numPerPage = 10;
		}
		// 처음에 초기화하는값을 try catch로 잡는다.

		// 여기까지 초기화

		//
		// 현재 페이지에 표시될 자료면 필터화하여 가져오는 로직구성.
		
		System.out.println("cPage :" + cPage);
		System.out.println("numPerPage :" + numPerPage);
		
		ArrayList<Member> list=new AdminMemberServiceServlet().selectMemberList(cPage,numPerPage);
		System.out.println(list);
		// 페이지 구성 pageBark작성
		
		int totalMember =new AdminMemberServiceServlet().selectCount();
		System.out.println("totalMember" + totalMember);
		//총페이지 를 알아야하기떄문에 totalMember를 가져온다.
		
		int totalPage=(int)Math.ceil((double)totalMember/numPerPage);
		//ex)57/10 5.7 이다 무조건 올림을해서 예방을해준다. totalPage는 즉슨 총페이지갯수.
		System.out.println("totalPage:"+totalPage);
		
		//페이지바 구성
		// 페이지 바의 표현될 페이지 개수
		int pageBarSize=5;
		// 페이지 바의 시작번호 설정
		// cPage 1~5사이의 숫자 :1 1~5
		// cpage 6~10사이의 숫자 : 6 6~10
		
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		// 페이지 바의 시작번호 설정
		// cPage 1~5사이의 숫자 :1 1~5
		// cpage 6~10사이의 숫자 : 6 6~10
		
		int pageEnd=pageNo+pageBarSize-1;
		//pageNo는 페이지바 시작번호이기떄문에 고정값과 더한후 -1일 해줄경우 페이지끝이 출력된다.
		//ex pageNo가 6라고 했을때 pageBarSize는 항상 5로 고정이기때문에 둘이더하면 11 -1 하면10이된다.
		//즉슨 pageNo는 1,6,11 로 정해진 로직에 따라 pageEnd도 바뀐다. 
		
		// 페이지바에 들어갈 html구문 작성
		// 이전

		//페이지바 구성
		String pageBar="";
		if(pageNo==1) {
			pageBar+="<span>[이전]</span>";
		}
		else {
			pageBar+="<a href='"+request.getContextPath()+"/memberList?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'>[이전]</a>";
			//cPage=(pageNo-1)해주는이유는 전에 페이지로 돌아가야하기때문이다
			//로직 다시 확인.
		}
		// 중간에 들어가는 페이지버튼 1~5버튼 만들기

		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo){
				pageBar += "<span class='cPage'>" + pageNo + "</span>";
				//페이지이 1~5일경우 5까지갔을때 눌리지 않아야한다.
			}
			else{
				pageBar += "<a href='" + request.getContextPath() + "/memberList?cPage=" + pageNo + "&numPerPage="
						+ numPerPage + "'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		if (pageNo > totalPage) {
			pageBar += "<span>[다음]</span>";
		} else {
			pageBar += "<a href='" + request.getContextPath() + "/memberList?cPage=" + pageNo + "&numPerPage=" + numPerPage
					+ "'>[다음]</a>";
		}

		System.out.println("pageBar : " + pageBar);
		
		System.out.println("pageBar : " + pageBar);

		/*
		 * for (Member m : list) { System.out.println(m.toString()); }
		 */

		//데이터전송
		request.setAttribute("list", list);
		//페이징바 설정ㄱ밧 전송
		request.setAttribute("pageBar", pageBar);
		//현재 페이지 전송 cpage
		request.setAttribute("cPage", cPage);
		//페이지당 자료수 전송 numPerPage
		request.setAttribute("numPerPage", numPerPage);
		
		RequestDispatcher rs = request.getRequestDispatcher("/views/admin/memberList.jsp");
		rs.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
