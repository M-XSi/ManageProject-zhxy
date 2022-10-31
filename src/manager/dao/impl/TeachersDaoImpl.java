package manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manager.bean.Teachers;
import manager.dao.BaseDao;
import manager.dao.TeachersDao;

public class TeachersDaoImpl implements TeachersDao {
	//数据库连接
	Connection conn;
	//执行SQL语句
	PreparedStatement ps;
	//查询结果集
	ResultSet rs;
	public int addTeacher(Teachers t) {
		BaseDao bd=new BaseDao();
		conn = bd.getConn();
		String sql="insert into manage.teachers(t_name,t_login,t_pwd,t_address,t_tel,t_sex,t_email) values(?,?,?,?,?,?,?)";
		int rst=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,t.getT_name());
			ps.setString(2,t.getT_login());
			ps.setString(3,t.getT_pwd());
			ps.setString(4,t.getT_address());
			ps.setString(5,t.getT_tel());
			ps.setString(6,t.getT_sex());
			ps.setString(7,t.getT_email());
			rst=ps.executeUpdate();
			bd.closeAll(conn, ps, rs);
			}catch (SQLException e) {
				bd.closeAll(conn, ps, rs);
			    //TODO Auto-generated catch block
				e.printStackTrace();				
		}		
			return rst;	    
	}
	public int delTeacher(Teachers t) {
		// TODO Auto-generated method stub
		BaseDao bd = new BaseDao();
		conn = bd.getConn();
		String sql = "delete from manage.teachers where t_id=?";
		int rst = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getT_id());
			rst = ps.executeUpdate();
			bd.closeAll(conn, ps, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			bd.closeAll(conn, ps, rs);
			e.printStackTrace();
		}
		return rst;	
	}
	public int updateTeachers(Teachers t) {
		BaseDao bd = new BaseDao();
		conn = bd.getConn();
		//String sql = "update manage.teachers  set t_name=?,t_address=?,t_tel=?,t_pwd=?,t_email=?,t_sex=?";
		String sql = "update manage.teachers  set t_name=?,t_pwd=?,t_address=?,t_tel=?,t_sex=?,t_email=?,t_login=? where t_id=?";
		int rst = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, t.getT_name());
			ps.setString(7, t.getT_login());
			ps.setString(2, t.getT_pwd());
			ps.setString(5, t.getT_sex());
			ps.setString(3, t.getT_address());
			ps.setString(4, t.getT_tel());
			ps.setString(6, t.getT_email());
			ps.setInt(8, t.getT_id());
			
			rst = ps.executeUpdate();
			System.out.println(rst);
			//bd.closeAll(conn, ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			bd.closeAll(conn, ps, rs);
			e.printStackTrace();
		}
		return rst;
	}

	public Teachers findTeacher(Teachers t) {
		BaseDao bd=new BaseDao();
		conn=bd.getConn();
		String sql="select * from manage.teachers where t_login=? and t_pwd=?";
		Teachers t1=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, t.getT_login());
			ps.setString(2, t.getT_pwd());
			rs=ps.executeQuery();
			if(rs.next()){
				t1=new Teachers();
				t1.setT_address(rs.getString("t_address"));
				t1.setT_email(rs.getString("t_email"));
				t1.setT_id(rs.getInt("t_id"));
				t1.setT_login(rs.getString("t_login"));
				t1.setT_pwd(rs.getString("t_pwd"));
				t1.setT_tel(rs.getString("t_tel"));
				t1.setT_sex(rs.getString("t_sex"));
				t1.setT_name(rs.getString("t_name"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return t1;
	}

	public Teachers findTeacher(int s_id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
	
	public List<Teachers> findTeachers(Object... param) {
		BaseDao bd=new BaseDao();
		conn=bd.getConn();
		String sql="select * from manage.teachers ";	//String sql="select * from manage.teachers where t_name like '?%' ";	
		Teachers t1=null;
		List<Teachers> tl=null;
		try {
			ps=conn.prepareStatement(sql);
//			ps.setString(1, param[0].toString());
//			ps.setInt(2, Integer.parseInt(param[1].toString()));
			rs=ps.executeQuery();
			while(rs.next()){
				if(tl==null){
					tl=new ArrayList<Teachers>();
				}
				t1=new Teachers();
				t1.setT_address(rs.getString("t_address"));
				t1.setT_email(rs.getString("t_email"));
				t1.setT_id(rs.getInt("t_id"));
				t1.setT_login(rs.getString("t_login"));
				t1.setT_pwd(rs.getString("t_pwd"));
				t1.setT_tel(rs.getString("t_tel"));
				t1.setT_sex(rs.getString("t_sex"));
				t1.setT_name(rs.getString("t_name"));
				tl.add(t1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return tl;
	}

}
