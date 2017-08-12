package supplies;

import java.util.Iterator;

/** Specifies different iterators for a collection of Supplies. */
public interface IterableSupplies {

	Iterator<Supplies> nameIterator();    // orders by name, a-z
	Iterator<Supplies> amountIterator();  // orders by amount, greatest to least
	Iterator<Supplies> weightIterator();  // orders by total weight, greatest to least
}
