package ch.lukasmartinelli.redditclone.dl;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import ch.lukasmartinelli.redditclone.beans.LoginController;
import ch.lukasmartinelli.redditclone.bl.reddit.Comment;
import ch.lukasmartinelli.redditclone.bl.reddit.Reddit;
import ch.lukasmartinelli.redditclone.bl.reddit.RedditRepository;

/**
 * Backing store for all data that needs to be persisted. Is managed by the
 * DataManager.
 */
public class DataContainer implements Serializable {
	private static final long serialVersionUID = 1L;
	public RedditRepository redditRepo;

	public DataContainer() {
	}

	/**
	 * Create a new DataContainer and populate it with sample data.
	 * @return Fully initialized DataContainer with sample data
	 */
	public static DataContainer getNew() {
		DataContainer dataContainer = new DataContainer();
		RedditRepository r = new RedditRepository();
		r.setReddits(DataContainer.createExampleReddits());
		dataContainer.redditRepo = r;

		return dataContainer;
	}
	
	public RedditRepository getRedditRepo() {
		return this.redditRepo;
	}

	private static ArrayList<Reddit> createExampleReddits() {
		ArrayList<Reddit> reddits = new ArrayList<Reddit>();
		Comment c = getCommentTree();
		for (int i = 0; i < 30; i++) {
			Reddit r = new Reddit();
			r.setTitle("Andreas Rüst geht gerne ins Schwulepuff!");
			try {
				r.setLink(new URL("http://www.20min.ch"));
			} catch (Exception e) {
			}
			r.setUser(LoginController.getCurrentUser());
			r.setCreateTime(new Date());
			r.addComment(c);
			reddits.add(r);

			r = new Reddit();
			r.setTitle("Dies ist ein Test");
			try {
				r.setLink(new URL("http://www.bluewin.ch"));
			} catch (Exception e) {
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
}
