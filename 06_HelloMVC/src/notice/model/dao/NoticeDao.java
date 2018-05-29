package notice.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import member.model.dao.MemberDao;
import notice.model.vo.Notice;
import static common.JDBCTemplate.*;

public class NoticeDao {
	private PreparedStatement pstmt;
	private Properties prop;
	private String fileName;

	public NoticeDao() {
		pstmt = null;
		prop = new Properties();

		try {
			fileName = NoticeDao.class.getResource("/sql/notice/notice-query.properties").getPath();
			// SQL command not properly ended 구문오류
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Notice> selectList(Connection conn) {
		ResultSet rs=null;
		List<Notice> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectList"));
			rs=pstmt.executeQuery();
			while (rs.next()) {
				Notice notice=new Notice();
				notice.setNotice_no(rs.getInt("notice_no"));
				notice.setNotice_title(rs.getString("notice_title"));
				notice.setNotice_writer(rs.getString("notice_writer"));
				notice.setNotice_content(rs.getString("notice_content"));
				notice.setNotice_date(rs.getDate("notice_date"));
				notice.setFilePath(rs.getString("filepath"));
				notice.setStatus(rs.getString("status"));
				list.add(notice);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;

	}

	public Notice selectOne(Connection conn, int no) {
		ResultSet rs=null;
		Notice notice=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectOne"));
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()){
				notice=new Notice();
				notice.setNotice_no(rs.getInt("notice_no"));
				notice.setNotice_title(rs.getString("notice_title"));
				notice.setNotice_writer(rs.getString("notice_writer"));
				notice.setNotice_content(rs.getString("notice_content"));
				notice.setNotice_date(rs.getDate("notice_date"));
				notice.setFilePath(rs.getString("filepath"));
				notice.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return notice;
	}

	
	public int updateNotice(Connection conn, Notice notice) {
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateNotice"));
			pstmt.setString(1, notice.getNotice_title());
			pstmt.setString(2, notice.getNotice_writer());
			pstmt.setString(3, notice.getNotice_content());
			pstmt.setString(4, notice.getFilePath());
			pstmt.setInt(5, notice.getNotice_no());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertNotice(Connection conn, Notice n) {
		int result=0;
		//1:title,writer,content,filepath=null
		//NO는 시퀀스 STATUS,DATE는 DEFAULT로 제약조건을 걸어노핬따.
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertNotice"));
			pstmt.setString(1, n.getNotice_title());
			pstmt.setString(2, n.getNotice_writer());
			pstmt.setString(3, n.getNotice_content());
			pstmt.setString(4, n.getFilePath());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	
	public int deleteNotice(Connection conn, int notice_no) {
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteNotice"));
			pstmt.setInt(1, notice_no);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}
