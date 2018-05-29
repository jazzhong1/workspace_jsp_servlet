package kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kh.member.model.vo.Member;

public class MemberDao {

	public Member logincheck(Connection con, String id, String pw) {
		PreparedStatement pstmt;
		ResultSet rs;
		Member m=new Member();
		String sql = "select * from member where member_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				if (rs.getString("member_pwd").equals(pw)) {
				
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
				} 
				else {
					m=new Member();
					m.setMember_pwd(null);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(m.getAddress());
		return m;
	}

}
