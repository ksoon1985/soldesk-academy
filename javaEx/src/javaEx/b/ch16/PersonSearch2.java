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

	public class PersonSearch2 extends JFrame implements ActionListener {
	   private JPanel p1;
	   private JButton search;
	   private JTextField idSearch;
	   private JTable tb;
	   private DefaultTableModel tbModel;
	   //생성자
	   public PersonSearch2(String name) {
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
	      
	      tbModel = new DefaultTableModel(title,0);
	      tb = new JTable(tbModel);
	      
	      JScrollPane js = new JScrollPane(tb);
	      // p2.add(js);
	      add(p1, BorderLayout.NORTH);
	      add(js, BorderLayout.CENTER);

	      pack(); // 사이즈 조정 안해도 자동으로 크기 조절해서 출력됨
	      setVisible(true);
	   }

	   public void actionPerformed(ActionEvent e) {
	      String id = idSearch.getText().trim();
	      // 데이터베이스 접속하는 메소드 호출
	      Connection conn = getConnection();
	      // 데이터베이스를 통해 데이터 가져오기
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = "";
	      DefaultTableModel dt
	         = (DefaultTableModel) tb.getModel();
	      try {
	         if (id.equals("")) {
	            // 전체검색
	            if (conn != null) {
	               //전체 레코드 검색
	               
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
	            sql = "select id, name from person ";
	            sql+= "where name = ? or id=?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, id);
	            pstmt.setString(2, id);
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

	      String url = "jdbc:oracle:thin:@172.16.1.1:1521:XE";
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
