package com.common;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactory {
	
	
	public static SqlSession getSession(){
		SqlSession session=null;
		//config.xml가져오기
		String resource="/mybatis-config.xml";
		
		try {
			Reader reader=Resources.getResourceAsReader(resource);
			session=new SqlSessionFactoryBuilder().build(reader).openSession(false);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return session;
	}

}
