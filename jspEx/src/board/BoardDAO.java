package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.dbutil.DBConnection;

// Data Access Object - 실질적인 DB 접근 객체 
// VO(Value Object) 와 비슷 하지만 VO 는 read-only 속성을 지님 
public class BoardDAO {
	/*
	 	db 처리해야 할 일이 있으면 DAO 인스터스를 받아서
	 	각각 insert , delete 등 모든 작업을 모듈화 해서 다른 객체에서 호출해서 사용 
	 */
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	
	// 게시글 작성 
	// 시퀀스를 받아서 저장해 두고 insert 시 받은 값을 사용한다. 
	public int boardWrite(BoardDTO dto) throws NamingException , SQLException{
		
		//boardnum_seq 
		
		Connection conn = DBConnection.getConnection();
		int cnt=0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 글번호를 위한 변수 
		int number = 0;
		int num = dto.getNum();
		int ref = dto.getRef();
		int re_step = dto.getRe_step();
		int re_level = dto.getRe_level();
		
		
		if(conn!=null) {
			String sql="";
			//시퀀스를 받아서 저장해두고 insert 시 
			//sql = "select boardnum_seq.nextval num from dual";
			

				sql = "select max(num)  num from board";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					number = rs.getInt("num") + 1;
				}
				
				// num if == 0 -> 새글 쓰기  , != 0 답글 쓰기 
				if(num == 0 )
				{
					num = number;
					ref = num;
					re_step = 1;
					re_level=1;
				
				}else if(num != 0) 
				{
					num = number;
					re_step += 1;
					re_level +=1;
				}
			
			
			sql = "insert into board(NUM,WRITER,SUBJECT,EMAIL,";
			sql+= "CONTENT,PASSWD,REG_DATE,READCNT,REF,RE_STEP,RE_LEVEL,ATTACHNM) ";
			sql+= " values(?,?,?,?,?,?,sysdate,0,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getContent());
			pstmt.setString(6, dto.getPasswd());
			pstmt.setInt(7, ref); // 그룹
			pstmt.setInt(8, re_step); // 답글의 단계
			pstmt.setInt(9, re_level); // 답글의 깊이 
			pstmt.setString(10, dto.getAttachNm());
			
			cnt = pstmt.executeUpdate();
		}
		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		
		return cnt;
	}
	
	// 모든 게시글 가져오기 
	public List<BoardDTO> getArticles(int sRow,int pageSize) throws NamingException, SQLException
	{
		String  sql = " select a.* ";
				sql+= " from (select rownum rr, rboard.* ";
				sql+= " 	from (select num,writer,subject,email,content,passwd,reg_date,readcnt,ref,re_step,re_level,attachnm";
		        sql+= " 			from board ";
		        sql+= "				order by ref asc, re_step asc ) rboard ) a ";
		        sql+= " where a.rr between ? and ? ";

		
		Connection conn = DBConnection.getConnection();
		
		List<BoardDTO> articles = new ArrayList<BoardDTO>(20);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, sRow);
		pstmt.setInt(2, pageSize);
		
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			BoardDTO dto = new BoardDTO();
			dto.setRr(rs.getInt("rr"));
			dto.setNum(rs.getInt("num"));
			dto.setWriter(rs.getString("WRITER"));
			dto.setSubject(rs.getString("SUBJECT"));
			dto.setEmail(rs.getString("EMAIL"));
			dto.setContent(rs.getString("CONTENT"));
			dto.setPasswd(rs.getString("PASSWD"));
			dto.setReg_date(rs.getString("REG_DATE"));
			dto.setReadcnt(rs.getInt("READCNT"));
			dto.setRef(rs.getInt("REF"));
			dto.setRe_step(rs.getInt("RE_STEP"));
			dto.setRe_level(rs.getInt("RE_LEVEL"));
			dto.setAttachNm(rs.getString("ATTACHNM"));
			
			articles.add(dto);
		}
		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		
		return articles;
	}
	
	// 선택한 게시글 보기 
	public BoardDTO getArticle(int num) throws NamingException  {
		
		PreparedStatement pstmt = null;
		BoardDTO dto = new BoardDTO();
		ResultSet rs = null;
		String sql = null;
		
		try {
			Connection conn = DBConnection.getConnection();
			
			sql = "update board set READCNT = READCNT + 1 where num  = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			int i = pstmt.executeUpdate();
			
			if(i > 0)
			{
				sql = "select NUM,WRITER,SUBJECT,EMAIL,CONTENT,PASSWD,REG_DATE,READCNT,REF,RE_STEP,RE_LEVEL, ATTACHNM";
				sql+= " from board where num= ? ";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				
				rs = pstmt.executeQuery();
			
				
				if(rs.next())
				{
					dto.setNum(rs.getInt("NUM"));
					dto.setWriter(rs.getString("WRITER"));
					dto.setSubject(rs.getString("SUBJECT"));
					dto.setEmail(rs.getString("EMAIL"));
					dto.setContent(rs.getString("CONTENT"));
					dto.setPasswd(rs.getString("PASSWD"));
					dto.setReg_date(rs.getString("REG_DATE"));
					dto.setReadcnt(rs.getInt("READCNT"));
					dto.setRef(rs.getInt("REF"));
					dto.setRe_step(rs.getInt("RE_STEP"));
					dto.setRe_level(rs.getInt("RE_LEVEL"));
					dto.setAttachNm(rs.getString("ATTACHNM"));
				}
			}
			
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}//
	
	// 게시글 수정 
	public int boardUpdate(BoardDTO dto) {
		int r = 0;
		
		PreparedStatement pstmt = null;
		try {
			String sql = "update board set ";
				   sql+= " SUBJECT = ?";
				   sql+= ", EMAIL = ?";
				   sql+= ", CONTENT = ?";
				   sql+= ", PASSWD = ?";
				   sql+= ", ATTACHNM = ?";
				   sql+= " where num =?";
				   
			Connection conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPasswd());
			pstmt.setString(5, dto.getAttachNm());
			pstmt.setInt(6, dto.getNum());
			
			r = pstmt.executeUpdate();
			
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
			
		}catch(NamingException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return r;
	}
	
	public int boardDelete(BoardDTO dto)
	{
		int r = 0;
		
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from board ";
				   sql+= " where num = ? ";
				   
			Connection conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getNum());
			
			r = pstmt.executeUpdate();
			
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
			
		}catch(NamingException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}
	
	public int getAllCount()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int allCnt = 0;
		
		String sql = "select count(num) cnt from board ";
		
		try {
		 conn = DBConnection.getConnection();
		 pstmt = conn.prepareStatement(sql);
		 rs = pstmt.executeQuery();
		 
		 if(rs.next())
		 {
			 allCnt = rs.getInt("cnt");
		 }
			
		 if(rs != null) {rs.close();}
		 if(pstmt != null) {pstmt.close();}
		 if(conn != null) {conn.close();}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allCnt;
	}
}
