package ch.lukasmartinelli.redditclone.beans;


import java.util.Date;

import javax.faces.context.FacesContext;

import ch.lukasmartinelli.redditclone.bl.User;
import ch.lukasmartinelli.redditclone.bl.reddit.Comment;
import ch.lukasmartinelli.redditclone.bl.reddit.Reddit;
import ch.lukasmartinelli.redditclone.dl.DataManager;

public class RedditViewBean {
	private int id;
	private Reddit reddit;
	private DataManager dataManager;
	private UserBean userBean;
	private String newText;
	
	public RedditViewBean() {
		dataManager = BeanHelper.findBean("dM");
		userBean = BeanHelper.findBean("userBean");
	}
	
	public String getNewText() {
		return newText;
	}

	public void setNewText(String text) {
		this.newText = text;
	}
	
	public String addComment() {
		Comment c = new Comment();
		c.setAuthor(userBean.getCurrentUser());
		c.setCreationTime(new Date());
		c.setText(newText);
		reddit.addComment(c);
		return "RedditTable.xhtml";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		for(Reddit r: dataManager.getData().reddits) {
			if(r.getId() == id){
				reddit = r;
				break;
			}
		}
		
	}

	public Reddit getReddit() {
		return reddit;
	}

	public boolean hasComments() {
		if(reddit.getComments() == null) return false;
		return reddit.getComments().size() > 0;
	}
	public boolean hasSubComments(Comment c) {
		if(c.getSubComments() == null) return false;
		return c.getSubComments().size() > 0;
	}
	
	
}
