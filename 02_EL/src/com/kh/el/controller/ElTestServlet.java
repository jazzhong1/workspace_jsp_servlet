package com.kh.el.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.el.model.vo.Person;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Servlet implementation class ElTestServlet
 */
@WebServlet("/eltest.do")
public class ElTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ElTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("player", "호나우딩요");
		request.setAttribute("age", "40");
		request.setAttribute("position", "MF");
		request.getSession().setAttribute("player", "메시");
		
		ArrayList<String> items=new ArrayList<>();
		items.add("축구화");
		items.add("정강이보호대");
		items.add("유니폼");
		
		
		request.setAttribute("person", new Person("홍성진", 26, "경기도구리시"));
		request.setAttribute("items", items);
		
		
		
		request.getRequestDispatcher("/views/elParam.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
