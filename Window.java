package ca.utoronto.utm.jugpuzzle;

import java.util.Observable;

/**
 * 
 * @author csc207 student
 * A Model in the MVC model. Determines which window should be opened.
 * 
 */
public class Window extends Observable {
	
	boolean win;
	/**
	 * An options window must open by default.
	 */
	Window(){
		this.win = false;
	}
	/**
	 * Returns the type of window is required. Where a true implies
	 * one with winning message on it and false for the default.
	 * @return a boolean expression inferring the type of window that should be displayed.
	 */
	public boolean getStatus() {
		return this.win;
	}
	/**
	 * Changes the required window type by changing the variable.
	 * @param bool boolean expression to set the variable to.
	 */
	private void window(boolean bool) {
		this.win = bool;
		this.setChanged();
		this.notifyObservers();
	}
	/**
	 * sets up to display a end of game window.
	 */
	public void Win() {
		window(true);
	}
	/**
	 * sets up to display the default "options" window.
	 */
	public void Options() {
		window(false);
	}
	
}
