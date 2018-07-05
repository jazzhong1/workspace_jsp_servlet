package com.hong.mybatis.model.service;

import java.util.List;
import java.util.Map;

import com.hong.mybatis.model.vo.Student;

public interface StudentService {
	int insertStudent(Student student);

	int insertStudent(Map<String, Object> map);

	Student selectOne(String no);

	int deleteStudent(int no);

	List<Student> selectList();

	List<Student> selectList(String name);
}
