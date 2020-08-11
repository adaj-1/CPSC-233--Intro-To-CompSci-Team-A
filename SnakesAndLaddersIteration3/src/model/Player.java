package model;

import java.util.Random;
import java.util.Scanner;

/**
 * This class retrieves player names, types, and 
 * their positions and sets them.
 */
public abstract class Player extends SnakesAndLadders { // Arlina
	protected String name;
	protected String[] player;
	protected int position = 1;
	protected int count = 0;
	protected Scanner playerInput;
	protected int diceRoll;
	protected int validRoll;
	
	/**
	* This constuctor creates spaces on the
	* gameboard for each of the players.
	*/
	public Player() {
	}

	/**
	 * This constructor takes in the type and
	 * name of the players. It then sets them
	 * according to their positions.
	 * @param type
	 * @param name
	 */
	public Player(String name) {
		this.name = name;
		player = new String[101];
		for (int i = 0; i < 101; i++) {
			player[i] = "  ";
		}
		player[1] = name;
	}
	
	public void MovePlayer() {
		/**
		 * This saves the dice rolls of each
		 * player if they are valid and sets their
		 * new position according to the number they rolled.
		 * @returns currentPlayers position
		 */
		
		diceRoll=dice();
		
		validRoll = diceRoll + position;
		if (validRoll <= 100) {
			validRoll = Ladder(validRoll);
			validRoll = Snake(validRoll);
			System.out.println(name + " rolled a " + diceRoll + ", and landed on " + validRoll + ".");
			
			this.setPosition(validRoll);
		} else if (validRoll > 100) {
			System.out.println(name + " rolled over 100, try again!");			
		}		
	}
	
	/**
	 * Duplicates previous methods for GUI.
	 */	
	public void MovePlayerGUI() {
		
		diceRoll = dice();
		validRoll = diceRoll + this.getPosition();
		if (validRoll <= 100) {
			validRoll = LadderGUI(validRoll);		
			validRoll = SnakeGUI(validRoll);			
			this.setPosition(validRoll);
		} 
	}
	
	public int dice() {
	int max = 6;
	int min = 1;
	Random randomNum = new Random();
	int diceRoll = randomNum.nextInt((max - min) + 1) + min; // Source: https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
	return diceRoll;
	}	
	
	/**
	 * The getters and setters retrieves the
	 * number of players, their names, positions,
	 * and sets them.
	 *
	 */
	public String[] getPlayer(){
		return this.player;
	}
	
	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int spaceNum) {
		this.player[position] = "  ";
		this.player[spaceNum] = name;
		this.position = spaceNum;
	}
	
	/**
	 * These save the dice rolls of
	 * each player after they roll.
	 */
	public int getDiceRoll() {
		return this.diceRoll;
	}

	public int getValidRoll() {
		return this.validRoll;
	}
}
