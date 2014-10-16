package ch.lukasmartinelli.redditclone.bl;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String login;

	protected String password;

	protected String name;

	protected String mail;

	public String getLogin() {
		if (login == null) {
			return "";
		}
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMail() {
		if (mail == null) {
			return "";
		}
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		if (name == null) {
			return "";
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		if (password == null) {
			return "";
		}
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean checkPassword(String password) {
		if (this.password.equals(password)) {
			return true;
		}
		return false;
	}

	public boolean checkEntries() throws UserException {
		if (login == null && password == null && name == null && mail == null)
			return false;
		if (login == null || login.equals(""))
			throw new UserException();
		if (password == null || password.equals(""))
			throw new UserException();
		if (name == null || name.equals(""))
			throw new UserException();
		if (mail == null || mail.equals(""))
			throw new UserException();
		if (mail.indexOf("@") == -1)
			throw new UserException();
		return true;
	}
}
