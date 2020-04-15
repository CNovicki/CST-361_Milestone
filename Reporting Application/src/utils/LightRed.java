package utils;

import java.awt.Color;

/**
 * Light red color.
 * @author Calvin Novicki
 *
 */
public class LightRed implements CustomColor {
	
	/**
	 * Sets color to light red.
	 */
	@Override
	public Color fill() {
		
		return new Color(255, 0, 102);
		
	}
	
}
