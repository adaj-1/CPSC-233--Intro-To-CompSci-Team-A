public class PollList {
	private Poll[] polls;
	private int numOfSeats;
	private float seatTotal;
	private float voteTotal;
	
	public PollList(int numOfPolls, int numOfSeats) {
		if (numOfPolls >= 1) {
			polls = new Poll[numOfPolls];
		}
		else {
			polls = new Poll[5];
		}
		if (numOfSeats >= 1) {
			this.numOfSeats = numOfSeats;
		}
		else {
			this.numOfSeats = 10;
		}
	}
	
	public int getNumOfSeats() {
		return numOfSeats;
	}
	
	public Poll[] getPolls() {
		return polls;
	}

	public void addPoll(Poll aPoll) {
		int index = 0;

/*		if (aPoll == null) {
			System.out.println("Error! The argument provided to addPoll cannot be null.");
		}
		if (index >= polls.length) {
			System.out.println("Error! The list is full, no more items can be added.");
		}*/
		
		for (; index < polls.length && polls[index] != null; index++) {	
		}
		
		if (aPoll != null && index < polls.length) {			
			polls[index] = aPoll;
		}
		else if (aPoll != null) {
			for (int i = 0; i < polls.length; i++) {
				if (aPoll.getPollName().equalsIgnoreCase(this.polls[i].getPollName())) {
				polls[i] = aPoll;
			}
		}			
		}
	}
	
	public Poll getAggregatePoll(String[] partyNames) {
		Poll aggregate = new Poll("Aggregate", partyNames.length);
		int i = 0;
		
		for (; i < partyNames.length; i++) {
		aggregate.addParty(getAveragePartyData(partyNames[i]));
		}
		
		return aggregate;
	}
	
	public Party getAveragePartyData(String partyName) {
		int i = 0;
		int count = 0;
		seatTotal = 0.0f;
		voteTotal = 0.0f;
		Party average = new Party(partyName);
		
		for (; i < polls.length; i++) {
			if (this.polls[i].getParty(partyName) != null) {				
				voteTotal += this.polls[i].getParty(partyName).getProjectedPercentageOfVotes();
				seatTotal += this.polls[i].getParty(partyName).getProjectedNumberOfSeats();
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
	
	public Poll adjustPollToMaximums(Poll aPoll) {
		return aPoll;
		
	}
	
	@Override
	public String toString() {
		return "Number of seats: " + numOfSeats;
	}
}
