package a7;

import java.util.ArrayList;

import supplies.FoodExpiredException;

public class Adventure {

	// declare private variables
	private Difficulty mode;
	private Squad squad;
	private City chapelHill, charlotte, atlanta, washingtonDC, newYork,
			chicago, austin, minneapolis, seattle, sanFrancisco, paloAlto;
	private City currentCity;
	private int day;
	private City[] cities;
	
	private ArrayList<TravelObserver> travelObservers;

	// declare enum
	public enum Difficulty {
		EASY, MEDIUM, HARD;
	}

	// constructor
	public Adventure(Difficulty mode, Squad squad) {
		this.mode = mode;
		this.squad = squad;
		
		travelObservers = new ArrayList<TravelObserver>();

		addTravelObserver(squad.getKnapsack());
		
		// helper methods
		instantiateCities();
		distances();

		currentCity = chapelHill;
		day = 0;

	}

	// helper method to clean up constructor
	private void instantiateCities() {
		// pick cities and goal based on difficulty
		// create an array of each city in each difficulty
		if (mode == Difficulty.EASY) {
			chapelHill = new CityImpl("Chapel Hill", null, null, false);
			charlotte = new CityImpl("Charlotte", null, null, false);
			atlanta = new CityImpl("Atlanta", null, null, false);
			washingtonDC = new CityImpl("Washington, D.C.", null, null, true);
			City[] array = { chapelHill, charlotte, atlanta, washingtonDC };
			cities = array;
		}
		if (mode == Difficulty.MEDIUM) {
			chapelHill = new CityImpl("Chapel Hill", null, null, false);
			charlotte = new CityImpl("Charlotte", null, null, false);
			atlanta = new CityImpl("Atlanta", null, null, false);
			washingtonDC = new CityImpl("Washington, D.C.", null, null, false);
			newYork = new CityImpl("New York", null, null, false);
			chicago = new CityImpl("Chicago", null, null, false);
			austin = new CityImpl("Austin", null, null, true);
			City[] array = { chapelHill, charlotte, atlanta, washingtonDC,
					newYork, chicago, austin };
			cities = array;
		}
		if (mode == Difficulty.HARD) {
			chapelHill = new CityImpl("Chapel Hill", null, null, false);
			charlotte = new CityImpl("Charlotte", null, null, false);
			atlanta = new CityImpl("Atlanta", null, null, false);
			washingtonDC = new CityImpl("Washington, D.C.", null, null, false);
			newYork = new CityImpl("New York", null, null, false);
			chicago = new CityImpl("Chicago", null, null, false);
			austin = new CityImpl("Austin", null, null, false);
			minneapolis = new CityImpl("Minneapolis", null, null, false);
			seattle = new CityImpl("Seattle", null, null, false);
			sanFrancisco = new CityImpl("San Francisco", null, null, false);
			paloAlto = new CityImpl("Palo Alto", null, null, true);
			City[] array = { chapelHill, charlotte, atlanta, washingtonDC,
					newYork, chicago, austin, minneapolis, seattle,
					sanFrancisco, paloAlto };
			cities = array;
		}
	}

