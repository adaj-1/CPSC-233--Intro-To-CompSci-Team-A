package model;

import java.util.ArrayList;
import application.GameboardController;
import java.util.Scanner;

	/**
	 * This Class is for setting up the game.
	 * There are two versions, the text and the
	 * GUI versions.
	 */
public class GameConfiguration extends Move { 
	
	/**
	 * These variables are for setting up the game.
	 * These include: Constants for the game setup (maximum
	 * number of players, finishing space on the board,
	 * lists for the players, number of computer players,
	 * human players and counter for total players).
	 */
	final static int FINISHING_SPACE = 100;		
	final static int MAX_PLAYERS=4;
	private ArrayList<Player> players = new ArrayList<Player>(); 
	private static Scanner playerInput;
	private int numComputer = 0;
	private int numHuman = 0;
	private int playerCounter = 0;
	private String gameType = "txtBased";


	/**
	 * This method creates a instance of GameConfiguration.
	 */
	public GameConfiguration() {
		
	}
	
	public GameConfiguration(String type) {
			this.gameType = type;
	}
	
	/**
	 * This method is for setting up the text version of the game,
	 * prompting for input from console.
	 * The user will input the number of human and computer players.
	 */
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
	
	/**
	 * This method is for setting up the GUI version of the game.
	 * Based on the selections in the GUI, it will create the number
	 * of human and computer players.
	 * It will also create a number of blank players, based on the
	 * selection of number of players to correctly space out the board.
	 * @param numOfHum takes in the number of human players.
	 * @param numOfComp takes in the number of computer players.
	 */
	public void GUIGameSetup(int numOfHum, int numOfComp) {
				
		/* Creates human players */
		if (numOfHum > 0) {
			createHumanPlayers();
		}
		
		/* Creates computer players */		
		if (numOfComp > 0) {
			createComputerPlayers();
		}
		
		/* Creates blank players for board spacing */
		if ((numOfHum + numOfComp) < MAX_PLAYERS) {
			createBlankPlayers();
		}
	}
	
	/**
	 * This method adds a created player to the player list.
	 * @param aPlayer
	 * @param index of player.
	 */
	public void addPlayer(Player aPlayer, int index) {
		players.add(index, aPlayer);
	}
	
	/**
	 * This method returns the list of players.
	 * @return
	 */
	public ArrayList<Player> getPlayer() {
		return this.players;
	}
	
	/**
	 * This method uses a for loop to create a number
	 * of human players, based on the user input.
	 */
	public void createHumanPlayers() {
		for (int i = 0; i < numHuman; i++) {
			Player human = new Player("human", "P" + (i + 1));
			players.add(playerCounter, human);
			playerCounter++;
		}
	}
	
	/**
	 * This method uses a for loop to create a number
	 * of computer players, based on the user input.
	 */
	public void createComputerPlayers() {
		for (int i = 0; i < numComputer; i++) {
			Player computer = new Player("AI", "C" + (i + 1));
			players.add(playerCounter, computer);
			playerCounter++;
		}
	}
	
	/**
	 * If the number of human and computer players is
	 * less than 4, blank players will be created for
	 * the board spacing.
	 */
	public void createBlankPlayers() {
		for (int i = 0; i < (MAX_PLAYERS - playerCounter); i++) {
			Player player = new Player();
			players.add(playerCounter, player);
		}
	}
	
	/**
	 * This method checks if the player passed in
	 * as a argument is a human.
	 * @param aPlayer
	 * @returns the type of player.
	 */
	public boolean isHuman(Player aPlayer) {
		return aPlayer.getType() == "human";
	}
	
	/**
	 * This method checks if the player passed in
	 * as a argument is a computer
	 * @param aPlayer
	 * @returns type of player.
	 */
	public boolean isComputer(Player aPlayer) {
		return aPlayer.getType() == "AI";
	}
	
	/**
	 * This method takes aPlayerList and aPlayer as arguments.
	 * If the player is a human, the program will prompt the
	 * user via console to roll the dice, and move the player.
	 * If the player is a computer, it will not ask for input,
	 * and move the computer player. After the player is moved,
	 * the game board will reprint to show the user the movement
	 * of the player on the board.
	 * @param aPlayerList
	 * @param aPlayer
	 */
	public void playerTurn(ArrayList<Player> aPlayerList, Player aPlayer) {
		
		if (isHuman(aPlayer)) {
			System.out.println("It is your turn player " + aPlayer.getName() 
					  +  " if you would like to roll, type 'r'");
			playerInput = new Scanner(System.in);
			String isRoll = playerInput.nextLine();
			if(isRoll.equals("r")) {
					MovePlayer(aPlayer);
					GameBoard.drawBoard(aPlayerList.get(0), aPlayerList.get(1), aPlayerList.get(2),
										aPlayerList.get(3));
			}
		} else if (isComputer(aPlayer)){
			MoveComputer(aPlayer.getPlayer(), aPlayer.getName());
			GameBoard.drawBoard(aPlayerList.get(0), aPlayerList.get(1), aPlayerList.get(2), 
								aPlayerList.get(3));
		}
	}
	
	/**
	 * This method is the same as playerTurn, but for
	 * the GUI version of the game.
	 * @param aPlayerList
	 * @param aPlayer
	 */
	public void playerTurnGUI(ArrayList<Player> aPlayerList, Player aPlayer) {
		if (isHuman(aPlayer)) {
			MovePlayer(aPlayer);
		} else if (isComputer(aPlayer)) {
			MoveComputer(aPlayer.getPlayer(), aPlayer.getName());
		}
	}
	
	
	/**
	 * This method sets up the game, and runs the game using
	 * a do while loop, until a player's last space is not empty,
	 * meaning that the game will be over. The console will print
	 * a message indicating which player won.
	 */
	public void run()  {
	/*
	 *  this should print out our start menu for all user inputs
	 *  this should ask for all user inputs ( # human players,
	 *  # computer players) check for valid inputs (example: max 4 players) and
	 *  provide user input arguments for methods
	 *  
	 *   (do while loop until a player reaches 100)
	 *  Then calls GameBoard 
	 */
		if (this.gameType == "txtBased") {
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
			
			if (p1.getPlayer()[FINISHING_SPACE] != "  ") {
				System.out.println(p1.getName() + " has won");
			} else if (p2.getPlayer()[FINISHING_SPACE] != "  ") {
				System.out.println(p2.getName() + " has won");
			} else if (p3.getPlayer()[FINISHING_SPACE] != "  ") {
				System.out.println(p3.getName() + " has won");
			} else {
				System.out.println(p4.getName() + " has won");
			}
		}
	}
	
	/**
	 * This method instantiates the class
	 * @param args
	 */
	public static void main(String[] args) {
		GameConfiguration app = new GameConfiguration();		// instantiates the class
		app.run();	
	}
}
	






