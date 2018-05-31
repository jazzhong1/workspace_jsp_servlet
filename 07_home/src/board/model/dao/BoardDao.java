package board.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import board.model.vo.Board;
import notice.model.vo.Notice;
import static common.JDBCTemplate.*;

public class BoardDao {
	private PreparedStatement pstmt;
	private Properties prop;
	private String fileName;
	public BoardDao() {
		prop=new Properties();
		fileName=Notice.class.getResource("/sql/board/board-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int selectCount(Connection conn) {
		int cnt=0;
		ResultSet rs=null;
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

	public ArrayList<Board> selectBoardList(Connection conn, int cPage, int numPerPage) {
		ArrayList<Board> list=new ArrayList();
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectList"));
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			//numPerPage증감 감소없이 고정이다 jsp에서 입력받은 3,5,10단위로 떨어진다 즉 row갯수.
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
