package main.display;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import beans.SensorData;
import beans.User;
import business.SensorDataBusiness;

/**
 * Menu panel for login.
 * @author Calvin Novicki
 *
 */
public class MenuBar implements ActionListener {

	/**
	 * Main menu panel.
	 */
	private JPanel menuPanel;
	
	/**
	 * label for username.
	 */
	private JLabel usernameLabel;
	
	/**
	 * label for password.
	 */
	private JLabel passwordLabel;
	
	/**
	 * username input.
	 */
	private JTextField usernameField;
		
	/**
	 * password input.
	 */
	private JPasswordField passwordField;
	
	/**
	 * get help label.
	 */
	private JLabel helpLabel;
		
	/**
	 * submit button.
	 */
	private JButton submitButton;
	
	/**
	 * passed-in display.
	 */
	private Display display;
	
	/**
	 * panel width.
	 */
	private int width;
	
	/**
	 * panel height.
	 */
	private int height;
	
	/**
	 * panel height.
	 */
	private Color color;
	
	/**
	 * username.
	 */
	private String username;
	
	/**
	 * password.
	 */
	private String password;
		
	/**
	 * Createss a new menu bar.
	 * @param display
	 * @param width
	 * @param height
	 * @param color
	 */
	public MenuBar(Display display, int width, int height, Color color) {
				
		this.display = display;
		
		this.width = width;
		
		this.height = height;
		
		this.color = color;
				
		menuPanel = new JPanel();
		
		usernameLabel = new JLabel("Username:");
		
		passwordLabel = new JLabel("Password:");
		
		usernameField = new JTextField();
				
		passwordField = new JPasswordField();
		
		helpLabel = new JLabel("<html><u>need an account?</u></html>");
				
		submitButton = new JButton("Submit");
		
	}
	
