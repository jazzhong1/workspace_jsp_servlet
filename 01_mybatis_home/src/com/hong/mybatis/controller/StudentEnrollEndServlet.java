package com.hong.mybatis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hong.mybatis.model.service.StudentService;
import com.hong.mybatis.model.service.StudentServiceImpl;
import com.hong.mybatis.model.vo.Student;


/**
 * Servlet implementation class StudentEnrollServlet
 */
@WebServlet("/studentEnrollEnd.do")
public class StudentEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentEnrollEndServlet() {
    	service=new StudentServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String flag=request.getParameter("flag");
		
		
		String studentName=request.getParameter("studentName");
		String studentTel=request.getParameter("studentTel");
		String studentEmail=request.getParameter("studentEmail");
		String studentAddr=request.getParameter("studentAddr");
		
		
		int result=0;
		if (flag.equals("0")){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("studentName", studentName);
			map.put("studentTel", studentTel);
			map.put("studentEmail", studentEmail);
			map.put("studentAddr", studentAddr);
			result=service.insertStudent(map);
			request.setAttribute("map", map);
		}
		else if(flag.equals("1")){
			Map<String, Object> map=new HashMap<String,Object>();
			Student student=new Student(studentName,studentTel,studentEmail,studentAddr);
			map.put("student", student);
			result=service.insertStudent(map);
			request.setAttribute("map", map);
		}
		else{
			Student student=new Student(studentName,studentTel,studentEmail,studentAddr);
			result=service.insertStudent(student);
		}
		
		String msg=result>0?"삽입성공":"실패";
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append(request.getContextPath()).append("<br>"+msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
