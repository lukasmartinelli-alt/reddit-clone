package ch.lukasmartinelli.redditclone.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

import ch.lukasmartinelli.redditclone.bl.User;
import ch.lukasmartinelli.redditclone.dl.DataManager;

public class LoginBean implements Serializable {
	private static final long serialVersionUID = -7525426507940195553L;
	private String username;
	private String password;
	private UserBean userBean;
	private DataManager dataManager;
	
	public LoginBean() {
		this.userBean = BeanHelper.findBean("userBean");
		this.dataManager = BeanHelper.findBean("dM");
	}

	public String login() {
		User user = getUserByLogin(dataManager.getData().users, getUsername());

		if (user != null && user.checkPassword(getPassword())) {
			userBean.setCurrentUser(user);
		} else {
			userBean.setCurrentUser(null);
		}

		return null;
	}

	private static User getUserByLogin(ArrayList<User> users, String login) {
		for (User user : users) {
			if (login.equals(user.getLogin())) {
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

		dataManager.getData().users.add(user);
		return login();
	}

	public String logOut() {
		userBean.setCurrentUser(null);
		return "home";
	}
}
