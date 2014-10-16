package ch.lukasmartinelli.redditclone.bl.reddit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import ch.lukasmartinelli.redditclone.bl.User;

public class Comment  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private User author;
	private Date creationTime;
	private ArrayList<Comment> subComments = new ArrayList<>();

	public void setText(String text){
		this.text = text;	
	}
	
	public String getText(){
		return text;	
	}
	
	public void addSubComment(Comment comment){
		subComments.add(comment);
	}
	
	public ArrayList<Comment> getSubComments(){
		return subComments;
	}
	public boolean getHasSubComments() {
		if(subComments==null) return false;
		return (subComments.size() > 0);
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

}
