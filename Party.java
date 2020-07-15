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

	public double projectedPercentOfSeats(int totalNumberOfSeats) {

		if (totalNumberOfSeats <= 0){
			return 0;
		}
		double result = projectedNumberOfSeats / totalNumberOfSeats;
		if (result < 0){
			result = 0;
		}
		return result;

	}


	public String textVisualizationBySeats(int maxStars, int starsNeededForMajority, double numOfSeatsPerStar) {

		double result = projectedNumberOfSeats / numOfSeatsPerStar;
		int resultInt = (int)Math.floor(result);
		int counterStars = 0;
		String resultStars= "";
		int resultForSpaces = maxStars - resultInt;
		String numSpaces= "";
		int counterSpaces = 0;

		//for (int i = 0; i < result; i++){
			//System.out.println("*");
			//if (counter = 10){
				//System.out.println("|");
		if (resultInt == 0){

			while (counterStars < maxStars){


				if (counterStars == starsNeededForMajority){
					resultStars = resultStars + "|";

				}else{
					resultStars = resultStars + "";
				}
				counterStars++;

			}

		} else {


			while (counterSpaces <= resultForSpaces) {
				numSpaces = numSpaces + " ";
				counterSpaces++;
			}


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

		return resultStars +numSpaces+ name + " " + "(" +(int)(projectedPercentageOfVotes*100) + "% of votes" +", "+  projectedNumberOfSeats + " seats)" ;
	}



	// 11+9=20
	//'*'+" "="|"
	public String textVisualizationByVotes(int maxStars, int starsNeededForMajority, double percentOfVotesPerStar) {




		//return name + "(" + projectedNumberOfSeats + ", " + projectedPercentageOfVotes + "%)";
	}

		return "";
}
