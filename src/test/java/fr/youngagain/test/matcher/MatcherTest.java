package fr.youngagain.test.matcher;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.youngagain.Criteres;
import fr.youngagain.Matcher;
import fr.youngagain.User;
import fr.youngagain.utils.database.DBConnector;

public class MatcherTest {
	
	
	@BeforeClass
	public static void initBeforeClass(){
	
		DBConnector.getDAO().initDB();
		DBConnector.getDAO().addUser("toto", "lol", "toto", "ro");
		DBConnector.getDAO().addUser("titi", "lil", "titi", "ri");
		DBConnector.getDAO().addUser("tata", "lal", "tata", "ra");
		DBConnector.getDAO().updateProfil("titi", true, "h", null);
		DBConnector.getDAO().addCritere("titi", true, "t", 1, 5, 4, 2, "berlin");
		DBConnector.getDAO().updateProfil("toto", true, "f", null);
		DBConnector.getDAO().addCritere("toto", false, "h", 5, 1, 2, 5, "paris");
		DBConnector.getDAO().updateProfil("tata", true, "h", null);
		DBConnector.getDAO().addCritere("tata", true, "t", 1, 5, 4, 2, "lille");
	}
	

	
	@Test
	public void testMatch() throws SQLException {
		ArrayList<User> testArray=Matcher.match("toto");
		ArrayList<User> temoin=new ArrayList<User>();
		ResultSet rs = DBConnector.getDAO().getUserAndCriteresByLogin("tata");

		boolean acceptFumeur = rs.getBoolean("acceptFumeur");
		char partirAvecSexe = rs.getString("acceptSexe").charAt(0);
		int sport = rs.getInt("sport");
		int culture = rs.getInt("culture");
		int musique = rs.getInt("musique");
		int cine = rs.getInt("cinema");
		Criteres c = new Criteres(acceptFumeur, partirAvecSexe, sport, culture,
				musique, cine);
		User user1 = new User(rs.getString("login"), rs.getString("paswd"), rs
				.getString("sexe").charAt(0), rs.getBoolean("fumeur"), c);
		temoin.add(user1);
		assertEquals(temoin.toString(),testArray.toString() );
		
	}
	
	

}
