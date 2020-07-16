/**
 * This class grabs and stores collection of polls, collecting seat 
 * and vote data that represent one election.
 * 
 * This class also performs calculations on the data such as providing
 * average seats and votes for a given party, as well as an aggregate of all parties.
 * 
 * @version 1.0 15 July 2020
 * @author Luke Couture
 *
 */
public class PollList {
	private Poll[] polls;
	private int numOfSeats;

	/**
	 * Creates a poll list when given two parameters which set number of polls
	 * and number of seats. 
	 * If a number <= 0 is entered the method will set default values for polls and seats.
	 *
	 * @param numOfPolls
	 * @param numOfSeats
	 */
	public PollList(int numOfPolls, int numOfSeats) {
		if (numOfPolls > 0) {
			this.polls = new Poll[numOfPolls];
		} else {
			this.polls = new Poll[5]; // If numOfPolls <= 0, number of polls are set to 5
		}
		if (numOfSeats > 0) {
			this.numOfSeats = numOfSeats;
		} else {
			this.numOfSeats = 10; // If numOfSeats <=0, number of seats are set to 10
		}
	}
	
	/**
	 * Returns the number of seats in the given poll list.
	 * 
	 * @return
	 */
	public int getNumOfSeats() {
		return numOfSeats;
	}
	
	/**
	 * Returns the number of polls in the given poll list.
	 * 
	 * @return
	 */
	public Poll[] getPolls() {
		return polls;
	}
	
	/**
	 * Adds the poll provided to the function as an argument to the poll list.
	 * If a poll added to the list has the same name as a poll already in the list,
	 * the method will overwrite the poll already in the list with the new one.
	 * 
	 * @param aPoll
	 */
	public void addPoll(Poll aPoll) {
		int index = 0;

		if (aPoll == null) {
			
			/* Error message is displayed and the program allowed to continue after error */
			System.out.println("Error! The argument provided to addPoll cannot be null.");
		}
		if (index >= polls.length) {
			
			/* Error message is displayed and the program allowed to continue after */
			System.out.println("Error! The list is full, no more items can be added.");
		}
		
		for (index = 0; index < polls.length && polls[index] != null; index++) {
			
			/* Index ensures polls are only stored in empty slots in the list */
		}
		
		if (aPoll != null && index < polls.length) {
			
			/* Ensures polls are not null or out of list range */
			polls[index] = aPoll;
		}
		else if (aPoll != null) {
			for (int i = 0; i < polls.length; i++) {
				
				/* Checks list for polls with same name as current argument,
				 *  then overwrites poll already in list if new poll being added has same name 
				 */
				if (aPoll.getPollName().equalsIgnoreCase(this.polls[i].getPollName())) {
				polls[i] = aPoll;														
			}
		}			
		}
	}
	
	/**
	 * Collects projected percentage of votes and seats for the indicated party,
	 * this is provided to the method as an argument.
	 * 
	 * This method then calculates the average amount of projected votes and seats
	 * across all polls in which the party name appears and finally returns the values
	 * with the given name. 
	 * 
	 * @param partyName
	 * @return
	 */
	public Party getAveragePartyData(String partyName) {
		int count = 0;
		float seatTotal = 0.0f;
		float voteTotal = 0.0f;
		Party average = new Party(partyName);
		
		for (int i = 0; i < polls.length; i++) {
			Party p = polls[i].getParty(partyName);					// Gathers the party data based on party name provided to method
			if (p != null) {				
				voteTotal += p.getProjectedPercentageOfVotes();		// Creates running total of votes
				seatTotal += p.getProjectedNumberOfSeats();			// Creates running total of seats
				count++;											// Counts amount of data gathered for averaging purposes
			}
		}
		
		if (count == 0) {
			count = 1;												// Fail safe to avoid a divide by zero situation
		}
		
		average.setProjectedNumberOfSeats(seatTotal / count);		// Calculates seat average
		average.setProjectedPercentageOfVotes(voteTotal / count);	// Calculates vote average

		return average;
	}
	
	/**
	 * This method uses the previous method getAveragePartyData to collect the average
	 * projected seats and votes for a number of parties, using the list of names passed
	 * to the method as an argument. This method then creates an aggregate of all the provided
	 * parties and returns it.
	 * 
	 * This method also adjusts the number of votes if the aggregate produces a number of 
	 * projected votes above 100% or a number of seats which is larger than the amount
	 * available in the election.
	 * 
	 * @param partyNames
	 * @return
	 */
	public Poll getAggregatePoll(String[] partyNames) {
		Float[] seats = new Float[partyNames.length];
		Float[] votes = new Float[partyNames.length];
		float seatTotal = 0.0f;
		float voteTotal = 0.0f;
		Party p1;
		Poll aggregate = new Poll("Aggregate", partyNames.length);		
		
		for (int i = 0; i < partyNames.length; i++) {
			
			/* Gathers average party seats and votes for each party in the list separately,
			 * then adds average party seats and votes to the Poll object aggregate,
			 * also keeps a running total of seats and votes to track values, in case values exceed amount available
			*/
			p1 = getAveragePartyData(partyNames[i]);				
			aggregate.addParty(p1);									
			seats[i] = p1.getProjectedNumberOfSeats();				
			votes[i] = p1.getProjectedPercentageOfVotes();			 
			seatTotal += seats[i];									
			voteTotal += votes[i];									
		}
		
		if (seatTotal > this.numOfSeats) {
			aggregate = new Poll("Aggregate", partyNames.length);
			for (int i = 0; i < partyNames.length; i++) {
				
				/* If seats do exceed amount available, reduces each parties seats by the required proportion */
				p1 = getAveragePartyData(partyNames[i]);
				seats[i] *= (this.numOfSeats / seatTotal);					 
				p1.setProjectedNumberOfSeats(seats[i]);				
				p1 = new Party(partyNames[i],
							   p1.getProjectedNumberOfSeats(), p1.getProjectedPercentageOfVotes());
				aggregate.addParty(p1);	
			}
		}

		if (voteTotal > 1) {
			
			/* If votes do exceed amount available, this line reduces each parties votes by the required proportion */
			aggregate = new Poll("Aggregate", partyNames.length);
			for (int i = 0; i < partyNames.length; i++) {
				p1 = getAveragePartyData(partyNames[i]);
				votes[i] *= (1 / voteTotal);
				p1.setProjectedPercentageOfVotes(votes[i]);
				p1 = new Party(partyNames[i],
							   p1.getProjectedNumberOfSeats(), p1.getProjectedPercentageOfVotes());
				aggregate.addParty(p1);	
			}
		}
		return aggregate;
	}
	
	/**
	 * Adjusts the poll to maximums based on the argument provided
	 * 
	 * @param aPoll
	 * @return
	 */
	public Poll adjustPollToMaximums(Poll aPoll) {
		return aPoll;
		
	}
	
	/**
	 * Overrides and formats the toString method to provide the number of
	 * seats preceded by text identifying it.
	 */
	@Override
	public String toString() {
		return "Number of seats: " + numOfSeats;
	}
}
