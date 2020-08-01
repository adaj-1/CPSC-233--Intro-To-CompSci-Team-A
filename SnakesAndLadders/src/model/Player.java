package model;

public class Player { // Arlina
	private String name;
	private String type; 
	private String[] player;

	public Player() {
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
