package jspEx.ch04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionEx3 {
	
	ConnectionEx3(){
		Connection conn = null; // 자바와 데이터베이스의 연결 통로
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // JDBC 드라이브 로드(db주소)
			String url = "jdbc:oracle:thin:@localhost:1521:XE"; // db이름
			String user = "user2";
			String password = "soldesk";
			
			conn = DriverManager.getConnection(url, user, password); // 데이터 베이스 접속
			System.out.println("DB 연결 성공");
			
			StringBuffer sql = new StringBuffer("select deptno,dname" + "  from dept where");
			sql.append(" deptno = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, 92);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				System.out.print("부서번호: "+ rs.getInt("deptno")+"\t");
				System.out.println("부서명: "+rs.getString("dname"));
			}
		} catch (SQLException e) {
			System.out.println("DB 연결 실패<br>");
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if (conn != null) {
				try {
					conn.close();
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String [] args) {
		new ConnectionEx3();
	}
}
