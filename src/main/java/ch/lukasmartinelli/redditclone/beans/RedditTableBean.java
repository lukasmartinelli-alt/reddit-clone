package ch.lukasmartinelli.redditclone.beans;

import java.util.Comparator;
import java.util.List;

import ch.lukasmartinelli.redditclone.bl.reddit.Reddit;
import ch.lukasmartinelli.redditclone.dl.DataManager;

public class RedditTableBean {

	public List<Reddit> getReddits() {
		List<Reddit> l =	DataManager.getData().reddits;
		l.sort(new Comparator<Reddit>() {
			@Override
			public int compare(Reddit r0, Reddit r1) {
			return	r0.getCreateTime().compareTo(r1.getCreateTime());
			}
		});
		return l.subList(0, 20);
	}
	public int getCommentsCount(Reddit r) {
		return r.getComments().size();
	}
}
