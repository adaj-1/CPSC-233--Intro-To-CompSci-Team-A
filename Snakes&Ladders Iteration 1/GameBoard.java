public class GameBoard {
	
	public static void Draw() {
		int spaceNum = 100;
		
		/* option of four human players */
		String[] player1 = new String[101];
		for (int i = 0; i < 101; i++) {
			player1[i] = " ";
		}
		String[] player2 = new String[101];
		for (int i = 0; i < 101; i++) {
			player2[i] = " ";
		}
		String[] player3 = new String[101];
		for (int i = 0; i < 101; i++) {
			player3[i] = " ";
		}
		String[] player4 = new String[101];
		for (int i = 0; i < 101; i++) {
			player4[i] = " ";
		}
		player1[1] = "A";
		player2[1] = "B";
		player3[1] = "C";
		player4[50] = "D";
		
		
		/* Last line of game board */
		System.out.print("_____________________________________________________________"
				+ "____________________________________________________________________________"
				+ "______________" + "\n");
		System.out.print("|");
		for (int i = 0; i < 10; i++) {
		System.out.print("              |");
		}
		System.out.println();
		System.out.print("|" + spaceNum + "      " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
		spaceNum -= 1;
		for (int i = 0; i < 9; spaceNum--, i++) {
		   System.out.print(spaceNum + "       " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
		}
		System.out.print("\n" + "______________________________________________________"
				+ "____________________________________________________________________________"
				+ "_____________________" + "\n" + "|");
		for (int i = 0; i < 10; i++) {
		System.out.print("              |");
		}
		System.out.print("\n" + "|");
		spaceNum -= 9;

		/* lines 9-2 of game board */
		for (int index = 0; index < 4; index++) {
			for (int i = 0; i < 10 ; spaceNum++, i++) {
				System.out.print(spaceNum + "       " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
						}
			System.out.print("\n" + "______________________________________________________"
					+ "____________________________________________________________________________"
					+ "_____________________" + "\n" + "|");
			for (int i = 0; i < 10; i++) {
				System.out.print("              |");
				}
				System.out.print("\n" + "|");
			spaceNum -= 11;
			
			for (int i = 0; i < 10 ; spaceNum--, i++) {
				System.out.print(spaceNum + "       " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
			}
			System.out.print("\n" + "______________________________________________________"
					+ "____________________________________________________________________________"
					+ "_____________________" + "\n" + "|");
			for (int i = 0; i < 10; i++) {
				System.out.print("              |");
				}
				System.out.print("\n" + "|");
			spaceNum -= 9;
		}
		
		/* first line of game board */
		System.out.print(spaceNum + "        " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
		spaceNum += 1;
		for (int i = 0; i < 8; spaceNum++, i++) {
			System.out.print(spaceNum + "        " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
			}
		System.out.print(spaceNum + "       " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
		System.out.print("\n" + "______________________________________________________"
				+ "____________________________________________________________________________"
				+ "_____________________" + "\n");
		
	}

	public static void main(String[] args) {
		Draw();
	}
}
