package com.kh.mybatis.model.service;

import java.util.Map;

import com.kh.mybatis.model.vo.Student;

public interface MybatisService {
	
	int insertStudent(Student student);
	int insertName(String name);
	int insertStudent();
	int insertStudent(Map<String, Object> map);
	Student selectOne(int no);
	int selectCount();
	
	
}
