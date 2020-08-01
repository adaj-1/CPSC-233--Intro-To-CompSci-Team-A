package model;
public class GameBoard {
	
	public static void drawBoard(Player firstPlayer, Player secondPlayer, Player thirdPlayer, Player fourthPlayer) {
		int spaceNum = 100;
		String[] player1 = firstPlayer.getPlayer();
		String[] player2 = secondPlayer.getPlayer();
		String[] player3 = thirdPlayer.getPlayer();
		String[] player4 = fourthPlayer.getPlayer();
		
		/* Last line of game board */
		System.out.print("_____________________________________________________________"
				+ "____________________________________________________________________________"
				+ "______________________________________________________" + "\n");
		System.out.print("|" + "                  |                  |                 "
				+ " |                  |                  |                  |                 "
				+ " |                  |                  |                  |" + "\n");
		System.out.print("|" + spaceNum + "      " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
		spaceNum -= 1;
		for (int i = 0; i < 9; spaceNum--, i++) {
			if(spaceNum == 97 || spaceNum == 92) {
				System.out.print(spaceNum + " /     " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
			} else {
				System.out.print(spaceNum + "       " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
				}
		}
		System.out.print("\n" + "______________________________________________________"
				+ "_______|____________________________________________________________________"
				+ "__________________________|__________________________________" + "\n");
		System.out.print("|                  |                  |                  |   |          "
				+ "    |                  |                  |                  |         "
				+ "         |   |              |                  |" + "\n" + "|");
		spaceNum -= 9;

		/* lines 9-2 of game board */
		for (int index = 0; index < 4; index++) {
			for (int i = 0; i < 10 ; spaceNum++, i++) {
				if (spaceNum == 42 || spaceNum == 47){
					System.out.print(spaceNum + " /     " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
				} else if (spaceNum == 61 || spaceNum == 66) {
					System.out.print(spaceNum + "|-|    " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
				} else if (spaceNum == 84 || spaceNum == 89) {
					System.out.print(spaceNum + " |     " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
				} else {
					System.out.print(spaceNum + "       " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");	
				}
			}
			if (spaceNum == 31) {
				System.out.print("\n" + "_________________________________________|-|__________"
						+ "____________________________________________________________________________"
						+ "_________________________|-|_________________________________" + "\n" + "|");
			} else if (spaceNum == 51){
				System.out.print("\n" + "_______________________|______________________________"
						+ "________________________________________________________________|___________"
						+ "_____________________________________________________________" + "\n" + "|");
			} else if (spaceNum == 71){
				System.out.print("\n" + " __|-|________________________________________________"
						+ "____________________________________________|-|_____________________________"
						+ "_____________________________________________________________" + "\n" + "|");
			} else if (spaceNum == 91) {
				System.out.print("\n" + "______________________________________________________"
						+ "_______|____________________________________________________________________"
						+ "__________________________|__________________________________" + "\n" + "|");
			} else {
				System.out.print("\n" + "______________________________________________________"
						+ "____________________________________________________________________________"
						+ "______________________________________________________________" + "\n" + "|");
			}
			if (spaceNum == 31) {
				System.out.print("                  |                  |  |-|             |    "
						+ "              |                  |                  |                  |    "
						+ "              |  |-|             |                  |" + "\n" + "|");
			} else if (spaceNum == 51){
				System.out.print("                  |   |              |                  |    "
						+ "              |                  |                  |   |              |    "
						+ "              |                  |                  |" + "\n" + "|");
			} else if (spaceNum == 71){
				System.out.print("  |-|             |                  |                  |    "
						+ "              |                  |  |-|             |                  |    "
						+ "              |                  |                  |" + "\n" + "|");
			} else if (spaceNum == 91) {
				System.out.print("                  |                  |                  |   /"
						+ "              |                  |                  |                  |    "
						+ "              |   /              |                  |" + "\n" + "|");
			} else {
				for (int i = 0; i < 10; i++) {
					System.out.print("                  |");
					}
					System.out.print("\n" + "|");	
			}
			spaceNum -= 11;
			
			for (int i = 0; i < 10 ; spaceNum--, i++) {
				if (spaceNum == 18 || spaceNum == 12) {
					System.out.print(spaceNum + "|-|    " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
				} else if (spaceNum == 39 || spaceNum == 34) {
					System.out.print(spaceNum + " |     " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
				} else if (spaceNum == 60 || spaceNum == 55) {
					System.out.print(spaceNum + "|-|    " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
				} else {
					System.out.print(spaceNum + "       " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
				}
			}
			if (spaceNum == 10) {
				System.out.print("\n" + "_________________________________________|-|__________"
						+ "____________________________________________________________________________"
						+ "_________________________|-|_________________________________" + "\n" + "|");
			} else if (spaceNum == 30) {
				System.out.print("\n" + "_______________________|______________________________"
						+ "________________________________________________________________|___________"
						+ "_____________________________________________________________" + "\n" + "|");
			} else if (spaceNum == 70) {
				System.out.print("\n" + "___|-|________________________________________________"
						+ "____________________________________________|-|_____________________________"
						+ "_____________________________________________________________" + "\n" + "|");
			} else {
				System.out.print("\n" + "______________________________________________________"
						+ "____________________________________________________________________________"
						+ "_____________________________________________________________" + "\n" + "|");
			}
			if (spaceNum == 10) {
				System.out.print("                  |                  |  |-|             |    "
						+ "              |                  |                  |                  |    "
						+ "              |  |-|             |                  |" + "\n" + "|");				
			} else if (spaceNum == 30) {
				System.out.print("                  |   /              |                  |    "
						+ "              |                  |                  |   /              |    "
						+ "              |                  |                  |" + "\n" + "|");				
			} else if (spaceNum == 70) {
				System.out.print("  |-|             |                  |                  |    "
						+ "              |                  |  |-|             |                  |    "
						+ "              |                  |                  |" + "\n" + "|");				
			} else {
				for (int i = 0; i < 10; i++) {
					System.out.print("                  |");
					}
					System.out.print("\n" + "|");				
			}
			spaceNum -= 9;
		}
		
		/* first line of game board */
		System.out.print(spaceNum + "        " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
		spaceNum += 1;
		for (int i = 0; i < 8; spaceNum++, i++) {
			if (spaceNum == 3 || spaceNum == 9) {
				System.out.print(spaceNum + " |-|    " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
			} else {
				System.out.print(spaceNum + "        " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
			}
		}
		System.out.print(spaceNum + "       " + player1[spaceNum] + player2[spaceNum] + player3[spaceNum] + player4[spaceNum] + " |");
		System.out.print("\n" + "______________________________________________________"
				+ "____________________________________________________________________________"
				+ "_____________________________________________________________" + "\n");
		
	}
/*
	public static void main(String[] args) {
		
		String[] player1 = new String[101];
		for (int i = 0; i < 101; i++) {
			player1[i] = "  ";
		}
		String[] player2 = new String[101];
		for (int i = 0; i < 101; i++) {
			player2[i] = "  ";
		}
		String[] player3 = new String[101];
		for (int i = 0; i < 101; i++) {
			player3[i] = "  ";
		}
		String[] player4 = new String[101];
		for (int i = 0; i < 101; i++) {
			player4[i] = "  ";
		}
		player1[1] = "Az";
		player2[1] = "Bz";
		player3[1] = "Cz";
		player4[50] = "Dz";
		
		drawBoard(player1, player2, player3, player4);
	}*/
}
