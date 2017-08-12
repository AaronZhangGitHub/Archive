package a6;

import java.util.Iterator;


import supplies.Supplies;

public class KnapsackWeightIterator extends KnapSackIterator {
	public KnapsackWeightIterator(Iterator<Supplies> food,Iterator<Supplies> powerUp,Iterator<Supplies> clothing){
		super(food, powerUp,clothing, new WeightComparator());
	}
}
