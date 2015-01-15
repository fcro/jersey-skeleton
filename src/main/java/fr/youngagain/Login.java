package fr.youngagain;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.youngagain.utils.DBConnector;

@WebServlet("/login")
public class Login extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String login = req.getParameter("login");
		String password = req.getParameter("paswd");
		try {
			Statement stm = DBConnector.getConnection().createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM user WHERE login='" + login +"' AND paswd ='" + password + "';");
			if (rs.next()) {
				if (rs.getString("role").equals("admin")) {
					session.setAttribute("role", "admin");
					res.sendRedirect("pageAdmin.html");
				} else {
					session.setAttribute("role", "user");
					res.sendRedirect("pageAccueil.html");
				}
			} else {
				res.sendRedirect("/index?bl=1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
