package javaEx.b.ch16;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PersonSearch extends JFrame implements ActionListener{
	   private JPanel p1;
	   
	   private JButton search;
	   private JTextField idSearch;
	   private JTable tb;
	   private DefaultTableModel tbModel;
	      
	   //생성자
	   public PersonSearch(String name) {
	      super(name);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      // setSize(400, 400);
	      setLayout(new BorderLayout());
	      idSearch = new JTextField(10);
	      search = new JButton("검색");
	      search.addActionListener(this);
	      p1 = new JPanel();
	      //p2 = new JPanel();
	      p1.add(idSearch);
	      p1.add(search);

	      // 실제 데이터베이스 연결 후 데이터를 읽어와서 저장
	      //data = new String[4][2];
	      String[] title = { "아이디", "이 름" };
	      
	      tbModel = new DefaultTableModel(title,0); // conName , rowCount 
	      tb = new JTable(tbModel); // 모델을 기반으로 JTable 만듬 
	      
	      JScrollPane js = new JScrollPane(tb); // 스크롤팬에 jtable 부착 
	      // p2.add(js);
	      add(p1, BorderLayout.NORTH); // jframe 상단에 jpanel p1부착
	      add(js, BorderLayout.CENTER); // jframe 센터에 scrollpane js 부착 

	      pack(); // 사이즈 조정 안해도 자동으로 크기 조절해서 출력됨
	      setVisible(true);
	   }

	   public void actionPerformed(ActionEvent e) {
	      String id = idSearch.getText().trim(); // 검색할 id trim해주기 
	      
	      System.out.println(id);
	      
	      // 데이터베이스 접속하는 메소드 호출
	      Connection conn = getConnection(); 
	      
	      // 데이터베이스를 통해 데이터 가져오기
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      String sql = "";
	      DefaultTableModel dt
	         = (DefaultTableModel) tb.getModel();
	      
	      try {
	    	  
	         // 전체검색(아무것도 입력하지 않고 검색을 눌렀을 때 )
	         if (id.equals("")) 
	         {
	            if (conn != null) {
	               
	               sql = "select id, name from person";
	               pstmt = conn.prepareStatement(sql);
	               rs = pstmt.executeQuery();
	               //테이블 모델 깨끗이 정리
	               dt.setNumRows(0);
	               //하나의 행을 위한 배열 선언과 생성
	               String row[]=new String[2];
	               
	               while(rs.next()) {
	                  row[0]=rs.getString("id");
	                  row[1]=rs.getString("name");
	                  dt.addRow(row);
	               } //while의 끝
	            } // connection 이 있을 때 실행 끝
	         } else {
	            // 해당 데이터 검색 부분검색
	            dt.setNumRows(0);
	            sql = "select id, name from person where id = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, id);
	            rs = pstmt.executeQuery();
	            String row[] = new String[2];
	            while(rs.next()) {
	               row[0]=rs.getString("id");
	               row[1]=rs.getString("name");
	               dt.addRow(row);
	            } //while의 끝
	         } // id 에 따른 조건 끝
	      } catch (SQLException e1) {
	         e1.printStackTrace();
	      }
	   }

	   private Connection getConnection() {
	      try {
	         String clname = "oracle.jdbc.driver.OracleDriver";
	         Class.forName(clname);
	      } catch (ClassNotFoundException e) {
	         System.out.println(e.getMessage());
	      }

	      String url = "jdbc:oracle:thin:@172.16.1.97:1521:XE";
	      String user = "user2";
	      String pw = "soldesk";
	      Connection conn = null;

	      try {
	         conn = DriverManager.getConnection(url, user, pw);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return conn;
	   }

	   public static void main(String args[]) {
	      new PersonSearch("회원명단");
	   }
}
