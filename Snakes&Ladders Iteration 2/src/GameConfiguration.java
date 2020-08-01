package model;
import java.util.ArrayList;
import java.util.Scanner;

public class GameConfiguration extends Move { // Nathan
	// this is our TextApplication 
	// should call GameBoard and take inputs from user

	final static int FINISHING_SPACE = 100;		
	final static int MAX_PLAYERS=4;
	private static ArrayList<Player> players = new ArrayList<Player>(); //arrayList of player objects
	private static Scanner playerInput;
	private int numComputer = 0;
	private int numHuman = 0;
	private int playerCounter = 0;
	
	public void gameSetup() {
		playerInput = new Scanner(System.in);
		System.out.println("Welcome to Snakes and Ladders!");
		System.out.println("How many human players would you like to play with? (max 4)");
		numHuman=playerInput.nextInt();
		
		if (numHuman < MAX_PLAYERS) {
			System.out.println("How many computer players would you like to play with?" + 
								" (max " + (MAX_PLAYERS - numHuman) + ")");
			numComputer=playerInput.nextInt();
		}
		
		/* Creates human players */
		if (numHuman > 0) {
			createHumanPlayers();
		}
		
		/* Creates computer players */		
		if (numComputer > 0) {
			createComputerPlayers();
		}
		
		/* Creates blank players for board spacing */
		if (playerCounter < MAX_PLAYERS) {
			createBlankPlayers();
		}
	}
	
	public void createHumanPlayers() {
		for (int i = 0; i < numHuman; i++) {
			Player human = new Player("human", "P" + (i + 1));
			players.add(playerCounter, human);
			playerCounter++;
		}
	}
	
	public void createComputerPlayers() {
		for (int i = 0; i < numComputer; i++) {
			Player computer = new Player("AI", "C" + (i + 1));
			players.add(playerCounter, computer);
			playerCounter++;
		}
	}
	
	public void createBlankPlayers() {
		for (int i = 0; i < (MAX_PLAYERS - playerCounter); i++) {
			Player player = new Player();
			players.add(playerCounter, player);
		}
	}
	
	public boolean isHuman(Player aPlayer) {
		return aPlayer.getType() == "human";
	}
	
	public boolean isComputer(Player aPlayer) {
		return aPlayer.getType() == "AI";
	}
	
	public void playerTurn(ArrayList<Player> aPlayerList, Player aPlayer) {
		
		if (isHuman(aPlayer)) {
			System.out.println("It is your turn player " + aPlayer.getName() +  " if you would like to roll, type 'r'");
			playerInput = new Scanner(System.in);
			String isRoll = playerInput.nextLine();
			if(isRoll.equals("r")) {
					MovePlayer(aPlayer.getPlayer(), aPlayer.getName());
					GameBoard.drawBoard(aPlayerList.get(0), aPlayerList.get(1), aPlayerList.get(2),
										aPlayerList.get(3));
			}
		} else if (isComputer(aPlayer)){
			MoveComputer(aPlayer.getPlayer(), aPlayer.getName());
			GameBoard.drawBoard(aPlayerList.get(0), aPlayerList.get(1), aPlayerList.get(2), 
								aPlayerList.get(3));
		}
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
	 *  
	 *  
	 */
		gameSetup();
				
		Player p1 = players.get(0);
		Player p2 = players.get(1);
		Player p3 = players.get(2);
		Player p4 = players.get(3);
		
		GameBoard.drawBoard(p1, p2, p3, p4);
		
		do {
			
			playerTurn(players, p1);
			playerTurn(players, p2);
			playerTurn(players, p3);
			playerTurn(players, p4);
	
		
		} while(p1.getPlayer()[FINISHING_SPACE] == "  " && 
				p2.getPlayer()[FINISHING_SPACE] == "  " &&
				p3.getPlayer()[FINISHING_SPACE] == "  " && 
				p4.getPlayer()[FINISHING_SPACE] == "  ");
		
		if (p1.getPlayer()[100] != "  ") {
			System.out.println(p1.getName() + " has won");
		} else if (p2.getPlayer()[100] != "  ") {
			System.out.println(p2.getName() + " has won");
		} else if (p3.getPlayer()[100] != "  ") {
			System.out.println(p3.getName() + " has won");
		} else {
			System.out.println(p4.getName() + " has won");
		}
	}
					
	public static void main(String[] args) {
		GameConfiguration app = new GameConfiguration();		// instantiates the class
		app.run();	
	}
}
	






