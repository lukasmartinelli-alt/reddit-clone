package ch.lukasmartinelli.redditclone.beans;

import ch.lukasmartinelli.redditclone.bl.reddit.Comment;
import ch.lukasmartinelli.redditclone.bl.reddit.Reddit;
import ch.lukasmartinelli.redditclone.dl.DataManager;

public class RedditViewBean {
	private int id;
	private Reddit reddit;
	private String title;
	private String link;
	
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
	
	public void save(){
		reddit.setTitle(title);
		reddit.setId(999999999);
		//TODO: set all Reddit Attributs
		DataManager.getData().reddits.add(reddit);
		for(Reddit r: DataManager.getData().reddits) {
			if(r.getId() == 999999999){
				System.out.println("found reddit:" + r.getTitle());
				break;
			}
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		for(Reddit r: DataManager.getData().reddits) {
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
