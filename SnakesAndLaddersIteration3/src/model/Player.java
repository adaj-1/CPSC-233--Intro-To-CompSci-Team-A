package model;

import java.util.Random;
import java.util.Scanner;

/**
 * This class is abstract and extended by specific player types
 * ie. Human, Computer and BlankPlayer.
 * 
 * It contains the methods needed for moving a players. 
 * It also extends the SnakesAndLadders which contains the methods
 * for checking if a player has landed on a snake or ladder
 * 
 * @author Luke
 * 
 */
public abstract class Player extends SnakesAndLadders {
	protected String name;
	protected String[] player;
	protected int position = 1;
	protected int count = 0;
	protected Scanner playerInput;
	protected int diceRoll;
	protected int validRoll;
	
	/**
	* This is the empty constructor which is only used by blank player
	* 
	*/
	public Player() {
	}

	/**
	 * This constructor creates a player with named with the string 
	 * that is passed to it as an argument. 
	 * It also sets the player to the first game space.
	 * 
	 * @param name
	 */
	public Player(String name) {
		this.name = name;
		
		/* this creates an empty list of blank spaces for text board spacing */
		player = new String[101];
		for (int i = 0; i < 101; i++) {
			player[i] = "  ";
		}
		player[1] = name;
	}
	
	/**
	 * This move is for the text based version, it calls the dice roll method and 
	 * adds the value of the dice roll to the current players position. (if the total number is < 100)
	 * else the player remains on their current space until they roll exactly 100
	 * 
	 * It prints out a message with the players name and what they rolled,
	 * as well checking if the player landed on a snake or a ladder
	 */ 
	public void MovePlayer() {
		diceRoll=dice();
		validRoll = diceRoll + position;
		
		/* this checks the roll + current position to make sure it's < 100*/
		if (validRoll <= 100) {
			
			/* this checks if the player has landed on a snake/ladder */
			validRoll = Ladder(validRoll);
			validRoll = Snake(validRoll);
			System.out.println(name + " rolled a " + diceRoll + ", and landed on " + 
							   validRoll + ".");
			
			this.setPosition(validRoll);
		} else if (validRoll > 100) {
			System.out.println(name + " rolled over 100, try again!");			
		}		
	}
	
	/**
	 * This move is for the GUI based version, it calls the dice roll method and 
	 * adds the value of the dice roll to the current players position. (if the total number is < 100)
	 * else the player remains on their current space until they roll exactly 100
	 * It also checks to see if a player has landed on a snake or ladder
	 * 
	 */ 	
	public void MovePlayerGUI() {
		
		diceRoll = dice();
		validRoll = diceRoll + this.getPosition();
		
		/* this checks the roll + current position to make sure it's < 100*/
		if (validRoll <= 100) {
			
			/* this checks if the player has landed on a snake/ladder */
			validRoll = LadderGUI(validRoll);		
			validRoll = SnakeGUI(validRoll);			
			this.setPosition(validRoll);
		} 
	}
	
	/**
	 * This simulates the rolling a dice and returns a number between 1-6 inclusive
	 * @return diceRoll
	 */
	public int dice() {
	int max = 6;
	int min = 1;
	Random randomNum = new Random();
	int diceRoll = randomNum.nextInt((max - min) + 1) + min; // Source: https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
	return diceRoll;
	}	
	
	/**
	 * This returns this players string array which contains either two blank spaces,
	 * or the two letter player name for the text based board print out
	 * @return
	 */
	public String[] getPlayer(){
		return this.player;
	}
	
	/**
	 * This returns this players name
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * This returns this players position
	 * @return
	 */
	public int getPosition() {
		return this.position;
	}

	/**
	 * This sets the players position in the players string array,
	 * as well as clearing the players name from it's old space.
	 * It also sets the int position
	 * @param spaceNum
	 */
	public void setPosition(int spaceNum) {
		this.player[position] = "  ";
		this.player[spaceNum] = name;
		this.position = spaceNum;
	}
	
	/**
	 * This returns the players dice roll
	 * @return
	 */
	public int getDiceRoll() {
		return this.diceRoll;
	}
	
	/**
	 * This returns the players dice roll added with their current position
	 * @return
	 */
	public int getValidRoll() {
		return this.validRoll;
	}
}
