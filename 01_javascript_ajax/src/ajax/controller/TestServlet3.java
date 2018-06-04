package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ajax.model.vo.User;


/**
 * Servlet implementation class TestServlet3
 */
@WebServlet("/test3.do")
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list=new ArrayList();
		//ajax용 service를 만들던지, jsp를 따로만들던지 해야한다.
		list.add(new User("박보검","010-1234-1234","parkBogum.jpg"));
		list.add(new User("멧데이먼","010-1234-1234","mattDamon.jpg"));
		list.add(new User("줄리아로버츠","010-1234-1234","juliaRoberts.jpg"));
		
		String csv="";
		for (int i = 0; i < list.size(); i++) {
			if(i!=0)csv+="\n";	//한번거르고 넣기
			csv+=list.get(i);
		
		}	
		System.out.println(csv);
		response.setContentType("text/csv;charset=UTF-8");
		PrintWriter out =response.getWriter();
		out.append(csv);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
