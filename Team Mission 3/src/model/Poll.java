package model;

import java.util.Arrays;

/**
 * @version 3.0 13 August 2020
 * @author Nathan Jung
 *
 */
public class Poll {
	private String name = "Unnamed Poll";
	private Party[] parties;
	private int numberOfParties = 0;
	
	/**
	 * This method creates a new Poll Array, with instance variables name (of Poll) and maxNumberOfParties allowed in Poll 
	 * If the value of maxNumberOfParties is less than 1, will automatically set maxNumberOfParties to 10
	 * @param name
	 * @param maxNumberOfParties
	 */
	public Poll(String name, int maxNumberOfParties) {
		this.name = name; 
		if(maxNumberOfParties<1) {
			maxNumberOfParties=10;
			parties = new Party[maxNumberOfParties];
		}else parties= new Party[maxNumberOfParties];	
	}
	
	/**
	 * This method gets name of Poll, returns it (string)
	 * @return
	 */
	public String getPollName() {
		return this.name;
		
	}
	
	/**
	 * This method gets numberOfParties in the Poll (int)	
	 * @return
	 */
	public int getNumberOfParties() {
		return numberOfParties;
	}
	
	/**
	  * This  method adds Parties to the Poll array, and a party is provided as an argument(aParty)
	  * If the argument is null, and Error is printed.
	  * If the party being added has the same name(not case sensitive) as an existing party,
	  * it will replace the existing party. 
	  * If the party dosent already exist, it will be added to the end of the Poll
	  * If the poll has no more spots left, an error prints
	  * @param aParty
	  * @throws PollFullException throws when you cannot add another party as the poll is full
	  */
	public void addParty(Party aParty) throws PollFullException {
		if (aParty==null) {
			System.out.println("Error, Party is null");
		}
		Boolean exists=false;
		Boolean size=true;
		for(int i=0; i<parties.length&&parties[i]!=null; i++) {//Iterates through every index of parties array
			if(aParty.getName().equalsIgnoreCase(parties[i].getName())) {
				parties[i]=aParty; //Replaces existing party with same name with argument aParty
				exists=true;
			}
			
			}
			
		if(numberOfParties>=parties.length) {
			System.out.println("Error, poll is full. No more parties can be added");
			size=false;
			
			}	
		
		if(exists.equals(false)&&size.equals(true)) {
			parties[numberOfParties++]=aParty;	
		}
	
	}

	/**
	 *  This method takes a argument name(string) to find in the poll, returns that party/
	 *  If no party with that name exists, will return null.
	 *  @param name
	 *  @return 
	 */
	public Party getParty(String name) {
		
		for(int i=0; i < parties.length;i++) {
			if(name.toUpperCase().equals(parties[i].getName().toUpperCase())) {
				return parties[i];
			}
			
		}
		 return null;
		
		 
	}
	/**
	 * These next two methods rearrange the poll of parties based on number of seats,
	 * or number of votes from most to least
	 * @return
	 */
	public Party[] getPartiesSortedBySeats() {
		Arrays.sort(parties, new DescendingSeatsComparator());
		return parties;
	}
	
	/**
	 * 
	 * @return
	 */
	public Party[] getPartiesSortedByVotes() {
		Arrays.sort(parties, new DescendingVotesComparator());
		return parties;
	}
	
	/**
	 * This method overrides the toString method to return a string with a specific
	 * format: <Name of poll><new line><string representation of first party>
	 * <newline><string representation of second party> etc...
	 * @return
	 */
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		for(int i=0; i<parties.length; i++) {
			if(parties[i]==null) {
				break;
			} else if(parties.length>0) {
				sb.append(parties[i].getName());
				sb.append("\n");
			}
			
			}
			return String.format(name+"\n"+sb);
			}
	}
