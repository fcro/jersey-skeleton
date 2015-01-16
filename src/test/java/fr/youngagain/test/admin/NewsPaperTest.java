package fr.youngagain.test.admin;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.youngagain.News;
import fr.youngagain.admin.NewsPaper;

public class NewsPaperTest {
	NewsPaper newspaper=new NewsPaper();

	@Before
	public void initBefore(){
		newspaper.addNews(new News("toto", "toti"));
		newspaper.addNews(new News("titre", "description"));
	}
	
	@Test
	public void getNewsTest() {
		Map<String,String> testMap=newspaper.getList();
		assertEquals("toti", testMap.get("toto"));
		assertEquals("description", testMap.get("titre"));
	}
	
	@Test
	public void addNewsTest() {
		newspaper.addNews(new News("test", "add"));
		assertEquals("add", newspaper.getList().get("test"));
	}

	@Test
	public void deleteNewsTest() {
		newspaper.remove(new News("toto","toti"));
		assertEquals(null, newspaper.getList().get("toto"));
	}

	@Test
	public void editNewsTest() {
		newspaper.update(new News("toto","titi"));
		assertEquals("titi", newspaper.getList().get("toto"));
		assertNotEquals("toti",newspaper.getList().get("toto"));
		assertNotNull(newspaper.getList().get("toto"));
	}
}
