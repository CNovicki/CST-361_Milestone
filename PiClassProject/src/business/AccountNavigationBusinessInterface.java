package business;

import beans.User;

/**
 * Interface for use navigation.
 * @author Calvin Novicki
 *
 */
public interface AccountNavigationBusinessInterface {

	/**
	 * Used for registering.
	 * @param user
	 * @return
	 */
	public int register(User user);
	
	/**
	 * Used for login.
	 * @param user
	 * @return
	 */
	public int login(User user);
	
	/**
	 * Used for logout.
	 * @param user
	 * @return
	 */
	public int logout(User user);
	
}
