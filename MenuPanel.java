package ca.utoronto.utm.jugpuzzle;
import javax.swing.*;  
import java.awt.*;
import java.awt.event.*; 

/**
 * 
 * @author csc207 student
 * A menu panel with multiple options depending on the context of the call.
 * It either displays a victory message with other options or simply presents 
 * the general in game options. A Controller in the MVC model.
 */
public class MenuPanel extends JPanel{
	static JFrame jf;
	JFrame mainFrame;
	
	/**
	 * Creates the Panel provided the context.
	 * 
	 * @param jf the frame where panel is will be applied on to.
	 * @param mainFrame the main window with the jugs.
	 * @param gameFinished determines the type of window is required (provides context)
	 */
	public MenuPanel(JFrame jf, JFrame mainFrame, boolean gameFinished) {
		this.jf = jf;
		this.mainFrame = mainFrame;
		createAndShowWindow(gameFinished);	
	}
	
	/**
	 * Creates the Menu panel with multiple options depending on
	 * where it is being called. i.e. at the end of the game or to display additional options.
	 * It either displays a winning message and presents options to restart and quit, or 
	 * with additional optional to change theme or resume.
	 * 
	 * @param gameFinished determines if its a end of game window or an Options menu.
	 */
	public void createAndShowWindow(boolean gameFinished) {
		
		setBackground(Color.GRAY);
		setMaximumSize(new Dimension(100,50));
		
		if (!gameFinished) {					//if its a normal window
			setLayout(new GridLayout(4,1,20,20));
			JButton resume = new JButton("Resume");		JButton theme = new JButton("Change Theme");
			Resume r = new Resume(mainFrame);			ChangeTheme c = new ChangeTheme(mainFrame);
			resume.addActionListener(r);				theme.addActionListener(c);
			add(resume);								add(theme);		
			resume.setBackground(Color.LIGHT_GRAY);		theme.setBackground(Color.LIGHT_GRAY);
		}
		else {									//if its a game end window
			setLayout(new GridLayout(3,1,20,20));
			JLabel congrats = new JLabel("Congratulations!! You have solved the puzzle!");
			congrats.setHorizontalAlignment(0); 	congrats.setForeground(Color.CYAN); 
			congrats.setFont(new Font("Courier New", Font.BOLD, 15));
			add(congrats);		
		}
		
		Quit q = new Quit();	NewGame ng = new NewGame(mainFrame);		//Initialize action listeners
		JButton newGame = new JButton("New Game");		JButton quit = new JButton("Quit");	//Buttons
		newGame.addActionListener(ng);	quit.addActionListener(q);			//Added action listeners
		add(newGame);		add(quit);										//added on to the panel
		newGame.setBackground(Color.LIGHT_GRAY); 		quit.setBackground(Color.LIGHT_GRAY);	
	}
	
	/**
	 * Closes the options window. 
	 */
	public static void closeWindow() {
		jf.dispose();
	}
}
