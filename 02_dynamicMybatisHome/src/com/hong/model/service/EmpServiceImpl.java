package com.hong.model.service;

import java.util.List;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;

import com.hong.model.dao.EmpDao;
import com.hong.model.dao.EmpDaoImpl;
import static common.SqlSessionFactory.*;

public class EmpServiceImpl implements EmpService {
	private SqlSession session;
	private EmpDao empdao;
	
	public EmpServiceImpl() {
		empdao=new EmpDaoImpl();
	}
	
	
	
	
	@Override
	public List<Map<String, String>> selectAll() {
		session=getSession();
		List<Map<String, String>> list=empdao.selectAll(session);
		return list;
	}




	@Override
	public List<Map<String, String>> selectCol(Map<String, String> map) {
		session=getSession();

		List<Map<String, String>> list=empdao.selectCol(session,map);
		return list;
	}





}
