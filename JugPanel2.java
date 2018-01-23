package ca.utoronto.utm.jugpuzzle;
import javax.swing.*;
import javax.swing.event.AncestorListener;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer; 
import javax.swing.JTextField;

/**
 * 
 * @author csc207 student
 * A controller in the MVC Model. A panel with a different theme than the default. 
 * Displays jugs and their corresponding label with their statuses in a Grid Pattern.
 */
public class JugPanel2 extends JPanel {
	
	private JugPuzzle jugPuzzle;
	private AmountLabel[] amountLabel = new AmountLabel[3];
	private static GameJug[] jugs = new GameJug[3];
	
	/**
	 * Creates a GUI for the Jug Puzzle.
	 * @param jugPuzzle the game jug puzzle.
	 */
	public JugPanel2(JugPuzzle jugPuzzle){
		
		this.jugPuzzle = jugPuzzle;
		createAndShowGUI();
	}
	/**
	 * Creates the panel with Jugs and their corresponding labels with each jugs status
	 * underneath them.
	 */
	private void createAndShowGUI(){
		JugPanelListener j = new JugPanelListener(jugs, jugPuzzle);
		setLayout(new GridLayout(2,3,10,10));	setPreferredSize(new Dimension(300,50));
		setBackground(Color.WHITE);
		
		for (int i = 0; i < 3; i++) {
			jugs[i] = new GameJug(i);   	add(jugs[i]);	
			jugs[i].addActionListener(j);	jugs[i].setBackground(Color.CYAN);			
			amountLabel[i] = new AmountLabel(i);	jugPuzzle.addObserver(amountLabel[i]);	
			amountLabel[i].setHorizontalAlignment(0);
		}
		for (int i = 0; i < 3; i++) {add(amountLabel[i]);}
	}

	
}
