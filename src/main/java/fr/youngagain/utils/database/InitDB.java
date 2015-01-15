package fr.youngagain.utils.database;

import java.sql.SQLException;
import java.sql.Statement;

public class InitDB {
	public static void init() {
		TheDAO dao = DBConnector.getDAO();
		dao.initDB();
		dao.addAdmin();
		dao.addMoi();
		dao.addNews();
	}
}
