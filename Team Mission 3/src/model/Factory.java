package model;

import java.util.Random;

public class Factory {
	private int numOfSeats;
	String[] partyNames = {"BQ","CPC","Green","Liberal","NDP","PPC","Rhinoceros"};
	
	public Factory(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}
	
	public void setPartyNames(String[] names) {
		partyNames = names;
	}
	
	public String[] getPartyNames() {
		return partyNames;
	}
	
	public Party createRandomParty(String partyName, int maximumSeats, int maximumPercent) {
		Random rand = new Random();
		Party hold = null;
		try {
			hold = new Party(partyName, rand.nextInt(numOfSeats), rand.nextFloat());
		} catch (InvalidPartyDataException e) {
			e.printStackTrace();				// this shouldn't happen for debugging purposes only
		}
		return hold;
	}
	
	public Poll createRandomPoll(String name) {
		Poll poll = new Poll(name, partyNames.length);
		
		Random rand = new Random();
		for (String partyName : partyNames) {
			try {
					poll.addParty(new Party(partyName, rand.nextInt(numOfSeats), rand.nextFloat()));
			} catch (InvalidPartyDataException e) {
				e.printStackTrace();				// this shouldn't happen for debugging purposes only
			} catch (PollFullException e) {
				e.printStackTrace();				// this shouldn't happen for debugging purposes only
			} 
		}
		return poll;
	}

	/**
	 * 
	 * @param numOfPolls
	 * @return
	 * @throws InvalidSetupDataException throws if # of polls is < 1
	 */
	public PollList createRandomPollList (int numOfPolls) throws InvalidSetupDataException {
		PollList list = null;
		list = new PollList(numOfPolls,numOfSeats);
		for (int counter = 0; counter < numOfPolls; counter++) {
			try {
				list.addPoll(createRandomPoll("Poll" + counter));
			} catch (PollListFullException e) {
				e.printStackTrace();				// this shouldn't happen for debugging purposes only
			}
		}
		return list;
	}
	
	/**
	 * 
	 * @param numOfPolls
	 * @return
	 * @throws InvalidSetupDataException throws if # of polls is < 1 
	 */
	public PollList promptForPollList(int numOfPolls) throws InvalidSetupDataException {
		return createRandomPollList(numOfPolls);
	}
	
}
