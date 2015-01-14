package fr.youngagain.database;

import java.sql.SQLException;
import java.sql.Statement;

public class InitDB {
	public static void init() {
		Statement stmt = null;
		try {
			stmt = DBConnector.getConnection().createStatement();
			String query = "CREATE TABLE USER"
					+ "(LOGIN VARCHAR(20) PRIMARY KEY,"
					+ "FIRSTNAME VARCHAR(50) NOT NULL,"
					+ "LASTNAME VARCHAR(50) NOT NULL,"
					+ "PASWD VARCHAR(12) NOT NULL);";
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnector.closeConnection();
		}
	}
}
