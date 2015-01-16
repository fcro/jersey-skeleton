package fr.youngagain.test.matcher;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.youngagain.utils.database.DBConnector;

public class MatcherTest {
	
	
	@BeforeClass
	public void initBeforeClass(){
		DBConnector.getDAO().initDB();
		DBConnector.getDAO().addUser("totoro", "lol", "toto", "ro");
		DBConnector.getDAO().addUser("titiri", "lil", "titi", "ri");
		DBConnector.getDAO().addUser("tatara", "lal", "tata", "ra");
	}
	
	
	@Test
	public void testMatch() {
		
	}

}
