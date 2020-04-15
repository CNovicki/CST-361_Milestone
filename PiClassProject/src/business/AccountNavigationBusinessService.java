package business;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import beans.User;
import exceptions.UserNotFoundException;
import utils.LoggingInterceptor;

/**
 * Used for account navigation.
 * @author Calvin Novicki
 *
 */
@Interceptors(LoggingInterceptor.class)
@Stateless
@Local(AccountNavigationBusinessInterface.class)
@LocalBean
public class AccountNavigationBusinessService implements AccountNavigationBusinessInterface {

	/**
	 * Injects the generic user service.
	 */
	@Inject
	private UserBusinessInterface service;
	
	/**
	 * Registers a user.
	 */
	@Override
	public int register(User user) {
			
		service.addUser(user);
			
		return 0;
	
	}
	
	/**
	 * Logs a user in.
	 */
	@Override
	public int login(User user) {
		
		try {
		
			User currentUser = service.getUser(user);
			
			String password = user.getPassword();
						
			password = service.encrypt(password);
						
			user.setPassword(password);
			
			if(currentUser.getPassword().equals(user.getPassword())) {
				
				user.setLoggedIn(true);
				
				user.setLoginText("Logout");
				
				return 0;
				
			}
			
			else {
				
				return 1;
				
			}
			
		}
		
		catch (UserNotFoundException e) {
			
			e.printStackTrace();
			
			return -1;
			
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
			
			return -2;
			
		}
				
	}

	/**
	 * Logs a user out.
	 */
	@Override
	public int logout(User user) {
		
		if(!user.getLoggedIn()) {
			
			return -1;
			
		}
		
		user.setLoggedIn(false);
		
		user.setLoginText("Login");
		
		return 0;
		
	}

}
