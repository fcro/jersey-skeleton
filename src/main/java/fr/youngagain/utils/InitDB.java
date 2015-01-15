package fr.youngagain.utils;

import java.sql.SQLException;
import java.sql.Statement;

public class InitDB {
	public static void init() {
		Statement stmt = null;
		try {
			stmt = DBConnector.getConnection().createStatement();
			stmt.executeUpdate("DROP TABLE user;");
			String query = "CREATE TABLE user"
					+ "(login VARCHAR(20) PRIMARY KEY,"
					+ "firstName VARCHAR(50) NOT NULL,"
					+ "lastName VARCHAR(50) NOT NULL,"
					+ "paswd VARCHAR(12) NOT NULL, role VARCHAR(5) NOT NULL);";
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConnection();
		}
	}
}
