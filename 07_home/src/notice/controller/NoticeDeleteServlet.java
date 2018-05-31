package notice.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet("/noticedelete")
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no=Integer.parseInt(request.getParameter("no"));
	
		String root=getServletContext().getRealPath("/");
		String filename=request.getParameter("filePath");
		String saveDir=root+"/uploadfiles"+File.separator+"notice";
		boolean flag=false;
		if(filename!=null&&filename.length()>0){
			File deleteFile=new File(saveDir+"/"+filename);
			flag=deleteFile.delete();
		}
		
		int result=new NoticeService().deleteNotice(no);
		String view="/views/common/msg.jsp";

		if(result>0&&flag){
			request.setAttribute("msg", "삭제완료");
			request.setAttribute("loc", "/noticeList");
		}
		else{
			request.setAttribute("msg", "삭제실패[관리자에게문의하세요]");
			request.setAttribute("loc", "/noticeList");
		}
		request.getRequestDispatcher(view).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
