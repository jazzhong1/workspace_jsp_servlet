package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminMemberServiceServlet;
import member.model.vo.Member;

@WebServlet(urlPatterns = { "/memberFinder" })
public class MemberFinderServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberFinderServelt() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member memberLoggedId = (Member) request.getSession().getAttribute("memberLoggedIn");

		System.out.println("memberLoggedId" + memberLoggedId);

		if (memberLoggedId == null || !(memberLoggedId.getMemberId()).equals("admin")) {
			request.setAttribute("msg", "잘못된경로로 접근하셨습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}

		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		System.out.println(searchKeyword);
		System.out.println(searchType);

		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			cPage = 1;
		}

		int numPerPage;
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		} catch (Exception e) {
			numPerPage = 10;
		}
		System.out.println("numPerPage="+numPerPage);

		int totalMember = new AdminMemberServiceServlet().selectCount();
		System.out.println("totalMember" + totalMember);
		int totalPage = (int) Math.ceil((double) totalMember / numPerPage);
		System.out.println("totalPage:" + totalPage);

		int pageBarSize = 5;

		int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
		System.out.println("pageNO"+pageNo);

		int pageEnd = pageNo + pageBarSize - 1;
		System.out.println("pageEnd"+pageEnd);


		String pageBar = "";

		if (pageNo == 1) {
			pageBar += "<span>[이전]</span>";
		} else {
			pageBar += "<a href='" + request.getContextPath() + "/memberFinder?cPage=" + (cPage - 1) + "&numPerPage="
					+ numPerPage +"&searchKeyword="+searchKeyword+"&searchType="+searchType+"'>[이전]</a>";
		}

		// 중간에 들어가는 1~5버튼만들기

		while (!(pageNo > pageEnd || pageNo > totalPage)) {
			if (cPage == pageNo) {
				// 페이지이 1~5일경우 5까지갔을때 눌리지 않아야한다.
				pageBar += "<span class='cPage'>" + pageNo + "</span>";
			} else {
				pageBar += "<a href='" + request.getContextPath() + "/memberFinder?cPage=" + pageNo + "&numPerPage="
						+ numPerPage +"&searchKeyword="+searchKeyword+"&searchType="+searchType+"'>" + pageNo + "</a>";
			}
			pageNo++;
		}

		if (pageNo > totalPage) {
			pageBar += "<span>[다음]</span>";
		} else {
			pageBar += "<a href='" + request.getContextPath() + "/memberList?cPage=" + pageNo + "&numPerPage="
					+ numPerPage +"&searchKeyword="+searchKeyword+"&searchType="+searchType+"'>[다음]</a>";
		}

		System.out.println("pageBar : " + pageBar);


		// 데이터베이스에서해당 맴버 가져오기
		List<Member> list = null;

		switch (searchType) {
		case "userId":
			list = new AdminMemberServiceServlet().selectMemberbyIdFind(cPage,numPerPage,searchKeyword);

			break;

		case "userName":
			list = new AdminMemberServiceServlet().selectMemberbyNameFind(cPage,numPerPage,searchKeyword);

			break;

		case "gender":
			list = new AdminMemberServiceServlet().selectMemberbyGenderFind(cPage,numPerPage,searchKeyword);

			break;

		default:
			list = null;
			break;
		}
		System.out.println("findlist=" + list);
		request.setAttribute("list", list);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("cPage", cPage);
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchKeyword", searchKeyword);
		request.getRequestDispatcher("/views/admin/memberFinder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
