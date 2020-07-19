import java.util.ArrayList;

public class Player { // Arlina

	private String name; 
	private int position;
	private ArrayList <Player> PlayerList = new ArrayList <Player> ();
	
	public Player() {
		
	}
	
	public Player(String playerType, String playerName) {
		/*
		 * loop String[] to fill the arrayList for 4 players 
		 */
		
		String[] player = new String[101];
		for (int i = 0; i < 101; i++) {
			player[i] = " ";
		}	
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	
	
}
