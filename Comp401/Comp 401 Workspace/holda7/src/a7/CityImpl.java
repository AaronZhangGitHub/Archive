package a7;

import java.util.HashMap;

public class CityImpl implements City {

	//create local variables, instantiate in constructor
	private String name;
	private Challenge challenge;
	private Store store;
	private boolean isGoal,isCleared;
	private HashMap<City, Integer> map;

	// constructor
	public CityImpl(String name, Challenge challenge, Store store,
			boolean is_goal) {
		this.name = name;
		this.challenge = challenge;
		this.store = store;
		isGoal = is_goal;
		isCleared = false;
		map = new HashMap<City, Integer>();

	}

     //check if city is in HashMap, return distance
	//else throw exception
	@Override
	public int getDistance(City other) {
		if (map.containsKey(other)) {
			return map.get(other);
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	//create pair in HashMap of city and distance
	@Override
	public void setDistance(City other, int distance) {
		map.put(other, distance);
	}

	// getters
	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isCleared() {
		return isCleared;
	}

	@Override
	public boolean isGoal() {
		return isGoal;
	}

	//start the challenge
	@Override
	public void challenge(Squad squad) {
		if(challenge.start(squad)){
			isCleared = true;
		}
	}

	//enter the store
	@Override
	public void store(Squad squad) {
		store.enter(squad);
	}

}
