package member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import member.model.vo.Member;
import oracle.net.aso.s;

import static common.JDBCTemplate.*;

public class MemberDao {
	private Properties prop;
	private PreparedStatement pstmt;
	private String sql;
	private String filename;
	
	public MemberDao() {
		prop=new Properties();
		pstmt=null;
		sql="";
		 filename = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();

		try {
			prop.load(new FileReader(filename));
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int loginCheck(Connection conn, String userId, String password) {

		int result = -1;
		ResultSet rs = null;
		try {
			sql = prop.getProperty("selectOne");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("userid").equals(userId) && rs.getString("password").equals(password)) {
					return 1;
				} else if (rs.getString("userid").equals(userId)) {
					return 0;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public Member selectOne(Connection conn, String userId) {
		ResultSet rs = null;
		Member member = null;

		try { // getResource의 반환값은 url반환값 String으로 변경하려면 getPath();
			prop.load(new FileReader(filename));
			sql = prop.getProperty("selectOne");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member();
				member.setUserId(rs.getString("userid"));
				member.setPassword(rs.getString("password"));
				member.setUserName(rs.getString("username"));
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
		} finally {
			close(rs);
			close(pstmt);
		}
		return member;
	}

	public int insertMember(Connection conn, Member m) {
		int result = 0;
		try {
			sql = prop.getProperty("insert");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public boolean duplicateId(Connection conn, String userId) {
		boolean flag = false;
		ResultSet rs = null;
		int cnt = 0;

		try {
			prop.load(new FileReader(filename));
			String sql = prop.getProperty("checkIdDuplicate");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
			if (cnt == 0) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return flag;

	}

	public int updateMember(Connection conn, Member m) {

		// 1.각 필요객체 statement, resultSet, int, sql
		// 2.sql문을 가져오기 위한 properties 로직 처리
		// 3.데이터 DBMS에 전송!(statement객체이용!)
		// - 실행 : 데이터 있으면 executeQuery()/아니면 execuUpdate();
		// - 결과에 데이터를 가지면 ResultSet으로 받고
		// - 결과에 데이터 없는 CRUD 면 int로 받는다.
		int result = 0;
		String sql = "";

		try {
			sql = prop.getProperty("update");
			pstmt = conn.prepareStatement(sql);
			// pstmt SQL문 완성
			// update=update member set
			// password=?,username=?,gender=?,age=?,email=?,phone=?,address=?,hobby=? where
			// userid=?
			// pstmt.setString(1, m.getPassword());
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getGender());
			pstmt.setInt(3, m.getAge());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getPhone());
			pstmt.setString(6, m.getAddress());
			pstmt.setString(7, m.getHobby());
			pstmt.setString(8, m.getUserId());
			// 수정이기 때문에 Update이다
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteMember(Connection conn, String userId) {
		int result = 0;

		try {
			prop.load(new FileReader(filename));
			sql = prop.getProperty("delete");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updatePassword(Connection conn, String userId, String pass_new) {
		int result = 0;
		try {
			prop.load(new FileReader(filename));
			pstmt = conn.prepareStatement(prop.getProperty("updatePassword"));
			pstmt.setString(1, pass_new);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


}
