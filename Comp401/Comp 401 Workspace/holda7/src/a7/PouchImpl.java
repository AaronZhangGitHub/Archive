package a7;

import java.util.ArrayList;
import java.util.List;

import supplies.Supplies;

public class PouchImpl<E extends Supplies> implements Pouch<E> {

	// declare list for for item storage
	private List<E> items;

	// constructor
	public PouchImpl() {
		items = new ArrayList<E>();
	}

	// add item
	public void add(E item) {
		items.add(item);
	}

	public void remove(E item) {
		items.remove(item);
	}

	// getter for weight
	public int getTotalWeight() {
		int weight = 0;
		for (int i = 0; i < items.size(); i++) {
			weight += items.get(i).getTotalWeight();
		}
		return weight;
	}

	// return array of supplies
	public Supplies[] getItems() {
		Supplies[] array = new Supplies[items.size()];
		for (int i = 0; i < items.size(); i++) {
			array[i] = items.get(i);
		}
		return array;
	}

}
