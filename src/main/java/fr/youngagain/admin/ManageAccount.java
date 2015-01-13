package fr.youngagain.admin;

public class ManageAccount {

	
	public static boolean createAccount(String nom, String prenom, String login, String mdp){
		/* try{
		 * Connection con = null;
		 * Statement stmt;
		 * 
		 * Class.forName("nom_du_Driver");
		 * 
		 * String url = "url_de_la_base";
		 * String login = "login";
		 * String mdp = "mot_de_passe";
		 * 
		 * con = DriverManager.getConnection(url,nom,mdp);
		 * stmt = con.createStatement();
		 * 
		 * String query = "insert into TABLE_DES_USERS values(nom, prenom, login, mdp)";
		 * 
		 * con.close();
		 * } catch (Exception e){
		 * 		e.printStackTrace();
		 * } finally {
		 * 	con.close();
		 * }
		 */
		
		return true;
	}
	
	public static boolean deleteAccount(String login){
		/* Connection con = null;
		 * 
		 * try{
		 * 
		 * Statement stmt;
		 * 
		 * Class.forName("nom_du_Driver");
		 * 
		 * String url = "url_de_la_base";
		 * String login = "login";
		 * String mdp = "mot_de_passe";
		 * 
		 * con = DriverManager.getConnection(url,nom,mdp);
		 * stmt = con.createStatement();
		 * 
		 * 
		 */
		
		String query = "select * from TABLE_DES_USERS where login=\'" + login + "\'";
		
		/*
		 * ResultSet rs = stmt.executeQuery(query);
		 * String rs_login = "";
		 * boolean login_trouvé = false;
		 * 
		 * while(rs.next() && !login_trouvé){
		 * 		rs_login = rs.getString("login");
		 * 
		 * 		if(rs_login.equals(login)
		 * 				login_trouvé = true;
		 * }
		 * 
		 * if(!login_trouvé)
		 * 		return false;
		 * 
		 * else {
		 * 		stmt.executeUpdate("delete from TABLE_DES_USERS where login = \'" + login + "\'");
		 * 		return true;
		 * }
		 * 
		 * con.close();
		 * 
		 * } catch (Exception e){
		 * 		e.printStackTrace();
		 * } finally{
		 * 		con.close();
		 * }
		 * 
		 */
		
		
		
		
		return true;
	}
	
}
