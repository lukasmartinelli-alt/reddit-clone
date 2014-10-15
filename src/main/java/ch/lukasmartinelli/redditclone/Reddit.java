package ch.lukasmartinelli.redditclone;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;


import ch.lukasmartinelli.redditclone.vote.VoteController;


public class Reddit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private User user;
	private URL link;
	private Date createTime;
	private ArrayList<Comment> comments = new ArrayList<>();
	VoteController voteController = new VoteController();
	
	public Reddit(){
	
	}
	
	public Reddit(String titel, User user){
		this.title = titel;
		this.setUser(user);
	}
	
	public void setTitle(String titel){
		this.title = titel;
	}
	public String getTitle(){
		return title;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	

	public URL getLink() {
		return link;
	}
	public void setLink(URL link) {
		this.link = link;
	}

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public void addComment(Comment comment){
		comments.add(comment);
	}
	public int getCommentsCount() {
		return comments.size();
	}
	public ArrayList<Comment> getComments(){
		return comments;
	}
	public VoteController getVoteController() {
		return voteController;
	}



}
