package fr.youngagain.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.youngagain.utils.html.PHProcks;

@WebServlet("/newsAdmin")
public class NewsAdmin extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			PHProcks.include(out, new File("resources/includes/newsAdmin.html"));
	}

}
