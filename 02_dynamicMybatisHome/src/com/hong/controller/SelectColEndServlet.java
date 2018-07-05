package com.hong.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hong.model.service.EmpService;
import com.hong.model.service.EmpServiceImpl;

/**
 * Servlet implementation class SelectColEndServlet
 */
@WebServlet("/selectColEnd.do")
public class SelectColEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectColEndServlet() {
    	service=new EmpServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType=request.getParameter("searchType");
		String keyword=request.getParameter("keyword");
		String gender=request.getParameter("gender");
		Map<String, String> map=new HashMap<>();
		map.put("searchType", searchType);
		map.put("gender", gender);
		map.put("keyword", keyword);
		
		List<Map<String, String>> list=service.selectCol(map);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/emp/selectCol.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
