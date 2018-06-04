package ajax.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AjaxDao {

	public List<String> selectByName(String srchName)
	{
		List<String> list=null;
		PreparedStatement pstmt=null;
		Connection conn=null;
		ResultSet rs=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"web","web");
			pstmt=conn.prepareStatement("select * from classmate where name like ?");
			pstmt.setString(1, "%"+srchName+"%");
			rs=pstmt.executeQuery();
			
			list=new ArrayList();
			while(rs.next())
			{
				list.add(rs.getString("name"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
}








