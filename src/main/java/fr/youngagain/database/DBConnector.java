package fr.youngagain.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static Connection c = null;

	public static Connection getConnection() throws SQLException {
		try {
			if (c == null || c.isClosed()) {
				Class.forName("org.h2.Driver");
				c = DriverManager.getConnection("jdbc:h2:./youngagain");
			}
		} catch (ClassNotFoundException cnfe) {
			throw new SQLException("Échec de connexion à la base de données.");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw new SQLException("Échec de connexion à la base de données.");
		}

		return c;
	}

	public static void closeConnection() {
		try {
			c.close();
		} catch (SQLException e) {}
	}
}
