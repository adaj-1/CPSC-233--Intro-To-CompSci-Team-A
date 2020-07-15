import java.util.Random;

public class Factory {
	private int numOfSeats;
	private String[] partyNames = {"BQ","CPC","Green","Liberal","NDP","PPC","Rhinoceros"};
	

	public Factory(int seats) {
		if (numOfSeats >= 1) {
		seats = numOfSeats;
	
	}
}
	
	public String[] getPartyNames() {
			return partyNames;
	}
	public void setPartyNames(String[] names) {
		partyNames = names;
		}

	public Party createRandomParty(String partyName, int maxSeats, int maxPercentOfVotes) {
		Random rand= new Random();
			int projSeats = rand.nextInt(maxSeats);
			double percentSeats = projSeats/numOfSeats;
			int randomVote = rand.nextInt(maxPercentOfVotes/100);

		if (Math.abs(percentSeats - randomVote) < 5) {
		Party party = new Party(partyName, maxSeats, maxPercentOfVotes);
		return party;
						
			}
		return null; 
			}

	
	public Poll createRandomPoll(String name) {
		Random rand = new Random();
		double percentVotes = rand.nextFloat();
		if (percentVotes >= 0 && percentVotes <= 100) {
		for (String partyname : partyNames) {
		createRandomParty(partyname, rand.nextInt(numOfSeats), rand.nextInt((int)percentVotes));
	} 
		} 
		for (int i = 0; i < partyNames.length; i++) { 
		int projNumofSeats = rand.nextInt();
		int totalprojSeats = projNumofSeats;
		if (totalprojSeats < numOfSeats) {
		Poll poll = new Poll(name, partyNames.length);
		return poll;
	}
		
		}
		return null;
	}

	public PollList createRandomPollList(int numOfPolls) {
		Random rand = new Random();
		PollList list = new PollList(numOfPolls,rand.nextInt(numOfSeats));
		for (int counter = 0; counter < numOfPolls; counter++) {
			list.addPoll(createRandomPoll("Poll" + counter));
		}
		return list;
	}
	
	public PollList promptForPollList(int numOfPolls) {
		return createRandomPollList(numOfPolls);
	}
	
}
