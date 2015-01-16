package fr.youngagain.admin;


import java.util.HashMap;

import java.util.Map;

import fr.youngagain.News;

public class NewsPaper {
	private Map <String,String> news = new HashMap <String,String>();
	
	public NewsPaper() {
		// TODO Auto-generated constructor stub
	}
	
	public Map<String,String> getList(){
		return news;
	}
	
	public void addNews(News newNews){
		news.put(newNews.getTitre(),newNews.getDescription());		
	}
	
	public void remove(News oldNews){
		news.remove(oldNews.getTitre());
	}
	
	public void update(News upNews){
		news.put(upNews.getTitre(), upNews.getDescription());
	}
	
	
}
