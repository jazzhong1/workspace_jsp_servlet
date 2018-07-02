package com.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactory {

	
	public static SqlSession getSession(){
		SqlSession session=null;
		
		String resource="/mybatis-config.xml";
		
		try {
			Reader reader=Resources.getResourceAsReader(resource);
			session=new SqlSessionFactoryBuilder().build(reader).openSession(false);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
	}
}
