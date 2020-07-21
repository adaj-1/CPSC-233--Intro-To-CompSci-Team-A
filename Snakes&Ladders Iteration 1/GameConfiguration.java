import java.util.Scanner;
public class GameConfiguration { // Nathan
	
	// this is our TextApplication 
	// should call GameBoard and take inputs from user

	final static int FINISHING_SPACE = 100;		
	
	private String[] board;

	private Scanner numPlayers;
	
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
		Boolean valid=false;
		int numComputer=0;
		Scanner playerInput = new Scanner(System.in);
		System.out.println("Welcome to Snakes and Ladders!");
				do {
				
				System.out.println("Enter the number of human players: ");
				int numHuman = playerInput.nextInt();	
				if(numHuman==1){
					System.out.println("Enter the number of computer players: ");
					numComputer = playerInput.nextInt();
				}
				if((numHuman==2&&numComputer==0)||(numHuman==1&&numComputer==1)) {
					if(numHuman==1&&numComputer==1) {
						System.out.println("Enter in the name of the human player (Three letters): ");
						String p1Name= playerInput.nextLine();
						String p1Type="Human";
						String p2Name="Computer";
						String p2Type="Computer";
					}
					else if(numHuman==2&&numComputer==0) {
						System.out.println("Enter in the name of the first player (Three letters): ");
						String p1Name= playerInput.nextLine();
						String p1Type="Human";
						System.out.println("Enter in the name of the second player (Three letters): ");
						String p2Name= playerInput.nextLine();
						String p2Type= "Human";
					}
					valid=true;
				}
				if(numHuman!=2||numHuman!=1) {
					System.out.println("Error: invalid player number");
				}else if(numComputer!=1) {
					System.out.println("Error: invalid number of computer players!");
			} 
				
			}while(valid.equals(false));
					
		
		
	}
	
	
	public static void main(String[] args) {
		GameConfiguration app = new GameConfiguration();		// instantiates the class
		app.run();	
	}
}
	






