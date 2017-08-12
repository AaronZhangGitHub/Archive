package a6;

import supplies.IterableSupplies;
import supplies.Supplies;

/** A container for our different types of <code>Supplies</code>. 
 * The <code>Knapsack</code> class encapsulates these as a composition.
 */

public interface Pouch<E extends Supplies> extends IterableSupplies {

	void add(E item); // Adds an item to the pouch
	int getTotalWeight();	// Returns the total weight of all items in the pouch
	Supplies[] getItems();	// Returns the items of the pouch in an array
}