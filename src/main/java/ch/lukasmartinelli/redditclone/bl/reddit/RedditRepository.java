package ch.lukasmartinelli.redditclone.bl.reddit;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

public class RedditRepository implements Serializable {

	private ArrayList<Reddit> reddits = new ArrayList<>();
	
	public RedditRepository() {
	}
	
	public ArrayList<Reddit> getReddits() {
		return reddits;
	}
	public void setReddits(ArrayList<Reddit> r) {
		reddits = r;
	}
	public Reddit getRedditById(int id) {
		return new Reddit();
	}
}
