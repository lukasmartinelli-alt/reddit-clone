package ch.lukasmartinelli.twitterclone;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBeam implements Serializable {
	private static final long serialVersionUID = 728602970340551883L;
	private String name;
	private String password;

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
