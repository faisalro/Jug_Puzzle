package ca.utoronto.utm.jugpuzzle;

import javax.swing.*;  

import java.util.Observable;
import java.util.Observer;

/**
 * 
 * @author csc207 student
 * A view in the MVC model. Displays the individual jug statuses for JugPanel2.
 */
public class AmountLabel extends JLabel implements Observer {
	private int i;
		
	/**
	 * Constructor for the labels in the second panel
	 * @param i keeps track of the index of the jug to display status for.
	 */
	AmountLabel(int i) {
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

