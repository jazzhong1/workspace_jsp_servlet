package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import member.model.vo.Member;

@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int cPage;
		try {
			cPage=Integer.parseInt((String) request.getParameter("cPage"));
		} catch (Exception e) {
			cPage=1;
		}
		
	
		
		
		int numPerPage;
		try {
			numPerPage=Integer.parseInt((String) request.getParameter("numPerPage"));
		} catch (Exception e) {
			numPerPage=10;
		}
		
		
	
		
		System.out.println("cPage :" + cPage);
		System.out.println("numPerPage :" + numPerPage);
		
		List<Board> list=new BoardService().selectList(cPage,numPerPage);
		System.out.println(list);

		int totalBoard=new BoardService().selectCount();
		System.out.println("totalBoard" + totalBoard);

		
		int totalPage=(int)Math.ceil((double)totalBoard/numPerPage);
		System.out.println("totalPage:" + totalPage);

		
		
		int pageBarSize=3;
		int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
		//페이지사이즈가 5이기떄문에 현재페이지가 6이되지 않을경우 시작페이지가 6으로 넘어간다.
		//로직임.
						

		// 페이지 바의 종료번호 설정
		int pageEnd = pageNo + pageBarSize - 1;
		
	
		
		
		System.out.println("pageNo :"+pageNo);

		System.out.println("pageEnd :"+pageEnd);
		
		String pageBar="";
		
		if (pageNo == 1) {
			pageBar += "<span>[이전]</span>";
		} else {
			pageBar+="<a href='"+request.getContextPath()+"/boardList?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'>[이전]</a>";
		}

		// 중간에 들어가는 페이지버튼 1~5버튼 만들기

		while (!(pageNo > pageEnd||pageNo > totalPage)) {
			if (cPage == pageNo) {
				pageBar += "<span class='cPage'>" + pageNo + "</span>";
			} else {
				pageBar += "<a href='" + request.getContextPath() + "/boardList?cPage=" + pageNo + "&numPerPage="
						+ numPerPage + "'>"+pageNo+"</a>";
			}
			pageNo++;
		}

		// [다음]버튼 만들기

		if (pageNo >= totalPage) {
			pageBar += "<span>[다음]</span>";
		} else {
			pageBar += "<a href='" + request.getContextPath() + "/boardList?cPage=" + pageNo + "&numPerPage=" + numPerPage
					+ "'>[다음]</a>";
		}

		System.out.println("pageBar : " + pageBar);
		
		
		request.setAttribute("board", list);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("cPage", cPage);
		request.setAttribute("numPerPage", numPerPage);
		request.getRequestDispatcher("/views/board/boardList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
