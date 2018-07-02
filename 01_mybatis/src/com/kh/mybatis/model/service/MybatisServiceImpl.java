package com.kh.mybatis.model.service;

import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kh.mybatis.model.dao.MybatisDAO;
import com.kh.mybatis.model.dao.MybatisDAOImpl;
import com.kh.mybatis.model.vo.Student;
import static com.common.SqlSessionFactory.*;

public class MybatisServiceImpl implements MybatisService {


	/*DAO객체 맴버변수로 선언*/
	private MybatisDAO mybatisDAO=new MybatisDAOImpl();
/*	
	SqlSession객체 만들어주는 메소드
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
	
*/
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
		
		//1.DB와 연결되는 Session관리(Connection 관리라고 볼수있음.)
		//2.Session을 DAO에 전달하는 역활
		//3.commit, rollback 처리(트랜잭션관리) insert,update,delete DB자료가 변경된 곳에서 
		
		SqlSession session=getSession();
		int result=mybatisDAO.insertStudent(session,student);
		
		//트렌젝션처리
		if(result>0)
			session.commit();
		else
			session.rollback();
		
		//연결객체 반환! POOLED: 반환~ 새로 생성하면 pool안에 임이의 저장되어있던 객체를 전송
		//pool에 있는지없는지 확인해보고 전송
		session.close();
		
		return result;
	}


	@Override
	public int insertStudent() {
		SqlSession session=getSession(); 
		int result=mybatisDAO.insertStudent(session);
		if(result>0)
			session.commit();
		else
			session.rollback();
		
		//연결객체 반환!
		session.close();
		
		return result;
	}


	@Override
	public int insertStudent(Map<String, Object> map) {
		SqlSession session=getSession(); 
		int result=mybatisDAO.insertStudent(session,map);
		if(result>0)
			session.commit();
		else
			session.rollback();
		
		//연결객체 반환!
		session.close();
		
		return result;
	}


	@Override
	public Student selectOne(int no) {
		SqlSession session=getSession();
		Student student=mybatisDAO.selectOne(session,no);
		return student;
	}

	@Override
	public int selectCount() {
		SqlSession session=getSession();
		int cnt=mybatisDAO.selectCount(session);
		return cnt;
	}




}






