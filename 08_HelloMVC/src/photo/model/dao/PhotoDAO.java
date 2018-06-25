package photo.model.dao;

import static common.JDBCTemplate.close;

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

import photo.model.vo.Photo;

public class PhotoDAO {
	private Properties prop = new Properties();

	public PhotoDAO() {
		try {
			String fileName = PhotoDAO.class.getResource("/sql/photo/photo-query.properties").getPath();
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public int insertPhoto(Connection conn, Photo p) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertPhoto"); 
		
		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setString(1, p.getPhotoWriter());
			pstmt.setString(2, p.getPhotoContent());
			pstmt.setString(3, p.getOriginalFileName());
			pstmt.setString(4, p.getRenamedFileName());
			
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int selectPhotoCount(Connection conn) {
		PreparedStatement pstmt = null;
		int total = 0;
		ResultSet rset = null;
		String query = prop.getProperty("selectPhotoCount");
		
		try{
			//미완성쿼리문을 가지고 객체생성. 
			pstmt = conn.prepareStatement(query);
			
			//쿼리문실행
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				total = rset.getInt("cnt");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return total;
	}

	public List<Photo> selectPhotoMore(Connection conn, int start, int len) {
		List<Photo> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectPhotoMore");
		
		try{
			//미완성쿼리문을 가지고 객체생성. 
			pstmt = conn.prepareStatement(query);
			
			//시작 rownum과 마지막 rownum 구하는 공식
			pstmt.setInt(1, start);
			pstmt.setInt(2, start+len-1);
			
			//쿼리문실행
			//완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			rset = pstmt.executeQuery();
			while(rset.next()){
				Photo p = new Photo();
				//컬럼명은 대소문자 구분이 없다.
				p.setPhotoNo(rset.getInt("photo_no"));
				p.setPhotoWriter(rset.getString("photo_writer"));
				p.setPhotoContent(rset.getString("photo_content"));
				p.setOriginalFileName(rset.getString("photo_original_filename"));
				p.setRenamedFileName(rset.getString("photo_renamed_filename"));
				p.setPhotoDate(rset.getDate("photo_date"));
				p.setReadCount(rset.getInt("photo_readcount"));
				list.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	
}
