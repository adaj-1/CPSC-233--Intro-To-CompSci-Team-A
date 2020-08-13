package model;
import java.util.Comparator;
public class DescendingSeatsComparator implements Comparator<Party> {

	@Override
	public int compare(Party o1, Party o2) {
		int seats1 =(int) o1.getProjectedNumberOfSeats();
		int seats2 = (int) o2.getProjectedNumberOfSeats();
		int compareResult= seats2-seats1;
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
