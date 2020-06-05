package logon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.dbutil.DBConnection;

public class LogonDAO {
	// 데이터베이스 연결 후 
	private static LogonDAO instance = new LogonDAO();
	
	public static LogonDAO getInstance() {
		return instance;
	}
	
	// DB char일 경우 정해져 있는 만큼 빈칸이 들어감 
	public int userCheck(String id, String passwd)
	{	
		int x = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="";
		
		// 받은 id , password 로 회원이 맞는지 확인하는 로직 
		try {
			
			conn = DBConnection.getConnection();
			
			sql = "select * from member where id= ? and passwd = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,passwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				 if(rs.getString("memno")!=null && rs.getString("memno").length()!=0 ) 
					x =  1;
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
	}
}
