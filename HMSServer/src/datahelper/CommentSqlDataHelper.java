package datahelper;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentSqlDataHelper {
	
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
	
	public ArrayList<Comment> getAll(){
		Connection conn = getConn();
	    String sql = "select * from comment";
	    PreparedStatement pstmt;
	    try{
	    	pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        ArrayList<Comment> list=new ArrayList<Comment>();
	        while(rs.next()){
	        	Comment c=new Comment(rs.getString("hotelname"),rs.getString("detials"));
	        	list.add(c);
	        }
	        conn.close();
	        pstmt.close();
	        return list;
	    }catch(SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public int insert(Comment c){
		Connection conn=getConn();
		int i=0;
		PreparedStatement pstmt;
		String sql="insert into comment (hotelname,detials) values ("+"'"+c.getHotelName()+"','"+c.getDetials()+"')";
		 try {
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        i = pstmt.executeUpdate();
		        pstmt.close();
		        conn.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return i;
	}
	
	public int delete(Comment c){
		Connection conn=getConn();
		int i=0;
		PreparedStatement pstmt;
		String sql="delete from comment where detials ='"+c.getDetials()+"'";
		try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
}