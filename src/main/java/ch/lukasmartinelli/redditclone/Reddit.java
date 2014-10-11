package ch.lukasmartinelli.redditclone;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class Reddit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titel;
	private User user;
	private URL link;
	private Date createTime;
	private ArrayList<Comment> comments = new ArrayList<>();
	private ArrayList<UpVote> upVotes = new ArrayList<>();
	private ArrayList<DownVote> downVotes = new ArrayList<>();
	
	public Reddit(){};
	
	public Reddit(String titel, User user){
		this.titel = titel;
		this.setUser(user);
	}
	
	public void setTitel(String titel){
		this.titel = titel;
	}
	public String getTitel(){
		return titel;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean hasCurrentUserUpvoted() {
		User currentUser = LoginController.getCurrentUser();
		
		if(currentUser == null) return false;
		
		for(UpVote vote : getUpVotes()) {
			if(vote.getUser().getName() == currentUser.getName()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasCurrentUserDownvoted() {
		User currentUser = LoginController.getCurrentUser();
		
		if(currentUser == null) return false;
		
		for(DownVote vote : getDownVotes()) {
			if(vote.getUser().getName() == currentUser.getName()) {
				return true;
			}
		}
		return false;
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

	public ArrayList<UpVote> getUpVotes() {
		return upVotes;
	}
	public void addUpVote(UpVote upVotes) {
		this.upVotes.add(upVotes);
	}

	public ArrayList<DownVote> getDownVotes() {
		return downVotes;
	}
	public void addDownVotes(DownVote downVotes) {
		this.downVotes.add(downVotes);
	}

	public int getVotesCount() {
		return upVotes.size() - downVotes.size();
	}

	public void upVote() {
		UpVote vote = new UpVote(new Date(), LoginController.getCurrentUser());
		addUpVote(vote);
		System.out.println("upVote reddit");
	}
	public void downVote() {
		DownVote vote = new DownVote(new Date(), LoginController.getCurrentUser());
		addDownVotes(vote);
		System.out.println("downVote reddit");
	}
}
