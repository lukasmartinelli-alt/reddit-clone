package ch.lukasmartinelli.redditclone;

/**
 * Serves as a generic interface to users that
 * could be saved in a session or a database.
 */
public interface UserRepository {
	User getUserByName(String username);
	void createUser(User user);
}

