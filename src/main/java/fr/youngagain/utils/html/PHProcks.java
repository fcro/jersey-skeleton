package fr.youngagain.utils.html;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class PHProcks {

	public static void include(PrintWriter out, File file ) {
		try {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String buf;
		while ((buf = br.readLine()) != null)
			out.println(buf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void includeWithTitle(PrintWriter out, String title) {
		include(out, new File("./resources/includes/header.html"));
		out.println(title);
		include(out, new File("./resources/includes/navbar.html"));
	}
	
	public static void includeWithTitleAdmin(PrintWriter out, String title) {
		include(out, new File("./resources/includes/header.html"));
		out.println(title);
		include(out, new File("./resources/includes/navbarAdmin.html"));
	}
	
	public static void includeFooter(PrintWriter out) {
		include(out, new File("./resources/includes/footer.html"));
	}
	
	public static void includePhoto(PrintWriter out, String path) {
		include(out, new File("profil1.html"));
		out.println(path);
		include(out, new File("profil2.html"));
	}
}
