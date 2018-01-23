package ca.utoronto.utm.jugpuzzle;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author csc207 student
 * A view in the MVC model. It displays an additional window when either a game is won
 * or a user selects the options button to see more options.
 */
public class CreateFrame implements Observer {
	
	private JFrame mainFrame;

	public CreateFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 * Pops up a window when either the user wins the game or the options button is selected.
	 */
	@Override
	public void update(Observable o, Object arg) {
		Window window = (Window)o;
		JFrame jf = new JFrame("Options");					//Initialize a new frame
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		jf.setLocation(800,500);							//Adjust GUI properties
		jf.setSize(450, 300);
		jf.setResizable(false);
		jf.setVisible(true);
		mainFrame.setVisible(false);							//Stop the user from accessing it
		jf.add(new MenuPanel(jf, mainFrame, window.getStatus()));	//Add the Menu panel on to it
	}
}
