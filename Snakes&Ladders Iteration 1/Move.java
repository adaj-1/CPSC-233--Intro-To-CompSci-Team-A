
public class Move {

	private int xcoord;
	private int ycoord;

	public Move() {	
	}
		
	// setter and getters
	public int getXcoord() {
		return xcoord;
	}

	public void setXcoord(int xcoord) { // might not need
		this.xcoord = xcoord;
	}

	public int getYcoord() {
		return ycoord;
	}

	public void setYcoord(int ycoord) {	// might not need
		this.ycoord = ycoord;
	}	
		
	
	public Move Ladder( /*start array index, end array index*/ ) {
		return null;		
	}
	
	public Move Snake( /*start array index, end array index*/ ) {
		return null;
	}

	public int dice() {
		// use random to generate one die roll		
		return 0;
	}
}
