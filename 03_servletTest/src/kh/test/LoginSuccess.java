package kh.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginSuccess extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("UTF-8");
		String id=req.getParameter("id");
		
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html;charset=UTF-8");
		
		//순서중요
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>로그인성공</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2 style=='color:red;'>로그인성공</h2>");
		out.print("</body>");
		out.print("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
