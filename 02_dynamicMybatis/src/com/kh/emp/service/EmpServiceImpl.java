package com.kh.emp.service;

import java.util.List;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;

import com.kh.emp.dao.EmpDao;
import com.kh.emp.dao.EmpDaoImpl;
import static common.SqlSessionTemplate.*;

public class EmpServiceImpl implements EmpService {
	
	private EmpDao empDao;
	private SqlSession session;
	
	public EmpServiceImpl() {
		empDao=new EmpDaoImpl();
	}

	@Override
	public List<Map<String, String>> selectAll() {
		//SqlSession 은 전역변수로 선언하면 안됨.....Executor was closed. 오류남..
		session=getSession();
		List<Map<String, String>> list=empDao.selectAll(session);
		session.close();
		return list;
	}

	@Override
	public List<Map<String, String>> searchCol(Map<String, String> map) {
		session=getSession();
		List<Map<String, String>> list=empDao.searchCol(session,map);
		return list;
	}

	@Override
	public List<Map<String, String>> searchArr(Map<String, String[]> map1) {
		session=getSession();
		List<Map<String, String>> list=empDao.searchArr(session,map1);
		return list;
	}

	@Override
	public List<Map<String, String>> selectEmpList(int cPage, int numPerPage) {
		session=getSession();
		List<Map<String, String>> list=empDao.selectEmpList(session,cPage,numPerPage);
		return list;
	}

	@Override
	public int selectCount() {
		session=getSession();
		int count=empDao.selectCount(session);
		return count;
	}







	

}
