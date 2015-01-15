package fr.youngagain.utils.database;

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

					+ "CREATE TABLE IF NOT EXISTS news(id SERIAL PRIMARY KEY,"
					+ "title TEXT NOT NULL,"
					+ "date VARCHAR(8) NOT NULL,"
					+ "text TEXT NOT NULL);")
	void initDB();

	@SqlQuery("SELECT role FROM user WHERE login = :login AND paswd = :paswd")
	String getRoleByLoginPswd(@Bind("login") String login, @Bind("paswd") String paswd);
	
	@SqlUpdate("INSERT INTO user VALUES('admin', 'admin', 'admin', 'superadmin', 'admin')")
	void addAdmin();
	
	@SqlUpdate("INSERT INTO user VALUES('moi', 'moi', 'moi', 'supermoi', 'user')")
	void addMoi();
	
	@SqlUpdate("INSERT INTO news(title, date, text) VALUES('Bienvenue !', '13011995', 'Ceci est un texte')")
	void addNews();
	
	@SqlQuery("SELECT title FROM news WHERE id=(SELECT MAX(id) FROM news)")
	String getNewsTitle();
	
	@SqlQuery("SELECT date FROM news WHERE id=(SELECT MAX(id) FROM news)")
	String getNewsDate();
	
	@SqlQuery("SELECT text FROM news WHERE id=(SELECT MAX(id) FROM news)")
	String getNewsTxt();
}
