package fr.youngagain;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import javassist.bytecode.Descriptor.Iterator;

import fr.youngagain.utils.database.DBConnector;

public class Matcher {

	public static ArrayList<User> match(String login) throws SQLException {
		ArrayList<User> listMatch = new ArrayList<>();

		User user1 = DBConnector.getDAO().getUserByLogin(login);
		Criteres c = DBConnector.getDAO().getCriteresByLogin(login);
		user1.setCriteres(c);
		User user2;
		
		ArrayList<User> list = DBConnector.getDAO().getUserByNotLogin(login);
		for(int i = 0; i < list.size();i++){
			user2 = list.get(i);
			user2.setCriteres(DBConnector.getDAO().getCriteresByLogin(user2.getLogin()));
		

			if (user1.getCriteres().isMatchable(user2)) {
				if ((user2.getCriteres().acceptFumeur())
						|| ((!user1.isFumeur() && !user1.getCriteres()
								.acceptFumeur()) && (!user2.isFumeur() && !user2
								.getCriteres().acceptFumeur()))) {

					if (user1.isMale()) {
						if (user1.getCriteres().partirAvecSexe() == 'h') {
							if (user2.isMale()
									&& (user2.getCriteres().partirAvecSexe() == 'h' || user2
											.getCriteres().partirAvecSexe() == 't')) {
								listMatch.add(user2);
							}
						} else if (user1.getCriteres().partirAvecSexe() == 't') {
							if (user2.getCriteres().partirAvecSexe() == 't') {
								listMatch.add(user2);
							}
						} else if (user1.getCriteres().partirAvecSexe() == 'f') {
							if (user2.isFemale()
									&& (user2.getCriteres().partirAvecSexe() == 'f' || user2
											.getCriteres().partirAvecSexe() == 't')) {
								listMatch.add(user2);
							}
						}
					}

					if (user1.isFemale()) {
						if (user1.getCriteres().partirAvecSexe() == 'h') {
							if (user2.isMale()
									&& (user2.getCriteres().partirAvecSexe() == 'f' || user2
											.getCriteres().partirAvecSexe() == 't')) {
								listMatch.add(user2);
							}
						} else if (user1.getCriteres().partirAvecSexe() == 't') {
							if (user2.getCriteres().partirAvecSexe() == 't') {
								listMatch.add(user2);
							}
						} else if (user1.getCriteres().partirAvecSexe() == 'f') {
							if (user2.isFemale()
									&& (user2.getCriteres().partirAvecSexe() == 'h' || user2
											.getCriteres().partirAvecSexe() == 't')) {
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
