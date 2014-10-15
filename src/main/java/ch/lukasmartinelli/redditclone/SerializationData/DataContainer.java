package ch.lukasmartinelli.redditclone.SerializationData;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import ch.lukasmartinelli.redditclone.LoginController;
import ch.lukasmartinelli.redditclone.Reddit;
import ch.lukasmartinelli.redditclone.RedditRepository;
//All data you need restored after a server restart you can put here in
public class DataContainer implements Serializable{
	public RedditRepository redditRepo;
	
	public DataContainer() {
		//Has to remain empty
	}
	public static DataContainer getNew() {
		/*
		 * Method to create a new DataContainer 
		 * Is only used if no file to deserialize was found
		 * Put some example data's here in
		 */
		DataContainer data = new DataContainer();
		
		//Put here your InitializeCode
		RedditRepository r = new RedditRepository();
		r.setReddits(DataContainer.createExampleReddits());
		data.redditRepo = r;
		
		
		return data;
	}
	
	private static ArrayList<Reddit> createExampleReddits() {
		ArrayList<Reddit> reddits = new ArrayList<Reddit>();
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
		return reddits;
	}
	public RedditRepository getRedditRepo() {
		return this.redditRepo;
	}
}
