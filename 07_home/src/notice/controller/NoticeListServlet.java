package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet(urlPatterns="/noticeList")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member memberLoggedIn=(Member)request.getSession().getAttribute("memberLoggedIn");
		
		if(memberLoggedIn==null){
			request.setAttribute("msg", "회원가입후 이용하세요");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		
		//페이징처리
		
		//1.v파라미터로 변수받기
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch (Exception e) {
			cPage=1; //현재페이지니까 
		}
		//처음초기화
		
		int numPerPage;
		try {
			numPerPage=Integer.parseInt(request.getParameter("numPerPage"));
		}catch (Exception e) {
			numPerPage=10; //현재페이지니까 
		}
		
		System.out.println("cPage :" + cPage);
		System.out.println("numPerPage :" + numPerPage);
		

		List<Notice> list=new NoticeService().selectList(cPage,numPerPage);
		
		int totalNotice=new NoticeService().selectCount();
		System.out.println("totalNotice" + totalNotice);
		
		int totalPage = (int) Math.ceil((double) totalNotice / numPerPage);
		//ex)57/10 5.7 이다 무조건 올림을해서 예방을해준다. totalPage는 즉슨 총페이지갯수.
		System.out.println("totalPage:" + totalPage);

		String pageBar = "";

		// 페이지 바 구성
		// 페이지 바의 표현될 페이지 개수
		int pageBarSize = 5;
		// 페이지 바의 시작번호 설정
		// cPage 1~5사이의 숫자 :1 1~5
		// cpage 6~10사이의 숫자 : 6 6~10
		int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
		//페이지사이즈가 5이기떄문에 현재페이지가 6이되지 않을경우 시작페이지가 6으로 넘어간다.
		//로직임.
						

		// 페이지 바의 종료번호 설정
		int pageEnd = pageNo + pageBarSize - 1;
		

		// 페이지바에 들어갈 html구문 작성
		// 이전
		if (pageNo == 1) {
			pageBar += "<span>[이전]</span>";
		} else {
			pageBar += "<a href='" + request.getContextPath() + "/noticeList?cPage=" + (pageNo - 1) + "&numPerPage="
					+ numPerPage + "'>[이전]</a>";
		}

		// 중간에 들어가는 페이지버튼 1~5버튼 만들기

		while (!(pageNo > pageEnd||pageNo > totalPage)) {
			if (cPage == pageNo) {
				pageBar += "<span class='cPage'>" + pageNo + "</span>";
			} else {
				pageBar += "<a href='" + request.getContextPath() + "/noticeList?cPage=" + pageNo + "&numPerPage="
						+ numPerPage + "'>"+pageNo+"</a>";
			}
			pageNo++;
		}

		// [다음]버튼 만들기

		if (pageNo > totalPage) {
			pageBar += "<span>[다음]</span>";
		} else {
			pageBar += "<a href='" + request.getContextPath() + "/noticeList?cPage=" + pageNo + "&numPerPage=" + numPerPage
					+ "'>[다음]</a>";
		}

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

		
		
		
		request.setAttribute("noticelist", list);
		request.getRequestDispatcher("/views/notice/noticeList.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
