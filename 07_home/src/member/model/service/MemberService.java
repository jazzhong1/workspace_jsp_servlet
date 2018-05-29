package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import member.model.dao.MemberDao;
import member.model.vo.Member;

import static common.JDBCTemplate.*;

public class MemberService {

	public static int LOGINOK = 1;
	public static int WORNGPW = 0;
	public static int NOID = -1;

	private Connection conn;

	public MemberService() {
		conn = getConnection();
	}

	public int loginCheck(String userId, String password) {
		int result = new MemberDao().loginCheck(conn, userId, password);
		close(conn);
		return result;
	}

	public Member selectOne(String userId) {
		Member m = new MemberDao().selectOne(conn, userId);
		close(conn);
		return m;
	}

	public int insertMember(Member member) {
		int result = new MemberDao().insertMember(conn, member);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}

	public boolean duplicate(String userId) {
		boolean result = new MemberDao().duplicate(conn, userId);
		close(conn);
		return result;
	}

	public int update(Member member) {
		int result = new MemberDao().update(conn, member);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

	public int deleteMember(String userId) {
		int result = new MemberDao().deleteMember(conn, userId);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updatePassword(String userId, String password_new) {
		int result=new MemberDao().updatePassword(conn,userId,password_new);
		if(result>0){
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	

}
