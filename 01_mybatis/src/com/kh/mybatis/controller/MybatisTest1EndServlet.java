package com.kh.mybatis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.service.MybatisServiceImpl;

/**
 * Servlet implementation class MybatisTest1EndServlet
 */
@WebServlet("/mybatisTest1End.do")
public class MybatisTest1EndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MybatisService service=new MybatisServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisTest1EndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("studentName");
		int result=service.insertName(name);
	String test=result>0?"테스트성공(입력!)":"테스트실패!(입력실패)";
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("served at ")
				.append(request.getContextPath())
				.append("<br>"+test);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
