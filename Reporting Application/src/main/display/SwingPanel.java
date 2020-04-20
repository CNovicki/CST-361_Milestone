package main.display;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * Abstract class for JPanel.
 * @author Calvin Novicki
 *
 */
public abstract class SwingPanel extends JPanel implements SwingInterface {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Passed-in Display.
	 */
	protected Display display;
	
	/**
	 * Width of panel.
	 */
	protected int width;
	
	/**
	 * Height of panel.
	 */
	protected int height;
	
	/**
	 * Color of panel.
	 */
	protected Color color;
	
	/**
	 * Creates a new swing panel.
	 * @param display
	 * @param width
	 * @param height
	 * @param color
	 */
	public SwingPanel(Display display, int width, int height, Color color) {
		
		this.display = display;
		
		this.width = width;
		
		this.height = height;
		
		this.color = color;
		
	}
	
	/**
	 * Creates GUI.
	 */
	@Override
	public void createAndShowGUI() {
		
		setPreferredSize(new Dimension(width, height));
		
		setMinimumSize(new Dimension(width, height));
		
		setMaximumSize(new Dimension(width, height));
		
		setBackground(color);
		
	}
	
	//********************************************************************************//
	/*
	 * GETTERS AND SETTERS
	 */
	//********************************************************************************//
	
	public Display getDisplay() {
	
		return display;
	
	}

	public void setDisplay(Display display) {
	
		this.display = display;
	
	}

	@Override
	public int getWidth() {
	
		return width;
	
	}

	public void setWidth(int width) {
	
		this.width = width;
	
	}

	@Override
	public int getHeight() {
	
		return height;
	
	}

	public void setHeight(int height) {
	
		this.height = height;
	
	}

	public Color getColor() {
	
		return color;
	
	}

	public void setColor(Color color) {
	
		this.color = color;
	
	}

}
