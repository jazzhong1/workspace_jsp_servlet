package board.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import board.model.dao.BoardDao;
import board.model.vo.Board;
import member.model.vo.Member;

import static common.JDBCTemplate.*;

public class BoardService {
	private Connection conn;

	public BoardService() {
		conn=getConnection();
	}
	


	public int selectCount() {
		int cnt=new BoardDao().selectCount(conn);
		close(conn);
		// TODO Auto-generated method stub
		return cnt;
	}


	public ArrayList<Board> selectBoardList(int cPage, int numPerPage) {
		ArrayList<Board> list=new BoardDao().selectBoardList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}



	public Board selectOne(int no) {
		Board board=new BoardDao().selectOne(conn,no);
		close(conn);
		return board;
	}



	public void incrementCount(int no) {
		new BoardDao().incrementCount(conn,no);	
		close(conn);

	}



	public int insertBoard(Board b) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
