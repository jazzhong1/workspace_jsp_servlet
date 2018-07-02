package com.hong.mybatis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hong.mybatis.model.service.StudentService;
import com.hong.mybatis.model.service.StudentServiceImpl;
import com.hong.mybatis.model.vo.Student;import com.sun.crypto.provider.RSACipher;

/**
 * Servlet implementation class StudentSearchEndServlet
 */
@WebServlet("/studentSelectOne.do")
public class StudentSearchEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSearchEndServlet() {
    	studentService=new StudentServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no=request.getParameter("no");
		System.out.println(no);
		Student student=studentService.selectOne(no);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/WEB-INF/views/student/studentView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
