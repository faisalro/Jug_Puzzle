package ca.utoronto.utm.jugpuzzle;
import javax.swing.*;  

import java.util.Observable;
import java.util.Observer; 

/**
 * 
 * @author csc207 student
 * View in the MVC model.
 * Updates the label when a move is made.
 */
public class UpdateMoves extends JLabel implements Observer {
	
	/**
	 * Displays the updated number of moves on the label.
	 */
	@Override
	public void update(Observable o, Object arg) {
		JugPuzzle jugPuzzle = (JugPuzzle)o;
		this.setText(String.valueOf("# of Moves: " + jugPuzzle.getMoves()));		
	}
	
}
