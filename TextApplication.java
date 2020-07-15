import java.util.Scanner;
public class TextApplication {
	public static final int MAX_NUMBER_OF_STARS = 25;
	private PollList polls;
	
	public TextApplication() {	
	}
	
	public TextApplication(PollList polls) {
		this.polls = polls;
	}
	
	public void displayPollsBySeat(String[] partyNames) {
		int numOfPolls = polls.getPolls().length;
		Poll[] regularPoll = polls.getPolls();
		
		for (int i = 0; i < numOfPolls; i++) {	
			displayPollDataBySeat(regularPoll[i]);
		  	
			System.out.println();
		}
		
		Poll AggregatePoll = polls.getAggregatePoll(partyNames);
		displayPollDataBySeat(AggregatePoll);
	}
	
	public PollList getPolls() {
		return polls;
	}

	public void displayPollDataBySeat(Poll aPoll) {
		int starsNeededForMajority = (MAX_NUMBER_OF_STARS + 1) / 2; //majority;
		
		int numOfSeats = polls.getNumOfSeats();	
		double numOfSeatsPerStar = numOfSeats / MAX_NUMBER_OF_STARS; 
				
		int numOfParties = aPoll.getNumberOfParties();
		Party[] partyList = aPoll.getPartiesSortedBySeats();
							
		System.out.println(aPoll.getPollName());
		
		for (int i = 0; i < numOfParties; i++) {
			String visualizationBySeat = partyList[i].textVisualizationBySeats(MAX_NUMBER_OF_STARS, 
																			   starsNeededForMajority,
																			   numOfSeatsPerStar);
			System.out.println(visualizationBySeat);	
		}
	}
	
	
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
			Factory test = new Factory(numOfSeats);	//generates random polls using Factory
			polls = test.promptForPollList(numOfPolls);
			
		} else {
			polls = new PollList(numOfPolls, numOfSeats);	//generate polls using other classes
			
		}
		
		boolean hold = true;
		do {
			System.out.println("Options: all (Show results of all Polls),"
					+ " aggregate (Show Aggregate results), or quit (End application)");
			System.out.println("Choose an Option: ");
			Scanner optionInput = new Scanner(System.in);
			String option = optionInput.nextLine();	
			
			if (option.equals("all")) {
				System.out.println("IN ALL");
				displayPollsBySeat(partyNameList);
				hold = true;
				
			} else if (option.equals("aggregate")) {
				System.out.println("IN AGGREGATE");
				Poll AggregatePoll = polls.getAggregatePoll(partyNameList);
				displayPollDataBySeat(AggregatePoll);
				hold = true;
			} else {
				System.out.println("Goodbye.");
				hold = false;
			}	
		}while(hold == true);	
	
	}

	public static void main(String[] args) {
		
		TextApplication app = new TextApplication();
		app.run();	
	}
}
