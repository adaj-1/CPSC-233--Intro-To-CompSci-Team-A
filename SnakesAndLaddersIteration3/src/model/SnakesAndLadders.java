/**
 * This class creates all the snakes and ladders for textbased and GUI version
 * of this game.
 * 
 * @version 3.0 11 August 2020
 * @author Jada Li, Nathan Jung, Luke Couture, and Arlina Dey
 *
 */
package model;

import java.util.Random;

public class SnakesAndLadders {
	/* the below section of instance variables are used for the text based version of the game */
	protected int[] snakesStart = {97, 92, 42, 47};
	protected int[] snakesEnd = {77, 72, 22, 27};
	protected int[] laddersStart = {3, 9, 55, 60};
	protected int[] laddersEnd = {23, 29, 75, 80};
	/* the below section of instance variables are used for the GUI based version of the game */
	private static int[] snakesStartGUI = new int[6];
	private static int[] snakesEndGUI = new int[6];
	private static int[] laddersStartGUI = new int[6];
	private static int[] laddersEndGUI = new int[6];
	
	/**
	 * constructor that initializes the snakes and ladders at the beginning
	 */
	public SnakesAndLadders() {	
		initializeSnakeLadder();
	}
	
	/**
	 * This sets the position of the ladders on the gameboard.
	 * @param position checks players current position
	 * @returns position of player after player goes up the ladder.
	 */
	public int Ladder(int position) {
		for (int counter = 0; counter < laddersStart.length; counter++) {
			if (position == laddersStart[counter]) {				
				position = laddersEnd[counter];
				System.out.println("You went up a ladder!");
			}
		}
		return position;	
	}
	
	/**
	 * This sets the positions of the snakes on the gameboard.
	 * @param position checks players current position
	 * @returns position of player after player goes down a snake.
	 */	
	public int Snake(int position) {
		for (int counter = 0; counter < snakesStart.length; counter++) {
			if (position == snakesStart[counter]) {
				position = snakesEnd[counter];
				System.out.println("You went down a snake!");
				
			}
		}
		return position;	
	}
	
	/**
	 * this checks whether a player has landed on a ladder 
	 * @param position checks players current position
	 * @return position of player after player goes up the ladder
	 */
	public int LadderGUI(int position) {
		for (int counter = 0; counter < 6; counter++) {
			if (position == getLaddersStart()[counter]) {
				position = getLaddersEndGUI()[counter];
			}
		}
		return position;	
	}
	
	/**
	 * this checks whether a player has landed on a snake 
	 * @param position checks players current position
	 * @return position of player after player goes down a snake
	 */
	public int SnakeGUI(int position) {
		
		for (int counter = 0; counter < 6; counter++) {			
			if (position == getSnakesStart()[counter]) {
				position = getSnakesEndGUI()[counter];
			}
		}
		return position;	
	}
	
	/**
	 * this method generates a random true or false
	 * @return a random true or false
	 */
	public static boolean getRandomBoolean() {
		Random random = new Random();
		return random.nextBoolean();
	}
	
