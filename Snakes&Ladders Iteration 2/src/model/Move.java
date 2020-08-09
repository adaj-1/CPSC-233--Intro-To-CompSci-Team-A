package model;

import java.util.Random;

public class Move { // Jada
	private int playerPosition;
	private int[] snakesStartGUI = new int[6];
	private int[] snakesEndGUI = new int[6];
	
	private int[] laddersStartGUI = new int[6];
	private int[] laddersEndGUI = new int[6];
	public Move() {
		
	}
	public Player MovePlayer(Player currentPlayer){
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
			}
		}
		return position;	
	}
	
	public boolean getRandomBoolean() {
		Random random = new Random();
		return random.nextBoolean();
	}
	
	public int LadderGUI(int position) {
		
		
		for (int counter = 0; counter < 6; counter++) {
			if (position == laddersStartGUI[counter]) {
				
				position = laddersEndGUI[counter];
			}
		}
		return position;	
	}
	
	public int SnakeGUI(int position) {
		
		for (int counter = 0; counter < 6; counter++) {
			if (position == snakesStartGUI[counter]) {
				position = snakesEndGUI[counter];
			}
		}
		return position;	
	}
	
	public void initializeSnakeLadder() {
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
		setLaddersStart(laddersStartGUI);
		System.out.println("ladders start");
		for (int i = 0; i < getSnakesStart().length; i++) {
			System.out.println(getLaddersStart()[i]);
		}
		
		
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
		System.out.println("ladders end");
		for (int i = 0; i < getSnakesStart().length; i++) {
			System.out.println(laddersEndGUI[i]);
		}
		
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
		setSnakesStart(snakesStartGUI);
		System.out.println("snake start");
	for (int i = 0; i < getSnakesStart().length; i++) {
		System.out.println(getSnakesStart()[i]);
	}
		
		
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
		System.out.println("snakes end");
		for (int i = 0; i < getSnakesStart().length; i++) {
			System.out.println(snakesEndGUI[i]);
		}
	}
	
	public int[] getSnakesStart() {
		return snakesStartGUI;
	}
	
	public void setSnakesStart(int[] snakesStart) {
		this.snakesStartGUI = snakesStart;
	}
	
	public int[] getLaddersStart() {
		return laddersStartGUI;
	}
	
	public void setLaddersStart(int[] laddersStart) {
		this.laddersStartGUI = laddersStart;
	}
	
	public int dice() {
	int max = 6;
	int min = 1;
	Random randomNum = new Random();
	int diceRoll = randomNum.nextInt((max - min) + 1) + min; // Source: https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
//	System.out.println("You rolled a " + diceRoll);
	return diceRoll;
	}
	
	public int getPlayerPosition() {
		return playerPosition;
	}
	public void setPlayerPosition(int playerPosition) {
		this.playerPosition = playerPosition;
	}
}
