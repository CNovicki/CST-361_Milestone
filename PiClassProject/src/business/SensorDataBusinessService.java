package business;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import beans.SensorData;
import data.DataAccessInterface;
import exceptions.DataNotFoundException;
import utils.LoggingInterceptor;

/**
 * Service for sensor data.
 * @author Calvin Novicki
 *
 */
@Interceptors(LoggingInterceptor.class)
@Stateless
@Local(SensorDataBusinessInterface.class)
@LocalBean
public class SensorDataBusinessService implements SensorDataBusinessInterface {

	/**
	 * Injects data service.
	 */
	@Inject
	private DataAccessInterface<SensorData> service;

	/**
	 * For cache design pattern.
	 */
	@Inject
	private SensorDataCache cache;
	
	/**
	 * Adds sensor data to database.
	 */
	@Override
	public SensorData addSensorData(SensorData sensorData) {
	
		return service.create(sensorData);
		
	}

	/**
	 * Gets sensor data from database.
	 */
	@Override
	public SensorData getSensorData(SensorData sensorData) throws DataNotFoundException {
			
		String[] values = {Double.toString(sensorData.getPressure()), Double.toString(sensorData.getTemperatureInFahrenheit()), sensorData.getTimestamp()};
		
		SensorData newSensorData = cache.getObject(sensorData);
			
		if(newSensorData != null) {
			
			return newSensorData;
			
		}
			
		newSensorData = service.read(values);
		
		if(newSensorData == null) {
			
			throw new DataNotFoundException();
			
		}
		
		else {
			
			cache.putObject(newSensorData);
			
			return newSensorData;
			
		}
			
	}

	/**
	 * Gets all sensor data.
	 */
	@Override
	public List<SensorData> getAllSensorData() throws DataNotFoundException {
		
		if(service.readAll() == null) {
			
			throw new DataNotFoundException();
			
		}
		
		else {
			
			return service.readAll();
		
		}
		
	}
	
}
