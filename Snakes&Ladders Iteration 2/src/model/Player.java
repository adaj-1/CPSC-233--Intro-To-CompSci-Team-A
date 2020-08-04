package model;


public class Player { // Arlina
	private String name;
	private String type; 
	private String[] player;

	public Player() {
		this.type = null;
		player = new String[101];
		for (int i = 0; i < 101; i++) {
			player[i] = "  ";
		}
	}	
	
	public Player(String type, String name) {
		this.type = type;
		this.name = name;
		player = new String[101];
		for (int i = 0; i < 101; i++) {
			player[i] = "  ";
		}
		player[1] = name;
	}
	public void rollDice(){
		int dice = (int)(Math.random()*6+1);
		count++;  //rolled how many times
		if (count == 1) {
			if (dice == 6){
				for (int i = 0; i <= dice; i++) {
					position++;
				}
				count++;
			} else {
				count = 0;
			}
		}else {
			for (int i = 0; i <= dice; i++) {
				position++;
			}
		}

	}

	public String[] getPlayer(){
		return this.player;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getName() {
		return this.name;
	}
}
