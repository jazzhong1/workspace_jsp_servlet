package admin.controller;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/memberList")
public class AdminMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminMemberListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Member memberLoggedId = (Member) request.getSession().getAttribute("memberLoggedIn");
		// 세션은 어디에서든즈 위방식으로 가져와서 확인할수 있따.

		// 관리자가 아닐경우 페이지 접속을 차단하는 로직. 아주중요하다.
		// System.out.println(memberLoggedId);
		if (memberLoggedId == null || !memberLoggedId.getUserId().equals("admin")) {
			request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}

		// 페이징처리
		// 1.파라미터로 변수받기.
		// 현재 페이지, 페이지에 표시될 자료수를 초기화

		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
			// NumberFomatException발생.
		} catch (NumberFormatException e) {
			cPage = 1;		//현재페이지니까
		}
		// 처음에 초기화하는값을 try catch로 잡는다.

		int numPerPage;
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		} catch (NumberFormatException e) {
			numPerPage = 10;
		}
		System.out.println("cPage :" + cPage);
		System.out.println("numPerPage :" + numPerPage);

		// 처음에 초기화하는값을 try catch로 잡는다.

		// 여기까지 초기화

		//
		// 현재 페이지에 표시될 자료면 필터화하여 가져오는 로직구성.
		ArrayList<Member> list = new AdminService().selectMemberList(cPage, numPerPage);
		System.out.println(list);
		// 페이지 구성 pageBark작성

		int totalMember = new AdminService().selectCount();
		System.out.println("totalMember" + totalMember);
		//총페이지 를 알아야하기떄문에 totalMember를 가져온다.

		int totalPage = (int) Math.ceil((double) totalMember / numPerPage);
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
			pageBar += "<a href='" + request.getContextPath() + "/memberList?cPage=" + (pageNo - 1) + "&numPerPage="
					+ numPerPage + "'>[이전]</a>";
		}

		// 중간에 들어가는 페이지버튼 1~5버튼 만들기

		while (!(pageNo > pageEnd||pageNo > totalPage)) {
			if (cPage == pageNo) {
				pageBar += "<span class='cPage'>" + pageNo + "</span>";
			} else {
				pageBar += "<a href='" + request.getContextPath() + "/memberList?cPage=" + pageNo + "&numPerPage="
						+ numPerPage + "'>"+pageNo+"</a>";
			}
			pageNo++;
		}

		// [다음]버튼 만들기

		if (pageNo > totalPage) {
			pageBar += "<span>[다음]</span>";
		} else {
			pageBar += "<a href='" + request.getContextPath() + "/memberList?cPage=" + pageNo + "&numPerPage=" + numPerPage
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
		
		RequestDispatcher rs = request.getRequestDispatcher("/views/admin/memberList.jsp");
		rs.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
