import java.util.Scanner;
public class GameConfiguration { // Nathan
	
	// this is our TextApplication 
	// should call GameBoard and take inputs from user

	final static int FINISHING_SPACE = 100;		
	final static int MAX_PLAYERS=4;
	private String[] board;

	private Scanner playerInput;
	
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
	 *  # computer players) check for valid inputs (example: max 4 players) and
	 *  provide user input arguments for methods
	 *  
	 *   (do while loop until a player reaches 100)
	 *  Then calls GameBoard
	 *  
	 *  while loop of (counter > 4) and use a counter to keep track of turn
	 *  
	 */
		Boolean validNumPlayers=false;
		Boolean validGameSetup=false;
		int numPlayers=0;
		int numComputer=0;
		int numHuman=0;
		int turnCounter=0;

		playerInput = new Scanner(System.in);
		System.out.println("Welcome to Snakes and Ladders!");
			do {
						System.out.println("Enter the total number of players (computer and human): ");
						numPlayers=playerInput.nextInt();
						if(numPlayers<2||numPlayers>4) System.out.println("Error: Invalid number of players");
						else {
							validNumPlayers=true;
						}
				}while(validNumPlayers.equals(false));
				do {
						System.out.println("Enter number of human players");
						numHuman=playerInput.nextInt();
						if(numHuman<numPlayers) {
							System.out.println("Enter number of computer players");
							numComputer=playerInput.nextInt();
						}
						if(numComputer+numHuman==numPlayers) {
							validGameSetup=true;
						}
					}while(validGameSetup.equals(false));
					
		GameBoard.Draw();
		
		while(turnCounter<5) {
			
		}
		
		
				
	}
	
	
	public static void main(String[] args) {
		GameConfiguration app = new GameConfiguration();		// instantiates the class
		app.run();	
	}
}
	






