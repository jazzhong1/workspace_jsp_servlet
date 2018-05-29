package admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import admin.model.dao.AdminDao;
import common.JDBCTemplate;
import member.model.vo.Member;

import static common.JDBCTemplate.*;

public class AdminService {
	private Connection conn;
	
	public AdminService() {
		conn=getConnection();
	}

	
	public ArrayList<Member> selectMemberList(int cPage, int numPerPage) {

		System.out.println("service cPage :" + cPage);
		System.out.println("service numPerPage :" + numPerPage);
		ArrayList<Member> list=new AdminDao().selectMemberList(conn,cPage,numPerPage);
		JDBCTemplate.close(conn);
		return list;
	}


	public ArrayList<Member> selectMemberbyId(String Keyword) {
		ArrayList<Member> list=new AdminDao().selectMemberbyId(conn,Keyword);
		JDBCTemplate.close(conn);
		return list;
		
	}
	
	public ArrayList<Member> selectMemberbyName(String Keyword) {
		ArrayList<Member> list=new AdminDao().selectMemberbyName(conn,Keyword);
		JDBCTemplate.close(conn);
		return list;
		
	}


	public ArrayList<Member> selectMemberbyGender(String Keyword) {
		ArrayList<Member> list=new AdminDao().selectMemberbyGender(conn,Keyword);
		JDBCTemplate.close(conn);
		return list;
	}


	public int selectCount() {
		int result=new AdminDao().selectCount(conn);
		JDBCTemplate.close(conn);
		return result;
	}


	public List<Member> selectMemberbyIdFind(int cPage, int numPerPage, String searchKeyword) {
		List<Member> list=new AdminDao().selectMemberbyIdFind(conn,cPage,numPerPage,searchKeyword);
		JDBCTemplate.close(conn);
		return list;
	}


	public List<Member> selectMemberbyNameFind(int cPage, int numPerPage, String searchKeyword) {
		List<Member> list=new AdminDao().selectMemberbyNameFind(conn,cPage,numPerPage,searchKeyword);
		JDBCTemplate.close(conn);
		return list;
	}


	public List<Member> selectMemberbyGenderFind(int cPage, int numPerPage, String searchKeyword) {
	List<Member> list=new AdminDao().selectMemberbyGenderFind(conn,cPage,numPerPage,searchKeyword);
	System.out.println("cPage"+cPage);
	System.out.println("numPerPage"+numPerPage);
	System.out.println("searchKeyword"+searchKeyword);
	JDBCTemplate.close(conn);
	return list;
	}


	
}
