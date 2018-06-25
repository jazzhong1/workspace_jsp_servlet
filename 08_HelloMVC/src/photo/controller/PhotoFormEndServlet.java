package photo.controller;

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

import common.MyFileRenamePolicy;
import photo.model.service.PhotoService;
import photo.model.vo.Photo;

/**
 * Servlet implementation class BoardFormEndServlet
 */
@WebServlet("/photo/photoFormEnd")
public class PhotoFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoFormEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDispatcher = null;
		
		/******* 파일업로드 로직 시작 ********/
		//enctype="multipart/form-data" 로 전송되었는지 확인. 
		//아래 두패키지에서 제공함.
		//org.apache.commons.fileupload.servlet.ServletFileUpload
		//org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload
		if(!ServletFileUpload.isMultipartContent(request)) {
			reqDispatcher = request.getRequestDispatcher("/views/common/msg.jsp");
			request.setAttribute("msg", "사진게시판 작성오류![form:enctype 관리자에게 문의하세요.");
			request.setAttribute("loc", "/");
			reqDispatcher.forward(request, response);
		}
		
		
		//a.현재 웹 컨테이너에서 구동중인 웹 어플리케이션의 루트 절대경로 알아내기
		//session객체 -> servlet context객체 -> 절대경로
		String root = request.getSession().getServletContext().getRealPath("/");
//		String saveDirectory = root + "upload/photo";
		//엄밀히 하면, window계열과  unix계열의 구분자가 다르기때문에 아래와 같이 File클래스의 separator필드값을 이용해야함.
		//하지만, 톰캣에서 알아서 처리함.
		String saveDirectory = root + "uploadFiles"+File.separator+"photo";
		System.out.println("saveDirectory => "+saveDirectory);
		
		
	
		int maxSize = 1024 * 1024 * 10;
		
		//c. MultipartRequest 객체 생성함 : 자동 파일 업로드됨
		//업로드 파일최대크기를 초과하면 IOException이 발생된다. 반드시 Exception처리해야 한다.(try~catch)
		/* 
		 com.oreilly.servlet.MultipartRequest.MultipartRequest(HttpServletRequest request, 
															   String saveDirectory, 
															   int maxPostSize, 
															   String encoding, 
															   FileRenamePolicy 중복파일네이밍정책객체) throws IOException
															
		 */
		MultipartRequest mrequest = new MultipartRequest(request, 
														 saveDirectory, 
														 maxSize, 
														 "UTF-8", 
														 new MyFileRenamePolicy());
		/******* 파일업로드 로직 끝 ********/
		
		//1.파라미터값 가져오기
		//이제 request가 아닌 MultipartRequest객체에서 폼파라미터를 가져와야함.
		String photoWriter = mrequest.getParameter("writer");
		String photoContent = mrequest.getParameter("content");
		
		//업로드한 첨부파일명을 얻을 때는 cos.jar라이브러리에서 제공한는 .getfilesystemName("name")을 이용하자.
		String renamedFileName = mrequest.getFilesystemName("up_file");// 현재 시스템에 저장된 파일명(renamed)을 리턴함. (경로아님)
		String originalFileName = mrequest.getOriginalFileName("up_file");//rename policy가 적용되기 전 파일명을 리턴함.
		
		System.out.println("renamedFileName = "+mrequest.getFilesystemName("up_file"));	// 20180411_214717037_449.txt
		System.out.println("originalFileName = "+mrequest.getOriginalFileName("up_file")); // 취업특강.txt
 		
		
		//Photo객체생성
		Photo p = new Photo();
		p.setPhotoWriter(photoWriter);
		p.setPhotoContent(photoContent);
		p.setOriginalFileName(originalFileName);
		p.setRenamedFileName(renamedFileName);
		System.out.println("p="+p);
		
		//2. 비지니스로직 호출
		int result = new PhotoService().insertPhoto(p);
		
		//3. 처리결과에 따른 view단에 처리위임.
		String view = "/views/common/msg.jsp";
		String msg = "";
		//javascript/html에서 사용할 url은 contextPath를 포함한다.
		String loc = "/photo/photoList";

		if(result>0){
			msg = "사진게시판 등록 성공!";
			//loc = "/photo/photoView?no="+result;
		}
		else {
			msg = "사진게시판 등록 실패!";				
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		reqDispatcher = request.getRequestDispatcher(view);
		reqDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
