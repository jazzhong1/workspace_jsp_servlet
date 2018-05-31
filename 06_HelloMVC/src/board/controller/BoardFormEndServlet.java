package board.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.model.service.BoardService;
import board.model.vo.Board;
import common.MyFileRenamePolicy;

/**
 * Servlet implementation class BoardFormEndServlet
 */
@WebServlet("/boardFormEnd")
public class BoardFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardFormEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//파일을 가져오는지 안가져오는지 확인.
		if(!ServletFileUpload.isMultipartContent(request)){
			request.setAttribute("msg", "게시판 작성오류[관리자에ㅔ문의하세요]");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		
		//2작업
		String root=getServletContext().getRealPath("/");
		String saveDir=root+"uploadFiles"+File.separator+"board";
		System.out.println(saveDir);
		
		//3작업 크기조정
		int maxSize=1024*1024*10; //10메가 설정
		
		
		
		//jsp,exe,html파일만 못올라오도록 막아주는것이 좋다.
		
		
		
		
		
		
	
		//4.객체생성및 폴리시정책작성
		MultipartRequest mpr=new MultipartRequest(request, saveDir,maxSize, "UTF-8",new MyFileRenamePolicy());
		
		Board b=new Board();
		b.setBoardTitle(mpr.getParameter("title"));
		b.setBoardWriter(mpr.getParameter("writer"));
		b.setBoardContent(mpr.getParameter("content"));
		b.setBoardOriginalFileName(mpr.getOriginalFileName("up_file")); //form에서 입력받은 파일이름이 들어옴
		b.setBoardRenameFileName(mpr.getFilesystemName("up_file"));	//리네임한 파일들어옴 즉 폴리시한 rename이 들어옴.
		
		//체크 mpr로 넘기니까 getpara로 받지못함.
		/*
		String checkFile=mpr.getOriginalFileName("up_file");
		if(checkFile.contains(".jsp")||checkFile.contains(".exe")||checkFile.contains(".html")){
		
			//삭제로직
			File deleteFile=new File(saveDir+"/"+checkFile);
			deleteFile.delete();
			
			request.setAttribute("msg", "올릴수 없는파일입니다.[확장자명 확인]");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}*/
		
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
