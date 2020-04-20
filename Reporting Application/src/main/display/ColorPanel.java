package main.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import utils.ColorFactory;

/**
 * Panel to change background color.
 * @author Calvin Novicki
 *
 */
public class ColorPanel extends SwingPanel implements SwingInterface {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * blue button
	 */
	private JButton[] buttons;
	/**
	 * Creates a new color panel.
	 * @param display
	 * @param width
	 * @param height
	 * @param color
	 */
	public ColorPanel(Display display, int width, int height, Color color) {
		
		super(display, width, height, color);
		
		buttons = new JButton[3];
						
		buttons[0] = new JButton("Blue");
		
		buttons[1] = new JButton("Red");
		
		buttons[2] = new JButton("Green");
		
	}

	/**
	 * Creates all GUI elements.
	 */
	@Override
	public void createAndShowGUI() {
		
		super.createAndShowGUI();
		
		for(int i = 0; i < buttons.length; i++) {
			
			buttons[i].setPreferredSize(new Dimension(width / 4, height - 10));
			
			buttons[i].setMinimumSize(new Dimension(width / 4, height - 10));
			
			buttons[i].setMaximumSize(new Dimension(width / 4, height - 10));
			
			final int index = i;
			
			buttons[i].addActionListener(new ActionListener() {
							
				@Override
				public void actionPerformed(ActionEvent e) {
					
					switch(index) {
						
						case 1:
							
							display.getPanel().setBackground(ColorFactory.getColor("lightred"));
							
							break;
							
						case 2:
							
							display.getPanel().setBackground(ColorFactory.getColor("lightgreen"));

							break;
							
						default:
							
							display.getPanel().setBackground(ColorFactory.getColor("lightblue"));
							
							break;
					
					
					}
										
					display.getPanel().revalidate();
					
					
				}
				
			});
			
			add(buttons[i]);
			
		}
		
	}
	
	//********************************************************************************//
	/*
	 * GETTERS AND SETTERS
	 */
	//********************************************************************************//

	public JButton[] getButtons() {
	
		return buttons;
	
	}

	public void setButtons(JButton[] buttons) {
	
		this.buttons = buttons;
	
	}
	
}
