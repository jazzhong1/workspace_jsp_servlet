package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.Name;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/boardView")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		Board board = new BoardService().selectOne(no);

		/*
		 * List<Board> list=null; if(board!=null) {
		 * 
		 * }
		 */

		Cookie[] cookies=request.getCookies();
		String boardCookieValue="";
		boolean hasRead=false;
		
		if(cookies!=null){
			for(Cookie c:cookies){
				String name=c.getName();
				String value=c.getValue();
				if(name.equals("boardCookies")){
					boardCookieValue=value;
					if(boardCookieValue.contains("|"+no+"|")){
						hasRead=!hasRead;
						break;
					}
				}
			}
		}
		
		if(!hasRead){
			new BoardService().incrementCount(no);
			
			Cookie cookie=new Cookie("boardCookies", boardCookieValue+"|"+no+"|");
			System.out.println(cookie.getValue());
			cookie.setMaxAge(-1);
			//브라우저가 닫는경우 삭제된다.**제일중요
			response.addCookie(cookie);
		}
		
		request.setAttribute("board", board);
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
