package a5jedi;

import supplies.Supplies;
import java.util.List;
import java.util.ArrayList;

public class PouchImpl<E extends Supplies> implements Pouch<E> {


	private List<E> items;
	
	public PouchImpl() {
		items = new ArrayList<E>();
	}
	
	@Override
	public void add(E item) {
		//adds the item to the pouch based on what type it is
		items.add(item);
	}

	@Override
	public int getTotalWeight() {
		int total = 0;
		for (int i=0; i<items.size(); i++) {
			total += items.get(i).getTotalWeight();
		}
		//returns the total weight of the items in its respective pouch
		return total;
	}

	@Override
	public Supplies[] getItems() {
		//returns an array of the items
		return items.toArray(new Supplies[items.size()]);
	}

}
