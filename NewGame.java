package ca.utoronto.utm.jugpuzzle;
import javax.swing.*;  
import java.awt.*;
import java.awt.event.*; 

/**
 * 
 * @author csc207 student
 * starts a new game when the corresponding button is selected.
 */
public class NewGame implements ActionListener {

	private JFrame mainFrame;
	
	public NewGame(JFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	/**
	 * restarts an instance of JugPuzzle.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JugPuzzleGUIController.main(new String[0]);
		this.mainFrame.dispose();
		MenuPanel.closeWindow();
		}
	}
	


