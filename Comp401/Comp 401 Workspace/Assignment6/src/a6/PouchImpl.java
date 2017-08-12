package a6;

import supplies.Supplies;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class PouchImpl<E extends Supplies> implements Pouch<E> {


	private List<E> items;
	
	public PouchImpl() {
		items = new ArrayList<E>();
	}
	
	public void add(E item) {
		items.add(item);
	}

	public int getTotalWeight() {
		int total = 0;
		for (int i=0; i<items.size(); i++) {
			total += items.get(i).getTotalWeight();
		}
		return total;
	}

	public Supplies[] getItems() {
		return items.toArray(new Supplies[items.size()]);
	}

	public Iterator<Supplies> nameIterator() {
		List<Supplies> copy = new ArrayList<Supplies>(items);
		Collections.sort(copy, new NameComparator());
		return copy.iterator();
	}


	public Iterator<Supplies> amountIterator() {
		List<Supplies> copy = new ArrayList<Supplies>(items);
		Collections.sort(copy,new AmountComparator());
		return copy.iterator();
	}

	public Iterator<Supplies> weightIterator() {
		List<Supplies> copy = new ArrayList<Supplies>(items);
		Collections.sort(copy,new WeightComparator());
		return copy.iterator();
	}

}
