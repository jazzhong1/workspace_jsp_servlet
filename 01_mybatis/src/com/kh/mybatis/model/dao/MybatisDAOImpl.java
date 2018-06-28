package com.kh.mybatis.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.model.vo.Student;

public class MybatisDAOImpl implements MybatisDAO {



	@Override
	public int insertStudent(SqlSession session) {
		int result=session.insert("mybatis.test1");
		return result;
	}
	
	@Override
	public int insertName(SqlSession session, String name) {
		System.out.println(name);
		int result=session.insert("mybatis.test2",name);
		return result;
	}

	@Override
	public int insertStudent(SqlSession session, Student student) {
		int result=session.insert("mybatis.test3",student);
		return result;
	}

}
