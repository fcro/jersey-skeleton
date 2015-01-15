package fr.youngagain.utils.database;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcConnectionPool;
import org.skife.jdbi.v2.DBI;

public class DBConnector {

	private static TheDAO dao = null;
	private static DBI dbi = null;

	public static TheDAO getDAO() {
		if (dbi == null || dao == null) {
			DataSource ds = JdbcConnectionPool.create("jdbc:h2:./youngagain", "yadb", "thesuperdbpassword");
			DBI dbi = new DBI(ds);
			dao = dbi.open(TheDAO.class);
		}

		return dao;
	}
	
}
