package ch.lukasmartinelli.redditclone.beans;

import ch.lukasmartinelli.redditclone.bl.User;
import ch.lukasmartinelli.redditclone.dl.DataManager;

public class UserBean {
	private User currentUser;
	
	public boolean isLoggedIn() {
		return currentUser != null;
	}
	
	public User getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(User user) {
		currentUser = user;
	}
}

