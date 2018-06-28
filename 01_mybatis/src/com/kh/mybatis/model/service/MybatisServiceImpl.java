package com.kh.mybatis.model.service;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kh.mybatis.model.dao.MybatisDAO;
import com.kh.mybatis.model.dao.MybatisDAOImpl;
import com.kh.mybatis.model.vo.Student;

public class MybatisServiceImpl implements MybatisService {


	/*DAO객체 맴버변수로 선언*/
	private MybatisDAO mybatisDAO=new MybatisDAOImpl();
	
	/*SqlSession객체 만들어주는 메소드*/
	private SqlSession getSession()
	{
		SqlSession session=null;
		String resource="/mybatis-config.xml";
		try {
			//import 패키지 org.apache.ibatis.io.Resources !!
			//xml에 설정되어있는 내용(DB정보)을 불러오는 구문
			InputStream is=Resources.getResourceAsStream(resource);
			//DB정보를 가지고 session객체 생성
			//1. SqlSessionFactoryBuilder객체 생성
			//2. SqlSessionFactory객체생성 
			//   -SqlSessionFactoryBuilder객체의 build()매소드 이용 
			//3. SqlSessionFactory객체 open()매소드이용 session생성!
			//   - open(false) : 오토커밋 여부 결정! 
			//   - 오토커밋 취소(false) / 오토커밋실행(true)
			
			//1번 처리
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			//2번 처리
			SqlSessionFactory factory=builder.build(is);
			//3번 처리
			session=factory.openSession(false);	
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}
	

	@Override
	public int insertName(String name) {
		SqlSession session=getSession();
		int result=mybatisDAO.insertName(session,name);
		
		//트렌젝션처리
		if(result>0)
			session.commit();
		else
			session.rollback();
		
		//연결객체 반환!
		session.close();
		
		return result;
	}

	@Override
	public int insertStudent(Student student) {
		SqlSession session=getSession();
		int result=mybatisDAO.insertStudent(session,student);
		
		//트렌젝션처리
		if(result>0)
			session.commit();
		else
			session.rollback();
		
		//연결객체 반환!
		session.close();
		
		return result;
	}

}






