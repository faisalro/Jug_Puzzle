package ca.utoronto.utm.jugpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author csc207 student
 * Takes jugs from either Panel yet makes the same moves.
 * Responsible for spilling from one jug into another.
 */
public class JugPanelListener implements ActionListener {
	JButton[] jugs;
	Object c = null;
	boolean flag = false;
	private JugPuzzle jugPuzzle;

	/**
	 * Allows the user to make moves in the game.
	 * @param jugs the jugs from the game
	 * @param jugPuzzle the Jug Puzzle game
	 */
	JugPanelListener(JButton[] jugs, JugPuzzle jugPuzzle){
		this.jugs = jugs;
		this.jugPuzzle = jugPuzzle;
	}
	/**
	 * when the two selected, it spills from the first selected jug into the 
	 * later selected one. Also determines when the user has won the game.
	 */
	@Override
	public void actionPerformed(ActionEvent move){
		
		if (!flag) {c = move.getSource(); flag = !flag;}		//wait for the second selection.
		else {
			int i1 = tellJug(c);	 int i2 = tellJug(move.getSource());		//get indices.
			jugPuzzle.move(i1,i2);		//Spill
			flag = !flag;
		}
		if (jugPuzzle.getIsPuzzleSolved()) {
			JugPuzzleGUIController.window.Win();	//inform that the user has won.
		}
	}
	
	/**
	 * Determines which jug was selected.
	 * @param button the Jug selected
	 * @return index of the jug in array jugs in the class JugPuzzle.
	 */
	public int tellJug(Object button) {	
		if (button == jugs[0]) return 0;
		else if (button == jugs[1]) return 1;
		else return 2;
	}

}
