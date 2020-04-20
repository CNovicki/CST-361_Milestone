package business;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public abstract class Cache<T> {

	protected HashMap<String, T> cache;
	
	@PostConstruct
	public void init() {
		
		cache = new HashMap<>();
		
	}
	
	/**
	 * Gets the object.
	 * @param user
	 * @return
	 */
	public abstract T getObject(T object);
	
	/**
	 * Puts the object in the cache.
	 * @param user
	 */
	public abstract void putObject(T object);

	public HashMap<String, T> getCache() {
	
		return cache;
	
	}

	public void setCache(HashMap<String, T> cache) {
	
		this.cache = cache;
	
	}
	
}
