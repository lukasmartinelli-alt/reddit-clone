package ch.lukasmartinelli.redditclone;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class LoginController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private UserRepository users;
	private HttpSession session;
	private static String CURRENT_USER_ATTRIBUTE = "currentUser";
	
	public LoginController() {
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		this.users = new UserSessionRepository(session);
		this.session = session;
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
	
	public boolean isLoggedIn() {
		return session.getAttribute(CURRENT_USER_ATTRIBUTE) != null;
	}
	
	/**
	 * Create a new user with the given credentials and log him in
	 */
	public String register() {
		User user = new User();
		user.setLogin(getUsername());
		user.setName(getUsername());
		user.setPassword(getPassword());
		users.createUser(user);
		
		return login();
	}
	
	public String login() {
		User user = users.getUserByName(getUsername());
		
		if(user != null && user.checkPassword(getPassword())) {
			session.setAttribute(CURRENT_USER_ATTRIBUTE, user);
		} else {
			//TODO: authentication failed..
		}
		
		return null;
    }
	
	public String logOut() {
		session.removeAttribute(CURRENT_USER_ATTRIBUTE);
        return null;
    }
}
