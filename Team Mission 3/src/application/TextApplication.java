package application;

import model.Party;
import model.Factory;
import model.InvalidPartyDataException;
import model.InvalidSetupDataException;
import model.Poll;
import model.PollList;

import java.util.Scanner;

/**
 * This class represents the entire application and pulls together 
 * all other classes (Party, Poll, PollList, and Factory). It takes
 * input from the user and outputs a visualization of the results of 
 * an election.
 * 
 * @version 3.0 13 August 2020
 * @author Jada Li
 *
 */

public class TextApplication {
	/* this class initiates the visualization for the poll data  */
	
	/** MAX_NUMBER_OF_STARS represents seats in the visualization */
	public static final int MAX_NUMBER_OF_STARS = 25;
	
	/** polls provides the poll and party data */
		private PollList polls;
		
	/**
	 * default constructor for the class
	 */
	public TextApplication() {	
	}
	
	/**
	 * initializes instance variable polls
	 * @param polls this provides the polls data
	 */
	public TextApplication(PollList polls) {
		this.polls = polls;
	}
	
	/**
	 * takes the polls data and provides it to displayPollDataBySeat()
	 * @param partyNames has all the party names
	 */
	public void displayPollsBySeat(String[] partyNames) {
		if (polls == null) {
			System.out.println("No polls to display");
		} else {
			int numOfPolls = polls.getPolls().length;
			Poll[] regularPoll = polls.getPolls();						// grabs array of poll data 
			
			for (int i = 0; i < numOfPolls; i++) {	
				
				displayPollDataBySeat(regularPoll[i]);					// invokes displayPollDataBySeat for each poll
			  
				System.out.println();
			}
				
			Poll AggregatePoll = null;
			AggregatePoll = polls.getAggregatePoll(partyNames);
			displayPollDataBySeat(AggregatePoll);
			}
	}
	
	/**
	 * gets the poll data from PollList
	 * @return the ArrayList for the poll
	 */	
	public PollList getPolls() {
		return polls;
	}
	
	/**
	 * invokes textVisualizationBySeats method to display visualization of 
	 * the poll data for each poll and each party
	 * @param aPoll has th name of the poll and number of parties
	 */
	public void displayPollDataBySeat(Poll aPoll) {
		
		int starsNeededForMajority = (MAX_NUMBER_OF_STARS + 1) / 2;		// calculates # of stars for majority
		
		int numOfSeats = polls.getNumOfSeats();  						// gets the # of seats for the poll
		double numOfSeatsPerStar = numOfSeats / MAX_NUMBER_OF_STARS;	// determines # of seats per star
				
		int numOfParties = aPoll.getNumberOfParties();
		Party[] partyList = aPoll.getPartiesSortedBySeats();			// gets list of parties sorted by seats
							
		System.out.println(aPoll.getPollName());
		
		for (int i = 0; i < numOfParties; i++) {
			String visualizationBySeat = partyList[i].textVisualizationBySeats(MAX_NUMBER_OF_STARS,			// creates string needed for visualization
																			   starsNeededForMajority,
																			   numOfSeatsPerStar);
			System.out.println(visualizationBySeat);	
		}
	}
	
	/**
	 * this pulls all the classes (Party, Poll, PollList, and Factory)
	 * together and gets the user input arguments needed to run the code.
	 */
	public void run() {	
		System.out.println("Welcome To The Poll Tracker.");
		
		System.out.println("How many seats are available in the election?");
		Scanner seatinput = new Scanner(System.in);
		int numOfSeats = seatinput.nextInt(); 
		
		System.out.println("Which parties are in the election (provide names, "
				+ "only comma separated, no spaces):");
		Scanner partyNameInput = new Scanner(System.in);
		String partyNames = partyNameInput.nextLine();
		String[] partyNameList = partyNames.split(",");
		
		System.out.println("How many polls do you want to track with this application?");
		Scanner numOfPollsInput = new Scanner(System.in);
		int numOfPolls = numOfPollsInput.nextInt();
		
		System.out.println("Would you like me create a random set of polls? (yes/no)");
		Scanner yesNoInput = new Scanner(System.in);
		String yesNo = yesNoInput.nextLine();
		
		if (yesNo.equals("yes")) {
			Factory holdPollList = new Factory(numOfSeats);        		// determine whether to use random polls or user input polls
			try {
				polls = holdPollList.createRandomPollList(numOfPolls);
			} catch (InvalidSetupDataException e) {
				e.printStackTrace();				// this shouldn't happen for debugging purposes only
			}		// creates a random poll list data
		} else {
			Factory holdPollList = new Factory(numOfSeats);				
			try {
				polls = holdPollList.promptForPollList(numOfPolls);		// prompts user for poll list data	
			} catch (InvalidSetupDataException e) {
				e.printStackTrace();				// this shouldn't happen for debugging purposes only
			}					
		}
		
		/* 
		 * this do-while loop prompts the user for which visualization they want
		 * to generate while allowing them to quit at any time
		 */
		boolean hold = true;
		do {
			System.out.println("Options: all (Show results of all Polls),"					
					+ " aggregate (Show Aggregate results), or quit (End application)");
			System.out.println("Choose an Option: ");
			Scanner optionInput = new Scanner(System.in);
			String option = optionInput.nextLine();	
			
			if (option.equals("all")) {														// displays all poll data including aggregate
				displayPollsBySeat(partyNameList);
				hold = true;
			} else if (option.equals("aggregate")) {										// displays only the aggregate data
				Poll AggregatePoll = null;
				AggregatePoll = polls.getAggregatePoll(partyNameList);
				displayPollDataBySeat(AggregatePoll);
				hold = true;
			} else if (option.equals("quit")) {
				System.out.println("Goodbye.");												// ends the application
				optionInput.close();
				hold = false;
			}	
		} while (hold == true);	
		
		seatinput.close();					// closes resource 
		partyNameInput.close();
		numOfPollsInput.close();
		yesNoInput.close();	
	}
/**
 * 
 * @param args
 * @throws InvalidSetupDataException when # of parties or # of seats < 1
 */
	public static void main(String[] args) throws InvalidSetupDataException {
		TextApplication app = new TextApplication();		// instantiates the class
		app.run();	
	}
}
