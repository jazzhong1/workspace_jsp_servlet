package com.hong.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hong.mybatis.model.vo.Student;

public interface StudentDAO {

	int insertStudent(SqlSession session, Student student);

	int insertStudent(SqlSession session, Map<String, Object> map);

	Student selectOne(SqlSession session, String no);

	int deleteStudent(SqlSession session, int no);

	List<Student> selectList(SqlSession session);

	List<Student> selectList(SqlSession session, String name);

}
