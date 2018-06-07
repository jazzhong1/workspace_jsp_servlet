package truck;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TruckChoiceServlet
 */
@WebServlet("/truckChoice")
public class TruckChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruckChoiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String truckPk=request.getParameter("choice");
			//service~dao다녀와서 
			//관련테이블 객체가져와서 
			
			System.out.println(truckPk);
			String view="";
			if(truckPk.equals("메뉴")){
				//객체같이 보내기
				view="/views/truck/truckChoiceMenu.jsp";
			}
			else if(truckPk.equals("리뷰")){
				//객체같이 보내기

				view="/views/truck/truckChoiceReview.jsp";
			}
			else {
				//객체같이 보내기

				view="/views/truck/truckChoiceEvent.jsp";
			}
			
			//속성보낼꺼 포함해서보냄~
			request.getRequestDispatcher(view).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
