package a7;

import supplies.*;

public interface Knapsack extends TravelObserver{
	void add(Food item);
	void add(PowerUp item);
	void add(Clothing item);
	void add(Supplies item);
	int getTotalWeight();
	Supplies[] getSupplies();
	Food[] getEdibleSupplies();
	void remove(Food item);
	void remove(PowerUp item);
	void remove(Clothing item);
	void remove(Supplies item);
}
