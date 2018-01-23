package ca.utoronto.utm.jugpuzzle;
import javax.swing.*;  
import java.awt.*;
import java.awt.event.*; 

/**
 * 
 * @author csc207 student
 * Action Listener to the Button "Options". It pops up a window with in game options 
 * i.e. resume, new game and quit.
 */
public class ShowMenu implements ActionListener {
	private Window window;
	
	/**
	 * Keeps track of the main frame.
	 * @param mainFrame the main window.
	 */
	ShowMenu(Window window) {
		this.window = window;
	}
	
	/**
	 * A new window with multiple options is displayed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		window.Options();		//informs the model to that it is a options menu
	}


}
