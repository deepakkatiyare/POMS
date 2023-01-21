package com.revature.poms.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

public class DatabaseConnection {
	private static Connection connection = null;
	private static Logger log = Logger.getLogger(DatabaseConnection.class);
	public static Connection getConnection() {
		if (connection == null) {
			ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
			String dburl = resourceBundle.getString("dburl");
			String username = resourceBundle.getString("username");
			String pass = resourceBundle.getString("password");
			try {
				Class.forName(resourceBundle.getString("driver"));
				connection = DriverManager.getConnection(dburl, username, pass);
			} catch (ClassNotFoundException e) {
				log.info(e.getMessage());
			} catch (SQLException e) {
				log.info(e.getMessage());
			}
		}
		return connection;
	}
}
