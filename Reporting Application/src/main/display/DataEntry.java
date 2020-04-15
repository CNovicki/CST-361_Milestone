package main.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import beans.SensorData;
import business.SensorDataBusiness;

/**
 * Panel for data entry.
 * @author Calvin Novicki
 *
 */
public class DataEntry implements ActionListener {
	
	/**
	 * data entry panel.
	 */
	private JPanel dataEntryPanel;

	/**
	 * pressure input.
	 */
	private JTextField addPressure;
	
	/**
	 * temperature input.
	 */
	private JTextField addTemperature;
	
	/**
	 * date input.
	 */
	private JTextField addDate;
	
	/**
	 * add button.
	 */
	private JButton addData;
	
	/**
	 * passed-in display.
	 */
	private Display display;
	
	/**
	 * passed-in data chart.
	 */
	private DataChart dataChart;
	
	/**
	 * panel width.
	 */
	private int width;
	
	/**
	 * panel height.
	 */
	private int height;
	
	/**
	 * panel color.
	 */
	private Color color;
	
	/**
	 * Creates a new data entry panel.
	 * @param display
	 * @param dataChart
	 * @param width
	 * @param height
	 * @param color
	 */
	public DataEntry(Display display, DataChart dataChart, int width, int height, Color color) {
		
		this.display = display;
		
		this.dataChart = dataChart;
		
		this.width = width;
		
		this.height = height;
		
		this.color = color;
		
		dataEntryPanel = new JPanel();
		
		addPressure = new JTextField();
		
		addTemperature = new JTextField();
		
		addDate = new JTextField();
		
		addData = new JButton("Add Data");
		
	}
	
	/**
	 * Creates data entry GUI.
	 */
	public void createDataEntry() {
		
		GridBagConstraints c = new GridBagConstraints();
		
		dataEntryPanel.setLayout(new GridBagLayout());
		
		dataEntryPanel.setBackground(color);
		
		addPressure.setPreferredSize(new Dimension(width / 3, 20));
		
		addPressure.setMinimumSize(new Dimension(width / 3, 20));
		
		addPressure.setMaximumSize(new Dimension(width / 3, 20));
						
		c.insets = new Insets(2, 2, 2, 2);
		
		c.anchor = GridBagConstraints.NORTH;
						
		c.gridx = 0;
		
		c.gridheight = 2;
		
		dataEntryPanel.add(addPressure, c);
		
		addTemperature.setPreferredSize(new Dimension(width / 3, 20));
		
		addTemperature.setMinimumSize(new Dimension(width / 3, 20));
		
		addTemperature.setMaximumSize(new Dimension(width / 3, 20));
								
		c.gridx = 1;
		
		dataEntryPanel.add(addTemperature, c);
		
		addDate.setPreferredSize(new Dimension(width / 3, 20));
		
		addDate.setMinimumSize(new Dimension(width / 3, 20));
		
		addDate.setMaximumSize(new Dimension(width / 3, 20));
								
		c.gridx = 2;
		
		dataEntryPanel.add(addDate, c);
		
		addData.setPreferredSize(new Dimension(width / 3, 20));
		
		addData.setMinimumSize(new Dimension(width / 3, 20));
		
		addData.setMaximumSize(new Dimension(width / 3, 20));
		
		addData.setBackground(Color.GRAY);
		
		addData.setForeground(Color.WHITE);
		
		addData.setFocusable(false);
		
		addData.addActionListener(this);
				
		c.gridx = 1;
		
		c.gridy = 2;
				
		dataEntryPanel.add(addData, c);
		
	}

	/**
	 * Action for add button.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		SensorDataBusiness sensorDataBusiness = new SensorDataBusiness();
						
		GridBagConstraints c = new GridBagConstraints();
		
		String pressure = addPressure.getText();
				
		String temperature = addTemperature.getText();
		
		String date = addDate.getText();
				
		SensorData sensorData = new SensorData(Double.valueOf(pressure), Double.valueOf(temperature), date);
		
		JLabel pressureData = new JLabel(pressure);
		
		JLabel temperatureData = new JLabel(temperature);

		JLabel dateData = new JLabel(date);
		
		c.insets = new Insets(5, 5, 5, 5);

		c.gridx = 0;
						
		dataChart.getScrollablePanel().add(pressureData, c);
		
		c.gridx = 1;
		
		dataChart.getScrollablePanel().add(temperatureData, c);
		
		c.gridx = 2;
		
		dataChart.getScrollablePanel().add(dateData, c);
		
		dataChart.getScrollablePanel().revalidate();
		
		dataChart.getScrollablePanel().repaint();
				
		sensorDataBusiness.writeSensorData(sensorData);
				
	}
	
	//********************************************************************************//
	/*
	 * GETTERS AND SETTERS
	 */
	//********************************************************************************//
	
	public JPanel getDataEntryPanel() {
	
		return dataEntryPanel;
	
	}

	public void setDataEntryPanel(JPanel dataEntryPanel) {
	
		this.dataEntryPanel = dataEntryPanel;
	
	}

	public JTextField getAddPressure() {
	
		return addPressure;
	
	}

	public void setAddPressure(JTextField addPressure) {
	
		this.addPressure = addPressure;
	
	}

	public JTextField getAddTemperature() {
	
		return addTemperature;
	
	}

	public void setAddTemperature(JTextField addTemperature) {
	
		this.addTemperature = addTemperature;
	
	}

	public JTextField getAddDate() {
	
		return addDate;
	
	}

	public void setAddDate(JTextField addDate) {
	
		this.addDate = addDate;
	
	}

	public JButton getAddData() {
	
		return addData;
	
	}

	public void setAddData(JButton addData) {
	
		this.addData = addData;
	
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
