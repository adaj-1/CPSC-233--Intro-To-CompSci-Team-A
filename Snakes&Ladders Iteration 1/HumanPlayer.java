
public class HumanPlayer {

	private String name;
	private Move position;
	
	public HumanPlayer(){
		
	}
	
	public Move getMove(GameConfiguration gameConfig) {
		return null;
		
	}
	
	public String toString() {
		return "(" + position.getXcoord() + "," + position.getYcoord() + ")" ;
	}
}
