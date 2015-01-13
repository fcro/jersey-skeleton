package fr.youngagain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}

	public User connect(String login, String password) {
		if (login.equals("toto") && password.equals("titi")) {
			
		}
		return null;
	}
}
