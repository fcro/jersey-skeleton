package fr.youngagain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("paswd");

		if (connect(login, password) == true)
			res.sendRedirect("pageAccueil.html");
		else
			res.sendRedirect("index.html?bl=1");
	}

	private boolean connect(String login, String password) {
		return (login.equals("toto") && password.equals("titi"));
	}
}
