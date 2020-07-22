
public class Human extends Player {  // Arlina
	int STARTPOSITION = 1;
	
	public Human(){	
	}
	
	public Human(String playerName){  // arg passed in from gameconfig

		super.setName(playerName); // should take first three letters of each name

		String playerNameChars = playerName.substring(0,3);
		System.out.println(playerNameChars);

		super.setPosition(STARTPOSITION);

	}
	
}
