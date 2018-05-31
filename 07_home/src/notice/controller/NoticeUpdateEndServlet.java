package notice.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;


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
		
		String saveDir=root+"uploadFiles"+File.separator+"/notice";
		
		int fileMax=1024*1024*10;
		
		MultipartRequest mpr=new MultipartRequest(request, saveDir,fileMax,"UTF-8",new DefaultFileRenamePolicy());
		
		
		//이전파일삭제
		String oldfile=mpr.getParameter("old_file");
		
		String filePath=mpr.getFilesystemName("up_file");
		
		File f=mpr.getFile("up_file");
		
		if(f!=null&&f.length()>0){
			File deleteFile=new File(saveDir+"/"+oldfile);
			boolean flag=deleteFile.delete();
		}
		else{
			//새로올린파일이없으면 그대로filePath에는 oldfile이 들어온다.
			filePath=oldfile;
		}
		
		int notice_no=Integer.parseInt(mpr.getParameter("no"));
		String notice_title = mpr.getParameter("title");
		String notice_writer = mpr.getParameter("writer");
		String notice_content = mpr.getParameter("content");
		Notice n = new Notice();
		
		
		n.setNotice_no(notice_no);
		n.setNotice_title(notice_title);
		n.setNotice_writer(notice_writer);
		n.setNotice_content(notice_content);
		n.setFilePath(filePath);
		

		int result = new NoticeService().updateNotice(n);

		String view = "/noticeList";
		String msg = "";

		if (result > 0) {
			msg = "공지사항 등록완료";
		} else {
			msg = "공지사항 등록실패";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", view);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);

		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
