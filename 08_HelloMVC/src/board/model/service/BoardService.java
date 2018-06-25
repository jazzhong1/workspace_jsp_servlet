package board.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import board.model.dao.BoardDao;
import board.model.vo.Board;
import board.model.vo.BoardComment;

public class BoardService {

	public List<Board> selectList(int cPage, int numPerPage)
	{
		Connection conn=getConnection();
		List<Board> list=new BoardDao().selectList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	public int selectCount()
	{
		Connection conn=getConnection();
		int result=new BoardDao().selectCount(conn);
		close(conn);
		return result;
	}
	
	public Board selectOne(int no)
	{
		Connection conn=getConnection();
		Board b=new BoardDao().selectOne(conn,no);
		close(conn);
		return b;
	}
	
	public void incrementCount(int no)
	{
		Connection conn=getConnection();
		int result=new BoardDao().incrementCount(conn,no);
		if(result>0)
		{
			commit(conn);
		}
		else
		{
			rollback(conn);
		}
		close(conn);
	}
	
	public int insertBoard(Board b)
	{
		Connection conn=getConnection();
		int result=new BoardDao().insertBoard(conn,b);
		if(result>0)
		{
			commit(conn);
		}
		else
		{
			rollback(conn);
		}
		close(conn);
		
		return result;		
	}
	
	public int insertComment(BoardComment bc)
	{
		Connection conn=getConnection();
		int result=new BoardDao().insertComment(conn,bc);
		if(result>0)
		{
			commit(conn);
		}
		else
		{
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	public List<BoardComment> selectComment(int no)
	{
		Connection conn=getConnection();
		List<BoardComment> list=new BoardDao().selectComment(conn,no);
		close(conn);
		return list;
	}
	
}










