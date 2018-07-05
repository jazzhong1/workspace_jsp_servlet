package com.hong.mybatis.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hong.mybatis.model.service.StudentService;
import com.hong.mybatis.model.service.StudentServiceImpl;
import com.hong.mybatis.model.vo.Student;

/**
 * Servlet implementation class StudentListServlet
 */
@WebServlet("/studentList.do")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListServlet() {
    	service=new StudentServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> list=service.selectList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/student/studentList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
