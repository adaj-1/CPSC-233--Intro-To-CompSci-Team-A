import java.util.ArrayList;
import java.util.List;

public class Player { // Arlina

	private String name; 
	private int position = 0;


	public Player() {
		String[] player = new String[101];
		for (int i = 0; i < 101; i++) {
			player[i] = "  ";
		}
	}
	
	
	
	public Player(String name) {
		this.name = name;
		
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
