package fr.youngagain;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/test")
public class Test extends HttpServlet {
	
	private Connection con = null;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		String login = req.getParameter("login");
		String password = req.getParameter("paswd");
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:./yougagaindb");
			Statement stm = con.createStatement();
			System.out.println("sa va juskici");
			stm.executeUpdate("CREATE TABLE user(firstName TEXT NOT NULL, lastName TEXT NOT NULL, login TEXT PRIMARY KEY, paswd VARCHAR(12)) NOT NULL, role VARCHAR(5);");
			System.out.println("isiosi");
			stm.executeUpdate("INSERT INTO user(login) VALUES('test1');");
			stm.executeUpdate("INSERT INTO user(login) VALUES('test2');");
			stm.executeUpdate("INSERT INTO user(login) VALUES('test3');");
			ResultSet rs = stm.executeQuery("SELECT * FROM user");
			while (rs.next())
				out.println(rs.getString("login"));
			stm.executeUpdate("DELETE * FROM user");
			stm.executeUpdate("DROP TABLE user");
		} catch (Exception e) {
			try {
				con.close();
			} catch (Exception e1) {
				e.printStackTrace();
				e1.printStackTrace();
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
