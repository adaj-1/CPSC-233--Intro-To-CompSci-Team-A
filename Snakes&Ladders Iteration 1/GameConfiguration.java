import java.util.ArrayList;
import java.util.Scanner;
public class GameConfiguration extends Move{ // Nathan
	
	// this is our TextApplication 
	// should call GameBoard and take inputs from user

	final static int FINISHING_SPACE = 100;		
	final static int MAX_PLAYERS=4;
	private String[] board;
	private ArrayList <String> PlayerList = new ArrayList <String> (); //arrayList of player objects
	private static Scanner playerInput;
	
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
		String playerName="  ";
		int player1Roll=0;
		int player2Roll=0;
		int player3Roll=0;
		int player4Roll=0;

		playerInput = new Scanner(System.in);
		System.out.println("Welcome to Snakes and Ladders!");
		
//		String[] player = new String[101];
//		for (int i = 0; i < 101; i++) {
//			player[i] = "  ";
//		}

//		for (int i = 0; i < 4; i++) {
//			PlayerList.add(player[i]);
//		}
		
//						System.out.println("Enter number of human players");
//						numHuman=playerInput.nextInt();
//						if(numHuman>5) {
//							System.out.println("Error: invalid number of players");
//						}else if(numHuman<=4&&numHuman>=0){
//							System.out.println("Enter number of computer players");
//							numComputer=playerInput.nextInt();
//							if(numComputer+numHuman>4) {
//								System.out.println("Error: Too many computers");
//							}
//						}else {
//							System.out.println("Error: invalid number");
//						}
//						if(numHuman>0) {
//							System.out.println("Enter the initials for the player: ");
//							playerName=playerInput.nextLine();
//							Player firstPlayer= new Player(playerName);
//							
//							
//							
//							}
//							System.out.println(PlayerList);
//						
//						if(numHuman+numComputer<4) {
//							
//						}
			
		String[] player1 = new String[101];
		for (int i = 0; i < 101; i++) {
			player1[i] = "  ";
		}
		String[] player2 = new String[101];
		for (int i = 0; i < 101; i++) {
			player2[i] = "  ";
		}
		String[] player3 = new String[101];
		for (int i = 0; i < 101; i++) {
			player3[i] = "  ";
		}
		String[] player4 = new String[101];
		for (int i = 0; i < 101; i++) {
			player4[i] = "  ";
		}
//		System.out.println("Enter initials for player one: ");
//		String p1Name = playerInput.nextLine();
//		System.out.println("Enter initials for player two: ");
//		String p2Name = playerInput.nextLine();
//		System.out.println("Enter initials for player three: ");
//		String p3Name = playerInput.nextLine();
//		System.out.println("Enter initials for player four: ");
//		String p4Name = playerInput.nextLine();
		player1[1] = "P1";
		player2[1] = "P2";
		player3[1] = "P3";
		player4[1] = "P4";
		int currentP1=0;
		int currentP2=0;
		int currentP3=0;
		int currentP4=0;
		GameBoard.drawBoard(player1, player2, player3, player4);
		do {
			System.out.println("It is your turn player 1, if you would like to roll, type 'r'");
			String isP1Roll = playerInput.nextLine();
			if(isP1Roll.equals("r")) {
				MovePlayer(player1,"P1");
				}
				 GameBoard.drawBoard(player1, player2, player3, player4);
				 
//				 if(diceRoll > 6) {
//					 System.out.println("You went up a Ladder!");
//				 } else if (diceRoll < 0) {
//					 System.out.println("You went down a Snake!");
//				 }
			
			System.out.println("It is your turn player 2, if you would like to roll, type 'r'");
			String isP2Roll = playerInput.nextLine();
			if(isP2Roll.equals("r")) {
				MovePlayer(player2, "P2");
				}
				 GameBoard.drawBoard(player1, player2, player3, player4);
//				 if(diceRoll > 6) {
//					 System.out.println("You went up a Ladder!");
//				 } else if (diceRoll < 0) {
//					 System.out.println("You went down a Snake!");
//				 }

			
			System.out.println("It is your turn player 3, if you would like to roll, type 'r'");
			String isP3Roll = playerInput.nextLine();
			if(isP3Roll.equals("r")) {
				MovePlayer(player3, "P3");
				}	
				 GameBoard.drawBoard(player1, player2, player3, player4);
//				 if(diceRoll > 6) {
//					 System.out.println("You went up a Ladder!");
//				 } else if (diceRoll < 0) {
//					 System.out.println("You went down a Snake!");
//				 }
			
			System.out.println("It is your turn player 4, if you would like to roll, type 'r'");
			String isP4Roll = playerInput.nextLine();
			if(isP4Roll.equals("r")) {
				MovePlayer(player4, "P4");
				}
				 GameBoard.drawBoard(player1, player2, player3, player4);
//				 if(diceRoll > 6) {
//					 System.out.println("You went up a Ladder!");
//				 } else if (diceRoll < 0) {
//					 System.out.println("You went down a Snake!");
//				 }
			
				
		
		}while(player1[100] == "  " && player2[100] == "  " && player3[100] == "  " && player4[100] == "  ");
		if(player1[100].equals("  ")) {
			if(player2[100].equals("  ")) {
				if(player3[100].equals("  ")) {
					System.out.println("Player 4 has won");
					}else System.out.println("Player 3 has won");
				}else System.out.println("Player 2 has won");
			}else System.out.println("Player 1 has won");
			
		}

		
		
		
		
		
		
		
				
	
	
	
	public static void main(String[] args) {
		GameConfiguration app = new GameConfiguration();		// instantiates the class
		app.run();	
	}
}
	






