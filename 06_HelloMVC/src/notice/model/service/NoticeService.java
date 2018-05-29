package notice.model.service;

import java.sql.Connection;
import java.util.List;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;

import static common.JDBCTemplate.*;

public class NoticeService {
	private Connection conn;
	
	public NoticeService() {
		conn=getConnection();
	}

	public List<Notice> selectList() {
		List<Notice> list=new NoticeDao().selectList(conn);
//		System.out.println(list);
		close(conn);
		return list;
	}

	public Notice selectOne(int no) {
		Notice notice=new NoticeDao().selectOne(conn,no);
		System.out.println("filePath:"+notice.getFilePath());
		close(conn);
		return notice;
	}

	public int updateNotice(Notice notice) {
		int result=new NoticeDao().updateNotice(conn,notice);
		if(result>0){
			commit(conn);
		}
		else{
			rollback(conn);
		}
		return result;
	}

	public int insertNotice(Notice n) {
		int result=new NoticeDao().insertNotice(conn, n);
		if(result>0){
			commit(conn);
		}
		else {
			rollback(conn);
		}
		return result;
	}

	public int deleteNotice(int notice_no) {
		int result=new NoticeDao().deleteNotice(conn,notice_no);
		if(result>0){
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	
}
