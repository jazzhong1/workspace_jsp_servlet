package member.model.sevice;
import static common.JDBCTemplate.*;

import static common.JDBCTemplate.getConnect;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;
public class MemberService {
	private Connection conn;
	
	public static int LOGINOK=1;
	public static int PASSWORDMAISS=0;
	public static int WORNGID=-1;
	public MemberService() {
		conn=getConnect();
	}
	
	public int loginCheck(String userId, String password) {
	
		int result=new MemberDao().loginCheck(conn,userId,password);
		close(conn);
		return result;
	}

	public Member selectOne(String userId) {
		Member member=new MemberDao().selectOne(conn,userId);
		close(conn);
		return member;
	}

	public int insert(Member member) {
		int result=new MemberDao().insert(conn,member);
		if(result>0){
			commit(conn);
		}
		else {
			rollback(conn);
		}
		return result;
	}

	public boolean duplicateId(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

}
