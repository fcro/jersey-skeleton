package fr.youngagain.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet ("/manageNews")
public class ManageNews extends HttpServlet {
	private static NewsPaper news=new NewsPaper();
	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String s = req.getParameter("act");
		if(s.equals("add")){
			news.addNews(new News());
		}
		if(s.equals("del")){
			news.remove(new News());
		}
		if(s.equals("up")){
			news.update(new News());
		}
	res.sendRedirect("newsAdmin.html");
	}
}
