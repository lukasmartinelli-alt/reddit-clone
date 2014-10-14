package ch.lukasmartinelli.redditclone;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

public class RedditRepository {

	private ArrayList<Reddit> reddits = new ArrayList<>();
	
	public RedditRepository() {
		for(int i=0;i<30;i++) {
			//Add reddit examples
			Reddit r = new Reddit();
			r.setTitle("Hellooo ist super");
			try {
				r.setLink(new URL("http://www.20min.ch"));
			}catch(Exception e) {
			}
			r.setUser(LoginController.getCurrentUser());
			r.setCreateTime(new Date());
			reddits.add(r);
			
			r = new Reddit();
			r.setTitle("Dies ist ein Test");
			try {
				r.setLink(new URL("http://www.bluewin.ch"));
			}catch(Exception e) {
			}
			r.setUser(LoginController.getCurrentUser());
			r.setCreateTime(new Date());
			reddits.add(r);
		}

	}
	
	public ArrayList<Reddit> getReddits() {
		return reddits;
	}
	
}