	/**
	 * Creates menu bar GUI.
	 */
	public void createMenuBar() {
		
		GridBagConstraints c = new GridBagConstraints();
		
		menuPanel.setLayout(new GridBagLayout());
		
		menuPanel.setPreferredSize(new Dimension(width, height));
		
		menuPanel.setMinimumSize(new Dimension(width, height));
		
		menuPanel.setMaximumSize(new Dimension(width, height));
		
		menuPanel.setBackground(color);
		
		c.insets = new Insets(5, 5, 5, 5);
		
		menuPanel.add(usernameLabel, c);
				
		usernameField.setPreferredSize(new Dimension(100, 20));
		
		usernameField.setText(username);
						
		menuPanel.add(usernameField, c);
		
		c.insets = new Insets(5, 5, 0, 5);
		
		c.gridy = 1;
				
		menuPanel.add(passwordLabel, c);
										
		passwordField.setPreferredSize(new Dimension(100, 20));
		
		passwordField.setText(password);
								
		menuPanel.add(passwordField, c);
		
		helpLabel.setForeground(Color.BLUE);
		
		helpLabel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				helpLabel.setForeground(new Color(255, 255, 255));
				
				try {
					
					Desktop.getDesktop().browse(new URI("http://localhost:8080/PiClassProject/Register.xhtml"));
					
				}
				
				catch(IOException | URISyntaxException e1) {
					
					e1.printStackTrace();
					
				}
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				helpLabel.setForeground(new Color(153, 51, 255));
						
			}
			
		});
		
		c.insets = new Insets(0, 5, 5, 5);
		
		c.gridx = 1;
		
		c.gridy = 2;
														
		menuPanel.add(helpLabel, c);
						
		submitButton.setPreferredSize(new Dimension(90, 20));
		
		submitButton.addActionListener(this);
		
		c.insets = new Insets(5, 5, 5, 5);
		
		c.gridy = 3;
								
		menuPanel.add(submitButton, c);
		
	}
	
	/**
	 * Action for submit button.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		User user = display.getUserBusiness().getUser(usernameField.getText());
		
		String password = Arrays.toString(passwordField.getPassword()).replaceAll("[, ]", "");

		password = password.substring(1, password.length() - 1);
						
		if(user.getPassword().equals(encryptPassword(password))) {
			
			usernameField.setText("");
			
			passwordField.setText("");
			
			GridBagConstraints c = new GridBagConstraints();
			
			c.insets = new Insets(5, 5, 5, 5);
			
			c.gridy = 0;
			
			display.getPanel().add(display.getColorPanel().getColorPanel(), c);
			
			c.gridy = 1;
			
			display.getPanel().add(display.getDataChart().getDataPanel(), c);
			
			c.gridy = 2;

			display.getPanel().add(display.getDataEntry().getDataEntryPanel(), c);
											
			SensorDataBusiness sensorDataBusiness = new SensorDataBusiness();

			SensorData[] sensorData = sensorDataBusiness.getAllSensorData();
						
			JLabel pressure = null;
			
			JLabel temperature = null;
			
			JLabel date = null;
						
			GridBagConstraints c2 = new GridBagConstraints();
			
			for(int i = 0; i < sensorData.length; i++) {
				
				pressure = new JLabel(Double.toString(sensorData[i].getPressure()));
				
				temperature = new JLabel(Double.toString(sensorData[i].getTemperatureInFahrenheit()));
				
				date = new JLabel(sensorData[i].getTimestamp());
				
				c2.gridy = i;
								
				c2.insets = new Insets(5, 5, 5, 5);
			
				c2.gridx = 0;
								
				display.getDataChart().getScrollablePanel().add(pressure, c2);
				
				c2.gridx = 1;
				
				display.getDataChart().getScrollablePanel().add(temperature, c2);

				c2.gridx = 2;
				
				display.getDataChart().getScrollablePanel().add(date, c2);
				
				display.getDataChart().getScrollablePanel().revalidate();
									
			}
			
			display.getPanel().revalidate();
			
		}
				
	}

	/**
	 * Takes in a string of plaintext, and encrypts using a SHA-256 hash.
	 * @param plaintext
	 * @return
	 */
	private String encryptPassword(String plaintext) {
		//Creates a new StringBuffer.
		StringBuffer hexString = new StringBuffer();
		//Try Block.
		try {
			//Creates a new MessageDigest of SHA-256
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			//Creates a new has byte array and gets the bytes of the plaintext in UTF-8 as the MessageDigest.
			byte[] hash = digest.digest(plaintext.getBytes("UTF-8"));
			//Loops through all bytes in the hash.
			for (byte element : hash) {
				//Creates a hex string and performs an binary AND on each bit of the element byte.
				String hex = Integer.toHexString(0xff & element);
				//Checks if the lengh of the hex is greater than 1.
				if(hex.length() == 1) {
					//Appends 0 to the hex string.
					hexString.append('0');
					
				}
				//Appends the hex value to the hex string.
				hexString.append(hex);
								
			}
			//Returns the hex string, which is properly hashed.
			return hexString.toString();
		
		}
		//Catches a NoSuchAlgorithmExeption and an UnsupportedEncodingException.
		catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			//TODO Add Fatal Error.
			e.printStackTrace();
		
		}
		//Returns the hex string, which is not properly hashed.
		return hexString.toString();
		
	}
	
	//********************************************************************************//
	/*
	 * GETTERS AND SETTERS
	 */
	//********************************************************************************//

	public JPanel getMenuPanel() {
	
		return menuPanel;
	
	}

	public void setMenuPanel(JPanel menuPanel) {
	
		this.menuPanel = menuPanel;
	
	}

	public JLabel getUsernameLabel() {
		
		return usernameLabel;
		
	}

	public void setUsernameLabel(JLabel usernameLabel) {
		
		this.usernameLabel = usernameLabel;
		
	}

	public JLabel getPasswordLabel() {
		
		return passwordLabel;
	
	}

	public void setPasswordLabel(JLabel passwordLabel) {
		
		this.passwordLabel = passwordLabel;
	
	}

	public JTextField getUsernameField() {
		
		return usernameField;
	
	}

	public void setUsernameField(JTextField usernameField) {
		
		this.usernameField = usernameField;
	
	}

	public JPasswordField getPasswordField() {
		
		return passwordField;
	
	}

	public void setPasswordField(JPasswordField passwordField) {
		
		this.passwordField = passwordField;
	
	}

	public JLabel getHelpLabel() {
	
		return helpLabel;
	
	}

	public void setHelpLabel(JLabel helpLabel) {
	
		this.helpLabel = helpLabel;
	
	}

	public JButton getSubmitButton() {
	
		return submitButton;
	
	}

	public void setSubmitButton(JButton submitButton) {
	
		this.submitButton = submitButton;
	
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

	public String getUsername() {
	
		return username;
	
	}

	public void setUsername(String username) {
	
		this.username = username;
	
	}

	public String getPassword() {
	
		return password;
	
	}

	public void setPassword(String password) {
	
		this.password = password;
	
	}

}
