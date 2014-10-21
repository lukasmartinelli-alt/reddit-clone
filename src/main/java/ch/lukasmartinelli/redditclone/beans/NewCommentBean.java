package ch.lukasmartinelli.redditclone.beans;

import java.util.Date;

import ch.lukasmartinelli.redditclone.bl.User;
import ch.lukasmartinelli.redditclone.bl.reddit.Comment;
import ch.lukasmartinelli.redditclone.dl.DataManager;

public class NewCommentBean {
	private String text;
	private boolean activ = false;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean getActiv() {
		return activ;
	}

	public void changeActiv() {
		activ = !activ;
	}
	public String submit(Comment top) {
		System.out.println("Yolo");
		activ = false;
		Comment c = new Comment();
		c.setAuthor(new User());
		c.setCreationTime(new Date());
		c.setText(text);
		top.addSubComment(c);
		return "RedditTable.xhtml";
	}
}
