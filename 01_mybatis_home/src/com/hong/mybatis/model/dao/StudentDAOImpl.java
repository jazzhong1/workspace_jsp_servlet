package com.hong.mybatis.model.dao;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import com.hong.mybatis.model.vo.Student;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;
import com.sun.xml.internal.ws.api.model.MEP;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public int insertStudent(SqlSession session, Student student) {
		int result=session.insert("mybatis.insertStudent", student);
		return result;
	}

	@Override
	public int insertStudent(SqlSession session, Map<String, Object> map) {
		int result=0;
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			String key=(String)it.next();
			if(map.get(key) instanceof String){
				result=session.insert("mybatis.insertStudentMap1",map);
				break;
			}
			else if (map.get(key) instanceof Student) {
				//인자값 it.next는 왜ㅏ안되지?
				result=session.insert("mybatis.insertStudentMap2",map);
				break;
			}
		}
		return result;
	}

	@Override
	public Student selectOne(SqlSession session, String no) {
		Student student=session.selectOne("mybatis.selectStudent",no);
		return student;
	}

}
