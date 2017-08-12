package a5adept;


import java.util.ArrayList;

import supplies.Supplies;

public class PowerUpPouch extends PouchImpl implements Pouch {

	
	public PowerUpPouch() {
		items = new ArrayList<Supplies>();
	}
	
	@Override
	public void add(Supplies item) {
		if (!(item instanceof supplies.PowerUp)) {
			throw new IllegalArgumentException("Only power-ups should go in a power-up pouch.");
		}
		
		items.add(item);
	}
	
	// Complete this class to implement the rest of the Pouch interface

}
