package ch.lukasmartinelli.redditclone.beans;

import java.util.Date;

import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;

import ch.lukasmartinelli.redditclone.bl.TimeAgoCalculator;
import ch.lukasmartinelli.redditclone.bl.User;
import ch.lukasmartinelli.redditclone.bl.reddit.Comment;
@FacesComponent(value="commentEntry")
public class CommentEntryBean  extends UINamingContainer  {
	
	private String newText;
	private boolean answerActiv = false;
	
	public String getNewText() {
		return newText;
	}

	public void setNewText(String text) {
		this.newText = text;
	}

	public boolean getAnswerActiv() {
		return answerActiv;
	}

	public void changeAnswerActiv() {
		answerActiv = !answerActiv;
	}

	public void addComment() {
		answerActiv = false;
		Comment c = new Comment();
		c.setAuthor(new User());
		c.setCreationTime(new Date());
		c.setText(newText);
		this.getComment().addSubComment(c);
	}

	public Comment getComment() {
		Comment ret = (Comment) this.getAttributes().get("value");
		return	ret;
	}
	public String getTimeAgo() {
		System.out.println("timeAgo");
		TimeAgoCalculator tac = new TimeAgoCalculator();
		Comment c = this.getComment();
		if(c==null) return "";
		String timeAgo = "posted " + tac.getTimeAgo(c.getCreationTime()) + " ago by ";
		return timeAgo;
	}

}
