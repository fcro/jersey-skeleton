package fr.youngagain.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.youngagain.utils.database.DBConnector;
import fr.youngagain.utils.database.TheDAO;
import fr.youngagain.utils.html.PHProcks;

@WebServlet("/profil")
public class Profil extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String login = session.getAttribute("login").toString();
		TheDAO dao = DBConnector.getDAO();
		if (session.getAttribute("login") == null)
			res.sendRedirect("/index");
		PrintWriter out = res.getWriter();
		PHProcks.includeWithTitle(out, "Profil");
		PHProcks.includePhoto(out, dao.getImageByLogin(login));
		PHProcks.includeFooter(out);
	}
}
