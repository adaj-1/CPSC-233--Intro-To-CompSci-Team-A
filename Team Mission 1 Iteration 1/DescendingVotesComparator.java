import java.util.Comparator;
public class DescendingVotesComparator implements Comparator<Party> {

	@Override
	public int compare(Party o1, Party o2) {
		float vote1 =  o1.getProjectedPercentageOfVotes(); 
		float vote2 =  o2.getProjectedPercentageOfVotes();
		float compareResult = vote2-vote1;
		if(compareResult < 0) {
			return -1;
		}
		else if(compareResult>0) {
			return 1;
		}
		else {
			return 0;
		}
		
	}

}