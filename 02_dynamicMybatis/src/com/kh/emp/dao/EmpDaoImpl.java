package com.kh.emp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

public class EmpDaoImpl implements EmpDao {
	
	

	@Override
	public List<Map<String, String>> selectAll(SqlSession session) {
		List<Map<String, String>> list=session.selectList("emp.selectAll");
		return list;
	}

	@Override
	public List<Map<String, String>> searchCol(SqlSession session, Map<String, String> map) {
		List<Map<String, String>> list=session.selectList("emp.searchCol2",map);
		return list;
	}

	@Override
	public List<Map<String, String>> searchArr(SqlSession session, Map<String, String[]> map1) {
		List<Map<String, String>> list=session.selectList("emp.searchArr",map1);
		System.out.println(list);
		return list;
	}

	@Override
	public List<Map<String, String>> selectEmpList(SqlSession session, int cPage, int numPerPage) {
		RowBounds rowBounds=new RowBounds((cPage-1)*numPerPage,numPerPage);
		List<Map<String, String>> list=session.selectList("emp.page",null,rowBounds);
																//pageing처리할떄 map
		return list;
	}

	@Override
	public int selectCount(SqlSession session) {
		int count=session.selectOne("emp.count");
		return count;
	}



}
