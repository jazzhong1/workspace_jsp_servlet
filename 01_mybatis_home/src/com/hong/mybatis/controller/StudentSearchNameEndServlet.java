package com.hong.mybatis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hong.mybatis.model.service.StudentService;
import com.hong.mybatis.model.service.StudentServiceImpl;
import com.hong.mybatis.model.vo.Student;

/**
 * Servlet implementation class StudentSearchNameEndServlet
 */
@WebServlet("/studentSearchNameEnd.do")
public class StudentSearchNameEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSearchNameEndServlet() {
    	service=new StudentServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		List<Student> list= service.selectList(name);
		response.setContentType("application/json;charset=UTF-8");
		new Gson().toJson(list,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
