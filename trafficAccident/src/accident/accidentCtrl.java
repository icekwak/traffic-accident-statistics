package accident;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

public class accidentCtrl {
	Connection conn = null;
	DataSource dataSource = null;
	
	public accidentCtrl() {
		try{
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		}catch(NamingException e){
			System.out.println("fail to DB Connection");
			e.printStackTrace();
		}
	}
	
	public ArrayList<accidentBean> getAccidentList(){
		ResultSet rs = null;
	    Statement stmt = null;
	    ArrayList<accidentBean> accidentList = new ArrayList<accidentBean>();
	    
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT accType, SUM(ac_accident) AS sumAccident, SUM(ac_death) AS sumDeath, SUM(ac_injured1) AS sumInjured1, SUM(ac_injured2) AS sumInjured2, SUM(ac_injured3) AS sumInjured3 FROM accident GROUP BY accType";
	      	stmt = conn.createStatement();
	      	rs = stmt.executeQuery(sql);
	      	
	      	while(rs.next()){
	      		accidentBean data = new accidentBean();
	      		
	      		data.setId(rs.getString("accType"));
	      		data.setAccident(rs.getInt("sumAccident"));
	      		data.setDeath(rs.getInt("sumDeath"));
	      	
	      		int injured = rs.getInt("sumInjured1") + rs.getInt("sumInjured2") + rs.getInt("sumInjured3");
	      		data.setInjured(injured);
	      		
	      		accidentList.add(data);
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
		return accidentList;
	}
}
