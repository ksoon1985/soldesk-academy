package emp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmpConnection {
	
	private static Connection con;
	private EmpConnection() {}
	
	public static Connection getConnection(){
		if(con!=null){ 
            return con;
        }
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url="jdbc:oracle:thin:@172.16.1.97:1521:xe";
            String user="user2";
            String pw="soldesk";   
            
            con = DriverManager.getConnection(url,user,pw);
           
            System.out.println("연결 성공");
           
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을수없습니다 : " + e);
        }catch(SQLException e){
            System.out.println(("일반 예외:" + e));
        }
        return con;
	}
}
