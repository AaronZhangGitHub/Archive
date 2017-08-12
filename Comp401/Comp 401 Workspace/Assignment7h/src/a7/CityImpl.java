package a7;

import java.util.HashMap;
import java.util.Map;

public class CityImpl implements City {

	private String name;
	private Challenge challenge;
	private Store store;
	private boolean is_goal;
	private Map<City,Integer> distances;
	private boolean is_cleared;
	
	public CityImpl(String name, Challenge challenge, Store store, boolean is_goal) {
		this.name = name;
		this.challenge = challenge;
		this.store = store;
		this.is_goal = is_goal;
		distances = new HashMap<City,Integer>();
		is_cleared = false;
	}

	@Override
	public int getDistance(City other) {
		if (distances.containsKey(other)) {
			return distances.get(other);
		}
		throw new RuntimeException("Don't know distance to " + other.getName());
	}

	@Override
	public void setDistance(City other, int distance) {
		distances.put(other, distance);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isCleared() {
		return is_cleared;
	}

	@Override
	public boolean isGoal() {
		return is_goal;
	}

	@Override
	public void challenge(Squad squad) {
		if (challenge.start(squad)) {
			is_cleared = true;
		}
	}

	@Override
	public void store(Squad squad) {
		store.enter(squad);
	}
	
}
