package member.model.service;

import static common.JDBCTemplate.*;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {
	//service객체의 역활
	//1. DB접속정보를 경로 확인 conn객체 생성 / 반환
	//2. 처리된 수정, 삭제, 삽입에 대한 commit, rollback처리
	//3. dao에서 받은 결과를 controller에 전달.
	
	//로그인 결과를 확인하는 변수 선언
	public static int LOGIN_OK=1;
	public static int WRONG_PASSWORD=0;
	public static int ID_NOT_EXIST=-1;
	
	public int loginCheck(String userId, String password)
	{
		Connection conn=getConnection();
		int result=new MemberDao().loginCheck(conn,userId,password);
		
		close(conn);
		
		return result;
	}
	public Member selectOne(String userId)
	{
		//1. DB와의 연결 객체를 생성 : connection
		//2. 데이터 CRUD(삽입, 수정, 삭제)가 
		//   발생한 경우 commit, rollback을 통제
		//3. 자신이 생성한 DB연결객체 반환 : connection
		//   **객체 삭제
		
		Connection conn=getConnection();
		Member m=new MemberDao().selectOne(conn, userId);
		close(conn);
		return m;
	}
	public int insertMember(Member member)
	{
		Connection conn=getConnection();
		int result=new MemberDao().insertMember(conn, member);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	public boolean duplicateId(String userId)
	{
		Connection conn=getConnection();
		
		boolean flag=new MemberDao().duplicateId(conn,userId);
		
		close(conn);
		
		return flag;
	}
	
	public int updateMember(Member m)
	{
		Connection conn=getConnection();
		
		int result=new MemberDao().updateMember(conn, m);
		//이작업은 수정이죠! CRUD에 해당! 수정!이면 
		//성공시 commit / 실패시 rollback을 해줘야함.
		//구분은 결과가 1이상이면 commit이고 아니면 rollback
		if(result>0)
		{
			commit(conn);
		}
		else
		{
			rollback(conn);
			
		}
		close(conn);
		return result;
		
	}
	
	public int memberDelete(String userId)
	{
		Connection conn=getConnection();
		
		int result=new MemberDao().memberDelete(conn, userId);
		//이작업은 수정이죠! CRUD에 해당! 수정!이면 
		//성공시 commit / 실패시 rollback을 해줘야함.
		//구분은 결과가 1이상이면 commit이고 아니면 rollback
		if(result>0)
		{
			commit(conn);
		}
		else
		{
			rollback(conn);
			
		}
		close(conn);
		return result;
		
	}
	
	public int updatePassword(String userId, String password)
	{
		Connection conn=getConnection();
		int result=new MemberDao().updatePassword(conn, userId, password);
		if(result>0)
		{
			commit(conn);
		}
		else
		{
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
}









