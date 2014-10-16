package ch.lukasmartinelli.redditclone.beans;

import ch.lukasmartinelli.redditclone.Reddit;

public class RedditViewBean {
	private int id;
	private Reddit reddit;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reddit getReddit() {
		return reddit;
	}

	public void setReddit(Reddit reddit) {
		this.reddit = reddit;
	}

	
}
