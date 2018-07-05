package common;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactory {
	
	public static SqlSession getSession(){
		SqlSession session=null;
		
		try {
			String resource="mybatis-config.xml";
			Reader reader=Resources.getResourceAsReader(resource);
			session=new SqlSessionFactoryBuilder().build(reader).openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
