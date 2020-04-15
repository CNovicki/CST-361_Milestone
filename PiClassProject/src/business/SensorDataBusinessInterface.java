package business;

import java.util.List;

import javax.ejb.Local;

import beans.SensorData;
import exceptions.DataNotFoundException;

/**
 * 
 * @author Ali Cooper
 * @author Calvin Novicki *Re-did
 *
 */
@Local
public interface SensorDataBusinessInterface {
	
	/**
	 * tries to store a given piece of Sensor Data
	 * @param sensorData
	 */
	public SensorData addSensorData(SensorData sensorData);
	
	/**
	 * gets sensor data.
	 * @param sensorData
	 * @return
	 * @throws DataNotFoundException
	 */
	public SensorData getSensorData(SensorData sensorData) throws DataNotFoundException;
	
	/**
	 * Gets all sensor data.
	 * @return
	 * @throws DataNotFoundException
	 */
	public List<SensorData> getAllSensorData() throws DataNotFoundException;
	
}
