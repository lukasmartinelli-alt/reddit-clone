package ch.lukasmartinelli.redditclone.bl.reddit;

import java.io.Serializable;
import java.util.ArrayList;

import ch.lukasmartinelli.redditclone.bl.User;

public class Voter implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<UpVote> upVotes = new ArrayList<>();
	private ArrayList<DownVote> downVotes = new ArrayList<>();

	public Voter(){};

	public boolean hasUserUpvoted(User user) {
		if(user == null) return false;
		
		for(UpVote vote : getUpVotes()) {
			if(vote.getUser().getName() == user.getName()) {
				return true;
			}
		}
		return false;
	}

	public boolean hasUserDownvoted(User user) {
		if(user == null) return false;
		
		for(DownVote vote : getDownVotes()) {
			if(vote.getUser().getName() == user.getName()) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<UpVote> getUpVotes() {
		return upVotes;
	}
	public void addUpVote(UpVote upVotes) {
		this.upVotes.add(upVotes);
	}

	public ArrayList<DownVote> getDownVotes() {
		return downVotes;
	}

	public void addDownVote(DownVote downVotes) {
		this.downVotes.add(downVotes);
	}

	public int getVotesCount() {
		return upVotes.size() - downVotes.size();
	}

	private void removeVoteFromUser(User u) {
		if(u!=null){
			UpVote up = getUpVoteFromUser(u);
			DownVote dn = getDownVoteFromUser(u);
			if(up!=null) {
				if(upVotes.contains(up)) upVotes.remove(up);
			}
			if(dn!=null) {
				if(downVotes.contains(dn)) downVotes.remove(dn);
			}
		}
	}

	public UpVote getUpVoteFromUser(User u) {
		for(UpVote v: upVotes) {
			if(v.getUser().getLogin().equals(u.getLogin())){
				return v;
			}
		}
		return null;
	}

	public DownVote getDownVoteFromUser(User u) {
		for(DownVote v: downVotes) {
			if(v.getUser().getLogin().equals(u.getLogin())){
				return v;
			}
		}
		return null;
	}

	public void upVote(User votingUser) {
		if(votingUser == null) throw new IllegalArgumentException("Cannot vote without a user");
		
		this.removeVoteFromUser(votingUser);
		addUpVote(new UpVote(votingUser));

	}
	public void downVote(User votingUser) {
		if(votingUser == null) throw new IllegalArgumentException("Cannot vote without a user");
		
		this.removeVoteFromUser(votingUser);
		addDownVote(new DownVote(votingUser));
	}
}
