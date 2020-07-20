import java.util.ArrayList;
import java.util.List;

public class Player { // Arlina

	private String name; 
	private int position = 0;
	private ArrayList <Player> PlayerList = new ArrayList <Player> (); //arrayList of player objects

	
	public Player(String name) {

		this.name = name;
		
	}

	public Player(String playerType, String playerName) {
		/*
		 * loop String[] to fill the arrayList for 4 players
		 */

		String[] player = new String[101];
		for (int i = 0; i < 101; i++) {
			player[i] = " ";
		}

		for (int i = 0; i < 4; i++) {
			PlayerList.add(new Player(playerName));
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
