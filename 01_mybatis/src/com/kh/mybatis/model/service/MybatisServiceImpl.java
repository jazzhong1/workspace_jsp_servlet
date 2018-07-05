package com.kh.mybatis.model.service;

import java.io.InputStream;
import java.util.List;
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


	private MybatisDAO mybatisDAO=new MybatisDAOImpl();
	
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

	@Override
	public int delete(int no) {
		SqlSession session=getSession();
		int result=mybatisDAO.delete(session,no);
		if(result>0)
			session.commit();
		else
			session.rollback();
		
		//연결객체 반환!
		session.close();
		return result;
	}

	@Override
	public List<Student> selectList() {
		SqlSession session=getSession();
		List<Student>list=mybatisDAO.selectList(session);
		session.close();
		return list;
	}

	@Override
	public List<Student> selectOneList(String name) {
		SqlSession session=getSession();
		List<Student>list=mybatisDAO.selectOneList(session,name);
		session.close();
		return list;
	}

	@Override
	public List<Map<String, String>> selectListMap() {
		SqlSession session =getSession();
		List<Map<String, String>> list=mybatisDAO.selectListMap(session);
		session.close();
		return list;
	}




}






