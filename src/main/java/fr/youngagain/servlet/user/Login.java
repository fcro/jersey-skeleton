package fr.youngagain.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.youngagain.utils.database.DBConnector;
import fr.youngagain.utils.database.TheDAO;

@WebServlet("/youngagain/login")
public class Login extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String login = req.getParameter("login");
		String password = req.getParameter("paswd");

		TheDAO dao = DBConnector.getDAO();
		String role = dao.getRoleByLoginPswd(login, password);

		if (role != null) {
			if (role.equals("admin")) {
				session.setAttribute("role", "admin");
				res.sendRedirect("/youngagain/accueilAdmin");
			} else {
				session.setAttribute("role", "user");
				session.setAttribute("login", login);
				res.sendRedirect("/youngagain/accueil");
			}
		} else {
			res.sendRedirect("/youngagain/index?bl=1");
		}
}


}
