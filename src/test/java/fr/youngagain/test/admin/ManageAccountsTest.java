package fr.youngagain.test.admin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.youngagain.admin.ManageAccount;

public class ManageAccountsTest {

	@Test
	public void createAccountTest() {
		assertTrue(createAccount("Dupont", "Gabozumeu", "dupontg", "password"));
	}

	@Test
	public void deleteAccountTest() {
		assertFalse(deleteAccount("totod"));
		createAccount("Dumond", "toto", "totod", "pswd");
		assertTrue(deleteAccount("totod"));
		assertFalse(deleteAccount("totod"));
	}

	@Test
	public void modifyAccountPasswordTest() {
		createAccount("Chose", "Truc", "mach", "ps");
		assertTrue(modifyPassword("mach", "peuceu", "peuceu", "ps"));
	}

	@Test(expected=PasswordFormatException.class)
	public void modifyAccountPasswordTest() {
		
	}

	@Test
	public void addAccountWarningTest() {
		fail("Not yet implemented");
	}

	@Test
	public void createProfileTest() {
		fail("Not yet implemented");
	}

	@Test
	public void blockAccountTest() {
		fail("Not yet implemented");
	}
}
