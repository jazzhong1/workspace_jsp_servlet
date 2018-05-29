package member.model.dao;

import java.io.FileNotFoundException;
import static common.JDBCTemplate.*;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import member.model.vo.Member;

public class MemberDao {
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	private String fileName;

	public MemberDao() {
		pstmt = null;
		rs = null;
		prop = new Properties();
		fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
	}

	public int loginCheck(Connection conn, String userId, String password) {
		int result = -1;
		try {
			prop.load(new FileReader(fileName));
			pstmt = conn.prepareStatement(prop.getProperty("selectOne"));
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("userid").equals(userId)) {
					result = 0;
					if (rs.getString("password").equals(password)) {
						result = 1;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs, pstmt);
		}

		return result;
	}

	public Member selectOne(Connection conn, String userId) {
		Member member=null;
		try {
			prop.load(new FileReader(fileName));
			pstmt = conn.prepareStatement(prop.getProperty("selectOne"));
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				member=new Member();
				member.setMemberId(rs.getString("userid"));
				member.setMemberPw(rs.getString("password"));
				member.setMemberName(rs.getString("username"));
				member.setGender(rs.getString("gender"));
				member.setAge(rs.getInt("age"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setHobby(rs.getString("hobby"));
				member.setPhone(rs.getString("phone"));
				member.setEnrollDate(rs.getDate("enrolldate"));		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs, pstmt);
		}

		return member;
	}

	public int insert(Connection conn, Member member) {
		int result=0;
		try {
			prop.load(new FileReader(fileName));
			pstmt=conn.prepareStatement(prop.getProperty("insert"));
			//쿼리문미완성
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getGender());
			pstmt.setInt(5, member.getAge());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getPhone());
			pstmt.setString(8, member.getAddress());
			pstmt.setString(9, member.getHobby());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}



}
