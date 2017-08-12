package a6;

import java.util.Arrays;

public class Adventure {
	private Squad squad;
	private Difficulty difficulty;
	private City chapelhill, charlotte, atlanta, washingtonDC, newyork,
			chicago, austin, minneapolis, seattle, sanfran, paloalto;
	private City[] all_cities;
	private City current_city;
	private int daynumber;

	public Adventure(Difficulty easy, Squad squad) {
		if (easy == null) {
			throw new IllegalArgumentException("Illegal");
		}
		if (easy == Difficulty.EASY) {
			all_cities = new City[4];
		} else if (easy == Difficulty.MEDIUM) {
			all_cities = new City[7];
		} else {
			all_cities = new City[11];
		}

		int[] chapelhill_dist = new int[] { 0, 140, 380, 271, 500, 784, 1300, 1194, 2849, 2813, 2787 };
		int[] charlotte_dist = new int[] { 140, 0, 200, 398, 625, 756, 1164, 1166, 2795, 2708, 2682 };
		int[] atlanta_dist = new int[] { 380, 200, 0, 639, 864, 717, 921, 1112, 2636, 2472, 2446 };
		int[] dc_dist = new int[] { 271, 398, 639, 0, 225, 699, 1524, 1106, 2761, 2817, 2844 };
		int[] ny_dist = new int[] { 500, 625, 864, 225, 0, 790, 1742, 1197, 2852, 2569, 2562 };
		int[] chicago_dist = new int[] { 784, 756, 717, 699, 790, 0, 1120, 404, 2064, 2131, 2158 };
		int[] austin_dist = new int[] { 1300, 1164, 921, 1524, 1742, 1120, 0, 1173, 2127, 1759, 1733 };
		int[] minn_dist = new int[] { 1194, 1166, 1112, 1106, 1197, 404, 1173, 0, 1656, 1977, 2004 };
		int[] sea_dist = new int[] { 2849, 2795, 2636, 2761, 2852, 2064, 2127, 1656, 0, 808, 835 };
		int[] sf_dist = new int[] { 2813, 2708, 2472, 2817, 2569, 2131, 1759, 1977, 808, 0, 33 };
		int[] palo_dist = new int[] { 2787, 2682, 2446, 2844, 2562, 2158, 1733, 2004, 835, 33, 0 };

		chapelhill = new CityImpl("Chapel Hill", null, null, false);
		charlotte = new CityImpl("Charlotte", null, null, false);
		atlanta = new CityImpl("Atlanta", null, null, false);
		washingtonDC = new CityImpl("Washington, D.C.", null, null,easy == Difficulty.EASY);
		newyork = new CityImpl("New York", null, null, false);
		chicago = new CityImpl("Chicago", null, null, false);
		austin = new CityImpl("Austin", null, null, easy == Difficulty.MEDIUM);
		minneapolis = new CityImpl("Minneapolis", null, null, false);
		seattle = new CityImpl("Seattle", null, null, false);
		sanfran = new CityImpl("San Francisco", null, null, false);
		paloalto = new CityImpl("Palo Alto", null, null,easy == Difficulty.HARD);

		this.difficulty = easy;
		this.squad = squad;
		current_city = chapelhill;
		daynumber = 0;

		all_cities = new City[] { chapelhill, charlotte, atlanta,
				washingtonDC, newyork, chicago, austin, minneapolis, seattle,
				sanfran, paloalto };

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
		int travel_length = current_city.getDistance(next_city);
		while (true) {
			System.out.println("Day " + daynumber + ": " + " You are "+ travel_length + 
					" miles away from "+ next_city.getName());
			daynumber++;
			travel_length -= 20;
			if (travel_length <= 0) {
				//daynumber=0;
				break;
			}
		}
		this.current_city = next_city;
	}

	public City getCurrentCity() {
		return current_city;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public int getDay() {
		return daynumber;
	}

	public City[] getCities() {
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
		for (int i = 0; i < to_city.length; i++) {
			from_city.setDistance(to_city[i], distance[i]);
		}
	}

}
