package fr.youngagain.admin;

public class News {
	private String titre;
	private String description;
	
	public News() {
		// TODO Auto-generated constructor stub
	}
	public News(String titre, String description){
		this.titre=titre;
		this.description=description;
	}
	public String getTitre() {
		
		return titre;
	}
	public String getDescription(){
		return description;
		
	}
}
