package common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


public class JDBCTemplate {
	// Connection 객체생성 반환
	// 객체를 반환하는것을 close 메소드를 오버로딩(매개변수를 달리.)해서 처리
	// Statment, PreparedStatment 객체 종료
	// Connection 객체 종료
	// Resultset 객체종료
	// =======Connection을이용해ㅓㅅ=======
	// commit
	// rollback

	public static Connection getConnection() {
		Properties prop=new Properties();	//
		String filename=JDBCTemplate.class.getResource("./driver.properties").getPath();
											//경로를 잡아준다.
		//현재경로
		//경로가져오기.
		Connection conn = null;
		try {
			prop.load(new FileReader(filename));
			System.out.println(filename);
			
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
			// WEB-INF lib에 ojdbc 넣어주는것이 좋다.
		}
		return conn;
	}

	public static void close(Connection con) {
		try {
			if (!con.isClosed() && con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if (!stmt.isClosed() && stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs, Statement stmt) {
		try {
			if (!rs.isClosed() && rs != null) {
				rs.close();
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void commit(Connection con) {
		try {
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void rollback(Connection con) {
		try {
			con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
