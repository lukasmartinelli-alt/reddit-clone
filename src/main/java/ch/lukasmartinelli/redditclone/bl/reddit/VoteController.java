package ch.lukasmartinelli.redditclone.bl.reddit;

import java.io.Serializable;
import java.util.ArrayList;

import ch.lukasmartinelli.redditclone.beans.BeanHelper;
import ch.lukasmartinelli.redditclone.beans.UserBean;
import ch.lukasmartinelli.redditclone.bl.User;

public class VoteController implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<UpVote> upVotes = new ArrayList<>();
	private ArrayList<DownVote> downVotes = new ArrayList<>();
	
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
	public void removeVoteFromUser(User u) {
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
		//if(u!=null) {
			this.removeVoteFromUser(votingUser);
			addUpVote(new UpVote(votingUser));
		//}

	}
	public void downVote(User votingUser) {
		//if(u!=null) {
			this.removeVoteFromUser(votingUser);
			addDownVote(new DownVote(votingUser));
		//}

	}
}
