package board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class BoardFileDownLoad
 */
@WebServlet("/boardFileDownLoad")
public class BoardFileDownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardFileDownLoad() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String rName = request.getParameter("rName");
		String oName = request.getParameter("oName");
		// 파일입출력할때 동일한 바익으로 처리
		String saveDir = getServletContext().getRealPath("/uploadFiles/board");
		File downFile = new File(saveDir + "/" + rName);
		// 파일입ㅈ출력 스트림연결, 클라리언트연결

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(downFile));

		ServletOutputStream sos = response.getOutputStream();

		BufferedOutputStream bos = new BufferedOutputStream(sos);
		
		String resFile="";
		boolean isMSIE=request.getHeader("user-agent").indexOf("MSIE")!=-1||request.getHeader("user-agent").indexOf("Trident")!=-1;

		if(isMSIE){
			resFile=URLEncoder.encode(oName, "UTF-8").replaceAll("\\", "%20");
		}
		else {
			resFile=new String(oName.getBytes("UTF-8"),"ISO-8859-1");
		}
		
		response.setContentType("application/octet-stream");
		response.setHeader("ContentDispostion", "attachment;filename="+resFile);
		
		int read=-1;
		
		while((read=bis.read())!=-1){
			bos.write(read);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
