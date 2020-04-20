package business;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import beans.User;

/**
 * Cache for the user.
 * @author Calvin Novicki
 *
 */
@Startup
@Singleton
public class UserCache extends Cache<User> {
	
	/**
	 * Gets the object.
	 * @param object
	 * @return
	 */
	@Override
	public User getObject(User object) {
		
		String key = object.getUsername();
		
		if(cache.containsKey(key)) {
						
			System.out.println("Cache hit for " + key);
			
			return cache.get(key);
			
		}
		
		else {
			
			System.out.println("Cache miss for " + key);
			
			return null;
			
		}
		
	}
	
	/**
	 * Puts the object in the cache.
	 * @param object
	 */
	@Override
	public void putObject(User object) {
		
		String key = object.getUsername();
		
		cache.put(key, object);
		
		System.out.println("Cache put for " + key);
		
	}

}
