package jspEx.ch04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionEx {
	ConnectionEx() {

		Connection conn = null; // 자바와 데이터베이스의 연결 통로
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // JDBC 드라이브 로드(db주소)
			String url = "jdbc:oracle:thin:@localhost:1521:XE"; // db이름
			String user = "user2";
			String password = "soldesk";

			conn = DriverManager.getConnection(url, user, password); // 데이터 베이스 접속
			System.out.println("DB 연결 성공");

			String sql = "insert into PERSON values(?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "kkk");
			pstmt.setString(2, "아무개");
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("입력에 성공");
			} else {
				System.out.println("입력에 실패");
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ConnectionEx();
	}

}
