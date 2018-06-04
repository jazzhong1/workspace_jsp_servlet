package ajax.controller;

import java.io.IOException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ajax.User;

/**
 * Servlet implementation class HtmlAjaxServlet
 */
@WebServlet("/test1.do")
public class HtmlAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HtmlAjaxServlet() {
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
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jquery_Ajax/sample1.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
