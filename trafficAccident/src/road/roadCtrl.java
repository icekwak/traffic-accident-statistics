package road;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

public class roadCtrl {
	Connection conn = null;
	DataSource dataSource = null;
	
	public roadCtrl() {
		try{
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		}catch(NamingException e){
			System.out.println("fail to DB Connection");
			e.printStackTrace();
		}
	}
	
	public ArrayList<roadBean> getRoadList(){
		ResultSet rs = null;
	    Statement stmt = null;
	    ArrayList<roadBean> roadList = new ArrayList<roadBean>();
	    
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM road";
	      	stmt = conn.createStatement();
	      	rs = stmt.executeQuery(sql);
	      	
	      	while(rs.next()){
	      		roadBean data = new roadBean();
	      		
	      		data.setId(rs.getString("roadName"));
	      		data.setAccident(rs.getInt("ro_accident"));
	      		data.setDeath(rs.getInt("ro_death"));
	      	
	      		int injured = rs.getInt("ro_injured1") + rs.getInt("ro_injured2") + rs.getInt("ro_injured3");
	      		data.setInjured(injured);
	      		
	      		roadList.add(data);
	      	}
	    }catch(SQLException ex){
	      	System.out.println("SQLException: " + ex.getMessage());
	    }finally{
	      	if(rs != null) {
	      		try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	      	}
	      	if(stmt != null) {
	      		try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	      	}
	      	if(conn != null) {
	      		try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	      	}
	    }
		return roadList;
	}
}
