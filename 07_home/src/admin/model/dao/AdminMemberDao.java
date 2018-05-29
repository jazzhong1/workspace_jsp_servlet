package admin.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import member.model.vo.Member;
import static common.JDBCTemplate.*;

public class AdminMemberDao {
	private PreparedStatement pstmt;
	private String fileName;
	private Properties prop;
	
	
	public AdminMemberDao() {
		pstmt=null;
		fileName=AdminMemberDao.class.getResource("/sql/admin/admin-query.properties").getPath();
		prop=new Properties();
		
		try {
			prop.load(new FileReader(fileName));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public ArrayList<Member> selectMemberList(Connection conn, int cPage, int numPerPage) {
		ResultSet rs=null;
		ArrayList<Member> list=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberList"));
			pstmt.setInt(1, ((cPage-1)*numPerPage+1));	//괄호 확실히해주기 오류남.
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Member member = new Member();
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
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}


	public ArrayList<Member> selectMemberbyId(Connection conn, String searchKeyword) {
		ResultSet rs=null;
		ArrayList<Member> list=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberbyId"));
			pstmt.setString(1, searchKeyword);
			rs=pstmt.executeQuery();

			while(rs.next()){
				Member member = new Member();
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
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}


	public ArrayList<Member> selectMemberbyName(Connection conn, String searchKeyword) {
		ResultSet rs=null;
		ArrayList<Member> list=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberbyName"));
			pstmt.setString(1, searchKeyword);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Member member = new Member();
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
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}


	public ArrayList<Member> selectMemberGender(Connection conn, String searchKeyword) {
		ResultSet rs=null;
		ArrayList<Member> list=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberGender"));
			pstmt.setString(1, searchKeyword);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Member member = new Member();
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
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}


	public int selectCount(Connection conn) {
		int cnt=0;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectCount"));
			rs=pstmt.executeQuery();
			if(rs.next()){
				cnt=rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}


	public ArrayList<Member> selectMemberbyIdFind(Connection conn, int cPage, int numPerPage, String searchKeyword) {
		ResultSet rs=null;
		ArrayList<Member> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberbyIdFind"));
			pstmt.setInt(1, ((cPage-1)*numPerPage+1));	//괄호 확실히해주기 오류남.
			pstmt.setInt(2, cPage*numPerPage);
			pstmt.setString(3, searchKeyword);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Member member = new Member();
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
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}


	public ArrayList<Member> selectMemberbyNameFind(Connection conn, int cPage, int numPerPage, String searchKeyword) {
		ResultSet rs=null;
		ArrayList<Member> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberbyNameFind"));
			pstmt.setInt(1, ((cPage-1)*numPerPage+1));	//괄호 확실히해주기 오류남.
			pstmt.setInt(2, cPage*numPerPage);
			pstmt.setString(3, searchKeyword);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Member member = new Member();
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
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}



	public ArrayList<Member> selectMemberbyGenderFind(Connection conn, int cPage, int numPerPage,
			String searchKeyword) {
		ResultSet rs=null;
		ArrayList<Member> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberbyGenderFind"));
			pstmt.setInt(1, ((cPage-1)*numPerPage+1));	//괄호 확실히해주기 오류남.
			pstmt.setInt(2, cPage*numPerPage);
			pstmt.setString(3, searchKeyword);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Member member = new Member();
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
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}




}
