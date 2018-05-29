package kh.member.model.sevice;

import java.sql.Connection;

import kh.member.model.dao.MemberDao;
import kh.member.model.vo.Member;
import static common.JDBCTemplate.*;

public class MemberService {
	//DB연결 자체를 통제.
	
	
	public MemberService() {
	}
	
	public Member logincheck(String id,String pw){
		Connection con=getConnection();
		Member m=new MemberDao().logincheck(con, id, pw);
		return m;
	}

}
