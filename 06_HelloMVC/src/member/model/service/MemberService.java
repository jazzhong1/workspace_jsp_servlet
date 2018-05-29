package member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import admin.model.dao.AdminDao;
import common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {
	//서비스의 역할
	//DB접속 정보를 확인 con 객체 생성/반환
	//처리된 수정,삭제, 삽입에 대한 commit/rollback 처리
	//dao에서 받은 결과를 controller에 전달
	
	//로그인 결과를 확인하는 변수 선언
	public static int LOGIN_OK=1;
	public static int WRONG_PASSWORD=0;
	public static int ID_NOT_EXIST=-1;
	
	
	public int loginCheck(String userId, String password) {
		Connection conn=JDBCTemplate.getConnection();
		int result=new MemberDao().loginCheck(conn,userId,password);
		JDBCTemplate.close(conn);
		return result;
		
	}
	//1. DB와의 연결 객체를 생성 : connection
	//2. 데이터 CRUD(삽입, 수정, 삭제)가 발생한 경우 commit,rollback을 통제
	//3.자신의 생성한 연결 객체를 반환(닫기)
	public Member selectOne(String userId) {
		Connection conn=JDBCTemplate.getConnection();
		Member m=new MemberDao().selectOne(conn,userId);
		JDBCTemplate.close(conn);
		return m;
	}
	public int insertMember(Member m) {
		Connection conn=JDBCTemplate.getConnection();
		int result=new MemberDao().insertMember(conn,m);
		JDBCTemplate.close(conn);
		JDBCTemplate.commit(conn);
		return result;
	}
	
	public boolean duplicateId(String userId) {
		Connection conn=JDBCTemplate.getConnection();
		boolean flag=new MemberDao().duplicateId(conn, userId);
		JDBCTemplate.close(conn);
		JDBCTemplate.commit(conn);
		return flag;
	}
	public int updateMember(Member m) {
		Connection conn=JDBCTemplate.getConnection();
		int result=new MemberDao().updateMember(conn,m);
		
		if(result>0) {
		JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
		
	}
	
	public int deleteMember(String userId) {
		Connection conn=JDBCTemplate.getConnection();
		int result=new MemberDao().deleteMember(conn, userId);
		
		if(result>0) {
		JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	
	public int updatePassword(String userId, String pass_new) {
		Connection conn=JDBCTemplate.getConnection();
		int result=new MemberDao().updatePassword(conn,userId,pass_new);
		if(result>0){
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
}
