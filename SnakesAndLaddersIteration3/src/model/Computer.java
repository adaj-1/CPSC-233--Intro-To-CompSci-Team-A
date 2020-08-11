package model;

/**
 * This class is for computer creation and moves
 * all methods call the super methods
 * 
 * @author Luke
 *
 */
public class Computer extends Player {

	/**
	 * This method is unused for Computer
	 */
	public Computer() {
	}
	
	/**
	 * This method creates a computer player with the name
	 * passed in as an argument
	 * @param name
	 */
	public Computer(String name) {
		super(name);
	}

	/**
	 * This move is for the text based version, it moves
	 * the player and prints the results
	 */
	public void MovePlayer() {
		super.MovePlayer();
	}
	
	/**
	 * This move is for the GUI based version, it auto rolls
	 * and moves the player
	 */
	public void MovePlayerGUI(){
		super.MovePlayerGUI();
	}
}
