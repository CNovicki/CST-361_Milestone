package business;

import java.util.HashMap;

import javax.annotation.PostConstruct;
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
public class UserCache {
	
	/**
	 * Hashmap for the cache.
	 */
	private HashMap<String, User> cache;
	
	/**
	 * Initializes the Hashmap.
	 */
	@PostConstruct
	public void init() {
		
		cache = new HashMap<>();
		
	}
	
	/**
	 * Gets the object.
	 * @param user
	 * @return
	 */
	public User getObject(User user) {
		
		String key = user.getUsername();
		
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
	 * @param user
	 */
	public void putObject(User user) {
		
		String key = user.getUsername();
		
		cache.put(key, user);
		
		System.out.println("Cache put for " + key);
		
	}

}
