package board.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.catalina.connector.Request;

import board.model.vo.Board;
import board.model.vo.BoardComment;

import static common.JDBCTemplate.*;

public class BoardDao {
	private PreparedStatement pstmt;
	private String fileName;
	private Properties prop;
	
	public BoardDao() {
		fileName=BoardDao.class.getResource("/sql/board/board-query.properties").getPath();
		
		prop=new Properties();
		try {
			prop.load(new FileReader(fileName));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<Board> selectList(Connection conn ,int cPage, int numPerPage) {
		ResultSet rs=null;
		List<Board>list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectList"));
			pstmt.setInt(1, ((cPage - 1) * numPerPage + 1));
			pstmt.setInt(2, cPage * numPerPage);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				Board board=new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setBoardTitle(rs.getString("board_title"));
				board.setBoardWriter(rs.getString("board_writer"));
				board.setBoardContent(rs.getString("board_content"));
				board.setBoardOriginalFileName(rs.getString("board_original_filename"));
				board.setBoardRenameFileName(rs.getString("board_renamed_filename"));
				board.setBoardDate(rs.getDate("board_date"));
				board.setBoardReadCount(rs.getInt("board_readcount"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int selectCount(Connection conn) {
		ResultSet rs=null;
		int cnt=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectCount"));
			rs=pstmt.executeQuery();
			if(rs.next()){
				cnt=rs.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return cnt;
	}

	public Board selectOne(Connection conn, int board_no) {
		
		Board board=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectOne"));
			pstmt.setInt(1, board_no);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				board=new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setBoardTitle(rs.getString("board_title"));
				board.setBoardWriter(rs.getString("board_writer"));
				board.setBoardContent(rs.getString("board_content"));
				board.setBoardOriginalFileName(rs.getString("board_original_filename"));
				board.setBoardRenameFileName(rs.getString("board_renamed_filename"));
				board.setBoardDate(rs.getDate("board_date"));
				board.setBoardReadCount(rs.getInt("board_readcount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return board;
	}

	public int incrementCount(Connection conn,int board_no) {
		int result=0;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("incrementCount"));
			pstmt.setInt(1, board_no);
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
		
	}

	public int insertBoard(Connection conn, Board b) {
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertBoard"));
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardWriter());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setString(4, b.getBoardOriginalFileName());
			pstmt.setString(5, b.getBoardRenameFileName());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertBoardComment(Connection conn, BoardComment bc) {
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertBoardComment"));
			pstmt.setInt(1, bc.getBoardCommentLevel());
			pstmt.setString(2, bc.getBoardCommentWriter());
			pstmt.setString(3, bc.getBoardCommentContent());
			pstmt.setInt(4, bc.getBoardRef());
			//0으로 설정했기때문에 제약조건발쌩
			pstmt.setString(5, (bc.getBoardCommnetRef()==0?null:String.valueOf(bc.getBoardCommnetRef())));
			//댓글은 무조건 null로 들어간다.
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public List<BoardComment> selectCommentList(Connection conn, int no) {
		ResultSet rs=null;
		List<BoardComment> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectCommentList"));
			pstmt.setInt(1,no );
			rs=pstmt.executeQuery();
			while (rs.next()) {
				BoardComment boc=new BoardComment();
				boc.setBoardCommentNO(rs.getInt("board_comment_no"));
				boc.setBoardCommentLevel(rs.getInt("board_comment_level"));
				boc.setBoardCommentWriter(rs.getString("board_comment_writer"));
				boc.setBoardCommentContent(rs.getString("board_comment_content"));
				boc.setBoardRef(rs.getInt("board_ref"));
				boc.setBoardCommnetRef(rs.getInt("board_comment_ref"));
				boc.setBoardCommnetDate(rs.getDate("board_comment_date"));
				list.add(boc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

}
