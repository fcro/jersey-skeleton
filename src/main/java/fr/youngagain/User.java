package fr.youngagain;

import java.io.File;

import fr.youngagain.utils.html.PHProcks;

public class User {
	private String login, mdp, nom, prenom, ville, role, photo, date;
	private char sexe;
	private boolean fumeur;
	private Criteres c;
	
	
	public User(String login, String mdp, char sexe, boolean fumeur, Criteres c){
		this.login = login;
		this.mdp = mdp;
		this.sexe = sexe;
		this.fumeur = fumeur;
		this.c = c;
	}
	
	public String getLogin(){
		return this.login;				
	}
	
	public String getMdp(){
		return this.mdp;
	}
	
	public boolean isFumeur(){
		return fumeur;
	}
	
	public boolean isMale(){
		return (sexe=='h');
	}
	
	public boolean isFemale(){
		return (sexe=='f');
	}
	
	public Criteres getCriteres(){
		return c;
	}
	
	public void setCriteres(Criteres c){
		this.c = c;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
