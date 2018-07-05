package com.hong.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Map<String, String>> selectAll(SqlSession session) {
		 List<Map<String, String>>list=session.selectList("emp.selectAll");
		return list;
	}

	@Override
	public List<Map<String, String>> selectCol(SqlSession session, Map<String, String> map) {
		List<Map<String, String>> list=session.selectList("emp.selectCol",map);
		return list;
	}

}
