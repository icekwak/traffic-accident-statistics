package region;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

public class rankSiCtrl {
	Connection conn = null;
	DataSource dataSource = null;
	
	public rankSiCtrl() {
		try{
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		}catch(NamingException e){
			System.out.println("fail to DB Connection");
			e.printStackTrace();
		}
	}
	
	public ArrayList<rankSiBean> getrankSiList(){
		ResultSet rs = null;
	    Statement stmt = null;
	    ArrayList<rankSiBean> rankSiList = new ArrayList<rankSiBean>();
	    
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT cityName FROM region GROUP BY cityName ORDER BY SUM(re_accident) DESC";
	      	stmt = conn.createStatement();
	      	rs = stmt.executeQuery(sql);
	      	
	      	while(rs.next()){
	      		rankSiBean data = new rankSiBean();
	      		data.setRankId(rs.getString("cityName"));
	      		rankSiList.add(data);
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
		return rankSiList;
	}
}
