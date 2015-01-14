package fr.youngagain.admin;

import java.sql.*;

import fr.youngagain.database.DBConnector;

public class ManageAccount {

	public static boolean createAccount(String nom, String prenom,
			String login, String mdp) throws SQLException /*
														 * ,
														 * LoginAlreadyUsedException
														 */{
		Connection con = null;
		if (!loginAlreadyUsed(login)) {

			try {

				Statement stmt = DBConnector.getConnection().createStatement();

				String query = "insert into "/* TABLE_DES_USERS */+ "values(\'"
						+ nom + "\', \'" + prenom + "\', \'" + login + "\', \'"
						+ mdp + "\')";
				stmt.executeUpdate(query);
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				con.close();
			}
		} else {
			// throws new LoginAlreadyUsedException();
			return false;
		}

		return true;
	}

	public static boolean loginAlreadyUsed(String login) throws SQLException {
		Connection con = null;
		boolean used = false;
		try {

			Statement stmt = DBConnector.getConnection().createStatement();

			ResultSet rs = stmt.executeQuery("select login from " /* TABLE_DES_USERS */
					+ "where login = \'" + login + "\'");

			if (rs.next()) {
				if (rs.getString("login").equals(login)) {
					used = true;
				}
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

	public static boolean deleteAccount(String login) throws SQLException /*
																		 * ,
																		 * AccountNotFoundException
																		 */{

		boolean deleted = false;
		if (loginAlreadyUsed(login)) {
			Connection con = null;
			try {

				Statement stmt = DBConnector.getConnection().createStatement();

				stmt.executeUpdate("delete from TABLE_DES_USERS wher login =\'"
						+ login + "\'");
				con.close();
				deleted = true;

			} catch (Exception e) {
				e.printStackTrace();
				deleted = false;
			} finally {
				con.close();
			}
		} else {
			// throws new AccountNotFoundException();
		}
		return deleted;
	}

	public static boolean modifyPassword(String login, String newPassword,
			String confirmNewPassword, String oldPassword) throws SQLException {
		boolean changed = false;
		Connection con = null;
		if (loginAlreadyUsed(login)) {
			if (newPassword.equals(confirmNewPassword)) {
				try {
					if (passwordIsCorrect(login, oldPassword)) {

						Statement stmt = DBConnector.getConnection()
								.createStatement();

						String update = "update" /* TABLE-DES-USERS */;
						update += "set mdp = " + newPassword
								+ " where login = \'" + login + "\'";
						stmt.executeUpdate(update);
						con.close();
					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					con.close();
				}
			}
		} else {
			// throws AccountNotFoundException
		}
		return changed;
	}

	public static boolean passwordIsCorrect(String login, String pwd)
			throws SQLException {
		Connection con = null;
		boolean correct = false;

		try {

			Statement stmt = DBConnector.getConnection().createStatement();

			ResultSet rs = stmt.executeQuery("select mdp from" /* TABLE_DES_USERS */
					+ " where login = \'" + login + "\'");

			if (rs.next()) {
				if (rs.getString("mdp").equals(pwd)) {
					correct = true;
				}
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return correct;

	}

	public static boolean blockAccount(String login) {
		return true;
	}

}
