package fr.diginamic.jdbc.recensement.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DaoUtils {
	
	private static ResourceBundle dataconf = ResourceBundle.getBundle("database");

	static {
		String driver = dataconf.getString("database.driver");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Connection getConnection() {
		try {
			String url = dataconf.getString("database.url");
			String user = dataconf.getString("database.user");
			String password = System.getProperty("password");
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
