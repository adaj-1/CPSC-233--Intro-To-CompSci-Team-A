public class Party {
	private String name;
	private float projectedNumberOfSeats;
	private float projectedPercentageOfVotes;

	//constructor
	public Party(String partyName) {

		name = partyName;
	}

	public Party(String partyName, float projectedNumberOfSeats, float projectedPercentageOfVotes) {
		name = partyName;

		if (projectedPercentageOfVotes >= 0 && projectedPercentageOfVotes <= 1){
			this.projectedPercentageOfVotes = projectedPercentageOfVotes;
		}
		else{
			this.projectedPercentageOfVotes = 0;
		}
		if (projectedNumberOfSeats >= 0){
			this.projectedNumberOfSeats = projectedNumberOfSeats;
		}
		else{
			this.projectedNumberOfSeats = 0;
		}
	}

	public float getProjectedPercentageOfVotes() {
		return projectedPercentageOfVotes;
	}

	public String getName() {
		return name;
	}

	public void setProjectedPercentageOfVotes(float projectedPercentageOfVotes) {
		if (projectedPercentageOfVotes >= 0 && projectedPercentageOfVotes <= 1) {
			this.projectedPercentageOfVotes = projectedPercentageOfVotes;
		}
	}

	public float getProjectedNumberOfSeats() {
		return projectedNumberOfSeats;
	}

	public void setProjectedNumberOfSeats(float projectedNumberOfSeats) {
			if (projectedNumberOfSeats >= 0){
				this.projectedNumberOfSeats = projectedNumberOfSeats;
			}
	}

	@Override
	public String toString() {

		return name + " "+"(" +(int)(projectedPercentageOfVotes*100) + "% of votes" +", "+  projectedNumberOfSeats + " seats)" ;
}




//total num of seats available in parliament in percentage
	public double projectedPercentOfSeats(int totalNumberOfSeats) {

		if (totalNumberOfSeats <= 0){
			return 0;
		}
		double result = projectedNumberOfSeats / totalNumberOfSeats;    //shows percentage of how much is occupied by party out of total num that exists
		if (result < 0){
			result = 0;
		}
		return result;

	}



	public String textVisualizationBySeats(int maxStars, int starsNeededForMajority, double numOfSeatsPerStar) {

		String result = printStars (projectedNumberOfSeats, numOfSeatsPerStar, starsNeededForMajority, maxStars);


		return result+ toString();
	}


	public String textVisualizationByVotes(int maxStars, int starsNeededForMajority, double percentOfVotesPerStar) {
		double votesInPercentage = projectedPercentageOfVotes*100;

		String result = printStars (votesInPercentage, percentOfVotesPerStar, starsNeededForMajority, maxStars);



		return result + toString();
	}


private String getNumSpaces (int majority, int minority){
		int counterSpaces = 0;
		int resultForSpaces = majority-minority;
		String numSpaces = "";
		while (counterSpaces <= resultForSpaces){
			numSpaces = numSpaces + " ";
			counterSpaces++;

		}
		return numSpaces;

}

	private String printStars (double projectedNumber, double numPerStars, int starsNeededForMajority, int maxStars ){

		double result = projectedNumber / numPerStars;   //num of starts in vizualization
		int resultInt = (int)Math.floor(result);
		int counterStars = 0;
		String resultStars= "";

		String numSpaces= "";


		if (resultInt == 0){


			while (counterStars < maxStars){

				if (counterStars == starsNeededForMajority){
					resultStars = resultStars + "|";

				}else{
					resultStars = resultStars + " ";
				}
				counterStars++;

			}
			resultStars = resultStars + "  ";

		} else if(resultInt < starsNeededForMajority){
			numSpaces = getNumSpaces(maxStars, starsNeededForMajority);

			String emptySeats = getNumSpaces(starsNeededForMajority-1, resultInt);
			while (counterStars < result-1) {
				Math.floor(result);


				resultStars = resultStars + "*";

				counterStars++;

			}
			resultStars = resultStars +emptySeats + "|";


		} else{


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
