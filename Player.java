package model;

/**
 * This class retrieves player names, types, and 
 * their positions and sets them.
 */
public class Player { // Arlina
	private String name;
	private String type; 
	private String[] player;
	private int position;
	private int holdDiceRoll;
	int count = 0;
       /**
	* This constuctor creates spaces on the
	* gameboard for each of the players.
	*/
	public Player() {
		this.type = null;
		player = new String[101];
		for (int i = 0; i < 101; i++) {
			player[i] = "  ";
		}
	}	

	/**
	 * This constructor takes in the type and
	 * name of the players. It then sets them
	 * according to their positions.
	 * @param type
	 * @param name
	 */
	public Player(String type, String name) {
		this.type = type;
		this.name = name;
		player = new String[101];
		for (int i = 0; i < 101; i++) {
			player[i] = "  ";
		}
		player[1] = name;
		this.setPosition(1);
	}
	
//	public void rollDice(){
//		int dice = (int)(Math.random()*6+1);
//		count++;  //rolled how many times
//		if (count == 1) {
//			if (dice == 6){
//				for (int i = 0; i <= dice; i++) {
//					setPosition(getPosition() + 1);
//				}
//				count++;
//			} else {
//				count = 0;
//			}
//		}else {
//			for (int i = 0; i <= dice; i++) {
//				setPosition(getPosition() + 1);
//			}
//		}
//
//	}

	/**
	 * The getters and setters retrieves the
	 * number of players, their names, positions,
	 * and sets them.
	 *
	 */
	public String[] getPlayer(){
		return this.player;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	/**
	 * These save the dice rolls of
	 * each player after they roll.
	 */
	public int getHoldDiceRoll() {
		return holdDiceRoll;
	}

	public void setHoldDiceRoll(int holdDiceRoll) {
		this.holdDiceRoll = holdDiceRoll;
	}
}
