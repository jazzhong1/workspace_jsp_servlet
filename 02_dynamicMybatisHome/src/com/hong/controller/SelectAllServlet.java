package com.hong.controller;

import java.io.IOException;
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
 * Servlet implementation class SelectAllServlet
 */
@WebServlet(urlPatterns = { "/selectAll.do" })
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService service;
	
	public SelectAllServlet() {
		service=new EmpServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, String>>list=service.selectAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/emp/selectAll.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
