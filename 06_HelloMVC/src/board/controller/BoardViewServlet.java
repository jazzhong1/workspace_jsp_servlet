package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/boardView")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardViewServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int board_no = Integer.parseInt(request.getParameter("no"));

		Board b = new BoardService().selectOne(board_no);
		System.out.println(b);

		Cookie[] cookies = request.getCookies();
		String boardCookieVal = "";
		boolean hasRead = false;
		// 사이트방문시아무런 크키를 갖고있지않으면
		// 갖고있지 않으면 cookie은 null

		
		//계속해서 조회수증가하게 막기
		if (cookies != null) {
			outter: for (Cookie c : cookies) {
				// for문 무시하고 빠져나옴.
				String name = c.getName();
				String value = c.getValue();

				if ("boardCookie".equals(name)) {
					boardCookieVal = value;
					if (value.contains("|" + board_no + "|")) {
						hasRead = true;
						break outter;
					}

				}

			}
		}
			if (!hasRead) {
				new BoardService().incrementCount(board_no);

				Cookie c = new Cookie("boardCookie", boardCookieVal + "|" + board_no + "|");
				c.setMaxAge(-1);
				//브라우저가 닫는경우 삭제된다.
				response.addCookie(c);
			}

		//계속해서 조회수증가하게 막기


		request.setAttribute("board", b);
		request.getRequestDispatcher("/views/board/boardView.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
