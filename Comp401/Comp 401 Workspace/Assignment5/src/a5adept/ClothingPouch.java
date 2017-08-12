package a5adept;

import java.util.ArrayList;

import supplies.Supplies;

public class ClothingPouch extends PouchImpl implements Pouch {


	
	public ClothingPouch() {
		items = new ArrayList<Supplies>();
	}
	
	@Override
	public void add(Supplies item) {
		if (!(item instanceof supplies.Clothing)) {
			throw new IllegalArgumentException("Only clothing should go in a clothing pouch.");
		}
		
		items.add(item);
	}
	
	// Complete this class to implement the rest of the Pouch interface
}
