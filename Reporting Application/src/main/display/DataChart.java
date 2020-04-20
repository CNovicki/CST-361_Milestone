package main.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 * Data chart panel.
 * @author Calvin Novicki
 *
 */
public class DataChart extends SwingPanel implements SwingInterface {
	
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The scroll panel.
	 */
	private JScrollPane scrollPane;
	
	/**
	 * Inside scroll panel.
	 */
	private JPanel scrollablePanel;
	
	/**
	 * Pressure label.
	 */
	private JLabel pressure;
	
	/**
	 * Temperature label.
	 */
	private JLabel temperature;
	
	/**
	 * Data label.
	 */
	private JLabel date;
	
	/**
	 * Creates a new data chart.
	 * @param display
	 * @param width
	 * @param height
	 * @param color
	 */
	public DataChart(Display display, int width, int height, Color color) {
		
		super(display, width, height, color);
						
		scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		scrollablePanel = new JPanel();
		
		pressure = new JLabel("Pressure (Pa)", SwingConstants.CENTER);
		
		temperature = new JLabel("Temperature (F)", SwingConstants.CENTER);
				
		date = new JLabel("Date", SwingConstants.CENTER);
				
	}

	/**
	 * Creates all chart GUI.
	 */
	@Override
	public void createAndShowGUI() {
		
		super.createAndShowGUI();
		
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(new GridBagLayout());
				
		c.insets = new Insets(5, 5, 5, 5);
		
		c.anchor = GridBagConstraints.NORTH;
		
		c.weightx = 1.0;
		
		c.weighty = 1.0;
								
		pressure.setPreferredSize(new Dimension(width / 3, 20));
		
		pressure.setMinimumSize(new Dimension(width / 3, 20));
		
		pressure.setMaximumSize(new Dimension(width / 3, 20));
		
		pressure.setOpaque(true);
		
		pressure.setBackground(Color.GRAY);
		
		pressure.setForeground(Color.WHITE);
		
		add(pressure, c);
		
		c.gridx = 1;
				
		temperature.setPreferredSize(new Dimension(width / 3, 20));
		
		temperature.setMinimumSize(new Dimension(width / 3, 20));
		
		temperature.setMaximumSize(new Dimension(width / 3, 20));
		
		temperature.setOpaque(true);
		
		temperature.setBackground(Color.GRAY);
		
		temperature.setForeground(Color.WHITE);
		
		add(temperature, c);
		
		c.gridx = 2;
		
		date.setPreferredSize(new Dimension(width / 3, 20));
		
		date.setMinimumSize(new Dimension(width / 3, 20));
		
		date.setMaximumSize(new Dimension(width / 3, 20));
		
		date.setOpaque(true);
		
		date.setBackground(Color.GRAY);
		
		date.setForeground(Color.WHITE);
		
		add(date, c);
		
		c.insets = new Insets(0, 0, 0, 0);
		
		c.gridx = 0;
		
		c.gridy = 1;
		
		c.gridwidth = 3;
				
		scrollPane.setPreferredSize(new Dimension(width, height - 35));
		
		scrollPane.setMinimumSize(new Dimension(width, height - 35));
		
		scrollPane.setMaximumSize(new Dimension(width, height - 35));		

		scrollablePanel.setLayout(new GridBagLayout());
				
		scrollPane.setViewportView(scrollablePanel);
								
		add(scrollPane, c);
		
	}
	
	//********************************************************************************//
	/*
	 * GETTERS AND SETTERS
	 */
	//********************************************************************************//

	public JScrollPane getScrollPane() {
	
		return scrollPane;
	
	}

	public void setScrollPane(JScrollPane scrollPane) {
	
		this.scrollPane = scrollPane;
	
	}

	public JPanel getScrollablePanel() {
	
		return scrollablePanel;
	
	}

	public void setScrollablePanel(JPanel scrollablePanel) {
	
		this.scrollablePanel = scrollablePanel;
	
	}

	public JLabel getPressure() {
	
		return pressure;
	
	}

	public void setPressure(JLabel pressure) {
	
		this.pressure = pressure;
	
	}

	public JLabel getTemperature() {
	
		return temperature;
	
	}

	public void setTemperature(JLabel temperature) {
	
		this.temperature = temperature;
	
	}

	public JLabel getDate() {
	
		return date;
	
	}

	public void setDate(JLabel date) {
	
		this.date = date;
	
	}
	
}
