
public class Computer extends Player {  // Arlina
	int STARTPOSITION = 1;
	String[] computerNames;
	
	public Computer(int numComp){
		
		computerNames[0] = "C1";
		computerNames[1] = "C2";
		computerNames[2] = "C3";
		computerNames[3] = "C4";
		
		super.setName(computerNames[numComp]);
		
		for (int i = 0; i < computerNames.length; i++) {
			super.setName(computerNames[i]);
		}

		super.setPosition(STARTPOSITION);
	}	
	
}
