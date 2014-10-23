package ch.lukasmartinelli.redditclone.beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import ch.lukasmartinelli.redditclone.bl.User;
import ch.lukasmartinelli.redditclone.bl.reddit.Reddit;
import ch.lukasmartinelli.redditclone.dl.DataManager;

public class RedditCreateBean implements Serializable {
	private static final long serialVersionUID = -1584203142133336546L;
	private String title;
	private String link;
	private String message;
	private DataManager dataManager;
	private UserBean userBean;
	
	public RedditCreateBean() {
		this.dataManager = BeanHelper.findBean("dM");
		this.userBean = BeanHelper.findBean("userBean");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String save() throws MalformedURLException{
		User currentUser = userBean.getCurrentUser();
		if(currentUser == null) return null;
		Reddit reddit = new Reddit();
		reddit.setTitle(title);
		try {
			
			URL url = new URL(getLink());
			reddit.setLink(url);
			reddit.setCreateTime(new Date());
			reddit.setUser(currentUser);
			dataManager.getData().reddits.add(reddit);
			return "RedditTable.xhtml";
			
		} catch (MalformedURLException e) {
			setMessage("URL is not vaild. Example: http://www.google.ch");
			return null;
		}
		
		

	}
}
