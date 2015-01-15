package fr.youngagain.utils;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface TheDAO {
	@SqlUpdate("CREATE TABLE user"
					+ "(login VARCHAR(20) PRIMARY KEY,"
					+ "firstName VARCHAR(50) NOT NULL,"
					+ "lastName VARCHAR(50) NOT NULL,"
					+ "paswd VARCHAR(12) NOT NULL, role VARCHAR(5) NOT NULL)")
	void initDB();

	@SqlQuery("SELECT role FROM user WHERE login = :login AND paswd = :paswd")
	String getRoleByLoginPswd(@Bind("login") String login, @Bind("paswd") String paswd);
}
