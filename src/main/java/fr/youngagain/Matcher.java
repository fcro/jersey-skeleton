package fr.youngagain;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.youngagain.utils.database.DBConnector;

public class Matcher {

	public static ArrayList<User> match(String login) throws SQLException {
		ArrayList<User> listMatch = new ArrayList<>();

		ResultSet rs = DBConnector.getDAO().getUserAndCriteresByLogin(login);

		boolean acceptFumeur = rs.getBoolean("acceptFumeur");
		int partirAvecSexe = rs.getInt("partirAvecSexe");
		int sport = rs.getInt("sport");
		int culture = rs.getInt("culture");
		int musique = rs.getInt("musique");
		int cine = rs.getInt("cine");
		Criteres c = new Criteres(acceptFumeur, partirAvecSexe, sport, culture,
				musique, cine);
		User user1 = new User(rs.getString("login"), rs.getString("mdp"), rs
				.getString("sexe").charAt(0), rs.getBoolean("fumeur"), c);
		User user2;

		rs = DBConnector.getDAO().getUsersAndCriteresByNotLogin(login);

		while (rs.next()) {
			acceptFumeur = rs.getBoolean("acceptFumeur");
			partirAvecSexe = rs.getInt("partirAvecSexe");
			sport = rs.getInt("sport");
			culture = rs.getInt("culture");
			musique = rs.getInt("musique");
			cine = rs.getInt("cine");
			c = new Criteres(acceptFumeur, partirAvecSexe, sport, culture,
					musique, cine);
			user2 = new User(rs.getString("login"), rs.getString("mdp"), rs
					.getString("sexe").charAt(0), rs.getBoolean("fumeur"), c);

			if (user1.getCriteres().isMatchable(user2)) {
				if ((user2.getCriteres().acceptFumeur())
						|| ((!user1.isFumeur() && !user1.getCriteres()
								.acceptFumeur()) && (!user2.isFumeur() && !user2
								.getCriteres().acceptFumeur()))) {

					if (user1.isMale()) {
						if (user1.getCriteres().partirAvecSexe() == 1) {
							if (user2.isMale()
									&& (user2.getCriteres().partirAvecSexe() == 1 || user2
											.getCriteres().partirAvecSexe() == 2)) {
								listMatch.add(user2);
							}
						} else if (user1.getCriteres().partirAvecSexe() == 2) {
							if (user2.getCriteres().partirAvecSexe() == 2) {
								listMatch.add(user2);
							}
						} else if (user1.getCriteres().partirAvecSexe() == 0) {
							if (user2.isFemale()
									&& (user2.getCriteres().partirAvecSexe() == 0 || user2
											.getCriteres().partirAvecSexe() == 2)) {
								listMatch.add(user2);
							}
						}
					}

					if (user1.isFemale()) {
						if (user1.getCriteres().partirAvecSexe() == 1) {
							if (user2.isMale()
									&& (user2.getCriteres().partirAvecSexe() == 0 || user2
											.getCriteres().partirAvecSexe() == 2)) {
								listMatch.add(user2);
							}
						} else if (user1.getCriteres().partirAvecSexe() == 2) {
							if (user2.getCriteres().partirAvecSexe() == 2) {
								listMatch.add(user2);
							}
						} else if (user1.getCriteres().partirAvecSexe() == 0) {
							if (user2.isFemale()
									&& (user2.getCriteres().partirAvecSexe() == 1 || user2
											.getCriteres().partirAvecSexe() == 2)) {
								listMatch.add(user2);
							}
						}
					}

				}
			}
		}

		return listMatch;
	}
}
