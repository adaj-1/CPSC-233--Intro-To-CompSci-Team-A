package model;
import java.util.Random;

public class Move { // Jada
	public Move() {
		
	}
	public String[] MovePlayer(String[] PlayerList, String playerName ){
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
			System.out.println("You rolled a " + diceRoll + ", and you landed on " + validRoll + ".");
			return PlayerList;
		} else if (validRoll > 100) {
			System.out.println("Rolled over 100, try again!");
			
		}
		PlayerList[currentPosition]=playerName;
		return PlayerList;
	}
	
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
				System.out.print("You went down a snake! ");
			}
		}
		return position;	
	}
	
	public int dice() {
	int max = 6;
	int min = 1;
	Random randomNum = new Random();
	int diceRoll = randomNum.nextInt((max - min) + 1) + min; // Source: https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
//	System.out.println("You rolled a " + diceRoll);
	return diceRoll;
	}
}
