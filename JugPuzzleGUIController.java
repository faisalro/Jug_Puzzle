package ca.utoronto.utm.jugpuzzle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
/**
 * 
 * @author csc207 student
 * This class allows the user to play an instance of the game Jug Puzzle.
 * It displays the GUI of the game and works as a compiler for all the panels 
 * and buttons involved.
 * 
 */
public class JugPuzzleGUIController {
	
	static JugPuzzle jugPuzzle;
	static JTextField moves;
	static boolean flag = true;
	static Window window;
	static JPanel masterPanel = new JPanel(new CardLayout());
	
	/**
	 * Starts the game Jug Puzzle.
	 */
	public JugPuzzleGUIController()  {
		jugPuzzle = new JugPuzzle();
		window = new Window();
	}
	
	/**
	 * Generates the Main GUI. Attaches additional panels to the main
	 * interface. It also adjusts the GUI properties.
	 */
	public static void createAndShowGUI()  {
		
		JFrame jf=new JFrame("Jug Puzzle");						//Initializes main frame
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Adjusts properties
		jf.setLayout(new BorderLayout(30,15));
		jf.getContentPane().setBackground(Color.white);
		
		JLabel label = new JLabel("Jug Puzzle");				//Title
		jf.getContentPane().add(label, BorderLayout.NORTH);		//add it to the main frame
		label.setHorizontalAlignment(0); 						//Extras
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Courier New", Font.BOLD, 25));
		
		JugPanel2 panel2 = new JugPanel2(jugPuzzle);		
		JugPanel panel = new JugPanel(jugPuzzle);		
		
		masterPanel = new JPanel(new CardLayout());
		masterPanel.add(panel, "JugPanel");			
		masterPanel.add(panel2, "JugPanel2");
		jf.getContentPane().add(masterPanel, BorderLayout.WEST);//Attaches the Panel responsible for Jugs
		
		JButton menu = new JButton("Options");					//Initialize Option Button
		jf.add(menu, BorderLayout.LINE_END);					//add it to the frame
		ShowMenu t = new ShowMenu(window);			
		menu.addActionListener(t);								//Added action listener (opens a new window)
		menu.setHorizontalAlignment(0); 						//Extras
		menu.setSize(new Dimension(20,20));
		menu.setBackground(Color.lightGray); 	
		menu.setForeground(Color.BLUE);
		
		UpdateMoves moves = new UpdateMoves();					//Displays moves
		jf.add(moves, BorderLayout.SOUTH);						//added it to main frame
		moves.setForeground(Color.BLUE);						//Extras
		moves.setHorizontalAlignment(0);
		
		jf.setLocation(800,500);								//Adjust GUI properties
		jf.setSize(450, 300);
		jf.setResizable(true);
		jf.setVisible(true);
		
		jugPuzzle.addObserver(moves);							//Add the 'view' moves to the model
		CreateFrame frame = new CreateFrame(jf);
		window.addObserver(frame);
	}
	
	public static void changeTheme() {
		CardLayout cl = (CardLayout)(masterPanel.getLayout());
		cl.next(masterPanel);		
	}
	

	/**
	 * Starts the GUI and allows the game to begin.
	 * @param args is not used, though required.
	 */
	public static void main(String[] args) {
		JugPuzzleGUIController GUIC = new JugPuzzleGUIController();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
