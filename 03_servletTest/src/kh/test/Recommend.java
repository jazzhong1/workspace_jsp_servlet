package kh.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Recommend extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//client가 입력한 값을 가져오는 것
		String name=req.getParameter("name");
		String color=req.getParameter("color");
		//
		//추천할 여행지 세팅!
		String recom="";
		switch(color)
		{
			case "파랑" : recom="해변으로 가요~~"; break;
			case "빨강" : recom="계곡으로 가요~~"; break;
			case "노랑" : recom="산으로 가요~~"; break;
			case "초록" : recom="수목원으로 가요~~"; break;
		}
		//
		//사용자 응답 페이지 작성
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
		out.print("<h2 style='color:red;'>여행지 추천결과</h2>");
		out.print("<span class='name'>"+name+"</span>님의 취향은");
		out.print("<span class='color'>"+color+"</span>색을 좋아하고,");
		out.print("추천하는 여행지는 <span class='food'>"+recom
					+"</span>입니다");
		out.print("</body>");
		out.print("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		doGet(req, resp);
		//다시 doGet메소드 호출 
	}

	
	
	
}
