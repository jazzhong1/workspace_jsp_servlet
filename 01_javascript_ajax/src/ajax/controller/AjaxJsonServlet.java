package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.NEW;

import ajax.model.vo.User;
import oracle.net.aso.p;


/**
 * Servlet implementation class AjaxJsonServlet
 */
@WebServlet("/ajaxjson")
public class AjaxJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxJsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//json객체받기
		request.setCharacterEncoding("UTF-8");
		//받아올떄안꺠지기위해
		//ajax에서 매핑하기떄문에 가져올수있따.
		String userId=request.getParameter("userId");
		String userPhone=request.getParameter("userPhone");
		String userProfile=request.getParameter("userProfile");
		
		System.out.println(userId+userPhone+userProfile);
		
		
		//1.json으로 값넘기기
		//객체로 mpa을 상속받아 구현되면 key:valu방식으로 저장
		//map 이랑 사용이 비슷함.
	/*	JSONObject jsobj=new JSONObject();
		jsobj.put("name", "홍성진");
		jsobj.put("age", 19);
		jsobj.put("hight", 171);
		jsobj.put("weight", 67);
		jsobj.put("phone", 1234555);*/
//		jsobj.put("user", new User("hong","홍성진","하하"));	객체로보낼수없다.
		//JSONObject는 값으로 객체를 받을수 없음.
		
		response.setContentType("application/json;charset=UTF-8");
		//json보낼떄는 setContentType이 "application/json;charset=UTF-8" 인자값을 넣어줘야한다.
		
		PrintWriter out	=response.getWriter();
//		out.print(jsobj);
		//객체의 자료를 보내기위해서는 JSONArray(==List)를 활용
//		JSONArray jsonArray=new JSONArray();
		List<User> list=new ArrayList();
		list.add(new User("hong","010123125","구리시프로필"));
		list.add(new User("jung","010123125","서울시프로필"));
		list.add(new User(userId,userPhone,userPhone));
	
	/*	for(User u:list){
			JSONObject temp=new JSONObject();
			temp.put("id", u.getName());
			temp.put("name", u.getName());
			temp.put("addr", u.getProfile());
			jsonArray.add(temp);
		}
		System.out.println(jsonArray);
		out.print(jsonArray);*/
		
		
		
		//Gson방식
		new Gson().toJson(list,response.getWriter());
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
