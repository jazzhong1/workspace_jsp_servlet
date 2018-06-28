package com.kh.mybatis.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.model.vo.Student;

public interface MybatisDAO {
	
	int insertStudent(SqlSession session);

	int insertName(SqlSession session,String name);

	int insertStudent(SqlSession session, Student student);

	
}
