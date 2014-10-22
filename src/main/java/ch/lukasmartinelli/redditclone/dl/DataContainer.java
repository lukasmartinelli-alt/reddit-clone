package ch.lukasmartinelli.redditclone.dl;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import ch.lukasmartinelli.redditclone.beans.UserBean;
import ch.lukasmartinelli.redditclone.bl.User;
import ch.lukasmartinelli.redditclone.bl.reddit.Comment;
import ch.lukasmartinelli.redditclone.bl.reddit.Reddit;

/**
 * Backing store for all data that needs to be persisted. Is managed by the
 * DataManager.
 */
public class DataContainer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public ArrayList<Reddit> reddits = new ArrayList<>();
	public ArrayList<User> users = new ArrayList<User>();

	public DataContainer() {
	}

	/**
	 * Create a new DataContainer and populate it with sample data.
	 * @return Fully initialized DataContainer with sample data
	 */
	public static DataContainer getNew() {
		DataContainer dataContainer = new DataContainer();
		dataContainer.users = DataContainer.createExampleUsers();
		dataContainer.reddits = DataContainer.createExampleReddits(dataContainer.users.get(0));

		return dataContainer;
	}
	
	private static ArrayList<User> createExampleUsers() {
		ArrayList<User> users = new ArrayList<User>();
		
		User user1 = new User();
		user1.setLogin("myUserName");
		user1.setMail("severin.buehler@hsr.ch");
		user1.setName("Hans Ueli Hofstetter");
		user1.setPassword("homo");
		users.add(user1);
		
		User user2 = new User();
		user2.setLogin("psommer");
		user2.setMail("psommer@hsr.ch");
		user2.setName("Peter Sommerlad");
		user2.setPassword("blub");
		users.add(user2);
		
		return users;
	}

	private static ArrayList<Reddit> createExampleReddits(User exampleUser) {
		ArrayList<Reddit> reddits = new ArrayList<Reddit>();
		
		for (int i = 0; i < 2; i++) {
			Comment c = getCommentTree(exampleUser);
			Reddit r = new Reddit();
			r.setId(i);
			r.setTitle("Dorfmarkt knackt Umsatzrekord");
			try {
				r.setLink(new URL("http://www.20min.ch"));
			} catch (Exception e) {
			}
			r.setUser(exampleUser);
			r.setCreateTime(new Date());
			r.addComment(c);
			reddits.add(r);

			r = new Reddit();
			r.setId(i + 30);
			r.setTitle("Dies ist ein Test");
			try {
				r.setLink(new URL("http://www.bluewin.ch"));
			} catch (Exception e) {
			}
			r.setUser(exampleUser);
			r.setCreateTime(new Date());
			r.addComment(c);
			reddits.add(r);
		}
		return reddits;
	}

	private static Comment getCommentTree(User u) {
		Comment c = new Comment();
		c.setText("Dies ist ein Kommentar zu einem Reddit.");
		c.setCreationTime(new Date());
		c.setAuthor(u);

		Comment c2 = new Comment();
		c2.setText("Dies ist ein Kommentar zu einem Reddit.");
		c2.setCreationTime(new Date());
		c2.setAuthor(u);
		c.addSubComment(c2);

		Comment c3 = new Comment();
		c3.setText("Dies ist ein Kommentar zu einem Reddit.");
		c3.setCreationTime(new Date());
		c3.setAuthor(u);
		c.addSubComment(c3);
		return c;
	}
}
