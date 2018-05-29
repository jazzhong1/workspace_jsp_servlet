package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	
	public static Connection getConnect() {
		Connection conn=null;
		Properties prop=new Properties();
		String fileName=JDBCTemplate.class.getResource("./driver.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
			Class.forName(prop.getProperty("driver"));
			conn=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("pw"));
			conn.setAutoCommit(false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(Connection conn){
		try {
			if(!conn.isClosed()&&conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt){
		try {
			if(!stmt.isClosed()&&stmt!=null){
				stmt.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs,Statement stmt){
		try {
			if(!rs.isClosed()&&rs!=null){
				rs.close();
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn){
		try {
			if(!conn.isClosed()&&conn!=null){
				conn.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void rollback(Connection conn){
		try {
			if(!conn.isClosed()&&conn!=null){
				conn.rollback();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
