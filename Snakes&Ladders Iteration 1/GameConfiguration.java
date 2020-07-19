
public class GameConfiguration { // Nathan
	
	// this is our TextApplication 
	// should call GameBoard and take inputs from user

	final static int FINISHING_SPACE = 100;		
	
	private String[] board;
	
	public GameConfiguration(){
		
	}
		
	public void updateIndex(Move move) {
		// updates player location through move method
	}
	
	public String toString() {
		return null;
	}
	
	public void run()  {
	/*
	 *  this should print out our start menu for all user inputs
	 *  this should ask for all user inputs ( # human players,
	 *  # computer players, player names) check for valid inputs (example: max 4 players) and
	 *  provide user input arguments for methods
	 *  
	 *   ( do while loop until a player reaches 100)
	 *  Then calls GameBoard
	 *  
	 *  while loop of (counter > 4) and use a counter to keep track of turn
	 *  
	 */
	
	}
	
	
	public static void main(String[] args) {
		GameConfiguration app = new GameConfiguration();		// instantiates the class
		app.run();	
	}
}
	






