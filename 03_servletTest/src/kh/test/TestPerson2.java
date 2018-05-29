package kh.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestPerson2 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id=req.getParameter("id");
		String pw=req.getParameter("password");
		String name=req.getParameter("name");
		String color=req.getParameter("color");
		String animal=req.getParameter("animal");
		//복수(여러값)의 값을 받을경우에는 getParameterValues를 
		//이용하여 배열로 값을 저장
		String[] foods=req.getParameterValues("food");
		System.out.println(name);
		System.out.println(color);
		System.out.println(animal);
		System.out.print("foods : " );
		for(String t : foods)
		{
			System.out.print(t+" ");
		}
		
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html;charset=UTF-8");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>응답페이지</title>");
		out.print("</head>");
		out.print("<style>");
		out.print("h2{color:red;}");
		out.print("span.name{color:lightblue;font-weight:bold;}");
		out.print("span.color{color:lightgreen;font-weight:bold;}");
		out.print("span.animal{color:lightsalmon;font-weight:bold;}");
		out.print("span.food{color:lightcoral;font-weight:bold;}");
		out.print("</style>");
		out.print("<body>");
		out.print("<h2 style='color:red;'>개인취향테스트결과</h2>");
		out.print("<span class='name'>"+name+"</span>님의 취향은");
		out.print("<span class='color'>"+color+"</span>색을 좋아하고,");
		out.print("<span class='animal'>"+animal+"</span>을 좋아합니다.");
		String foodsum="";
		for(String t : foods)
		{
			foodsum+=t+" ";
		}
		out.print("좋아하는 음식은<span class='food'>"+foodsum
					+"</span>입니다");
		out.print("</body>");
		out.print("</html>");
	}

	
	
}
