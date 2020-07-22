import java.util.Random;

public class Move { // Jada
	
	public Move(Player player) {	
		int position = player.getPosition();
		int newPosition = position + dice();
		
		newPosition = Ladder(newPosition);
		newPosition = Snake(newPosition);
		
		if (newPosition <= 100) {
			player.setPosition(newPosition);
		} else if(newPosition > 100) {
			player.setPosition(position);
		}
	}

	public int Ladder(int position) {
		int[] laddersStart = new int[3];		
		laddersStart[0] = 3;
		laddersStart[1] = 9;
		laddersStart[2] = 55;
		laddersStart[3] = 60;
		
		int[] laddersEnd = new int[3];
		laddersEnd[0] = 23;
		laddersEnd[1] = 29;
		laddersEnd[2] = 75;
		laddersEnd[3] = 80;
		
		for (int counter = 0; counter < 4; counter++) {
			if (position == laddersStart[counter]) {
				position = laddersEnd[counter];
			}
		}
		return position;	
	}
	
	public int Snake(int position) {
		int[] snakesStart = new int[3];
		snakesStart[0] = 97;
		snakesStart[1] = 92;
		snakesStart[2] = 42;
		snakesStart[3] = 47;
		
		int[] snakesEnd = new int[3];
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
	
	public int dice() {
		int max = 6;
		int min = 1;
		Random randomNum = new Random();
		int diceRoll = randomNum.nextInt((max - min) + 1) + min; // Source: https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
		System.out.println(diceRoll);
		return diceRoll;
	}
}
