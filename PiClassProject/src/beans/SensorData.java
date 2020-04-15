package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Model Class for sensor data
 * @author Ali Cooper
 * @author Calvin Novicki *Re-did
 *
 */
@ManagedBean
@ViewScoped
public class SensorData {
	
	/**
	 * The pressure data.
	 */
	private double pressure;
	
	/**
	 * The temperature data.
	 */
	private double temperatureInFahrenheit;
	
	/**
	 * The time data.
	 */
	private String timestamp;
	
	/**
	 * Default constructor.
	 */
	public SensorData() {
		
		super();
				
		this.pressure = 0;
		
		this.temperatureInFahrenheit = 0;
		
		this.timestamp = new Date().toString();
		
	}
	
	/**
	 * Creates new SensorData with initializations.
	 * @param pressure
	 * @param temperatureInFahrenheit
	 * @param timestamp
	 */
	public SensorData(double pressure, double temperatureInFahrenheit, String timestamp) {
		
		this.pressure = pressure;
		
		this.temperatureInFahrenheit = temperatureInFahrenheit;
		
		this.timestamp = timestamp;
		
	}
	
	@Override
	public String toString() {
		
		return "data: " + pressure + ", " + temperatureInFahrenheit + ", " + timestamp;
		
	}
	
	//********************************************************************************//
	/*
	 * GETTERS AND SETTERS
	 */
	//********************************************************************************//
	
	public double getPressure() {
		
		return pressure;
		
	}
	
	public void setPressure(double pressure) {
		
		this.pressure = pressure;
		
	}
	
	public double getTemperatureInFahrenheit() {
		
		return temperatureInFahrenheit;
		
	}
	
	public void setTemperatureInFahrenheit(double temperatureInFahrenheit) {
		
		this.temperatureInFahrenheit = temperatureInFahrenheit;
		
	}
	
	public String getTimestamp() {
		
		return timestamp;
		
	}
	
	public void setTimestamp(String timestamp) {
		
		this.timestamp = timestamp;
		
	}
	
}
