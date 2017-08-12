package a5jedi;

import java.util.Arrays;

public class Adventure {
	private Squad squad;
	private Difficulty difficulty;
	private City chapelhill, charlotte, atlanta, washingtonDC, newyork,
			chicago, austin, minneapolis, seattle, sanfran, paloalto;
	private City[] all_cities;
	private City current_city;
	private int daynumber;

	public Adventure(Difficulty difficulty_level, Squad squad) {
		if (difficulty_level == null) {
			//if the difficulty level is null, throw an exception
			throw new IllegalArgumentException("Illegal");
		}
		
		//Determines the difficulty level and sets the appropriate city amount for the level
		//the size of the city array corresponds with 
		if (difficulty_level == Difficulty.EASY) {
			all_cities = new City[4];
		} else if (difficulty_level == Difficulty.MEDIUM) {
			all_cities = new City[7];
		} else {
			all_cities = new City[11];
		}

		//array of distances from a each city to each other city
		int[] chapelhill_dist = {0, 140, 380, 271, 500, 784, 1300, 1194, 2849, 2813, 2787 };
		int[] charlotte_dist = { 140, 0, 200, 398, 625, 756, 1164, 1166, 2795, 2708, 2682 };
		int[] atlanta_dist = { 380, 200, 0, 639, 864, 717, 921, 1112, 2636, 2472, 2446 };
		int[] dc_dist = { 271, 398, 639, 0, 225, 699, 1524, 1106, 2761, 2817, 2844 };
		int[] ny_dist = { 500, 625, 864, 225, 0, 790, 1742, 1197, 2852, 2569, 2562 };
		int[] chicago_dist = { 784, 756, 717, 699, 790, 0, 1120, 404, 2064, 2131, 2158 };
		int[] austin_dist =  { 1300, 1164, 921, 1524, 1742, 1120, 0, 1173, 2127, 1759, 1733 };
		int[] minn_dist = { 1194, 1166, 1112, 1106, 1197, 404, 1173, 0, 1656, 1977, 2004 };
		int[] sea_dist = { 2849, 2795, 2636, 2761, 2852, 2064, 2127, 1656, 0, 808, 835 };
		int[] sf_dist = { 2813, 2708, 2472, 2817, 2569, 2131, 1759, 1977, 808, 0, 33 };
		int[] palo_dist = { 2787, 2682, 2446, 2844, 2562, 2158, 1733, 2004, 835, 33, 0 };

		//Cities constructed, depending on the difficulty level the goal city is determined
		chapelhill = new CityImpl("Chapel Hill", null, null, false);
		charlotte = new CityImpl("Charlotte", null, null, false);
		atlanta = new CityImpl("Atlanta", null, null, false);
		washingtonDC = new CityImpl("Washington, D.C.", null, null,difficulty_level == Difficulty.EASY);
		newyork = new CityImpl("New York", null, null, false);
		chicago = new CityImpl("Chicago", null, null, false);
		austin = new CityImpl("Austin", null, null, difficulty_level == Difficulty.MEDIUM);
		minneapolis = new CityImpl("Minneapolis", null, null, false);
		seattle = new CityImpl("Seattle", null, null, false);
		sanfran = new CityImpl("San Francisco", null, null, false);
		paloalto = new CityImpl("Palo Alto", null, null,difficulty_level == Difficulty.HARD);

		this.difficulty = difficulty_level;
		this.squad = squad;
		current_city = chapelhill; //sets current city to chapel hill
		daynumber = 0;//current day is 0

		all_cities = new City[] { chapelhill, charlotte, atlanta,
				washingtonDC, newyork, chicago, austin, minneapolis, seattle,
				sanfran, paloalto };//array of all the cities

		//calls distanceSetter method to match up each distance to each city 
		distanceSetter(chapelhill, all_cities, chapelhill_dist);
		distanceSetter(charlotte, all_cities, charlotte_dist);
		distanceSetter(atlanta, all_cities, atlanta_dist);
		distanceSetter(washingtonDC, all_cities, dc_dist);
		distanceSetter(newyork, all_cities, ny_dist);
		distanceSetter(chicago, all_cities, chicago_dist);
		distanceSetter(austin, all_cities, austin_dist);
		distanceSetter(minneapolis, all_cities, minn_dist);
		distanceSetter(seattle, all_cities, sea_dist);
		distanceSetter(sanfran, all_cities, sf_dist);
		distanceSetter(paloalto, all_cities, palo_dist);

	}

	public void travel(City next_city) {
		int travel_length = current_city.getDistance(next_city); //distance from current city to the next city
		while (true) {
			//prints out how much you travel each day and distance left until you are there
			System.out.println("Day " + daynumber + ": " + " You are "+ travel_length + 
					" miles away from "+ next_city.getName());
			daynumber++;
			travel_length -= 20;
			if (travel_length <= 0) {
				break;
			}
		}
		this.current_city = next_city;
	}

	public City getCurrentCity() {
		//returns the city you are in
		return current_city;
	}

	public Difficulty getDifficulty() {
		//returns the difficulty level
		return difficulty;
	}

	public int getDay() {
		//returns the day
		return daynumber;
	}

	public City[] getCities() {
		//depending on the difficulty gives you an array of the range of cities in the difficulty level
		if(difficulty == Difficulty.EASY){
			return Arrays.copyOfRange(all_cities,0,4);
		}else if(difficulty == Difficulty.MEDIUM){
			return Arrays.copyOfRange(all_cities,0,7);
		}else if(difficulty == Difficulty.HARD){
			return Arrays.copyOfRange(all_cities,0,11);
		}
		else{
			throw new IllegalArgumentException("Illegal");
		}
	}

	public enum Difficulty {
		EASY, MEDIUM, HARD
	}

	public void distanceSetter(City from_city, City[] to_city, int[] distance) {
		//sets distance from city to city given an array of cities and an array of distances from city to city
		//uses the map set in CityImpl
		for (int i = 0; i < to_city.length; i++) {
			from_city.setDistance(to_city[i], distance[i]);
		}
	}

}
