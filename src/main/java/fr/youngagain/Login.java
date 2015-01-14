package fr.youngagain;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {

	private Connection con = null;

	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("paswd");
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:./yougagaindb");
			Statement stm = con.createStatement();
			stm.executeUpdate("CREATE TABLE IF NOT EXISTS user(firstName TEXT NOT NULL, lastName TEXT NOT NULL, login TEXT PRIMARY KEY, paswd VARCHAR(12)) NOT NULL, role VARCHAR(5);");
			stm.executeQuery("SELECT * FROM user WHERE login='" + login
					+ "' AND paswd ='" + password + "';");
			ResultSet rs = stm.getResultSet();
			if (rs.next()) {
				if (rs.getString("role").equals("admin"))
					res.sendRedirect("/panelAdmin");
				res.sendRedirect("/pageAccueil.html");
			}
			res.sendRedirect("/index?bl=1");
		} catch (Exception e) {
			try {
				con.close();
			} catch (Exception e1) {
				System.out.println(e);
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
}
