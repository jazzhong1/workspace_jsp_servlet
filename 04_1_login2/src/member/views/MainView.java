package member.views;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;

@WebServlet("/mainview")
public class MainView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainView() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m=(Member)request.getAttribute("member");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		out.write("<html><head>");
		out.write("<style>");
		out.write("body{ background-color:black; color:white;}");
		out.write("li a{ text-decoration:none; color:white;}");
		out.write("li {margin-right:10px;display:inline-block;}");
		out.write("td{text-align:center}");
		out.write("td:first-child{text-align:right}");
		out.write("#login{");
		out.write("display:inline-block;");
		out.write("float:right;");
		out.write("}");
		out.write("#head{");
		out.write("margin-top:-20px;");
		out.write("display:inline-block;");
		out.write("}");
		out.write("</style>");
		out.write("</head><body>");
		out.write("<div align='center'>");
		out.write("<div id='head'>");
		out.write("<h1 id='header' align='center'>BS 홈페이지에 오신것을 환영합니다.</h1>");
		out.write("</div>");
		out.write("<div id='login'>");
		out.write("<form action='loginout.do' method='post'>");
		out.write("<table>");
		out.write("<tr>");
		out.write("<td><label for='id'><h3>"+m.getMember_name()+"</h3></label></td>");
		out.write("<td><h3>님 방문을 환영합니다.</h3></td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td></td>");
		out.write("<td><button type='submit'>로그아웃</button></td>");
		out.write("</tr>");
		out.write("</table>");
		out.write("</form>");
		out.write("</div>");
		out.write("</div>");
		out.write("<hr>");
		out.write("<header>");
		out.write("<ul>");
		out.write("<li><a href='info.do'>공지사항</a></li>");
		out.write("<li><a href='board.do'>게시판</a></li>");
		out.write("<li><a href='content.do'>자료실</a></li>");
		out.write("</ul>");
		out.write("</header>");
		out.write("</body></html>");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
