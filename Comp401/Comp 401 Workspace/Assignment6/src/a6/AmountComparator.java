package a6;

import java.util.Comparator;
import supplies.Supplies;
public class AmountComparator implements Comparator<Supplies>{

	public int compare(Supplies o1, Supplies o2) {
		if(o1.getAmount()==o2.getAmount()){
			return 0;
		}
		else if(o1.getAmount()<o2.getAmount()){
			return 1;
		}else{
			return -1;
		}
	}
	
}
