package accident;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

public class rankAccCtrl {
	Connection conn = null;
	DataSource dataSource = null;
	
	public rankAccCtrl() {
		try{
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		}catch(NamingException e){
			System.out.println("fail to DB Connection");
			e.printStackTrace();
		}
	}
	
	public ArrayList<rankAccBean> getrankAccList(){
		ResultSet rs = null;
	    Statement stmt = null;
	    ArrayList<rankAccBean> rankAccList = new ArrayList<rankAccBean>();
	    
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT accName FROM accident WHERE accName NOT IN('기타') ORDER BY ac_accident DESC";
	      	stmt = conn.createStatement();
	      	rs = stmt.executeQuery(sql);
	      	
	      	while(rs.next()){
	      		rankAccBean data = new rankAccBean();
	      		data.setRankId(rs.getString("accName"));
	      		rankAccList.add(data);
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
		return rankAccList;
	}
}
