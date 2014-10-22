package ch.lukasmartinelli.redditclone.beans;

import java.util.Comparator;
import java.util.List;

import ch.lukasmartinelli.redditclone.bl.reddit.Reddit;
import ch.lukasmartinelli.redditclone.dl.DataManager;

public class RedditTableBean {
	private DataManager dataManager;
	
	public RedditTableBean() {
		this.dataManager = BeanHelper.findBean("dM");
	}

	public List<Reddit> getReddits() {
		List<Reddit> reddits = dataManager.getData().reddits;
		reddits.sort(new Comparator<Reddit>() {
			@Override
			public int compare(Reddit r0, Reddit r1) {
				return	r0.getCreateTime().compareTo(r1.getCreateTime());
			}
		});

		if(reddits.size() > 20) {
			return reddits.subList(0, 20);
		} else {
			return reddits;
		}
	}
	public int getCommentsCount(Reddit r) {
		return r.getComments().size();
	}
}
