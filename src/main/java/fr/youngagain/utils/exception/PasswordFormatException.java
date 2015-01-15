package fr.youngagain.utils.exception;

public class PasswordFormatException extends Exception {
	private String message;
	public PasswordFormatException() {
		// TODO Auto-generated constructor stub
	}
	public PasswordFormatException(String message) {
		this.message=message;
	}
}
