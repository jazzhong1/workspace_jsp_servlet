package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.Member;

public class MemberDao {

	private Properties prop=new Properties();

	public MemberDao() {
		try {
			String fileName=MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public int loginCheck(Connection conn, String userId, String password)
	{
		int result=-1;
		PreparedStatement pstmt=null;
		String sql="";
		ResultSet rs=null;
		try {
			
			sql=prop.getProperty("selectOne");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				if(rs.getString("userid").equals(userId)
						&&rs.getString("password").equals(password))
					return 1;
				else if(rs.getString("userid").equals(userId))
				{
					return 0;
				}	
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
		return result;
	}
	public Member selectOne(Connection conn, String userId)
	{
		PreparedStatement pstmt=null;
		Member member=null;
		ResultSet rs=null;
		String sql="";
		try
		{
			sql=prop.getProperty("selectOne");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
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
		return member;
	}
	public int insertMember(Connection conn, Member member)
	{
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insert"); 
		//insert into member values(?,?,?,?,?,?,?,?,?,sysdate);
		System.out.println(query);
		
		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
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
			
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
	
	public boolean duplicateId(Connection conn, String userId)
	{
		boolean flag=false;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int cnt=0;
		
		String sql=prop.getProperty("checkIdDuplicate");
		System.out.println(sql);
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			System.out.println(userId);
			if(rs.next())
			{
				cnt=rs.getInt("cnt");
			}
			if(cnt==0)
			{
				flag=true;
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
		return flag;
	}
	public int updateMember(Connection conn, Member m)
	{
		//1.각 필요객체 statement, resultSet, int, sql문
		//2.sql문을 가져오기 위한 properties로직 처리
		//3.데이터 DBMS에 전송!(statement객체이용!)
		//  -실행 : 데이터있으면 executeQuery() / 
		//          아니면 executeUpdate();
		//  -결과에 데이터를 가지면 ResultSet으로 받고
		//  -결과에 데이터 없는 수정, 삭제, 삽입이면 int로 받음
		PreparedStatement pstmt=null;
		int result=0;
		String sql="";
		//sql문가져오기
		try
		{
			sql=prop.getProperty("update");
			pstmt=conn.prepareStatement(sql);
			//pstmt SQL문 완성
			//UPDATE MEMBER SET PASSWORD=?,USERNAME=?,GENDER=?,AGE=?,EMAIL=?,PHONE=?,ADDRESS=?,HOBBY=? WHERE USERID=?
			//pstmt.setString(1, m.getMemberPw());
			pstmt.setString(1, m.getMemberName());
			pstmt.setString(2, m.getGender());
			pstmt.setInt(3, m.getAge());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getPhone());
			pstmt.setString(6, m.getAddress());
			pstmt.setString(7, m.getHobby());
			pstmt.setString(8, m.getMemberId());			
			//수정이기때문에 executeUpdate()사용
			result=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;	
		
	}
	
	public int memberDelete(Connection conn, String userId)
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql="";
		//sql문가져오기
		try
		{
			sql=prop.getProperty("delete");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			result=pstmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(pstmt);
		}
		
		return result;
		
		
	}
	
	public int updatePassword(Connection conn, String userId, String password)
	{
		PreparedStatement pstmt=null;
		int result=0;
		String sql="";
		try {
			sql=prop.getProperty("updatePassword");
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, password);
			pstmt.setString(2, userId);
			
			result=pstmt.executeUpdate();			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			close(pstmt);			
		}
		return result;		
	}
	
	
}








