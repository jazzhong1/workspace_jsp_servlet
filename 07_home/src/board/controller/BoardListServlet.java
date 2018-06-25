package board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import javafx.scene.layout.Pane;
import member.model.vo.Member;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 페이징처리 여기서하기

		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (Exception e) {
			cPage = 1;
		}

		int numPerPage;
		try {
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		} catch (Exception e) {
			numPerPage = 10;
		}

		int totalBoard = new BoardService().selectCount();
		System.out.println(totalBoard);
		int totalPage = (int) Math.ceil((double) totalBoard / numPerPage);

		ArrayList<Board> list = new BoardService().selectBoardList(cPage, numPerPage);
		System.out.println(list);

		// 화면에 표시될 페이지바 구성

		int pageBarSize = 3;
		int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
		int pageEnd = pageNo + pageBarSize - 1;
		System.out.println(pageNo);
		System.out.println(pageEnd);
		System.out.println(pageBarSize);

		String pageBar = "";
		if (pageNo == 1) {
			pageBar += "<span>[이전]</span>";
		}

		else {
			pageBar += "<a href='" + request.getContextPath() + "/boardList?cPage=" + (pageNo - 1) + 
					"&numPerPage="+ numPerPage + "'>[이전]</a>";
		}
		while (!(pageNo > pageEnd) || (pageNo > totalPage)) {
			if (cPage == pageNo) {
				pageBar += "<span class='cPage'>" + pageNo + "</span>";
			} else {
				pageBar += "<a href='" + request.getContextPath() + "/boardList?cPage=" 
				+ pageNo + "&numPerPage="+ numPerPage + "'>" + pageNo + "</a>";
			}
			pageNo++;
		}

		if (pageNo >= totalPage) { // 같거나 커지면
			pageBar += "<span>[다음]</span>";
		} else {
			pageBar += "<a href='" + request.getContextPath() + "/boardList?cPage=" 
			+ pageNo + "&numPerPage="+ numPerPage + "'>[다음]</a>";
		}

		System.out.println("pageBar : " + pageBar);

		request.setAttribute("board", list);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("cPage", cPage);
		request.setAttribute("numPerPage", numPerPage);
		request.getRequestDispatcher("/views/board/boardList.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
