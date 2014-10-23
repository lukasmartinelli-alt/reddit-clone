package ch.lukasmartinelli.redditclone.dl;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import ch.lukasmartinelli.redditclone.bl.User;
import ch.lukasmartinelli.redditclone.bl.reddit.Comment;
import ch.lukasmartinelli.redditclone.bl.reddit.Reddit;

/**
 * Backing store for all data that needs to be persisted. Is managed by the
 * DataManager.
 */
public class DataContainer implements Serializable {
	private static final long serialVersionUID = 804787552520801955L;
	public ArrayList<Reddit> reddits = new ArrayList<>();
	public ArrayList<User> users = new ArrayList<User>();

	public DataContainer() {
	}

	/**
	 * Create a new DataContainer and populate it with sample data.
	 * @return Fully initialized DataContainer with sample data
	 * @throws MalformedURLException 
	 */
	public static DataContainer getNew() throws MalformedURLException {
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

	private static ArrayList<Reddit> createExampleReddits(User exampleUser) throws MalformedURLException {
		ArrayList<Reddit> reddits = new ArrayList<Reddit>();
		
		Comment comment1 = getCommentTree(exampleUser);		
		Reddit reddit1 = new Reddit();
		reddit1.setTitle("Dorfmarkt knackt Umsatzrekord");
		reddit1.setLink(new URL("http://www.20min.ch"));		
		reddit1.setUser(exampleUser);
		reddit1.setCreateTime(new Date());
		reddit1.addComment(comment1);
		reddits.add(reddit1);

		Comment comment2 = getCommentTree(exampleUser);
		Reddit reddit2 = new Reddit();
		reddit2.setTitle("Dies ist ein Test");
		reddit2.setLink(new URL("http://www.bluewin.ch"));
		reddit2.setUser(exampleUser);
		reddit2.setCreateTime(new Date());
		reddit2.addComment(comment2);
		reddits.add(reddit2);
			
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
