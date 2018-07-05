package com.kh.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.model.vo.Student;

public interface MybatisDAO {
	
	int insertStudent(SqlSession session);

	int insertName(SqlSession session,String name);

	int insertStudent(SqlSession session,Student student);
	int insertStudent(SqlSession session,Map<String, Object> map);

	Student selectOne(SqlSession session, int no);

	int selectCount(SqlSession session);

	int delete(SqlSession session, int no);

	List<Student> selectList(SqlSession session);

	List<Student> selectOneList(SqlSession session, String name);

	List<Map<String, String>> selectListMap(SqlSession session);



	
}
