package business;
import javax.ejb.Local;

import beans.User;
import exceptions.UserNotFoundException;

/**
 * Interface for user service.
 * @author Calvin Novicki
 *
 */
@Local
public interface UserBusinessInterface {
	
	/**
	 * Adds a user.
	 * @param user
	 * @return
	 */
    public User addUser(User user);
    
    /**
     * Gets a user.
     * @param user
     * @return
     * @throws UserNotFoundException
     */
    public User getUser(User user) throws UserNotFoundException;
    
    /**
     * Encrypts password.
     * @param base
     * @return
     */
	public String encrypt(String base);
    
}
