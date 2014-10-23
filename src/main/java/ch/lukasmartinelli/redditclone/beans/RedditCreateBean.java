package ch.lukasmartinelli.redditclone.beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import ch.lukasmartinelli.redditclone.bl.reddit.Reddit;
import ch.lukasmartinelli.redditclone.dl.DataManager;

public class RedditCreateBean implements Serializable {
	private static final long serialVersionUID = -1584203142133336546L;
	private String title;
	private String link;
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
	
	public String save() throws MalformedURLException{
		Reddit reddit = new Reddit();
		reddit.setTitle(title);
		reddit.setLink(new URL(getLink()));
		reddit.setId(12345);
		
		reddit.setUser(userBean.getCurrentUser());
		dataManager.getData().reddits.add(reddit);
		return "RedditTable.xhtml";
	}
}
