package com.hanu.se2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnector {
	private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/se2_tutorial";
	private static DbConnector instance;
	private Connection connection;
	
	private DbConnector() throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		connection = DriverManager.getConnection(CONNECTION_STRING, "aspnet", "aspnet123");
	}
	
	public ResultSet executeSelect(String selectQuery) throws SQLException {
		PreparedStatement stm = connection.prepareStatement(selectQuery);
		return stm.executeQuery();
	}
	
	public int executeUpdate(String selectQuery, String...args) throws SQLException {
		PreparedStatement stm = connection.prepareStatement(selectQuery);
		for (int i = 0; i < args.length; i++) {
			stm.setString(i + 1, args[i]);
		}
		return stm.executeUpdate();
	}
	
	public static DbConnector getInstance() throws SQLException {
		if (instance == null) {
			instance = new DbConnector();
		}
		return instance;
	}
}
