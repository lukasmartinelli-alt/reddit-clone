package ch.lukasmartinelli.redditclone.beans;

import java.util.ArrayList;

import javax.faces.context.FacesContext;
import ch.lukasmartinelli.redditclone.bl.User;
import ch.lukasmartinelli.redditclone.dl.DataManager;

public class LoginBean {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public String login() {
		ArrayList<User> users = DataManager.getData().users;
		FacesContext context = FacesContext.getCurrentInstance();
		UserBean userBean = context.getApplication().evaluateExpressionGet(context, "#{userBean}", UserBean.class);

		User user = getUserByLogin(users, getUsername());

		if (user != null && user.checkPassword(getPassword())) {
			userBean.setCurrentUser(user);
		} else {
			userBean.setCurrentUser(null);
		}

		return null;
	}

	private static User getUserByLogin(ArrayList<User> users, String login) {
		for (User user : users) {
			if (login == user.getLogin()) {
				return user;
			}
		}
		return null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Create a new user with the given credentials and log him in
	 */
	public String register() {
		User user = new User();
		user.setLogin(getUsername());
		user.setName(getUsername());
		user.setPassword(getPassword());

		DataManager.getData().users.add(user);
		return login();
	}

	public String logOut() {
		FacesContext context = FacesContext.getCurrentInstance();
		UserBean userBean = context.getApplication().evaluateExpressionGet(
				context, "#{user}", UserBean.class);
		userBean.setCurrentUser(null);
		return "home";
	}
}
