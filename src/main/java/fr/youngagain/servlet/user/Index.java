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

@WebServlet("/index")
public class Index extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("role") == null) {
			PrintWriter out = res.getWriter();
			PHProcks.include(out, new File("./resources/includes/index/index.html"));
			if (req.getParameter("bl") != null)
				out.println("<center><ul class=\"list-group\"><li class=\"list-group-item list-group-item-danger\">Erreur d'authentification</li></ul></center></body></html>");
			PHProcks.includeFooter(out);
		} else if (session.getAttribute("role").equals("admin")) {
			res.sendRedirect("/accueilAdmin");
		} else {
			res.sendRedirect("/accueil");
		}

	}
}