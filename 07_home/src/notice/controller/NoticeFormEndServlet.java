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

import member.model.vo.Member;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;


@WebServlet("/noticeFormEnd")
public class NoticeFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeFormEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member memberLoggedIn=(Member)request.getSession().getAttribute("memberLoggedIn");
		//getAttruibute로 받는다.
		
		if(memberLoggedIn==null||!(memberLoggedIn.getMemberId()).equals("admin")){
			request.setAttribute("msg", "잘못된 경로입니다.");
			request.setAttribute("loc", "/views/notice/noticeList.jsp");
			request.getRequestDispatcher("/views/common/msg.jsp");
			return;
		}
		
		//값이 제대로 전송됬는지부터확인
		
		if(!ServletFileUpload.isMultipartContent(request)){
			request.setAttribute("msg", "공지사항작성오류[form:enctype=]");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp");
			return;
		}
		
		///파일업로드 시작
		//1파일업로드 위치설정(직접경로) 파일시스템에서 하고 폴더먼저 생성
		
		String root=getServletContext().getRealPath("/");
		// C드라이브에서부터 이 프로젝트 경로까지잡아버린다.
		// C:\Users\jazzh\Desktop\KH_Academy_Hong\Day_result\KH_Academy_Hong\jsp_servelt\workspace_servlet_jsp\06_HelloMVC\web\
		// 까지 경로를 잡아줌
		
		String saveDir=root+"uploadFiles"+File.separator+"/notice";
		// File.separator \,/ 파일시스템에 맞춰서 처리해줌
		// System.out.println(saveDir);
		
		//2.파일이 업로드 될 최대크기설정
		int fileMax=1024*1024*10; 	//10mb임
		
		//업로드할방식 끝~
		
		//3.MultipartRequeset 객체를 생성하여 파일업로드
		// 1)인자값 : requset, 파일 저장 경로, 파일최대 사이즈, 인코딩방식, 파일 중복처리객체
		// new DefaultFileRenamePolicy() 파일중복처리객체
		
		MultipartRequest mpr=new MultipartRequest(request, saveDir,fileMax,"UTF-8",new DefaultFileRenamePolicy());
		

		String notice_title = mpr.getParameter("title");
		String notice_writer = mpr.getParameter("writer");
		String notice_content = mpr.getParameter("content");
		String filePath = mpr.getFilesystemName("up_file");
		// enctype form데이터로 보냈기때문에 cos에서 제공하는 multpart mpr로 받는ㄷ.ㅏ
		
		System.out.println(filePath);
		
		Notice n=new Notice();
		n.setNotice_title(notice_title);
		n.setNotice_writer(notice_writer);
		n.setNotice_content(notice_content);
		n.setFilePath(filePath);
		
		int result=new NoticeService().insertNotice(n);
		
		String view="/noticeList";
		String msg="";
		if(result>0) {
			msg="공지사항등록완료";
		}
		else {
			msg="공지사항등록실패";
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
