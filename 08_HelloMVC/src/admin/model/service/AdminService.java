package admin.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;

import admin.model.dao.AdminDao;
import member.model.vo.Member;

public class AdminService {

	public ArrayList<Member> selectMemberList(int cPage, int numPerPage)
	{
		Connection conn=getConnection();
		ArrayList<Member> list=new AdminDao().selectMemberList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	public List<Member> selectMemberbyId(String keyword)
	{
		Connection conn=getConnection();
		List<Member> list=new AdminDao().selectMemberbyId(conn,keyword);
		close(conn);
		return list;
	}
	
	public int selectCount()
	{
		Connection conn=getConnection();
		int result=new AdminDao().selectCount(conn);
		close(conn);
		return result;		
	}
	
	
}
