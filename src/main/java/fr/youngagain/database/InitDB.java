package fr.youngagain.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDB {
	public void init() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.h2.Driver");
			c = DriverManager.getConnection("jdbc:h2:youngagain");
			stmt= c.createStatement();
			String query = "CREATE TABLE USER"
					+ "(LOGIN TEXT PRIMARY KEY,"
					+ "FIRSTNAME TEXT NOT NULL,"
					+ "LASTNAME TEXT NOT NULL,"
					+ "PASWD VARCHAR(12) NOT NULL);";
			stmt.executeUpdate(query);
		} catch (SQLException | ClassNotFoundException e1) {
			e1.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
