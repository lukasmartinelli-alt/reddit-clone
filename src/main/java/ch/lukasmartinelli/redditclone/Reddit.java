package ch.lukasmartinelli.redditclone;

import java.util.ArrayList;

public class Reddit {
	private String titel;
	private User user;
	private ArrayList<Comment> comments = new ArrayList<>();
	
	public Reddit(String titel, User user){
		this.titel = titel;
		this.user = user;
	}
	
	public void setTitel(String titel){
		this.titel = titel;
	}
	
	public String getTitel(){
		return titel;
	}
	
	public void addComment(Comment comment){
		comments.add(comment);
	}
	
	public ArrayList<Comment> getComments(){
		return comments;
	}

}
