package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBCTemplate;
import member.model.vo.Member;

public class MemberDao {
	// 직접 DB와 소통하여 DB에 있는 데이터를 가져오는 객체
	public Member loginCheck(Connection conn, String id, String pw) {
		// DB가서 데이터를 요청하고 가져올 객체
		// 1. 객체생성 db가서 데이터를 요청하고 가져올 객체
		// 2. 요청할 sql문을 작성(String)
		// 3. 조회면 가져온 데이터를 받을 객체 생성(ResultSet)
		// 404는 서버문제
		// 505는 코드문제
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m =null;
		//중간에서 m을 호출하거나 사용할겅유 nullpoint 뜬다.
		String sql = "select * from member where member_id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // rs에 조회된 데이터가 있다.
			if (rs.next()) {
				if (rs.getString("member_pwd").equals(pw)) {
					m=new Member();
					
					m.setMember_id(rs.getString("member_id"));
					m.setMember_pwd(rs.getString("member_pwd"));
					m.setMember_name(rs.getString("member_name"));
					m.setGender(rs.getString("gender"));
					m.setAge(rs.getInt("age"));
					m.setEmail(rs.getString("email"));
					m.setPhone(rs.getString("phone"));
					m.setAddress(rs.getString("address"));
					m.setHobby(rs.getString("hobby"));
					m.setEnroll_datess(rs.getDate("enroll_date"));
				} else {
					m=new Member();
					m.setMember_id(rs.getString("member_id"));
					m.setMember_pwd("");
					m.setMember_name(rs.getString("member_name"));
					m.setGender(rs.getString("gender"));
					m.setAge(rs.getInt("age"));
					m.setEmail(rs.getString("email"));
					m.setPhone(rs.getString("phone"));
					m.setAddress(rs.getString("address"));
					m.setHobby(rs.getString("hobby"));
					m.setEnroll_datess(rs.getDate("enroll_date"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// 수정, 삭제, 삽입이면 결과를 받을 int형 변수선언
			// 4. 만약 불러온 데이터를 내 어플케이션에서 사용하려면
			// vo객체를 생성하여 저장
			// (단일 row일때는 vo, 다중값일때는 Collection으로 보관)
			// 5. 매소드에서 사용한 DB연결 객체는 닫아준다.
			// 닫아줄때는 생성의 역순으로 닫아줘야한다.
			// ResultSet -> Statement -> Connection
			JDBCTemplate.close(rs, pstmt);
		}
		return m;
	}

}
