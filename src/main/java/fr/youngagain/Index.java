package fr.youngagain;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
				out.println("<br><center>Erreur d'authentification</center></body></html>");
		} else if (session.getAttribute("role").equals("admin")) {
			res.sendRedirect("pageAdmin.html");
		} else {
			res.sendRedirect("pageAccueil.html");
		}

	}
}
