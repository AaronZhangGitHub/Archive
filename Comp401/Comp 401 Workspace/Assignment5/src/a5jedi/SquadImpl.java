package a5jedi;

import person.Person;

public class SquadImpl implements Squad{
	private Knapsack knapsack;
	private Person[] playersArray;
	public SquadImpl(int num_players, Knapsack knapsack){
		if(num_players<=0||knapsack == null){
			throw new IllegalArgumentException("Illegal");
		}
		this.knapsack = knapsack;
		playersArray = new Person[num_players];
	}

	public int getNumPlayers() {
		//returns number of players
		return playersArray.length;
	}
	public Person getPlayer(int num) {
		if(num>=getNumPlayers()-1||num<0){//if the player requested is out of the index range, throws an exception
			throw new IllegalArgumentException("Out of Bounds");
		}
		return playersArray[num];
	}

	public void setPlayer(int num, Person player) {
		if(num>=getNumPlayers()-1||num<0){
			//if the player you are trying to set is out of the range, throws an exception
			throw new IllegalArgumentException("Out of Bounds");
		}
		playersArray[num] = player; //sets the player to the given player
		
	}

	public Knapsack getKnapsack() {
		return knapsack;
	}
}
