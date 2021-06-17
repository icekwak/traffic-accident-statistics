package road;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

public class rankRoadCtrl {
	Connection conn = null;
	DataSource dataSource = null;
	
	public rankRoadCtrl() {
		try{
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		}catch(NamingException e){
			System.out.println("fail to DB Connection");
			e.printStackTrace();
		}
	}
	
	public ArrayList<rankRoadBean> getrankRoadList(){
		ResultSet rs = null;
	    Statement stmt = null;
	    ArrayList<rankRoadBean> rankRoadList = new ArrayList<rankRoadBean>();
	    
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT ddname FROM roadd ORDER BY d_accident DESC";
	      	stmt = conn.createStatement();
	      	rs = stmt.executeQuery(sql);
	      	
	      	while(rs.next()){
	      		rankRoadBean data = new rankRoadBean();
	      		data.setRankId(rs.getString("ddname"));
	      		rankRoadList.add(data);
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
		return rankRoadList;
	}
}
