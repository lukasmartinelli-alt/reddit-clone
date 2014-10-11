package ch.lukasmartinelli.redditclone;

import java.util.Date;

public class Vote {
	private Date clickTime;
	private User user;

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
	
	public Vote() {
		
	}
	
	public Vote(Date clickTime, User user) {
		setClickTime(clickTime);
		setUser(user);
	}
}
