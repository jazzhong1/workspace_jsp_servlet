package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

@WebServlet("/noticeUpdate")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int notice_no=Integer.parseInt(request.getParameter("no"));
		Notice notice=new NoticeService().selectOne(notice_no);
//		System.out.println("notice: "+notice);
		
		String view="";
		if(notice!=null){
			view="/views/notice/noticeUpdate.jsp";
			request.setAttribute("notice", notice);
		}
		else {
			view="/views/common/msg.jsp";
			request.setAttribute("msg", "조회할수없습니다.[관리자에게문의하세요]");
			request.setAttribute("loc", "/views/notice/noticeView.jsp");
		}
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
