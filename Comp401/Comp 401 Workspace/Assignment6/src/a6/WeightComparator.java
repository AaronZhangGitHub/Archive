package a6;

import java.util.Comparator;
import supplies.Supplies;
public class WeightComparator implements Comparator<Supplies> {
	
	public int compare(Supplies o1, Supplies o2) {
		if(o1.getTotalWeight()==o2.getTotalWeight()){
			return 0;
		}
		else if(o1.getTotalWeight()<o2.getTotalWeight()){
			return 1;
		}else{
			return -1;
		}
	}
}
