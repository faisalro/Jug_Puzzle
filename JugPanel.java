package ca.utoronto.utm.jugpuzzle;
import javax.swing.*;
import javax.swing.event.AncestorListener;

import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;
import java.util.Observable;
import java.util.Observer; 

/**
 * 
 * @author cscs207 Student
 * A controller in the MVC Model. Default Visual of the game Jug Puzzle.
 * Generates a panel consisting of the three jugs used to play the game.
 */
public class JugPanel extends JPanel{
	private JugPuzzle jugPuzzle;
	private GameJug[] jugs = new GameJug[3];

	/**
	 * Creates a panel with the three jugs. 
	 * @param jugPuzzle the jug puzzle game
	 */
	public JugPanel(JugPuzzle jugPuzzle){
		this.jugPuzzle = jugPuzzle;
		createAndShowGUI();
	}
	/**
	 * Sets up the panel with the three jugs and adjusts their properties. 
	 */
	private void createAndShowGUI() {

		setMinimumSize(new Dimension(100,100));
		setBackground(Color.white);
		JLabel label1 = new JLabel();	label1.setPreferredSize(new Dimension(5,5));		//Blank spaces between jugs
		JLabel label2 = new JLabel();	label2.setPreferredSize(new Dimension(5,5));	
		JugPanelListener j = new JugPanelListener(jugs, jugPuzzle);
		for (int i = 0; i < 3; i++) {
			jugs[i] = new GameJug(i);   
			jugs[i].addActionListener(j);	jugPuzzle.addObserver(jugs[i]);
			jugs[i].setPreferredSize(new Dimension(100-i*8,150-i*20));						//Change size depending on the capacity of the jug
			jugs[i].setBackground(Color.CYAN);												//Extras
		}	
		add(jugs[0]);   add(label1);	add(jugs[1]);	add(label2);	add(jugs[2]);		//Add the jugs on to the panel with spaces
	}
	
}
