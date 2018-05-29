package kh.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestPerson1 extends HttpServlet {

	// 상속받는 순간 servlet 클래스가된다.
	// alt+shift+s+v 누르면

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// form 에있는데이터를 HttpServletReques에담아준다.
		// req 사용자가 보낸 데이터,
		// resp : 내가 응답할 주소, 대상.
		// 같이움직인다.
	
		
		String name = req.getParameter("name");
		// name으로 받아옴
		
		String color = req.getParameter("color"); // 단일 text로 받아온다.
		String animal = req.getParameter("animal");
		String[] foods = req.getParameterValues("food");

		// 복수의 값을 받을경우에는 getParameterValues를 이용
		// 이용하여 배열로 값dmf 받는다ㅏ. 저장한다
		System.out.println(name);
		System.out.println(color);
		System.out.println(animal);
		System.out.print("foods:");
		for (String t : foods) {
			System.out.println(t);
		}
		

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();	//무엇을 리턴?
		// 이러한 방식으로 보낸다는 뜻.
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
		out.print("<span class='name'>" + name + "</span>님의 취향은");
		out.print("<span class='color'>" + color + "</span>색을 좋아하고,");
		out.print("<span class='animal'>" + animal + "</span>을 좋아합니다.");
		String foodsum = "";
		for (String t : foods) {
			foodsum += t;
		}
		out.print("좋아하는 음식은<span class='food'>" + foodsum + "</span>입니다.");
		out.print("</body>");
		out.print("</html>");

		// super.doGet(req, resp); 잘 사용하진 않는다.
	}

}
