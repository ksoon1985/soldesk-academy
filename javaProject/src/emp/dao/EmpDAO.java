package emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import emp.common.EmpConnection;
import emp.dto.EmpDTO;

public class EmpDAO {
	
	private static EmpDAO instance = new EmpDAO();
	public static EmpDAO getInstance() {return instance;}
	
	
	public int empEnrol(EmpDTO dto) throws NamingException , SQLException
	{
		Connection conn = EmpConnection.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int cnt = 0;
		int empno = 0;
		
		if(conn != null)
		{
			String sql = "";
			
			sql = "select nvl(max(empno),0) + 1 empno from emp";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				empno = rs.getInt("empno");
			}
			
			sql = "insert into emp(empno,deptno,ename,job,mgr,hiredate,sal,comm)";
			sql += " values(?,?,?,?,?,sysdate,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.setInt(2, dto.getDeptno());
			pstmt.setString(3,dto.getEname());
			pstmt.setString(4, dto.getJob());
			pstmt.setInt(5,dto.getMgr());
			pstmt.setInt(6,dto.getSal());
			pstmt.setInt(7, dto.getComm());
			
			cnt = pstmt.executeUpdate();
		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
		
		return cnt;
	}
	
	public void empUpdate(EmpDTO dto)
	{
		int r = 0;
		String sql="";
		
		PreparedStatement pstmt = null;
		
		try {
			
			Connection conn = EmpConnection.getConnection();
			
			sql = "update emp set ";
			sql+= " deptno = ? ";
			sql+= ", ename = ? ";
			sql+= ", job = ? ";
			sql+= ", mgr = ? ";
			sql+= ", hiredate = ?";
			sql+= ", sal = ? ";
			sql+= ", comm = ? ";
			sql+= " where empno = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getDeptno());
			pstmt.setString(2, dto.getEname());
			pstmt.setString(3, dto.getJob());
			pstmt.setInt(4,dto.getMgr());
			pstmt.setString(5, dto.getHiredate());
			pstmt.setInt(6, dto.getSal());
			pstmt.setInt(7, dto.getComm());
		
			r = pstmt.executeUpdate();
			
			if()
		}
		
	}
	
	public void empDelete()
	{
		
	}
	
}
