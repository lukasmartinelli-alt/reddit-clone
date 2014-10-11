package ch.lukasmartinelli.redditclone;

import java.util.Date;

public class Vote {
	private Date clickTime;
	private User user;
<<<<<<< HEAD
	
	public Vote(User u) {
		this.setUser(u);
		clickTime = new Date();
	}
=======

>>>>>>> 0759c7145cd756185f13a986cd38f6c15e6850b7
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
<<<<<<< HEAD
	
=======
>>>>>>> 0759c7145cd756185f13a986cd38f6c15e6850b7
	
	public Vote() {
		
	}
	
	public Vote(Date clickTime, User user) {
		setClickTime(clickTime);
		setUser(user);
	}
}
