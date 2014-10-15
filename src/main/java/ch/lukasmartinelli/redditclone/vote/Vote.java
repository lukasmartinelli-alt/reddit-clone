package ch.lukasmartinelli.redditclone.vote;

import java.io.Serializable;
import java.util.Date;

import ch.lukasmartinelli.redditclone.User;

public class Vote implements Serializable {
	private Date clickTime;
	private User user;
	
	public Vote() {
		
	}
	public Vote(User u) {
		this.setUser(u);
		clickTime = new Date();
	}
	public Vote(Date clickTime, User user) {
		setClickTime(clickTime);
		setUser(user);
	}

	public Date getClickTime() {
		return clickTime;
	}

	public void setClickTime(Date clickTime) {
		this.clickTime = clickTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	

}