	/**
	 * this method randomly generates the snakes and ladders for the GUI version of the game
	 */
	public static void initializeSnakeLadder() {
		/* the below section of code randomly generates ladders and snakes using if statements for each index */
		if (getRandomBoolean() == true) {
			laddersStartGUI[0] = 4;
		} else {
			laddersStartGUI[0] = 37;
		}
		if (getRandomBoolean() == true) {
			laddersStartGUI[1] = 18;
		} else {
			laddersStartGUI[1] = 41;
		}
		if (getRandomBoolean() == true) {
			laddersStartGUI[2] = 30;
		} else {
			laddersStartGUI[2] = 87;
		}
		if (getRandomBoolean() == true) {
			laddersStartGUI[3] = 51;
		} else {
			laddersStartGUI[3] = 14;
		}
		if (getRandomBoolean() == true) {
			laddersStartGUI[4] = 55;
		} else {
			laddersStartGUI[4] = 58;
		}
		if (getRandomBoolean() == true) {
			laddersStartGUI[5] = 62;
		} else {
			laddersStartGUI[5] = 73;
		}
		setLaddersStartGUI(laddersStartGUI);

		
		
		if (laddersStartGUI[0] == 4) {
			laddersEndGUI[0] = 25;
		} else {
			laddersEndGUI[0] = 56;
		}
		if (laddersStartGUI[1] == 18) {
			laddersEndGUI[1] = 39;
		} else {
			laddersEndGUI[1] = 59;
		}
		if (laddersStartGUI[2] == 30) {
			laddersEndGUI[2] = 49;
		} else {
			laddersEndGUI[2] = 94;
		}
		if (laddersStartGUI[3] == 51) {
			laddersEndGUI[3] = 72;
		} else {
			laddersEndGUI[3] = 33;
		}
		if (laddersStartGUI[4] == 55) {
			laddersEndGUI[4] = 74;
		} else {
			laddersEndGUI[4] = 77;
		}
		if (laddersStartGUI[5] == 62) {
			laddersEndGUI[5] = 96;
		} else {
			laddersEndGUI[5] = 92;
		}
		setLaddersEndGUI(laddersEndGUI);
		
		if (getRandomBoolean() == true) {
			snakesStartGUI[0] = 93;
		} else {
			snakesStartGUI[0] = 97;
		}
		if (getRandomBoolean() == true) {
			snakesStartGUI[1] = 83;
		} else {
			snakesStartGUI[1] = 96;
		}
		if (getRandomBoolean() == true) {
			snakesStartGUI[2] = 57;
		} else {
			snakesStartGUI[2] = 21;
		}
		if (getRandomBoolean() == true) {
			snakesStartGUI[3] = 52;
		} else {
			snakesStartGUI[3] = 80;
		}
		if (getRandomBoolean() == true) {
			snakesStartGUI[4] = 46;
		} else {
			snakesStartGUI[4] = 34;
		}
		if (getRandomBoolean() == true) {
			snakesStartGUI[5] = 26;
		} else {
			snakesStartGUI[5] = 16;
		}
		
		setSnakesStartGUI(snakesStartGUI);
		
		if (snakesStartGUI[0] == 93) {
			snakesEndGUI[0] = 71;
		} else {
			snakesEndGUI[0] = 76;
		}
		if (snakesStartGUI[1] == 83) {
			snakesEndGUI[1] = 65;
		} else {
			snakesEndGUI[1] = 74;
		}
		if (snakesStartGUI[2] == 57) {
			snakesEndGUI[2] = 42;
		} else {
			snakesEndGUI[2] = 3;
		}
		if (snakesStartGUI[3] == 52) {
			snakesEndGUI[3] = 47;
		} else {
			snakesEndGUI[3] = 58;
		}
		if (snakesStartGUI[4] == 46) {
			snakesEndGUI[4] = 17;
		} else {
			snakesEndGUI[4] = 29;
		}
		if (snakesStartGUI[5] == 26) {
			snakesEndGUI[5] = 9;
		} else {
			snakesEndGUI[5] = 7;
		}
		setSnakesEndGUI(snakesEndGUI);

	}
	
	/**
	 * the method returns the generate snake starting position array
	 * @return snakesStartGUI array
	 */
	public int[] getSnakesStart() {
		return snakesStartGUI;
	}
	
	/**
	 * the method returns the generate ladder starting position array
	 * @return laddersStartGUI array
	 */
	public int[] getLaddersStart() {
		return laddersStartGUI;
	}
	/**
	 * the method returns the generate snake ending position array
	 * @return snakesEndGUI array
	 */
	public int[] getSnakesEndGUI() {
		return snakesEndGUI;
	}
	
	/**
	 * the method returns the generate ladder ending position array
	 * @return laddersEndGUI array
	 */
	public int[] getLaddersEndGUI() {
		return laddersEndGUI;
	}

	/**
	 * this method sets the snake starting position array
	 * @param snakesStartGUI
	 */
	public static void setSnakesStartGUI(int[] snakesStartGUI) {
		SnakesAndLadders.snakesStartGUI = snakesStartGUI;
	}
	
	/**
	 * this method sets the snake ending position array
	 * @param snakesEndGUI
	 */
	public static void setSnakesEndGUI(int[] snakesEndGUI) {
		SnakesAndLadders.snakesEndGUI = snakesEndGUI;
	}

	/**
	 * this method sets the ladder starting position array
	 * @param laddersStartGUI
	 */
	public static void setLaddersStartGUI(int[] laddersStartGUI) {
		SnakesAndLadders.laddersStartGUI = laddersStartGUI;
	}

	/**
	 * this method sets the ladder ending position array
	 * @param laddersEndGUI
	 */
	public static void setLaddersEndGUI(int[] laddersEndGUI) {
		SnakesAndLadders.laddersEndGUI = laddersEndGUI;
	}
}
