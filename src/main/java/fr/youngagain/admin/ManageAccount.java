package fr.youngagain.admin;

import java.sql.*;

public class ManageAccount {

	public static boolean createAccount(String nom, String prenom,
			String login, String mdp) throws SQLException {
		Connection con = null;
		if (!loginAlreadyUsed(login)) {

			try {

				Statement stmt;

				Class.forName("nom_du_Driver");

				String url = "url_de_la_base";
				String log = "login";
				String password = "mot_de_passe";

				con = DriverManager.getConnection(url, log, password);
				stmt = con.createStatement();

				String query = "insert into TABLE_DES_USERS values(\'" + nom
						+ "\', \'" + prenom + "\', \'" + login + "\', \'" + mdp
						+ "\')";
				stmt.executeUpdate(query);
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.close();
			}
		} else {
			return false;
		}

		return true;
	}

	public static boolean loginAlreadyUsed(String log) throws SQLException {
		Connection con = null;
		boolean used = false;
		try {

			Statement stmt;

			Class.forName("nom_du_driver");
			String url = "url_de_la_base";
			String login = "login";
			String mdp = "mot_de_passe";
			con = DriverManager.getConnection(url, login, mdp);
			stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("select login from TABLE_DES_USERS where login = \'"
							+ login + "\'");

			if (rs.getString(0).equals(log)) {
				used = true;
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			con.close();
		}
		return used;

	}

	public static boolean deleteAccount(String login) throws SQLException {

		boolean deleted = false;
		if (loginAlreadyUsed(login)) {
			Connection con = null;
			try {

				Statement stmt;

				Class.forName("nom_du_Driver");

				String url = "url_de_la_base";
				String log = "login";
				String mdp = "mot_de_passe";

				con = DriverManager.getConnection(url, log, mdp);
				stmt = con.createStatement();
				
				stmt.executeUpdate("delete from TABLE_DES_USERS wher login =\'"+login+"\'");
				con.close();
				deleted = true;

			} catch (Exception e) {
				e.printStackTrace();
				deleted = false;
			} finally {
				con.close();
			}
		}
		return deleted;
	}

}
