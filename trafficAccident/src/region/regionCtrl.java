package region;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

public class regionCtrl {
	Connection conn = null;
	DataSource dataSource = null;
	
	public regionCtrl() {
		try{
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		}catch(NamingException e){
			System.out.println("fail to DB Connection");
			e.printStackTrace();
		}
	}
	
	public ArrayList<regionBean> getRegionList(){
		ResultSet rs = null;
	    Statement stmt = null;
	    ArrayList<regionBean> regionList = new ArrayList<regionBean>();
	    
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT name, SUM(re_accident) AS sumAccident, SUM(re_death) AS sumDeath, SUM(re_injured1) AS sumInjured1, SUM(re_injured2) AS sumInjured2, SUM(re_injured3) AS sumInjured3 FROM rePackage INNER JOIN region ON rePackage.type = region.cityName GROUP BY name";
	      	stmt = conn.createStatement();
	      	rs = stmt.executeQuery(sql);
	      	
	      	while(rs.next()){
	      		regionBean data = new regionBean();
	      		
	      		data.setId(rs.getString("name"));
	      		data.setAccident(rs.getInt("sumAccident"));
	      		data.setDeath(rs.getInt("sumDeath"));
	      	
	      		int injured = rs.getInt("sumInjured1") + rs.getInt("sumInjured2") + rs.getInt("sumInjured3");
	      		data.setInjured(injured);
	      		
	      		regionList.add(data);
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
		return regionList;
	}
}
