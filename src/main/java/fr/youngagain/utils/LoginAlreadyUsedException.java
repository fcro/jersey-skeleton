package fr.youngagain.utils;

public class LoginAlreadyUsedException extends Exception {
	private String message;
	public LoginAlreadyUsedException() {
		// TODO Auto-generated constructor stub
	}
	public LoginAlreadyUsedException(String message) {
		this.message=message;
	}
}
