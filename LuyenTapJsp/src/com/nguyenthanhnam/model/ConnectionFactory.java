package com.nguyenthanhnam.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory instance = new ConnectionFactory();
	String url = "jdbc:mysql://localhost/employee";
	String user = "root";
	String password = "";
	String driiverClass = "com.mysql.jdbc.Driver";

	// private contructor
	private ConnectionFactory() {
		try {
			Class.forName(driiverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ConnectionFactory getInstance() {
		return instance;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
