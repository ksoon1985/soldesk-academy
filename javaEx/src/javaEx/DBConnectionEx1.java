package javaEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//주의할 점
		/*
		 1. Connection 객체를 받아야 함
		 2. JDBC Driver 가 필요
		 3. JDBC Loading 
		 4. Driver Manager 를 통해서 db접속
		 5. db접속 종료시 반드시 연결을 닫아야함 
		 6. 예외 처리 ... 
		*/
		
		Connection conn = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver"; // db주소
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // db이름
		String user = "c##soon"; //유저
		String pass ="1234"; // 비밀번호
		try{
			Class.forName(driver);
			System.out.println("jdbc driver loading 성공 ");
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("connection 연결  성공 ");
			
			String sql = 
				"insert into STUDENT values('2013244009','임장순','남','컴퓨터공학부')";
			Statement stat = conn.createStatement(); 
			int result = stat.executeUpdate(sql);
			if(result >0) {
				System.out.println("입력에 성공");
			}else {
				System.out.println("입력에 실패");
			}
			
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("jdbc driver 없음");
			e.printStackTrace();
		}catch( SQLException e)
		{
			System.out.println("oracle 연결 실패 ");
			e.printStackTrace();
		}finally {
			if(conn!=null)
			{
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
