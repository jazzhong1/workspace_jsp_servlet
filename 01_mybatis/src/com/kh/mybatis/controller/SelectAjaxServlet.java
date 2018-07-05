package com.kh.mybatis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.service.MybatisServiceImpl;
import com.kh.mybatis.model.vo.Student;

/**
 * Servlet implementation class SelectAjaxServlet
 */
@WebServlet("/selectAjax.do")
public class SelectAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MybatisService mybatisService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAjaxServlet() {
    	mybatisService=new MybatisServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int no=Integer.parseInt(request.getParameter("no"));
		System.out.println("학생번호"+no);
		
		Student student=mybatisService.selectOne(no);
		response.setContentType("application/json;charset=UTF-8");
		new Gson().toJson(student,response.getWriter());
		
		
		
		
		/*response.setContentType("application/json;charset=UTF-8");
		PrintWriter out	=response.getWriter();
		List<Student> list=new ArrayList();
		list.add(student);
		new Gson().toJson(list,response.getWriter());
*/	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
