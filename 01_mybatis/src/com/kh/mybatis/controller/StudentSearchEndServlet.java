package com.kh.mybatis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.service.MybatisServiceImpl;
import com.kh.mybatis.model.vo.Student;

/**
 * Servlet implementation class StudentSearchEndServlet
 */
@WebServlet("/studentSelectOne.do")
public class StudentSearchEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MybatisService mybatisService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSearchEndServlet() {
    	mybatisService=new MybatisServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no=Integer.parseInt(request.getParameter("no"));
		Student student=mybatisService.selectOne(no);
		int cnt=mybatisService.selectCount();
		System.out.println(student);
		request.setAttribute("student", student);
		request.setAttribute("cnt", cnt);
		request.getRequestDispatcher("/WEB-INF/views/student/searchList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
