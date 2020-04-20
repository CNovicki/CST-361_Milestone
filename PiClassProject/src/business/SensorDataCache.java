package business;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import beans.SensorData;

/**
 * Cache for Singleton design pattern.
 * @author Calvin Novicki
 *
 */
@Startup
@Singleton
public class SensorDataCache extends Cache<SensorData> {
	
	/**
	 * Gets the object of the cache.
	 * @param object
	 * @return
	 */
	@Override
	public SensorData getObject(SensorData object) {
		
		String key = object.getPressure() + " - " + object.getTemperatureInFahrenheit() + " - " + object.getTimestamp();
		
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
	public void putObject(SensorData object) {
		
		String key = object.getPressure() + " - " + object.getTemperatureInFahrenheit() + " - " + object.getTimestamp();
		
		cache.put(key, object);
		
		System.out.println("Cache put for " + key);
		
	}
	
}
