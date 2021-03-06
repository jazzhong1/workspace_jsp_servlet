package notice.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import notice.model.vo.Notice;
import static common.JDBCTemplate.*;

public class NoticeDao {
	private PreparedStatement pstmt;
	private Properties prop;
	private String fileName;
	public NoticeDao() {
		prop=new Properties();
		fileName=Notice.class.getResource("/sql/notice/notice-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public List<Notice> selectList(Connection conn, int cPage, int numPerPage) {
		ResultSet rs=null;
		List<Notice>list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberList"));
			pstmt.setInt(1, ((cPage-1)*numPerPage+1));
			pstmt.setInt(2, cPage * numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()){
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
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
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
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return cnt;
	}


	public Notice selectOne(Connection conn, int no) {
		ResultSet rs=null;
		Notice notice=null;
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectOne"));
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
			notice=new Notice();
			notice.setNotice_no(rs.getInt("notice_no"));
			notice.setNotice_title(rs.getString("notice_title"));
			notice.setNotice_writer(rs.getString("notice_writer"));
			notice.setNotice_content(rs.getString("notice_content"));
			notice.setNotice_date(rs.getDate("notice_date"));
			notice.setFilePath(rs.getString("filepath"));
			notice.setStatus(rs.getString("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return notice;
	}


	public int insertNotice(Connection conn, Notice n) {
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertNotice"));
			pstmt.setString(1, n.getNotice_title());
			pstmt.setString(2, n.getNotice_writer());
			pstmt.setString(3, n.getNotice_content());
			pstmt.setString(4, n.getFilePath());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int updateNotice(Connection conn, Notice n) {
//updateNotice=UPDATE NOTICE SET NOTICE_TITLE=?,NOTICE_WRITER=?,NOTICE_CONTENT=?,NOTICE_DATE=SYSDATE,FILEPATH=?,STATUS=DEFAULT WHERE NOTICE_NO=?
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateNotice"));
			pstmt.setString(1, n.getNotice_title());
			pstmt.setString(2, n.getNotice_writer());
			pstmt.setString(3, n.getNotice_content());
			pstmt.setString(4, n.getFilePath());
			pstmt.setInt(5, n.getNotice_no());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int deleteNotice(Connection conn, int no) {
		int result=0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteNotice"));
			pstmt.setInt(1, no);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}
