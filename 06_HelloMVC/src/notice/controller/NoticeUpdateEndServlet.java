package notice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

@WebServlet("/noticeUpdateEnd")
public class NoticeUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeUpdateEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.값이 제대로 전송됬는지 부터 확인
				RequestDispatcher rd = null;
				if (!ServletFileUpload.isMultipartContent(request)) {
					// 데이터자체가 끊어졌을때 파일을 올렸는데 제대로 받지 않아쓸때
					rd = request.getRequestDispatcher("/views/common/msg.jsp");
					request.setAttribute("msg", "공지사항작성오류[fom:enctype=관리자에게 문의하세요]");
					request.setAttribute("loc", "/");
				}

				// 파일 업로드 시작!!
				// 1.파일 업로드 위치를 설정(직접경로) 파일시스템에서 하고 폴더를 먼저 생성
				// 폴더먼저생성 upload.notice 하위로

				String root = getServletContext().getRealPath("/");
				// C드라이브에서부터 이 프로젝트 경로까지잡아버린다.
				// C:\Users\jazzh\Desktop\KH_Academy_Hong\Day_result\KH_Academy_Hong\jsp_servelt\workspace_servlet_jsp\06_HelloMVC\web\
				// 까지 경로를 잡아줌

				String saveDir = root + "uploadFiles" + File.separator + "/notice";
				// File.separator \,/ 파일시스템에 맞춰서 처리해줌
				// System.out.println(saveDir);

				// 2.파일이 업로드될 최대크기설정
				int fileMax = 1024 * 1024 * 10; // 10mb

				// 업로드할 방식끝

				// 3.MultipartRequset 객체를 생성하여 파일업로드
				// 1)인자값 : requset, 파일 저장 경로, 파일최대 사이즈, 인코딩방식, 파일 중복처리객체
				// new DefaultFileRenamePolicy() 파일중복처리객체
				MultipartRequest mpr = new MultipartRequest(request, saveDir, fileMax, "UTF-8", new DefaultFileRenamePolicy());
				
				int notice_no=Integer.parseInt(mpr.getParameter("no"));
				String notice_title = mpr.getParameter("title");
				String notice_writer = mpr.getParameter("writer");
				String notice_content = mpr.getParameter("content");
				//이전파일삭제
				String oldfile=mpr.getParameter("old_file");
				//noticeUpdate.jsp 에서 hidden으로 만들어서 old파일을 만들어 관리한다.
				
				String filePath = mpr.getFilesystemName("up_file");
				
				File f=mpr.getFile("up_file");
				
				if (f!=null && f.length()>0) { //이전 파일을 삭제함
					//이전파일을 삭제해야함.
					File deleteFile=new File(saveDir+"/"+oldfile);
					boolean flag=deleteFile.delete();
				}
				else {
					filePath=oldfile;
				}
				// enctype form데이터로 보냈기때문에 cos에서 제공하는 multpart requset로 받는ㄷ.ㅏ
				System.out.println(filePath);

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
