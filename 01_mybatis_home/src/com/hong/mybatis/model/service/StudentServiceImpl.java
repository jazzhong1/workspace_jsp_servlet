package com.hong.mybatis.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hong.mybatis.model.dao.StudentDAO;
import com.hong.mybatis.model.dao.StudentDAOImpl;
import com.hong.mybatis.model.vo.Student;

import static com.common.SqlSessionFactory.*;

public class StudentServiceImpl implements StudentService {

	/* DAO객체 맴버변수 선언 */
	private StudentDAO studentdao;
	private SqlSession session;

	/* DAO객체 멤버변수 초기화 */
	public StudentServiceImpl() {
		studentdao = new StudentDAOImpl();
		session = getSession();
	}

	@Override
	public int insertStudent(Student student) {
		session = getSession();
		int result = studentdao.insertStudent(session, student);
		if (result > 0)
			session.commit();
		else
			session.rollback();

		// 연결객체 반환!
		session.close();
		return result;
	}

	@Override
	public int insertStudent(Map<String, Object> map) {
		session = getSession();
		int result = studentdao.insertStudent(session, map);
		if (result > 0)
			session.commit();
		else
			session.rollback();

		// 연결객체 반환!
		session.close();
		return result;
	}

	@Override
	public Student selectOne(String no) {
		session = getSession();
		Student student = studentdao.selectOne(session, no);
		return student;
	}

	@Override
	public int deleteStudent(int no) {
		session=getSession();
		int result=studentdao.deleteStudent(session,no);
		if(result>0){
			session.commit();
		}
		else{
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public List<Student> selectList() {
		session=getSession();
		List<Student> list=studentdao.selectList(session);
		session.close();
		return list;
	}

	@Override
	public List<Student> selectList(String name) {
		session=getSession();
		List<Student> list=studentdao.selectList(session,name);
		session.close();
		return list;
	}

}
