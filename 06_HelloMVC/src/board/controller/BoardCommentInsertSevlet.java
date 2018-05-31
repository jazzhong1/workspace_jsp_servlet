package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.BoardComment;

@WebServlet("/boardCommentInsert")
public class BoardCommentInsertSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardCommentInsertSevlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardRef=Integer.parseInt(request.getParameter("boardRef"));
		String boardCommentWriter=request.getParameter("boardCommentWriter");
		int boardCommentLevel=Integer.parseInt(request.getParameter("boardCommentLevel"));
		int boardCommentRef=Integer.parseInt(request.getParameter("boardCommentRef"));
		String boardCommentContent=request.getParameter("boardCommentContent");
		
		BoardComment bc=new BoardComment();
		bc.setBoardRef(boardRef);
		bc.setBoardCommentWriter(boardCommentWriter);
		bc.setBoardCommentLevel(boardCommentLevel);
		bc.setBoardCommnetRef(boardCommentRef);
		bc.setBoardCommentContent(boardCommentContent);
		
		int result=new BoardService().insertBoardComment(bc);
		String view="/views/common/msg.jsp";
		String loc="boardView?no="+boardRef;	//게시판 번호
		String msg="";
		if(result>0){
			msg="작성완료";
		}
		else{
			msg="작성실패";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
