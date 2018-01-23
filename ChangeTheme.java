package ca.utoronto.utm.jugpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author csc207 student
 * Controller in the MVC Model. Changes the theme of the game.
 */
public class ChangeTheme implements ActionListener {

	private JFrame mainFrame;
	
	ChangeTheme(JFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	
	/**
	 * Changes the theme of the game then closes the options menu.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JugPuzzleGUIController.changeTheme();
		mainFrame.setVisible(true);
		MenuPanel.closeWindow();
	}

}
