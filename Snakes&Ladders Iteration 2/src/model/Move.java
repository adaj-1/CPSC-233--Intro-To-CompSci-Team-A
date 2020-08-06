package model;

import java.util.Random;

public class Move { // Jada
	private int playerPosition;
	
	public Move() {
		
	}
	
	/**
	 * This method moves the players to their
	 * positions after the dice is rolled.
	 * @param currentPlayer
	 */
	public Player MovePlayer(Player currentPlayer){
		int currentPosition=0;
		int i=0;
		for (i=0; i<101;i++) {
			if (currentPlayer.getPlayer()[i]!="  ") {
				currentPosition=i;
				currentPlayer.getPlayer()[i]="  ";
			}
		}
		
		/**
		 * This saves the dice rolls of each
		 * player if they are valid and sets their
		 * new position according to the number they rolled.
		 * @returns currentPlayers position
		 */
		
		int diceRoll=dice();
		currentPlayer.setHoldDiceRoll(diceRoll);
		
		int validRoll=diceRoll+currentPosition;
		if (validRoll <= 100) {
			validRoll = Ladder(validRoll);
			validRoll = Snake(validRoll);
		
			currentPlayer.getPlayer()[validRoll]=currentPlayer.getName();
			System.out.println("You rolled a " + diceRoll + ", and you landed on " + validRoll + ".");
			currentPlayer.setPosition(validRoll);
			return currentPlayer;
		} else if (validRoll > 100) {
			System.out.println("Rolled over 100, try again!");
			
		}
		
		currentPlayer.getPlayer()[currentPosition]=currentPlayer.getName();
		currentPlayer.setPosition(currentPosition);
		
		return currentPlayer;
		
	}
	
	/**
	 * Duplicates previous methods for GUI.
	 */	
	public Player MovePlayerGUI(Player currentPlayer){
		int currentPosition=0;
		int i=0;
		for (i=0; i<101;i++) {
			if (currentPlayer.getPlayer()[i]!="  ") {
				currentPosition=i;
				currentPlayer.getPlayer()[i]="  ";
			}
		}
		
		int diceRoll=dice();
		currentPlayer.setHoldDiceRoll(diceRoll);
		
		int validRoll=diceRoll+currentPosition;
		if (validRoll <= 100) {
			validRoll = LadderGUI(validRoll);
			validRoll = SnakeGUI(validRoll);
		
			currentPlayer.getPlayer()[validRoll]=currentPlayer.getName();
			currentPlayer.setPosition(validRoll);
			return currentPlayer;
		}		
		currentPlayer.getPlayer()[currentPosition]=currentPlayer.getName();
		currentPlayer.setPosition(currentPosition);
		
		return currentPlayer;
		
	}
	
	/**
	 * This does the same thing as theprevious methods,
	 * but for the computer players.
	 * @param PlayerList
	 * @param playerName
	 * @returns the players name.
	 */
	public String[] MoveComputer(String[] PlayerList, String playerName ){
		int currentPosition=0;
		int i=0;
		for (i=0; i<101;i++) {
			if (PlayerList[i]!="  ") {
				currentPosition=i;
				PlayerList[i]="  ";
			}
		}
		int diceRoll=dice();
		int validRoll=diceRoll+currentPosition;
		if (validRoll <= 100) {
			validRoll = Ladder(validRoll);
			validRoll = Snake(validRoll);
		
			PlayerList[validRoll]=playerName;
			System.out.println(playerName + " rolled a " + diceRoll + ", and landed on " + validRoll + ".");
			return PlayerList;
		} else if (validRoll > 100) {
			System.out.println("Rolled over 100, try again!");
			
		}
		PlayerList[currentPosition]=playerName;
		return PlayerList;
	}
	
	/**
	 * This sets the position of the ladders
	 * on the gameboard.
	 * @param position
	 * @returns position of player after
	 * player goes up the ladder.
	 */
	public int Ladder(int position) {
		int[] laddersStart = new int[4];	
		laddersStart[0] = 3;
		laddersStart[1] = 9;
		laddersStart[2] = 55;
		laddersStart[3] = 60;
		
		int[] laddersEnd = new int[4];
		laddersEnd[0] = 23;
		laddersEnd[1] = 29;
		laddersEnd[2] = 75;
		laddersEnd[3] = 80;
		
		for (int counter = 0; counter < 4; counter++) {
			if (position == laddersStart[counter]) {
				
				position = laddersEnd[counter];
				System.out.print("You went up a ladder! ");
			}
		}
		return position;	
	}
	
	/**
	 * This sets the positions of the snakes
	 * on the gameboard.
	 * @param position
	 * @returns position of player after
	 * player goes down a snake.
	 */	
	public int Snake(int position) {
		int[] snakesStart = new int[4];
		snakesStart[0] = 97;
		snakesStart[1] = 92;
		snakesStart[2] = 42;
		snakesStart[3] = 47;
		
		int[] snakesEnd = new int[4];
		snakesEnd[0] = 77;
		snakesEnd[1] = 72;
		snakesEnd[2] = 22;
		snakesEnd[3] = 27;

		for (int counter = 0; counter < 4; counter++) {
			if (position == snakesStart[counter]) {
				position = snakesEnd[counter];
			}
		}
		return position;	
	}
	
	public int LadderGUI(int position) {
		int[] laddersStart = new int[6];	
		laddersStart[0] = 4;
		laddersStart[1] = 18;
		laddersStart[2] = 30;
		laddersStart[3] = 51;
		laddersStart[4] = 55;
		laddersStart[5] = 62;
		
		int[] laddersEnd = new int[6];
		laddersEnd[0] = 25;
		laddersEnd[1] = 39;
		laddersEnd[2] = 49;
		laddersEnd[3] = 72;
		laddersEnd[4] = 74;
		laddersEnd[5] = 96;
		
		for (int counter = 0; counter < 4; counter++) {
			if (position == laddersStart[counter]) {
				
				position = laddersEnd[counter];
			}
		}
		return position;	
	}
	
	public int SnakeGUI(int position) {
		int[] snakesStart = new int[6];
		snakesStart[0] = 93;
		snakesStart[1] = 83;
		snakesStart[2] = 57;
		snakesStart[3] = 52;
		snakesStart[4] = 45;
		snakesStart[5] = 26;
		

		
		int[] snakesEnd = new int[6];
		snakesEnd[0] = 71;
		snakesEnd[1] = 65;
		snakesEnd[2] = 42;
		snakesEnd[3] = 47;
		snakesEnd[4] = 18;
		snakesEnd[5] = 9;
		


		for (int counter = 0; counter < 4; counter++) {
			if (position == snakesStart[counter]) {
				position = snakesEnd[counter];
			}
		}
		return position;	
	}
	
	/**
	 * This method randomly rolls the dice
	 * and returns the number rolled.
	 */
	public int dice() {
	int max = 6;
	int min = 1;
	Random randomNum = new Random();
	int diceRoll = randomNum.nextInt((max - min) + 1) + min; // Source: https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
//	System.out.println("You rolled a " + diceRoll);
	return diceRoll;
	}
	
	/**
	 * Gets and sets psotion of players
	 * throughout the game.
	 * @returns player's position.
	 */
	public int getPlayerPosition() {
		return playerPosition;
	}
	public void setPlayerPosition(int playerPosition) {
		this.playerPosition = playerPosition;
	}
}
