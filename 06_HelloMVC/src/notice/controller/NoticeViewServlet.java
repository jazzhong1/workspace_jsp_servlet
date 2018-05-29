package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeViewServlet
 */
@WebServlet("/noticeView")
public class NoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no=Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
		Notice n=new NoticeService().selectOne(no);
		System.out.println(n);
		
		String view="";
		if(n!=null){
			request.setAttribute("notice", n);
			view="/views/notice/noticeView.jsp";
			//정상적인view테이블이면 옮긴다는뜻.
		}
		else{
			view="common/msg.jsp";
			request.setAttribute("msg", "조회한 공지사항을 찾을수 없습니다.");
			request.setAttribute("loc", "/noticeList");
			//무조건 jsp->servlet으로 고쳐야한다.
			
		}
		
		
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
