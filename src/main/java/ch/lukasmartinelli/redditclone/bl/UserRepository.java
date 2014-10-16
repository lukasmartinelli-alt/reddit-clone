package ch.lukasmartinelli.redditclone.bl;

/**
 * Serves as a generic interface to users that
 * could be saved in a session or a database.
 */
public interface UserRepository {
	User getUserByName(String username);
	void createUser(User user);
}

