package ch.lukasmartinelli.redditclone.beans;

import java.util.Date;

import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;

import ch.lukasmartinelli.redditclone.bl.TimeAgoCalculator;
import ch.lukasmartinelli.redditclone.bl.User;
import ch.lukasmartinelli.redditclone.bl.reddit.Comment;
import ch.lukasmartinelli.redditclone.dl.DataManager;
@FacesComponent(value="commentEntry")
public class CommentEntryBean  extends UINamingContainer  {
	private String newText;
	private UserBean userBean;
	
	public CommentEntryBean() {
		userBean = BeanHelper.findBean("userBean");
	}
	
	public String getNewText() {
		return newText;
	}

	public void setNewText(String text) {
		this.newText = text;
	}

	public void addComment() {
		User currentUser = userBean.getCurrentUser();
		if(currentUser == null) return;
		
		Comment comment = new Comment();
		comment.setAuthor(currentUser);
		comment.setCreationTime(new Date());
		comment.setText(getNewText());
		this.getComment().addSubComment(comment);
	}

	public Comment getComment() {
		Comment ret = (Comment) this.getAttributes().get("value");
		return	ret;
	}

	public String getTimeAgo() {
		Comment comment = this.getComment();
		if(comment==null) return "";
		
		TimeAgoCalculator tac = new TimeAgoCalculator();
		String timeAgo = "posted " + tac.getTimeAgo(comment.getCreationTime()) + " ago by ";
		return timeAgo;
	}

}
