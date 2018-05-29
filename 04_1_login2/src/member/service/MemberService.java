package member.service;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {
	//service 객체의 기능 : DB와 연결을 관리하는객체
	//Connection의 활용이 끝나면 객체를 반환해 줘야한다.
	//만약 데이터를 수정,삭ㅈ[ㅔ,삽입 경우 commit 또는 rollback처리한다.

	public Member loginCheck(String id, String pw) {

		Connection conn=getConnection();
		Member m=new MemberDao().loginCheck(conn,id,pw);
			JDBCTemplate.close(conn);
		return m;
	}

}
