package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.BoardComment;

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

		List<BoardComment>list=null;
		if(b!=null){
			list=new BoardService().selectCommentList(board_no);
			System.out.println(list);
		}
		
		
		Cookie[] cookies = request.getCookies();
		String boardCookieVal = ""; //속성값을 넣기위한 초기화값
		boolean hasRead = false;	//이 서블릿에서 원하는 name에 쿠기가 없기때문에 if문에 걸리기위한 초기화.
		// 사이트방문시아무런 크키를 갖고있지않으면
		// 갖고있지 않으면 cookie은 null

		
		//계속해서 조회수증가하게 막기
		if (cookies != null) {
			outter: for (Cookie c : cookies) {
				// for문 무시하고 빠져나옴.
				String name = c.getName();
				String value = c.getValue();

				if ("boardCookie".equals(name)) {		//특정게시판에 한번은 접속한것임.
					boardCookieVal = value;
					if (value.contains("|" + board_no + "|")) {	//primary key가 중요하다.
							//value.안에 있는지 검사 규칙적인 구분자로 끊어질경우 contains으로 끊어서 찾는다.
						hasRead = true;	//이부분이 핵심 제일 밑으로 내려가지 못하게 하기위해.
						break outter;
						// for문 무시하고 빠져나옴.
					}
				}
				//내부적으로 어느부분에서 쿠키로 작성못하는 로직인지 알아야함.
			}
		}
			if (!hasRead) { //hasRead가 false이면~
				new BoardService().incrementCount(board_no); //증가시킨다. 여기서 hasRead가 거짖일떄만 들어올수있기때문에
															//한번밖에 조회수를 증가시키지 못한다.

				Cookie c = new Cookie("boardCookie", boardCookieVal + "|" + board_no + "|");
				System.out.println("Cookie"+c);
				c.setMaxAge(-1);
				//브라우저가 닫는경우 삭제된다.**제일중요
				response.addCookie(c);
				//헤더에 쿠키를 첨부해서 보낸다.
			}

		//계속해서 조회수증가하게 막기
			
			
			
			
		request.setAttribute("board", b);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/board/boardView.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
