
public class Human extends Player {  // Arlina
	int STARTPOSITION = 1;
	
	public Human(){	
	}
	
	public Human(String playerName){  // arg passed in from gameconfig
		super.setName(playerName); // should take first three letters of each name
		super.setPosition(STARTPOSITION);
	}
	
	
}
