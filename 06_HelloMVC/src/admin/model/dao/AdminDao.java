package admin.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class AdminDao {
	private Properties prop;
	private String fileName;
	private PreparedStatement pstmp;

	public AdminDao() {
		pstmp = null;
		prop = new Properties();
		fileName = AdminDao.class.getResource("/sql/admin/admin-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Member> selectMemberList(Connection conn, int cPage, int numPerPage) {
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<>();
		try {
			pstmp = conn.prepareStatement(prop.getProperty("selectPage"));
			pstmp.setInt(1, ((cPage - 1) * numPerPage + 1));
			pstmp.setInt(2, cPage * numPerPage);
			rs = pstmp.executeQuery();
			while (rs.next()) {
				Member member = new Member();
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
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmp);
		}

		return list;
	}

	public ArrayList<Member> selectMemberbyId(Connection conn, String keyword) {
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<>();
		try {
			pstmp = conn.prepareStatement(prop.getProperty("selectMemberId"));
			pstmp.setString(1, "%" + keyword + "%"); // Like이기때문에 %로 앞뒤로 해한다.
			rs = pstmp.executeQuery();
			while (rs.next()) {
				Member member = new Member();
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
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmp);
		}

		return list;
	}

	public ArrayList<Member> selectMemberbyName(Connection conn, String keyword) {
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<>();
		try {
			prop.load(new FileReader(fileName));
			pstmp = conn.prepareStatement(prop.getProperty("selectByName"));
			pstmp.setString(1, keyword); // Like이기때문에 %로 앞뒤로 해한다.
			rs = pstmp.executeQuery();
			while (rs.next()) {
				Member member = new Member();
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
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmp);
		}

		return list;
	}

	public ArrayList<Member> selectMemberbyGender(Connection conn, String keyword) {
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<>();
		try {
			prop.load(new FileReader(fileName));
			pstmp = conn.prepareStatement(prop.getProperty("selectByGender"));
			pstmp.setString(1, keyword);
			rs = pstmp.executeQuery();
			while (rs.next()) {
				Member member = new Member();
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
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmp);
		}
		System.out.println(list);
		return list;
	}

	public int selectCount(Connection conn) {
		ResultSet rs = null;
		int result = 0;

		try {
			pstmp = conn.prepareStatement(prop.getProperty("selectCount"));
			rs = pstmp.executeQuery();
			if (rs.next()) {
				result = rs.getInt("cnt");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmp);
		}

		return result;
	}

	public List<Member> selectMemberbyIdFind(Connection conn, int cPage, int numPerPage, String searchKeyword) {
		ResultSet rs=null;
		List<Member> list=new ArrayList();
		//List<Member> list=new ArrayList<>(); 컬렉션붙이고 ()할경우 ArrayList가 만들어지지않는다.

		try {			
			pstmp=conn.prepareStatement(prop.getProperty("selectMemberbyIdFind"));
			pstmp.setInt(1, (cPage-1)*numPerPage+1);
			pstmp.setInt(2, cPage*numPerPage);
			pstmp.setString(3, searchKeyword);
			rs=pstmp.executeQuery();
			while (rs.next()) {
				Member member = new Member();
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
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmp);
		}
		
		return list;
	}

	public List<Member> selectMemberbyNameFind(Connection conn, int cPage, int numPerPage, String searchKeyword) {
		ResultSet rs=null;
		List<Member> list=new ArrayList();
		try {			
			pstmp=conn.prepareStatement(prop.getProperty("selectMemberbyNameFind"));
			pstmp.setInt(1, (cPage-1)*numPerPage+1);
			pstmp.setInt(2, cPage*numPerPage);
			pstmp.setString(3, searchKeyword);
			rs=pstmp.executeQuery();
			while (rs.next()) {
				Member member = new Member();
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
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmp);
		}
		
		return list;
	}

	public List<Member> selectMemberbyGenderFind(Connection conn, int cPage, int numPerPage, String searchKeyword) {
		ResultSet rs=null;
		List<Member> list=new ArrayList();
		try {			
			pstmp=conn.prepareStatement(prop.getProperty("selectMemberbyGenderFind"));
			pstmp.setInt(1, (cPage-1)*numPerPage+1);
			pstmp.setInt(2, cPage*numPerPage);
			pstmp.setString(3, searchKeyword);
			rs=pstmp.executeQuery();
			while (rs.next()) {
				Member member = new Member();
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
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmp);
		}
		
		return list;
	}
}
