package com.nguyenthanhnam.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	String url = "jdbc:mysql://localhost/employee";
	String user = "root";
	String password = "";
	String driverClass = "com.mysql.jdbc.Driver";

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
