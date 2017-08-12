package a5jedi;

import supplies.*;

public interface Knapsack {
	void add(Food item); //adds a food item to the knapsack
	void add(PowerUp item);//adds a powerup item to the knapsack
	void add(Clothing item);//adds a clothing item to the knapsack
	void add(Supplies item);//adds a supplies item to the knapsack
	int getTotalWeight();//gets total weight of the items
	Supplies[] getSupplies();//gets an array of supplies
	Food[] getEdibleSupplies();//gets an array of the edible supplies
}
