package ch.lukasmartinelli.redditclone.bl.reddit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import ch.lukasmartinelli.redditclone.bl.User;

public class Comment  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String text;
	private User author;
	private Date creationTime;
	private ArrayList<Comment> subComments = new ArrayList<>();
	private Voter votes = new Voter();
	

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
	public boolean getHasSubComments() {
		if(subComments == null) return false;
		return subComments.size() > 0;
	}
	public int getSubCommentsCount() {
		int ret = 0;
		for(Comment c: subComments) {
			ret += c.getSubCommentsCount();
		}
		ret++;
		return ret;
	}

	public Voter getVotes() {
		return votes;
	}


}
