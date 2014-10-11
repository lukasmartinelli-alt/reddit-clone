package ch.lukasmartinelli.redditclone;

import java.util.Date;


public class UpVote extends Vote {
	public UpVote(Date clickTime, User user) {
		super(clickTime, user);
	}
public UpVote(User u) {
		super(u);
		// TODO Auto-generated constructor stub
	}

}
