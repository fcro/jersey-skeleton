package fr.youngagain.servlet.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/accountAdmin")
public class AccountAdmin extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		fr.youngagain.utils.html.PHProcks.include(out, new File("resources/includes/newsAdmin.html"));
	}
}
