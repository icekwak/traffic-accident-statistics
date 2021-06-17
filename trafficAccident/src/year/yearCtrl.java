package year;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

public class yearCtrl {
	Connection conn = null;
	DataSource dataSource = null;
	
	public yearCtrl() {
		try{
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		}catch(NamingException e){
			System.out.println("fail to DB Connection");
			e.printStackTrace();
		}
	}
	
	public ArrayList<yearBean> getYearList(){
		ResultSet rs = null;
	    Statement stmt = null;
	    ArrayList<yearBean> yearList = new ArrayList<yearBean>();
	    
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM year";
	      	stmt = conn.createStatement();
	      	rs = stmt.executeQuery(sql);
	      	
	      	while(rs.next()){
	      		yearBean data = new yearBean();
	      		
	      		data.setId(rs.getString("year"));
	      		data.setAccident(rs.getInt("y_accident"));
	      		data.setDeath(rs.getInt("y_death"));
	      	
	      		int injured = rs.getInt("y_injured1") + rs.getInt("y_injured2") + rs.getInt("y_injured3");
	      		data.setInjured(injured);
	      		
	      		yearList.add(data);
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
		return yearList;
	}
}
