package com.dbutil;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection{
	private static DBConnection instance = new DBConnection();
	private DBConnection() {}
	
	//naming service 를 사용 JNDI
	public static Connection getConnection() throws NamingException , SQLException{
		
		Context context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/soldesk");
		Connection conn = dataSource.getConnection(); 
		
		/*
		Context inCtx = new InitialContext();
		Context enCtx = (Context) inCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)enCtx.lookup("jdbc/soldesk");
		Connection conn;
		*/
		
		return conn;
	}
	public static DBConnection getInstance() {
		return instance;
	}
}
