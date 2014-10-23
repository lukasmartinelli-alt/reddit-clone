package ch.lukasmartinelli.redditclone.beans;

import java.io.Serializable;

import ch.lukasmartinelli.redditclone.bl.User;

public class UserBean implements Serializable {
	private static final long serialVersionUID = -4059287358140732319L;
	private User currentUser;
	private String userLocale;
	
	public boolean isLoggedIn() {
		return currentUser != null;
	}
	
	public User getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(User user) {
		currentUser = user;
	}

	public String getUserLocale() {
		return userLocale;
	}

	public void setGerman() {
		userLocale = "de";
	}
	public void setEnglish() {
		userLocale = "en";
	}
}

