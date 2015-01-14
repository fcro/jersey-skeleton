package fr.youngagain.admin;

import java.sql.*;

public class ManageAccount {

	public static boolean createAccount(String nom, String prenom,
			String login, String mdp) throws SQLException /*, LoginAlreadyUsedException*/{
		Connection con = null;
		if (!loginAlreadyUsed(login)) {

			try {

				Statement stmt;

				Class.forName("nom_du_Driver"); //a changer

				String url = "url_de_la_base";
				String log = "login";
				String password = "mot_de_passe";

				con = DriverManager.getConnection(url, log, password);
				stmt = con.createStatement();

				String query = "insert into "/*TABLE_DES_USERS*/ + "values(\'" + nom
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
			//throws new LoginAlreadyUsedException();
			return false;
		}

		return true;
	}

	public static boolean loginAlreadyUsed(String log) throws SQLException {
		Connection con = null;
		boolean used = false;
		try {

			Statement stmt;
			Class.forName("nom_du_driver");	// a changer
			String url = "url_de_la_base";
			String login = "login";
			String mdp = "mot_de_passe";
			con = DriverManager.getConnection(url, login, mdp);
			stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("select login from " /*TABLE_DES_USERS*/ + "where login = \'"
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

	public static boolean deleteAccount(String login) throws SQLException /*, AccountNotFoundException*/ {

		boolean deleted = false;
		if (loginAlreadyUsed(login)) {
			Connection con = null;
			try {

				Statement stmt;

				Class.forName("nom_du_Driver"); // a changer
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
		} else {
			//throws new AccountNotFoundException();
		}
		return deleted;
	}
	
	public static boolean modifyPassword(String login, String newPassword, String confirmNewPassword, String oldPassword) throws SQLException{
		boolean changed = false;
		Connection con = null;
		if(loginAlreadyUsed(login)){
			if(newPassword.equals(confirmNewPassword)){
				try{
					if(passwordIsCorrect(login, oldPassword)){
						
						Statement stmt;

						Class.forName("nom_du_Driver"); // a changer
						String url = "url_de_la_base";
						String log = "login";
						String mdp = "mot_de_passe";
						con = DriverManager.getConnection(url, log, mdp);
						stmt = con.createStatement();
						
						String update = "update" /*TABLE-DES-USERS*/;
						update += "set mdp = " + newPassword + " where login = \'" + login +"\'";
						stmt.executeUpdate(update);
						con.close();
					}
													
				}catch(Exception e){
					e.printStackTrace();
				} finally {
					con.close();
				}
			}
			
			
			
			
			
		} else {
			//throws AccountNotFoundException
		}
		return changed;
	}
	
	public static boolean passwordIsCorrect(String login, String pwd) throws SQLException{
		Connection con = null;
		boolean correct = false;
		
		try{
			
			Statement stmt;

			Class.forName("nom_du_Driver"); // a changer
			String url = "url_de_la_base";
			String log = "login";
			String mdp = "mot_de_passe";
			con = DriverManager.getConnection(url, log, mdp);
			stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select mdp from" /*TABLE_DES_USERS*/ + " where login = \'" + login + "\'");
			String rs_mdp = rs.getString(0);
			
			if(rs_mdp.equals(pwd)){
				correct = true;
			}
			
			con.close();
		
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			con.close();
		}
		
		return correct;
		
	}

}
