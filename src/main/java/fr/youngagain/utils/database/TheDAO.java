package fr.youngagain.utils.database;

import java.sql.ResultSet;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface TheDAO {
	
	@SqlUpdate("CREATE TABLE IF NOT EXISTS user"
					+ "(login VARCHAR(20) PRIMARY KEY,"
					+ "firstName VARCHAR(50) NOT NULL,"
					+ "lastName VARCHAR(50) NOT NULL,"
					+ "paswd VARCHAR(12) NOT NULL,"
					+ "dateNaiss VARCHAR(8),"
					+ "sexe VARCHAR(1),"
					+ "fumeur BOOLEAN,"
					+ "ville VARCHAR(30),"
					+ "photo VARCHAR(255),"
					+ "mail VARCHAR(60),"
					+ "role VARCHAR(20) NOT NULL);"
					
					+ "CREATE TABLE IF NOT EXISTS critereUser"
					+ "(login VARCHAR(20) PRIMARY KEY,"
					+ "acceptFumeur BOOLEAN,"
					+ "acceptSexe VARCHAR(1),"
					+ "sport TINYINT,"
					+ "culture TINYINT,"
					+ "musique TINYINT,"
					+ "cinema TINYINT,"
					+ "typeDest VARCHAR(20),"
					+ "FOREIGN KEY(login) REFERENCES USER(login));"

					+ "CREATE TABLE IF NOT EXISTS voyage"
					+ "(id INT PRIMARY KEY,"
					+ "login VARCHAR(20),"
					+ "FOREIGN KEY (login) REFERENCES USER(login));"

					+ "CREATE TABLE IF NOT EXISTS critereVoyage"
					+ "(id_voyage INT PRIMARY KEY,"
					+ "typeDest VARCHAR(20),"
					+ "lieu VARCHAR(50),"
					+ "maxPerson SMALLINT,"
					+ "login_createur VARCHAR(20));"

					+ "CREATE TABLE IF NOT EXISTS news(id SERIAL PRIMARY KEY,"
					+ "title TEXT NOT NULL,"
					+ "date VARCHAR(8) NOT NULL,"
					+ "text TEXT NOT NULL);")
	void initDB();

	@SqlUpdate("INSERT INTO USER(login, paswd, firstName, lastName, role) VALUES(:login, :paswd," +
			":firstName, :lastName, 'user')")
	void addUser(@Bind("login") String login, @Bind("paswd") String paswd, @Bind("firstName") String firstName,
			@Bind("lastName") String lastName);
	
	@SqlUpdate("INSERT INTO user(login, firstName, lastName, paswd, role) " +
			"VALUES('admin', 'admin', 'admin', 'superadmin', 'admin')")
	void addAdmin();
	
	@SqlUpdate("INSERT INTO user(login, firstName, lastName, paswd, role) " +
			"VALUES('moi', 'moi', 'moi', 'supermoi', 'user')")
	void addMoi();
	
	@SqlUpdate("INSERT INTO news(title, date, text) VALUES('Bienvenue !', '16012015', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.')")
	void addNews();

	@SqlQuery("SELECT role FROM USER WHERE login = :login AND paswd = :paswd")
	String getRoleByLoginPswd(@Bind("login") String login, @Bind("paswd") String paswd);

	@SqlQuery("SELECT login FROM USER WHERE login = :login")
	String getUserByLogin(@Bind("login") String login);

	@SqlQuery("SELECT * FROM USER INNER JOIN CRITEREUSER " +
			"WHERE USER.login = CRITEREUSER.login AND USER.login = :login")
	ResultSet getUserAndCriteresByLogin(@Bind("login") String login);

	@SqlQuery("SELECT * FROM USER INNER JOIN CRITEREUSER " +
			"WHERE USER.login = CRITEREUSER.login and USER.login <> :login")
	ResultSet getUsersAndCriteresByNotLogin(@Bind("login") String login);

	@SqlQuery("SELECT path FROM USER WHERE login = :login")
	String getImageByLogin(@Bind("login") String login);
	
	@SqlQuery("SELECT title FROM news WHERE id=(SELECT MAX(id) FROM news)")
	String getNewsTitle();
	
	@SqlQuery("SELECT date FROM news WHERE id=(SELECT MAX(id) FROM news)")
	String getNewsDate();
	
	@SqlQuery("SELECT text FROM news WHERE id=(SELECT MAX(id) FROM news)")
	String getNewsTxt();

}
