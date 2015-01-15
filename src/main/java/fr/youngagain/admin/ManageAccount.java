//package fr.youngagain.admin;
//
//import java.sql.*;
//
//import fr.youngagain.utils.AccountNotFoundException;
//import fr.youngagain.utils.DBConnector;
//import fr.youngagain.utils.LoginAlreadyUsedException;
//import fr.youngagain.utils.PasswordFormatException;
//import fr.youngagain.utils.TheDAO;
//
//public class ManageAccount {
//
//	public static boolean createAccount(String nom, String prenom,
//			String login, String mdp) throws LoginAlreadyUsedException{
//
//		if (!loginAlreadyUsed(login)) {
//			DBConnector.getDAO().addUser(login, mdp, prenom, nom);
//		} else {
//			throw new LoginAlreadyUsedException();
//		}
//
//		return true;
//	}
//
//	public static boolean loginAlreadyUsed(String login) {
//		return (DBConnector.getDAO().getUserByLogin(login).equals(login));
//	}
//
//	public static boolean deleteAccount(String login) throws AccountNotFoundException{
//
//		boolean deleted = false;
//		if (loginAlreadyUsed(login)) {
//
//			try {
//
//				Statement stmt = DBConnector.getHandler().createStatement();
//
//				stmt.executeUpdate("delete from TABLE_DES_USERS wher login =\'"
//						+ login + "\'");
//
//				deleted = true;
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				deleted = false;
//			} finally {
//				DBConnector.closeConnection();
//			}
//		} else {
//			throw new AccountNotFoundException();
//		}
//		return deleted;
//	}
//
//	public static boolean modifyPassword(String login, String newPassword,
//			String confirmNewPassword, String oldPassword) throws AccountNotFoundException, PasswordFormatException  {
//		boolean changed = false;
//
//		if (loginAlreadyUsed(login)) {
//			if (newPassword.equals(confirmNewPassword)) {
//				try {
//					if (passwordIsCorrect(login, oldPassword)) {
//
//						Statement stmt = DBConnector.getHandler()
//								.createStatement();
//
//						String update = "update" /* TABLE-DES-USERS */;
//						update += "set mdp = " + newPassword
//								+ " where login = \'" + login + "\'";
//						stmt.executeUpdate(update);
//
//					}
//					else{
//						throw new PasswordFormatException();
//					}
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					DBConnector.closeConnection();
//				}
//			}
//			else{
//				throw new PasswordFormatException();
//			}
//		} else {
//			throw new AccountNotFoundException();
//		}
//		return changed;
//	}
//
//	public static boolean passwordIsCorrect(String login, String pwd)
//	{
//		boolean correct = false;
//
//		try {
//
//			Statement stmt = DBConnector.getHandler().createStatement();
//
//			ResultSet rs = stmt.executeQuery("select mdp from" /* TABLE_DES_USERS */
//					+ " where login = \'" + login + "\'");
//
//			if (rs.next()) {
//				if (rs.getString("mdp").equals(pwd)) {
//					correct = true;
//				}
//			}
//
//
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBConnector.closeConnection();
//		}
//
//		return correct;
//
//	}
//
//	public static boolean blockAccount(String login)  {
//
//		boolean blocked = true;
//		if (loginAlreadyUsed(login)) {
//			try {
//				Statement stmt = DBConnector.getHandler().createStatement();
//				String query = "UPDATE " /* TABLE_DES_USERS */
//						+ " SET blocked = true WHERE login = \'" + login + "\'";
//				stmt.executeUpdate(query);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				blocked = false;
//			} finally {
//				DBConnector.closeConnection();			}
//		}
//
//		return blocked;
//	}
//
//	public static boolean sendWarning(String login) {
//		boolean warned = true;
//
//		if(loginAlreadyUsed(login)){
//			try{
//
//				Statement stmt = DBConnector.getHandler().createStatement();
//
//				ResultSet rs = stmt.executeQuery("SELECT warnings FROM "+ /*TABLE_DES_USERS*/ " user WHERE login = \'" + login + "\'");
//
//				if(rs.next()){
//					int warning = rs.getInt("warnings") + 1;
//					stmt.executeQuery("UPDATE user SET warnings = "+ warning +" WHERE login = \'" + login + "\'");
//
//				} else {
//					stmt.executeQuery("UPDATE user SET warnings = 1 WHERE login = \'" + login + "\'");
//				}
//
//			} catch (Exception e){
//				e.printStackTrace();
//				warned = false;
//
//			} finally {
//				DBConnector.closeConnection();
//			}
//		}
//		return warned;
//	}
//}
