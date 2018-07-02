package com.hong.mybatis.model.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hong.mybatis.model.dao.StudentDAO;
import com.hong.mybatis.model.dao.StudentDAOImpl;
import com.hong.mybatis.model.vo.Student;

public class StudentServiceImpl implements StudentService {

	/* DAO객체 맴버변수 선언 */
	private StudentDAO studentdao;

	/* DAO객체 멤버변수 초기화 */
	public StudentServiceImpl() {
		studentdao = new StudentDAOImpl();
	}

	/* SqlSession 객체를 만들어주는 메소드로 private로 선언 service에서 관리해야하기떄문에 */
	private SqlSession getSession() {

		SqlSession session = null;
		String resource = "/mybatis-config.xml";
		// import 패키지 org.apache.ibatis.io.Resources !!
		// xml에 설정되어있는 내용(DB정보)을 불러오는 구문
		// DB정보를 가지고 session객체 생성
		// 1. SqlSessionFactoryBuilder객체 생성
		// 2. SqlSessionFactory객체생성
		// -SqlSessionFactoryBuilder객체의 build()매소드 이용
		// 3. SqlSessionFactory객체 openSession()매소드이용 session생성!
		// - openSession(false) : 오토커밋 여부 결정!
		// - 오토커밋 취소(false) / 오토커밋실행(true)

		// 1번 처리
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

			SqlSessionFactory factory = builder.build(is);

			session = factory.openSession(false);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return session;
	}

	@Override
	public int insertStudent(Student student) {
		SqlSession session = getSession();
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
		SqlSession session = getSession();
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
		SqlSession session=getSession();
		Student student=studentdao.selectOne(session,no);
		return student;
	}

}
