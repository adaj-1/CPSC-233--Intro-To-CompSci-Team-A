import java.util.Random;

public class Factory {
	private static final int numOfPolls = 0;
	private int numOfSeats;
	String[] partyNames = {"BQ","CPC","Green","Liberal","NDP","PPC","Rhinoceros"};
	
	public Factory(int numOfSeats) {
		if (numOfSeats >= 1) {
		this.numOfSeats = numOfSeats;
		}
	}
	public void setPartyNames(String[] names) {
		partyNames = names;
	}
	
	public String[] getPartyNames() {
		return partyNames;
	}
	
	
	public Party createRandomParty(String partyName, int maximumSeats, int maximumPercent) {
		PollList polllist1 = new PollList(numOfPolls,numOfSeats); //created poll list object to get total number of seats
		Party party1 = new Party(partyName); //created party object to get projected number of seats
		double numSeats = party1.getProjectedNumberOfSeats(); // used Party class method to get projected seats #
		int totalSeats = polllist1.getNumOfSeats(); // used PollList class method to get total # seats
		double percentSeats = numSeats/totalSeats; // calculated percentage of seats the party will get
		double percentVotes = party1.getProjectedPercentageOfVotes(); //get % votes from party class
		double difference = (Math.abs(percentSeats - percentVotes)); // get difference between percentages
		if (difference < 0.05) {	
		Random rand = new Random();
		return new Party(partyName, rand.nextInt(numOfSeats), rand.nextFloat());
	}
		return null;
	}
	
	public Poll createRandomPoll(String name) {
		Poll poll = new Poll(name, partyNames.length);
	
		Random rand = new Random();
		PollList polllist1 = new PollList(numOfPolls,numOfSeats); //created poll list object to get total number of seats
		int totalSeats = polllist1.getNumOfSeats(); //used PollList class method to get total # seats
		double percentVotes = rand.nextFloat();
		if (percentVotes >= 0 && percentVotes <= 100) {
			if (numOfSeats <= totalSeats) {
		
		for (String partyname : partyNames) {
			poll.createRandomParty(partyname, rand.nextInt(numOfSeats), rand.nextInt(PercentVotes));
		}
		return poll;
	}
		}
	}

	public PollList createRandomPollList(int numOfPolls) {
		PollList list = new PollList(numOfPolls,numOfSeats);
		for (int counter = 0; counter < numOfPolls; counter++) {
			list.addPoll(createRandomPoll("Poll" + counter));
		}
		return list;
	}
	
	public PollList promptForPollList(int numOfPolls) {
		return createRandomPollList(numOfPolls);
	}
	
}
