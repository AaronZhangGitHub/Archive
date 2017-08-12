package a7;

import person.Person;

public class SquadImpl implements Squad {

	// declare variables, instantiate in constructor
	private Person[] players;
	private Knapsack knapsack;

	public SquadImpl(int num_players, Knapsack knapsack) {
		if (num_players < 1 || knapsack == null) {
			throw new IllegalArgumentException();
		} else {
			players = new Person[num_players];
			this.knapsack = knapsack;
		}

	}

	// getters
	@Override
	public int getNumPlayers() {
		return players.length;
	}

	@Override
	public Person getPlayer(int num) {
		if (num < 0 || num >= players.length) {
			throw new IllegalArgumentException();
		} else {
			return players[num];
		}
	}
	
	@Override
	public Knapsack getKnapsack() {
		return knapsack;
	}

	// setter
	@Override
	public void setPlayer(int num, Person player) {
		if (num < 0 || num >= players.length) {
			throw new IllegalArgumentException();
		} else {
			players[num] = player;
		}
	}
}
