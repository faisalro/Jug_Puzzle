package ca.utoronto.utm.jugpuzzle;
import javax.swing.*;  

import java.util.Observable;
import java.util.Observer;

/**
 * 
 * @author csc207 student
 * The view in MVC model. Displays the updated amount in a jug
 * in the default theme.
 * 
 */
public class GameJug extends JButton implements Observer {
	private int i;
	
	/**
	 * 
	 * @param i keeps track of the index of the jug to display on to.
	 */
	GameJug(int i) {
		this.i = i;
	}
	
	/**
	 * Updates the jug status.
	 */
	@Override
	public void update(Observable o, Object arg) {
		JugPuzzle jug = (JugPuzzle)o;
		this.setText(jug.getJugs()[i].toString());		
	}
	
}
