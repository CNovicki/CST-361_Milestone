package main.display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import business.UserBusiness;
import utils.ColorFactory;

/**
 * Creates a new <b>Display</b> for the <b>Launcher</b> with a <b>JFrame</b>, <b>JPanel<b/>,
 * and <b>MenuBar</b>. This is the top-level component of the <b>Launcher</b>.
 * @author Calvin Novicki
 * @see JFrame
 * @see JPanel
 * @see MenuBar
 */
public class Display {

	/**
	 * This is the <b>Launcher</b> <b>JFrame</b>.
	 */
	private JFrame frame;
	
	/**
	 * This is the <b>Launcher</b> <b>JPanel</b>.
	 */
	private JPanel panel;
		
	/**
	 * This is the <b>MenuBar</b>.
	 */
	private MenuBar menuBar;
	
	/**
	 * change color panel.
	 */
	private ColorPanel colorPanel;
	
	/**
	 * data chart panel.
	 */
	private DataChart dataChart;
	
	/**
	 * 
	 */
	private DataEntry dataEntry;
		
	/**
	 * This is the width of the <b>Launcher</b>.
	 */
	private int width;
	
	/**
	 * This is the height of the <b>Launcher</b>.
	 */
	private int height;
	
	/**
	 * This is the <b>UserBusiness</b>.
	 */
	private UserBusiness userBusiness;
	
	/**
	 * Creates a new <b>Display</b> that takes in the title, width, height, and command arguments.
	 * @param title
	 * @param width
	 * @param height
	 * @param args
	 */
	public Display(int width, int height) {
		//Instantiates the width.
		this.width = width;
		//Instantiates the height.
		this.height = height;
		//Initializes the JFrame with the title.
		frame = new JFrame("Reporting Application");
		//Initializes the JPanel.
		panel = new JPanel();
		//Initializes the UserBusiness.
		userBusiness = new UserBusiness();
		//Initializes the MenuBar with this, a width, height, color, and arguments.
		menuBar = new MenuBar(this, width, 150, Color.LIGHT_GRAY);
		
		colorPanel = new ColorPanel(this, 320, 50, Color.LIGHT_GRAY);
		
		dataChart = new DataChart(this, 320, 320, Color.LIGHT_GRAY);
		
		dataEntry = new DataEntry(this, dataChart, 320, 50, Color.LIGHT_GRAY);
				
	}
	
	/**
	 * Creates and draws the display to the screen.
	 */
	public void createDisplay() {
		//Sets the size of the JFrame.
		frame.setSize(width, height);
		//Sets the minimum size of the JFrame.
		frame.setMinimumSize(new Dimension(600, 600));
		//Sets the default close operation of the JFrame to exit.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Sets the JFrame to resizable.
		frame.setResizable(true);
		//Sets the location of the JFrame to the center.		
		frame.setLocationRelativeTo(null);
		//Sets the layout of the JFrame to BorderLayout.
		frame.setLayout(new BorderLayout());
		//Sets the preferred size of the panel.
		panel.setPreferredSize(new Dimension(width, height));
		
		panel.setLayout(new GridBagLayout());
		
		panel.setBackground(ColorFactory.getColor("lightblue"));
		
		colorPanel.createColorPanel();
		
		dataChart.createDataChart();
										
		dataEntry.createDataEntry();
		//Adds the JPanel to the JFrame to the North.
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		//Creates the MenuBar.
		menuBar.createMenuBar();
		//Adds the MenuBar to the JFrame to the South.
		frame.getContentPane().add(menuBar.getMenuPanel(), BorderLayout.SOUTH);
		//Packs the JFrame.
		frame.pack();
		//Sets the JFrame to visible.
		frame.setVisible(true);
		
	}
	
	//********************************************************************************//
	/*
	 * GETTERS AND SETTERS
	 */
	//********************************************************************************//

	public JFrame getFrame() {
	
		return frame;
	
	}

	public void setFrame(JFrame frame) {
	
		this.frame = frame;
	
	}

	public JPanel getPanel() {
	
		return panel;
	
	}

	public void setPanel(JPanel panel) {
	
		this.panel = panel;
	
	}
	
	public MenuBar getMenuBar() {
		
		return menuBar;
	
	}

	public void setMenuBar(MenuBar menuBar) {
	
		this.menuBar = menuBar;
	
	}
	
	public ColorPanel getColorPanel() {
	
		return colorPanel;
	
	}

	public void setColorPanel(ColorPanel colorPanel) {
	
		this.colorPanel = colorPanel;
	
	}

	public DataChart getDataChart() {
	
		return dataChart;
	
	}

	public void setDataChart(DataChart dataChart) {
	
		this.dataChart = dataChart;
	
	}

	public DataEntry getDataEntry() {
	
		return dataEntry;
	
	}

	public void setDataEntry(DataEntry dataEntry) {
	
		this.dataEntry = dataEntry;
	
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
	
	public UserBusiness getUserBusiness() {
	
		return userBusiness;
	
	}

	public void setUserBusiness(UserBusiness userBusiness) {
	
		this.userBusiness = userBusiness;
	
	}
	
}
