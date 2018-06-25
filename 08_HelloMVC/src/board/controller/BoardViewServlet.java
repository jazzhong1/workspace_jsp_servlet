package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//번호 파라미터 받아오기
		int no=Integer.parseInt(request.getParameter("no"));
		Board b=new BoardService().selectOne(no);
		if(b!=null)
		{
			List<BoardComment> list=new BoardService().selectComment(no);
			System.out.println(list);
			request.setAttribute("comment", list);
		}
		//조회수 증가!
		Cookie[] cookie=request.getCookies();
		String boardCookieVal="";
		boolean hasRead=false;
		//사이트 방문시에는 아무런 쿠키를 
		//갖고있지 않으면 cookie값은 null이 나옴
		if(cookie!=null)
		{
			outter:
				for(Cookie c : cookie)
				{
					String name=c.getName();
					String value=c.getValue();
					
					if("boardCookie".equals(name))
					{
						boardCookieVal=value;
						if(value.contains("|"+no+"|"))
						{
							System.out.println(c.getValue());
							hasRead=true;
							break outter;
						}
					}
				}
		}
		
		if(!hasRead)
		{
			new BoardService().incrementCount(no);
			
			Cookie c=new Cookie("boardCookie",boardCookieVal+"|"+no+"|");
			c.setMaxAge(-1);
			//브라우저가 닫는 경우 삭제
			response.addCookie(c);		
		}

		request.setAttribute("board", b);
		RequestDispatcher rd=request.getRequestDispatcher("/views/board/boardView.jsp");
		rd.forward(request, response);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
