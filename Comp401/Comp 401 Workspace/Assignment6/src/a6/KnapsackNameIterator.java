package a6;

import java.util.Iterator;
import supplies.Supplies;

public class KnapsackNameIterator extends KnapSackIterator{
	public KnapsackNameIterator(Iterator<Supplies> food,Iterator<Supplies> powerUp,Iterator<Supplies> clothing){
		super(food, powerUp,clothing, new NameComparator());
	}
}
