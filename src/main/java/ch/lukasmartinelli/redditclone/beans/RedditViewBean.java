package ch.lukasmartinelli.redditclone.beans;


import javax.faces.context.FacesContext;

import ch.lukasmartinelli.redditclone.bl.reddit.Comment;
import ch.lukasmartinelli.redditclone.bl.reddit.Reddit;
import ch.lukasmartinelli.redditclone.dl.DataManager;

public class RedditViewBean {
	private int id;
	private Reddit reddit;
	private String title;
	private String link;
	private DataManager dataManager;
	
	public void setLink(String link){
		this.link = link;
	}
	public String getLink(){
		return link;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return title;
	}
	
	public RedditViewBean() {
		dataManager = BeanHelper.findBean("dM");
	}
	
	public void save(){
		reddit = new Reddit();
		reddit.setTitle(title);
		reddit.setId(12345);
		
		FacesContext context = FacesContext.getCurrentInstance();
		UserBean userBean = context.getApplication().evaluateExpressionGet(context, "#{userBean}", UserBean.class);
		reddit.setUser(userBean.getCurrentUser());
		
		//TODO: set all Reddit Attributs
		dataManager.getData().reddits.add(reddit);
		
		System.out.println("Titel: " + reddit.getTitle());
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
