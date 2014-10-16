package ch.lukasmartinelli.redditclone.bl.reddit;

import java.util.Date;

import ch.lukasmartinelli.redditclone.bl.User;


public class UpVote extends Vote {
	public UpVote(Date clickTime, User user) {
		super(clickTime, user);
	}
public UpVote(User u) {
		super(u);
		// TODO Auto-generated constructor stub
	}

}
