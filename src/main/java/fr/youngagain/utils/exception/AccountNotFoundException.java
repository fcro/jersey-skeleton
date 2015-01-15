package fr.youngagain.utils.exception;

public class AccountNotFoundException extends Exception {
	private String message;
	public AccountNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public AccountNotFoundException(String message) {
		this.message=message;
	}
	
}
