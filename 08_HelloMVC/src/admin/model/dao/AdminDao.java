package admin.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class AdminDao {
	private Properties prop=new Properties();
	
	//기본생성자(default)에서 sql의properties파일을 받아오는 
	//로직구현
	public AdminDao() {
		try {
			String fileName=MemberDao.class.
					getResource("/sql/admin/admin-query.properties")
					.getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<Member> selectMemberList(Connection conn, int cPage, int numPerPage)
	{
		PreparedStatement pstmt=null;
		ArrayList<Member> list=new ArrayList();
		Member member=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectPage");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ((cPage-1)*numPerPage+1));
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				member=new Member();
				member.setMemberId(rs.getString("userid"));
				member.setMemberPw(rs.getString("password"));
				member.setMemberName(rs.getString("username"));
				member.setAge(rs.getInt("age"));
				member.setAddress(rs.getString("address"));
				member.setEmail(rs.getString("email"));
				member.setGender(rs.getString("gender"));
				member.setHobby(rs.getString("hobby"));
				member.setPhone(rs.getString("phone"));
				member.setEnrollDate(rs.getDate("enrolldate"));					
				list.add(member);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(pstmt);
		}
		return list;		
	}
	
	public List<Member> selectMemberbyId(Connection conn, String keyword)
	{
		PreparedStatement pstmt=null;
		ArrayList<Member> list=new ArrayList();
		Member member=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectMemberId");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				member=new Member();
				member.setMemberId(rs.getString("userid"));
				member.setMemberPw(rs.getString("password"));
				member.setMemberName(rs.getString("username"));
				member.setAge(rs.getInt("age"));
				member.setAddress(rs.getString("address"));
				member.setEmail(rs.getString("email"));
				member.setGender(rs.getString("gender"));
				member.setPhone(rs.getString("phone"));
				member.setHobby(rs.getString("hobby"));
				member.setEnrollDate(rs.getDate("enrolldate"));					
				list.add(member);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(pstmt);
		}
		return list;	
		
	}
	
	public int selectCount(Connection conn)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectCount");
		int result=0;
		try
		{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				result=rs.getInt("cnt");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	
}








