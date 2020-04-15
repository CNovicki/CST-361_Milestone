package main.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import utils.ColorFactory;

/**
 * Panel to change background color.
 * @author Calvin Novicki
 *
 */
public class ColorPanel {
	
	/**
	 * Panel for color picker.
	 */
	private JPanel colorPanel;

	/**
	 * blue button
	 */
	private JButton blue;
	
	/**
	 * red button.
	 */
	private JButton red;
	
	/**
	 * green button.
	 */
	private JButton green;
	
	/**
	 * The main Display passed in.
	 */
	private Display display;
	
	/**
	 * width of panel.
	 */
	private int width;
	
	/**
	 * height of panel.
	 */
	private int height;
	
	/**
	 * Color of panel.
	 */
	private Color color;
	
	/**
	 * Creates a new color panel.
	 * @param display
	 * @param width
	 * @param height
	 * @param color
	 */
	public ColorPanel(Display display, int width, int height, Color color) {
		
		this.display = display;
		
		this.width = width;
		
		this.height = height;
		
		this.color = color;
		
		colorPanel = new JPanel();
		
		blue = new JButton("Blue");
		
		red = new JButton("Red");
		
		green = new JButton("Green");
		
	}

	/**
	 * Creates all GUI elements.
	 */
	public void createColorPanel() {
				
		colorPanel.setPreferredSize(new Dimension(width, height));
		
		colorPanel.setMinimumSize(new Dimension(width, height));
		
		colorPanel.setMaximumSize(new Dimension(width, height));
		
		colorPanel.setBackground(color);
		
		blue.setPreferredSize(new Dimension(width / 4, height - 10));
		
		blue.setMinimumSize(new Dimension(width / 4, height - 10));
		
		blue.setMaximumSize(new Dimension(width / 4, height - 10));
		
		blue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				display.getPanel().setBackground(ColorFactory.getColor("lightblue"));
				
				display.getPanel().revalidate();
				
			}
			
		});
		
		red.setPreferredSize(new Dimension(width / 4, height - 10));
		
		red.setMinimumSize(new Dimension(width / 4, height - 10));
		
		red.setMaximumSize(new Dimension(width / 4, height - 10));
		
		red.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				display.getPanel().setBackground(ColorFactory.getColor("lightred"));
				
				display.getPanel().revalidate();
				
			}
			
		});
		
		green.setPreferredSize(new Dimension(width / 4, height - 10));
		
		green.setMinimumSize(new Dimension(width / 4, height - 10));
		
		green.setMaximumSize(new Dimension(width / 4, height - 10));
		
		green.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				display.getPanel().setBackground(ColorFactory.getColor("lightgreen"));
				
				display.getPanel().revalidate();
				
			}
			
		});
		
		colorPanel.add(blue);
		
		colorPanel.add(red);

		colorPanel.add(green);
		
	}
	
	//********************************************************************************//
	/*
	 * GETTERS AND SETTERS
	 */
	//********************************************************************************//
	
	public JPanel getColorPanel() {
		
		return colorPanel;
	
	}

	public void setColorPanel(JPanel colorPanel) {
	
		this.colorPanel = colorPanel;
	
	}
	
	public JButton getBlue() {
	
		return blue;
	
	}

	public void setBlue(JButton blue) {
	
		this.blue = blue;
	
	}

	public JButton getRed() {
	
		return red;
	
	}

	public void setRed(JButton red) {
	
		this.red = red;
	
	}

	public JButton getGreen() {
	
		return green;
	
	}

	public void setGreen(JButton green) {
	
		this.green = green;
	
	}

	public Display getDisplay() {
	
		return display;
	
	}

	public void setDisplay(Display display) {
	
		this.display = display;
	
	}

	public int getWidth() {
	
		return width;
	
	}

	public void setWidth(int width) {
	
		this.width = width;
	
	}

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
