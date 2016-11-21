package datahelper;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import PO.HotelPO;

public class HotelSqlDataHelper {
	private static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/SE2";
	    String username = "root";
	    String password = "wasd132435";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,���ض�Ӧ����
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	
	public ArrayList<HotelPO> getAll(){
		Connection conn = getConn();
	    String sql = "select * from hotel";
	    PreparedStatement pstmt;
	    try{
	    	pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        ArrayList<HotelPO> list=new ArrayList<HotelPO>();
	        while(rs.next()){
	        	HotelPO h=new HotelPO(rs.getString("name"),rs.getString("businesscircle"),
	        			rs.getString("introduce"),rs.getString("adress"),rs.getDouble("stars"));
	        	list.add(h);
	        }
	        conn.close();
	        pstmt.close();
	        return list;
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }
	    return null;
	}
	
	public int insert(HotelPO h){
		
	}
}