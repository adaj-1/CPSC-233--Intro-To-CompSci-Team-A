package model;

import java.util.Random;

public class SnakesAndLadders {
	
	private static int[] snakesStartGUI = new int[6];
	private static int[] snakesEndGUI = new int[6];
	private static int[] laddersStartGUI = new int[6];
	private static int[] laddersEndGUI = new int[6];
	
	public SnakesAndLadders() {	
		initializeSnakeLadder();
	}
	
	public static boolean getRandomBoolean() {
		Random random = new Random();
		return random.nextBoolean();
	}
	
	public static void initializeSnakeLadder() {
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
	
	public int[] getSnakesStart() {
		return snakesStartGUI;
	}
	
	public int[] getLaddersStart() {
		return laddersStartGUI;
	}
	
	public int[] getSnakesEndGUI() {
		return snakesEndGUI;
	}


	public int[] getLaddersEndGUI() {
		return laddersEndGUI;
	}

	public static void setSnakesStartGUI(int[] snakesStartGUI) {
		SnakesAndLadders.snakesStartGUI = snakesStartGUI;
	}

	public static void setSnakesEndGUI(int[] snakesEndGUI) {
		SnakesAndLadders.snakesEndGUI = snakesEndGUI;
	}

	public static void setLaddersStartGUI(int[] laddersStartGUI) {
		SnakesAndLadders.laddersStartGUI = laddersStartGUI;
	}

	public static void setLaddersEndGUI(int[] laddersEndGUI) {
		SnakesAndLadders.laddersEndGUI = laddersEndGUI;
	}

}
