package admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import admin.model.dao.AdminMemberDao;
import member.model.dao.MemberDao;
import member.model.vo.Member;
import static common.JDBCTemplate.*;

public class AdminMemberServiceServlet {
	private Connection conn;
	
	public AdminMemberServiceServlet() {
			conn=getConnection();
	}

	public ArrayList<Member> selectMemberList(int cPage, int numPerPage) {
		ArrayList<Member> list=new AdminMemberDao().selectMemberList(conn,cPage,numPerPage);
		close(conn);
		
		return list;
	}

	public List<Member> selectMemberbyId(String searchKeyword) {
		ArrayList<Member> list=new AdminMemberDao().selectMemberbyId(conn,searchKeyword);
		System.out.println(list);
		close(conn);
		return list;
	}

	public List<Member> selectMemberbyName(String searchKeyword) {
		ArrayList<Member> list=new AdminMemberDao().selectMemberbyName(conn,searchKeyword);
		close(conn);		
		return list;
	}

	public List<Member> selectMemberGender(String searchKeyword) {
		ArrayList<Member> list=new AdminMemberDao().selectMemberGender(conn,searchKeyword);
		close(conn);
		return list;
	}

	public int selectCount() {
		int cnt=new AdminMemberDao().selectCount(conn);
		close(conn);
		return cnt;
	}

	public List<Member> selectMemberbyIdFind(int cPage, int numPerPage, String searchKeyword) {
		ArrayList<Member> list=new AdminMemberDao().selectMemberbyIdFind(conn,cPage,numPerPage,searchKeyword);
		close(conn);
		return list;
	}

	public List<Member> selectMemberbyNameFind(int cPage, int numPerPage, String searchKeyword) {
		ArrayList<Member> list=new AdminMemberDao().selectMemberbyNameFind(conn,cPage,numPerPage,searchKeyword);
		close(conn);
		return list;
	}

	public List<Member> selectMemberbyGenderFind(int cPage, int numPerPage, String searchKeyword) {
		ArrayList<Member> list=new AdminMemberDao().selectMemberbyGenderFind(conn,cPage,numPerPage,searchKeyword);
		close(conn);
		return list;
	}


}
