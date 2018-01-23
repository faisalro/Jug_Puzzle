package ca.utoronto.utm.jugpuzzle;
import javax.swing.*;  
import java.awt.*;
import java.awt.event.*; 

/**
 * 
 * @author csc207 student
 * End the game when the corresponding button is selected
 */
public class Quit implements ActionListener {
	
	/**
	 * Ends the game.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);	
	}

}
