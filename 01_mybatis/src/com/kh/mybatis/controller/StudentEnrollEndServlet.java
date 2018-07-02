package com.kh.mybatis.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
@WebServlet("/studentEnrollEnd.do")	// /student/studentEnrollEnd.do 가상의 경로를 만들어서 해줄수 있음.
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
		
		request.setCharacterEncoding("UTF-8");
		String flag=request.getParameter("map");
		System.out.println(flag);
		
		String studentName=request.getParameter("studentName");
		String studentTel=request.getParameter("studentTel");
		String studentEmail=request.getParameter("studentEmail");
		String studentAddr=request.getParameter("studentAddr");
		
		int result=0;
		if(flag.equals("0")){
			Student student=new Student(studentName,studentTel,studentEmail,studentAddr);
			result=mybatisService.insertStudent(student);
		}
		
		
		else if(flag.equals("1")) {
			Map<String,Object> map=new HashMap<>();
			map.put("studentName", studentName);
			map.put("studentTel", studentTel);
			map.put("studentEmail", studentEmail);
			map.put("studentAddr", studentAddr);
			result=mybatisService.insertStudent(map);
		}
		else {
			Map<String, Object> map=new HashMap<>();
			Student student=new Student(studentName,studentTel,studentEmail,studentAddr);
			map.put("student", student);
			result=mybatisService.insertStudent(map);
		}
		
		
		String msg=result>0?"입력성공":"입력실패";
		
		
		/*long date=Date.parse(request.getParameter("time"));
		System.out.println(date);
		DateFormat df = new SimpleDateFormat("HH:mm:ss"); // HH=24h, hh=12h
		 String str = df.format(today);
		  System.out.println(str);
		  
		  Date date = new Date(today);
		  System.out.println(date);*/
		
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
