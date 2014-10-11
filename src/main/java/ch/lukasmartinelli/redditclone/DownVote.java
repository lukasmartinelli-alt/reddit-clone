package ch.lukasmartinelli.redditclone;

import java.util.Date;

<<<<<<< HEAD
	public DownVote(User u) {
		super(u);
		// TODO Auto-generated constructor stub
	}

=======
public class DownVote extends Vote {
	public DownVote(Date clickTime, User user) {
		super(clickTime, user);
	}
>>>>>>> 0759c7145cd756185f13a986cd38f6c15e6850b7
}
