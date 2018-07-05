package com.kh.emp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface EmpDao {

	List<Map<String, String>> selectAll(SqlSession session);

	List<Map<String, String>> searchCol(SqlSession session, Map<String, String> map);

	List<Map<String, String>> searchArr(SqlSession session, Map<String, String[]> map1);

	List<Map<String, String>> selectEmpList(SqlSession session, int cPage, int numPerPage);

	int selectCount(SqlSession session);


}
