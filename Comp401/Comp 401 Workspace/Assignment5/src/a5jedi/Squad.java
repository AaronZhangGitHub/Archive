package a5jedi;

import person.Person;

public interface Squad {
	int getNumPlayers(); //returns number of players
	Person getPlayer(int num);//returns a certain player based on the index
	void setPlayer(int num, Person player);//sets a player
	Knapsack getKnapsack();//returns the knapsack
}
