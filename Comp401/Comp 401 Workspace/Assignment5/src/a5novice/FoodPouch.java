package a5novice;

import java.util.ArrayList;
import supplies.Supplies;

public class FoodPouch extends PouchImpl implements Pouch {

	
	public FoodPouch() {
		items = new ArrayList<Supplies>();
	}
	
	@Override
	public void add(Supplies item) {
		if (!(item instanceof supplies.Food)) {
			throw new IllegalArgumentException("Only food should go in a food pouch.");
		}
		
		items.add(item);
	}
	
	// Complete this class to implement the rest of the Pouch interface

}
