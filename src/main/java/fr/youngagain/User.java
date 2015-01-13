package fr.youngagain;

public class User {
	private String login;
	private String password;
	private String sexe;

	public User() {}

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public User(String login, String password, String sexe) {
		this.login = login;
		this.password = password;
		this.sexe = sexe;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String toString() {
		return login + ": " + password;
	}
}
