package manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {
	Connection conn;
	public Connection getConn(){
		try {
			Context ctx = new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/manager");
			conn=ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	public void closeAll(Connection conn,PreparedStatement stmt,ResultSet rs){
		if(rs!=null){
		  try {
		  	  rs.close();
		  } catch (SQLException e) {
		  	  // TODO Auto-generated catch block
		  	  e.printStackTrace();
		  }
		}
		if(stmt!=null){
		  try {
			  stmt.close();
		  } catch (SQLException e) {
		  	// TODO Auto-generated catch block
			  e.printStackTrace();
		  }
		}
		if(conn!=null){
		  try {
			  conn.close();
		  } catch (SQLException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
		}
	}

} 
