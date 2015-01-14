package fr.youngagain;

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
}
