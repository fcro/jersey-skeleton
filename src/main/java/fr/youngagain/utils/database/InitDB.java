package fr.youngagain.utils.database;

public class InitDB {
	public static void init() {
		TheDAO dao = DBConnector.getDAO();
		dao.initDB();
		dao.addAdmin();
		dao.addMoi();
		dao.addNews();
	}
}