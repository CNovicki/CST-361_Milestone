package beans;

/**
 * Helper class to format date.
 * 
 * @author Calvin Novicki
 *
 */
public class Date {
	
	/**
	 * time String.
	 */
	private String time;
	
	/**
	 * month String.
	 */
	private String month;
	
	/**
	 * day string.
	 */
	private String day;
	
	/**
	 * year string.
	 */
	private String year;
	
	/**
	 * Creates a date.
	 */
	public Date() {
		
		time = "00:00:00";
		
		month = "01";
		
		day = "01";
		
		year = "1970";
		
	}
	
	/**
	 * Creates a date.
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
