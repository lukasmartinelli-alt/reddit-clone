package ch.lukasmartinelli.redditclone;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class LoginController implements Serializable {
	private String username;
	private String password;
	private Boolean isLoggedIn;
	private FacesMessage msg;
	
	public LoginController() {
		
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
	
	public String login() {
        if (this.getUsername().equals("daniel") && this.getPassword().equals("123")) {
            this.isLoggedIn = true;                 
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loginController", this);
            return "home.html";
        } else {
            this.isLoggedIn = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalider Benutzername.", username);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "login.html";
        }
    }
	
	public String logOut() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("loginController");
        return "login.html";
    }
}
