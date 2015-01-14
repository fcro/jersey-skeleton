package fr.youngagain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class Index extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		BufferedReader br = new BufferedReader(new FileReader("./resources/includes/index/index.html"));
		String buf;
		while ((buf = br.readLine()) != null)
			out.println(buf);
		if (req.getParameter("bl") == "1")
			out.println("<br><center><span style=\"color:red;\">Erreur d'authentification</span></center></body></html>");
		
	}

}
