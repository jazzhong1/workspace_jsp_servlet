package notice.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class NoticeUpdateEndServlet
 */
@WebServlet("/noticeUpdateEnd")
public class NoticeUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeUpdateEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.값이 제데로 전송됬느지부터 확인
		if(!ServletFileUpload.isMultipartContent(request)){
			request.setAttribute("msg", "[오류:관리자에게문의하세요]");
			request.setAttribute("loc", "/views/notice/noticeUpdate.jsp");
			request.getRequestDispatcher("/views/common/msg.jsp");
		}
		
		//파일업로드시작!
		//1.파일
		String root=getServletContext().getRealPath("/");
		String saveDir=root+File.separator+"/notice";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
