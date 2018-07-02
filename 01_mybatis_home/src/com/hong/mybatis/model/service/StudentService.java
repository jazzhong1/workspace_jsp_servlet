package com.hong.mybatis.model.service;

import java.util.Map;

import com.hong.mybatis.model.vo.Student;

public interface StudentService {
	int insertStudent(Student student);

	int insertStudent(Map<String, Object> map);

	Student selectOne(String no);
}
