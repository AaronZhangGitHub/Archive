package a6;

import java.util.Iterator;


import supplies.Supplies;
public class KnapsackAmountIterator extends KnapSackIterator {
	public KnapsackAmountIterator(Iterator<Supplies> food,Iterator<Supplies> powerUp,Iterator<Supplies> clothing){
		super(food, powerUp,clothing, new AmountComparator());
	}
}
