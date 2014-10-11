package ch.lukasmartinelli.redditclone;

import java.util.Date;

public class DownVote extends Vote {
	public DownVote(Date clickTime, User user) {
		super(clickTime, user);
	}
}
