package beans;

/**
 * Model Class for sensor data
 * @author Ali Cooper
 * @author Calvin Novicki
 *
 */
public class SensorData {
	
	/**
	 * pressure double.
	 */
	private double pressure;
	
	/**
	 * temperature double.
	 */
	private double temperatureInFahrenheit;
	
	/**
	 * time and date String.
	 */
	private String timestamp;
	
	/**
	 * Creates new sensor data.
	 */
	public SensorData() {
		
		super();
				
		this.pressure = 0;
		
		this.temperatureInFahrenheit = 0;
		
		this.timestamp = new Date().toString();
		
	}
	
	/**
	 * Creates new sensor data.
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
