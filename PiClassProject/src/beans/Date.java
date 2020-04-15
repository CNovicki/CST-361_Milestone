package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * This is a helper class to format a date for the sensor data.
 * @author Calvin Novicki
 *
 */
@ManagedBean
@ViewScoped
public class Date {
	
	/**
	 * The time as a String.
	 */
	private String time;
	
	/**
	 * The month as a String.
	 */
	private String month;
	
	/**
	 * The day as a String.
	 */
	private String day;
	
	/**
	 * The year as a String.
	 */
	private String year;
	
	/**
	 * Creates a new default date.
	 */
	public Date() {
		
		time = "00:00:00";
		
		month = "01";
		
		day = "01";
		
		year = "1970";
		
	}
	
	/**
	 * Creates a new date with initializations.
	 * @param time
	 * @param month
	 * @param day
	 * @param year
	 */
	public Date(String time, String month, String day, String year) {
		
		this.time = time;
		
		this.month = month;
		
		this.day = day;
		
		this.year = year;
		
	}
	
	@Override
	public String toString() {
		
		return time + " " + month + " " + day + " " + year;
		
	}
	
	//********************************************************************************//
	/*
	 * GETTERS AND SETTERS
	 */
	//********************************************************************************//

	public String getTime() {
		
		return time;
		
	}

	public void setTime(String time) {
		
		this.time = time;
		
	}

	public String getMonth() {
		
		return month;
		
	}

	public void setMonth(String month) {
		
		this.month = month;
		
	}

	public String getDay() {
		
		return day;
		
	}

	public void setDay(String day) {
		
		this.day = day;
		
	}

	public String getYear() {
		
		return year;
		
	}

	public void setYear(String year) {
		
		this.year = year;
		
	}
	
}
