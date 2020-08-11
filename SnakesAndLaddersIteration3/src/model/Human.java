package model;

import java.util.Scanner;

/**
 * This class handles the methods for human players
 * @author Luke
 *
 */
public class Human extends Player {
	
	/**
	 * This constructor is unused in Human
	 */
	public Human() {
	}
	
	/**
	 * This constructor uses the super constructor, making a player
	 * with the name passes as an argument 
	 * @param name
	 */
	public Human(String name) {
	 super(name);
	}
	
	/**
	 * This method if for the text based version prompts the user to input 'r' 
	 * in order to roll, as well as printing out the players name and roll.
	 * 
	 * It also checks whether the player landed on a snake or ladder
	 */
	public void MovePlayer(){
		System.out.println("It is your turn player " + name +  
						   " if you would like to roll, type 'r'");
		
		/* this takes the input from the user to roll */
		playerInput = new Scanner(System.in);
		String isRoll = playerInput.nextLine();
		if(isRoll.equals("r")) {
			diceRoll=dice();
			
			/* this checks if the player has landed on a snake/ladder */
			int validRoll=diceRoll+position;
			if (validRoll <= 100) {
				validRoll = Ladder(validRoll);
				validRoll = Snake(validRoll);
			
				System.out.println(name + " rolled a " + diceRoll + ", and landed on " + 
								   validRoll + ".");
				this.setPosition(validRoll);
			} else if (validRoll > 100) {
				System.out.println(name + " rolled over 100, try again!");
				
			}
			
			this.setPosition(position);
			}
	}		
	
	/**
	 * This move for the GUI version, it calls the super method
	 */
	public void MovePlayerGUI(){
		super.MovePlayerGUI();
	}
}
