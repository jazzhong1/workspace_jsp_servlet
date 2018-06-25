package photo.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import admin.model.dao.AdminDao;
import board.model.dao.BoardDao;
import board.model.vo.Board;
import photo.model.dao.PhotoDAO;
import photo.model.vo.Photo;

public class PhotoService {

	public int insertPhoto(Photo p) {
		Connection conn = getConnection();
		int result = new PhotoDAO().insertPhoto(conn, p);
		if(result>0){
			commit(conn);
			//마지막에 추가한 시퀀스번호 가져오기
			//result = new PhotoDAO().selectLastSeq(conn);
		}
		else 
			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int selectPhotoCount() {
		Connection conn = getConnection();
		int total = new PhotoDAO().selectPhotoCount(conn);
		close(conn);
		return total;
	}

	public List<Photo> selectPhotoMore(int start, int len) {
		Connection conn = getConnection();
		List<Photo> list= new PhotoDAO().selectPhotoMore(conn, start, len);
		close(conn);
		return list;
	}

}