	// helper method to clean up constructor
	private void distances() {

		if (mode == Difficulty.EASY || mode == Difficulty.MEDIUM
				|| mode == Difficulty.HARD) {
			// chapel Hill
			chapelHill.setDistance(chapelHill, 0);
			chapelHill.setDistance(charlotte, 140);
			chapelHill.setDistance(atlanta, 380);
			chapelHill.setDistance(washingtonDC, 271);

			// charlotte
			charlotte.setDistance(chapelHill, 140);
			charlotte.setDistance(charlotte, 0);
			charlotte.setDistance(atlanta, 200);
			charlotte.setDistance(washingtonDC, 398);

			// atlanta
			atlanta.setDistance(chapelHill, 380);
			atlanta.setDistance(charlotte, 200);
			atlanta.setDistance(atlanta, 0);
			atlanta.setDistance(washingtonDC, 639);

			// washington D.C.
			washingtonDC.setDistance(chapelHill, 271);
			washingtonDC.setDistance(charlotte, 398);
			washingtonDC.setDistance(atlanta, 639);
			washingtonDC.setDistance(washingtonDC, 0);
		}
		if (mode == Difficulty.MEDIUM || mode == Difficulty.HARD) {
			// chapel Hill
			chapelHill.setDistance(newYork, 500);
			chapelHill.setDistance(chicago, 784);
			chapelHill.setDistance(austin, 1300);

			// charlotte
			charlotte.setDistance(newYork, 625);
			charlotte.setDistance(chicago, 756);
			charlotte.setDistance(austin, 1164);

			// atlanta
			atlanta.setDistance(newYork, 864);
			atlanta.setDistance(chicago, 717);
			atlanta.setDistance(austin, 921);

			// washington D.C.
			washingtonDC.setDistance(newYork, 225);
			washingtonDC.setDistance(chicago, 699);
			washingtonDC.setDistance(austin, 1524);

			// new york
			newYork.setDistance(chapelHill, 500);
			newYork.setDistance(charlotte, 625);
			newYork.setDistance(atlanta, 864);
			newYork.setDistance(washingtonDC, 225);

			newYork.setDistance(newYork, 0);
			newYork.setDistance(chicago, 790);
			newYork.setDistance(austin, 1742);

			// Chicago
			chicago.setDistance(chapelHill, 784);
			chicago.setDistance(charlotte, 756);
			chicago.setDistance(atlanta, 717);
			chicago.setDistance(washingtonDC, 699);

			chicago.setDistance(newYork, 790);
			chicago.setDistance(chicago, 0);
			chicago.setDistance(austin, 1120);

			// austin
			austin.setDistance(chapelHill, 1300);
			austin.setDistance(charlotte, 1164);
			austin.setDistance(atlanta, 921);
			austin.setDistance(washingtonDC, 1524);

			austin.setDistance(newYork, 1742);
			austin.setDistance(chicago, 1120);
			austin.setDistance(austin, 0);
		}

		if (mode == Difficulty.HARD) {

			// chapel Hill

			chapelHill.setDistance(minneapolis, 1194);
			chapelHill.setDistance(seattle, 2849);
			chapelHill.setDistance(sanFrancisco, 2813);
			chapelHill.setDistance(paloAlto, 2787);

			// charlotte

			charlotte.setDistance(minneapolis, 1166);
			charlotte.setDistance(seattle, 2795);
			charlotte.setDistance(sanFrancisco, 2708);
			charlotte.setDistance(paloAlto, 2682);

			// atlanta

			atlanta.setDistance(minneapolis, 1112);
			atlanta.setDistance(seattle, 2636);
			atlanta.setDistance(sanFrancisco, 2472);
			atlanta.setDistance(paloAlto, 2446);

			// washington D.C.

			washingtonDC.setDistance(minneapolis, 1106);
			washingtonDC.setDistance(seattle, 2761);
			washingtonDC.setDistance(sanFrancisco, 2817);
			washingtonDC.setDistance(paloAlto, 2844);

			// new york

			newYork.setDistance(minneapolis, 1197);
			newYork.setDistance(seattle, 2852);
			newYork.setDistance(sanFrancisco, 2569);
			newYork.setDistance(paloAlto, 2562);

			// Chicago

			chicago.setDistance(minneapolis, 404);
			chicago.setDistance(seattle, 2064);
			chicago.setDistance(sanFrancisco, 2131);
			chicago.setDistance(paloAlto, 2158);

			// austin

			austin.setDistance(minneapolis, 1173);
			austin.setDistance(seattle, 2127);
			austin.setDistance(sanFrancisco, 1759);
			austin.setDistance(paloAlto, 1733);

			// minneapolis
			minneapolis.setDistance(chapelHill, 1194);
			minneapolis.setDistance(charlotte, 1166);
			minneapolis.setDistance(atlanta, 1112);
			minneapolis.setDistance(washingtonDC, 1106);

			minneapolis.setDistance(newYork, 1197);
			minneapolis.setDistance(chicago, 404);
			minneapolis.setDistance(austin, 1173);

			minneapolis.setDistance(minneapolis, 0);
			minneapolis.setDistance(seattle, 1656);
			minneapolis.setDistance(sanFrancisco, 1977);
			minneapolis.setDistance(paloAlto, 2004);

			// seattle
			seattle.setDistance(chapelHill, 2849);
			seattle.setDistance(charlotte, 2795);
			seattle.setDistance(atlanta, 2636);
			seattle.setDistance(washingtonDC, 2761);

			seattle.setDistance(newYork, 2852);
			seattle.setDistance(chicago, 2064);
			seattle.setDistance(austin, 2127);

			seattle.setDistance(minneapolis, 1656);
			seattle.setDistance(seattle, 0);
			seattle.setDistance(sanFrancisco, 808);
			seattle.setDistance(paloAlto, 835);
			
			// san francisco
			sanFrancisco.setDistance(chapelHill, 2813);
			sanFrancisco.setDistance(charlotte, 2708);
			sanFrancisco.setDistance(atlanta, 2472);
			sanFrancisco.setDistance(washingtonDC, 2817);

			sanFrancisco.setDistance(newYork, 2569);
			sanFrancisco.setDistance(chicago, 2131);
			sanFrancisco.setDistance(austin, 1759);

			sanFrancisco.setDistance(minneapolis, 1977);
			sanFrancisco.setDistance(seattle, 808);
			sanFrancisco.setDistance(sanFrancisco, 0);
			sanFrancisco.setDistance(paloAlto, 33);
			
			// palo alto
			paloAlto.setDistance(chapelHill, 2787);
			paloAlto.setDistance(charlotte, 2682);
			paloAlto.setDistance(atlanta, 2446);
			paloAlto.setDistance(washingtonDC, 2884);

			paloAlto.setDistance(newYork,2562);
			paloAlto.setDistance(chicago, 2158);
			paloAlto.setDistance(austin, 1733);

			paloAlto.setDistance(minneapolis, 2004);
			paloAlto.setDistance(seattle, 835);
			paloAlto.setDistance(sanFrancisco, 33);
			paloAlto.setDistance(paloAlto, 0);

		}

	}

	public void travel(City next_city){
		int distance = currentCity.getDistance(next_city);
		while (distance >= 20) {
			distance -= 20;
			day++;		
			
			// notify observers of distance away from destination
			for(TravelObserver o : travelObservers){
				o.travelUpdate(this, distance, next_city);
			}
			
			System.out.println("Day " + day + ": You are " + distance
					+ " miles away from " + next_city.getName() + ".");
		}
		currentCity = next_city;
	}

	// observer methods
	
	public void addTravelObserver(TravelObserver observer){
		travelObservers.add(observer);
	}
	
	public void removeTravelObserver(TravelObserver observer){
		travelObservers.remove(observer);
	}
	
	// getters
	
	public City getCurrentCity() {
		return currentCity;
	}

	public Difficulty getDifficulty() {
		return mode;
	}

	public int getDay() {
		return day;
	}

	public City[] getCities() {
		return cities;
	}
}
