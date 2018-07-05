package com.hong.mybatis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.hong.mybatis.model.service.StudentService;
import com.hong.mybatis.model.service.StudentServiceImpl;

import jdk.nashorn.api.scripting.JSObject;

/**
 * Servlet implementation class StudentDeleteEndServlet
 */
@WebServlet("/studentDeleteEnd.do")
public class StudentDeleteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteEndServlet() {
    	service=new StudentServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no=Integer.parseInt(request.getParameter("no"));
		int result=service.deleteStudent(no);
		JSONObject obj= new JSONObject();
		
		if(result>0){
			obj.put("msg", "삭제성공");
		}
		else {
			obj.put("msg", "삭제실패");
		}
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(obj);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
