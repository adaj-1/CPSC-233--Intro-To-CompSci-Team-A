/**
 * This class provides...
 * 
 * @version 1.0 15 July 2020
 * @author Luke Couture
 *
 */
public class PollList {
	private Poll[] polls;
	private int numOfSeats;

	/**
	 * 
	 * @param numOfPolls
	 * @param numOfSeats
	 */
	public PollList(int numOfPolls, int numOfSeats) {
		if (numOfPolls > 0) {
			polls = new Poll[numOfPolls];
		} else {
			polls = new Poll[5];
		}
		if (numOfSeats > 0) {
			this.numOfSeats = numOfSeats;
		} else {
			this.numOfSeats = 10;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNumOfSeats() {
		return numOfSeats;
	}
	
	/**
	 * 
	 * @return
	 */
	public Poll[] getPolls() {
		return polls;
	}
	
	/**
	 * 
	 * @param aPoll
	 */
	public void addPoll(Poll aPoll) {
		int index = 0;

		if (aPoll == null) {
			System.out.println("Error! The argument provided to addPoll cannot be null.");
		}
		if (index >= polls.length) {
			System.out.println("Error! The list is full, no more items can be added.");
		}
		
		for (index = 0; index < polls.length && polls[index] != null; index++) {	
		}
		
		if (aPoll != null && index < polls.length) {			
			polls[index] = aPoll;
		} else if (aPoll != null) {
			for (int i = 0; i < polls.length; i++) {
				if (aPoll.getPollName().equalsIgnoreCase(this.polls[i].getPollName())) {
				polls[i] = aPoll;
			}
		}			
		}
	}
	
	/**
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
			p1 = getAveragePartyData(partyNames[i]);
			aggregate.addParty(p1);
			seats[i] = p1.getProjectedNumberOfSeats();
			votes[i] = p1.getProjectedPercentageOfVotes();
			seatTotal += seats[i];
			voteTotal += votes[i];
		}
		
		if (seatTotal > 400) {
			aggregate = new Poll("Aggregate", partyNames.length);
			for (int i = 0; i < partyNames.length; i++) {
				p1 = getAveragePartyData(partyNames[i]);
				seats[i] *= (400 / seatTotal);	
				p1.setProjectedNumberOfSeats(seats[i]);
				p1 = new Party(partyNames[i],
							   p1.getProjectedNumberOfSeats(), p1.getProjectedPercentageOfVotes());
				aggregate.addParty(p1);
			}
		}

		if (voteTotal > 1) {
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
			Party p = polls[i].getParty(partyName);
			if (p != null) {				
				voteTotal += p.getProjectedPercentageOfVotes();
				seatTotal += p.getProjectedNumberOfSeats();
				count++;
			}
		}
		
		if (count == 0) {
			count = 1;
		}
		
		average.setProjectedNumberOfSeats(seatTotal/count);
		average.setProjectedPercentageOfVotes(voteTotal/count);

		return average;
	}
	
	/**
	 * 
	 * @param aPoll
	 * @return
	 */
	public Poll adjustPollToMaximums(Poll aPoll) {
		return aPoll;
		
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Number of seats: " + numOfSeats;
	}
}
