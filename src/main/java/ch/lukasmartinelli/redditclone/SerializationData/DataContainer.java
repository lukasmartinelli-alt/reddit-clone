package ch.lukasmartinelli.redditclone.SerializationData;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import ch.lukasmartinelli.redditclone.Comment;
import ch.lukasmartinelli.redditclone.LoginController;
import ch.lukasmartinelli.redditclone.Reddit;
import ch.lukasmartinelli.redditclone.RedditRepository;
//All data you need restored after a server restart you can put here in
public class DataContainer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		Comment c = getCommentTree();
		for(int i=0;i<30;i++) {
			//Add reddit examples
			Reddit r = new Reddit();
			r.setTitle("Andreas Rüst geht gerne ins Schwulepuff!");
			try {
				r.setLink(new URL("http://www.20min.ch"));
			}catch(Exception e) {
			}
			r.setUser(LoginController.getCurrentUser());
			r.setCreateTime(new Date());
			r.addComment(c);
			reddits.add(r);
			
			r = new Reddit();
			r.setTitle("Dies ist ein Test");
			try {
				r.setLink(new URL("http://www.bluewin.ch"));
			}catch(Exception e) {
			}
			r.setUser(LoginController.getCurrentUser());
			r.setCreateTime(new Date());
			r.addComment(c);
			reddits.add(r);
		}
		return reddits;
	}
	
	private static Comment getCommentTree() {
		Comment c = new Comment();
		c.setText("Dies ist ein Kommentar zu einem Reddit.");
		c.setCreationTime(new Date());
		c.setAuthor(LoginController.getCurrentUser());
		
		Comment c2 = new Comment();
		c2.setText("Dies ist ein Kommentar zu einem Reddit.");
		c2.setCreationTime(new Date());
		c2.setAuthor(LoginController.getCurrentUser());
		c.addSubComment(c2);
		
		Comment c3 = new Comment();
		c3.setText("Dies ist ein Kommentar zu einem Reddit.");
		c3.setCreationTime(new Date());
		c3.setAuthor(LoginController.getCurrentUser());
		c.addSubComment(c3);
		return c;
	}
	
	public RedditRepository getRedditRepo() {
		return this.redditRepo;
	}
}
