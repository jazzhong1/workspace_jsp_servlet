package board.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import board.model.service.BoardService;
import board.model.vo.Board;
import common.MyFileRenamePolicy;

/**
 * Servlet implementation class BoardAddEndServlet
 */
@WebServlet("/boardFormEnd")
public class BoardAddEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardAddEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)){
			request.setAttribute("msg", "파일불러오기실패");
			request.setAttribute("loc", "/views/board/boardview.jsp");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		String root=getServletContext().getRealPath("/");
		String saveDir=root+"/uploadFiles"+File.separator+"/board";
		
		int maxSize=1024*1024*10;
		
		MultipartRequest mpr=new MultipartRequest(request, saveDir,maxSize, "UTF-8",new MyFileRenamePolicy());
		
		Board b=new Board();
		b.setBoardTitle(mpr.getParameter("title"));
		b.setBoardWriter(mpr.getParameter("writer"));
		b.setBoardContent(mpr.getParameter("content"));
		b.setBoardOriginalFileName(mpr.getOriginalFileName("up_file"));
		b.setBoardOriginalFileName(mpr.getFilesystemName("up_file"));
		
		int result=new BoardService().insertBoard(b);
		String view="/views/common/msg.jsp";
		String msg="";
		String loc="/boardList";
		if(result>0){
			msg="게시글 등록성공!!";
		}
		else {
			msg="게시글등록실패!!";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
