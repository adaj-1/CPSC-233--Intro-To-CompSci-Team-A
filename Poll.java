import java.lang.reflect.Array;
import java.util.Arrays;

public class Poll {
	private String name = "Unnamed Poll";
	private Party[] parties;
	private int numberOfParties = 0;

	public Poll(String name, int maxNumberOfParties) {
		this.name = name; 
		if(maxNumberOfParties<1) {
			maxNumberOfParties=10;
			parties = new Party[maxNumberOfParties];
		}
		else parties= new Party[maxNumberOfParties];	
	}
	
	public String getPollName() {
		return this.name;
		
	}
	
	public int getNumberOfParties() {
		return numberOfParties;
	}
	
	public void addParty(Party aParty) {
		if (aParty==null) {
			System.out.println("Error");
		}
		Boolean exists=false;
		Boolean size=true;
		for(int i=0; i<parties.length&&parties[i]!=null; i++) {//Iterates through every index of parties array
			if(aParty.getName().equalsIgnoreCase(parties[i].getName())) {
				parties[i]=aParty; //Replaces existing party with same name with argument aParty
				exists=true;
			}
			else if(numberOfParties>=parties.length) {
				System.out.println("Error, poll is full. No more parties can be added");
				size=false;
			}
			
			
			}	
		
		if(exists.equals(false)&&size.equals(true)) {
			parties[numberOfParties++]=aParty;	
		}
	
	}
	
	
	public Party getParty(String name) {
		
		for(int i=0;i<parties.length;i++) {
			if(name.toUpperCase().equals(parties[i].getName().toUpperCase())) {
				return parties[i];
			}
			
		}
		 return null;
		
	}
	
	public Party[] getPartiesSortedBySeats() {
		return parties;
	}

	public Party[] getPartiesSortedByVotes() {
		return parties;
	}
	

	
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		for(int i=0; i<parties.length;i++) {
			if(parties[i]==null) {
				return name + "\n";
			}
			else if(parties.length>0) {
				sb.append(parties[i].getName());
				sb.append("\n");
			}
			
		}
		return String.format(name+"\n"+sb);
	}
}
