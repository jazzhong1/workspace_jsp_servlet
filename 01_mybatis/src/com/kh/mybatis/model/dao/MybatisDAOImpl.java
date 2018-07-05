package com.kh.mybatis.model.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.Session;

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
		//mybatis에 있는 sql문을 실행시킴~
		//****-mapper.xml 에 설정되어 있는 sql문을 활용
		int result=session.insert("mybatis.test3",student);
		return result;
	}

	
	@Override
	public int insertStudent(SqlSession session, Map<String, Object> map) {
		 Iterator i = map.keySet().iterator();
		 int result=0;
		 while(i.hasNext()) {
		        String key = (String)i.next();
		        System.out.println(key);
		        if(key.equals("student")){
		    		result=session.insert("mybatis.test5",map);
		        }
		        else {
		    		result=session.insert("mybatis.test4",map);
		        }
		 }
		 
		/*	Set<Map.Entry<String,Object>> set=map.entrySet();
			Iterator it=set.iterator();
			while(it.hasNext())
			{
				Map.Entry key=(Map.Entry)it.next();
		
				if(key.getValue() instanceof Student)
				{	
					result=session.insert("mybatis.test5",map);
				}
				else if(key.getValue() instanceof String)
				{
					result=session.insert("mybatis.test4",map);
				}
			}*/
		return result;
	}

	@Override
	public Student selectOne(SqlSession session, int no) {
		System.out.println(no);
		Student student=session.selectOne("mybatis.test6",no);
		return student;
	}

	@Override
	public int selectCount(SqlSession session) {
		int cnt=session.selectOne("mybatis.test7");
		return cnt;
	}

	@Override
	public int delete(SqlSession session, int no) {
		int result=session.delete("mybatis.test8",no);
		return result;
	}

	@Override
	public List<Student> selectList(SqlSession session) {
		List<Student> list=session.selectList("mybatis.list1");
		return list;
	}

	@Override
	public List<Student> selectOneList(SqlSession session, String name) {
		List<Student> list=session.selectList("mybatis.list2",name);
		return list;
	}

	@Override
	public List<Map<String, String>> selectListMap(SqlSession session) {
		List<Map<String, String>>  list=session.selectList("mybatis.list3");
		return list;
	}




}
