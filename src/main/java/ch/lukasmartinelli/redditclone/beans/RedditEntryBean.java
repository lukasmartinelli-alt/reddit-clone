package ch.lukasmartinelli.redditclone.beans;


import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;

import ch.lukasmartinelli.redditclone.bl.TimeAgoCalculator;
import ch.lukasmartinelli.redditclone.bl.reddit.Reddit;
@FacesComponent(value="redditEntry")
public class RedditEntryBean extends UINamingContainer  {

	public Reddit getReddit() {
		Reddit r = (Reddit) this.getAttributes().get("value");
		return r;
	}
	public String getTimeAgo() {
		TimeAgoCalculator tac = new TimeAgoCalculator();
		String timeAgo = "posted " + tac.getTimeAgo(this.getReddit().getCreateTime()) + " ago by ";
		return timeAgo;
	}

}
