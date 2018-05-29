package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.server.Dispatcher;


/**
 * Servlet implementation class MemberOrder
 */
@WebServlet("/menuOrder.do")
public class MemberOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MemberOrder() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String main_menu=request.getParameter("main_menu");
		String side_menu=request.getParameter("side_menu");
		String drink_menu=request.getParameter("drink_menu");
		
		HashMap<String, Integer> map=new HashMap<>();
		
		map.put("한우버거", 5000);
		map.put("밥버거", 4500);
		map.put("치즈버거", 4000);
		map.put("감자튀김", 1500);
		map.put("어니언링", 1700);
		map.put("콜라", 1000);
		map.put("커피", 1000);
		map.put("밀크쉐이크", 1000);
		
		int price=0;
		
		Iterator<String> iterator=map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			if(key.equals(main_menu)){
				price+=map.get(main_menu);
			}
			else if(key.equals(side_menu)){
				price+=map.get(side_menu);
			}
			else if(key.equals(drink_menu)){
				price+=map.get(drink_menu);
			}
		}
		request.setAttribute("main_menu", main_menu);
		request.setAttribute("side_menu", side_menu);
		request.setAttribute("drink_menu", drink_menu);
		request.setAttribute("price", price);
		RequestDispatcher rs=request.getRequestDispatcher("view.jsp");
		rs.forward(request, response);
		
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
