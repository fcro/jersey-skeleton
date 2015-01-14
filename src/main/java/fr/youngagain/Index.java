package fr.youngagain;

import java.io.BufferedReader;
import java.io.FileReader;
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
			BufferedReader br = new BufferedReader(new FileReader(
					"./resources/includes/index/index.html"));
			String buf;
			while ((buf = br.readLine()) != null)
				out.println(buf);
			if (req.getParameter("bl") == "1")
				out.println("<br><center>Erreur d'authentification</center></body></html>");
		} else if (session.getAttribute("role").equals("admin")) {
			res.sendRedirect("pageAdmin.html");
		} else {
			res.sendRedirect("pageAccueil.html");
		}

	}
}
