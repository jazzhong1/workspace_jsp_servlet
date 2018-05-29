package notice.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.interfaces.RSAKey;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.http11.filters.BufferedInputFilter;

@WebServlet("/noticeFileDownload")
public class NoticeIfleDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeIfleDownloadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.경로설정(직접경로)
		String saveDir=getServletContext().getRealPath("/uploadFiles"+File.separator+"/notice");
		//2.파라미터가져오기(파일명)
		String filename=request.getParameter("filePath");
		//해당하는 파일 을 불어오기
		System.out.println(filename);
		File downFile=new File(saveDir+"/"+filename);
		//파일을 램과 연결하는 스트림 생성 서버의 램으로 파일을 옮김
		//통상적으로 Bufferd를 많이사용한다.
		BufferedInputStream bis=new BufferedInputStream
				(new FileInputStream(downFile));
		
		//client의 컴퓨터와 스트림 연결
		ServletOutputStream sos=response.getOutputStream();
		BufferedOutputStream bos=new BufferedOutputStream(sos);
		
		//브라우저에서 받을수있게 분기 처리
		//1. 브라우저 확인 
		//인코딩을 UTF-8형식으로 바꿔주는것 한글명 파일 깨짐 방지
		String resFile="";
		boolean isMSIE=request.getHeader("user-agent").indexOf("MSIE")!=-1
				||request.getHeader("user-agent").indexOf("Trident")!=-1;
				
		if(isMSIE)//브라우저가 익스플로러이면! 
		{
			resFile=URLEncoder.encode(filename,"UTF-8").replaceAll("\\+","%20");
		}
		else
		{
			resFile=new String(filename.getBytes("UTF-8"),"8859_1");//8859-1
			//java.io.UnsupportedEncodingException: IOS-8859-1 지원안한다는뜻.
		}
		
		//파일을 전송하기 위한 응답설정
		//파일 전송 설정 response header를 설정
		response.setContentType("application/octet-stream");
		response.setHeader("content-Disposition","attachment;filename="+resFile);
												//inline로 하면 화면에바로뜸...
		
		//전송파일을 client에 써주기!
		
		
		
		////////////////////////////실제로 쏘는 로직은 여기서작용된다////////////////////////////////////
		//실제파일 write하기 
		int read=-1;
		//에초에 -1로 초기화한후
		
		while((read=bis.read())!=-1)
				//bis.read()한바이트씩 읽어들여 read에 저장
		{
			bos.write(read);
			//정확히 브라우저한테 쏘는 로직은 여기서 작용된다.
		}
		bis.close();
		bos.close();		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
