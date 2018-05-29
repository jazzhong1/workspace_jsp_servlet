package admin.controller;

import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import member.model.vo.Member;

@WebServlet("/memberFinder")
public class MemberFinderServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberFinderServelt() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Member memberLoggedId = (Member) request.getSession().getAttribute("memberLoggedIn");
		// jsp에서 접근가능 jsp에서 세션을 만들었기떄문에 접근가능하다.

		// 관리자가 아닐경우 페이지 접속을 차단하는 로직.
		System.out.println("세션확인:" + memberLoggedId);
		// 왜 memberLoggedId가 null로나올까

		if (memberLoggedId == null || !memberLoggedId.getUserId().equals("admin")) {
			request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}

		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");

		// 페이징처리 시작

		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			cPage = 1;
		}

		int numPerPage;
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		} catch (NumberFormatException e) {
			numPerPage = 10;
		}

		int totalMember = new AdminService().selectCount();

		// 총 페이지 갯수
		int totalPage = (int) Math.ceil((double) totalMember / numPerPage);

		// 페이지바 세팅
		int pageBarSize = 5;

		// 페이지바 시작번호
		int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
		System.out.println("pageNO" + pageNo);

		int pageEnd = pageNo + pageBarSize - 1;
		// 이부분이네.......

		String pageBar = "";

		if (cPage == 1) {
			pageBar += "<span>[이전]</span>";
		} else {
			pageBar += "<a href='" + request.getContextPath() + "/memberFinder?cPage=" + (cPage - 1) + "&numPerPage="
					+ numPerPage + "&searchType=" + searchType + "&searchKeyword=" + searchKeyword + "'>[이전]</a>";
		}

		while (!(pageNo > pageEnd || pageNo > totalPage)) {

			if (cPage == pageNo) {
				// 처음표시될때 눌리지 않을경우의수
				pageBar += "<span>" + pageNo + "</span>";
			} else {
				pageBar += "<a href='" + request.getContextPath() + "/memberFinder?cPage=" + pageNo + "&numPerPage="
						+ numPerPage + "&searchType=" + searchType + "&searchKeyword=" + searchKeyword + "'>" + pageNo
						+ "</a>";
			}
			pageNo++;
		}

		if (pageNo > totalPage) {
			pageBar += "<span>[다음]</span>";

		}

		else {
			pageBar += "<a href='" + request.getContextPath() + "/memberFinder?cPage=" + pageNo + "&numPerpage="
					+ numPerPage + "&searchType=" + searchType + "&searchKeyword" + searchKeyword + "'>[다음]</a>";
		}
		System.out.println("pageBar" + pageBar);

		// 데이터베이스에서 해당되는 멤버 가져오기(searchKeyword하고 일치하는 것가져오기)
		List<Member> list = null;

		// 안먹음....
		switch (searchType) {
		case "userId":
			list = new AdminService().selectMemberbyIdFind(cPage, numPerPage, searchKeyword);
			break;
		case "userName":
			list = new AdminService().selectMemberbyNameFind(cPage, numPerPage, searchKeyword);
			break;
		case "gender":
			list = new AdminService().selectMemberbyGenderFind(cPage, numPerPage, searchKeyword);
			break;
		default:
			list = null;
			break;
		}

		System.out.println(list);
		request.setAttribute("list", list);
		request.setAttribute("cPage", cPage);
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchKeyword", searchKeyword);

		

		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/memberFinder.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
