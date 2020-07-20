
public class Computer extends Player {  // Arlina
	int STARTPOSITION = 1;
	String[] computerNames;
	
	public Computer(){
		  //preset computer names to jada,luke,nathan,arlina (first 3 letters)
		computerNames[0] = "jada";
		computerNames[1] = "luke";
		computerNames[2] = " nathan";
		computerNames[3] = "arlina";

		for (int i = 0; i < computerNames.length; i++) {
			super.setName(computerNames[i]);
		}


		super.setPosition(STARTPOSITION);
	}	
	
}
