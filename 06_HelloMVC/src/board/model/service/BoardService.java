package board.model.service;

import java.sql.Connection;
import java.util.List;

import board.model.dao.BoardDao;
import board.model.vo.Board;
import board.model.vo.BoardComment;

import static common.JDBCTemplate.*;
public class BoardService {
	private Connection conn;
	
	public BoardService() {
		conn=getConnection();
	}

	public List<Board> selectList(int cPage, int numPerPage) {
		List<Board> list=new BoardDao().selectList(conn,cPage,numPerPage);
		System.out.println(list);
		close(conn);
		return list;
	}

	public int selectCount() {
		int cnt=0;
		cnt=new BoardDao().selectCount(conn);
		close(conn);
		return cnt;
	}

	public Board selectOne(int board_no) {
		Board board=new BoardDao().selectOne(conn,board_no);
		close(conn);
		return board;
	}

	public int incrementCount(int board_no) {
		int result=new BoardDao().incrementCount(conn,board_no);
		if(result>0){
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
		
		
	}

	public int insertBoard(Board b) {
		int result=new BoardDao().insertBoard(conn,b);
		if(result>0){
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int insertBoardComment(BoardComment bc) {
		int result=new BoardDao().insertBoardComment(conn,bc);
		if(result>0){
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public List<BoardComment> selectCommentList(int board_no) {
		List<BoardComment> list=new BoardDao().selectCommentList(conn,board_no);
		close(conn);
		return list;
	}
}
