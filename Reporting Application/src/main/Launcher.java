package main; 

import javax.swing.SwingUtilities;

import main.display.Display;

/**
 * Creates a new <b>Launcher</b>. <b>SwingUtilities.invokeLater</b> is called to run the <b>Swing</b>
 * components on the <b>Swing Event Dispatch Thread</b> to prevent any conflicts with the main <b>Thread</b>.
 * A <b>Display</b> is created with a title, width, height, and command arguments in order to launch the game,
 * assuming successful login credentials are input.
 * @author Calvin Novicki
 * @see SwingUtilities
 * @see Display
 */
public class Launcher {

	/**
	 * This is the main starting point of the <b>Launcher</b>.
	 * @param args
	 */
	public static void main(String[] args) {
		//SwingUtilties.invokeLater is called here, and takes in a new Runnable object.
		SwingUtilities.invokeLater(new Runnable() {
			//This is the method to run on the Swing EDT.
			@Override
			public void run() {
				//Creates a new display and passes in the width, height, and command arguments.
				Display display = new Display(800, 600);
				//Creates the display.
				display.createDisplay();
				
			}
			
		});
		
	}
	
}
