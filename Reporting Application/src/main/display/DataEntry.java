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
import javax.swing.JTextField;

import beans.SensorData;
import business.SensorDataBusiness;

/**
 * Panel for data entry.
 * @author Calvin Novicki
 *
 */
public class DataEntry extends SwingPanel implements ActionListener {
	
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

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
	 * passed-in data chart.
	 */
	private DataChart dataChart;
	
	/**
	 * Creates a new data entry panel.
	 * @param display
	 * @param dataChart
	 * @param width
	 * @param height
	 * @param color
	 */
	public DataEntry(Display display, DataChart dataChart, int width, int height, Color color) {
		
		super(display, width, height, color);
				
		this.dataChart = dataChart;
				
		addPressure = new JTextField();
		
		addTemperature = new JTextField();
		
		addDate = new JTextField();
		
		addData = new JButton("Add Data");
		
	}
	
	/**
	 * Creates data entry GUI.
	 */
	@Override
	public void createAndShowGUI() {
		
		super.createAndShowGUI();
		
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(new GridBagLayout());
				
		addPressure.setPreferredSize(new Dimension(width / 3, 20));
		
		addPressure.setMinimumSize(new Dimension(width / 3, 20));
		
		addPressure.setMaximumSize(new Dimension(width / 3, 20));
						
		c.insets = new Insets(2, 2, 2, 2);
		
		c.anchor = GridBagConstraints.NORTH;
						
		c.gridx = 0;
		
		c.gridheight = 2;
		
		add(addPressure, c);
		
		addTemperature.setPreferredSize(new Dimension(width / 3, 20));
		
		addTemperature.setMinimumSize(new Dimension(width / 3, 20));
		
		addTemperature.setMaximumSize(new Dimension(width / 3, 20));
								
		c.gridx = 1;
		
		add(addTemperature, c);
		
		addDate.setPreferredSize(new Dimension(width / 3, 20));
		
		addDate.setMinimumSize(new Dimension(width / 3, 20));
		
		addDate.setMaximumSize(new Dimension(width / 3, 20));
								
		c.gridx = 2;
		
		add(addDate, c);
		
		addData.setPreferredSize(new Dimension(width / 3, 20));
		
		addData.setMinimumSize(new Dimension(width / 3, 20));
		
		addData.setMaximumSize(new Dimension(width / 3, 20));
		
		addData.setBackground(Color.GRAY);
		
		addData.setForeground(Color.WHITE);
		
		addData.setFocusable(false);
		
		addData.addActionListener(this);
				
		c.gridx = 1;
		
		c.gridy = 2;
				
		add(addData, c);
		
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
				
		//sensorData = sensorDataBusiness.getSensorData(pressure, temperature, date);
		
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
		
		sensorDataBusiness.writeSensorData(sensorData);						
	}
	
	//********************************************************************************//
	/*
	 * GETTERS AND SETTERS
	 */
	//********************************************************************************//

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

	public DataChart getDataChart() {
	
		return dataChart;
	
	}

	public void setDataChart(DataChart dataChart) {
	
		this.dataChart = dataChart;
	
	}

}
