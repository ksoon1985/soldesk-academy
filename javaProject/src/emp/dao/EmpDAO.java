package emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import emp.common.EmpConnection;
import emp.dto.EmpDTO;

public class EmpDAO {
	
	private Connection con = null;
	
	public int empEnrol(EmpDTO dto) throws NamingException , SQLException
	{
		con = EmpConnection.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int cnt = 0;
		int empno = 0;
		
		if(con != null)
		{
			String sql = "";
			
			sql = "select nvl(max(empno),0) + 1 empno from emp";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				empno = rs.getInt("empno");
			}
			
			sql = "insert into emp(empno,deptno,ename,job,mgr,hiredate,sal,comm)";
			sql += " values(?,?,?,?,?,sysdate,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
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
		if(con != null) con.close();
		
		return cnt;
	}
	
	public void empUpdate(EmpDTO dto)
	{
		
	}
	
	public void empDelete()
	{
		
	}
	
}
