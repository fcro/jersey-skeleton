package fr.youngagain.utils.database;

public class InitDB {
	public static void init() {
		TheDAO dao = DBConnector.getDAO();
//		dao.addAdmin();
//		dao.addMoi();
		dao.updateProfil("jeanraymond", true, "h", "/images/jeanraymond.jpg");
		dao.addCritere("jeanraymond", true, "t", 4, 5, 5, 1, "null");
		dao.addNews();
	}
}