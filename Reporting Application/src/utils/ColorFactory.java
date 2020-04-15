package utils;

import java.awt.Color;

/**
 * Factory desing pattern for background color.
 * @author Calvin Novicki
 *
 */
public class ColorFactory {
	
	/**
	 * Gets the color.
	 * @param color
	 * @return
	 */
	public static Color getColor(String color) {
		
		if(color == null) {
			
			return null;
			
		}
		
		if(color.equalsIgnoreCase("lightblue")) {
			
			return new LightBlue().fill();
			
		}
		
		else if(color.equalsIgnoreCase("lightred")) {
			
			return new LightRed().fill();
			
		}
		
		else if(color.equalsIgnoreCase("lightgreen")) {
			
			return new LightGreen().fill();
			
		}
		
		return null;
		
	}

}
