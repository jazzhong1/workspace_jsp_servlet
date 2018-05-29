package member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import static common.JDBCTemplate.*;

import member.model.vo.Member;

public class MemberDao {
	private PreparedStatement pstmp;
	private Properties prop;
	private String fileName;
	public MemberDao() {
		pstmp=null;
		prop=new Properties();
		fileName=MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
	}

	public int loginCheck(Connection conn, String userId, String password) {
		ResultSet rs=null;
		int result=-1;
		try {
			prop.load(new FileReader(fileName));
			pstmp=conn.prepareStatement(prop.getProperty("selectOne"));
			pstmp.setString(1, userId);
			rs=pstmp.executeQuery();
			if(rs.next()){
				if(rs.getString("userid").equals(userId)&&rs.getString("password").equals(password)){
					result=1;
				}
				else if(rs.getString("userid").equals(userId)) {
					result=0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Member selectOne(Connection conn, String userId) {
		ResultSet rs=null;
		Member member=null;
		try {
			prop.load(new FileReader(fileName));
			pstmp=conn.prepareStatement(prop.getProperty("selectOne"));
			pstmp.setString(1, userId);
			rs=pstmp.executeQuery();
			while (rs.next()) {
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
			close(rs);
			close(pstmp);
		}
		
		return member;
	}

	public int insertMember(Connection conn, Member member) {
		int result=0;
		try {
			prop.load(new FileReader(fileName));
			pstmp=conn.prepareStatement(prop.getProperty("insert"));
			pstmp.setString(1, member.getMemberId());
			pstmp.setString(2, member.getMemberPw());
			pstmp.setString(3, member.getMemberName());
			pstmp.setString(4, member.getGender());
			pstmp.setInt(5, member.getAge());
			pstmp.setString(6, member.getEmail());
			pstmp.setString(7, member.getPhone());
			pstmp.setString(8, member.getAddress());
			pstmp.setString(9, member.getHobby());
			result=pstmp.executeUpdate();
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmp);
		}
		
		return result;
	}

	public boolean duplicate(Connection conn,String userId) {

		boolean result=true;
		ResultSet rs=null;
		try {
			prop.load(new FileReader(fileName));
			pstmp=conn.prepareStatement(prop.getProperty("duplicate"));
			pstmp.setString(1, userId);
			rs=pstmp.executeQuery();
			if(rs.next()){
				int cnt=rs.getInt("cnt");
				if(cnt==0){
					result=!result;
				}
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int update(Connection conn, Member member) {
		int result=0;
		try {
			System.out.println(member);
			prop.load(new FileReader(fileName));
			pstmp=conn.prepareStatement(prop.getProperty("update"));
			pstmp.setString(1, member.getMemberPw());
			pstmp.setString(2, member.getMemberName());
			pstmp.setString(3, member.getGender());
			pstmp.setInt(4, member.getAge());
			pstmp.setString(5, member.getEmail());
			pstmp.setString(6, member.getPhone());
			pstmp.setString(7, member.getAddress());
			pstmp.setString(8, member.getHobby());
			pstmp.setString(9, member.getMemberId());
//			update=UPDATE MEMBER SET PASSWORD=?,USERNAME=?,GENDER=?,AGE=?,EMAIL=?,PHONE=?,ADDRESS=?,HOBBY=? WHERE USERID=?

			result=pstmp.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmp);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, String userId) {
		int result=0;
		try {
			prop.load(new FileReader(fileName));
			pstmp=conn.prepareStatement(prop.getProperty("delete"));
			//delete=DELETE FROM MEMBER WHERE USERID=?
			pstmp.setString(1, userId);
			result=pstmp.executeUpdate();

		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close(pstmp);
		}
		
		return result;
	}

	public int updatePassword(Connection conn, String userId, String password_new) {
		int result=0;
		try {
			prop.load(new FileReader(fileName));
			pstmp=conn.prepareStatement(prop.getProperty("updatePassword"));
			pstmp.setString(1, password_new);
			pstmp.setString(2, userId);
			result=pstmp.executeUpdate();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmp);
		}
		return result;
	}

	

	

}
