package ch.lukasmartinelli.redditclone;

import java.io.Serializable;

public class LoginBeam implements Serializable {
	private static final long serialVersionUID = 728602970340551883L;
	private String name;
	private String password;
	
	public LoginBeam() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
