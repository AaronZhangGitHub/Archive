package a6;

import java.util.Comparator;
import supplies.Supplies;
public class NameComparator implements Comparator<Supplies>{

	public int compare(Supplies o1, Supplies o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}
	

}
