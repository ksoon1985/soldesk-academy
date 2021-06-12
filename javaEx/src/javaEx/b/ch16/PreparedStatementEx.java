package javaEx.b.ch16;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementEx {
	 static {
         try {
            String clname="oracle.jdbc.driver.OracleDriver";
            Class.forName(clname);
         }catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
      
         }
      }
      public static void main(String[] args) {
         String url="jdbc:oracle:thin:@172.16.1.3:1521:xe";
         String pw="soldesk";   
         String user="user2";
         Connection conn =null;
         PreparedStatement pstmt=null;
         ResultSet rs = null;
         try {
            conn= DriverManager.getConnection(url,user,pw);
            if(conn!=null) {
               //System.out.println("연결성공");
               String sql="create table test99(name varchar(20),";
                        sql+="tel varchar(15))";
               pstmt = conn.prepareStatement(sql);
               int r = pstmt.executeUpdate();
               if(r==0)System.out.println("테이블 생성 성공");
               else System.out.println("테이블 생성 실패");
               // for문을 이용해서 person 테이블에, 홍길동1,홍길동2... 
               //20200526~ 5명만 저장해보기
               sql="insert into Person(id,name)  values(?,?)";
               
               for(int i=1; i<=5; i++) {
                  pstmt=conn.prepareStatement(sql);
                  pstmt.setString(1 ,""+ (20200525+i));
                  pstmt.setString(2 ,"홍길동"+ i);
                  r= pstmt.executeUpdate();
                  if(r>0)System.out.println("삽입 성공");
               }
               r=0;
               sql = "select id, name from person";
               pstmt =conn.prepareStatement(sql);
               rs= pstmt.executeQuery();
               while(rs.next()) {
                  System.out.println("+++++++회원명단++++++");
                  System.out.print(rs.getString("id")+"\t");
                  System.out.println(rs.getString("name"));
               }
               
               pstmt =conn.prepareStatement("drop table test99");
               r= pstmt.executeUpdate();
               System.out.println(r+"테이블 삭제 성공");
            }
         }catch(SQLException e) {
            e.printStackTrace();
         }
      
   }

}
