package fr.youngagain;

public class Criteres {
	private boolean acceptFumeur;
	private int sport, cine, musique, culture;
	private char partirAvecSexe;
	/*
	 * partirAvecSexe
	 * f= avec femmes uniquement
	 * h= avec hommes uniquement
	 * t= peu importe
	 * 
	 * sport, cine, musique et culture : note de 1 à 5
	 * 1= pas interressé
	 * 5= très interressé 
	 *  
	 */

	public Criteres(boolean acceptFumeur, char partirAvecSexe, int sport,
			int culture, int musique, int cine) {
		this.acceptFumeur = acceptFumeur;
		this.partirAvecSexe = partirAvecSexe;
		this.sport = sport;
		this.culture = culture;
		this.musique = musique;
		this.cine = cine;
	}

	public boolean acceptFumeur() {
		return this.acceptFumeur;
	}

	public int partirAvecSexe() {
		return this.partirAvecSexe;
	}

	public int getSport() {
		return sport;
	}

	public int getCulture() {
		return culture;
	}

	public int getMusique() {
		return musique;
	}

	public int getCine() {
		return cine;
	}

	public boolean isMatchable(User u) {
		boolean matchable = true;
		if(!(sport - u.getCriteres().getSport() <= 3) || !(sport - u.getCriteres().getSport() >= -2)){
			matchable = false;
		}
		if(!(cine - u.getCriteres().getCine() <= 3) || !(cine - u.getCriteres().getCine() >= -2)){
			matchable = false;
		}
		if(!(musique - u.getCriteres().getMusique() <= 3) || !(musique - u.getCriteres().getMusique() >= -2)){
			matchable = false;
		}
		if(!(culture - u.getCriteres().getCulture() <= 3) || !(culture - u.getCriteres().getCulture() >= -2)){
			matchable = false;
		}
		return matchable;
		
	}
}
