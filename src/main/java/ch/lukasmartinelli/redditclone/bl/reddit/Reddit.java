package ch.lukasmartinelli.redditclone.bl.reddit;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;






import ch.lukasmartinelli.redditclone.bl.TimeAgoCalculator;
import ch.lukasmartinelli.redditclone.bl.User;


public class Reddit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private User user;
	private URL link;
	private Date createTime;
	private ArrayList<Comment> comments = new ArrayList<>();
	Voter votes = new Voter();
	
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
	public int getCommentsCount() {
		int ret = 0;
		for(Comment c: comments) {
			ret += c.getSubCommentsCount();
		}
		return ret;
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
	

	public ArrayList<Comment> getComments(){
		return comments;
	}
	public Voter getVotes() {
		return votes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



}
