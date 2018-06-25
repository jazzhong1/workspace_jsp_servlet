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
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		Notice n=new NoticeService().selectOne(no);
		
		String view="";
		if(n!=null)
		{
			request.setAttribute("notice", n);
			view="/views/notice/noticeUpdate.jsp";
		}
		else
		{
			view="/views/common/msg.jsp";
			request.setAttribute("msg", "게시물을 찾을수 없습니다.");
			request.setAttribute("loc","/noticeList");
		}
		request.getRequestDispatcher(view).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
