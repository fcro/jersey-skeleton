package fr.youngagain.servlet.user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.youngagain.utils.html.PHProcks;

@WebServlet("/messagerie")
public class Messagerie extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter out = res.getWriter();
		if (session.getAttribute("login") == null)
			res.sendRedirect("/index");
		PHProcks.includeWithTitle(out, "Messagerie");
		PHProcks.include(out, new File("./resources/includes/home/messagerie.html"));
		PHProcks.includeFooter(out);
	}

}
