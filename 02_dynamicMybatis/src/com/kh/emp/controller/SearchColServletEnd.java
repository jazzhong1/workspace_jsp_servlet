package com.kh.emp.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import org.apache.ibatis.ognl.MapPropertyAccessor;

import com.kh.emp.service.EmpService;
import com.kh.emp.service.EmpServiceImpl;

/**
 * Servlet implementation class SearchColServlet
 */
@WebServlet("/searchColEnd.kh")
public class SearchColServletEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService service;
       
    public SearchColServletEnd() {
    	service=new EmpServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType=request.getParameter("searchType");
		String keyword=request.getParameter("keyword");
		String gender=request.getParameter("gender");
		String salary=request.getParameter("salary");
		String hire_date=request.getParameter("hire_date");
		String[] job_code=request.getParameterValues("job_code");
		
		String flag1=request.getParameter("salary_le_ge");
		String flag2=request.getParameter("hire_date_le_ge");
		
		Map<String, String> map=new HashMap<>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		map.put("gender", gender);
		map.put("salary", salary);
		map.put("hire_date", hire_date);
		//Date도 형변환 바로 해줌
		map.put("salary_le_ge", flag1);
		map.put("hire_date_le_ge", flag2);
		
		Map<String, String[]> map1=new HashMap<>();
		map1.put("job_code", job_code);

		List<Map<String, String>> list=service.searchCol(map);
		List<Map<String, String>> list1=service.searchArr(map1);

		request.setAttribute("list", list1);
		request.getRequestDispatcher("/WEB-INF/views/emp/search1.jsp").forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
