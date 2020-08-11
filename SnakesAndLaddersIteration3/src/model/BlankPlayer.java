package model;

/**
 * This method creates blank players needed for board spacing
 * on the text based version of the game
 * 
 * @author Luke
 *
 */
public class BlankPlayer extends Player {

	/**
	 * This creates blank players with blank names
	 */
	public BlankPlayer() {
		this.name = "  ";
		player = new String[101];
		for (int i = 0; i < 101; i++) {
			player[i] = "  ";
		}
	}
	
	/**
	 * This method is unused for blank players
	 */
	public void MovePlayer() {
	}

	/**
	 * This method is unused for blank players
	 */
	public void MovePlayerGUI() {
	}
}
