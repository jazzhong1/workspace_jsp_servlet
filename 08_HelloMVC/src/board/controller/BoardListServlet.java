package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import board.model.service.BoardService;
import board.model.vo.Board;


@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardListServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징 처리
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}
		catch(NumberFormatException e)
		{
			cPage=1;
		}
		int numPerPage;
		try {
			numPerPage=Integer.parseInt(request.getParameter("numPerPage"));
		}
		catch(NumberFormatException e)
		{
			numPerPage=10;
		}
		
		List<Board> list=new BoardService().selectList(cPage,numPerPage);
		int totalMember=new BoardService().selectCount();
		int totalPage=(int)Math.ceil((double)totalMember/numPerPage);
		
		String pageBar="";
		//페이지 바의 표현될 페이지 개수
		int pageBarSize=3;
		//페이지 바의 시작번호 설정
		//cPage 1~5사이의 숫자 : 1
		//cPage 6~10사이의 숫자 : 6
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		//페이지 바의 종료번호 설정
		int pageEnd=pageNo+pageBarSize-1;
		
		//페이지바에 들어갈 html구문 작성
		//이전버튼 만들기
		if(pageNo==1)
		{
			pageBar+="<span>[이전]</span>";
		}
		else
		{
			pageBar+="<a href='"+request.getContextPath()+"/boardList?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'>[이전]</a>";
		}
		//중간에 들어가는 페이지 버튼(1~5/6~10/...)만들기
		//while(pageNo<pageEnd && pageNo<=totalPage)
		while(!(pageNo>pageEnd||pageNo>totalPage))
		{
			if(cPage==pageNo)
			{
				pageBar+="<span class='cPage'>"+pageNo+"</span>";
			}
			else
			{
				pageBar+="<a href='"+request.getContextPath()+"/boardList?cPage="+pageNo+"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		//[다음]버튼 만들기
		if(pageNo>totalPage)
		{
			pageBar+="<span>[다음]</span>";
		}
		else
		{
			pageBar+="<a href='"+request.getContextPath()+"/boardList?cPage="+pageNo+"&numPerPage="+numPerPage+"'>[다음]</a>";
		}
		
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("board", list);
		request.getRequestDispatcher("/views/board/boardList.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
