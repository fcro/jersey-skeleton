package fr.youngagain.servlet.admin;

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

@WebServlet("/youngagain/accueilAdmin")
public class Admin extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		if (!session.getAttribute("role").equals("admin"))
			res.sendRedirect("/youngagain/index");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		PHProcks.includeWithTitleAdmin(out, "Page d'Administration");
		PHProcks.include(out, new File("./resources/includes/admin/pageAdmin.html"));
		PHProcks.includeFooter(out);
	}
}