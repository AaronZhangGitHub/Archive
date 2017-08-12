package a6;

import person.Person;

public interface Squad {
	int getNumPlayers();
	Person getPlayer(int num);
	void setPlayer(int num, Person player);
	Knapsack getKnapsack();
}
