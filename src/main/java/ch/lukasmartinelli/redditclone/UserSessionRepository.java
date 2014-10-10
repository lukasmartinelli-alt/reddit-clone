package ch.lukasmartinelli.redditclone;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

/**
 * Uses an Http Session as backing store for the users
 */
public class UserSessionRepository implements UserRepository {
	private HttpSession session;
	private static String REGISTERED_USERS_ATTRIBUTE = "registeredUsers";

	/**
	 * Create a repository that will use the given session
	 * for storing the registered users
	 * @param session
	 */
	public UserSessionRepository(HttpSession session) {
		this.session = session;
	}
	
	/**
	 * Access session and return the first user that matches
	 * the given username
	 */
	@SuppressWarnings("unchecked")
	@Override
	public User getUserByName(String username) {
		ArrayList<User> registeredUsers = (ArrayList<User>) session.getAttribute(REGISTERED_USERS_ATTRIBUTE);
		for(User user: registeredUsers) {
			if(user.getName().equals(username)) {
				return user;
			}
		}
		
		//TODO: shall we throw an exception or return null?
		//I don't know the java policy for that
		return null;
	}

	/**
	 * Replaces the registered users attribute in the session
	 * with a new list where the created user is inculded
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void createUser(User user) {
		ArrayList<User> registeredUsers = (ArrayList<User>) session.getAttribute(REGISTERED_USERS_ATTRIBUTE);
		if(registeredUsers == null) {
			registeredUsers = new ArrayList<User>();
		}
		registeredUsers.add(user);
		session.setAttribute(REGISTERED_USERS_ATTRIBUTE, registeredUsers);
	}

}
