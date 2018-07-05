package com.hong.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface EmpDao {

	List<Map<String, String>> selectAll(SqlSession session);

	List<Map<String, String>> selectCol(SqlSession session, Map<String, String> map);

}
