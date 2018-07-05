package com.kh.mybatis.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.dao.MybatisDAO;
import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.service.MybatisServiceImpl;
import com.kh.mybatis.model.vo.Student;

/**
 * Servlet implementation class StudentListServlet
 */
@WebServlet("/studentList.do")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MybatisService mybatisService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListServlet() {
    	mybatisService=new MybatisServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> list=new ArrayList<>();
		list=mybatisService.selectList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/student/searchList2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
