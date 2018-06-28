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
 * Servlet implementation class StudentInputServlet
 */
@WebServlet("/studentEnrollEnd.do")
public class StudentEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MybatisService mybatisService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentEnrollEndServlet() {
    	mybatisService=new MybatisServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentName=request.getParameter("studentName");
		String studentTel=request.getParameter("studentTel");
		String studentEmail=request.getParameter("studentEmail");
		String studentAddr=request.getParameter("studentAddr");
		
		Student student=new Student(studentName,studentTel,studentEmail,studentAddr);
		
		int result=mybatisService.insertStudent(student);
		
		String msg=result>0?"입력성공":"입력실패";
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append(request.getContextPath())
		.append("<br>"+msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
