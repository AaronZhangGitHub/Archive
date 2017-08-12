package a7;

import person.Person;

public class SquadImpl implements Squad {
	
	private Person[] players;
	private Knapsack knapsack;
	
	public SquadImpl(int num_players, Knapsack knapsack) {
		if (num_players < 1) {
			throw new IllegalArgumentException("Must have at least 1 player on the sqaud.");
		}
		if (knapsack == null) {
			throw new IllegalArgumentException("Squad must have a non-null knapsack");
		}
		
		players = new Person[num_players];
		this.knapsack = knapsack;
	}

	@Override
	public int getNumPlayers() {
		return players.length;
	}

	@Override
	public Person getPlayer(int num) {
		if (num < 0 || num >= getNumPlayers()) {
			throw new IllegalArgumentException("num out of bounds");
		}
		return players[num];
	}

	@Override
	public void setPlayer(int num, Person player) {
		if (num < 0 || num >= getNumPlayers()) {
			throw new IllegalArgumentException("num out of bounds");
		}
		players[num] = player;
	}

	@Override
	public Knapsack getKnapsack() {
		return knapsack;
	}
	
}
