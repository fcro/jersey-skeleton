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

import fr.youngagain.utils.database.DBConnector;
import fr.youngagain.utils.database.TheDAO;
import fr.youngagain.utils.html.PHProcks;

@WebServlet("/accueil")
public class Home extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter out = res.getWriter();
		if (session.getAttribute("login") == null)
			res.sendRedirect("/index");
		PHProcks.includeWithTitle(out, "Accueil");
		PHProcks.include(out, new File("./resources/includes/home/pageAccueil.html"));
		try {
			TheDAO dao = DBConnector.getDAO();
			boolean isPresent = (dao.getNewsTitle() != null);
			if (isPresent) {
				String title = dao.getNewsTitle();
				String bufDate = dao.getNewsDate();
				String date = bufDate.substring(0, 2) + '-'
						+ bufDate.substring(2, 4) + '-' + bufDate.substring(4);
				String text = dao.getNewsTxt();
				out.println(title + "</h1><h2>" + date + "</h2><p>" + text
						+ "</p></div></div>");
			} else {
				out.println("Bienvenue </h1><h2>13-01-1995</h2><p>Ceci est un texte mais pas le bon pour que ça marche</p></div></div></body></html>");
			}
			PHProcks.includeFooter(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
