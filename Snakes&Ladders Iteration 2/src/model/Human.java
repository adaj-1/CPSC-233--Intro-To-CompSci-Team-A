package model;

import java.util.Scanner;

public class Human extends Player {

	public Human() {
	}

	public Human(String name) {
	 super(name);
	}
	
	public void MovePlayer(){
		System.out.println("It is your turn player " + name +  " if you would like to roll, type 'r'");
		playerInput = new Scanner(System.in);
		String isRoll = playerInput.nextLine();
		if(isRoll.equals("r")) {
			diceRoll=dice();
			
			int validRoll=diceRoll+position;
			if (validRoll <= 100) {
				validRoll = Ladder(validRoll);
				validRoll = Snake(validRoll);
			
				System.out.println(name + " rolled a " + diceRoll + ", and landed on " + validRoll + ".");
				this.setPosition(validRoll);
			} else if (validRoll > 100) {
				System.out.println(name + " rolled over 100, try again!");
				
			}
			
			this.setPosition(position);
			}
	}		

	public void MovePlayerGUI(){
		super.MovePlayerGUI();
	}
}
