package ch.lukasmartinelli.redditclone.vote;

import java.util.Date;

import ch.lukasmartinelli.redditclone.User;


public class DownVote extends Vote {
	public DownVote(Date clickTime, User user) {
		super(clickTime, user);
	}
	public DownVote(User u) {
		super(u);
		// TODO Auto-generated constructor stub
	}

}
