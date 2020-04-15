package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

import beans.SensorData;
import business.SensorDataBusinessInterface;
import exceptions.DataNotFoundException;
import utils.LoggingInterceptor;

/**
 * Controller for the sensor data.
 * 
 * @author Ali Cooper
 * @athor Calvin Novicki *Re-did
 * @author Jonathan Nungaray
 */
@Interceptors(LoggingInterceptor.class)
@Named
@ViewScoped
public class SensorDataController implements Serializable {
	
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Injects the sensor data service.
	 */
	@Inject
	private SensorDataBusinessInterface service;
	
	/**
	 * List of all the sensor data.
	 */
	private List<SensorData> sensorData;

	/**
	 * Gets the sensor data.
	 * @return
	 */
	public List<SensorData> getSensorData() {
	
		try {
			
			return sensorData = service.getAllSensorData();
		
		}
		
		catch (DataNotFoundException e) {
			
			e.printStackTrace();
			
			return new ArrayList<>();
						
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
			return new ArrayList<>();
			
		}
			
	}

	/**
	 * Sets the sensor data.
	 * @param sensorData
	 */
	public void setSensorData(List<SensorData> sensorData) {
	
		this.sensorData = sensorData;
	
	}
	
}
