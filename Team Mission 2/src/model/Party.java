package model;
/**
 *
 * @author Arlina Dey
 * Iteration 1
 * @version 15.07.2020
 */

/**
 * This class creates a visualization of all the
 * majority and minority votes of a political party.
 *
 * It shows a visual representation by drawing stars
 * that represent the number of seats and a bar to represent
 * the number of seats needed for a majority.
 *
 * Empty spaces between the last start(or no star)
 * and a bar represents that the party has
 * fewer seats than needed for majority.
 */
public class Party {
	private String name;
	private float projectedNumberOfSeats;
	private float projectedPercentageOfVotes;

	/**
	 * constructor 1
	 *@param partyName includes all the party names
	 */
	public Party(String partyName) {
		name = partyName;
	}

	/**
	 * constructor 2
	 * This takes the projectedSeats and projectedVotes
	 * as values between 0 & 1.
	 */
	public Party(String partyName,
				 float projectedNumberOfSeats,
				 float projectedPercentageOfVotes) {
		name = partyName;

		if (projectedPercentageOfVotes >= 0 && projectedPercentageOfVotes <= 1) {
			this.projectedPercentageOfVotes = projectedPercentageOfVotes;
		} else {
			this.projectedPercentageOfVotes = 0;
		}
		if (projectedNumberOfSeats >= 0) {
			this.projectedNumberOfSeats = projectedNumberOfSeats;
		} else {
			this.projectedNumberOfSeats = 0;
		}
	}

	/**
	 *  getters & setters for instance variables
	 * @returns the percentage of votes
	 */
	public float getProjectedPercentageOfVotes() {
		return projectedPercentageOfVotes;
	}

	public String getName() {
		return name;
	}

	public void setProjectedPercentageOfVotes
			(float projectedPercentageOfVotes) {
		if (projectedPercentageOfVotes >= 0 && projectedPercentageOfVotes <= 1) {
			this.projectedPercentageOfVotes = projectedPercentageOfVotes;
		}
	}

	public float getProjectedNumberOfSeats() {
		return projectedNumberOfSeats;
	}

	public void setProjectedNumberOfSeats(float projectedNumberOfSeats) {
		if (projectedNumberOfSeats >= 0) {
			this.projectedNumberOfSeats = projectedNumberOfSeats;
		}
	}

	/**
	 * This method does not take any arguments and returns
	 * the information: '<name> (<projected% of votes>%, <projected seats> seats)'.
	 * The projected number of seats will be between 0 & 100.	*
	 */

	@Override
	public String toString() {

		return name + " " + "(" + (int)(projectedPercentageOfVotes*100)
				+ "% of votes" + ", " +  projectedNumberOfSeats + " seats)" ;
	}

	/**
	 * Shows total num of seats available in parliament in percentage.
	 * @returns the value of the percentage of seats the party
	 * is expected to win as a value between 0 & 1.
	 * @param totalNumberOfSeats displays the total num of seats
	 */
	public double projectedPercentOfSeats(int totalNumberOfSeats) {

		if (totalNumberOfSeats <= 0) {
			return 0;
		}
		/* Shows percentage of how much
		is occupied by party out of
		total num that exists */
		double result = projectedNumberOfSeats / totalNumberOfSeats;
		if (result < 0) {
			result = 0;
		}
		return result;

	}

	/**
	 * This method gives a visual representation by displaying
	 * a row of stars representing the expected number of seats
	 * and a bar representing seats needed for a majority.
	 * @param maxStars is the maximum number
	 * of stars that represent seats.
	 * @param starsNeededForMajority is the max number
	 * of stars needed for majority.
	 * @param numOfSeatsPerStar is the number of seats
	 * represented by each star.
	 * @returns the result including visualization info.
	 */
	public String textVisualizationBySeats(int maxStars,
										   int starsNeededForMajority, double numOfSeatsPerStar) {

		String result = printStars (projectedNumberOfSeats,
				numOfSeatsPerStar, starsNeededForMajority, maxStars);


		return result + toString();
	}

	/**
	 * This method is similar to the previous method but
	 * creates a visual representation of the percentage
	 * of votes the party is expected to win.
	 * @return the percentage result.
	 */
	public String textVisualizationByVotes(int maxStars,
										   int starsNeededForMajority, double percentOfVotesPerStar) {
		double votesInPercentage = projectedPercentageOfVotes * 100;                //since it takes values between 0 & 1 it is multiplied by 100

		String result = printStars (votesInPercentage,
				percentOfVotesPerStar, starsNeededForMajority, maxStars);

		return result + toString();
	}

	/**
	 * Private methods to support public methods
	 * to avoid code duplication.
	 * This method subtracts the minority
	 * from majority to get number of spaces.
	 * It also fills remaining gap with spaces if minority.
	 */
	private String getNumSpaces (int majority, int minority) {
		int counterSpaces = 0;
		int resultForSpaces = majority-minority;
		String numSpaces = "";
		while (counterSpaces <= resultForSpaces) {
			numSpaces = numSpaces + " ";
			counterSpaces++;
		}
		return numSpaces;

	}

	/**
	 * @param projectedNumber of seats
	 * @param numPerStars represents num of seats per star
	 * @returns a visualization of stars and spaces
	 * The result gets rounded down to an int num of stars.
	 */
	private String printStars (double projectedNumber,
							   double numPerStars, int starsNeededForMajority, int maxStars ) {

		double result = projectedNumber / numPerStars;
		int resultInt = (int) Math.floor(result);
		int counterStars = 0;
		String resultStars= "";

		String numSpaces= "";

		//shows if stars meet or exceed majority
		if (resultInt == 0){

			while (counterStars < maxStars){

				if (counterStars == starsNeededForMajority) {
					resultStars = resultStars + "|";
				} else {
					resultStars = resultStars + " ";
				}
				counterStars++;

			}
			resultStars = resultStars + "  ";

		//if result is less than stars needed for majority fill gap with space blocks
		} else if(resultInt < starsNeededForMajority) {
			numSpaces = getNumSpaces(maxStars, starsNeededForMajority);

			String emptySeats = getNumSpaces(starsNeededForMajority-1, resultInt);
			while (counterStars < result - 1) {
				Math.floor(result);


				resultStars = resultStars + "*";

				counterStars++;

			}
			resultStars = resultStars +emptySeats + "|";

		} else {

			numSpaces = getNumSpaces(maxStars, resultInt);

			while (counterStars <= result) {
				Math.floor(result);

				if (counterStars == starsNeededForMajority) {
					resultStars = resultStars + "|";

				} else {
					resultStars = resultStars + "*";
				}
				counterStars++;
			}
		}

		return resultStars + numSpaces;
	}

}
