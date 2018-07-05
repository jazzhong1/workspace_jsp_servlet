package com.kh.emp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.emp.service.EmpService;
import com.kh.emp.service.EmpServiceImpl;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/page.kh")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
    	service=new EmpServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage;
		int numPerPage=5;
		
		try {
			cPage=Integer.parseInt((String)request.getParameter("cPage"));
		} catch (Exception e) {
			cPage=1;
		}
	
 
		List<Map<String, String>> list=service.selectEmpList(cPage,numPerPage);
		int total=service.selectCount();
		int totalPage=(int)Math.ceil((double)total/numPerPage);
		int pageBarSize=5;
		System.out.println("numPerPage"+numPerPage);
		
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		String pageBar="";
		
		pageBar += "<ul class='pagination justify-content-center pagination-sm'>";
		//[이전]section
		if(pageNo == 1 ){
			pageBar += "<li class='page-item disabled'>";
			pageBar += "<a class='page-link' href='#' tabindex='-1'>이전</a>";
			pageBar += "</li>";
		}
		else {
			pageBar += "<li class='page-item'>";
			pageBar += "<a class='page-link' href='javascript:void(0);' onclick='fn_paging("+(pageNo-1)+")'>이전</a>";
			pageBar += "</li>";
		}
		
		// pageNo section
		while(!(pageNo>pageEnd || pageNo > total)){
			if(cPage == pageNo ){
				pageBar += "<li class='page-item active'>";
				pageBar += "<a class='page-link'>"+pageNo+"</a>";
				pageBar += "</li>";
			} 
			else {
				pageBar += "<li class='page-item'>";
				pageBar += "<a class='page-link' href='javascript:void(0);' onclick='fn_paging("+pageNo+")'>"+pageNo+"</a>";
				pageBar += "</li>";
			}
			pageNo++;
		}
		System.out.println(pageNo);
		System.out.println(total);
		
		//[다음] section
		if(pageNo > totalPage){
			pageBar += "<li class='page-item disabled'>";
			pageBar += "<a class='page-link' href='#'>다음</a>";
			pageBar += "</li>";
			
		} else {
			pageBar += "<li class='page-item'>";
			pageBar += "<a class='page-link' href='javascript:void(0);' onclick='fn_paging("+pageNo+")'>다음</a> ";
			pageBar += "</li>";
		}
		
		pageBar += "</ul>";
		
		//2.스크립트 태그 작성
		//fn_paging함수
		pageBar += "<script>";
		pageBar += "function fn_paging(cPage){";
		pageBar += "location.href='"+request.getRequestURI()+"?cPage='+cPage";
		pageBar += "}";
		pageBar += "</script>";
		
		request.setAttribute("list", list);
		System.out.println(list);
		request.setAttribute("pageBar", pageBar);		
		request.getRequestDispatcher("/WEB-INF/views/emp/empPage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
