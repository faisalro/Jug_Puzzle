package ca.utoronto.utm.jugpuzzle;
import javax.swing.*;  
import java.awt.*;
import java.awt.event.*; 

/**
 * 
 * @author csc207 student
 * Allows the user to continue with their game when the menu is opened.
 */
public class Resume implements ActionListener {

	private JFrame mainFrame;
	
	public Resume(JFrame mainFrame){
		this.mainFrame = mainFrame;
	}

	/**
	 * closes the popped up window and allows the game to continue.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mainFrame.setVisible(true);		
		MenuPanel.closeWindow();
	}
}
