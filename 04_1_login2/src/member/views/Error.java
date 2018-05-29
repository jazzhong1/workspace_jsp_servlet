package member.views;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;

@WebServlet("/error")
public class Error extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Error() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m=(Member) request.getAttribute("member");
		//requset에서 member가져오기
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<script src='http://code.jquery.com/jquery-latest.min.js'></script>");
		out.println("<script>");
		out.println("$(function(){setTimeout(function(){location.href='index.html'},3000)});");
		out.println("</script>");
		out.println("<title>에러페이지</title");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>"+request.getAttribute("msg")+"</h1>");
		out.println("</body>");
		out.println("</html>");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
