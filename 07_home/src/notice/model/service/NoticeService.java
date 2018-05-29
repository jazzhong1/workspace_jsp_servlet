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

	public List<Notice> selectList(int cPage, int numPerPage) {
		List<Notice> list=new NoticeDao().selectList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}

	public int selectCount() {
		int cnt=new NoticeDao().selectCount(conn);
		close(conn);
		return cnt;
	}

	public Notice selectOne(int no) {
		Notice notice=new NoticeDao().selectOne(conn,no);
		return notice;
	}

}
