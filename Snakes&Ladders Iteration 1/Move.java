
public class Move { //Jada
	
	// for this iteration these will be constant variables
	private int ladderStart = 10;
	private int ladderEnd;
	private int snakeStart;
	private int snakeEnd;
	
	
	public Move(Player player) {	
		// calls get method to getPosition
		// dice method and adds to the player index
		// check if snake or ladder by calling methods below and passing back the index
		// call set method to setPosition	
	}

	/*
	 *  move will take the dice roll and add that to the player index ( to move the player)
	 *  then it will check if that number lands on a ladder or a snake. 
	 *  then it will clear the players previous index with a blank " " so that player does not
	 *  appear in two spots on the game board
	 */

	
	public int Ladder() {
		// method checks if the index is a ladder. if so, passes new index if not index remains the same
		return 0;	
	}
	
	public int Snake() {
		// method checks if the index is a snake. if so, passes new index if not index remains the same
		return 0;	
	}

	public int dice() {
		// use random to generate one die roll up to 6		
		return 0;
	}
}
