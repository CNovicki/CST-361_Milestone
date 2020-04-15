package business;

import java.util.HashMap;

import javax.annotation.PostConstruct;
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
public class SensorDataCache {

	/**
	 * Hashmap of cache.
	 */
	private HashMap<String, SensorData> cache;
	
	/**
	 * Initializes Hashmap.
	 */
	@PostConstruct
	public void init() {
		
		cache = new HashMap<>();
		
	}
	
	/**
	 * Gets the object of the cache.
	 * @param sensorData
	 * @return
	 */
	public SensorData getObject(SensorData sensorData) {
		
		String key = sensorData.getPressure() + " - " + sensorData.getTemperatureInFahrenheit() + " - " + sensorData.getTimestamp();
		
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
	 * @param sensorData
	 */
	public void putObject(SensorData sensorData) {
		
		String key = sensorData.getPressure() + " - " + sensorData.getTemperatureInFahrenheit() + " - " + sensorData.getTimestamp();
		
		cache.put(key, sensorData);
		
		System.out.println("Cache put for " + key);
		
	}
	
}
