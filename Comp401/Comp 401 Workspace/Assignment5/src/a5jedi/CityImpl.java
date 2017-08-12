package a5jedi;

import java.util.HashMap;

public class CityImpl implements City{
	private String name;
	private Challenge challenge;
	private Store store;
	private boolean is_goal;
	private boolean is_cleared;
	private HashMap<City,Integer> map_CityAndDistance;
	
	public CityImpl(String name, Challenge challenge, Store store, boolean is_goal){
		map_CityAndDistance = new HashMap<City,Integer>();
		this.name = name;
		this.challenge = challenge;
		this.store = store;
		this.is_goal = is_goal;
	}
	
	public int getDistance(City other) {
		//gets the distance from one city to another
		if(map_CityAndDistance.get(other)==null){
			//if the city does not exsist throws an exception
			throw new IllegalArgumentException("City does not exist");
		}else{
			return map_CityAndDistance.get(other);
		}
	}

	public void setDistance(City other, int distance) {
		//sets distance to another city using a map
		map_CityAndDistance.put(other, distance);	
	}

	public String getName() {
		return name;
	}

	public boolean isCleared() {
		return is_cleared;
	}

	public boolean isGoal() {
		return is_goal;
	}

	public void challenge(Squad squad) {
		is_cleared = challenge.start(squad);
	}

	public void store(Squad squad) {
		store.enter(squad);		
	}

}
